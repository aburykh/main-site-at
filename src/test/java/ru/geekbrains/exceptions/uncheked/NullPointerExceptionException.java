package ru.geekbrains.exceptions.uncheked;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class NullPointerExceptionException {

    WebDriver webDriver;

    @Test
    void name() {
        webDriver.get("https://google.com");
    }
}