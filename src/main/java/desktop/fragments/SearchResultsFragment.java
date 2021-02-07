package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static driver.SingletonDriver.getDriver;

public class SearchResultsFragment extends AbstractFragment {
    private By filterYourSearchField = By.xpath("//h2[contains(text(),'Filter your search')]");

    @FindBy(xpath = "//div[@class='item-info']/h3/a")
    private List<WebElement> locatorsOfBooksFromSearchResult;

    @FindBy(xpath = "//a[@data-isbn='9780131872486']")
    private WebElement addToBasketButton;


    public List<String> returnNamesOfBooksFromSearchResult() {
        List<String> namesOfBooksFromSearchResult = new ArrayList<>();
        for (int i = 0; i < locatorsOfBooksFromSearchResult.size(); i++) {
            namesOfBooksFromSearchResult.add(locatorsOfBooksFromSearchResult.get(i).getText());
        }
        return namesOfBooksFromSearchResult;
    }

    public BasketPopUpFragment addBookToTheBasket(String nameOfBook) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(addToBasketButton);
        actions.click();
        actions.build().perform();
        return new BasketPopUpFragment();
    }


}



