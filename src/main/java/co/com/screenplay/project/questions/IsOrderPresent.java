package co.com.screenplay.project.questions;

import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.OrdersUI.*;
import static co.com.screenplay.project.ui.HomeUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.utils.Constants.*;

public class IsOrderPresent implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
    actor.attemptsTo(Click.on(ORDERS_BUTTON),
            WaitUntil.the(ORDER_HISTORY,isEnabled()).forNoMoreThan(TIME_SHORT).seconds());

        return PRODUCT_DETAILS.resolveFor(actor).isVisible();
    }
    public static IsOrderPresent isOrderPresent(){
        return new IsOrderPresent();
    }
}
