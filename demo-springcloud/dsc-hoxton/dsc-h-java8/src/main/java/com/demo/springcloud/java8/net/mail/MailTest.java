package com.demo.springcloud.java8.net.mail;


import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * 使用 JavaMail 发送邮件
 *
 * @author liuxilin
 * @date 2022/8/12 22:43
 */
public class MailTest {
    public static void main(String[] args) throws MessagingException, IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("data", "mail.properties"))) {
            props.load(in);
        }
        List<String> lines = Files.readAllLines(Paths.get("data\\message.txt"), Charset.forName("UTF-8"));

        String from = lines.get(0);
        String to = lines.get(1);
        String subject = lines.get(2);

        StringBuilder builder = new StringBuilder();
        for (int i = 3; i < lines.size(); i++) {
            builder.append(lines.get(i));
            builder.append("\n");
        }

        Console console = System.console();
        String password = new String(console.readPassword("Password: "));

        Session mailSession = Session.getDefaultInstance(props);
        // mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(builder.toString());
        Transport tr = mailSession.getTransport();
        try {
            tr.connect(null, password);
            tr.sendMessage(message, message.getAllRecipients());
        } finally {
            tr.close();
        }
    }
}
