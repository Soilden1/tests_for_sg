package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.AccordionComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class PlacesPage {

    private final MailRuAuthorizationPage mailRuAuthorizationPage = new MailRuAuthorizationPage();
    private final AccordionComponent accordion = new AccordionComponent();

    private final SelenideElement headerTitle = $(".controls-margin_right-s"),
            selectCityButton = $(".sg-cityButton"),
            cityInput = $(".ClassRegionPopup__headerContainer").$("[type='text']"),
            itemsContainer = $("[data-qa='items-container']"),
            categoriesList = $(".ws-flexbox"),
            findInput = $("[type='text']");

    @Step("Открыть страницу регистрации")
    public PlacesPage openPage() {
        open("");
        headerTitle.shouldHave(text("Places and services")); //Места и услуги
        return this;
    }

    @Step("Выбрать город")
    public PlacesPage selectCity(String city) {
        sleep(500);
        selectCityButton.click();
        sleep(1000);
        cityInput.setValue(city).pressEnter();
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
        sleep(1000);
        cityInput.setValue(notExistCity).pressEnter();
        sleep(1000);
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

    @Step("Авторизоваться через mail.ru")
    public PlacesPage authorizationWithMailRu(String login, String password) {
        accordion.goToLogin();
        $("[data-qa='oauth-List__Mail']").click();
        switchTo().window(1);
        PlacesPage placesPage = mailRuAuthorizationPage.logIn(login, password);
        switchTo().window(0);
        sleep(1000);
        return placesPage;
    }

    @Step("Найти место или компанию")
    public CompanyPage findPlaceOrCompany(String value) {
        findInput.setValue(value);
        sleep(3000);
        $(byAttribute("title", value)).click();
        CompanyPage companyPage = new CompanyPage();
        companyPage.checkTitle(value);
        return companyPage;
    }
}
