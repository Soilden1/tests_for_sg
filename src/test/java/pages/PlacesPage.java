package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PlacesPage {

    private final SelenideElement headerTitle = $(".controls-margin_right-s"),
            selectCityButton = $(".sg-cityButton"),
            cityInput = $(".ClassRegionPopup__headerContainer").$("[type='text']"),
            itemsContainer = $("[data-qa='items-container']"),
            categoriesList = $(".ws-flexbox"),
            authButton = $("[data-qa='Войти']"),
            profileButton = $("[data-qa='Профиль']"),
            emptyMessageArea = $("[data-qa='hint-EmptyView__title']"),
            userAgreement = $(".sg-Footer__userAgreement"),
            userAgreementTitle = $("[data-qa='docview3-CommandPanel__rename']");

    @Step("Открыть страницу регистрации")
    public PlacesPage openPage() {
        open("");
        headerTitle.shouldHave(text("Места и услуги")); //Места и услуги Places and services
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
        emptyMessageArea.shouldHave(text("Не найдено ни одной записи")); //Не найдено ни одной записи No records found
        return this;
    }

    @Step("Выбрать категорию")
    public CategoryPage selectCategory(String category) {
        categoriesList.$(byText(category)).click();
        return new CategoryPage();
    }

    @Step("Перейти на страницу авторизации")
    public AuthorizationPage goAuthorizationPage() {
        authButton.click();
        return new AuthorizationPage();
    }

    @Step("Перейти на страницу профиля")
    public ProfilePage goProfilePage() {
        profileButton.click();
        return new ProfilePage();
    }

    @Step("Открыть пользовательское соглашение")
    public void openUserAgreement() {
        userAgreement.click();
        userAgreementTitle.shouldHave(text("Пользовательское соглашение сайта.docx"));
    }

    @Step("Открыть страницу заведения")
    public CompanyPage openCompanyPage(String title) {
        $("[title='" + title + "']").click();
        sleep(1000);
        return new CompanyPage();
    }
}
