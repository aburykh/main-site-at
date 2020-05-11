package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.page.content.base.BasePage;

public class TestPage extends BasePage {

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TestPage openUrl() {
        driver.get("https://geekbrains.ru/tests");
        //driver.get("https://geekbrains.ru/career");
        return this;
    }
}