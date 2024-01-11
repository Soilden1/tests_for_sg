package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FavoritesPage {

    private final SelenideElement contentList = $("[data-qa='items-container']");

    @Step("Проверить наличие места или компании в избранных")
    public FavoritesPage checkPlaceOrCompany(String placeOrCompany) {
        sleep(2000);
        Assertions.assertTrue(contentList.$("[data-qa='item']").isDisplayed());
        return this;
    }

    @Step("Выбрать компанию")
    public CompanyPage selectCompany(String placeOrCompany) {
        $(byText(placeOrCompany)).click();
        return new CompanyPage();
    }
}
