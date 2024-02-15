package learning.allure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

        @Test
        public void testIssueSearch() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com/");

            $("[data-target= 'qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();
            $("[href ='/eroshenkoam/allure-example']").click();
            $("#issues-tab").click();
            $(withText("#87")).should(Condition.exist);


        }
    }
