package demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    // SelenideElement, Locators, etc
    SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultsOutput = $("#output");

    // Actions
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage closedBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();

    }

    public TextBoxPage verifyResultsOutputAppear() {
        resultsOutput.shouldBe(appear);

        return this;
    }

    public TextBoxPage verifyResults(String key, String value) {
        resultsOutput.$(byText(key))
                .shouldHave(text(value));

        return this;
    }
}
