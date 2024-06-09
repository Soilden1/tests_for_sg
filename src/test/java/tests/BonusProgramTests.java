package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;
import pages.components.AccordionComponent;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Программа лояльности")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class BonusProgramTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Присоединиться к бонусной программе (получить промокод)")
    public void joinBonusProgramTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("wifi373", "wifi373")
                .setCityTitle("Кострома")
                .selectCity("Кострома")
                .openCompanyPage("Таверна Златоземья")
                .openBonusProgram()
                .confirmAgreementAndDataPolicy()
                .pressAcceptButton();
    }

    @Test
    @DisplayName("Проверить наличие промокода в реестре 'Промокоды'")
    public void checkPromocodeTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goPromocodesPage()
                .checkPromocode("LDBBIPIY");
    }

    @Test
    @DisplayName("Проверить наличие промокода на странице заведения")
    public void checkPromocodeOnCompanyPageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Кострома")
                .selectCity("Кострома")
                .openCompanyPage("Таверна Златоземья")
                .checkPromocode("LDBBIPIY");
    }

    @Test
    @DisplayName("Рекомендовать заведение")
    public void recommendCompanyTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Кострома")
                .selectCity("Кострома")
                .openCompanyPage("Таверна Златоземья")
                .openRecommendCompanyWidget();
    }

    @Test
    @DisplayName("Открыть карточку бонуса в реестре 'Бонусы'")
    public void openBonusesTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goBonusesPage()
                .openBonuses("Таверна Златоземья");
    }

    @Test
    @DisplayName("Открыть бонусы на странице заведения")
    public void openBonusesInCompanyTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("wifi373", "wifi373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .showBonuses();
    }

    @Test
    @DisplayName("Открыть карточку промокода в реестре 'Промокоды'")
    public void openPromocodeCardTest() {
        placesPage.openPage();
        placesPage.goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goPromocodesPage()
                .openPromocodeCard("LDBBIPIY");
    }
}
