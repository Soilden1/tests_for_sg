package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;
import pages.components.AccordionComponent;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Избранное")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class FavoritesTests extends TestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();
    private final TestData testData = new TestData();

    @Disabled
    @Test
    @DisplayName("Добавление товара в избранное")
    public void addToFavoritesTest() {
        placesPage.openPage()
                .authorizationWithMailRu(testData.login, testData.password)
                .selectCity(testData.city)
                .findPlaceOrCompany(testData.company)
                .clickFavoritesButton();

        accordion.goToFavorites().checkPlaceOrCompany(testData.company)
                .selectCompany(testData.company)
                .clickFavoritesButton();
    }
}
