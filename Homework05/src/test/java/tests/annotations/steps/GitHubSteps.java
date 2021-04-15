package tests.annotations.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSteps {

    @Step("Открываем главную страницу Гитхаб")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Вводим {repository} в строку поиска")
    public void search(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").val(repository).pressEnter();
    }

    @Step("Открываем репозиторий {repository}")
    public void goToRepository(String repository) {
        $x("//*[contains(@href,'/" + repository + "')]").click();
    }

    @Step("Проверяем что Issue с названием {issueName} существует")
    public void checkIssueData(String issueName) {
        $(withText("Issues")).click();
        $x("//a[text()='" + issueName + "']").shouldBe(visible);
    }
}
