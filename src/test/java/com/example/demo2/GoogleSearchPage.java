package com.example.demo2;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.Keys;

public class GoogleSearchPage {

    protected String baseUrl = "https://www.google.com/";

    public SelenideElement searchBox = $x("//textarea[@name='q']");

    public void search(String query) {
        searchBox.sendKeys(query + Keys.ENTER);
    }

    public void assertTitleContains(String query) {
        assertThat(title(), containsString(query));
    }

    public void takeScreenshot() {
        Selenide.screenshot("screenshot");
    }
}
