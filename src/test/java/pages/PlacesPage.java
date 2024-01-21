package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PlacesPage {

    private final SelenideElement headerTitle = $(".controls-margin_right-s"),
            selectCityButton = $(".sg-cityButton"),
            cityInput = $(".ClassRegionPopup__headerContainer").$("[type='text']"),
            itemsContainer = $("[data-qa='items-container']"),
            categoriesList = $(".sg-mainWorkspace__contentRow");

    @Step("Открыть страницу регистрации")
    public PlacesPage openPage() {
        open("");
        headerTitle.shouldHave(text("Places and services")); //Места и услуги
        return this;
    }

    @Step("Ввести название города")
    public PlacesPage setCityTitle(String city) {
        selectCityButton.click();
        cityInput.shouldBe(editable, Duration.ofSeconds(6)).setValue(city).pressEnter();
        return this;
    }

    @Step("Выбрать город")
    public PlacesPage selectCity(String city) {
        itemsContainer.$(byText(city)).click();
        return this;
    }

    @Step("Проверить текущий город")
    public PlacesPage checkCity(String city) {
        selectCityButton.shouldHave(text(city.substring(0, city.length() - 2)));
        return this;
    }

    @Step("Проверить отображение сообщения об отсутствии найденных записей города")
    public PlacesPage checkNoFoundRecords() {
        $("[data-qa='hint-EmptyView__title']").shouldHave(text("No records found")); //Не найдено ни одной записи
        return this;
    }

    @Step("Выбрать категорию")
    public CategoryPage selectCategory(String category) {
        categoriesList.$(byText(category)).shouldBe(visible, Duration.ofSeconds(6)).click();
        return new CategoryPage();
    }
}
