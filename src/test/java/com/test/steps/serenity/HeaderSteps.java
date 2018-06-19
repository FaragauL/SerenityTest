package com.test.steps.serenity;

import com.test.pages.HeaderPage;
import net.thucydides.core.annotations.Step;

public class HeaderSteps {

    HeaderPage headerPage;

    @Step
    public void enters(String keyword) {
        headerPage.enterKeyword(keyword);
    }

    @Step
    public void startsSearch() {
        headerPage.searchProduct();
    }

    @Step
    public void looksFor(String keyword) {
        enters(keyword);
        startsSearch();
    }

    @Step
    public void isTheHomePage() {
        headerPage.open();
    }


}
