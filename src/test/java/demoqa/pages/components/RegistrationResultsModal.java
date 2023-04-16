package demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key))
                .sibling(0).shouldHave(text(value));
    }
}
