package co.com.screenplay.project.stepdefinition;

import co.com.screenplay.project.questions.ValidateLogin;
import co.com.screenplay.project.tasks.AddToCartProduct;
import co.com.screenplay.project.tasks.FunctionElementsTask;
import co.com.screenplay.project.tasks.LoginWithUserCredentials;
import co.com.screenplay.project.tasks.SearchProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Exception;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class PurchaseMarketPlaceTest {
    @Before
    public void setOnStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @When("{} logs in to the webpage with the following credentials:")
    public void the_user_logs_in_to_the_webpage_with_the_following_credentials(String actor,io.cucumber.datatable.DataTable dataTable) {

        OnStage.theActorCalled(actor).attemptsTo(FunctionElementsTask.choose());

        List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
        String email = "";
        String pwd = "";

        for (Map<String, String> credential : credentials) {
            if ("Email".equals(credential.get("Field"))) {
                email = credential.get("Value");
            } else if ("Password".equals(credential.get("Field"))) {
                pwd = credential.get("Value");
            }
        }

        System.out.println("The user set the credentials = "+email+","+pwd);
        OnStage.theActorCalled(actor).attemptsTo(LoginWithUserCredentials.Login(email,pwd));
        System.out.println("The user has been able to log in Succesfull");
    }
    @Then("{} should be authenticated successfully")
    public void should_be_authenticated_successfully(String actor) {
      String validationText = OnStage.theActorInTheSpotlight().asksFor(ValidateLogin.getTextValidation());
        Assert.assertTrue(validationText.contains("Welcome to the Dashboard"));
    }
    @When("{} searches for the {}")
    public void searches_for_the(String actor, String product) {
        OnStage.theActorCalled(actor).attemptsTo(SearchProduct.searchProduct(product));
        System.out.println("The "+actor+"search for the item =>"+product);
    }
    @When("{} selects the {}")
    public void selects_the(String actor, String product) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("{} clicks {string}")
    public void clicks(String actor, String action)
    {

            switch (action){
                case "Add to Cart":
                    OnStage.theActorCalled(actor).attemptsTo(AddToCartProduct.addToCartProduct());
                    System.out.println(actor +"Has added the product to the cart");
                    break;
                case "Pay Now":
                    break;
                case "Add to Cart the product":
                    break;
                default:
                    throw new IllegalArgumentException("Action not supported: " + action);
            }

    }
    @When("the {} provides the following product characteristics:")
    public void the_user_provides_the_following_product_characteristics(String actor, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> table= dataTable.asMaps(String.class,String.class);
        String size="";
        String color="";
        String quantity="";
        String product= OnStage.theActor(actor).recall("Product");


        for(Map<String,String> row:table){
            if("Size".equals(row.get("Field"))){
                size=row.get("Value");
            }
            if("Color".equals(row.get("Field"))){
                color=row.get("Value");
            }
            if("Quantity".equals(row.get("Field"))){
                quantity=row.get("Value");
            }
            String[] newSize= size.split("/");
            String sizeObtained= product.contains("phone")?newSize[0]:newSize[1];




        }


    }

    @When("{} proceeds to checkout")
    public void the_user_proceeds_to_checkout(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> table= dataTable.asMaps(String.class,String.class);

    }

    @Then("{} should see the message {string}")
    public void the_user_should_see_the_message(String actor, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{} should see the product in the order history of the dashboard")
    public void the_user_should_see_the_product_in_the_order_history_of_the_dashboard( String actor) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
