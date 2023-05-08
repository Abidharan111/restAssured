package bdd;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


@SuppressWarnings("unused")
public class EMSBDD {
	
	@Test(priority = 1)
	public void getAllStudents() {
		
		when()
		  .get("http://localhost:3000/students")
		.then()
		  .statusCode(200)
		  .log().all();
	} 
	
	@Test(priority = 2)
	public void getAStudent() {
		
		when() 
		  .get("http://localhost:3000/students/1")
        .then()
          .statusCode(200)
          .log().all();
	}
	
	@Test(priority = 3)
	public void delete() {
		
		when()
		 .delete("http://localhost:3000/students/2")
		.then()
		  .statusCode(200);
	}
	
	
	
	

}
