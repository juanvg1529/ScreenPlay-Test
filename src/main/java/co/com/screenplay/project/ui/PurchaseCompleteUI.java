package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PurchaseCompleteUI extends PageObject
{
    public static final Target MESSAGE_CONGRATS = Target.the("congratulations message").located(By.xpath("//h3[text()=\"Congratulation! Payment is successful.\"]"));
    public static final Target BACK_TO_DASHBOARD_BUTTON = Target.the("back to dashboard").located(By.xpath("//a[@class=\"btn btn-success\"]"));
}
