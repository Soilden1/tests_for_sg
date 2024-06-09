package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PromocodesPage {

    private final SelenideElement promocodesList = $("[name='scrollContent']"),
            promocodeCard = $("[data-qa='controls-Scroll__content']");

    @Step("Проверить наличие промокода")
    public PromocodesPage checkPromocode(String promocode) {
        promocodesList.shouldHave(text(promocode));
        return this;
    }

    @Step("Открыть карточку прромокода")
    public PromocodesPage openPromocodeCard(String promocode) {
        promocodesList.$(byText(promocode)).click();
        promocodeCard.shouldHave(text("Ваш промокод"));
        return this;
    }
}
