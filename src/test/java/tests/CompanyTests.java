package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Страница компании")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class CompanyTests extends TestBase {

    private final PlacesPage placesPage = new PlacesPage();

    @Test
    @DisplayName("Просмотр карточки компании")
    public void viewCompanyCardTest() {
        placesPage.openPage()
                .selectCity("Moscow") //Москва
                .checkCity("Moscow")
                .selectCategory("Museums") //Музеи
                .selectCompany("Останкинская башня")
                .checkTitle("Останкинская башня")
                .viewCompanyCard();
    }
}
