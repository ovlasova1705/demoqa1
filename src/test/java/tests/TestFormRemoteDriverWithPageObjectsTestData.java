package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestFormRemoteDriverWithPageObjectsTestData extends TestBaseExtended {

    @Test
    @Tag("remote")
    void practiceFormTest() {

        step("Open form", () -> {
            registrationFormPageTestData.openPage();

        });

        step("Fill form", () -> {
            registrationFormPageTestData.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.userEmail)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dateBirthday)
                    .setSubject(testData.subject)
                    .setHobbies(testData.hobbies)
                    .uploadFile(testData.fileName)
                    .setCurrentAddress(testData.currentAddress)
                    .setState(testData.stateValue)
                    .setCity(testData.cityValue)
                    .submitForm();
        });

        step("Verification", () -> {
            registrationFormPageTestData.checkResultTableHeader()
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobbies);
        });
    }


}
