package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.HomeUI.LOGIN_BUTTON;
import static co.com.screenplay.project.ui.HomeUI.LOGO_HOMEPAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import  static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class FunctionElementsTask implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LOGIN_BUTTON,isEnabled()).forNoMoreThan(TIME_SHORT).seconds(), Click.on(LOGIN_BUTTON));
    }

    public static FunctionElementsTask choose(){
        return Tasks.instrumented(FunctionElementsTask.class);
    }
}
