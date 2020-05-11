package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Footer extends BasePageObject {

    //private Navigation navigation;


    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"facebook\"]")
    private WebElement checkFacebookInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"vk\"]")
    private WebElement checkVkInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"instagram\"]")
    private WebElement checkInstagramInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"youtube\"]")
    private WebElement checkYoutubeInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"telegram\"]")
    private WebElement checkTelegramInFooter;


    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"/feedbacks\"]")
    private WebElement checkFeedbacksInFooter;

    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"https://geekbrains.zendesk.com/hc/ru\"]")
    private WebElement checkHelpInFooter;

    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"/company\"]")
    private WebElement checkCompanyInFooter;


    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/license\"]")
    private WebElement checkLicenseInFooter;

    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/career\"]")
    private WebElement checkCareerInFooter;

    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/forbusiness\"]")
    private WebElement checkForBusinessInFooter;


    public Footer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * //   c. В методе checkElementsInFooter –
     * //    i. через гетеры в таком случае не надо обращаться к переменным. Они ведь в этом же классе.
     * //    ii. .isDisplayed(); - этот метод он просто возвращает тру или фолс (есть элемент на странице или нет). Использовав его на элементах ты не делаешь проверку.
     * <p>
     * public boolean checkElementsIsDisplayed(boolean isDisplayed) {
     * isDisplayed = true;
     * if (checkFacebookInFooter.isDisplayed()
     * && checkVkInFooter.isDisplayed() //return true;
     * && checkVkInFooter.isDisplayed() //return true;
     * && checkInstagramInFooter.isDisplayed() //return true;
     * && checkYoutubeInFooter.isDisplayed() //return true;
     * && checkTelegramInFooter.isDisplayed()) { //return true;
     * return true;
     * } else {
     * return false;
     * }
     * }
     */


    @Step("Проверка отображения элементов в Footer'е")
    public void checkElementsInFooter() throws RuntimeException {

        checkFacebookInFooter.isDisplayed();
        checkVkInFooter.isDisplayed();
        checkInstagramInFooter.isDisplayed();
        checkYoutubeInFooter.isDisplayed();
        checkTelegramInFooter.isDisplayed();


        String feedbacksInFooterText = checkFeedbacksInFooter.getText();
        assertThat(feedbacksInFooterText, equalToCompressingWhiteSpace("Отзывы"));

        String helpInFooterText = checkHelpInFooter.getText();
        assertThat(helpInFooterText, equalToCompressingWhiteSpace("Помощь"));

        String companyInFooterText = checkCompanyInFooter.getText();
        assertThat(companyInFooterText, equalToCompressingWhiteSpace("О проекте"));

        String licenseInFooterText = checkLicenseInFooter.getText();
        assertThat(licenseInFooterText, equalToCompressingWhiteSpace("Лицензия"));

        String careerInFooterText = checkCareerInFooter.getText();
        assertThat(careerInFooterText, equalToCompressingWhiteSpace("Вакансии"));

        String forBusinessInFooterText = checkForBusinessInFooter.getText();
        assertThat(forBusinessInFooterText, equalToCompressingWhiteSpace("Компаниям"));

    }

//    public WebElement getCheckFacebookInFooter() {
//        return checkFacebookInFooter;
//    }
//
//    public WebElement getCheckVkInFooter() {
//        return checkVkInFooter;
//    }
//
//    public WebElement getCheckInstagramInFooter() {
//        return checkInstagramInFooter;
//    }
//
//    public WebElement getCheckYoutubeInFooter() {
//        return checkYoutubeInFooter;
//    }
//
//    public WebElement getCheckTelegramInFooter() {
//        return checkTelegramInFooter;
//    }

}