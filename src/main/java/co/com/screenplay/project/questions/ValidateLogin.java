package co.com.screenplay.project.questions;

import co.com.screenplay.project.tasks.ValidateHome;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;

import static co.com.screenplay.project.ui.DashboardUi.DASHBOARD_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class ValidateLogin implements Question<String> {

    @Override
    public String answeredBy(@NotNull Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(DASHBOARD_MESSAGE,isEnabled()).forNoMoreThan(TIME_SHORT).seconds());
        return  DASHBOARD_MESSAGE.resolveFor(actor).getText();
    }
    public static ValidateLogin getTextValidation(){
        return new ValidateLogin();
    }


}
