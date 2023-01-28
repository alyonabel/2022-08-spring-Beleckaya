package ru.otus.spring.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw2.dao.QuestionDao;

import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;
    private final LocaleMessage localeMessage;


    @Autowired
    public QuestionServiceImpl(QuestionDao dao, LocaleMessage localeMessage) {
        this.dao = dao;
        this.localeMessage = localeMessage;
    }

    public void getQuestions() {
        introduceTest();
        dao.findQuestions();
        System.out.println(localeMessage.showMessage("overTest.user"));
    }

    public void introduceTest() {
        Scanner in = new Scanner(System.in);
        System.out.println(localeMessage.showMessage("introduce.user"));
        String str = in.nextLine();
        System.out.println(localeMessage.showMessage("inputNumber.user", str));
    }

    public void getResult() {
        System.out.println(localeMessage.showMessage("scoreTest.user", dao.resultTest()));
    }

    @Override
    public void startTest() {
        getQuestions();
        getResult();
    }
}
