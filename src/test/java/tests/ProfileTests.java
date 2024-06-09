package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Профиль пользователя")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class ProfileTests extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();

    @Test
    @DisplayName("Смена номера телефона в профиле")
    public void changePhoneNumberTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("wifi373", "wifi373")
                .goProfilePage()
                .changePhoneNumber();
    }

    @Test
    @DisplayName("Смена языка интерфейса в профиле")
    public void changeInterfaceLanguageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .goProfilePage()
                .changeInterfaceLanguage("English")
                .changeInterfaceLanguage("Русский");
    }
}
