package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login extends PageObject {

    public static final Target NAME_FIElD = Target.the("name input").located(By.xpath("//input[@name='cust_email']"));
    public static final Target PWD_FIElD = Target.the("pwd input").located(By.xpath("//input[@name='cust_password']"));
    public static final Target CUSTOMER_LOGIN = Target.the("customer input").located(By.xpath("//h1[text()=\"Customer Login\"]"));
    public static final Target SUBMIT_BUTTON = Target.the("submit button").located(By.xpath("//input[@class='btn btn-success']"));

}
