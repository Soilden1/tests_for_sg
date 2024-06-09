package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;
import pages.components.AccordionComponent;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Заказы")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class OrdersTest extends LocalTestBase {

    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Оформить заказ")
    public void placeOrderTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openDeliveryWidget()
                .openCategory("Раздел блюд1")
                .addDish("блюдо с продуктом без ккал добавлено")
                .goReceiptMethod()
                .selectReceiptMethod()
                .selectReceiptTime()
                .selectPaymentMethod()
                .confirmUserAgreements()
                .finishOrdering();
        accordion.goOrdersPage()
                .checkOrderAvailability("Гранд, ГСК");
    }

    @Test
    @DisplayName("Открыть карточку заказа")
    public void openOrderCardTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goOrdersPage()
                .checkOrderAvailability("Гранд, ГСК")
                .openOrderCard("Гранд, ГСК");
    }

    @Test
    @DisplayName("Отменить заказ")
    public void cancelOrderTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goOrdersPage()
                .checkOrderAvailability("Гранд, ГСК")
                .cancelOrder();
    }

    @Test
    @DisplayName("Повторить заказ")
    public void repeatOrderTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goOrdersPage()
                .openOrderCardByStatus("Отменено")
                .repeatOrder()
                .goReceiptMethod()
                .selectReceiptMethod()
                .selectReceiptTime()
                .selectPaymentMethod()
                .confirmUserAgreements()
                .finishOrdering()
                .closeOrderCard()
                .checkOrderAvailability("Гранд, ГСК");
    }
}
