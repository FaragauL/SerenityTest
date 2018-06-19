package com.test.steps.serenity;

import com.test.pages.CartPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class CartSteps {

    CartPage cartPage;

    @Step
    public void assertThatTheSubtotalIsRight() throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#", new DecimalFormatSymbols(Locale.GERMAN));
        double subtotalSum = 0;

        //convert  subtotal for cart from string to double
        String subtotal = cartPage.subtotalField.getText();
        String[] subtotalResult = subtotal.split(" ");
        String subtotalAsString = subtotalResult[0];//replace(".", "").replace(",", ".");
        Number subtotalFormat = decimalFormat.parse(subtotalAsString);
        double subtotalToDouble = subtotalFormat.doubleValue();

        //browse the list of subtotals for all products
        for (int i = 0; i < cartPage.subtotalPriceForProduct.size(); i++) {
            String price = cartPage.subtotalPriceForProduct.get(i).getText();

            String[] priceResult = price.split(" ");
            for (String priceElement : priceResult) {
                System.out.println(priceElement);
            }
            String priceAsString = priceResult[0];//.replace(".", "").replace(",", ".");
            Number priceValue = decimalFormat.parse(priceAsString);
            double priceValueDouble = priceValue.doubleValue();
            //double priceValue = Double.parseDouble(priceAsString);
            System.out.println("Total price for " + i + " is: " + priceValue);

            //sum of all subtotals
            subtotalSum = subtotalSum + priceValueDouble;
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
