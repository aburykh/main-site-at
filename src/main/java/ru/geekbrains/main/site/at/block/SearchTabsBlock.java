package ru.geekbrains.main.site.at.block;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTabsBlock extends BasePageObject {


    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    public WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;


    // ПАНЕЛЬ НАВИГАЦИИ СВЕРХУ

    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement tabEveryWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProfessions;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement tabCourses;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement tabWebinars;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement tabBlogs;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement tabForums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement tabTests;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement tabCompanies;


    // БЛОКИ

    @FindBy(xpath = "//header/h2[text()='Профессии']")
    private WebElement textProfession;

    @FindBy(xpath = "//header/h2[text()='Курсы']")
    private WebElement textCourses;

    @FindBy(xpath = "//header/h2[text()='Вебинары']")
    private WebElement textWebinars;

    @FindBy(xpath = "//header/h2[text()='Блоги']")
    private WebElement textBlogs;

    @FindBy(xpath = "//header/h2[text()='Форум']")
    private WebElement textForum;

    @FindBy(xpath = "//header/h2[text()='Тесты']")
    private WebElement textTests;

    @FindBy(xpath = "//header/h2[text()='Проекты и компании']")
    private WebElement textProjectsAndCompanies;


    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    private WebElement countProfession;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    private WebElement countCourses;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    private WebElement countWebinars;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    private WebElement countBlogs;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    private WebElement countForums;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    private WebElement countTests;

    @FindBy(css = "[class=\"company-item__pic\"] [src*=\"63268ac.png\"]")
    public WebElement logoGB;

    @FindBy(css = "h3 [href=\"/career/682\"]")
    private WebElement textGB;

    public SearchTabsBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButton(Tab tab) {
        getButton(tab).click();
    }

    public SearchTabsBlock checkCount(Tab tab, Matcher<Integer> matcher) {
        //wait30second.until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
        String actualCount = getButton(tab).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    private WebElement getButton(Tab tab) {
        switch (tab) {
            case Everywhere:
                return tabEveryWhere;
            case Professions:
                return tabProfessions;
            case Courses:
                return tabCourses;
            case Webinars:
                return tabWebinars;
            case Blogs:
                return tabBlogs;
            case Forums:
                return tabForums;
            case Tests:
                return tabTests;
            case Companies:
                return tabCompanies;
            default:
                throw new IllegalStateException("Unexpected value: " + tab);
        }
    }


//    @Step("Проверка нажатия на иконку поиска")
//    public SearchTabsBlock clickSearch() {
//                //new WebDriverWait(this.driver, 30)
//        wait30second.until(ExpectedConditions.elementToBeClickable(buttonSearch));
//        buttonSearch.click();
//
////        return PageFactory.initElements(this.driver, SearchTabsBlock.class);
//        return this;
//    }
//
//    @Step("Ввод в строку поиска ключевого слова \"java\"")
//    public SearchTabsBlock inputSearch() {
//        //WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
//        inputSearch.sendKeys("java");
////        return PageFactory.initElements(this.driver, SearchTabsBlock.class);
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Профессии\" и проверка количественного показателя (>= 2)")
//    public SearchTabsBlock checkProfession() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
//        String textBlock = textProfession.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Профессии"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("профессии"), containsString("Про")));
//
//        String countInBlock = countProfession.getText();
//        int countOfProfessions = Integer.parseInt(countInBlock.trim());
//        System.out.println("countOfProfessions = " + countOfProfessions);
//        assertThat(countOfProfessions, greaterThanOrEqualTo(2));
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Курсы\" и проверка количественного показателя (> 15)")
//    public SearchTabsBlock checkCourses() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textCourses, "Курсы"));
//        String textBlock = textCourses.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Курсы"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("курсы"), containsString("ур")));
//
//        String coursesActual = countCourses.getText();
//        int countOfCourses = Integer.parseInt(coursesActual.trim());
//        System.out.println("countOfCourses = " + countOfCourses);
//        assertThat(countOfCourses, greaterThan(15));
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Вебинары\" и проверка количественного показателя (> 180 && < 300)")
//    public SearchTabsBlock checkWebinars() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textWebinars, "Вебинары"));
//        String textBlock = textWebinars.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Вебинары"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("вебинары"), containsString("бинар"), endsWith("ры")));
//
//        String webinarsActual = countWebinars.getText();
//        int countOfWebinars = Integer.parseInt(webinarsActual.trim());
//        System.out.println("countOfWebinars = " + countOfWebinars);
//        assertThat(countOfWebinars, allOf(greaterThan(180), lessThan(300)));
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Блоги\" и проверка количественного показателя (> 300)")
//    public SearchTabsBlock checkBlogs() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textBlogs, "Блоги"));
//        String textBlock = textBlogs.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Блоги"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("блоги"), containsString("лог")));
//
//        String blogsActual = countBlogs.getText();
//        int countOfBlogs = Integer.parseInt(blogsActual.trim());
//        System.out.println("countOfBlogs = " + countOfBlogs);
//        assertThat(countOfBlogs, greaterThan(300));
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Форум\" и проверка количественного показателя (!= 350)")
//    public SearchTabsBlock checkForum() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textForum, "Форум"));
//        String textBlock = textForum.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Форум"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("форум"), containsString("ору")));
//
//        String forumsActual = countForums.getText();
//        int countOfForums = Integer.parseInt(forumsActual.trim());
//        System.out.println("countOfForums = " + countOfForums);
//        assertThat(countOfForums, not(350));
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Тесты\" и проверка количественного показателя (!= 0)")
//    public SearchTabsBlock checkTests() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textTests, "Тесты"));
//        String textBlock = textTests.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Тесты"));
//        assertThat(textBlock, allOf(equalToIgnoringCase("тесты"), containsStringIgnoringCase("тест")));
//
//        String testsActual = countTests.getText();
//        int countOfTests = Integer.parseInt(testsActual.trim());
//        System.out.println("countOfTests = " + countOfTests);
//        assertThat(countOfTests, not(0));
//
//        return this;
//    }
//
//    @Step("Проверка отображения блока \"Проекты и компании\", а также проверка загрузки логотипа и текста карточки \"GeekBrains\" с последующим кликом на данную карточку")
//    public void checkProjectsAndCompanies() {
//        //new WebDriverWait(driver, 30)
//        wait30second.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies, "Проекты и компании"));
//        String textBlock = textProjectsAndCompanies.getText();
//        assertThat(textBlock, equalToCompressingWhiteSpace("Проекты и компании"));
//
//        logoGB.isDisplayed();
//
//        Assertions.assertEquals("Образовательный портал GeekBrains", textGB.getText());
//        String textGBActual = textGB.getText();
//        assertThat(textGBActual, allOf(
//                equalToIgnoringCase("образовательный портал geekbrains"),
//                containsStringIgnoringCase("geekbrains"),
//                endsWith("GeekBrains"),
//                equalToCompressingWhiteSpace("Образовательный портал GeekBrains")
//        ));
//
//        logoGB.click();
//    }


    public enum Tab {
        Everywhere("Везде"),
        Professions("Профессии"),
        Courses("Курсы"),
        Webinars("Вебинары"),
        Blogs("Блоги"),
        Forums("Форумы"),
        Tests("Тесты"),
        Companies("Компании");

        private String text;

        Tab(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

}