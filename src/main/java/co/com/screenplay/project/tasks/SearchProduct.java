package co.com.screenplay.project.tasks;

import co.com.screenplay.project.ui.NavigationBarUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.screenplay.project.ui.NavigationBarUi.SEARCH_BUTTON;
import static co.com.screenplay.project.ui.NavigationBarUi.SEARCH_FIELD;
public class SearchProduct implements Task {

    private String product;

    public SearchProduct(String product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(product).into(SEARCH_FIELD),
                Click.on(SEARCH_BUTTON));
        actor.remember("Product",product);

    }

    public static SearchProduct searchProduct(String product){
        return Instrumented.instanceOf(SearchProduct.class).withProperties(product);
    }
}
