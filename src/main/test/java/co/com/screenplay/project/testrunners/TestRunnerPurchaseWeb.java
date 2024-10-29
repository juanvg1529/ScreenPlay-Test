package co.com.screenplay.project.testrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/main/test/resources/features/purchase.feature",
        glue="co.com.screenplay.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@successful"

)
public class TestRunnerPurchaseWeb {
    @Managed
    WebDriver driver;
}
