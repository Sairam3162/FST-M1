package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Activity1 {

	String baseURI = "https://petstore.swagger.io/v2/pet";

	@Test(priority = 1)
	public void addNewPet() {

		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77232);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");

		Response response = given().baseUri(baseURI).header("Content-Type", "application/json").body(reqBody).when().post();

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		response.then().statusCode(200);
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
	}

	@Test(priority = 2)
	public void getPetInfo() {

		Response response = given().baseUri(baseURI).header("Content-Type", "application/json").when()
				.pathParam("petId", 77232).get("/{petId}");

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		response.then().statusCode(200);
		response.then().body("id", equalTo(77232));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));

	}

	@Test(priority = 3)
	public void deletePet() {

		Response response = given().baseUri(baseURI).header("Content-Type", "application/json").when()
				.pathParam("petId", 77232).delete("/{petId}");

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		response.then().statusCode(200);
		response.then().body("message", equalTo("77232"));
	}
}
