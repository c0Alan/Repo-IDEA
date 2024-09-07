package com.demo.springcloud.controller;

import com.demo.springcloud.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 邮件发送
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(value = "邮件发送")
@RestController
@RequestMapping("/mail")
public class MailController {


    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.sendTo}")
    private String sendTo;

    @GetMapping("/send")
    public String send() {
        sendSimpleMail();
        return "success";
    }

    public void sendSimpleMail() {
        mailService.sendSimpleMail(from, sendTo, "这是一封测试邮件！", "这是一封测试邮件！");
    }

    public void sendHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(from, sendTo, "test simple mail", content);
    }

    public void sendAttachmentsMail() {
        String filePath = "e:\\tmp\\application.log";
        mailService.sendAttachmentsMail(from, sendTo, "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        mailService.sendInlineResourceMail(from, sendTo, "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("MailTemplate", context);
        mailService.sendHtmlMail(from, sendTo, "主题：这是模板邮件", emailContent);
    }
}
