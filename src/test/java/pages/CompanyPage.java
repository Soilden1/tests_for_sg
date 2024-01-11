package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class CompanyPage {

    SelenideElement companyCard = $(".sg-Contractor__readOnly-off"),
            companyTitle = $("[data-qa='headers-Header__mainText']"),
            addToFavoritesButton = $("[name='toolbar']");

    @Step("Открыть информационную карту компании")
    public CompanyPage viewCompanyCard() {
        companyCard.click();
        sleep(1000);
        step("Проверить открытие информационной карты компании", () ->
                Assertions.assertTrue($("[templatename='SabyGetContractor/widget:Card']").isDisplayed()));
        return this;
    }

    @Step("Проверить название компании")
    public CompanyPage checkTitle(String company) {
        companyTitle.shouldHave(text(company));
        return this;
    }

    @Step("Добавить в избранное/Убрать из избранного")
    public CompanyPage clickFavoritesButton() {
        addToFavoritesButton.click();
        return this;
    }
}
