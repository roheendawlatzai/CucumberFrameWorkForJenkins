package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.apiConstants;

import static io.restassured.RestAssured.given;


public class GenerateTokenSteps {
    public static String token;
    @Given("a JWT token is generated")
    public void a_jwt_token_is_generated(){
        RequestSpecification generateTokenRequest = given().header("Content-type", "application/json")
                .body("{\n" +
                        "  \"email\": \"sontoxAPI@gmail.com\",\n" +
                        "  \"password\": \"abc123\"\n" +
                        "}");
        Response generateTokenResponse = generateTokenRequest.when().post( apiConstants.GENERATE_TOKEN_URI);
        generateTokenResponse.prettyPrint();
        token ="Bearer " + generateTokenResponse.jsonPath().getString("token");
    }
}
