package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPopUpFragment extends AbstractFragment {

//    @FindBy(xpath = "//a[@data-localizer-string-id='bd_js_basket_checkout']")
//    private WebElement basketAndCheckoutButton;

    private By basketAndCheckoutButton = By.xpath("//a[@data-localizer-string-id='bd_js_basket_checkout']");

    public void clickOnBasketCheckoutButton() {
        clickOnButton(basketAndCheckoutButton);
    }

    public BasketPage goToBasketPage() {
        return new BasketPage();
    }

}
