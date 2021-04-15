package tests.lambda;

import config.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.issueText;
import static data.TestData.repositoryName;
import static io.qameta.allure.Allure.step;

public class IssueTest extends TestBase {

    @Test
    void IssueTextTest() {

        step("Open github page", () -> open("/"));

        step("Search for " + repositoryName, (step) -> {
            step.parameter("Repository name", repositoryName);
            $(byName("q")).setValue(repositoryName).submit();
        });

        step("Click on link with text " + repositoryName, (step) -> {
            step.parameter("Link text", repositoryName);
            $(".codesearch-results").$(byLinkText(repositoryName)).click();
        });

        step("Go to issues tab", () -> $("[data-content=Issues]").click());

        step("Check issue name present" + issueText, (step) -> {
            step.parameter("Issue name", issueText);
            $("div[aria-label=Issues]").$(byLinkText(issueText)).shouldBe(visible);
        });
    }

}
