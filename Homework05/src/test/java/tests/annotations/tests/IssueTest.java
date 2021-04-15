package tests.annotations.tests;

import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.annotations.steps.GitHubSteps;

import static data.TestData.issueText;
import static data.TestData.repositoryName;

@DisplayName("Issue tests with annotations")
public class IssueTest extends TestBase {
    GitHubSteps gitHubSteps = new GitHubSteps();

    @Test
    @DisplayName("Checking issue name")
    void IssueTextTest() {
        gitHubSteps.openPage();
        gitHubSteps.search(repositoryName);
        gitHubSteps.goToRepository(repositoryName);
        gitHubSteps.checkIssueData(issueText);
    }
}
