package co.com.screenplay.project.tasks;

import io.cucumber.java.en_old.Ac;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.HomeUI.LOGIN_BUTTON;
import static  co.com.screenplay.project.ui.HomeUI.LOGO_HOMEPAGE;
import static co.com.screenplay.project.utils.Constants.TIME_LOAD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
 import static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class ValidateHome implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO_HOMEPAGE,
                        isVisible()).forNoMoreThan(TIME_LOAD).seconds());

    }

    public static ValidateHome validateHomePage() {
        return instrumented(ValidateHome.class);
    }
}
