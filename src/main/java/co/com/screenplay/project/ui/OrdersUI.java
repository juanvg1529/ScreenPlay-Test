package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrdersUI extends PageObject {

    public static final Target ORDER_HISTORY = Target.the("history title").located(By.xpath("//button[text()='Orders']"));

    public static final Target PRODUCT_DETAILS = Target.the( "product details").located(By.xpath("//td[contains(text(), 'Product Name: Amazfit GTS 3 Smart Watch for Android iPhone')]\n"));
}
