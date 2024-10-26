package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.htmlunit.jetty.util.security.Password;
@AllArgsConstructor
public class LoginWithUserCredentials implements Task {

    private String username;
    private String Password;
    @Override
    public <T extends Actor> void performAs(T actor) {

    }
    public static LoginWithUserCredentials Login (String username, String password){
        return Tasks.instrumented(LoginWithUserCredentials.class);
    }
}
