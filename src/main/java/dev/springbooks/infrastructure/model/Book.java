package dev.springbooks.infrastructure.model;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {

}
