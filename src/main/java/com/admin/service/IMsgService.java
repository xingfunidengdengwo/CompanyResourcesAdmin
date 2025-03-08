package com.admin.service;

import org.springframework.mail.MailSendException;

import javax.mail.MessagingException;

public interface IMsgService {

    // 发送邮件
    void sendMsg(String msg) throws MessagingException, MailSendException;
}
