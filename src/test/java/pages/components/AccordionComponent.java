package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.FavoritesPage;
import pages.PlacesPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AccordionComponent {

    private final SelenideElement places = $("[data-qa='Места']"),
            news = $("[data-qa='News']"), //Новости
            cards = $("[data-qa='Cards']"), //Карты
            orders = $("[data-qa='Purchases']"), //Покупки
            favorites = $("[data-qa='Favorites']"), //Избранное
            contacts = $("[data-qa='Chats']"), //Чаты
            feedback = $("[data-qa='Reviews']"), //Отзывы
            //login = $("[data-name='profile']"), //Войти
            profile = $("[data-name='profile']"); //Профиль

    @Step("Перейти на страницу 'Места'")
    public PlacesPage goToPlaces() {
        places.click();
        return new PlacesPage();
    }

    @Step("Нажать на кнопку 'Профиль' для авторизации")
    public void goToLogin() {
        profile.click();
    }

    @Step("Перейти на страницу 'Профиль'")
    public void goToProfile() {
        profile.click();
        $("[name='headerContent']").shouldHave(text("Profile")); //Профиль
    }

    @Step("Перейти на страницу 'Избранное'")
    public FavoritesPage goToFavorites() {
        favorites.click();
        return new FavoritesPage();
    }
}
