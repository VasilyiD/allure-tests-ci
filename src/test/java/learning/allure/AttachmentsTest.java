package learning.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "87";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-target= 'qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $("[href ='/eroshenkoam/allure-example']").click();
        });
        step("Открываем таб Issuee", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }
        @Test
        public void testAnnotatedStep() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps steps = new WebSteps();

            steps.openMainPage();
            steps.searchForRepository(REPOSITORY);
            steps.clickOnRepositoryLink(REPOSITORY);
            steps.openIssuesTab();
            steps.shouldSeeIssueWithNumber(ISSUE);
        }



 /*  step("Что-то делаем", new Allure.ThrowableContextRunnableVoid<Allure.StepContext>() {
                @Override
                public void run(Allure.StepContext stepContext) throws Throwable {

                }
            });*/

    }