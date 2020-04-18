package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;


@DisplayName("Тесты навигации по сайту GeekBrains")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class NavigationTest extends BaseTest {


    static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        //Navigation navigation = PageFactory.initElements(driver, Navigation.class);
        Page page = PageFactory.initElements(driver, Page.class);


        PageFactory.initElements(driver, HomePage.class)
                .getNavigation().clickButton(namePage)
                .checkNamePage(namePage);

        //Header header = PageFactory.initElements(driver, Header.class);
        PageFactory.initElements(driver, Header.class)
                .checkElementsInHeader();

        //Footer footer = PageFactory.initElements(driver, Footer.class);
        PageFactory.initElements(driver, Footer.class)
                .checkElementsInFooter();

    }

    /**
     void checkNavCoursesTest(String arg) throws InterruptedException {
     //driver.get("https://geekbrains.ru/career");

     //getButton(blockName).click();
     //CoursesPage.buttonClick(BaseTest.getButton);

     WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
     buttonCourses.click();

     WebElement headerCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
     Assertions.assertEquals(arg, headerCourses.getText());

     checkHeaderTest();
     checkFooterTest();

     WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
     buttonEvents.click();
     WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
     Assertions.assertEquals(arg, headerPageEvents.getText());

     checkHeaderTest();
     checkFooterTest();
     }
     */


}