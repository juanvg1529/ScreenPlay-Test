package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class NavigationBarUi extends PageObject {

    public static final Target SEARCH_FIELD = Target.the("search field").located(By.xpath("//input[@class='form-control search-top']"));
    public static final Target SEARCH_BUTTON = Target.the("search button").located(By.xpath("//button[@class='btn btn-danger']"));


}
