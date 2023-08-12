package ru.otus.hw.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw.service.BookService;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommands {
    private final BookService bookService;

    @ShellMethod(value = "Count of books", key = {"c", "count"})
    public String countBooks() {
        return "The count of books is " + bookService.countBooks();
    }

    @ShellMethod(value = "Select book", key = {"s", "select"})
    public String selectBook(@ShellOption long id) {
       return bookService.showBook(id);
    }

    @ShellMethod(value = "Select all", key = {"sa", "select all"})
    public String selectBooks() {
        return bookService.showAll();
    }

    @ShellMethod(value = "Create book", key = {"cr", "create"})
    public String createBook(@ShellOption String name, @ShellOption String author, @ShellOption String genre) {
       long id = bookService.create(name,author,genre);
       return "Book with is created with id= "+ id + " successfully.";
    }

    @ShellMethod(value = "Update book", key = {"up", "update"})
    public String updateBook(@ShellOption long id,@ShellOption String name, @ShellOption String author, @ShellOption String genre) {
        bookService.updateBook(id,name,author,genre);
        return "Book with id " + id + " is updated successfully.";
    }

    @ShellMethod(value = "Delete book", key = {"d", "delete"})
    public String deleteBook(@ShellOption long id) {
        bookService.delete(id);
        return "Book with id " + +id+ " is deleted successfully.";
    }
}
