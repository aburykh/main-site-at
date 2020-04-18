package ru.geekbrains.main.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.block.CourseHeader;

public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
        this.courseHeader = PageFactory.initElements(driver, CourseHeader.class);
    }

    private CourseHeader courseHeader;

    public CoursePage configFilter(String... args) {
        for (String test : args) {
            //TODO после прохождения коллекций -переделать на коллекции
            driver.findElement(By.xpath("//form/ul//label[text()='" + test + "']"))
                    .click();
        }
        return this;
    }

    public CoursePage checkingDisplayedCourses(String... args) {
        for (String test : args) {
            //TODO после прохождения коллекций -переделать на коллекции
            driver.findElement(By.xpath("//a/div/div/span[text()='" + test + "']"));
        }
        return this;
    }

    public CourseHeader getCourseHeader() {
        return courseHeader;
    }
}