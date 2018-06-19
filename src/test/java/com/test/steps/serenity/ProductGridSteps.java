package com.test.steps.serenity;

import com.test.pages.ProductGridPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductGridSteps {

    ProductGridPage productGridPage;


    @Step
    public void clickProductFromSearchResult(String linkText) {
        productGridPage.clickLinkForSelectedProduct(linkText);
    }


//    @Step
//    public void getNumberOfProductSearch() {
//        productGridPage.getNumberOfPages();
//    }

    @Step
    public void clickOnARandomPage() {
        int numberOfPages = productGridPage.getNumberOfPages();
        System.out.println("Number of pages is: " + numberOfPages);
        int randomNumberForPage = ThreadLocalRandom.current().nextInt(1, numberOfPages);
        System.out.println("Number of randomNumberForPage is: " + randomNumberForPage);
        int currentPage;
        do {
            productGridPage.nextButton.click();
            currentPage = Integer.valueOf(productGridPage.currentPage.getText());
        } while (currentPage != randomNumberForPage);
        System.out.println("Current page is: " + currentPage);

        productGridPage.getNumberOfPages();

    }
}

