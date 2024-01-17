package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class PlacesPage {

    private final SelenideElement headerTitle = $(".controls-margin_right-s"),
            selectCityButton = $(".sg-cityButton"),
            cityInput = $(".ClassRegionPopup__headerContainer").$("[type='text']"),
            itemsContainer = $("[data-qa='items-container']"),
            categoriesList = $(".ws-flexbox");

    @Step("Открыть страницу регистрации")
    public PlacesPage openPage() {
        open("");
        headerTitle.shouldHave(text("Places and services")); //Места и услуги
        return this;
    }

    @Step("Выбрать город")
    public PlacesPage selectCity(String city) {
        selectCityButton.click();
        cityInput.shouldBe(editable, Duration.ofSeconds(4)).setValue(city).pressEnter();
        itemsContainer.$(byText(city)).click();
        return this;
    }

    @Step("Проверить текущий город")
    public PlacesPage checkCity(String city) {
        selectCityButton.shouldHave(text(city.substring(0, city.length() - 2)));
        return this;
    }

    @Step("Выбрать несуществующий город")
    public PlacesPage selectNotExistCity(String notExistCity) {
        selectCityButton.click();
        cityInput.setValue(notExistCity).pressEnter();
        step("Проверить наличие сообщения об отсутствии найденных записей", () ->
                $("[data-qa='hint-EmptyView__title']").shouldHave(text("No records found"))); //Не найдено ни одной записи
        return this;
    }

    @Step("Выбрать категорию")
    public CategoryPage selectCategory(String category) {
        categoriesList.$(byText(category)).click();
        step("Проверить текущую категорию", () ->
                $(".sg-CompilationViewHeader__head-title").shouldHave(text(category)));
        return new CategoryPage();
    }
}
