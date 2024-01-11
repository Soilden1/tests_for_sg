package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPage {

    SelenideElement companyInput = $(byTagName("input")),
            companyList = $("[data-qa='items-container']");

    @Step("Выбрать компанию")
    public CompanyPage selectCompany(String company) {
        companyInput.setValue(company);
        companyList.$(byText(company)).click();
        return new CompanyPage();
    }
}
