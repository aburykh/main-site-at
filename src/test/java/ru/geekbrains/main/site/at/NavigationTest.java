package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.block.Footer;
import ru.geekbrains.main.site.at.block.Header;
import ru.geekbrains.main.site.at.block.Navigation;
import ru.geekbrains.main.site.at.page.content.HomePage;

import java.util.stream.Stream;


@DisplayName("Тесты навигации по сайту GeekBrains")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(value = ExecutionMode.SAME_THREAD)
@Feature(value = "Проверка страниц")
@Story(value = "Проверка навигации")

public class NavigationTest extends BaseTest {


    static Stream<Navigation.Button> stringProvider() {
        //return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
        return Stream.of(
                Navigation.Button.buttonCourses,
                Navigation.Button.buttonEvents,
                Navigation.Button.buttonTopics,
                Navigation.Button.buttonPosts,
                Navigation.Button.buttonTests,
                Navigation.Button.buttonCareer
        );
    }

    @DisplayName("Нажатие в навигации")
    @Description(value = "Тест-кейс позволяет проверить переход по страницам, используя панель навигации на портале, с последующей проверкой загрузки элементов в header и footer на каждой странице")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkNavigation(Navigation.Button button) throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        new HomePage(driver)
                .getNavigation().clickButton(button)
                .checkNamePage(button.getName());

        new Header(driver)
                .checkElementsInHeader();

        new Footer(driver)
                .checkElementsInFooter();
    }

}