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
                .setCityTitle(testData.city)
                .selectCity(testData.city)
                .checkCity(testData.city);
    }

    @Test
    @DisplayName("Проверить отсутствие записей при вводе несуществующего города")
    public void selectInvalidCityTest() {
        placesPage.openPage()
                .setCityTitle(testData.invalidCity)
                .checkNoFoundRecords();
    }

    @Test
    @DisplayName("Выбрать категорию")
    public void selectCategoryTest() {
        placesPage.openPage()
                .selectCategory(testData.categoryPharmacies)
                .checkCategory(testData.categoryPharmacies);
    }
}
