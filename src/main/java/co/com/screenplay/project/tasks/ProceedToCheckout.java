package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.screenplay.project.ui.NavigationBarUi.*;
import static co.com.screenplay.project.ui.CheckoutUi.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.utils.Constants.*;

public class ProceedToCheckout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        String product = actor.recall("Product");
        String xpathProduct="//td[text()='"+product+"']";
        Target PRODUCT_CHECKOUT= Target.the("product").located(By.xpath(xpathProduct));
        String validationProduct=PRODUCT_CHECKOUT.resolveFor(actor).getText();
        if( validationProduct.equals(product)){

            try {
                actor.attemptsTo(WaitUntil.the(PRODUCT_CHECKOUT,isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                        Click.on(CHECKOUT_OPTION));
            }catch (Exception exception){
                System.err.println(exception.getMessage());
            }

        }
    }

    public static ProceedToCheckout proceedToCheckout(){
        return Tasks.instrumented(ProceedToCheckout.class);
    }
}
