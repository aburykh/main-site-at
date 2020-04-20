/**
package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка Поиска")
@Feature(value = "Проверка страниц")
@Story(value = "Проверка Поиска")
public class SearchWebTest extends BaseTest {
//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки:
//            Профессии
//            Курсы
//            Вебинары
//            Блоги
//            Форум
//            Тесты
//            Проекты и компании

    @Test
    @DisplayName("Проверка по ключевому слову Java")
    void name() {
        driver.get("https://geekbrains.ru/career");
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg")));
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
}*/
