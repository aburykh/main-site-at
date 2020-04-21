package ru.geekbrains.exceptions.uncheked;

import org.junit.jupiter.api.Test;

public class StringIndexOutOfBoundsExample {

    @Test
    void name() {
        String name = "Бармаглот";
        System.out.println(name.charAt(10));
    }
}