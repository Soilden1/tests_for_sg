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
public class CompanyTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final TestData testData = new TestData();

    @Test
    @DisplayName("Просмотреть карточку компании")
    public void viewCompanyCardTest() {
        placesPage.openPage()
                .setCityTitle(testData.city)
                .selectCity(testData.city)
                .selectCategory(testData.categoryMuseums)
                .selectCompany(testData.companyMuseum)
                .checkTitle(testData.companyMuseum)
                .openCompanyCard()
                .checkCompanyCard();
    }

    @Test
    @DisplayName("Отображается маркер на карте при просмотре страницы компании")
    public void checkCompanyMarkerTest() {
        placesPage.openPage()
                .setCityTitle(testData.city)
                .selectCity(testData.city)
                .selectCategory(testData.categoryCafe)
                .checkCategory(testData.categoryCafe)
                .selectCompany(testData.companyCafe)
                .checkMarker();
    }

    @Test
    @DisplayName("Просмотреть отзывы")
    public void showFeedBackTest() {
        placesPage.openPage()
                .setCityTitle(testData.city)
                .selectCity(testData.city)
                .selectCategory(testData.categoryPharmacies)
                .selectCompany(testData.companyPharmacies)
                .goToFeedback()
                .checkFeedbackList();
    }

    @Test
    @DisplayName("Просмотреть меню")
    public void showMenuTest() {
        placesPage.openPage()
                .setCityTitle(testData.city)
                .selectCity(testData.city)
                .selectCategory(testData.categoryCafe)
                .checkCategory(testData.categoryCafe)
                .selectCompany(testData.companyCafe)
                .goToMenu()
                .checkMenuList();
    }
}
