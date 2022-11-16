package steps;

import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static commons.Constantes.*;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApiSteps {

    private static final Logger logger = LoggerFactory.getLogger(ApiSteps.class);

    private static RequestSpecification requestSpecification;
    //private static ResponseSpecification responseSpecification;

    private Response response;
    private RequestSpecBuilder builder;
    private String bodyPost;

    @Step("inicializo request")
    public void inicializoParametrosRequest(){
        RestAssured.baseURI = URL_BASE;
        builder = new RequestSpecBuilder();
        requestSpecification = builder.build();
    }





    public void addHeader(){
       builder.addHeader(HEADER,VALUE_HEADER);
    }

    public void insertUsers(String name, String photoUrls, String status){
        addHeader();
        JsonObject parametros = new JsonObject();
        parametros.addProperty("name", name);
        parametros.addProperty("photoUrls", photoUrls);
        parametros.addProperty("status", status);

        bodyPost = parametros.toString();
        builder.setBody(bodyPost);

        executeCreation(API);
    }
    public void executeCreation(String api){
        response = given().spec(requestSpecification).when().post(api);
    }

    public void validaCode(int code){
        assertThat(lastResponse().statusCode(), is(code));
    }

    public void validoValores(String name, String photoUrls, String status){
        assertThat(response.body().path(name), CoreMatchers.equalTo(photoUrls), CoreMatchers.equalTo(status));
    }

    public void enviarRequestGet(String api){
        response = given().spec(requestSpecification).when().get(api);
    }

    @Step("obtengo el id Mascota {int}")
    public void obtengoelnombreMascota(int var){
        given()
                .log().all()
                .spec(requestSpecification).pathParam("id", var)
                .when().get("mascota/{id}").
                then().
                and().
                log().all();
    }

    @Step("verifico  el ability id")
    public void verificoelabilityId(){
        logger.info(lastResponse().getBody().path("abilities.ability.id").toString());
    }
    @Step("verifico su base_experience")
    public void verificosubase_experience(){
        logger.info(lastResponse().getBody().path("verificosubase_experience").toString());
    }



}
