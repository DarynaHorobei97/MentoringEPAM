package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static driver.SingletonDriver.getDriver;

public class BillingAddressFragment extends AbstractFragment {

    @FindBy(xpath = "//button[@id='hasSubmittedSameAddresses']")
    private WebElement continueToPaymentButton;

    @FindBy(xpath = " //label[@for='hide-billing-check']")
    private WebElement optionOnBillAddrBlock;


    public void clickOnContinueToPaymentButton() {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", continueToPaymentButton);
        continueToPaymentButton.click();
    }

    public WebElement getOptionOnBillAddrBlock() {
        return optionOnBillAddrBlock;
    }
}
