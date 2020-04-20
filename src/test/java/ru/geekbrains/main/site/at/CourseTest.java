package ru.geekbrains.main.site.at;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

/**
 * 6. Нажать в навигации "Курсы"
 * 7. Нажать в шапке сайта "Курсы"
 * 8. Выбрать в фильтрах чекбокс "Бесплатные"
 * 9. Выбрать в фильтрах чекбокс "Тестирование"
 * 10. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 1"
 * 11. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 2"
 */

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка страницы Курсы")
@Feature(value = "Проверка страниц")
@Story(value = "Проверка страницы Курсы")
public class CourseTest extends BaseTest {

    @DisplayName("Вход с валидными логином и паролем")
    @Test
    void checkSingInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");

        ((CoursePage)
                PageFactory.initElements(driver, AuthorizationPage.class)
                        .authorization(login, password)
                        .checkNamePage("Главная")
                        .getNavigation()
                        .clickButton("Курсы")
        )
                .getCourseHeader().clickButton("Курсы")
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses("Тестирование ПО. Уровень 1", "Тестирование ПО. Уровень 2");

    }
}