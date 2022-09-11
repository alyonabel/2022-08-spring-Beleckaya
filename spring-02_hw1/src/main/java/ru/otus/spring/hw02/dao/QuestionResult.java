package ru.otus.spring.hw02.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuestionResult {
    private String fileAnswersName="answers.csv";

    public void resultTest(ArrayList<String> arrayList) throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream(fileAnswersName);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(input));
        String line;
        ArrayList <String> right = new ArrayList(5);
        while((line=reader2.readLine()) != null){
            right.add(line);}
        int count = 0;
        for (int i = 0; i < right.size(); i++) {
            if (right.get(i).equals(arrayList.get(i)))
            { count++; }
        }
        System.out.println("Your score for the test: " + count );
    }
}
