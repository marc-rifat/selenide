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
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized",
                "--disable-blink-features=AutomationControlled",
                "--disable-infobars",
                "--disable-notifications",
                "--disable-popup-blocking",
                "--disable-save-password-bubble",
                "--disable-translate",
                "--no-sandbox",
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriverRunner.setWebDriver(new ChromeDriver(options));
        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Configuration.timeout = 10000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    @Test
    public void googleSearch() throws InterruptedException {
        googleSearchPage.searchBox.sendKeys("Selenium is fun" + Keys.ENTER);
        assertThat(title(), containsString("Selenium is fun"));
    }
}
