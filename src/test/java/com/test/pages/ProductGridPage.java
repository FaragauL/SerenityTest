package com.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class ProductGridPage extends PageObject {

    @FindBy(css = "a[class='next i-next']")
    public WebElementFacade nextButton;

    @FindBy(css = "p[class='amount amount--has-pages']")
    public WebElementFacade amountOfProducts;

    @FindBy(css = "select[title='Results per page'] option")
    public WebElementFacade resultsPerPage;

    @FindBy(css = "div[class='pages'] li[class='current']")
    public WebElementFacade currentPage;

    public int getTotalOfProductsFound() {
        String amountOfProduct = amountOfProducts.getText();
        String[] amountOfProductList = amountOfProduct.split(" ");
        String totalProductSearch = amountOfProductList[2];
        int totalProducts = Integer.valueOf(totalProductSearch);
        //System.out.println("Total products is: " + totalProducts);
        return totalProducts;
    }

    public int getNumberOfResultPerPage() {
        String resultPerPage = resultsPerPage.getText().trim();
        int productResultsPerPage = Integer.valueOf(resultPerPage);
        //System.out.println("Results per page is: " + productResultsPerPage);
        return productResultsPerPage;
    }

    public int getNumberOfPages() {
        int numberOfPages;
        if (getTotalOfProductsFound() % getNumberOfResultPerPage() == 0) {
            numberOfPages = getTotalOfProductsFound() / getNumberOfResultPerPage() + 1;
        } else {
            numberOfPages = getTotalOfProductsFound() / getNumberOfResultPerPage() + 1;
        }
        //System.out.println("Number of pages is:" + numberOfPages);
        return numberOfPages;
        ///int randomNumberForPage = ThreadLocalRandom.current().nextInt(1, numberOfPages );
        //System.out.println("Number of randomNumberForPage is: " + randomNumberForPage);
    }

    public void clickLinkForSelectedProduct(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
    }
}
