package ru.otus.spring.hw2.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.hw2.config.ApplicationProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = ApplicationProps.class)
@ActiveProfiles("test")
public class QuestionDaoImplTest  {

    @Autowired
    private ApplicationProps applicationProps;

    @Test
    @DisplayName("BindingYMLPropertiesUnitTest")
    void whenBindingYMLConfigFile_thenAllFieldsAreSet(){
        Assertions.assertNotNull(applicationProps.getAnswersFile());
        Assertions.assertNotNull(applicationProps.getQuestionsFile());
        Assertions.assertNotNull(applicationProps.getLocale());
    }
}