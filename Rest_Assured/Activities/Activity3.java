package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

public class Activity3 {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	String baseURI = "https://petstore.swagger.io/v2/pet";

	@BeforeClass
	public void setUp() {

		requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(baseURI).build();

		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json")
				.expectBody("status", equalTo("alive")).build();
	}

	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {

		Object[][] testData = new Object[][] { { 77232, "Riley", "alive" }, { 77233, "Hansel", "alive" }

		};
		return testData;
	}

	@Test(priority = 1, dataProvider = "petInfo")
	public void addPets(int petId, String petName, String petStatus) {

		Map<String, Object> reqBody = new HashMap<>();

		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);

		given().spec(requestSpec).body(reqBody).when().post().then().log().all().spec(responseSpec).statusCode(200)
				.body("id", equalTo(petId)).body("name", equalTo(petName)).body("status", equalTo(petStatus));

	}

	@Test(priority = 2, dataProvider = "petInfo")
	public void getPetsInfo(int petId, String petName, String petStatus) {

		given().spec(requestSpec).pathParam("petId", petId).log().all().when().get("/{petId}").then().log().all()
				.statusCode(200).body("id", equalTo(petId)).body("name", equalTo(petName))
				.body("status", equalTo(petStatus));

	}

	@Test(priority = 3, dataProvider = "petInfo")
	public void deletePets(int petId, String petName, String petStatus) {

		given().spec(requestSpec).pathParam("petId", petId).log().all().when().delete("/{petId}").then().log().all()
				.and().statusCode(200).body("message", equalTo("" + petId));

	}
}