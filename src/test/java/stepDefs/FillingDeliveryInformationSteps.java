package stepDefs;

import desktop.fragments.*;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillingDeliveryInformationSteps {

    DeliveryAddressFragment deliveryAddressFragment = new DeliveryAddressFragment();


    @And("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformation(@Transpose Map<String, String> deliveryAddr) {

        String fullName = deliveryAddr.get("Full name");
        String deliveryCountry = deliveryAddr.get("Delivery country");
        String addLine1 = deliveryAddr.get("Address line 1");
        String addLine2 = deliveryAddr.get("Address line 2");
        String city = deliveryAddr.get("Town/City");
        String country = deliveryAddr.get("County/State");
        String postcode = deliveryAddr.get("Postcode");

        deliveryAddressFragment.setValueForFullNameField(fullName);
        deliveryAddressFragment.setCountryValueFromDropDown(deliveryCountry);
        deliveryAddressFragment.setValueForAddressLine1(addLine1);
        deliveryAddressFragment.setValueForAddressLine2(addLine2);
        deliveryAddressFragment.setValueForCityField(city);
        deliveryAddressFragment.setValueForCountryField(country);
        deliveryAddressFragment.setValueForPostCodeField(postcode);

    }





}
