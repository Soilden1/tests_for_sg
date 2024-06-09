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

@Feature("Отзывы клиента Saby Get")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class ReviewsTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Оставить отзыв о заведении")
    public void leaveReviewTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .goToFeedback()
                .openReviewWidget()
                .selectOrder()
                .selectRate()
                .sendReview()
                .selectReviewVisibility();
    }

    @Test
    @DisplayName("Отзывы отображаются на вкладке 'Отзывы' карточки заведения")
    public void checkReviewOnCompanyPageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .goToFeedback()
                .checkReviewVisibility();
    }

    @Test
    @DisplayName("Оставленный отзыв отображается в реестре 'Отзывы'")
    public void checkReviewOnRegistryTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goFeedbackPage()
                .checkReviewByCompany("Гранд, ГСК");
    }
}
