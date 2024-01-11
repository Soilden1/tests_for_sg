package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.FavoritesPage;
import pages.PlacesPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AccordionComponent {

    private final SelenideElement places = $("[data-qa='Места']"),
            news = $("[data-qa='Новости']"),
            cards = $("[data-qa='Карты']"),
            orders = $("[data-qa=\"Покупки\"]"),
            favorites = $("[data-qa=\"Favorites\"]"), //Избранное
            contacts = $("[data-qa=\"Чаты\"]"),
            feedback = $("[data-qa=\"Отзывы\"]"),
            login = $("[data-name='profile']"), //Войти
            profile = $("[data-name='profile']"); //Профиль

    @Step("Перейти на страницу 'Места'")
    public PlacesPage goToPlaces() {
        places.click();
        return new PlacesPage();
    }

    @Step("Нажать на кнопку 'Войти' для авторизации")
    public void goToLogin() {
        login.click();
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
