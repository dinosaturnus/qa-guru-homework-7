package demoqa.tests;

import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullFormTest() {

        String firstName = "Alina",
                lastName = "Krivosheeva",
                email = "alina@test.ru",
                gender = "Female",
                phoneNumber = "9202981234",
                birthMonth = "May",
                birthYear = "1999",
                birthDay = "16",
                subject = "Maths",
                hobby = "Music",
                picturePath = "images/image.png",
                pictureName = "image.png",
                address = "Moscow, ul Leopardovaya, d 18, kv 219",
                state = "NCR",
                city = "Noida";

        registrationPage.openPage()
                .closedBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthYear, birthMonth, birthDay)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        registrationPage.verifyRegistrationsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);


    }
}
