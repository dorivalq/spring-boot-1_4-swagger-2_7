package br.com.ijminfo.ms.webapp.sefaz.controller;

import static io.restassured.RestAssured.given;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ijminfo.ms.webapp.config.WebappConfig;
import io.restassured.RestAssured;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebappConfig.class, /*WebappPersistenceConfig.class */})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SefazControllerTest2 {
	
	private static final Object CLIENT_ID = "MessageSystemWebapp";

	private static final Object CLIENT_SECRET = "IJMInfoMessageSytem@secretXtkmac";

	@LocalServerPort
	private int port;
//	
//	@Mock
//	private HttpServiceImpl httpService;

	private Connection conn;

	private String oauth_token;

	private String redirect_url = "http://localhost:8080/swagger-ui.html";

	private String oauth_code;
	
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;
//		conn = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//				.setName("testdb;DATABASE_TO_UPPER=false;MODE=MYSQL")
//				.continueOnError(true)
//				
//		.build().getConnection();
	}

	/*
	 *
	 * // we need to get the oauth token before we can perform the request private
	 * void authenticateUser(String username, String password) {
	 *
	 * String response = given() .parameters("username", username, "password",
	 * password, "grant_type", "password", "scope", "read write", "client_id",
	 * "clientapp", "client_secret", "123456") .auth() .preemptive()
	 * .basic("clientapp","123456") .when() .post("/oauth/token") .asString();
	 *
	 * JsonPath jsonPath = new JsonPath(response); accessToken =
	 * jsonPath.getString("access_token"); }
	 *
	 * And them on the test I used the retrieved token:
	 *
	 * @Test public void testGetUserDefaultUserOwner() {
	 *
	 *
	 * authenticateUser(testData.user1.getLogin(), "1");
	 *
	 * User user = given() .auth().oauth2(accessToken)
	 * .contentType(ContentType.JSON) .accept(ContentType.JSON) .expect()
	 * .log().all() .statusCode(HttpStatus.OK.value()) .when() .get(USER_RESOURCE,
	 * testData.user1.getId()) .as(User.class);
	 *
	 * assertThat(user).isEqualTo(testData.user1); }
	 *
	 *
	 */
	// https://medium.com/@vicusbass/api-testing-with-rest-assured-oauth2-flow-with-redirect-uri-ba48b5953823
	// https://medium.com/@niluka/getting-access-token-in-oauth2-0-using-rest-assured-225593b8fc1a
	// https://aaronparecki.com/oauth-2-simplified/#authorization
	@Test
	@Ignore
	public void authenticate() {
		String oauth_token = given().when().queryParams("client_id", CLIENT_ID)
				.queryParams("client_secret", CLIENT_SECRET)
				// .queryParams("grant_type", "authorization_code")
				.queryParams("grant_type", "authorization_code")
				// .queryParams("redirect_uri", "http://localhost:8080/oauth2/access_token")
				.queryParams("redirect_uri", "http://localhost:8080/oauth/token")
				// .queryParams("code", oauth_code)
				// .get("http://foursquare.com/oauth2/access_token")
				.get("http://localhost:8080/oauth/token").then().extract().asString();
//		         .then()
//		         .statusCode(200)
//		         .extract().path("access_token");
		System.out.println(oauth_token);
		/*
		 * POST https://api.authorization-server.com/token
		 * grant_type=authorization_code& code=AUTH_CODE_HERE&
		 * redirect_uri=REDIRECT_URI& client_id=CLIENT_ID& code_verifier=VERIFIER_STRING
		 */
	}

	@Test
	public void oauthTest() {
		String res = given()
				.when().
						get("http://localhost:"+port+"/users")
				.body()
				.asString()
				;
		System.out.println(res);
	}

	@Test
	public void oauthTest3() {
		//https://www.youtube.com/watch?v=GMuFZMBZLg4
		String string = given().get("http://localhost:" + port + "/users")
				.getBody()
				.asString();

		System.out.println(string);
	}

	@Test
	public void oauthTest4() {
//{"error":"unauthorized","error_description":"There is no client authentication. Try adding an appropriate authentication filter."}

		String string = given()
				.formParam("client_id", CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("grant_type", "client_credentials")
				.post("http://localhost:"+port+"/oauth/token")
				.getBody()
				.asString();

		System.out.println(string);

	}

	@Test
	public void oauthTest5() {

		String string = given()
				.post("http://localhost:"+port+"/produto")
				.getBody()
				.asString();

		System.out.println(string);

	}
}