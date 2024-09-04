package demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static demoqa.utils.PandomUtils.randomEmail;
import static demoqa.utils.PandomUtils.randomString;

public class PracticeFormWithRandomUtilsTests extends BaseTest {

    @Test
    void successRegistrationTest() {
        String firstName = randomString(10);
        String lastName = randomString(12);
        String userEmail = randomEmail();

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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
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
                text(firstName), text(lastName),
                text(userEmail),
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
