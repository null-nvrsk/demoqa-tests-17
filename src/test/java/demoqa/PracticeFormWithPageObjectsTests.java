package demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


public class PracticeFormWithPageObjectsTests extends BaseTest {
    @Test
    void successRegistrationTest() {
        String FIRST_NAME = "John";
        String LAST_NAME = "Smith";
        String USER_EMAIL = "johnsmith@gmail.com";
        String USER_GENDER = "Male";
        String USER_NUMBER = "8001234567";
        String USER_BIRTH_HEAR = "1985";
        String USER_BIRTH_MONTH = "August";
        String USER_BIRTH_DAY = "30";
        String SUBJECT1 = "Maths";
        String SUBJECT2 = "Biology";
        String SUBJECT3 = "Computer Science";
        String HOBBY1 = "Reading";
        String HOBBY2 = "Music";
        String CURRENT_ADDRESS = "1195 Borregas Drive";
        String STATE = "Uttar Pradesh";
        String CITY = "Lucknow";

        regPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(USER_EMAIL)
                .setGender(USER_GENDER)
                .setPhone(USER_NUMBER)
                .setBirthDate(USER_BIRTH_DAY, USER_BIRTH_MONTH, USER_BIRTH_HEAR)
                .setSubject(SUBJECT1) // Maths
                .setSubject(SUBJECT2) // Biology
                .setSubject(SUBJECT3) // Computer Science
                .setHobby(HOBBY1)
                .setHobby(HOBBY2)
                .uploadPicture("img/avatar.png")
                .setCurrentAddress(CURRENT_ADDRESS)
                .setStateAndCity(STATE, CITY);

        regPage.submitRegistrtionForm();

        regPage
                .verifyResultsModal()
                .verifyResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .verifyResult("Student Email", USER_EMAIL)
                .verifyResult("Gender", USER_GENDER)
                .verifyResult("Mobile", USER_NUMBER)
                .verifyResult("Date of Birth", USER_BIRTH_DAY + " " + USER_BIRTH_MONTH + "," + USER_BIRTH_HEAR)
                .verifyResult("Subjects", SUBJECT1 + ", " + SUBJECT2 + ", " + SUBJECT3)
                .verifyResult("Hobbies", HOBBY1 + ", " + HOBBY2)
                .verifyResult("Picture", "avatar.png")
                .verifyResult("Address", CURRENT_ADDRESS)
                .verifyResult("State and City", STATE + " " + CITY);
    }

    @Test
    void successRegistration1Test() {
        String FIRST_NAME = "John";
        String LAST_NAME = "Smith";
        String USER_EMAIL = "johnsmith@gmail.com";
        String USER_GENDER = "Male";
        String USER_NUMBER = "8001234567";

        regPage.openPage();

        regPage.setFirstName(FIRST_NAME);
        regPage.setLastName(LAST_NAME);
        regPage.setEmail(USER_EMAIL);
        regPage.setGender(USER_GENDER);
        regPage.setPhone(USER_NUMBER);

        $("button#submit").click();
        // ....
    }
}
