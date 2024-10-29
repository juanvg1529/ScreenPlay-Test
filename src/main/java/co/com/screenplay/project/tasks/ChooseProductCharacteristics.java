package co.com.screenplay.project.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static co.com.screenplay.project.ui.CharacteristicsProduct.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;

public class ChooseProductCharacteristics implements Task {

    private String size;
    private String color;
    private String quantity;

    public ChooseProductCharacteristics(String size, String color, String quantity) {
        this.size = size;
        this.color = color;
        this.quantity = quantity;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String xpathProduct = "//h2[text()=\"" + actor.recall("Product") + "\"]";

        actor.attemptsTo(WaitUntil.the(By.xpath(xpathProduct),isEnabled()).forNoMoreThan(TIME_SHORT).seconds(),
                SelectFromOptions.byVisibleText(size).from(SIZE_SELECT),
                SelectFromOptions.byVisibleText(color).from(SELECT_COLOR),
                Enter.theValue(quantity).into(SELECT_QUANTITY),
                Click.on(ADD_TO_CART_BUTTON));

    }

    public static ChooseProductCharacteristics chooseProductCharacteristics(String size,String color, String quantity){
        return Instrumented.instanceOf(ChooseProductCharacteristics.class).withProperties(size,color,quantity);
    }
}
