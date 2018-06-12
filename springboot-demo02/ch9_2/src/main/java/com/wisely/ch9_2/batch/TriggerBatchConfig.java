package com.springboot.ch9_2.batch;

import com.springboot.ch9_2.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class TriggerBatchConfig {

    /**
     * 参数后置绑定 - jobParameters
     *
     * 我们在ltemReader 和ItemWriter 的Bean 定义的时候，参数已经硬编码在Bean 的初始化中
     * 要实现参数的后置绑定，我们可以在JobParameters 中绑定参数.
     * 在bean定义的时候, 用一个特殊的bean生命周期注解@StepScope:
     * 然后通过@Value 注入此参数。
     */
    @Bean
    @StepScope
    public FlatFileItemReader<Person> reader(@Value("#{jobParameters['input.file.name']}") String pathToFile) throws Exception {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>(); //1
        reader.setResource(new ClassPathResource(pathToFile)); //2
        reader.setLineMapper(new DefaultLineMapper<Person>() {{ //3
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"name", "age", "nation", "address"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                setTargetType(Person.class);
            }});
        }});

        return reader;
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        CsvItemProcessor processor = new CsvItemProcessor(); //1
        processor.setValidator(csvBeanValidator()); //2
        return processor;
    }

    @Bean
    public ItemWriter<Person> writer(DataSource dataSource) {//1
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>(); //2
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        String sql = "insert into person " + "(id,name,age,nation,address) "
                + "values(hibernate_sequence.nextval, :name, :age, :nation,:address)";
        writer.setSql(sql); //3
        writer.setDataSource(dataSource);
        return writer;
    }

    /**
     * jobRepository 的定义需要dataSource 和transactioManager，
     * Spring Boot 已为我们自动配置了这两个类， Spring 可通过方法注入已有的Bean.
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("oracle");
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1) // 为Job 指定Step.
                .end()
                .listener(csvJobListener()) // 绑定监听器csvJobListener.
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader, ItemWriter<Person> writer,
                      ItemProcessor<Person, Person> processor) {
        return stepBuilderFactory
                .get("step1")
                .<Person, Person>chunk(65000) // 批处理每次提交 65000 条数据.
                .reader(reader) // 给step 绑定reader
                .processor(processor) // 给step 绑定processor.
                .writer(writer) // 给 step 绑定 writer
                .build();
    }


    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<Person> csvBeanValidator() {
        return new CsvBeanValidator<Person>();
    }
}
