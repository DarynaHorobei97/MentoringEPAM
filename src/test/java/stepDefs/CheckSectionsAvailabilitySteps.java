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

    PaymentFragment paymentFragment = new PaymentFragment();
    @And("'Payment' section is disabled for editing")
    public void checkIfPaymentSectionIsDisabled() {

        Assert.assertFalse(paymentFragment.isEnabledCardNumberField());
    }

    @When("I press 'Continue to payment' button on checkout")
    public void iPressContinueToPaymentButton() {
        billingAddressFragment.clickOnContinueToPaymentButton();
    }

    @And("'Delivery Address' and 'Billing Address' sections are disabled for editing")
    public void checkIfDelAddrAndBillAddrAreDisabled() {

        boolean deliverySectionAvailability = deliveryAddressFragment.isEnabledFullNameField();
        boolean billingSectionAvailability = billingAddressFragment.isEnabledBillingInformation();

        Assertions.assertAll("Delivery and Billing sections are editable!",
                () -> assertTrue(deliverySectionAvailability),
                () -> assertTrue(billingSectionAvailability)
        );

    }


}
