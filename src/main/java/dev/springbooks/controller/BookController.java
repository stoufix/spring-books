package dev.springbooks.controller;

import dev.springbooks.infrastructure.repository.CountriesRepository;
import dev.springbooks.infrastructure.model.Book;
import dev.springbooks.infrastructure.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final CountriesRepository countriesRepository;

    public BookController(BookRepository bookRepository, CountriesRepository countriesRepository) {
        this.bookRepository = bookRepository;
        this.countriesRepository = countriesRepository;
    }

    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {

        var countries = countriesRepository.getCountrie("tunis");
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookRepository.findOne(id);
    }
}
