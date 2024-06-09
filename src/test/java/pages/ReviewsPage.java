package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ReviewsPage {

    private final SelenideElement reviewList = $("[name='viewContainer']");

    @Step("Проверить наличие отзыва")
    public ReviewsPage checkReviewByCompany(String companyTitle) {
        reviewList.shouldHave(text(companyTitle));
        return this;
    }
}
