package ru.otus.spring.hw02.dao;

import ru.otus.spring.hw02.domain.Question;
import ru.otus.spring.hw02.exceptions.TestFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;
    private final String fileAnswersName;
    private final List<String> questions = new ArrayList<>();
    private final List<String> answersUser = new ArrayList<>(5);
    private final List<String> rightAnswers = new ArrayList<>(5);

    public QuestionDaoImpl(String fileName, String fileAnswersName) {
        this.fileName = fileName;
        this.fileAnswersName = fileAnswersName;
    }

    @Override
    public Question findQuestions() {
        readFile(fileName, questions);
        System.out.println(questions.get(0) + "\n" + questions.get(1) + "\n" + questions.get(2) + "\n" + questions.get(3));
        var in = new Scanner(System.in);
        answersUser.add(in.nextLine());
        System.out.println(questions.get(5) + "\n" + questions.get(6) + "\n" + questions.get(7) + "\n" + questions.get(8));
        answersUser.add(in.nextLine());
        System.out.println(questions.get(10) + "\n" + questions.get(11) + "\n" + questions.get(12) + "\n" + questions.get(13));
        answersUser.add(in.nextLine());
        System.out.println(questions.get(15) + "\n" + questions.get(16) + "\n" + questions.get(17) + "\n" + questions.get(18));
        answersUser.add(in.nextLine());
        System.out.println(questions.get(20) + "\n" + questions.get(21) + "\n" + questions.get(22) + "\n" + questions.get(23));
        answersUser.add(in.nextLine());
        System.out.println("The test is over!");
        return new Question(fileName, questions);
    }

    @Override
    public void resultTest() {
        readFile(fileAnswersName, rightAnswers);
        int count = 0;
        for (int i = 0; i < rightAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(answersUser.get(i))) {
                count++;
            }
        }
        System.out.println("Your score for the test: " + count);
    }

    private void readFile(String file, List<String> list) {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (TestFileException e) {
            System.out.println("The reading a file isn't available! Please start the test later.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}