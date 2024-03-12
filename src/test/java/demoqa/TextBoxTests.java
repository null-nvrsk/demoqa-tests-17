package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String USER_NAME = "John Smith";
        String USER_EMAIL = "johnsmith@gmail.com";
        String USER_CURRENT_ADDRESS = "1195 Borregas Drive\n" +
                "Building 6\n" +
                "Sunnyvale, CA 94089";
        String USER_PERMANENT_ADDRESS = "1900 Seaport Boulevard\n" +
                "Redwood City, CA 94063";

        open("/text-box");
        $("h1.text-center").shouldHave(text("Text Box"));

        $("input#userName").setValue(USER_NAME);
        $("input#userEmail").setValue(USER_EMAIL);
        $("textarea#currentAddress").setValue(USER_CURRENT_ADDRESS);
        $("textarea#permanentAddress").setValue(USER_PERMANENT_ADDRESS);
        $("#submit").click();

        $("div#output #name").shouldHave(text(USER_NAME));
        $("div#output #email").shouldHave(text(USER_EMAIL));
        $("div#output #currentAddress").shouldHave(text(USER_CURRENT_ADDRESS));
        $("div#output #permanentAddress").shouldHave(text(USER_PERMANENT_ADDRESS));
    }
}
