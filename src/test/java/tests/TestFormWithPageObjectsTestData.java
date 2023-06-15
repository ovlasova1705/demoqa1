package tests;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class TestFormWithPageObjectsTestData extends TestBase {

    @Test
    void practiceFormTest() {


        registrationFormPageTestData.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender (testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dateBirthday)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .uploadFile(testData.fileName)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.stateValue)
                .setCity(testData.cityValue)
                .submitForm()
                .checkResultTableHeader()
                .checkResult("Student Email",testData.userEmail)
                .checkResult("Subjects",testData.subject)
                .checkResult("Hobbies",testData.hobbies);
    }


}
