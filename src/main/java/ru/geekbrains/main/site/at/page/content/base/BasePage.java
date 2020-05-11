package ru.geekbrains.main.site.at.page.content.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.block.Header;
import ru.geekbrains.main.site.at.block.Navigation;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.page.OpenUrl;
import ru.geekbrains.main.site.at.page.content.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public abstract class BasePage extends BasePageObject implements OpenUrl {

    private static SearchPage searchPage;
    protected Header header;
    protected Navigation navigation;

    //protected WebDriver driver;

    //private SearchPage searchPage;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerTitlePage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;


    public BasePage(WebDriver driver) {
        super(driver);
        this.header = new Header(driver);
        this.navigation = new Navigation(driver);
//        navigation = PageFactory.initElements(driver, Navigation.class);
//        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @Step("Закрытие Pop-UP окна")
    public BasePage closedPopUp() {
        buttonPopUpClosed.click();
        return this;
    }

    @Step("Проверка загрузки заголовка страницы {exampleNamePage}")
    public BasePage checkNamePage(String exampleNamePage) {
        //new WebDriverWait(driver, 30)
        wait30second.until(ExpectedConditions.textToBePresentInElement(headerTitlePage, exampleNamePage));

        String headerPageText = headerTitlePage.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Header getHeader() {
        return header;
    }

    public static SearchPage getSearch() {
        return searchPage;
    }

}