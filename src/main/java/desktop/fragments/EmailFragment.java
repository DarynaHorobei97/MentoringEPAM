package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFragment extends AbstractFragment {

    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailField;

    public DeliveryAddressFragment checkoutWithEmail(String email) {
        emailField.sendKeys(email);
        return new DeliveryAddressFragment();
    }

}
