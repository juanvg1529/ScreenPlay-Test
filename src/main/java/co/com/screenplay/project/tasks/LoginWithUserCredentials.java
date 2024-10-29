package co.com.screenplay.project.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.htmlunit.jetty.util.security.Password;
import org.openqa.selenium.By;


import static co.com.screenplay.project.ui.Login.*;
import static co.com.screenplay.project.ui.HomeUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;


public class LoginWithUserCredentials implements Task {

    private String username;
    private String password;

    public LoginWithUserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGIN_BUTTON),
                WaitUntil.the(NAME_FIElD, isEnabled()).
                        forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(username).into(NAME_FIElD),
                Enter.theValue(password).into(PWD_FIElD),
                Click.on(SUBMIT_BUTTON));


    }

    public static LoginWithUserCredentials Login(String username, String password) {
        return Instrumented.instanceOf(LoginWithUserCredentials.class).withProperties(username, password);
    }
}
