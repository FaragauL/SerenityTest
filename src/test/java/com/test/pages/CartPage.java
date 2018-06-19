package com.test.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table tbody tr")
    public List<WebElementFacade> elementItems;

    @FindBy(css = "button[title=\"Continue Shopping\"] span")
    public WebElementFacade continueShoppingButton;

    @FindBy(css = "td[class=\"product-cart-total\"] span[class=\"price\"]")
     public List<WebElementFacade> subtotalPriceForProduct;

    @FindBy(css = "#shopping-cart-totals-table > tbody > tr:nth-child(1) > td:nth-child(2) > span")
    public WebElementFacade subtotalField;


    public List<WebElementFacade> getElementItems() {
        return elementItems;
    }
}
