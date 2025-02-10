package com.example.demo2;

import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test
    public void googleSearch() throws InterruptedException {
        String query = "Selenium is fun";
        googleSearchPage.navigateToBaseUrl();
        googleSearchPage.search(query);
        googleSearchPage.assertTitleContains(query);
        googleSearchPage.takeScreenshot();
    }
}
