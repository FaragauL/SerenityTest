package com.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class HeaderPage extends PageObject {

    @FindBy(id = "search")
    private WebElementFacade searchTerms;

    @FindBy(css = "button[title=Search]")
    private WebElementFacade searchButton;

    public void enterKeyword(String keyword) {
        typeInto(searchTerms, keyword);
    }

    public void searchProduct() {
        searchButton.click();
    }
}
