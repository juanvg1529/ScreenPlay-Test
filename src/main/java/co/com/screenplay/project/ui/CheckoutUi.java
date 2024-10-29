package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutUi  extends PageObject {

    public static final Target CHECKOUT_OPTION = Target.the("checkout button").located(By.xpath("//a[normalize-space()='Proceed to Checkout']"));
}
