package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.*;

import static com.codeborne.selenide.Selenide.$;

public class AccordionComponent {

    private final SelenideElement places = $("[data-qa='Места']"),
            news = $("[data-qa='Новости']"),
            cards = $("[data-name='cards']"),
            promocodes = $("[data-name='promocodes']"),
            orders = $("[data-name='orders']"),
            favorites = $("[data-name='favorites']"),
            bonuses = $("[data-name='bonuses']"),
            contacts = $("[data-name='contacts']"),
            feedback = $("[data-name='feedback']"),
            profile = $("[data-name='profile']");

    @Step("Нажать на кнопку 'Профиль' для авторизации")
    public AuthorizationPage goToLogin() {
        profile.click();
        return new AuthorizationPage();
    }

    @Step("Перейти на разводящую")
    public PlacesPage goPlacesPage() {
        places.click();
        return new PlacesPage();
    }

    @Step("Перейти на вкладку новостей")
    public void goNewsPage() {
        news.click();
    }

    @Step("Перейти на вкладку карт")
    public void goCardsPage() {
        cards.click();
    }

    @Step("Перейти на вкладку промокодов")
    public PromocodesPage goPromocodesPage() {
        promocodes.click();
        return new PromocodesPage();
    }

    @Step("Перейти на вкладку заказов")
    public OrdersPage goOrdersPage() {
        orders.click();
        return new OrdersPage();
    }

    @Step("Перейти на вкладку избранного")
    public void goFavoritesPage() {
        favorites.click();
    }

    @Step("Перейти на вкладку бонусов")
    public BonusesPage goBonusesPage() {
        bonuses.click();
        return new BonusesPage();
    }

    @Step("Перейти на вкладку контактов")
    public ContactsPage goContactsPage() {
        contacts.click();
        return new ContactsPage();
    }

    @Step("Перейти на вкладку отзывов")
    public ReviewsPage goFeedbackPage() {
        feedback.click();
        return new ReviewsPage();
    }

    @Step("Перейти на вкладку профиля")
    public void goProfilePage() {
        profile.click();
    }
}
