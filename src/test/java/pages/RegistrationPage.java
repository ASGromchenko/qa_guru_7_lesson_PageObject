package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResults;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            hobbies = $("#hobbiesWrapper"),
            subjectInput = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitClick = $("#submit"),
            tableResults = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResults checkResults = new CheckResults();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.val(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        uploadFile.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage currentAdress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState (String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity (String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submitClick.click();
        return this;
    }

    public RegistrationPage checkResultsTable(String key, String value) {
        checkResults.checkResultsTable(key, value);
        return this;
    }

    public RegistrationPage verifyTable () {
        tableResults.shouldNotBe(Condition.visible);
        return this;
    }

}
