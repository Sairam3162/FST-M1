package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity2 {

	String baseURI = "https://petstore.swagger.io/v2/user";

	@Test(priority = 1)
	public void addNewUser() {

		File resJsonFile = new File("src/test/resources/userInfo.json");

		Response response = given().header("Content-Type", "application/json").body(resJsonFile).when().post(baseURI);

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("9999"));
	}

	@Test(priority = 2)
	public void getUserInfo() throws IOException {

		File outputJSON = new File("userGETResponse.json");

		Response response = given().baseUri(baseURI).header("Content-Type", "application/json").when()
				.pathParam("username", "justinCase").get("/{username}");

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		FileOutputStream out = new FileOutputStream(outputJSON);

		out.write(body.getBytes());
		out.close();

		response.then().statusCode(200);
		response.then().body("id", equalTo(9999));
		response.then().body("username", equalTo("justinCase"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
		response.then().body("userStatus", equalTo(0));

	}

	@Test(priority = 3)
	public void deleteUser() {

		Response response = given().baseUri(baseURI).header("Content-Type", "application/json").when()
				.pathParam("username", "justinCase").delete("/{username}");

		String body = response.getBody().asPrettyString();
		System.out.println(body);

		response.then().statusCode(200);
		response.then().body("message", equalTo("justinCase"));
	}
}
