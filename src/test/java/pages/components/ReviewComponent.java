package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ReviewComponent {

    private final SelenideElement orderItem = $("[data-qa='item']"),
            rateStar = $("[data-qa='rating__star']"),
            submitButton = $(byText("Отправить")),
            reviewVisibility = $(byText("Опубликовать для всех"));

    @Step("Выбрать покупку")
    public ReviewComponent selectOrder() {
        orderItem.click();
        return this;
    }

    @Step("Поставить оценку")
    public ReviewComponent selectRate() {
        rateStar.click();
        return this;
    }

    @Step("Отправить отзыв")
    public ReviewComponent sendReview() {
        submitButton.click();
        return this;
    }

    @Step("Выбрать видимость отзыва")
    public ReviewComponent selectReviewVisibility() {
        reviewVisibility.click();
        return this;
    }
}
