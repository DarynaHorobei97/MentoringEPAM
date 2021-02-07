package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFragment extends AbstractFragment {

//    @FindBy(xpath = "//input[@name='emailAddress']")
//    private WebElement emailField;

    private By emailField = By.xpath("//input[@name='emailAddress']");

    public DeliveryAddressFragment checkoutWithEmail(String email) {
        inputTextIntoField(emailField,email);
        return new DeliveryAddressFragment();
    }

}
