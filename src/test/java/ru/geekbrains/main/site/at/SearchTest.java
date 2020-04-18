package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Execution(ExecutionMode.CONCURRENT)
public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Тест поиска на портале GeekBrains")
    void checkSearchTest() {

        driver.get("https://geekbrains.ru/career");
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg")));
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


//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Профессии']"),"Профессии"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Курсы']"),"Курсы"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Вебинары']"),"Вебинары"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Блоги']"),"Блоги"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Форум']"),"Форум"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Тесты']"),"Тесты"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Проекты и компании']"),"Проекты и компании"));

        wait.until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
        String textProfActual = textProfession.getText();
        assertThat(textProfActual, allOf(equalToIgnoringCase("профессии"), containsString("Про")));

        String profActual = countProfession.getText();

        try {
            int countOfProfessions = Integer.parseInt(profActual.trim());
            System.out.println("countOfProfessions = " + countOfProfessions);
            //Assertions.assertTrue(countOfProfessions >= 2);
            assertThat(countOfProfessions, greaterThanOrEqualTo(2));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textCourses, "Курсы"));
        String textCoursesActual = textCourses.getText();
        assertThat(textCoursesActual, allOf(equalToIgnoringCase("курсы"), containsString("ур")));

        String coursesActual = countCourses.getText();
        try {
            int countOfCourses = Integer.parseInt(coursesActual.trim());
            System.out.println("countOfCourses = " + countOfCourses);
            //Assertions.assertTrue(countOfCourses > 15);
            assertThat(countOfCourses, greaterThan(15));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textWebinars, "Вебинары"));
        String textWebinarsActual = textWebinars.getText();
        assertThat(textWebinarsActual, allOf(equalToIgnoringCase("вебинары"), containsString("бинар"), endsWith("ры")));

        String webinarsActual = countWebinars.getText();
        try {
            int countOfWebinars = Integer.parseInt(webinarsActual.trim());
            System.out.println("countOfWebinars = " + countOfWebinars);
            //Assertions.assertTrue(countOfWebinars > 180 && countOfWebinars < 300);
            assertThat(countOfWebinars, allOf(greaterThan(180), lessThan(300)));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textBlogs, "Блоги"));
        String textBlogsActual = textBlogs.getText();
        assertThat(textBlogsActual, allOf(equalToIgnoringCase("блоги"), containsString("лог")));

        String blogsActual = countBlogs.getText();
        try {
            int countOfBlogs = Integer.parseInt(blogsActual.trim());
            System.out.println("countOfBlogs = " + countOfBlogs);
            //Assertions.assertTrue(countOfBlogs > 300);
            assertThat(countOfBlogs, greaterThan(300));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textForum, "Форум"));
        String textForumActual = textForum.getText();
        assertThat(textForumActual, allOf(equalToIgnoringCase("форум"), containsString("ору")));

        String forumsActual = countForums.getText();
        try {
            int countOfForums = Integer.parseInt(forumsActual.trim());
            System.out.println("countOfForums = " + countOfForums);
            //Assertions.assertTrue(countOfForums != 350);
            assertThat(countOfForums, not(350));
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textTests, "Тесты"));
        String textTestsActual = textTests.getText();
        assertThat(textTestsActual, allOf(equalToIgnoringCase("тесты"), containsStringIgnoringCase("тест")));

        String testsActual = countTests.getText();
        try {
            int countOfTests = Integer.parseInt(testsActual.trim());
            System.out.println("countOfTests = " + countOfTests);
            //Assertions.assertTrue(countOfTests != 0);
            assertThat(countOfTests, not(350));

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies, "Проекты и компании"));
        driver.findElement(By.cssSelector("[class=\"company-item__pic\"] [src*=\"63268ac.png\"]")).isDisplayed();

        WebElement textGB = driver.findElement(By.cssSelector("h3 [href=\"/career/682\"]"));
        Assertions.assertEquals("Образовательный портал GeekBrains", textGB.getText());
        String textGBActual = textGB.getText();
        assertThat(textGBActual, allOf(
                equalToIgnoringCase("образовательный портал geekbrains"),
                containsStringIgnoringCase("geekbrains"),
                endsWith("GeekBrains"),
                equalToCompressingWhiteSpace("Образовательный портал GeekBrains")
        ));

        WebElement logoGB = driver.findElement(By.cssSelector("[class=\"company-item__pic\"] [src*=\"63268ac.png\"]"));
        logoGB.click();


//        Assertions.assertEquals("Курсы", textCourses.getText());
//        Assertions.assertEquals("Вебинары", textWebinars.getText());
//        Assertions.assertEquals("Блоги", textBlogs.getText());
//        Assertions.assertEquals("Форум", textForum.getText());
//        Assertions.assertEquals("Тесты", textTests.getText());
//        Assertions.assertEquals("Проекты и компании", textProjectsAndCompanies.getText());


    }
}
