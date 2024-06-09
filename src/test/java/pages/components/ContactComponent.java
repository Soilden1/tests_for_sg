package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.CompanyPage;

import static com.codeborne.selenide.Selenide.$;

public class ContactComponent {

    private final SelenideElement messageInput = $("textarea"),
            sendMessageButton = $("[title='Отправить']"),
            closeChat = $("[title='Закрыть']");

    @Step("Отправить сообщение")
    public ContactComponent sendMessage(String message) {
        messageInput.click();
        messageInput.sendKeys(message);
        sendMessageButton.click();
        return this;
    }

    @Step("закрыть виджет чата")
    public CompanyPage closeChat() {
        closeChat.click();
        return new CompanyPage();
    }
}
