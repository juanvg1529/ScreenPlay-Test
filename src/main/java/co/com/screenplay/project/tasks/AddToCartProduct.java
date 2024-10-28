package co.com.screenplay.project.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.ProductUi.PRODUCT_ADD_TO_CART;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.ui.ProductUi.PRODUCT;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class AddToCartProduct implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String product= actor.recall("Product");
        actor.attemptsTo(WaitUntil.the(PRODUCT,isEnabled()).forNoMoreThan(TIME_SHORT).seconds());
        String xpathProduct = "//a[normalize-space()="+"'"+product+"'"+"]";
        Target elementProduct = Target.the("productName").located(By.xpath(xpathProduct));
        String validationProducteSelected=  elementProduct.resolveFor(actor).getText();
        if( validationProducteSelected.contains(product)){
            actor.attemptsTo(Click.on(PRODUCT_ADD_TO_CART));
        }

    }
    public static AddToCartProduct addToCartProduct(){
        return Tasks.instrumented(AddToCartProduct.class);
    }

}
