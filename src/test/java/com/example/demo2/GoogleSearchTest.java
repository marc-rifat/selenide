package com.example.demo2;

import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTest {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test
    public void googleSearch() throws InterruptedException {
        String query = "Selenium is fun";
        open(googleSearchPage.baseUrl);
        googleSearchPage.search(query);
        googleSearchPage.assertTitleContains(query);
        googleSearchPage.takeScreenshot();
    }
}
