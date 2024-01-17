package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = System.getProperty("baseUrl", "https://sabyget.ru/");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "100");
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 6000;
        Configuration.remote = System.getProperty("host", "https://user1:1234@selenoid.autotests.cloud") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!browser.equals("firefox")) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();

        closeWebDriver();
    }
}
