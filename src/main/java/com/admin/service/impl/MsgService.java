package com.admin.service.impl;

import com.admin.bean.Email;
import com.admin.service.IMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class MsgService implements IMsgService {

    private  final JavaMailSender javaMailSender;
    private final Email email;

    @Override
    public void sendMsg(String msg) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(email.getFrom() + "(" + email.getName() + ")");

            helper.setTo(email.getTo());

            helper.setSubject(email.getSubject());

            String content = email.getContextPrefix() + msg + email.getContextSuffix();
            helper.setText(content,true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("邮件发送失败... ...");
        }

        log.info("发送成功!");
    }
}
