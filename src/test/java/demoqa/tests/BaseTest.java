package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import demoqa.pages.RegistrationPage;

public class BaseTest {
    RegistrationPage regPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 120_000;
        Configuration.pageLoadTimeout = 120_000;
    }
}