package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.page.content.HomePage;
import ru.geekbrains.main.site.at.page.content.TestPage;
import ru.geekbrains.main.site.at.page.content.base.BasePage;

public class Navigation {

    @FindBy(css = "[class=\"svg-icon icon-logo\"]")
    private WebElement icon;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка нажатия на кнопку {nameButton}")
    public BasePage clickButton(Button button) {
        BasePage basePage = null;

        switch (button) {
            case icon:
                icon.click();
                //return new HomePage(driver);
                basePage = new HomePage(driver);
                break;
            //return PageFactory.initElements(driver, HomePage.class);
            case buttonCourses:
                buttonCourses.click();
                //return new CoursePage(driver);
                basePage = new CoursePage(driver);
                break;
            //return PageFactory.initElements(driver, CoursePage.class);
            case buttonEvents:
                buttonEvents.click();
                break;
            case buttonTopics:
                buttonTopics.click();
                break;
            case buttonPosts:
                buttonPosts.click();
                break;
            case buttonTests:
                buttonTests.click();
                basePage = new TestPage(driver);
                break;
            case buttonCareer:
                buttonCareer.click();
                break;
            //            default: {
//                throw new NotFoundException("Не найдена кнопка с именем: " + button.getName());
        }

        if (null == basePage) {
            throw new NotFoundException("Страница: " + button.getName() + " не описана!");
        }

        return basePage;
    }

//        return new HomePage(driver);
//        //return PageFactory.initElements(driver, HomePage.class);
//    }

    public enum Button {
        icon("Главная"),
        buttonCourses("Курсы"),
        buttonEvents("Вебинары"),
        buttonTopics("Форум"),
        buttonPosts("Блог"),
        buttonTests("Тесты"),
        buttonCareer("Карьера");

        private String name;

        Button(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}