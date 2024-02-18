package com.example.demo2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchPage {
    public SelenideElement searchBox = $x("//textarea[@name='q']");

}
