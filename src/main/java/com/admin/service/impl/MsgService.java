package com.admin.service.impl;

import com.admin.bean.Email;
import com.admin.service.IMsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MsgService implements IMsgService {

    private final JavaMailSender javaMailSender;
    private final Email email;

    @Override
    public void sendMsg(String msg) throws MessagingException, MailSendException {

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(email.getFrom() + "(" + email.getName() + ")");

        helper.setTo(email.getTo());

        helper.setSubject(email.getSubject());

        String content = email.getContextPrefix() + msg + email.getContextSuffix();

        helper.setText(content, true);

        javaMailSender.send(message);

    }
}
