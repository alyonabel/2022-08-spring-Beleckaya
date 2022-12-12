package ru.otus.spring.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw2.config.DaoConfig;
import ru.otus.spring.hw2.dao.QuestionDaoImpl;

import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDaoImpl daoImpl;
    private final MessageSource messageSource;
    private final DaoConfig daoConfig;

    @Autowired
    public QuestionServiceImpl(QuestionDaoImpl daoImpl, MessageSource messageSource, DaoConfig daoConfig) {
        this.daoImpl = daoImpl;
        this.messageSource = messageSource;
        this.daoConfig = daoConfig;
    }

    public void getQuestions() {
        introduceTest();
        daoImpl.findQuestions();
    }

    public void introduceTest() {
        Scanner in = new Scanner(System.in);
        var messageLocalized = messageSource.getMessage("introduce", new String[]{""}, daoConfig.getLocale());
        System.out.println(messageLocalized);
        String str = in.nextLine();
        var messageLocalized2 = messageSource.getMessage("inputNumber", new String[]{str}, daoConfig.getLocale());
        System.out.println(messageLocalized2);
    }

    public void getResult() {
        daoImpl.resultTest();
    }

    @Override
    public void startTest() {
        getQuestions();
        getResult();
    }
}
