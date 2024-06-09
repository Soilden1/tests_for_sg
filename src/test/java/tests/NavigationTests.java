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

@Feature("Навигация по страницам сайта")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class NavigationTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Навигация по разделам аккордеона")
    public void accordionNavigationTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goNewsPage();
        accordion.goCardsPage();
        accordion.goPromocodesPage();
        accordion.goOrdersPage();
        accordion.goFavoritesPage();
        accordion.goBonusesPage();
        accordion.goContactsPage();
        accordion.goFeedbackPage();
        accordion.goProfilePage();
    }

    @Test
    @DisplayName("Навигация по вкладкам страницы заведения")
    public void companyPageNavigationTest() {
        placesPage.openPage()
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .goToMenu()
                .goToFeedback();
    }
}
