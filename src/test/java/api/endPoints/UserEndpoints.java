package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	//Create new user API
	public static Response createUser(User user) {

		Response response = given().contentType("application/json").accept("application/json").body(user)

				.when().post(Routes.postUser);

		return response;
	}
	//Get user API
	public static Response getUser(String UserName) {

		Response response = given().pathParam("username",UserName)
				
				.when().get(Routes.getUser_Url);

		return response;
	}
	
	//Update user API
		public static Response updateUser(User user,String UserName) {

			Response response = given().pathParam("username",UserName)
					.contentType("application/json").accept("application/json").body(user)

					.when().put(Routes.putUser_Url);

			return response;
		}
		
		//Delete user API
		public static Response removeUser(String UserName) {

			Response response = given().pathParam("username",UserName)
					.when().delete(Routes.deleteUser_Url);

			return response;
		}

}
