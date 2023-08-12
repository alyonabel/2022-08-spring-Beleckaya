package ru.otus.hw;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);

//        BookDao dao = context.getBean(BookDao.class);
//
//        System.out.println("All count: " + dao.count());
//
//        dao.insert("2",1,2);
//
//        System.out.println("All count: " + dao.count());
//
//        Book second = dao.getById(2);
//
//        System.out.println("Second id: " + second.getId() + "name: " + second.getName() + "author: " + second.getAuthor() + "genre: " + second.getGenre());
//
//        System.out.println(dao.getAll());

        Console.main(args);
    }
}