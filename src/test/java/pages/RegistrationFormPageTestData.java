package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CalendarComponentTestData;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageTestData {

    CalendarComponentTestData calendarComponentTestData = new CalendarComponentTestData();
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

   public RegistrationFormPageTestData openPage(){
       open("/automation-practice-form");
       $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
       executeJavaScript("$('footer').remove()");
       executeJavaScript("$('#fixedban').remove()");

       return this;
   }
    public RegistrationFormPageTestData setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPageTestData setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPageTestData setEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationFormPageTestData setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageTestData setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPageTestData setDateOfBirth(String date){
        dateOfBirthInput.click();
        calendarComponentTestData.setDate(date);
        return this;
    }


    public RegistrationFormPageTestData setSubject(String value){
        subjectsInput.setValue(value).pressEnter();;

        return this;
    }

    public RegistrationFormPageTestData setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPageTestData uploadFile(String value){
        uploadFileInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPageTestData setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationFormPageTestData setState(String value){
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageTestData setCity(String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPageTestData submitForm(){
        submitValue.click();
        return this;
    }

    public RegistrationFormPageTestData checkResultTableHeader (){
        resultTableComponent.checkResultTableHeader();

        return this;
    }

    public RegistrationFormPageTestData checkResult(String key, String value){
        resultTableComponent.checkResult(key,value);

        return this;
    }
}
