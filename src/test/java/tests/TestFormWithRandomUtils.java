package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtilsExample.getRandomEmail;
import static utils.RandomUtilsExample.getRandomString;

public class TestFormWithRandomUtils extends TestBase {
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String userEmail = getRandomEmail();
    String userNumber = "1234567890";
    String currentAddress = "123 Street, City";
    @Test
    void practiceFormTest() {



        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July"); // Select July
        $(".react-datepicker__year-select").selectOptionByValue("2008"); // Select 2008
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); // Select 30th day of the month
        $("#subjectsInput").setValue("Computer Science").pressEnter();


        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/image.png");

        $("#currentAddress").setValue(currentAddress);

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        // Verification
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
                $(".table-responsive").shouldHave(text(firstName),text(lastName),
                text(userEmail), text("Computer Science"),
                text("Sports"), text("123 Street, City"), text("NCR Delhi"));
    }


}
