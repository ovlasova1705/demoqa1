package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public ResultTableComponent checkResultTableHeader() {
        $("#example-modal-sizes-title-lg").
                shouldHave(text("Thanks for submitting the form"));

        return this;
    }
    public ResultTableComponent checkResult(String key, String value) {
        $(".table-responsive").
                $(byText(key)).parent().shouldHave(text(value));

        return this;
    }


}
