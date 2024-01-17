package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Selenide.$;

public class AccordionComponent {

    private final SelenideElement profile = $("[data-name='profile']"); //Профиль

    @Step("Нажать на кнопку 'Профиль' для авторизации")
    public AuthorizationPage goToLogin() {
        profile.click();
        return new AuthorizationPage();
    }
}
