package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MailRuAuthorizationPage {

    private final SelenideElement loginInput = $("#login"),
            passwordInput = $("#password"),
            submitButton = $("[type='submit']");

    @Step("Авторизоваться на mail.ru")
    public PlacesPage logIn(String login, String password) {
        setLogin(login);
        sleep(4000);
        setPassword(password);
        submitButton.click();
        return new PlacesPage();
    }

    @Step("Ввести логин")
    private void setLogin(String login) {
        loginInput.setValue(login);
    }

    @Step("Ввести пароль")
    private void setPassword(String password) {
        passwordInput.setValue(password);
    }
}
