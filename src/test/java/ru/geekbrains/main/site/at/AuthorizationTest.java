package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

/**
 * 1. Перейти на страницу авторизация https://geekbrains.ru/login
 * 2. Ввести логин : hao17583@bcaoo.com
 * 3. Пароль: hao17583
 * 4. Нажать кнопку войти
 * 5. Проверить что отобразилась страница "Главная"
*/

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Вход с валидными логин/пароль")
    @Test
    @Issue(value = "https://google.com")
    @TmsLink(value = "https://ya.ru")
    @Description(value = "Описание теста")
    void checkSingInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");
        PageFactory.initElements(driver, AuthorizationPage.class)
                .authorization(login, password)
                .checkNamePage("Главная");
    }
}