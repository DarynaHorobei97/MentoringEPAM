package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static driver.SingletonDriver.getDriver;

public class BasketPage extends AbstractFragment {


    @FindBy(xpath = "//dl[@class='delivery-text']/dd")
    private WebElement deliveryCost;

    @FindBy(xpath = "//dl[@class='total']/dd")
    private WebElement total;

    @FindBy(xpath = "//div[@class='checkout-btns-wrap']//a[@class='checkout-btn btn']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='corner-content']//a[@class='close-button']")
    private WebElement alertAboutCovid;

    public EmailFragment clickOnCheckoutButton() {

        checkoutButton.click();
        return new EmailFragment();
    }

    public String getDeliveryCost() {
        return deliveryCost.getText();
    }

    public String getTotal() {
        return total.getText();
    }
}


