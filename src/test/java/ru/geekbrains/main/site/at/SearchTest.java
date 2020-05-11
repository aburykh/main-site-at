package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.block.SearchTabsBlock;
import ru.geekbrains.main.site.at.page.content.TestPage;

import static org.hamcrest.Matchers.*;


@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка Поиска")
@Feature(value = "Проверка страниц")
@Story(value = "Проверка Поиска")
public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Тест поиска на портале GeekBrains по ключевому слову \"java\" ")
    @Description(value = "Тест-кейс позволяет проверить работу поиска по ключевому слову, а также загрузку блоков страницы и элементов по, загружающихся по результатам поиска")
    void checkSearchTest() {

        driver.get("https://geekbrains.ru/career");
//        WebDriverWait wait = new WebDriverWait(driver, 40);

//        new SearchTabsBlock(driver)
//                .clickSearch()
//                .inputSearch()
//                .checkProfession()
//                .checkCourses()
//                .checkWebinars()
//                .checkBlogs()
//                .checkForum()
//                .checkTests()
//                .checkProjectsAndCompanies();
        new TestPage(driver)
                //Page page = new Page(driver)
                .openUrl()
                .getHeader()
                //.clickSearch()
                .inputSearch("java")
                .getSearchTabsBlock()

//                .openUrl()
//                .getHeader()
//                .searchText("java")
//                .getSearchTabsBlock()


                .checkCount(SearchTabsBlock
                        .Tab
                        .Professions,
                        greaterThanOrEqualTo(2))
                .checkCount(SearchTabsBlock.Tab.Courses, greaterThan(15))
                .checkCount(SearchTabsBlock.Tab.Webinars, allOf(greaterThan(180), lessThan(300)))
                .checkCount(SearchTabsBlock.Tab.Blogs, greaterThan(300))
                .checkCount(SearchTabsBlock.Tab.Forums, not(350))
                .checkCount(SearchTabsBlock.Tab.Tests, not(0))
                .logoGB.click();
    }

}