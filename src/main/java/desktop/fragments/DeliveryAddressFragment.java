package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static driver.SingletonDriver.getDriver;

public class DeliveryAddressFragment extends AbstractFragment {

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private WebElement fullNameField1;

    private By fullNameField = By.xpath("//input[@name='delivery-fullName']");

    @FindBy(xpath = "//button[@id='manualEntryDeliveryAddress']")
    private WebElement enterAddressManuallyButton;


//    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
//    private WebElement addressLine1Field;

    private By addressLine1Field = By.xpath("//input[@name='delivery-addressLine1']");

    //    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
//    private WebElement addressLine2Field;
    private By addressLine2Field = By.xpath("//input[@name='delivery-addressLine2']");

    //
//    @FindBy(xpath = "//input[@name='delivery-city']")
//    private WebElement cityField;
    private By cityField = By.xpath("//input[@name='delivery-city']");

    //    @FindBy(xpath = "//input[@name='delivery-county']")
//    private WebElement countryField;
    private By countryField = By.xpath("//input[@name='delivery-county']");

//
//    @FindBy(xpath = "//input[@name='delivery-postCode']")
//    private WebElement postcodeField;

    private By postcodeField = By.xpath("//input[@name='delivery-postCode']");

//    private Select countryDropDown = new Select(getDriver()
//            .findElement(By.xpath("//select[@id='deliveryCountryDropdown']")));

    private By countryDropDown = By.xpath("//select[@id='deliveryCountryDropdown']");

    public void setValueForFullNameField(String fullName) {

        fullNameField1.sendKeys(fullName);
        enterAddressManuallyButton.click();
    }

    public void setValueForAddressLine1(String addLine1) {
        inputTextIntoField(addressLine1Field,addLine1);
    }

    public void setValueForAddressLine2(String addLine2) {
        inputTextIntoField(addressLine2Field,addLine2);
    }

    public void setValueForCityField(String city) {
        inputTextIntoField(cityField,city);
    }

    public void setValueForCountryField(String country) {
        inputTextIntoField(countryField,country);
    }

    public void setValueForPostCodeField(String postcode) {
       inputTextIntoField(postcodeField,postcode);
    }

    public void setCountryValueFromDropDown(String valueFromCountryDropDown) {
       selectElementByVisibleText(countryDropDown,valueFromCountryDropDown);
    }


    public boolean isEnabledFullNameField() {
        boolean result;
        try {
            getDriver().findElement(fullNameField).isEnabled();
            result = true;
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }

}
