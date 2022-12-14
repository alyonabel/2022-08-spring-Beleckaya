package ru.otus.spring.hw02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw02.dao.QuestionDao;

import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    @Autowired
    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public void introduceTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nHello! Let's start the test!\nPlease introduce yourself! Input your name and press Enter\n");
        String str = in.nextLine();
        System.out.println("\nHello " + str + "!" + "\n Input the number of answer and press Enter\n Good luck!\n");
    }

    @Override
    public void getQuestions() {
        introduceTest();
        dao.findQuestions();
    }

    @Override
    public void getResult() {
        dao.resultTest();
    }

    @Override
    public void startTest() {
        getQuestions();
        getResult();
    }

}
