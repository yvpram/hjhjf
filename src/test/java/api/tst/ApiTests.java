package api.tst;


import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import api.payload.UserPayload;
import api.service.ApiService;


public class ApiTests {

    private ApiService apiService;

    @BeforeClass
    public void setup() {
        // Set up the base URI
        apiService = new ApiService(Routes.base_url);
    }

    @Test
    public void testGetUser() {
    	Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("id", 2); 
        Response response = apiService.getRequest(Routes.get_url, pathParams);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("GET Response: " + response.asString());
    }
    

    @Test
    public void testGetAllUser() {
        Response response = apiService.getAllRequest(Routes.get_Allurl);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("GET Response: " + response.asString());
    }

    @Test
    public void testCreateUser() {
        UserPayload user = new UserPayload("John Doe", "Leader");
        Response response = apiService.postRequest(Routes.post_url, user);
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("POST Response: " + response.asString());
    }

    @Test
    public void testUpdateUser() {
    	Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("id", 2);
        UserPayload user = new UserPayload("Jane Doe", "Manager");
        Response response = apiService.putRequest(Routes.put_url,pathParams , user);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("PUT Response: " + response.asString());
    }

    @Test
    public void testDeleteUser() {
    	Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("id", 2);
        Response response = apiService.deleteRequest(Routes.delete_url, pathParams);
        Assert.assertEquals(response.getStatusCode(), 204);
        System.out.println("DELETE Response: " + response.asString());
    }
}
