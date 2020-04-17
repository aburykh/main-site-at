package ru.geekbrains.main.site.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Header {

    private Navigation navigation;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;


    @FindBy(css = "[class=\"gb-top-menu__item\"] [class=\"svg-icon icon-search \"]")
    private WebElement searchIcon;

    @FindBy(css = "[class=\"gb-top-menu__item\"]")
    private WebElement checkFieldInHeader;


//    @FindBy(css = "[class=\"gb-top-menu__item\"] [href=\"/login\"]")
//    private WebElement checkLoginInHeader;
//
//    @FindBy(css = "[class=\"gb-top-menu__item\"] [href=\"/register\"]")
//    private WebElement checkRegisterInHeader;

    public WebElement getHeaderPage() {
        return headerPage;
    }

    public WebElement getButtonPopUpClosed() {
        return buttonPopUpClosed;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getCheckFieldInHeader() {
        return checkFieldInHeader;
    }

//    public WebElement getCheckLoginInHeader() {
//        return checkLoginInHeader;
//    }
//
//    public WebElement getCheckRegisterInHeader() {
//        return checkRegisterInHeader;
//    }


    public Header checkElementsInHeader(String nameOfElement) {
        String fieldInHeaderText = checkFieldInHeader.getText();
        assertThat(fieldInHeaderText, equalToCompressingWhiteSpace(nameOfElement));
        return this;
    }



    public Header(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);


        public void checkHeaderTest () throws InterruptedException {


            WebElement checkLoginInHeader = driver.findElement(By.cssSelector("[class=\"gb-top-menu__item\"] [href=\"/login\"]"));
            WebElement checkRegisterInHeader = driver.findElement(By.cssSelector("[class=\"gb-top-menu__item\"] [href=\"/register\"]"));
        }

    }
}
