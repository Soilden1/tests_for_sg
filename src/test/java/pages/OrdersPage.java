package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ContactComponent;
import pages.components.DeliveryComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OrdersPage {

    private final SelenideElement list = $("[name='itemsContainer']"),
            chat = $("[data-qa='sg-OrderButton__chat']"),
            chatHeader = $(".consultant-widget-Header__area"),
            orderCardHeader = $("[data-qa='headers-Header__middle']"),
            orderCardCloseButton = $("[data-qa='controls-stack-Button__close']"),
            orderRepeatButton = $(byText("Повторить")),
            orderCancelButton = $(byText("Отменить")),
            orderCancelConfirmButton = $("[data-qa='controls-ConfirmationDialog__button-true']"),
            orderCancelConfirmMessage = $("[data-qa='controls-ConfirmationDialog__message']");

    @Step("Проверить наличие заказа")
    public OrdersPage checkOrderAvailability(String companyTitle) {
        list.shouldHave(text(companyTitle));
        return this;
    }

    @Step("Открыть карточку заказа по заведению")
    public OrdersPage openOrderCard(String companyTitle) {
        list.$(byText(companyTitle)).click();
        orderCardHeader.shouldHave(text(companyTitle));
        return this;
    }

    @Step("Открыть карточку заказа по статусу")
    public OrdersPage openOrderCardByStatus(String status) {
        list.$(byText(status)).click();
        return this;
    }

    @Step("Зкарыть карточку")
    public OrdersPage closeOrderCard() {
        orderCardCloseButton.click();
        return this;
    }

    @Step("Отменить заказ")
    public OrdersPage cancelOrder() {
        list.$(byText("В работе")).click();
        orderCancelButton.click();
        orderCancelConfirmButton.click();
        orderCancelConfirmMessage.shouldHave(text("Заказ отменён"));
        return this;
    }

    @Step("Повторить заказ")
    public DeliveryComponent repeatOrder() {
        orderRepeatButton.click();
        return new DeliveryComponent();
    }

    @Step("Открыть чат")
    public ContactComponent openChat() {
        chat.click();
        chatHeader.shouldHave(text("Давайте поговорим"));
        return new ContactComponent();
    }
}
