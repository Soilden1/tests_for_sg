package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;

import static io.qameta.allure.SeverityLevel.*;

@Feature("Разводящая страница")
@Tag("Smoke")
@Severity(BLOCKER)
@Owner("dimacm14")
public class SelectTests extends TestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final TestData testData = new TestData();

    @Test
    @DisplayName("Выбрать город")
    public void selectCityTest() {
        placesPage.openPage()
                .selectCity(testData.city)
                .checkCity(testData.city);
    }

    @Test
    @DisplayName("Выбор несуществующего города")
    public void selectInvalidCityTest() {
        placesPage.openPage()
                .selectNotExistCity(testData.invalidCity);
    }

    @Test
    @DisplayName("Выбор категории")
    public void selectCategoryTest() {
        placesPage.openPage()
                .selectCategory(testData.categoryPharmacies);
    }
}
