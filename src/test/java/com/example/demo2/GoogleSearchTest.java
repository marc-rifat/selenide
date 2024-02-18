package com.example.demo2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchTest {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browser = "chrome";
        WebDriverRunner.setWebDriver(new ChromeDriver(new ChromeOptions().addArguments("--start-maximized")));
        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void googleSearch() throws InterruptedException {
        googleSearchPage.searchBox.sendKeys("Selenium is fun" + Keys.ENTER);
        assertThat(title(), containsString("Selenium is fun"));
    }
}
