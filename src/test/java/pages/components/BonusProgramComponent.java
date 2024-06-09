package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BonusProgramComponent {

    private final SelenideElement personalDataPolicy = $$(".sg-ReferralPanel__preview_agreement-link").findBy(text("персональных данных")),
            UserAgreement = $$(".sg-ReferralPanel__preview_agreement-link").findBy(text("пользовательское соглашение")),
            documentTitle = $("[data-qa='docview3-CommandPanel__rename']"),
            confirmAgreementAndDataPolicyCheckbox = $("[data-qa='controls-CheckboxMarker']"),
            acceptButton = $(".sg-bonusButton");


    @Step("Открыть политику обработки персональных данных")
    public void openUserAgreement() {
        personalDataPolicy.click();
        documentTitle.shouldHave(text("Политика обработки персональных данных.docx"));
    }

    @Step("Открыть пользовательское соглашение")
    public void openPersonalDataPolicy() {
        UserAgreement.click();
        documentTitle.shouldHave(text("Пользовательское соглашение Заведения.docx"));
    }

    @Step("Принять пользовательское соглашение")
    public BonusProgramComponent confirmAgreementAndDataPolicy() {
        confirmAgreementAndDataPolicyCheckbox.click();
        return this;
    }

    @Step("Нажать 'Получить'")
    public void pressAcceptButton() {
        acceptButton.shouldHave(visible);
    }
}
