package learning.issuetests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsIssueNameTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[data-target= 'qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория  {repo}")
    public void clickOnRepositoryLink() {
        $("[href ='/VasilyiD/allure-tests-ci']").click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Открываем первую Issue")
    public  void openFirstIssue() {$("#issue_1_link").click();}

    @Step("Проверяем наличие Issue с номером {issue}")
    public void issueNameShouldExist(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
