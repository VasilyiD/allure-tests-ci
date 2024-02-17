package learning.issuetests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static io.qameta.allure.Allure.step;

public class IssueTestWithLambdaSteps {
    private static final String REPOSITORY = "VasilyiD / allure-tests-ci";
    private static final String ISSUENAME = "NEW TEST ISSUE";

    @Test
    void testIssueNameExistWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-target= 'qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys("VasilyiD / allure-tests-ci");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $("[href ='/VasilyiD/allure-tests-ci']").click();
        });
        step("Открываем вкладку Issue", () -> {
            $("#issues-tab").click();
        });
        step("Открываем первую Issue", () -> {
            $("#issue_1_link").click();
        });
        step("Проверяем название первой Issue " + ISSUENAME, () -> {
            $(withText(ISSUENAME)).should(Condition.exist);
        });

    }
}

