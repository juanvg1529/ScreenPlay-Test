package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.IsOrderPresent;
import co.com.screenplay.project.questions.IsProductPurchase;
import co.com.screenplay.project.questions.ValidateLogin;
import co.com.screenplay.project.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import co.com.screenplay.project.utils.Methods;


public class PurchaseMarketPlaceTest {
    @Before
    public void setOnStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("{string} logs in to the webpage with the following credentials:")
    public void the_user_logs_in_to_the_webpage_with_the_following_credentials(String actor, io.cucumber.datatable.DataTable dataTable) {


        Actor currentActor = OnStage.theActorCalled(actor);
        // Obtener las credenciales de la tabla
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String email = "";
        String pwd = "";

        for (Map<String, String> credential : credentials) {
            if ("Email".equals(credential.get("Field"))) {
                email = credential.get("Value");
            } else if ("Password".equals(credential.get("Field"))) {
                pwd = credential.get("Value");
            }
        }

        System.out.println("The user set the credentials = " + email + "," + pwd);

        // Usa la variable currentActor para el login
        currentActor.attemptsTo(LoginWithUserCredentials.Login(email, pwd));
        System.out.println("The user has been able to log in Successfully");
    }

    @Then("{string} should be authenticated successfully")
    public void should_be_authenticated_successfully(String actor) {
        String validationText = OnStage.theActorInTheSpotlight().asksFor(ValidateLogin.getTextValidation());
        Assert.assertTrue(validationText.contains("Welcome to the Dashboard"));
        System.out.println("User Authenticated ");
    }

    @When("{string} searches for the {string}")
    public void searches_for_the(String actor, String product) {
        OnStage.theActorCalled(actor).attemptsTo(SearchProduct.searchProduct(product));
        System.out.println("The " + actor + "search for the item =>" + product);
    }

    @When("{string} selects the {string}")
    public void selects_the(String actor, String product) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} clicks {string}")
    public void clicks(String actor, String action) {
        switch (action) {
            case "Add to Cart":
                System.out.println("Searching for product...");
                OnStage.theActorCalled(actor).attemptsTo(AddToCartProduct.addToCartProduct());
                System.out.println(actor + "Has added the product to the cart");
                break;
            case "Cart":
                System.out.println("user goes to Cart");
                OnStage.theActorCalled(actor).attemptsTo(GoToCart.goToCart());
                System.out.println("Cart Page");
                break;
            default:
                throw new IllegalArgumentException("Action not supported: " + action);
        }

    }

    @When("the {string} provides the following product characteristics:")
    public void the_user_provides_the_following_product_characteristics(String actor, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String size = "";
        String color = "";
        String quantity = "";
        String product = OnStage.theActor(actor).recall("Product");

        for (Map<String, String> row : table) {
            if ("Size".equals(row.get("Characteristic"))) {
                size = row.get("Value");
            }
            if ("Color".equals(row.get("Characteristic"))) {
                color = row.get("Value");
            }
            if ("Quantity".equals(row.get("Characteristic"))) {
                quantity = row.get("Value");
            }
        }
        OnStage.theActorCalled(actor).attemptsTo(ChooseProductCharacteristics.chooseProductCharacteristics(size, color, quantity));
        System.out.println("the user has selected successfully the and proceeds to checkout the info");
    }

    @When("{string} completes the payment")
    public void the_user_proceeds_to_checkout(String actor, DataTable dataTable) {

        OnStage.theActorCalled(actor).attemptsTo(ProceedToCheckout.proceedToCheckout());
        String paymentMethod = "";
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : table) {
            if ("Payment Method".equals(row.get("Field"))) {
                paymentMethod = row.get("Value");
            }
        }
        OnStage.theActorCalled(actor).attemptsTo(CompletePayment.completePayment(paymentMethod));

    }

    @Then("{string} should see the message {string}")
    public void the_user_should_see_the_message(String actor, String stringValidation) {
        String validationMessage = OnStage.theActorInTheSpotlight().asksFor(IsProductPurchase.isProductPurchase());
        Assert.assertEquals(stringValidation, validationMessage);

    }

    @Then("{string} should see the product in the order history of the dashboard")
    public void the_user_should_see_the_product_in_the_order_history_of_the_dashboard(String actor) {
        Boolean validationOrderHistory = OnStage.theActorInTheSpotlight().asksFor(IsOrderPresent.isOrderPresent());
        Assert.assertTrue(validationOrderHistory);
        System.out.println("product present at the order history");

    }


}
