package api.attornatus.person;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonApiApplicationTests {

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest(){
		System.out.println(randomPort);
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllCheckResult() {
		RestAssured.given()
				.when()
				.get("/person")
				.then()
				.statusCode(HttpStatus.OK.value())
				.extract().response().body().prettyPrint();

	}
}
