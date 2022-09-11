package ru.otus.spring.hw01.dao;

import ru.otus.spring.hw01.domain.Questions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao{

    private final String fileName;
    private final List<String> questions = new ArrayList<>();

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public Questions findQuestions() throws IOException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line=reader.readLine()) != null){
                questions.add(line);}
            System.out.println(questions);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file with questions doesn't exist in the specified directory!");
        }
       return new Questions(fileName);
    }

}
