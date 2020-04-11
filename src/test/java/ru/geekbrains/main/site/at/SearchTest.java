package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

/**
 * 1. Перейти на сайт https://geekbrains.ru/courses
 * 2. Нажать на кнопку Курсы
 * 3. Проверить что страница Курсы открылась
 * 4. Повторить для:
 *      - Курсы
 *      - Вебинары
 *      - Форум
 *      - Блог
 *      - Тесты
 *      - Карьера
 *
 * /////////////////////////////////////////////////////
 * >>>Доработка Тест 1
 *
 * 1. Вынести проверку каждой страницы в отдельный тест
 * 2. Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)
 * 3. (Дополнительное задание, тема следующего занятия) Cоздать классы Header и Footer, в которых создать локаторы ко всем элементам в этих блоках
 *
 *  /////////////////////////////////////////////////////
 * >>> Доработка Тест 2
 *
 * 1. Перейти на сайт https://geekbrains.ru/courses
 * 2. Нажать на кнопку Поиск
 * 3. В поле Поиск ввести текст: java
 * 4. Проверить что отобразились блоки и в них:
 *      - Профессий не менее чем 2
 *      - Курсов более 15
 *      - Вебинаров больше чем 180, но меньше 300
 *      - Блогов более 300
 *      - Форумов не 350
 *      - Тестов не 0
 *      - В Проектах и компаниях отображается GeekBrains
 */

public class SearchTest extends BaseTest {

    @Test
    void name() {
        driver.get("https://geekbrains.ru/career");
        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));


        WebDriverWait wait = new WebDriverWait(driver, 40);
//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Профессии']"),"Профессии"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Курсы']"),"Курсы"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Вебинары']"),"Вебинары"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Блоги']"),"Блоги"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Форум']"),"Форум"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Тесты']"),"Тесты"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Проекты и компании']"),"Проекты и компании"));
//
        wait.until(ExpectedConditions.textToBePresentInElement(textProfession,"Профессии"));
        wait.until(ExpectedConditions.textToBePresentInElement(textCourses,"Курсы"));
        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars,"Вебинары"));
        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs,"Блоги"));
        wait.until(ExpectedConditions.textToBePresentInElement(textForum,"Форум"));
        wait.until(ExpectedConditions.textToBePresentInElement(textTests,"Тесты"));
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies,"Проекты и компании"));

//        Assertions.assertEquals("Курсы", textCourses.getText());
//        Assertions.assertEquals("Вебинары", textWebinars.getText());
//        Assertions.assertEquals("Блоги", textBlogs.getText());
//        Assertions.assertEquals("Форум", textForum.getText());
//        Assertions.assertEquals("Тесты", textTests.getText());
//        Assertions.assertEquals("Проекты и компании", textProjectsAndCompanies.getText());


    }
}
