package co.com.screenplay.project.tasks;

import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static  co.com.screenplay.project.ui.HomeUI.LOGO_HOMEPAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
 import static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class ValidateHome implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO_HOMEPAGE, WebElementStateMatchers.isEnabled()).forNoMoreThan(TIME_SHORT).seconds()
        );
    }

    public static ValidateHome validateHomePage() {
        return instrumented(ValidateHome.class);
    }
}
