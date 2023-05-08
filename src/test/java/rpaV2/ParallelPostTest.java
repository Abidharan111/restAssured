package rpaV2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ParallelPostTest {

    @Test
    public void testParallelPostRequests() {
    	
        RestAssured.baseURI = "https://qa-rpav2.freightify.in";
        ExecutorService executorService = Executors.newFixedThreadPool(5); // Number of threads to run in parallel

        for (int i = 0; i < 10; i++) { // Number of requests to make
            executorService.submit(() -> {
                Response response = given()
                        .header("Content-Type", "application/json")
                        .body("{\r\n"
                        		+ "    \"origin_port\": \"inmaa\",\r\n"
                        		+ "    \"destination_port\": \"aejea\",\r\n"
                        		+ "    \"cargo_ready_date\": \"2023-03-31\",\r\n"
                        		+ "    \"load_type\": \"20GP\",\r\n"
                        		+ "    \"quantity\": 2,\r\n"
                        		+ "    \"cargo_weight\": 6325,\r\n"
                        		+ "    \"vendor_id\": \"323\",\r\n"
                        		+ "    \"sub_vendor\": \"msc\"\r\n"
                        		+ "}")
                        .post("/instantqbt/command/SpotRates");

                // Get the response body as a string
                String responseBody = response.getBody().asString();

                // Print the response body
                System.out.println("Response body: " + responseBody);
                
                // Assert the response as per your requirements
                response.then()
                        .statusCode(200);
            });
        }

        // Shutdown the executor service
        executorService.shutdown();

        try {
            // Wait for all threads to finish executing
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
