package api.endPoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Routes {

	
	//  https://petstore.swagger.io/v2/user -Add user
	//  https://petstore.swagger.io/v2/user/{username}  -Fetch user by userID
	//  https://petstore.swagger.io/v2/user/{username}  -update or modify the data
	//  https://petstore.swagger.io/v2/user/{username}  -to delete the user data
	
	
	public static String baseUrl="https://petstore.swagger.io/v2/";
	
	public static String postUser=baseUrl+"user";
	public static String getUser_Url=baseUrl+"user/{username}";
	public static String putUser_Url=baseUrl+"user/{username}";
	public static String deleteUser_Url=baseUrl+"user/{username}";
	
	
	
}
