package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.page.content.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;


public class Header extends BasePageObject {

    //private Navigation navigation;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    public WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;


    @FindBy(css = "[class*=\"gb-top-menu__item\"] [class=\"svg-icon icon-search \"]")
    private WebElement searchIcon;

    @FindBy(css = "[class*=\"gb-top-menu__item\"] [href=\"/login\"]")
    private WebElement checkLoginInHeader;

    @FindBy(css = "[class*=\"gb-top-menu__item\"] [href=\"/register\"]")
    private WebElement checkRegisterInHeader;


    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Step("Проверка отображения элементов в Header'е")
    public void checkElementsInHeader() throws RuntimeException {
        //getSearchIcon().isDisplayed();
        wait10second.until(ExpectedConditions.visibilityOf(searchIcon));

        String loginInHeaderText = checkLoginInHeader.getText();
        assertThat(loginInHeaderText, equalToCompressingWhiteSpace("Вход"));

        String registerInHeaderText = checkRegisterInHeader.getText();
        assertThat(registerInHeaderText, equalToCompressingWhiteSpace("Регистрация"));
    }

//    @Step("Нажать кнопку поиска в секции header")
//    public SearchPage clickSearch() {
//        searchIcon.click();
//        return BasePage.getSearch();
//    }


//    @Step("Проверка нажатия на иконку поиска")
//    public Header clickSearch() {
//        //new WebDriverWait(this.driver, 30)
//        wait30second.until(ExpectedConditions.elementToBeClickable(buttonSearch));
//        buttonSearch.click();
//
////        return PageFactory.initElements(this.driver, SearchTabsBlock.class);
//        return new Header(driver);
//    }

    @Step("Ввод в строку поиска ключевого слова \"java\"")
    public SearchPage inputSearch(String text) {
        //WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        wait30second.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.click();
        inputSearch.sendKeys(text);
//        return PageFactory.initElements(this.driver, SearchTabsBlock.class);
        return new SearchPage(driver);
    }


    public WebElement getSearchIcon() {
        return searchIcon;
    }

}
