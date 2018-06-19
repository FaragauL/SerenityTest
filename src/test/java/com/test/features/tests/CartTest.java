package com.test.features.tests;

import com.test.steps.ProductDetailsSteps;
import com.test.steps.serenity.CartSteps;
import com.test.steps.serenity.HeaderSteps;
import com.test.steps.serenity.ProductGridSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

@RunWith(SerenityRunner.class)
public class CartTest extends TestUtils {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public ProductDetailsSteps productDetailsSteps;
    @Steps
    public HeaderSteps headerSteps;
    @Steps
    public CartSteps cartSteps;
    @Steps
    public ProductGridSteps productGridSteps;

    @Test
    public void addToCartButtonShouldDisplayedOnProductPage() {
        headerSteps.isTheHomePage();
        headerSteps.looksFor("ELIZABETH KNIT TOP");
        productGridSteps.clickProductFromSearchResult("ELIZABETH KNIT TOP");
        productDetailsSteps.shouldSeeAddToCartButton();
    }

    @Test
    public void cartButtonShouldDisplayedOnHomepage() {
        headerSteps.isTheHomePage();
        productDetailsSteps.shouldSeeCartButton();
    }

    @Test
    public void colorAndSizeShouldBeRequiredForAddToCart() {
        headerSteps.isTheHomePage();
        headerSteps.looksFor("ELIZABETH KNIT TOP");
        productGridSteps.clickProductFromSearchResult("ELIZABETH KNIT TOP");
        productDetailsSteps.clickOnAddToCartButton();
        productDetailsSteps.shouldSeeMessageForColorRequiredFields();
        productDetailsSteps.shouldSeeMessageForSizeRequiredFields();
    }

    @Test
    public void shouldBeAbleToAddProductsToCart() {
        addToCartButtonShouldDisplayedOnProductPage();
        selectColorSizeAndQuantityOfProduct("Pink", "s");
    }

    @Test
    public void assertThatTheSubtotalPriceIsRight() throws InterruptedException, ParseException {
        shouldBeAbleToAddProductsToCart();
        cartSteps.clickOnContinueShoppingButton();
        headerSteps.looksFor("NOLITA CAMI");
        productGridSteps.clickProductFromSearchResult("NOLITA CAMI");
        selectColorSizeAndQuantityOfProduct("Black", "s");
        cartSteps.assertThatTheSubtotalIsRight();
    }

    @Test
    public void clickOnARandomPage() {
        headerSteps.isTheHomePage();
        headerSteps.looksFor("t");
        productGridSteps.clickOnARandomPage();
    }
}
