package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static driver.SingletonDriver.getDriver;

public class PaymentFragment extends AbstractFragment {

    @FindBy(xpath = "//iframe[@id='chase']")
    private WebElement iFramePaymentBlock;

    @FindBy(xpath = "//input[@id='visacardNumber']")
    private WebElement cardNumberField;


    private Select cardTypeDropDown = new Select(getDriver().
            findElement(By.xpath("//select[@id='brandSelected']")));

    private Select validToMonthDropDown = new Select(getDriver()
            .findElement(By.xpath("//select[@id='visacardValidToMonth']")));

    private Select validToYearDropDown = new Select(getDriver()
            .findElement(By.xpath("//select[@id='visacardValidToYear']")));

    @FindBy(xpath = "//input[@id='visacardName']")
    private WebElement nameOnCard;

    @FindBy(xpath = "//input[@id='visacardCvv']")
    private WebElement cvvCode;


    public PaymentFragment() {
        getDriver().switchTo().frame(getDriver().findElement(By.id("chase")));
    }


    public void fillCardTypeField(String cardType) {
        cardTypeDropDown.selectByVisibleText(cardType);
    }

    public void fillCardNumberField(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }


    public void fillValidToMonthDropDownField(String month) {
        validToMonthDropDown.selectByVisibleText(month);
    }

    public void fillValidToYearDropDownField(String year) {
        validToYearDropDown.selectByVisibleText(year);
    }

    public void fillCardNameField(String cardName) {
        nameOnCard.sendKeys(cardName);
    }

    public void fillCvvCodeField(String cvv) {
        cvvCode.sendKeys(cvv);
    }

    public WebElement getCardNumberField() {
        return cardNumberField;
    }


}
