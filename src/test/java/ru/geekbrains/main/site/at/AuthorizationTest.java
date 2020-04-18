package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Вход с валидный логин/пароль")
    @Test
    void checkSingInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");
        PageFactory.initElements(driver, AuthorizationPage.class)
                .authorization(login, password)
                .checkNamePage("Главная");
    }
}