package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage {

    private final Faker faker = new Faker();

    private final SelenideElement selectLanguageButton = $(".engine_LanguageSelectorNew"),
            languageList = $("[data-qa='controls-Scroll__content']"),
            phoneNumberInput = $("[data-qa='phone']").$("input"),
            confirmPhoneNumberButton = $(byText("Подтвердить")),
            confirmCodeEntryField = $("[data-qa='controls-Render__field']").$("input"),
            userAgreement = $(".icon-ArrowTimeForward"),
            userAgreementTitle = $("[data-qa='docview3-CommandPanel__rename']");

    @Step("Сменить номер телефона")
    public ProfilePage changePhoneNumber() {
        String randomNumber = faker.random().nextInt(10, 99).toString();
        String newPhoneNumber = "+90152364" + randomNumber;
        phoneNumberInput.setValue(newPhoneNumber);
        confirmPhoneNumberButton.click();
        sleep(500);
        confirmCodeEntryField.setValue("6744");
        return this;
    }

    @Step("Сменить язык интерфейса")
    public ProfilePage changeInterfaceLanguage(String language) {
        selectLanguageButton.click();
        languageList.$(byText(language)).click();
        selectLanguageButton.shouldHave(text(language));
        return this;
    }

    @Step("Открыть пользовательское соглашение")
    public void openUserAgreement() {
        userAgreement.click();
        userAgreementTitle.shouldHave(text("Пользовательское соглашение сайта.docx"));
    }
}
