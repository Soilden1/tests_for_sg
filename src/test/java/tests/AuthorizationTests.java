package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;
import pages.components.AccordionComponent;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Страница авторизации")
@Tag("Smoke")
@Severity(BLOCKER)
@Owner("dimacm14")
public class AuthorizationTests extends TestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();
    private final TestData testData = new TestData();

    @Test
    @DisplayName("Проверить способы авторизации")
    public void checkAuthorizationMethodsTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .checkAuthorizationMethods();
    }

    @Test
    @DisplayName("При неполном указании номера телефона отображается сообщение об ошибке")
    public void setIncompletePhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.incompletePhoneNumber)
                .checkErrorMessage(testData.incompletePhoneNumberMessage);
    }

    @Test
    @DisplayName("При указании неподдерживаемого номера телефона отображается сообщение об ошибке")
    public void setUnsupportedPhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.unsupportedPhoneNumber)
                .checkErrorMessage(testData.unsupportedPhoneNumberMessage);
    }

    @Test
    @DisplayName("При указании номера телефона недопустимой длины отображается сообщение об ошибке")
    public void setInvalidLengthPhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.invalidLengthPhoneNumber)
                .checkErrorMessage(testData.invalidLengthPhoneNumberMessage);
    }

    @Test
    @DisplayName("При указании стационарного номера телефона отображается сообщение об ошибке")
    public void setLandlinePhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.landlinePhoneNumber)
                .checkErrorMessage(testData.landlinePhoneNumberMessage);
    }

    @Test
    @DisplayName("При указании несуществующего номера телефона отображается сообщение об ошибке")
    public void setFictitiousPhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.fictitiousPhoneNumber)
                .checkErrorMessage(testData.fictitiousPhoneNumberMessage);
    }

    @Test
    @DisplayName("При авторизации без указания номера телефона отображается сообщение об ошибке")
    public void setEmptyPhoneNumberTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .submitButtonClick()
                .checkErrorMessage(testData.emptyPhoneNumberMessage);
    }

    @Test
    @DisplayName("При авторизации по номеру телефона отображается капча")
    public void checkPhoneNumberConfirmationTest() {
        placesPage.openPage();
        accordion.goToLogin()
                .setPhoneNumber(testData.validPhoneNumber)
                .checkCaptcha();
    }
}
