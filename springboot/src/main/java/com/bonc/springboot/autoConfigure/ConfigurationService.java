package com.bonc.springboot.autoConfigure;

import com.bonc.springboot.service.I18nService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author: liming522
 * @description:
 * @date: 2022/10/13 10:47 AM
 * @hope: The newly created file will not have a bug
 */
@Configuration
public class ConfigurationService {
    @Value("${spring.messages.basename}")
    private String beanName;

    @Value("${spring.messages.encoding}")
    private String encoding;

    @Bean
    public I18nService i18nService() {
        return new I18nService(messageSource());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource  messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(beanName);
        messageSource.setDefaultEncoding(encoding);
        return messageSource;
    }

}
