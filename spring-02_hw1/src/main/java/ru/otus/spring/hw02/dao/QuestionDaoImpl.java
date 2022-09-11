package ru.otus.spring.hw02.dao;
import ru.otus.spring.hw02.domain.Question;

import java.io.*;
import java.util.*;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    QuestionResult questionResult = new QuestionResult();

    private final List<String> questions = new ArrayList<>();

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findQuestions() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line=reader.readLine()) != null){
                questions.add(line);}
            System.out.println(questions.get(0) +"\n" +questions.get(1)+"\n" +questions.get(2)+"\n" +questions.get(3));
            Scanner in = new Scanner(System.in);
            ArrayList <String> answers = new ArrayList(5);
            answers.add(in.nextLine());
            System.out.println(questions.get(5) +"\n" +questions.get(6)+"\n" +questions.get(7)+"\n" +questions.get(8));
            answers.add(in.nextLine());
            System.out.println(questions.get(10) +"\n" +questions.get(11)+"\n" +questions.get(12)+"\n" +questions.get(13));
            answers.add(in.nextLine());
            System.out.println(questions.get(15) +"\n" +questions.get(16)+"\n" +questions.get(17)+"\n" +questions.get(18));
            answers.add(in.nextLine());
            System.out.println(questions.get(20) +"\n" +questions.get(21)+"\n" +questions.get(22)+"\n" +questions.get(23));
            answers.add(in.nextLine());
            System.out.println("The test is over!");

            questionResult.resultTest(answers);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new Question(fileName, questions);
    }
}