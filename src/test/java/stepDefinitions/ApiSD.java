package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import steps.ApiSteps;

import static net.serenitybdd.rest.SerenityRest.given;

public class ApiSD {

    @Steps
    ApiSteps steps;

    @When("ejecuta la creacion {string}")
    public void ejecutaLaCreacion(String api) {
        steps.executeCreation(api);
    }

    @And("inicializo request")
    public void inicializoRequestEnPost() {
        steps.inicializoParametrosRequest();
    }

    @And("inserto los valores de la mascota nombre {string} ,  photoUrls {string} y status{string}")
    public void insertoLosValoresDelaMascota(String name, String photoUrls, String status) {
        steps.insertUsers(name, photoUrls, status);
    }

    @And("ejecuta la peticion {string}")
    public void ejecutaPeticion(String api){
        steps.enviarRequestGet(api);
    }

    @Then("valida que la respuesta es {int}")
    public void validaQueLaRespuestaEs(int code) {
        steps.validaCode(code);
    }
    @And("valida el {string} sea {string}")
    public void validaValores(String var1, String var2 , String var3) {
        steps.validoValores(var1,var2, var3);
    }


    @When("obtengo el id pokemon {int}")
    public void obtengoelnombrePokemon(int var) {steps.obtengoelnombreMascota(var);
    }

    @And("verifico el ability id")
    public void verificoElAbilityId() {steps.verificoelabilityId();

    }

    @And("verifico su base_experience")
    public void verificoSuBase_experience() {steps.verificosubase_experience();
    }


}
