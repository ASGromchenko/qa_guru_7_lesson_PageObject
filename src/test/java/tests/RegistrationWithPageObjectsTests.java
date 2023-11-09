package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Gromchenko")
                .setEmail("test@gmail.com")
                .setGenderWrapper("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("20", "February", "1991")
                .setHobbies("Sports")
                .setSubject("Physics")
                .uploadPicture("homer.png")
                .currentAdress("Home Address")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        $(".table-responsive").shouldHave(text("Alexander Gromchenko"));
        $(".table-responsive").shouldHave(text("test@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("20 February,1991"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("homer.png"));
        $(".table-responsive").shouldHave(text("Home Address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
