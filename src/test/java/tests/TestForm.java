package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

//ctrl+Alt+L - correct all
public class TestForm extends TestBase{

    @Test
    void practiceFormTest() {

        String firstName = "John";
        String lastName = "Boom";
        String userEmail= "mail@email.com";
        String  userNumber = "1234567890";
        String currentAddress = "123 Street, City";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Other")).click();
//        $("#gender-radio-1").parent().click();
//        $("[for=gender-radio-3]").click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July"); // Select July
        $(".react-datepicker__year-select").selectOptionByValue("2008"); // Select 2008
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); // Select 30th day of the month
//<div class="react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected react-datepicker__day--outside-month"  aria-label="Choose Monday, June 30th, 2008" >30</div>
//<div class="react-datepicker__day react-datepicker__day--030"                                                                       aria-label="Choose Wednesday, July 30th, 2008" >30</div>
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
//        $(".table-responsive").shouldHave(text(firstName),text(lastName),
//                text(userEmail), text("Computer Science"),
//                text("Sports"), text("123 Street, City"), text("NCR Delhi"));
        //$(".table-responsive").$(byText("Subjects")).parent().shouldHave( text("Computer Science"));
        checkTable("Subjects", "Computer Science");
    }

    void checkTable(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

    }
}
