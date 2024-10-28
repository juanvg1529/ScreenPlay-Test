package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardUi extends PageObject {

    public static final Target DASHBOARD_MESSAGE = Target.the("welcome message ").located(By.xpath("//h3[@class='text-center']"));

}
