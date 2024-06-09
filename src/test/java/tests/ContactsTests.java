package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PlacesPage;
import pages.components.AccordionComponent;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Feature("Чаты и контакты клиента Saby Get")
@Tag("Smoke")
@Severity(CRITICAL)
@Owner("dimacm14")
public class ContactsTests extends LocalTestBase {

    private final Faker faker = new Faker();
    private final PlacesPage placesPage = new PlacesPage();
    private final AccordionComponent accordion = new AccordionComponent();

    @Test
    @DisplayName("Отрправить сообщение в реестре 'Чаты'")
    public void sendMessageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goContactsPage()
                .sendMessage();
    }

    @Test
    @DisplayName("Отредактировать сообщение в реестре 'Чаты'")
    public void editMessageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goContactsPage()
                .editMessage();
    }

    @Test
    @DisplayName("Ответить на сообщение в реестре 'Чаты'")
    public void replyToMessageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goContactsPage()
                .replyToMessage();
    }

    @Test
    @DisplayName("Начать диалог из карточки заказа")
    public void startDialogueFromOrderCardTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373");
        accordion.goOrdersPage()
                .openOrderCard("Гранд, ГСК")
                .openChat();
    }

    @Test
    @DisplayName("Начать диалог со страницы заведения")
    public void startDialogueFromCompanyPageTest() {
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openChat();
    }

    @Test
    @DisplayName("Сообщение, отправленное из виджета чата, отображается в реестре 'Чаты'")
    public void DisplayMessageFromWidgetInRegistryTest() {
        String message = "CHAT_MESSAGE" + faker.random().nextInt(100, 300);
        placesPage.openPage()
                .goAuthorizationPage()
                .logIn("atest373", "atest373")
                .setCityTitle("Северодвинск")
                .selectCity("Северодвинск")
                .openCompanyPage("Гранд, ГСК")
                .openChat()
                .sendMessage(message)
                .closeChat();
        accordion.goContactsPage()
                .checkMessage(message);
    }
}
