package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductUi extends PageObject {

    public static final Target PRODUCT = Target.the("product box").located(By.xpath("//div[@class='col-md-3 item item-search-result']"));
    public static final Target PRODUCT_ADD_TO_CART = Target.the("add to cart product").located(By.xpath("//a[normalize-space()='Add to Cart']"));
}
