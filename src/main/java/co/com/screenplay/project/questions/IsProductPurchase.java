package co.com.screenplay.project.questions;

import io.cucumber.java.bs.A;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.screenplay.project.ui.PurchaseCompleteUI.BACK_TO_DASHBOARD_BUTTON;
import static co.com.screenplay.project.ui.PurchaseCompleteUI.MESSAGE_CONGRATS;
import static co.com.screenplay.project.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class IsProductPurchase implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String congratsMessage =MESSAGE_CONGRATS.resolveFor(actor).getText();
        actor.attemptsTo(WaitUntil.the(MESSAGE_CONGRATS,isEnabled()).forNoMoreThan(TIME_SHORT).seconds());
        actor.attemptsTo(Click.on(BACK_TO_DASHBOARD_BUTTON));


        return congratsMessage;
    }
    public static IsProductPurchase isProductPurchase(){
        return  new IsProductPurchase();
    }
}
