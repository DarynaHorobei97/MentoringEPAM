package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.SingletonDriver.getDriver;

public class SearchFiltersFragment extends AbstractFragment {


    @FindBy(xpath = "//button[contains(text(),'Refine results')]")
    private WebElement refineResultsButton;

    @FindBy(xpath = "//div[@class='corner-content']//a[@class='close-button']")
    private WebElement alertAboutCovid;


    public SearchResultsFragment setFilters(String userFilerPrice, String userFilterAvailability,
                                            String userFilterLang, String userFilterFormat) {
        Select filerPrice = new Select(getDriver().findElement(By.xpath("//select[@id='filterPrice']")));
        Select filterAvailability = new Select(getDriver().findElement(By.xpath("//select[@id='filterAvailability']")));
        Select filterLang = new Select(getDriver().findElement(By.xpath("//select[@id='filterLang']")));
        Select filterFormat = new Select(getDriver().findElement(By.xpath("//select[@id='filterFormat']")));

        filerPrice.selectByVisibleText(userFilerPrice);
        filterAvailability.selectByVisibleText(userFilterAvailability);
        filterLang.selectByVisibleText(userFilterLang);
        filterFormat.selectByVisibleText(userFilterFormat);


        Actions actions = new Actions(getDriver());
        actions.moveToElement(alertAboutCovid);
        actions.click();
        actions.build().perform();


        refineResultsButton.click();
        return new SearchResultsFragment();

    }

}
