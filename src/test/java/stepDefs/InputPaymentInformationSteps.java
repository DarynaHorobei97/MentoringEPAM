package stepDefs;

import desktop.fragments.BillingAddressFragment;
import desktop.fragments.DeliveryAddressFragment;
import desktop.fragments.PaymentFragment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.Map;

public class InputPaymentInformationSteps {

    PaymentFragment paymentFragment = new PaymentFragment();

    @And("I enter my card details")
    public void iEnterMyCardDetails(Map<String, String> deliveryAddr) {

        paymentFragment.fillCardTypeField(deliveryAddr.get("Card Type"));
        paymentFragment.fillCardNameField(deliveryAddr.get("Name On Card"));
        paymentFragment.fillCardNameField(deliveryAddr.get("cardNumber"));
        paymentFragment.fillValidToYearDropDownField(deliveryAddr.get("Expiry Year"));
        paymentFragment.fillValidToMonthDropDownField(deliveryAddr.get("Expiry Month"));
        paymentFragment.fillCvvCodeField(deliveryAddr.get("Cvv"));

    }


}
