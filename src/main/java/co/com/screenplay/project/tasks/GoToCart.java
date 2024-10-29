package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.screenplay.project.ui.NavigationBarUi.CART_BUTTON;

public class GoToCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_BUTTON));
    }
    public static GoToCart goToCart(){
        return Tasks.instrumented(GoToCart.class);
    }
}
