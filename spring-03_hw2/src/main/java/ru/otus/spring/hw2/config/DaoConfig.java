package ru.otus.spring.hw2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;


@ConfigurationProperties(prefix = "application")
public class DaoConfig {

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
