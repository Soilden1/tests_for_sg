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

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Авторизация")
@Tag("Smoke")
@Severity(BLOCKER)
@Owner("dimacm14")
public class AuthorizationTests extends TestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();
    private final TestData testData = new TestData();

    @Disabled
    @Test
    @DisplayName("Авторизация с валидными данными")
    public void authorizationTest() {
        placesPage.openPage()
                .authorizationWithMailRu(testData.login, testData.password);

        accordion.goToProfile();
    }
}
