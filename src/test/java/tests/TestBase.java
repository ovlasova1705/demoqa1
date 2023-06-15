package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationFormPage;
import pages.RegistrationFormPageTestData;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RegistrationFormPageTestData registrationFormPageTestData = new RegistrationFormPageTestData();
    TestData testData = new TestData();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }


}
