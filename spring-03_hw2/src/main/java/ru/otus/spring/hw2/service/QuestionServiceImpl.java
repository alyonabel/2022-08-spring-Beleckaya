package ru.otus.spring.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw2.config.ApplicationProps;
import ru.otus.spring.hw2.dao.QuestionDao;

import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;
    private final MessageSource messageSource;
    private final ApplicationProps applicationProps;

    @Autowired
    public QuestionServiceImpl(QuestionDao dao,MessageSource messageSource, ApplicationProps applicationProps) {
        this.dao = dao;
        this.messageSource = messageSource;
        this.applicationProps=applicationProps;


    }

    public void getQuestions() {
        introduceTest();
        dao.findQuestions();
        var messageLocalized = messageSource.getMessage("overTest.user", null, applicationProps.getLocale());
        System.out.println(messageLocalized);
    }

    public void introduceTest() {
       Scanner in = new Scanner(System.in);
       var messageLocalized = messageSource.getMessage("introduce.user", null, applicationProps.getLocale());
       System.out.println(messageLocalized);
       String str = in.nextLine();
       var messageLocalized2 = messageSource.getMessage("inputNumber.user", new String[]{str},applicationProps.getLocale());
       System.out.println(messageLocalized2);
    }

    public void getResult() {
        var messageLocalized = messageSource.getMessage("scoreTest.user", new Integer[]{dao.resultTest()},applicationProps.getLocale());
        System.out.println(messageLocalized);
    }

    @Override
    public void startTest() {
        getQuestions();
        getResult();
    }
}
