package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CharacteristicsProduct extends PageObject {

    public static final Target SIZE_SELECT = Target.the("Select size").located(By.xpath("//select[@name='size_id']"));
    public static final Target SELECT_COLOR = Target.the("Select color").located(By.xpath("//select[@name='color_id']"));
    public static final Target SELECT_QUANTITY = Target.the("Select quantity").located(By.xpath("//input[@class='input-text qty']"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button").located(By.xpath("//input[@Value=\"Add to Cart\"]"));

    public static final Target SEARCH_FIELD= Target.the("search field").located(By.xpath("//input[@class='select2-search__field']"));
    public static final Target ARROW_FIELD= Target.the("search field").located(By.xpath("//input[@class='select2-selection__arrow']"));
}
