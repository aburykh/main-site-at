package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.block.SearchTabsBlock;
import ru.geekbrains.main.site.at.page.content.base.BasePage;

public class SearchPage extends BasePage {

    private SearchTabsBlock searchTabsBlock;

    public SearchPage(WebDriver driver) {
        super(driver);
        //this.searchTabsBlock = new SearchTabsBlock(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public SearchPage openUrl() {
        driver.get("https://geekbrains.ru/search");
        return this;
    }

    public SearchTabsBlock getSearchTabsBlock() {
        return searchTabsBlock;
    }

}