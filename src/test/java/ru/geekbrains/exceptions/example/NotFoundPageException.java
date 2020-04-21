package ru.geekbrains.exceptions.example;

public class NotFoundPageException extends RuntimeException {
    public NotFoundPageException() {
    }

    public NotFoundPageException(String message) {
        super(message);
    }
}