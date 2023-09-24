package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitValue = $("#submit");

   public RegistrationFormPage openPage(){
       open("/automation-practice-form");
       $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
       executeJavaScript("$('footer').remove()");
       executeJavaScript("$('#fixedban').remove()");

       return this;
   }
    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }


    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year, String day){
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day );
        return this;
    }


    public RegistrationFormPage setSubject(String value){
        subjectsInput.setValue(value).pressEnter();;

        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage uploadFile(String value){
        uploadFileInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationFormPage setState(String value){
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage submitForm(){
        submitValue.click();
        return this;
    }

    public RegistrationFormPage checkResultTableHeader (){
        resultTableComponent.checkResultTableHeader();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        resultTableComponent.checkResult(key,value);

        return this;
    }
}
