package non_bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EMSNonBDD {

	@Test(enabled = false)
	public void getTheEmployees() {

		RestAssured.baseURI="http://localhost:3000/";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response  = requestSpecification.request(Method.GET,"employees");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusCode());
	}

	@Test(enabled = false)
	public void createAnEmployee() {
		RestAssured.baseURI="http://localhost:3000/";

		RequestSpecification requestSpecification=RestAssured.given().header("Content-Type","application/json").body("  {\r\n"
				+ "   \r\n"
				+ "        \"first_name\": \"thomas\",\r\n"
				+ "        \"last_name\": \"edition\",\r\n"
				+ "        \"email\": \"thomasedition@gmail.com\"\r\n"
				+ "    }");

		Response response= requestSpecification.request(Method.POST,"employees");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusCode());
	}

	@Test(enabled = false)
	public void updateAnEmployee() {
		RestAssured.baseURI="http://localhost:3000/";

		RequestSpecification requestSpecification=	RestAssured.given().header("Content-Type","application/json").body(" {\r\n"
				+ "    \"first_name\": \"hiroshima\",\r\n"
				+ "    \"last_name\": \"nagasaki\",\r\n"
				+ "    \"email\": \"abishekhrajendhran@gmail.com\",\r\n"
				+ "    \"id\": 12\r\n"
				+ "  }");

		Response response = requestSpecification.request(Method.PUT,"employees/12");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusCode());

	}

	@Test
	public void deleteAnEmployee() {
		Response response = null;
		
for (int i = 14; i < 25; i++) {
	RestAssured.baseURI="http://localhost:3000/";

	RequestSpecification requestSpecification=	RestAssured.given();
	 response=	requestSpecification.request(Method.DELETE,"employees/16");
	
}
System.out.println(response.asPrettyString());
		

//		System.out.println(response.asPrettyString());


	}

	@Test(enabled = false)
	public void getSingleEmployee() {
		RestAssured.baseURI="http://localhost:3000/";

		RequestSpecification requestSpecification=	RestAssured.given();

		Response response=	requestSpecification.request(Method.GET,"employees/5");

		System.out.println(response.asPrettyString());



	}
}
