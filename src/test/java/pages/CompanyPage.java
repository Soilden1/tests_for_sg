package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CompanyPage {

    private final SelenideElement companyCardButton = $(".sg-Contractor__readOnly-off"),
            companyTitle = $("[data-qa='headers-Header__mainText']"),
            feedbackButton = $("[name='tabfeedback']"),
            menuButton = $("[data-name='catalog']"),
            map = $(".mapboxgl-map");

    @Step("Открыть информационную карту компании")
    public CompanyPage openCompanyCard() {
        companyCardButton.click();
        return this;
    }

    @Step("Проверить отображение информационной карты компании")
    public CompanyPage checkCompanyCard() {
        $("[templatename='SabyGetContractor/widget:Card']").shouldBe(visible, Duration.ofSeconds(1));
        return this;
    }

    @Step("Проверить название компании")
    public CompanyPage checkTitle(String company) {
        companyTitle.shouldHave(text(company));
        return this;
    }

    @Step("Перейти на вкладку отзывов")
    public CompanyPage goToFeedback() {
        feedbackButton.click();
        return this;
    }

    @Step("Проверить переход на вкладку отзывов")
    public CompanyPage checkFeedbackList() {
        $("[data-qa='list']").shouldHave(visible);
        return this;
    }

    @Step("Перейти на вкладку меню")
    public CompanyPage goToMenu() {
        sleep(2000);
        menuButton.shouldBe(visible, Duration.ofSeconds(2)).click();
        return this;
    }

    @Step("Проверить переход на вкладку меню")
    public CompanyPage checkMenuList() {
        $("[data-qa='tile-container']").shouldHave(visible);
        return this;
    }

    @Step("Проверить наличие маркера")
    public CompanyPage checkMarker() {
        map.$(".sg-MapMarker__marker").shouldHave(visible);
        return this;
    }
}
