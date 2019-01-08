package com.xuting.xuwuproject.web.service.mail;

import com.xuting.xuwuproject.XuwuProjectApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

import static org.junit.Assert.*;

/**
 * @Author: dongQin
 * @Date: 2019/1/8 13:20
 * @Description: 邮件服务测试
 */

public class MailServiceTest extends XuwuProjectApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendMessageMail() throws MessagingException {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "000006");
        String emailContent = templateEngine.process("/email/emailTemplate", context);

        mailService.sendHtmlMail("228386474@qq.com","主题：这是模板邮件",emailContent);
    }

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("228386474@qq.com","test simple mail"," hello this is simple mail");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("228386474@qq.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="e:\\tmp\\application.log";
        mailService.sendAttachmentsMail("228386474@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

        mailService.sendInlineResourceMail("228386474@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
}