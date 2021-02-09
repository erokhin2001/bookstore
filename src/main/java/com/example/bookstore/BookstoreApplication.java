package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner bookDemo(BookRepository bookRepository) {
        return (args) -> {
            log.info("save a couple of books");


            bookRepository.save(new Book("title", "author", 1944, "isbn", 16.36));
            bookRepository.save(new Book("tidfb", "authors", 1975, "isbn2", 16.63));


            log.info("fetch all books");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }

        };

    }
}
