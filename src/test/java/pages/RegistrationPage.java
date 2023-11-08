package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage () {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail (String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenderWrapper (String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDate (String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;


    }
}
