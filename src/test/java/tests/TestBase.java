package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 5000;
    }
}
