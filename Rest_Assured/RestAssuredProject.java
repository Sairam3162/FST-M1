package com.restassuredproject;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredProject {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	String baseURI = "https://api.github.com";
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILpbyvAcVvxd20APrCpPsDAy0T1zzjeihCwW6qFCTk4E";
	int id;
	String accessToken = "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";

	@Test(priority = 1)
	public void setUp() {

		requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.addHeader("Authorization", "token " + accessToken).setBaseUri(baseURI).build();

		responseSpec = new ResponseSpecBuilder().expectContentType("application/json").build();

	}

	@Test(priority = 2)
	public void addSSHKey() {

		String reqBody = "{\r\n" + "	\"title\" : \"TestKey\",\r\n"
				+ "	\"key\" : \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILpbyvAcVvxd20APrCpPsDAy0T1zzjeihCwW6qFCTk4E\"\r\n"
				+ "}";

		Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");

		response.then().statusCode(201);
		response.then().log().all();
		id = response.then().extract().path("id");
//		id = response.getBody().path("id");
		System.out.println("id : " + id);
	}

	@Test(priority = 3)
	public void getSSHKey() {

		Response response = given().spec(requestSpec).when().pathParam("keyid", id).get("/user/keys/{keyid}");

		response.then().log().all();
		response.then().statusCode(200);
		Reporter.log(response.asString());
	}

	@Test(priority = 4)
	public void deleteSSHKey() {

		Response response = given().spec(requestSpec).when().pathParam("keyid", id).delete("/user/keys/{keyid}");

		response.then().statusCode(204);
		Reporter.log(response.toString());
		response.then().log().all();
	}
}
