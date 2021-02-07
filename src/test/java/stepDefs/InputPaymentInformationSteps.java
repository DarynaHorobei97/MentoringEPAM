package stepDefs;

import desktop.fragments.PaymentFragment;
import io.cucumber.java.en.And;

import java.util.Map;

public class InputPaymentInformationSteps {

    PaymentFragment paymentFragment = new PaymentFragment();

    @And("I enter my card details")
    public void iEnterMyCardDetails(Map<String, String> deliveryAddr) {

        paymentFragment.fillCardTypeField(deliveryAddr.get("Card Type"));
        paymentFragment.fillCardNameField(deliveryAddr.get("Name On Card"));
        paymentFragment.fillCardNumberField(deliveryAddr.get("cardNumber"));
        paymentFragment.fillValidToYearDropDownField(deliveryAddr.get("Expiry Year"));
        paymentFragment.fillValidToMonthDropDownField(deliveryAddr.get("Expiry Month"));
        paymentFragment.fillCvvCodeField(deliveryAddr.get("Cvv"));

    }


}
