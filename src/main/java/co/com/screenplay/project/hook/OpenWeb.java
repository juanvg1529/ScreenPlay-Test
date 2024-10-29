package co.com.screenplay.project.hook;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.screenplay.project.utils.Constants.WEB_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb implements Task {

    //variables


    private EnvironmentVariables environmentVariables;

    public OpenWeb() {

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathWebURL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);

        if (pathWebURL == null || pathWebURL.isEmpty()) {
            throw new IllegalArgumentException("La URL del entorno no está configurada o está vacía.");
        }
      pathWebURL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);
        actor.attemptsTo(Open.url(pathWebURL));
    }

    public static Performable browseURL() {
        return instrumented(OpenWeb.class);
    }


}
