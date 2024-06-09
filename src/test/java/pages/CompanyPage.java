package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CompanyPage {

    private final SelenideElement companyCardButton = $(".sg-Contractor__readOnly-off"),
            companyTitle = $("[data-qa='headers-Header__mainText']"),
            feedbackButton = $("[name='tabfeedback']"),
            menuButton = $("[data-name='catalog']"),
            deliveryButton = $("[name='tabdelivery']"),
            map = $(".mapboxgl-map"),
            mapMarker = $(".sg-MapMarker__marker"),
            chat = $("[data-qa='sg-OrderButton__chat']"),
            chatHeader = $(".consultant-widget-Header__area"),
            review = $(byText("Отзыв")),
            informationCard = $("[templatename='SabyGetContractor/widget:Card']"),
            reviewList = $("[data-qa='list']"),
            menu = $("[data-qa='tile-container']"),
            userAgreement = $(".sg-Footer__userAgreement"),
            userAgreementTitle = $("[data-qa='docview3-CommandPanel__rename']"),
            bonusProgramJoinButton = $(".sg-bonusProgram__joinButton"),
            bonusProgramHeader = $(".sg-ReferralPanel__header"),
            companyRecommendButton = $(".sg-bonusButton"),
            companyRecommendTitle = $(".sg-ReferralShare__headerTitle"),
            bonuses = $(".sg-ShopLayout__toolbar-viewButtons"),
            bonusesCounter = $(".sg-bonusCounter"),
            promocodes = $(".sg-estPromo"),
            orderButton = $(".sg-OrderButton");

    @Step("Открыть информационную карту компании")
    public CompanyPage openCompanyCard() {
        companyCardButton.click();
        return this;
    }

    @Step("Проверить отображение информационной карты компании")
    public CompanyPage checkCompanyCard() {
        informationCard.shouldBe(visible, Duration.ofSeconds(1));
        return this;
    }

    @Step("Проверить название компании")
    public CompanyPage checkTitle(String company) {
        companyTitle.shouldHave(text(company));
        return this;
    }

    @Step("Перейти на вкладку меню")
    public CompanyPage goToMenu() {
        sleep(2000);
        menuButton.shouldBe(visible, Duration.ofSeconds(2)).click();
        return this;
    }

    @Step("Перейти на вкладку доставки")
    public CompanyPage goToDelivery() {
        sleep(2000);
        deliveryButton.shouldBe(visible, Duration.ofSeconds(2)).click();
        return this;
    }

    @Step("Перейти на вкладку отзывов")
    public CompanyPage goToFeedback() {
        feedbackButton.click();
        return this;
    }

    @Step("Проверить переход на вкладку отзывов")
    public CompanyPage checkFeedbackList() {
        reviewList.shouldHave(visible);
        return this;
    }

    @Step("Проверить переход на вкладку меню")
    public CompanyPage checkMenuList() {
        menu.shouldHave(visible);
        return this;
    }

    @Step("Проверить наличие маркера")
    public CompanyPage checkMarker() {
        mapMarker.shouldHave(visible);
        return this;
    }

    @Step("Открыть пользовательское соглашение")
    public void openUserAgreement() {
        userAgreement.click();
        userAgreementTitle.shouldHave(text("Пользовательское соглашение Заведения.docx"));
    }

    @Step("Открыть виджет бонусной программы")
    public BonusProgramComponent openBonusProgram() {
        bonusProgramJoinButton.click();
        bonusProgramHeader.shouldHave(text("Вы получите"));
        return new BonusProgramComponent();
    }

    @Step("Открыть виджет рекомендации заведения")
    public BonusProgramComponent openRecommendCompanyWidget() {
        companyRecommendButton.click();
        companyRecommendTitle.shouldHave(text("Поделитесь ссылкой с друзьями"));
        return new BonusProgramComponent();
    }

    @Step("Открыть бонусы в задедении")
    public CompanyPage showBonuses() {
        bonuses.click();
        bonusesCounter.shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие промокода на странице заведения")
    public CompanyPage checkPromocode(String promocode) {
        promocodes.shouldHave(text(promocode));
        return this;
    }

    @Step("Открыть виджет доставки")
    public DeliveryComponent openDeliveryWidget() {
        orderButton.$(byText("Доставка")).click();
        return new DeliveryComponent();
    }

    @Step("Открыть виджет чата")
    public ContactComponent openChat() {
        chat.click();
        chatHeader.shouldHave(text("Давайте поговорим"));
        return new ContactComponent();
    }

    @Step("Открыть виджет отзыва")
    public ReviewComponent openReviewWidget() {
        review.click();
        return new ReviewComponent();
    }

    @Step("Проверить наличие отзыва")
    public CompanyPage checkReviewVisibility() {
        review.shouldBe(visible);
        return new CompanyPage();
    }
}
