package com.wisely.ch9_2.batch;

import com.wisely.ch9_2.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Configuration
@EnableBatchProcessing // 要使用@EnableBatchProcessing 开启批处理的支持，这点千万不要忘记。
public class CsvBatchConfig {

    @Bean
    public ItemReader<Person> reader() throws Exception {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>(); // 使用FlatFileItemReader 读取文件。
        reader.setResource(new ClassPathResource("people.csv")); // 使用FlatFileItemReader 的setResource 方法设置csv 文件的路径。
        reader.setLineMapper(new DefaultLineMapper<Person>() {{ // 在此处对cvs 文件的数据和领域模型类做对应映射。
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
        CsvItemProcessor processor = new CsvItemProcessor(); // 使用我们自己定义的ltemProcessor 的实现CsvItemProcessor.
        processor.setValidator(csvBeanValidator()); // 为processor 指定校验器为CsvBeanValidator;
        return processor;
    }

    /**
     * Spring 能让容器中已有的Bean 以参数的形式注入，Spring Boot 己为我们定义了dataSource.
     * @param dataSource
     * @return
     */
    @Bean
    public ItemWriter<Person> writer(DataSource dataSource) {
        // 我们使用JDBC批处理的JdbcBatchltemWriter 来写数据到数据库。
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>(); //2
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        String sql = "insert into person " + "(id,name,age,nation,address) "
                + "values(hibernate_sequence.nextval, :name, :age, :nation,:address)";
        writer.setSql(sql); // 在此设置要执行批处理的SQL 语句。
        writer.setDataSource(dataSource);
        return writer;
    }

    /**
     * 用来注册Job 的容器
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

    /**
     * 用来启动Job 的接口
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    /**
     * 实际执行的任务，包含一个或多个Step
     * Step-步骤包含ItemReader 、ItemProcessor 和ItemWrter
     * @param jobs
     * @param s1
     * @return
     */
    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1) // 为Job 指定Step.
                .end()
                .listener(csvJobListener()) // 注册并绑定监听器到Job
                .build();
    }

    /**
     * Step-步骤包含ItemReader 、ItemProcessor 和ItemWrter
     * @param stepBuilderFactory
     * @param reader
     * @param writer
     * @param processor
     * @return
     */
    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader, ItemWriter<Person> writer,
                      ItemProcessor<Person, Person> processor) {
        return stepBuilderFactory
                .get("step1")
                .<Person, Person>chunk(65000) // 批处理每次提交 65000 条数据
                .reader(reader) // 给step 绑定reader
                .processor(processor) // 给step 绑定processor.
                .writer(writer) // 给 step 绑定 writer
                .build();
    }


    /**
     * Job 监听器, 监听我们的Job 的执行情况
     * @return
     */
    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    /**
     * 数据校验器
     * @return
     */
    @Bean
    public Validator<Person> csvBeanValidator() {
        return new CsvBeanValidator<Person>();
    }
}
