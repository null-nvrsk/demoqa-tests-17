package demoqa.tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTests extends BaseTest {

    @Test
    void successRegistrationTest() {
        regPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhone(testData.userNumber)
                .setBirthDate(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picturePath)
                .setCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city);

        regPage.submitRegistrtionForm();

        regPage
                .verifyResultsModal()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth + ","
                        + testData.userBirthYear)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.pictureName)
                .verifyResult("Address", testData.currentAddress)
                .verifyResult("State and City", testData.state + " " + testData.city);
    }
}
