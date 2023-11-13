package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestData;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.emailName)
                .setGenderWrapper(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .setDateOfBirth(testData.dayOffBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setHobbies(testData.hobbies)
                .setSubject(testData.subj)
                .uploadPicture(testData.picture)
                .currentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()
                .checkResultsTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultsTable("Student Email", testData.emailName)
                .checkResultsTable("Gender", testData.gender)
                .checkResultsTable("Mobile", testData.mobilePhone)
                .checkResultsTable("Date of Birth", testData.dayOffBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResultsTable("Subjects", testData.subj)
                .checkResultsTable("Hobbies", testData.hobbies)
                .checkResultsTable("Picture", testData.picture)
                .checkResultsTable("Address", testData.address)
                .checkResultsTable("State and City", testData.state + " " + testData.city);
    }
    @Test
    void MinimumParams () {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .submit()
                .checkResultsTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultsTable("Gender", testData.gender)
                .checkResultsTable("Mobile", testData.mobilePhone);


    }

    @Test
    void NegativeTest () {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.gender)
                .submit()
                .verifyTable();


    }
}
