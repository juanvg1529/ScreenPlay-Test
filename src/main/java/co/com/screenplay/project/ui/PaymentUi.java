package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentUi extends PageObject {

    public static final Target VALIDATION_PAYMENT_PAGE = Target.the("validation displayed payment page").located(By.xpath("//h3[text()=\"Billing Address\"]"));
    public static final Target SELECT_PAYMENT_METHOD = Target.the("select payment method").located(By.xpath("//select[@name=\"payment_method\"]"));
    public static final Target DESCRIPTION_FIELD = Target.the("description mail").located(By.xpath("//label[text()='Send to this Details']"));
    public static final Target INPUT_UUID = Target.the("input UUID").located(By.xpath("//textarea[@class='form-control']"));
    public static final Target PAYMENT_BUTTON = Target.the("payment button").located(By.xpath("//input[@name='form3']"));

}
