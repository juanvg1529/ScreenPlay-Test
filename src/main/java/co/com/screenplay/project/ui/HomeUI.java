package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomeUI extends PageObject
{
    public static final Target LOGO_HOMEPAGE= Target.the("Logo").located(By.xpath("//div[@class='col-md-4 logo']") );
    public static final Target LOGIN_BUTTON= Target.the("Login Button").located(By.xpath("//a[normalize-space()='Login']") );
}
