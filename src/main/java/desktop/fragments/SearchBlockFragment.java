package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.SingletonDriver.getDriver;

public class SearchBlockFragment extends AbstractFragment {

//    @FindBy(xpath = "//input[@class='text-input']")
//    private WebElement searchField;

    private By searchField = By.xpath("//input[@class='text-input']");

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;


    public SearchBlockFragment bookNameInput(String bookName) {
        inputTextIntoField(searchField, bookName);
        return this;
    }

    public SearchResultsFragment searchForABook() {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", searchButton);
        searchButton.click();

        return new SearchResultsFragment();
    }


}
