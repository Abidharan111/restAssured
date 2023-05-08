package bdd;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

//import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

@SuppressWarnings("unused")
public class DIffTypesOfPostReq {
	
	
	
//	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void hashMap() {
		
		HashMap data= new HashMap<>();
		data.put("id",4);
		data.put("name", "Abisrey");
		data.put("location", "texas");
		data.put("phone_number", "8870568607");
		
		String[] courses= {"postman","RestAssured"};
		
		data.put("courses", courses);
		
		
		given()
		   .contentType("application/json")
		   .body(data)
		
		.when()
		   .post("http://localhost:3000/students")
		   
		.then()
		    .statusCode(201)
		    .log().all();
		}
	
//	@Test
	public void jsonObject() {
		
		JSONObject data1 = new JSONObject();
		data1.put("name", "pumpkin");
		data1.put("location", "Canada");
		
		String[] courses= {"security testing","Jmeter"};
		
		data1.put("courses",courses);
		
		
		
		given()
		   .contentType("application/json")
		   //convert the json object to string while using hashmap we dont need to use toString() Method
		   .body(data1.toString())
		
		.when()
		   .post("http://localhost:3000/students")
		   
		.then()
		    .statusCode(201)
		    .log().all();
		}

	//@Test
	public void usingPojoClass() {
		
		Pojo data =new Pojo();
		data.setName("onion");
		data.setLocation("bengaluru");
		data.setPhone("3573461");
		
		String[] courses= {"manual testing","full stack automation"};
		data.setCourses(courses);
		
		
		given()
		   .contentType("application/json")
		   //convert the json object to string while using hashmap we dont need to use toString() Method
		   .body(data)
		
		.when()
		   .post("http://localhost:3000/students")
		   
		.then()
		    .statusCode(201)
		    .log().all();
		}
	
	@Test
	public void usingExternalJsonFile() throws FileNotFoundException {
		
		File fn=new File("body.json");
     
		
		
		given()
		   .contentType("application/json")
		   //convert the json object to string while using hashmap we dont need to use toString() Method
		   .body(fn)
		
		.when()
		   .post("http://localhost:3000/students")
		   
		.then()
		    .statusCode(201)
		    .log().all();
		}
}
