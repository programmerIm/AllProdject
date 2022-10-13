package com.bonc.springboot.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author: liming522
 * @description:
 * @date: 2022/10/12 6:23 PM
 * @hope: The newly created file will not have a bug
 */
@Component
public class I18nService {
    private final  MessageSource messageSource;

    public I18nService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String msgKey, Locale locale, Object... args) {
        return messageSource.getMessage(msgKey, args, locale);
    }

    public String getMessage(String msgKey,Locale locale) {
        return messageSource.getMessage(msgKey, null,locale);
    }
}
