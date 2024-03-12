package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = FIREFOX;
        Configuration.browserSize = "1920x1080";
        System.out.println("Это перед всеми тестами (beforeAll)");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Это после всех тестов (afterAll)");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Это перед тестом (beforeEach)");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    Это после теста (afterEach)");
    }

    @Test
    void firstTest() {
        System.out.println("            Это тест firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            Это тест secondTest");
        Assertions.assertTrue(4*4 > 10);
    }
}
