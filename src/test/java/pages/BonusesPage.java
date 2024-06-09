package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BonusesPage {

    private final SelenideElement bonusCard = $(".sg-BonusCards__tile"),
            bonusCardHeader = $(".sg-ReferralPanel__header");

    @Step("Открыть плитку бонуса")
    public BonusesPage openBonuses(String companyName) {
        bonusCard.click();
        bonusCardHeader.shouldHave(text(companyName));
        return this;
    }
}
