package api.endPoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payLoad.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {

	
	static ResourceBundle urls(){
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
	}
		
	
	//Create new user API
	public static Response createUser(User user) {

	  
		
		Response response = given().contentType("application/json").accept("application/json").body(user)

				.when().post(urls().getString("addUser"));

		return response;
	}
	//Get user API
	public static Response getUser(String UserName) {

		Response response = given().pathParam("username",UserName)
				
				.when().get(urls().getString("getUser"));

		return response;
	}
	
	//Update user API
		public static Response updateUser(User user,String UserName) {

			Response response = given().pathParam("username",UserName)
					.contentType("application/json").accept("application/json").body(user)

					.when().put(urls().getString("updateUser"));

			return response;
		}
		
		//Delete user API
		public static Response removeUser(String UserName) {

			Response response = given().pathParam("username",UserName)
					.when().delete(urls().getString("deleteUser"));

			return response;
		}

}
