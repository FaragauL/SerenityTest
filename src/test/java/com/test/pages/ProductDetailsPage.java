package com.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class ProductDetailsPage extends PageObject {


    @FindBy(name = "qty")
    private WebElementFacade quantityField;

    @FindBy(css = ".add-to-cart-buttons span")
    private WebElementFacade addToCartButton;




    public void selectColorOfProduct(String colorName) {
        getDriver().findElement(By.cssSelector("img[alt='" + colorName + "']")).click();
    }

    public void selectSizeOfProduct(String sizeName) {
        getDriver().findElement(By.name(sizeName)).click();

    }

    public void addingQuantityOfProduct() {
        quantityField.clear();
        quantityField.type(String.valueOf(ThreadLocalRandom.current().nextInt(1,10)));
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }
}
