package tests.selenide.tests;

import config.TestBase;
import org.junit.jupiter.api.Test;
import tests.selenide.pages.GitHubPage;

import static data.TestData.issueText;
import static data.TestData.repositoryName;

public class IssueTest extends TestBase {
    GitHubPage gitHubPage = new GitHubPage();

    @Test
    void IssueTextTest() {
        gitHubPage.openPage()
                .search(repositoryName)
                .goToRepository(repositoryName)
                .checkIssueData(issueText);
    }
}
