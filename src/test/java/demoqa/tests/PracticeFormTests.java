package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

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

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper h5").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(USER_EMAIL);
        $("#genterWrapper").$(byText(USER_GENDER)).click();
        $("#userNumber").setValue(USER_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(USER_BIRTH_HEAR);
        $(".react-datepicker__month-select").selectOption(USER_BIRTH_MONTH);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(USER_BIRTH_DAY)).click();
        $("#subjectsInput").setValue(SUBJECT1).pressTab(); // Maths
        $("#subjectsInput").setValue(SUBJECT2).pressTab(); // Biology
        $("#subjectsInput").setValue(SUBJECT3).pressTab(); // Computer Science
        $("#hobbiesWrapper").$(byText(HOBBY1)).click();
        $("#hobbiesWrapper").$(byText(HOBBY2)).click();
        $("#uploadPicture").uploadFromClasspath("img/avatar.png");
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(CITY)).click();
        $("button#submit").click();

        $(".modal-content").should(appear);
        $(".modal-content .h4").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body .table-responsive").shouldHave(
                text(FIRST_NAME), text(LAST_NAME),
                text(USER_EMAIL),
                text(USER_GENDER),
                text(USER_NUMBER),
                text(USER_BIRTH_DAY), text(USER_BIRTH_MONTH), text(USER_BIRTH_HEAR),
                text(SUBJECT1), text(SUBJECT2), text(SUBJECT3),
                text(HOBBY1), text(HOBBY2),
                text("avatar.png"),
                text(CURRENT_ADDRESS), text(STATE), text(CITY)
        );
    }
}
