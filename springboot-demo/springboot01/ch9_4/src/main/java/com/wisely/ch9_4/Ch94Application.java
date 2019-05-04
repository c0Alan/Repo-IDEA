package com.wisely.ch9_4;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

@SpringBootApplication
public class Ch94Application {

    public static final String EMAIL_ADDRESS = "785837442@qq.com"; // QQ邮箱
    public static final String EMAIL_PASSWORD = "***"; // qq邮箱授权码
    public static final int QQ_EMAIL_PASSWORD = 465; // qq邮箱开放端口, 不行试试587

    public static void main(String[] args) {
        SpringApplication.run(Ch94Application.class, args);
    }

    // 通过@value 注解自动获得https://spring.io/blog.atom 的资源。
    @Value("https://spring.io/blog.atom") // 1
    Resource resource;

    /**
     * 使用FluentAPI 和Pollers 配置默认的轮询方式。
     * @return
     */
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() { // 2
        return Pollers.fixedRate(500).get();
    }

    /**
     * FeedEntryMessageSource 实际为feed: inbound-channel-adapter ，
     * 此处即构造feed 的入站通道适配器作为数据输入。
     * @return
     * @throws IOException
     */
    @Bean
    public FeedEntryMessageSource feedMessageSource() throws IOException { //3
        FeedEntryMessageSource messageSource = new FeedEntryMessageSource(resource.getURL(), "news");
        return messageSource;
    }

    /**
     * 读取流程
     *
     * 通过路由方法route 来选择路由，消息体(payload) 的类型为SyndEntry ，
     * 作为判断条件的类型为String ，判断的值是通过payload 获得的分类( Categroy );
     *
     * 通过不同分类的位转向不同的消息通道，若分类为releases ，则转向releasesChannel ;
     * 若分类为engineering ，则转向engineeringChannel; 若分类为news ，则转向newsChannel
     *
     * 通过get 方法获得 IntegrationFlow 实体，配置为Spring 的Bean
     * @return
     * @throws IOException
     */
    @Bean
    public IntegrationFlow myFlow() throws IOException {
        return IntegrationFlows.from(feedMessageSource()) // 流程从from 方法开始。
                .<SyndEntry, String>route(payload -> payload.getCategories().get(0).getName(),//5
                        mapping -> mapping.channelMapping("releases", "releasesChannel") //6
                                .channelMapping("engineering", "engineeringChannel")
                                .channelMapping("news", "newsChannel"))

                .get(); //
    }

    /**
     * releases 流程
     *
     * 1. 从消息通道 releasesChannel 开始获取数据。
     * 2. 使用transfonn 方法进行数据转换。payload 类型为SyndEnt巧，将其转换为字符串类型，并自定义数据的格式。
     * 3. 用handle 方法处理file 的出站适配器。
     * Files 类是由Spring Integration Java DSL 提供的FluentAPI 用来构造文件输出的适配器。
     *
     * @return
     */
    @Bean
    public IntegrationFlow releasesFlow() {
        return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10)) //
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator")) //2
                .handle(Files.outboundAdapter(new File("e:/springblog")) //3
                        .fileExistsMode(FileExistsMode.APPEND) //4
                        .charset("UTF-8") //5
                        .fileNameGenerator(message -> "releases.txt") //6
                        .get())
                .get();
    }

    /**
     * engineering 流程
     * 与releases 流程相同
     * @return
     */
    @Bean
    public IntegrationFlow engineeringFlow() {
        return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 10))
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator"))
                .handle(Files.outboundAdapter(new File("e:/springblog"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .charset("UTF-8")
                        .fileNameGenerator(message -> "engineering.txt")
                        .get())
                .get();
    }

    /**
     * news 流程
     * 1. 通过enrichHeader 来增加消息头的信息。
     * 2. 邮件发送的相关信息通过Spring Integration Java DSL 提供的Mail 的headers 方法来构造。
     * 3. 使用handle 方法来定义邮件发送的出站适自己器，使用Spring Integration Java DSL 提供的Mail.outboundAdapter 来构造，
     * 这里使用wisely-man@126.com 邮箱向自己发送邮件。
     *
     * @return
     */
    @Bean
    public IntegrationFlow newsFlow() {
        return IntegrationFlows.from(MessageChannels.queue("newsChannel", 10))
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator"))
                .enrichHeaders( //1
                        Mail.headers()
                                .subject("来自Spring的新闻")
                                .to(EMAIL_ADDRESS)
                                .from(EMAIL_ADDRESS))
                .handle(Mail.outboundAdapter("smtp.qq.com") //2
                        .port(QQ_EMAIL_PASSWORD)
                        .protocol("smtp")
                        .credentials(EMAIL_ADDRESS, EMAIL_PASSWORD)
                        .javaMailProperties(p -> p.put("mail.debug", "false")), e -> e.id("smtpOut"))
                .get();
    }

}
