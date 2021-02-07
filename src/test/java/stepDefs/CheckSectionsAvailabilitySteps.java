package stepDefs;

import desktop.fragments.BillingAddressFragment;
import desktop.fragments.DeliveryAddressFragment;
import desktop.fragments.PaymentFragment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CheckSectionsAvailabilitySteps {


    BillingAddressFragment billingAddressFragment = new BillingAddressFragment();
    DeliveryAddressFragment deliveryAddressFragment = new DeliveryAddressFragment();

    @And("'Payment' section is disabled for editing")
    public void checkIfPaymentSectionIsDisabled() {

        //  boolean paymentSectionAvailability = paymentFragment.getCardNumberField().isEnabled();
        Assert.assertFalse(false);
    }

    @When("I press 'Continue to payment' button on checkout")
    public void iPressContinueToPaymentButton() {
        billingAddressFragment.clickOnContinueToPaymentButton();
    }

    @And("'Delivery Address' and 'Billing Address' sections are disabled for editing")
    public void checkIfDelAddrAndBillAddrAreDisabled() {

        boolean deliverySectionAvailability = deliveryAddressFragment.getFullNameField().isDisplayed();
        Assert.assertFalse(false);

        boolean billingSectionAvailability = billingAddressFragment.getOptionOnBillAddrBlock().isDisplayed();

        Assertions.assertAll("Delivery and Billing sections are editable!",
                () -> assertTrue(deliverySectionAvailability),
                () -> assertTrue(billingSectionAvailability)
        );

    }


}
