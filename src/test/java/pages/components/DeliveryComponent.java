package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.OrdersPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class DeliveryComponent {

    private final SelenideElement categoryList = $("[data-qa='list']"),
            dishList = $("[name='viewContainer']"),
            pickupReceiptMethod = $("[name='TumblerButton1']"),
            confirmUserAgreementsCheckbox = $("[data-qa='controls-CheckboxMarker']");

    @Step("Открыть категорию")
    public DeliveryComponent openCategory(String title) {
        categoryList.$(byText(title)).parent().parent().click();
        return this;
    }

    @Step("Добавить блюдо в карзину")
    public DeliveryComponent addDish(String title) {
        dishList.$(byText(title)).parent().parent().parent().$("[data-qa='CounterIncrement']").click();
        return this;
    }

    @Step("Перейти к выбору способа получения")
    public DeliveryComponent goReceiptMethod() {
        $("[data-qa='ExtButtons-doubleButton__button']").click();
        $("[data-qa='bw-BasketPopup__btn']").click();
        return this;
    }

    @Step("Выбрать способ получения")
    public DeliveryComponent selectReceiptMethod() {
        pickupReceiptMethod.click();
        $("[data-qa='bw-AddressSelect__confirm-address']").click();
        return this;
    }

    @Step("Выбрать время получения")
    public DeliveryComponent selectReceiptTime() {
        //$("[data-qa='bw-AddressSelect__confirm-date']").click();
        $("[data-qa='bw-Calendar__btn']").click();
        sleep(3000);
        return this;
    }

    @Step("Выбрать спосогб оплаты")
    public DeliveryComponent selectPaymentMethod() {
        $("[data-qa='bw-Payment__payment-popup-btn']").click();
        $("[data-qa='bw-ConfirmOrder__button']").click();
        return this;
    }

    @Step("Принять пользовательские соглашения")
    public DeliveryComponent confirmUserAgreements() {
        confirmUserAgreementsCheckbox.click();
        return this;
    }

    @Step("Закончить оформление заказа")
    public OrdersPage finishOrdering() {
        $("[data-qa='sgp-payment-card-activateButton']").click();
        $("[data-qa='bw-Finish__btn']").click();
        return new OrdersPage();
    }
}
