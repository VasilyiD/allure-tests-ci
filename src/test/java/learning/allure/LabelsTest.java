package learning.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "87";

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });

    }
        @Test
        public void testAnnotatedAttachments() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps steps = new WebSteps();

            steps.openMainPage();
            steps.takeScreenshot();
        }



 /*  step("Что-то делаем", new Allure.ThrowableContextRunnableVoid<Allure.StepContext>() {
                @Override
                public void run(Allure.StepContext stepContext) throws Throwable {

                }
            });*/

    }