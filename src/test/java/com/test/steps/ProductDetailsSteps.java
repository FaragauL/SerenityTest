package com.test.steps;

import com.test.pages.ProductDetailsPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;



    @Step
    public void shouldSeeAddToCartButton() {
        productDetailsPage.shouldBeVisible(By.cssSelector("button[onclick='productAddToCartForm.submit(this)'"));
    }
    @Step
    public void shouldSeeCartButton() {
        productDetailsPage.shouldBeVisible(By.cssSelector("div[class='header-minicart'] span[class='label']"));
    }
    @Step
    public void shouldSeeMessageForColorRequiredFields() {
        productDetailsPage.shouldBeVisible(By.id("advice-required-entry-attribute92"));
    }
    @Step
    public void shouldSeeMessageForSizeRequiredFields() {
        productDetailsPage.shouldBeVisible(By.id("advice-required-entry-attribute180"));
    }
    @Step
    public void selectColorForProduct(String colorName) {
        productDetailsPage.selectColorOfProduct(colorName);
    }
    @Step
    public void selectSizeForProduct (String sizeName) {
        productDetailsPage.selectSizeOfProduct(sizeName);
    }
    @Step
    public void addingQuantityOfProduct() {
        productDetailsPage.addingQuantityOfProduct();
    }
    @Step
    public void clickOnAddToCartButton() {
        productDetailsPage.clickOnAddToCartButton();
    }
}
