import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import  io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class UserController {
    String baseUrlDev = "http://46.101.196.83/api";
    String token = "null";
    String authPath = "/oauth/token";
    Response response;
    ValidatableResponse json;
    RequestSpecification request = RestAssured.given();


    @Given("^testGiven$")
    public void testgiven() throws Exception {
        System.out.println("Hi");
    }

    @Given("^testAnd$")
    public void testand() throws Exception {
        System.out.println("Hi");
    }


    @Then("^Verify$")
    public void verify() throws Exception {
        System.out.println("Hi");
    }


    @Given("^LogIn Parameters$")
    public void login_Parameters() throws Exception {
       request=
        RestAssured.given()
                .headers("Content-Type", "application/x-www-form-urlencoded",
                        "Authorization", "Basic YmV0MTE6YmV0MTE=")
                .formParam("grant_type", "password")
                .formParam("username", "coffe90@mailinator.com")
                .formParam("platform", "ANDROID")
                .formParam("password", "Qwe1156q@@");
    }

    @When("^sends post logIn request$")
    public void sends_post_logIn_request() throws Exception {
        response = request.when().post("http://46.101.196.83/api/oauth/token").then().extract().response();
        
    }

    @Then("^verifies user is logged In$")
    public void verifies_user_is_logged_In() throws Exception {
        json = response.then().statusCode(200)
                .body("token_type",equalTo("bearer"));
        token = response.path("access_token");
        System.out.println(token);
    }
}




