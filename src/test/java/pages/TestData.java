package pages;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Optional;


public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            emailName = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobilePhone = faker.phoneNumber().subscriberNumber(10),
            dayOffBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(2000, 2023)),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            subj = faker.options().option("Physics", "Maths"),
            picture = faker.options().option("homer.png", "cat.jpg"),
            address = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state);

    public String setCity (String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
        }

        return null;
    }


}
