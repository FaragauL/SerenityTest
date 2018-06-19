package com.test.steps.serenity;

import com.test.pages.CartPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class CartSteps {

    CartPage cartPage;

    @Step
    public void assertThatTheSubtotalIsRight() {
        int countList = cartPage.getElementItems().size();
        System.out.println("Count list is: " + countList);
        double subtotalSum = 0;
        //convert subtotal from string to double
        String subtotal = cartPage.subtotalField.getText();
        String[] subtotalResult = subtotal.split(" ");
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#", new DecimalFormatSymbols(Locale.US));
        String subtotalAsString = subtotalResult[0];//replace(".", "").replace(",", ".");
        double subtotalToDouble = Double.valueOf(subtotalAsString);

        for (int i = 0; i < cartPage.subtotalPriceForProduct.size(); i++) {
            String price = cartPage.subtotalPriceForProduct.get(i).getText();

            String[] priceResult = price.split(" ");
            for (String priceElement : priceResult) {
                System.out.println(priceElement);
            }
            String priceAsString = priceResult[0].replace(".", "").replace(",", ".");

            double priceValue = Double.parseDouble(priceAsString);
            System.out.println("Total price for " + i + " is: " + priceValue);

            subtotalSum = subtotalSum + priceValue;
            System.out.println("Subtotal is: " + subtotalSum);
        }
        System.out.println("SubtotalToDouble is: " + subtotalToDouble);
        Assert.assertEquals(subtotalSum, subtotalToDouble, 0);
    }

    @Step
    public void clickOnContinueShoppingButton() {
        cartPage.continueShoppingButton.click();
    }
}
