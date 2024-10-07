package api.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Map;

public class ApiService {
    
    // Base URI configuration
    public ApiService(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    // POST Request
    public Response postRequest(String endpoint,Object payload) {
        return given().log().all()
                .contentType("application/json")
                .body(payload)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract().response();
    }
    
    // GET Request
    public Response getRequest(String endpoint,Map<String, Object> pathparams) {
        return given().pathParams(pathparams).log().all()
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }
    // GET Request
    public Response getAllRequest(String endpoint) {
        return given().log().all()
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }

    // PUT Request
    public Response putRequest(String endpoint,Map<String, Object> pathparams, Object payload) {
        return given().log().all()
                .contentType("application/json").pathParams(pathparams)
                .body(payload)
                .when()
                .put(endpoint)
                .then().log().all()
                .extract().response();
    }

    // DELETE Request
    public Response deleteRequest(String endpoint,Map<String, Object> pathparams) {
        return given().pathParams(pathparams).log().all()
                .when()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
    }
}
