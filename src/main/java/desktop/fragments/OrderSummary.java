package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummary extends AbstractFragment {

    @FindBy(xpath = "//div[@class='sidebar right']//dl[4]/dd")
    private WebElement subTotalField;

    @FindBy(xpath = "//div[@class='sidebar right']//dd[@class='text-right']/strong")
    private WebElement deliveryField;

    @FindBy(xpath = "//div[@class='sidebar right']//dd[@class='text-right total-tax']")
    private WebElement vatField;

    @FindBy(xpath = "//div[@class='sidebar right']//dd[@class='text-right total-price']")
    private WebElement totalField;

    public String getSubTotalField() {
        return subTotalField.getText();
    }

    public String getDeliveryField() {
        return deliveryField.getText();
    }

    public String getVatField() {
        return vatField.getText();
    }

    public String getTotalField() {
        return totalField.getText();
    }
}
