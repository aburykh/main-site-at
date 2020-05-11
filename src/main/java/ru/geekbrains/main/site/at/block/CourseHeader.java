package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseHeader {

    public CourseHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class*=\"nav nav-tabs\"] [id=\"prof-link\"]")
    private WebElement buttonProfessions;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [id=\"free-link\"]")
    private WebElement buttonFreeIntensive;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [id=\"cour-link\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href*=\"https://forbusiness\"]")
    private WebElement buttonCompanies;


    private WebDriver driver;

    @Step("Проверка перехода в блок {nameButton}")
    public CourseHeader clickButton(String nameButton) {
        switch (nameButton) {
            case "Профессии": {
                buttonProfessions.click();
                break;
            }
            case "Бесплатные интенсивы": {
                buttonFreeIntensive.click();
                break;
            }
            case "Курсы": {
                buttonCourses.click();
                break;
            }
            case "Компаниям": {
                buttonCompanies.click();
                break;
            }
            default: {
                throw new NotFoundException("Не найдена кнопка с именем: " + nameButton);
            }
        }

        return this;
    }
}