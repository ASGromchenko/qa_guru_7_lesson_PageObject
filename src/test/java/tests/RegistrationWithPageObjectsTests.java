package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
                .submit()
                .checkResultsTable("Student Name", "Alexander Gromchenko")
                .checkResultsTable("Student Email", "test@gmail.com")
                .checkResultsTable("Gender", "Male")
                .checkResultsTable("Mobile", "1234567890")
                .checkResultsTable("Date of Birth", "20 February,1991")
                .checkResultsTable("Subjects", "Physics")
                .checkResultsTable("Hobbies", "Sports")
                .checkResultsTable("Picture", "homer.png")
                .checkResultsTable("Address", "Home Address")
                .checkResultsTable("State and City", "NCR Delhi");
    }
    @Test
    void MinimumParams () {
        registrationPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Gromchenko")
                .setGenderWrapper("Male")
                .setUserNumber("1234567890")
                .submit()
                .checkResultsTable("Student Name", "Alexander Gromchenko")
                .checkResultsTable("Gender", "Male")
                .checkResultsTable("Mobile", "1234567890");


    }

    @Test
    void NegativeTest () {
        registrationPage.openPage()
                .setFirstName("Alexander")
                .setLastName("Gromchenko")
                .setGenderWrapper("Male")
                .submit()
                .verifyTable();


    }
}
