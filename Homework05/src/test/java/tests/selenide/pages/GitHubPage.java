package tests.selenide.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPage {

    public GitHubPage openPage() {
        open("https://github.com");
        return this;
    }

    public GitHubPage search(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").val(repository).pressEnter();
        return this;
    }

    public GitHubPage goToRepository(String repository) {
        $x("//*[contains(@href,'/" + repository + "')]").click();
        return this;
    }

    public void checkIssueData(String issueName) {
        $(withText("Issues")).click();
        $x("//a[text()='" + issueName + "']").shouldBe(visible);
    }
}
