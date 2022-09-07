package ru.otus.spring.hw01.dao;
import ru.otus.spring.hw01.domain.Question;

import java.io.*;

public class QuestionDaoImpl implements QuestionDao{

    private final String fileName;

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public Question findQuestions() throws IOException {
        try {

            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            byte[] b = new byte[is.available()];
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
            is.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file with questions doesn't exist in the specified directory!");
        }
        return new Question(fileName);
    }

}
