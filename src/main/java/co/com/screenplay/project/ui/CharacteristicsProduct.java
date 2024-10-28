package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CharacteristicsProduct extends PageObject {

    public static final Target SELEC_SIZE= Target.the("Select size").located(By.xpath("//span[@id='select2-size_id-h9-container']"));
    public static final Target SELEC_COLOR= Target.the("Select color").located(By.xpath("//span[@id='select2-color_id-4j-container']"));
    public static final Target SELEC_QUANTITY= Target.the("Select quantity").located(By.xpath("//input[@title='Qty']"));

    public static final Target SEARCH_FIELD= Target.the("search field").located(By.xpath("//input[@class='select2-search__field']"));
    public static final Target ARROW_FIELD= Target.the("search field").located(By.xpath("//input[@class='select2-selection__arrow']"));
}
