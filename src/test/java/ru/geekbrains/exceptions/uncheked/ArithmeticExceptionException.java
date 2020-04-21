package ru.geekbrains.exceptions.uncheked;

import org.junit.jupiter.api.Test;

public class ArithmeticExceptionException {

    @Test
    void name() {
        System.out.println(5/0);
    }
}