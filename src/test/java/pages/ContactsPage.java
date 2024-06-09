package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {

    private final Faker faker = new Faker();
    private final SelenideElement sendMessageInput = $("[data-qa='textEditor_slate_Field']"),
            messageList = $("[name='viewContainer']"),
            sendMessageButton = $("[data-qa='msg-send-editor__send-button']"),
            firstMessage = $(".msg-entity-layout__body"),
            contextMenu = $(".controls-Menu__popup-list");

    @Step("Отправить сообщение")
    public ContactsPage sendMessage() {
        String message = "MESSAGE" + faker.random().nextInt(100, 300);
        sendMessageInput.click();
        sendMessageInput.press(message);
        sendMessageButton.click();
        messageList.shouldHave(text(message));
        return this;
    }

    @Step("Отредактировать сообщение")
    public ContactsPage editMessage() {
        String message = "MESSAGE" + faker.random().nextInt(100, 300);
        firstMessage.hover().contextClick();
        contextMenu.$(byText("Редактировать")).click();
        sendMessageInput.click();
        sleep(500);
        for (int i = 0; i < 10; i++) {
            actions().sendKeys(Keys.BACK_SPACE).perform();
        }
        sleep(500);
        sendMessageInput.press(message);
        sendMessageButton.click();
        return this;
    }

    @Step("Ответить на сообщение")
    public ContactsPage replyToMessage() {
        String message = "REPLY_TO_MESSAGE" + faker.random().nextInt(100, 300);
        firstMessage.hover().contextClick();
        contextMenu.$(byText("Цитировать")).click();
        sendMessageInput.press(message);
        sendMessageButton.click();
        messageList.shouldHave(text(message));
        return this;
    }

    @Step("Проверить наличие сообщения")
    public ContactsPage checkMessage(String message) {
        messageList.shouldHave(text(message));
        return this;
    }

}
