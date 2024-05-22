package api.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endPoints.UserEndpoints;
import api.payLoad.User;
import api.utilities.ListenerUtility;
import io.restassured.response.Response;

@Listeners(ListenerUtility.class)
public class Test_UserwithMutlipleData {
    //User user;
	
	public Logger log;
	
	@Test(priority=1,dataProvider = "fullData",dataProviderClass =ExcelDataProvider.class)
	public void multipleTestdata(String id,String firstName,String lastName,String email,String username,String Password,String statusCode) {
		
		//Logger
		log=LogManager.getLogger(this.getClass());
		
		
		User user=new User();
		
		user.setId(Integer.parseInt(id));
		//user.setPhone();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(Password);
		user.setUserStatus(200);
		
		System.out.println("creating new user===================================");
		
		
		Response res=UserEndpoints.createUser(user);
		res.then().log().all();
		
		log.info("*************User is created**************");
		
//		System.out.println(this.user.getId());
//		System.out.println(this.user.getFirstName());
	}
		

	@Test(priority=2,dataProvider = "userNames",dataProviderClass =ExcelDataProvider.class )
	public void test_getUser(String username) {
		System.out.println("fetching user details**********************");
		Response res=UserEndpoints.getUser(username);
		res.then().log().all();
		log.info("***********User details is fetched****************");
}
	
	@Test(priority=3,dataProvider = "userNames",dataProviderClass =ExcelDataProvider.class)
	public void test_deleteUser(String username) {
		System.out.println("deleting user details^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Response res=UserEndpoints.removeUser(username);
		res.then().log().all();
		log.info("**************User is deleted****************");
	}
		
}