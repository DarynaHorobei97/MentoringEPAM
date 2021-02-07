package stepDefs;

import desktop.fragments.*;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;

import java.util.Map;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckBasketSummarySteps {

    SearchResultsFragment searchResultsFragment = new SearchResultsFragment();
    BasketPopUpFragment basketPopUpFragment = new BasketPopUpFragment();
    BasketPage basketPage = new BasketPage();
    EmailFragment emailFragment = new EmailFragment();
    OrderSummary orderSummary = new OrderSummary();


    @And("I click 'Add to basket' button for product with name \"Thinking in Java\"")
    public void addBookToTheBasket() {
        searchResultsFragment.addBookToTheBasket("Thinking in Java");
    }

    @And("I select 'Basket Checkout' in basket pop-up")
    public void iSelectBasketCheckoutInTheBasketPopUp() {
        basketPopUpFragment.clickOnBasketCheckoutButton();
    }

    @And("I am redirected to a \"Basket page\"")
    public void goToBasketPage() {
        basketPopUpFragment.goToBasketPage();
    }

    @And("Basket order summary is as following:")
    public void checkBasketOrderSummary(@Transpose Map<String, String> basketOrderSummary) {
        String delivery_cost = basketOrderSummary.get("Delivery cost");
        String total = basketOrderSummary.get("Total");


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals(delivery_cost, basketPage.getDeliveryCost()),
                () -> assertEquals(total, basketPage.getTotal())
        );

    }

    @And("I click 'Checkout' button on 'Basket' page")
    public void iClickOnCheckoutButton() {
        basketPage.clickOnCheckoutButton();
    }

    @And("I checkout as a new customer with email \"test@user.com\"")
    public void iCheckoutAsANewCustomer() {
        emailFragment.checkoutWithEmail("test@user.com");
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummary(@Transpose Map<String, String> orderSum) {

        String subTotal = orderSum.get("Sub-total");
        String delivery = orderSum.get("Delivery");
        String vat = orderSum.get("VAT");
        String total = orderSum.get("Total");


        String actualSubTotal = orderSummary.getSubTotalField();
        String actualDelivery = orderSummary.getDeliveryField();
        String actualVat = orderSummary.getVatField();
        String actualTotal = orderSummary.getTotalField();


        Assertions.assertAll("Total prices do not equal",
                () -> assertEquals(total, actualTotal),
                () -> assertEquals(delivery, actualDelivery),
                () -> assertEquals(vat, actualVat),
                () -> assertEquals(total, actualTotal)
        );


    }



}
