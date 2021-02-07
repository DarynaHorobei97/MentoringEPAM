package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static driver.SingletonDriver.getDriver;

public class PaymentFragment extends AbstractFragment {

    @FindBy(xpath = "//iframe[@id='chase']")
    private WebElement iFramePaymentBlock;

//    @FindBy(xpath = "//input[@id='visacardNumber']")
//    private WebElement cardNumberField;

    private By cardNumberFieldLocator = By.xpath("//input[@id='visacardNumber']");


    //    private Select cardTypeDropDown = new Select(getDriver().
//            findElement(By.xpath("//select[@id='brandSelected']")));
    private By cardTypeDropDownLocator = By.xpath("//select[@id='brandSelected']");


//    private Select validToMonthDropDown = new Select(getDriver()
//            .findElement(By.xpath("//select[@id='visacardValidToMonth']")));

    private By validToMonthDropDownLocator = By.xpath("//select[@id='visacardValidToMonth']");


//    private Select validToYearDropDown = new Select(getDriver()
//            .findElement(By.xpath("//select[@id='visacardValidToYear']")));

    private By validToYearDropDownLocator = By.xpath("//select[@id='visacardValidToYear']");

//    @FindBy(xpath = "//input[@id='visacardCvv']")
//    private WebElement cvvCode;

    private By cardCvvFieldLocator = By.xpath("//input[@id='visacardCvv']");

    private By cardNameFieldLocator = By.xpath("//input[@id='visacardName']");

    public PaymentFragment() {
        // getDriver().switchTo().frame(getDriver().findElement(By.id("chase")));
    }


    public void fillCardTypeField(String cardType) {
        switchToIFrame();
        selectElementByVisibleText(cardTypeDropDownLocator, cardType);
//        cardTypeDropDown.selectByVisibleText(cardType);
        switchToDefault();

    }

    private void switchToIFrame() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("chase")));
    }

    private void switchToDefault() {
        getDriver().switchTo().defaultContent();
    }

    public void fillCardNumberField(String cardNumber) {

        switchToIFrame();
        inputTextIntoField(cardNumberFieldLocator, cardNumber);
        switchToDefault();
    }

    public void fillCardNameField(String cardName) {

        switchToIFrame();
        inputTextIntoField(cardNameFieldLocator, cardName);
        switchToDefault();
    }


    public void fillValidToMonthDropDownField(String month) {
        switchToIFrame();
        selectElementByVisibleText(validToMonthDropDownLocator, month);
        switchToDefault();
    }

    public void fillValidToYearDropDownField(String year) {
        switchToIFrame();
        selectElementByVisibleText(validToYearDropDownLocator, year);
        switchToDefault();
    }


    public void fillCvvCodeField(String cvv) {
        switchToIFrame();
        inputTextIntoField(cardCvvFieldLocator, cvv);
        switchToDefault();
        getDriver().quit();
    }

    public boolean isEnabledCardNumberField() {
        boolean result;
        try {
            getDriver().findElement(cardNumberFieldLocator).isEnabled();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }
}