package ru.geekbrains.main.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer extends Page {

    public Footer(WebDriver driver) {
        super(driver);
    }


    public void checkFooterTest() throws InterruptedException {

        driver.findElement(By.cssSelector("[class=\"site-footer__icon\"] [class*=\"facebook\"]"));
        driver.findElement(By.cssSelector("[class=\"site-footer__icon\"] [class*=\"vk\"]"));
        driver.findElement(By.cssSelector("[class=\"site-footer__icon\"] [class*=\"instagram\"]"));
        driver.findElement(By.cssSelector("[class=\"site-footer__icon\"] [class*=\"youtube\"]"));
        driver.findElement(By.cssSelector("[class=\"site-footer__icon\"] [class*=\"telegram\"]"));

        WebElement checkFeedbacksInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_first-row\"] [href=\"/feedbacks\"]"));
        assertEquals("Отзывы", checkFeedbacksInFooter.getText());

        WebElement checkHelpInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_first-row\"] [href=\"https://geekbrains.zendesk.com/hc/ru\"]"));
        assertEquals("Помощь", checkHelpInFooter.getText());

        WebElement checkCompanyInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_first-row\"] [href=\"/company\"]"));
        assertEquals("О проекте", checkCompanyInFooter.getText());

        WebElement checkLicenseInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_second-row\"] [href*=\"/license\"]"));
        assertEquals("Лицензия", checkLicenseInFooter.getText());

        WebElement checkCareerInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_second-row\"] [href*=\"/career\"]"));
        assertEquals("Вакансии", checkCareerInFooter.getText());

        WebElement checkForBusinessInFooter = driver.findElement(By.cssSelector("[class*=\"footer__links_second-row\"] [href*=\"/forbusiness\"]"));
        assertEquals("Компаниям", checkForBusinessInFooter.getText());

    }

}
