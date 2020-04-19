package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

public class NavigationTest extends BaseTest {

    //Курсы
    @Test
    void checkNavCoursesTest() {

        WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
        buttonCourses.click();
        WebElement headerCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Курсы", headerCourses.getText());

    }

    //Вебинары
    @Test
    void checkNavEvents() {

        WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
        buttonEvents.click();
        WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", headerPageEvents.getText());

    }

    //Форум
    @Test
    void checkNavTopics() {

        WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
        buttonTopics.click();
        WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Форум", headerPageTopics.getText());

    }

    //Блог
    @Test
    void checkNavPosts() {

        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
        buttonPosts.click();
        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Блог", headerPagePosts.getText());

    }

    //Тесты
    @Test
    void checkNavTests() {

        WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
        buttonTests.click();
        WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Тесты", headerPageTests.getText());

    }

    //Карьера
    @Test
    void checkNavCareer() {

        WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
        buttonCareer.click();
        WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Карьера", headerPageCareer.getText());

    }
}