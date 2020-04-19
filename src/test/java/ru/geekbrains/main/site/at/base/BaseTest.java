package ru.geekbrains.main.site.at.base;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://geekbrains.ru/career");
    }

    public void checkHeaderTest() {

        driver.findElement(By.cssSelector("[class=\"gb-top-menu__item\"] [class=\"svg-icon icon-search \"]"));

        WebElement checkLoginInHeader = driver.findElement(By.cssSelector("[class=\"gb-top-menu__item\"] [href=\"/login\"]"));
        assertEquals(" Вход", checkLoginInHeader.getText());

        WebElement checkRegisterInHeader = driver.findElement(By.cssSelector("[class*=\"gb-top-menu__item\"] [href=\"/register\"]"));
        assertEquals(" Регистрация", checkRegisterInHeader.getText());

    }

    public void checkFooterTest() {

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

    protected String getTextFromElement(@NotNull WebElement element) {
        //wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    @AfterEach
    void tearDown() {
        checkHeaderTest();
        checkFooterTest();
        driver.quit();
    }
}