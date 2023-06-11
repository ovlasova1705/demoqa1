package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFormWithPageObjects extends TestBase {

    @Test
    void practiceFormTest() {

        String firstName = "John";
        String lastName = "Boom";
        String userEmail = "mail@email.com";
        String userNumber = "1234567890";
        String currentAddress = "123 Street, City";



        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender ("Other")
                .setUserNumber(userNumber)
                .setDateOfBirth("July", "2008", "30")
                .setSubject("Computer Science")
                .setHobbies("Sports")
                .uploadFile("img/image.png")
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submitForm()
                .checkResultTableHeader()
                .checkResult("Student Email","mail@email.com")
                .checkResult("Subjects","Computer Science")
                .checkResult("Hobbies","Sports");
    }


}
