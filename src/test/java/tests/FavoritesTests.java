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

@Feature("Избранное")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class FavoritesTests extends RemoteTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Добавление товара в избранное")
    public void addToFavoritesTest() {
        placesPage.openPage()
                .authorizationWithMailRu("vanyaalekseev77@mail.ru", "alexvan77KSQ")
                .selectCity("Москва")
                .findPlaceOrCompany("Останкинская башня")
                .clickFavoritesButton();

        accordion.goToFavorites().checkPlaceOrCompany("Останкинская башня")
                .selectCompany("Останкинская башня")
                .clickFavoritesButton();
    }
}
