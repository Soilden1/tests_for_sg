package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private final SelenideElement authorizationDialogWindow = $(".sabugetAuth-AuthContent__content"),
            authorizationMethodsList = $(".oauth-List"),
            phoneNumberInput = authorizationDialogWindow.$("input"),
            submitButton = $(".controls-BaseButton__wrapper"),
            errorMessage = $(".controls-ValidateController__errorMessage"),
            sabyAuth = $("[data-qa='oauth-List__SabyAuth']"),
            sabyLoginInput = $("input"),
            sabyPasswordInput = $("[type='password']"),
            sabyAuthButton = $("[data-qa='auth-AdaptiveLoginForm__signInButton']");

    @Step("Проверить наличие сторонних способов авторизации")
    public AuthorizationPage checkAuthorizationMethods() {
        authorizationMethodsList.$("[data-qa='oauth-List__VK']").shouldBe(visible); //VK
        authorizationMethodsList.$("[data-qa='oauth-List__Apple']").shouldBe(visible); //Apple
        authorizationMethodsList.$("[data-qa='oauth-List__Yandex']").shouldBe(visible); //Yandex
        authorizationMethodsList.$("[data-qa='oauth-List__SabyAuth']").shouldBe(visible); //Saby
        authorizationMethodsList.$("[data-qa='oauth-List__Google']").shouldBe(visible); //Google
        authorizationMethodsList.$("[data-qa='oauth-List__Mail']").shouldBe(visible); //Mail
        authorizationMethodsList.$("[data-qa='oauth-List__Odnoklassniki']").shouldBe(visible); //OK
        return this;
    }

    @Step("Ввести номер телефона")
    public AuthorizationPage setPhoneNumber(String number) {
        phoneNumberInput.setValue(number);
        submitButtonClick();
        return this;
    }

    @Step("Нажать на кнопку авторизации")
    public AuthorizationPage submitButtonClick() {
        submitButton.shouldBe(visible, Duration.ofSeconds(6)).click();
        return this;
    }

    @Step("Проверить сообщение об ошибке")
    public AuthorizationPage checkErrorMessage(String message) {
        errorMessage.shouldHave(text(message), Duration.ofSeconds(6));
        return this;
    }

    @Step("Проверить отображение капчи после ввода номера телефона")
    public AuthorizationPage checkCaptcha() {
        authorizationDialogWindow.shouldBe(visible); //(remote launch)
        //$("[templatename='Antibot/captcha:Captcha']").shouldBe(visible, Duration.ofSeconds(2)); (local launch)
        return this;
    }

    @Step("Авторизоваться")
    public PlacesPage logIn(String login, String password) {
        sabyAuth.click();
        switchTo().window(1);
        sabyLoginInput.setValue(login).pressEnter();
        sabyPasswordInput.setValue(password);
        sabyAuthButton.click();
        switchTo().window(0);
        sleep(10000);
        return new PlacesPage();
    }
}
