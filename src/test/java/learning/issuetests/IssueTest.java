package learning.issuetests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueTest {
    @Test
    @Feature("Название Issue в репозитории")
    @Story("Проверка названия первой Issue")
    @Owner("VasilyiD")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Testing", url = "https://github.com/")
    @DisplayName("Проверка названия первого Issue в репозитории пользователя")
    public void testIssueNameExist() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");

        $("[data-target= 'qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys("VasilyiD / allure-tests-ci");
        $("#query-builder-test").submit();
        $("[href ='/VasilyiD/allure-tests-ci']").click();
        $("#issues-tab").click();
        $("#issue_1_link").click();
        $(withText("NEW TEST ISSUE")).should(Condition.exist);
    }
}
