package com.example.demo2;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Feature("Google Search")
public class GoogleSearchTest extends BaseTest {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test
    @Description("Verify Google search functionality with query 'Selenium is fun'")
    @Severity(SeverityLevel.NORMAL)
    public void googleSearch() throws InterruptedException {
        String query = "Selenium is fun";
        googleSearchPage.navigateToBaseUrl();
        googleSearchPage.search(query);
        googleSearchPage.assertTitleContains(query);
        googleSearchPage.takeScreenshot();
    }
}
