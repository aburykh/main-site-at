package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.base.BaseTest;


/**
 * 1. Перейти на сайт https://geekbrains.ru/courses
 * 2. Нажать на кнопку Курсы
 * 3. Проверить что страница Курсы открылась
 * 4. Повторить для:
 * - Курсы
 * - Вебинары
 * - Форум
 * - Блог
 * - Тесты
 * - Карьера
 * <p>
 * <p>
 * /////////////////////////////////////////////////////
 * >>>Доработка Тест 1
 * <p>
 * V 1. Вынести проверку каждой страницы в отдельный тест
 * V 2. Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)
 * 3*. (Дополнительное задание, тема следующего занятия):
 * Создать классы Header и Footer, в которых создать локаторы ко всем элементам в этих блоках
 */


/**
 * /////////////////////////////////////////////////////
 * Создать ветку lessons 4_hw
 * V 1. Доработать через Parameterized тест с навигацией
 * V 2. Изменить во втором тесте проверки на hamcrest
 */

@DisplayName("Тесты навигации по сайту GeekBrains")
public class NavigationTest extends BaseTest {

    //Курсы
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Курсы\"")
    @ValueSource(strings = {"Что-то там ещё", "Курсы"})
    void checkNavCoursesTest(String arg) throws InterruptedException {

        WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
        buttonCourses.click();
        WebElement headerCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerCourses.getText());

    }

    //Вебинары
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Вебинары\"")
    @ValueSource(strings = {"Вебинары", "Курсы"})
    void checkNavEvents(String arg) throws InterruptedException {

        WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
        buttonEvents.click();
        WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerPageEvents.getText());

    }

    //Форум
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Форум\"")
    @ValueSource(strings = {"Вебинары", "Курсы", "Форум"})
    void checkNavTopics(String arg) throws InterruptedException {

        WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
        buttonTopics.click();
        WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerPageTopics.getText());

    }

    //Блог
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Блог\"")
    @ValueSource(strings = {"Вебинары", "Блог", "Форум"})
    void checkNavPosts(String arg) throws InterruptedException {

        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
        buttonPosts.click();
        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerPagePosts.getText());

    }

    //Тесты
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Тесты\"")
    @ValueSource(strings = {"Вебинары", "Тесты"})
    void checkNavTests(String arg) throws InterruptedException {

        WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
        buttonTests.click();
        WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerPageTests.getText());

    }

    //Карьера
    //@Test
    @ParameterizedTest
    @DisplayName("Тест страницы \"Карьера\"")
    @ValueSource(strings = {"Вебинары", "Карьера", "Карьера"})
    void checkNavCareer(String arg) throws InterruptedException {

        WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
        buttonCareer.click();
        WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals(arg, headerPageCareer.getText());

    }
}