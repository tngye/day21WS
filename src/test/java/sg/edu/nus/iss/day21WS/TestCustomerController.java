package sg.edu.nus.iss.day21WS;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.day21WS.services.CustomersService;

@SpringBootTest
@AutoConfigureMockMvc
class TestCustomerController {

	@Autowired
    private MockMvc mvc;


	@Test
	void contextLoads() {
	}

	@Test
	void ShouldReturnDefaultLimit5(){

		int count = 5; 
		
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customer")
			.accept(MediaType.APPLICATION_JSON_VALUE);
			
			MvcResult result = null;
			try {
				result = mvc.perform(req).andReturn();
			} catch (Exception ex) {
				fail("cannot perform mvc invocation", ex);
				return;
			}
	
			MockHttpServletResponse resp = result.getResponse();
			String payload;
			try {
				// JSON
				payload = resp.getContentAsString();
			} catch (Exception ex) {
				fail("cannot retrieve response payload", ex);
				return;
			}
	
			JsonReader reader = Json.createReader(new StringReader(payload));
			JsonArray customers = reader.readArray();

			assertEquals(count, customers.size(), 
            "Expect %s customers. Got %s".formatted(count, customers.size()));
	
	}

	@Test
	void ShouldReturnCustomerById(){
		Integer cusId = 1;
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customer/" + cusId)
			.accept(MediaType.APPLICATION_JSON_VALUE);
			
			MvcResult result = null;
			try {
				result = mvc.perform(req).andReturn();
			} catch (Exception ex) {
				fail("cannot perform mvc invocation", ex);
				return;
			}
	
			MockHttpServletResponse resp = result.getResponse();
			String payload;
			try {
				// JSON
				payload = resp.getContentAsString();
			} catch (Exception ex) {
				fail("cannot retrieve response payload", ex);
				return;
			}
	
			JsonReader reader = Json.createReader(new StringReader(payload));
			JsonObject customer = reader.readObject();

			assertEquals(cusId, customer.getInt("id"), 
            "Expect customerId = %s. Got id = %s".formatted(cusId, customer.getInt("id")));
	

	}

	@Test
	void ShouldReturn2Orders(){
		Integer orders = 2;
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customer/1/orders")
			.accept(MediaType.APPLICATION_JSON_VALUE);
			
			MvcResult result = null;
			try {
				result = mvc.perform(req).andReturn();
			} catch (Exception ex) {
				fail("cannot perform mvc invocation", ex);
				return;
			}
	
			MockHttpServletResponse resp = result.getResponse();
			String payload;
			try {
				// JSON
				payload = resp.getContentAsString();
			} catch (Exception ex) {
				fail("cannot retrieve response payload", ex);
				return;
			}
	
			JsonReader reader = Json.createReader(new StringReader(payload));
			JsonArray ordersArr = reader.readArray();

			assertEquals(orders, ordersArr.size(), 
            "Expect %s orders. Got %s orders".formatted(orders,  ordersArr.size()));
	

	}

}
