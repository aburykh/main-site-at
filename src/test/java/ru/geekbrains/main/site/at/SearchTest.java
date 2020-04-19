package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

@Execution(ExecutionMode.CONCURRENT)
public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Тест поиска на портале GeekBrains")
    void checkSearchTest() {

        driver.get("https://geekbrains.ru/career");
        WebDriverWait wait = new WebDriverWait(driver, 40);

        PageFactory.initElements(driver, SearchPage.class)
                .clickSearch()
                .inputSearch()
                .checkProfession()
                .checkCourses()
                .checkWebinars()
                .checkBlogs()
                .checkForum()
                .checkTests()
                .checkProjectsAndCompanies();

    }
}