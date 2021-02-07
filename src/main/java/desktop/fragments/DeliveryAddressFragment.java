package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static driver.SingletonDriver.getDriver;

public class DeliveryAddressFragment extends AbstractFragment {

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//button[@id='manualEntryDeliveryAddress']")
    private WebElement enterAddressManuallyButton;

    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private WebElement addressLine1Field;

    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private WebElement addressLine2Field;

    @FindBy(xpath = "//input[@name='delivery-city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@name='delivery-county']")
    private WebElement countryField;

    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private WebElement postcodeField;

    private Select countryDropDown = new Select(getDriver()
            .findElement(By.xpath("//select[@id='deliveryCountryDropdown']")));


    public void setValueForFullNameField(String fullName) {
        fullNameField.sendKeys(fullName);
        enterAddressManuallyButton.click();
    }

    public void setValueForAddressLine1(String addLine1) {
        addressLine1Field.sendKeys(addLine1);
    }

    public void setValueForAddressLine2(String addLine2) {
        addressLine2Field.sendKeys(addLine2);
    }

    public void setValueForCityField(String addLine2) {
        cityField.sendKeys(addLine2);
    }

    public void setValueForCountryField(String country) {
        countryField.sendKeys(country);
    }

    public void setValueForPostCodeField(String postcode) {
        postcodeField.sendKeys(postcode);
    }

    public void setCountryValueFromDropDown(String valueFromCountryDropDown) {
        countryDropDown.selectByVisibleText(valueFromCountryDropDown);
    }

    public WebElement getFullNameField() {
        return fullNameField;
    }
}
