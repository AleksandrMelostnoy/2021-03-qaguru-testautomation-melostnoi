import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSoftAssertionsExampleTest {

    @Test
    void junit5ExamplePresentOnSoftAssertionsPagesTest() {

        // Given / Open site
        open("https://github.com/selenide/selenide");

        // When
        $x("//*[@data-content='Wiki']").click();
        // Then
        ElementsCollection softAssertionsPages = $$x("//ul[@data-filterable-for='wiki-pages-filter']/li/*/*")
                .filterBy(href("/selenide/selenide/wiki/SoftAssertions")).shouldHaveSize(1);

        // When
        softAssertionsPages.first().click();
        // Then
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
    }
}
