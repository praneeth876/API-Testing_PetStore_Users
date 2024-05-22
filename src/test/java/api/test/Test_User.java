package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.Routes;
import api.endPoints.UserEndpoints;
import api.payLoad.User;
import io.restassured.response.Response;

public class Test_User {
	Faker fakeData ;
	User user;
	
	//String username=user.getUsername();

	
	@BeforeClass
	void testData() {
		
	    fakeData =new Faker();
	
		user=new User();
		user.setId(fakeData.idNumber().hashCode());
		user.setUsername(fakeData.name().username());
		user.setPassword(fakeData.internet().password());
		user.setPhone(fakeData.phoneNumber().phoneNumber());
		user.setEmail(fakeData.internet().emailAddress());
		user.setFirstName(fakeData.name().firstName());
		user.setLastName(fakeData.name().lastName());
		user.setUserStatus(200);
		
		
	}
	
	@Test(priority=1)
	public void test_createUser() {
		
		Response res=UserEndpoints.createUser(user);
		res.then().log().all();
		
//		int statusCode=res.getStatusCode();
//		String acceptheader=res.getHeader("accept");
//		
//		
//		Assert.assertEquals(200,statusCode);
//		Assert.assertEquals(acceptheader,"application/json");
		
		
	}
	
	@Test(priority=2, dependsOnMethods = "test_createUser")
	public void test_getUser() {
		
		Response res=UserEndpoints.getUser(this.user.getUsername());
		res.then().log().all();
		
//		int statusCode=res.getStatusCode();
//		String acceptheader=res.getHeader("accept");
//		
//		Assert.assertEquals(200,statusCode);
//		Assert.assertEquals(acceptheader,"application/json");
	}
	
	@Test(priority=3, dependsOnMethods = "test_getUser")
	public void test_putUser() {
		
		user.setEmail(fakeData.internet().emailAddress());
		user.setFirstName(fakeData.name().firstName());
		user.setLastName(fakeData.name().lastName());
		
		Response res=UserEndpoints.updateUser(user,this.user.getUsername());
		res.then().log().body();
		
	
		//checking data after update
		Response responseAfterUpdate=UserEndpoints.updateUser(user,user.getUsername());
		//responseAfterUpdate.then().statusCode(200);
		Assert.assertEquals(200,responseAfterUpdate.statusCode());
		
//		int statusCode=res.getStatusCode();
//		String acceptheader=res.getHeader("accept");
//
//		Assert.assertEquals(200,statusCode);
//		Assert.assertEquals(acceptheader,"application/json");
	}
	
	@Test(priority=4, dependsOnMethods = "test_putUser")
	public void test_deleteUser() {
		
		Response res=UserEndpoints.removeUser(user.getUsername());
		res.then().log().all();
		

	}
	
	
	
}
