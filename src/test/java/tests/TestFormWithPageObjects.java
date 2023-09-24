package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFormWithPageObjects extends TestBase {

    @Test
    void practiceFormTest() {


        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender ("Other")
                .setUserNumber(testData.userNumber)
                .setDateOfBirth("July", "2008", "30")
                .setSubject("Computer Science")
                .setHobbies("Sports")
                .uploadFile("img/image.png")
                .setCurrentAddress(testData.currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .checkResultTableHeader()
                .checkResult("Student Email",testData.userEmail)
                .checkResult("Subjects","Computer Science")
                .checkResult("Hobbies","Sports");
    }


}
