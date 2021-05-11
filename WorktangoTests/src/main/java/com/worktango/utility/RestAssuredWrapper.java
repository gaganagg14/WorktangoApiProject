package com.worktango.utility;

import static io.restassured.RestAssured.given;

import java.util.Map;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RestAssuredWrapper {
	
	public <T> T run(String url, Object request, Map<String, Object> queryParam,int port, Map<String, String> headers,Class<T> responseClass, int statusCode){
	    RequestSpecification requestSpec = new RequestSpecBuilder()
	            .addQueryParams(queryParam)
	            .setPort(port)
	            .setBody(request)
	            .setContentType("application/json")
	            .addHeaders(headers)
	            .addFilter(new RequestLoggingFilter())
	            .addFilter(new ResponseLoggingFilter())
	            .build();
	    
		return given().spec(requestSpec).when().post(url).then().statusCode(statusCode).extract().as(responseClass);	    
	    
	}

}
