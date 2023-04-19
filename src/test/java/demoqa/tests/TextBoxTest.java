package demoqa.tests;

import demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {

        String fullName = "Alina Krivosheeva",
                email = "test@test.ru",
                currentAddress = "Kaluga, ul Volkova, d 34, kv 16",
                permanentAddress = "Moscow, ul Tulpa, d 6, kv 19";

        textBoxPage.openPage()
                .closedBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton();

        textBoxPage.verifyResultsOutputAppear()
                .verifyResults("Name:", fullName)
                .verifyResults("Email:", email)
                .verifyResults("Current Address :", currentAddress)
                .verifyResults("Permananet Address :", permanentAddress);
    }
}
