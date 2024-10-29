package co.com.screenplay.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;


import static co.com.screenplay.project.utils.Methods.randomNumber;
import static co.com.screenplay.project.ui.PaymentUi.*;
import static co.com.screenplay.project.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;;

public class CompletePayment implements Task {
    private String paymentMethod;


    public CompletePayment(String paymentMethod) {
        this.paymentMethod = paymentMethod;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(VALIDATION_PAYMENT_PAGE, isEnabled()).forNoMoreThan(TIME_SHORT).seconds());
        String UUID = Integer.toString(randomNumber());
        String product = actor.recall("Product");
        String xpathProduct = "//td[text()='" + product + "']";
        Target PRODUCT_PURCHASE = Target.the("product to buy").located(By.xpath(xpathProduct));
        if (PRODUCT_PURCHASE.resolveFor(actor).getText().equals(product)) {
            actor.attemptsTo(SelectFromOptions.byVisibleText(paymentMethod).from(SELECT_PAYMENT_METHOD));
            actor.attemptsTo(WaitUntil.the(DESCRIPTION_FIELD, isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                    Enter.theValue(UUID).into(INPUT_UUID),
                    Scroll.to(PAYMENT_BUTTON),
                    Click.on(PAYMENT_BUTTON));

        }
    }

    public static CompletePayment completePayment(String paymentMethod) {
        return Instrumented.instanceOf(CompletePayment.class).withProperties(paymentMethod);
    }

}
