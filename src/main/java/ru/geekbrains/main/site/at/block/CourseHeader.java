package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.CoursePage;

public class CourseHeader {

    public CourseHeader(WebDriver driver) {
        this.driver = driver;
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

    public CoursePage clickButton(String nameButton) {
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

        return PageFactory.initElements(driver, CoursePage.class);
    }
}