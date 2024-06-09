package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPage {

    private final SelenideElement companyInput = $(byTagName("input")),
            companyList = $("[data-qa='items-container']"),
            categoryList = $(".sg-CompilationViewHeader__head-title");

    @Step("Проверить текущую категорию")
    public CategoryPage checkCategory(String category) {
        categoryList.shouldHave(text(category));
        return this;
    }

    @Step("Выбрать компанию")
    public CompanyPage selectCompany(String company) {
        companyInput.shouldBe(editable, Duration.ofSeconds(6)).setValue(company);
        companyList.$(byText(company)).click();
        return new CompanyPage();
    }
}
