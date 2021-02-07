package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.SingletonDriver.getDriver;

public class BillingAddressFragment extends AbstractFragment {

    @FindBy(xpath = "//button[@id='hasSubmittedSameAddresses']")
    private WebElement continueToPaymentButton;


    @FindBy(xpath = " //label[@for='hide-billing-check']")
    private WebElement optionOnBillAddrBlock;


    private By optionOnBillAddrBlock1 = By.xpath("//label[@for='hide-billing-check']");

    public void clickOnContinueToPaymentButton() {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", continueToPaymentButton);
        continueToPaymentButton.click();
    }

    public boolean isEnabledBillingInformation() {
        boolean result;
        try {
            getDriver().findElement(optionOnBillAddrBlock1).isEnabled();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }
}
