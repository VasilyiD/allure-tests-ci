package learning.issuetests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;



public class IssueTestWithSteps {

    private static final String REPOSITORY = "VasilyiD / allure-tests-ci";
    private static final String ISSUENAME = "NEW TEST ISSUE";
    @Test
    public void testIssueNameExistWithAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsIssueNameTest steps = new WebStepsIssueNameTest();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink();
        steps.openIssuesTab();
        steps.openFirstIssue();
        steps.issueNameShouldExist(ISSUENAME);
    }
}
