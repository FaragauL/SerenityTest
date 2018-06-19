package com.test.features.search;

import com.test.pages.ProductDetailsPage;
import com.test.steps.ProductDetailsSteps;
import com.test.steps.serenity.HeaderSteps;
import com.test.steps.serenity.ProductGridSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

public class TestUtils {
    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    ProductDetailsSteps productDetailsSteps;
    @Steps
    HeaderSteps headerSteps;
    @Steps
    ProductGridSteps productGridSteps;


    public void selectColorSizeAndQuantityOfProduct(String color, String size){
        productDetailsSteps.selectColorForProduct(color);
        productDetailsSteps.selectSizeForProduct(size);
        productDetailsSteps.addingQuantityOfProduct();
        productDetailsSteps.clickOnAddToCartButton();

    }

    public void searchProductAndClickIt(String productName, String productNameForSelect) {
        headerSteps.looksFor(productName);
        productGridSteps.clickProductFromSearchResult(productNameForSelect);
    }

}
