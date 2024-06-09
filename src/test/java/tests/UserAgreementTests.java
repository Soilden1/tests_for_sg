package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Пользовательское соглашение")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class UserAgreementTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();

    @Test
    @DisplayName("Открытие пользовательского соглашения сайта в футере на разводящей")
    public void openUserAgreementOnPlacesPageTest() {
        placesPage.openPage();
        placesPage.openUserAgreement();
    }

    @Test
    @DisplayName("Открытие пользовательского соглашения сайта в профиле")
    public void openUserAgreementOnProfilePageTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("wifi373", "wifi373")
                .goProfilePage()
                .openUserAgreement();
    }

    @Test
    @DisplayName("Открытие пользовательского соглашения заведения")
    public void openUserAgreementOnCompanyPageTest() {
        placesPage.openPage();
        placesPage.setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openUserAgreement();
    }

    @Test
    @DisplayName("Открытие пользовательского соглашения заведения из виджета бонусной программы")
    public void openUserAgreementFromBonusProgramTest() {
        placesPage.openPage();
        placesPage.setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openBonusProgram()
                .openUserAgreement();
    }

    @Test
    @DisplayName("Открытие политики обработки персональных данных их виджета бонусной программы")
    public void openPersonalDataPolicyFromBonusProgramTest() {
        placesPage.openPage();
        placesPage.setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openBonusProgram()
                .openPersonalDataPolicy();
    }
}
