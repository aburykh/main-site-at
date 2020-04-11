package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
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
    void checkSearchTest() {

        driver.get("https://geekbrains.ru/career");

        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        WebElement countProfession = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"professions\"] span"));

        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        WebElement countCourses = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"courses\"] span"));

        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        WebElement countWebinars = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span"));

        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        WebElement countBlogs = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span"));

        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        WebElement countForums = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"forums\"] span"));

        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        WebElement countTests = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"tests\"] span"));

        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));
        //WebElement countCompanies = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"companies\"] span"));


        WebDriverWait wait = new WebDriverWait(driver, 40);
//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Профессии']"),"Профессии"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Курсы']"),"Курсы"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Вебинары']"),"Вебинары"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Блоги']"),"Блоги"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Форум']"),"Форум"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Тесты']"),"Тесты"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Проекты и компании']"),"Проекты и компании"));

        wait.until(ExpectedConditions.textToBePresentInElement(textProfession,"Профессии"));
        String profActual = countProfession.getText();
        try
        {
            int countOfProfessions = Integer.parseInt(profActual.trim());
            System.out.println("countOfProfessions = " + countOfProfessions);
            Assertions.assertTrue(countOfProfessions >= 2);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


        wait.until(ExpectedConditions.textToBePresentInElement(textCourses,"Курсы"));
        String coursesActual = countCourses.getText();
        try
        {
            int countOfCourses = Integer.parseInt(coursesActual.trim());
            System.out.println("countOfCourses = " + countOfCourses);
            Assertions.assertTrue(countOfCourses > 15);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars,"Вебинары"));
        String webinarsActual = countWebinars.getText();
        try
        {
            int countOfWebinars = Integer.parseInt(webinarsActual.trim());
            System.out.println("countOfWebinars = " + countOfWebinars);
            Assertions.assertTrue(countOfWebinars > 180 && countOfWebinars < 300);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs,"Блоги"));
        String blogsActual = countBlogs.getText();
        try
        {
            int countOfBlogs = Integer.parseInt(blogsActual.trim());
            System.out.println("countOfBlogs = " + countOfBlogs);
            Assertions.assertTrue(countOfBlogs > 300);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


        wait.until(ExpectedConditions.textToBePresentInElement(textForum,"Форум"));
        String forumsActual = countForums.getText();
        try
        {
            int countOfForums = Integer.parseInt(forumsActual.trim());
            System.out.println("countOfForums = " + countOfForums);
            Assertions.assertTrue(countOfForums != 350);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


        wait.until(ExpectedConditions.textToBePresentInElement(textTests,"Тесты"));
        String testsActual = countTests.getText();
        try
        {
            int countOfTests = Integer.parseInt(testsActual.trim());
            System.out.println("countOfTests = " + countOfTests);
            Assertions.assertTrue(countOfTests != 0);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies,"Проекты и компании"));
        WebElement logoGB = driver.findElement(By.cssSelector("[class=\"company-item__pic\"] [src=\"https://d2xzmw6cctk25h.cloudfront.net/coverimage/1361021/attachment/thumb-3a75c9438b95bfc500e2360bf63268ac.png\"]"));
        WebElement textGB = driver.findElement(By.cssSelector("h3 [href=\"/career/682\"]"));
        assertEquals("Образовательный портал GeekBrains", textGB.getText());
        logoGB.click();


//        Assertions.assertEquals("Курсы", textCourses.getText());
//        Assertions.assertEquals("Вебинары", textWebinars.getText());
//        Assertions.assertEquals("Блоги", textBlogs.getText());
//        Assertions.assertEquals("Форум", textForum.getText());
//        Assertions.assertEquals("Тесты", textTests.getText());
//        Assertions.assertEquals("Проекты и компании", textProjectsAndCompanies.getText());



    }
}
