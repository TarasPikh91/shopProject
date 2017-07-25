package com.shop.service;

/**
 * Created by taras on 6/14/2017.
 */
public interface MailSendlerService {

    void sendMail(String theme, String mailBody, String email);
}
