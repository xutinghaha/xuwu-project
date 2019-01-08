package com.xuting.xuwuproject.config.exception;

import com.xuting.xuwuproject.web.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @Author: dongQin
 * @Date: 2019/1/8 13:31
 * @Description: 全局捕获异常
 */
@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @ExceptionHandler(value = Exception.class)
    public void myExceptionHandler(Exception ex){
        Context context = new Context();
        context.setVariable("message", ex);
        String emailContent = templateEngine.process("email/emailTemplate", context);
        try {
            mailService.sendHtmlMail("228386474@qq.com","系统错误日志邮件",emailContent);
        } catch (MessagingException e) {
            log.error("mail send failed");
        }


    }
}
