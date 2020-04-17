package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;


/**
 * 1. Перейти на сайт https://geekbrains.ru/courses
 * 2. Нажать на кнопку Курсы
 * 3. Проверить что страница Курсы открылась
 * 4. Повторить для:
 * - Курсы
 * - Вебинары
 * - Форум
 * - Блог
 * - Тесты
 * - Карьера
 * <p>
 * <p>
 * /////////////////////////////////////////////////////
 * >>>Доработка Тест 1
 * <p>
 * V 1. Вынести проверку каждой страницы в отдельный тест
 * V 2. Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)
 * 3*. (Дополнительное задание, тема следующего занятия):
 * Создать классы Header и Footer, в которых создать локаторы ко всем элементам в этих блоках
 */


/**
 * /////////////////////////////////////////////////////
 * Создать ветку lessons 4_hw
 * V 1. Доработать через Parameterized тест с навигацией
 * V 2. Изменить во втором тесте проверки на hamcrest
 */

@DisplayName("Тесты навигации по сайту GeekBrains")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest extends BaseTest {

    //Курсы
    //@Test
/**    @ParameterizedTest//(name = "Тест страницы \"Курсы\"")
 @DisplayName("Тест страницы \"Курсы\"")
 @ValueSource(strings = {"Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера" })
 //@ValueSource(strings = {"Что-то там ещё", "Курсы" })
 void checkNavCoursesTest(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/career");

 WebElement buttonCourses = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/courses\"]"));
 buttonCourses.click();
 WebElement headerCourses = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerCourses.getText());

 checkHeaderTest();
 checkFooterTest();
 }

 //Вебинары
 //@Test
 //    @ParameterizedTest(name = "Тест страницы \"Вебинары\"")
 //    @DisplayName("Тест страницы \"Вебинары\"")
 //    @ValueSource(strings = {"Вебинары", "Курсы" })
 public void checkNavEvents(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/career");

 WebElement buttonEvents = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/events\"]"));
 buttonEvents.click();
 WebElement headerPageEvents = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerPageEvents.getText());

 checkHeaderTest();
 checkFooterTest();
 }

 //Форум
 //@Test
 //    @ParameterizedTest(name = "Тест страницы \"Форум\"")
 //    @DisplayName("Тест страницы \"Форум\"")
 //    @ValueSource(strings = {"Вебинары", "Курсы", "Форум" })
 void checkNavTopics(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/career");

 WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
 buttonTopics.click();
 WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerPageTopics.getText());

 checkHeaderTest();
 checkFooterTest();
 }

 //Блог
 //@Test
 //    @ParameterizedTest(name = "Тест страницы \"Блог\"")
 //    @DisplayName("Тест страницы \"Блог\"")
 //    @ValueSource(strings = {"Вебинары", "Блог", "Форум" })
 void checkNavPosts(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/career");

 WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
 buttonPosts.click();
 WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerPagePosts.getText());

 checkHeaderTest();
 checkFooterTest();
 }

 //Тесты
 //@Test
 //    @ParameterizedTest(name = "Тест страницы \"Тесты\"")
 //    @DisplayName("Тест страницы \"Тесты\"")
 //    @ValueSource(strings = { "Вебинары", "Тесты" })
 void checkNavTests(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/career");

 WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
 buttonTests.click();
 WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerPageTests.getText());

 checkHeaderTest();
 checkFooterTest();
 }

 //Карьера
 //@Test
 //    @ParameterizedTest(name = "Тест страницы \"Карьера\"")
 //    @DisplayName("Тест страницы \"Карьера\"")
 //    @ValueSource(strings = {"Вебинары", "Карьера", "Карьера" })
 void checkNavCareer(String arg) throws InterruptedException {
 driver.get("https://geekbrains.ru/tests");

 WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
 buttonCareer.click();
 WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
 Assertions.assertEquals(arg, headerPageCareer.getText());

 checkHeaderTest();
 checkFooterTest();
 }*/


    /**
     * /////////////////////////////////////////////////////
     * /////////////////////////////////////////////////////
     * /////////////////////////////////////////////////////
     * /////////////////////////////////////////////////////
     */


//    @BeforeAll
//    protected void setUp(){
//        super.setUp();
//        CoursesPage coursesPage = new CoursesPage(driver);
//        driver.get("https://geekbrains.ru/courses");
//    }
    static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    //@ParameterizedTest(name = "Тест страницы {0}")
    //@DisplayName("Тест страницы \"{0}\"")
    //@ValueSource(strings = {"Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера"})

    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        //Navigation navigation = PageFactory.initElements(driver, Navigation.class);
        Page page = PageFactory.initElements(driver, Page.class);


        PageFactory.initElements(driver, Page.class)
                .getNavigation().clickButton(namePage);
                //.checkNamePage(namePage);
        PageFactory.initElements(driver, Page.class)
                .checkNamePage(namePage);

        Header header = PageFactory.initElements(driver, Header.class);
        PageFactory.initElements(driver, Header.class)
                .checkElementsInHeader(nameOfElement);


        checkHeaderTest();
        checkFooterTest();
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


//    //Форум
//    //@Test
////    @ParameterizedTest(name = "Тест страницы \"Форум\"")
////    @DisplayName("Тест страницы \"Форум\"")
////    @ValueSource(strings = {"Вебинары", "Курсы", "Форум" })
//    void checkNavTopics(String arg) throws InterruptedException {
//        driver.get("https://geekbrains.ru/career");
//
//        WebElement buttonTopics = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/topics\"]"));
//        buttonTopics.click();
//        WebElement headerPageTopics = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
//        Assertions.assertEquals(arg, headerPageTopics.getText());
//
//        checkHeaderTest();
//        checkFooterTest();
//    }
//
//    //Блог
//    //@Test
////    @ParameterizedTest(name = "Тест страницы \"Блог\"")
////    @DisplayName("Тест страницы \"Блог\"")
////    @ValueSource(strings = {"Вебинары", "Блог", "Форум" })
//    void checkNavPosts(String arg) throws InterruptedException {
//        driver.get("https://geekbrains.ru/career");
//
//        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
//        buttonPosts.click();
//        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
//        Assertions.assertEquals(arg, headerPagePosts.getText());
//
//        checkHeaderTest();
//        checkFooterTest();
//    }
//
//    //Тесты
//    //@Test
////    @ParameterizedTest(name = "Тест страницы \"Тесты\"")
////    @DisplayName("Тест страницы \"Тесты\"")
////    @ValueSource(strings = { "Вебинары", "Тесты" })
//    void checkNavTests(String arg) throws InterruptedException {
//        driver.get("https://geekbrains.ru/career");
//
//        WebElement buttonTests = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/tests\"]"));
//        buttonTests.click();
//        WebElement headerPageTests = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
//        Assertions.assertEquals(arg, headerPageTests.getText());
//
//        checkHeaderTest();
//        checkFooterTest();
//    }
//
//    //Карьера
//    //@Test
////    @ParameterizedTest(name = "Тест страницы \"Карьера\"")
////    @DisplayName("Тест страницы \"Карьера\"")
////    @ValueSource(strings = {"Вебинары", "Карьера", "Карьера" })
//    void checkNavCareer(String arg) throws InterruptedException {
//        driver.get("https://geekbrains.ru/tests");
//
//        WebElement buttonCareer = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/career\"]"));
//        buttonCareer.click();
//        WebElement headerPageCareer = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
//        Assertions.assertEquals(arg, headerPageCareer.getText());
//
//        checkHeaderTest();
//        checkFooterTest();
//    }
//


}