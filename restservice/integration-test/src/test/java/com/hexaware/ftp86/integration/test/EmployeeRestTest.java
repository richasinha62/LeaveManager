package com.hexaware.ftp86.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		for (Employee e: res) {
			switch (e.getEmpId()) {
				case 1000:
					assertEquals(1000, e.getEmpId());
					break;
				 case 2000:
					assertEquals(2000, e.getEmpId());
					break;				
				case 3000:
					assertEquals(3000, e.getEmpId());
					break;				
				case 4000:
					assertEquals(4000, e.getEmpId());
					break;				
				case 5000:
					assertEquals(5000, e.getEmpId());
					break;
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException ,ParseException{
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	assertEquals(1000, res.getEmpId());
	assertEquals("Richa", res.getEmpFullName());
	assertEquals("rsq@gmail.com", res.getEmailId());
	assertEquals("1234567890", res.getMobNumber());
	assertEquals("2018-10-04", sdf.format(res.getDateOfJoining()));
	assertEquals("Java", res.getDepartment());
	assertEquals(47, res.getAvailableLeave());
	assertEquals(0, res.getMgrId());
  }

  
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}


	
}
