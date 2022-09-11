package ru.otus.spring.hw02.service;

import ru.otus.spring.hw02.dao.QuestionDao;
import ru.otus.spring.hw02.domain.Question;

import java.io.IOException;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    public void introduceTest () {
        Scanner in = new Scanner(System.in);
        System.out.println("\nHello! Let's start the test!\nPlease introduce yourself! Input your name and press Enter\n");
        String str = in.nextLine();
        System.out.println("\nHello " + str +"!" +"\n Input the number of answer and press Enter\n Good luck!\n");
    }

    @Override
    public Question getQuestions() throws IOException {
        introduceTest();
        return dao.findQuestions();
    }
}
