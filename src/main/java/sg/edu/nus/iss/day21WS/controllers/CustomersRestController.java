package sg.edu.nus.iss.day21WS.controllers;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.naming.LimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import sg.edu.nus.iss.day21WS.model.Customers;
import sg.edu.nus.iss.day21WS.model.Orders;
import sg.edu.nus.iss.day21WS.services.CustomersService;

@RestController
@RequestMapping("/api")
public class CustomersRestController {

    @Autowired
    CustomersService cSvc;

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomers(@RequestParam(name = "offset", defaultValue = "0") Integer offset,
            @RequestParam(name = "limit", defaultValue = "5") Integer limit) {

        List<Customers> list = cSvc.getAllCustomers(offset, limit);

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Customers c : list) {
            arrBuilder.add(Json.createObjectBuilder()
                    .add("id", c.getId())
                    .add("company", c.getCompany() != null ? c.getCompany(): "")
                    .add("last_name", c.getLastName() != null ? c.getLastName(): "") //if number set 0, if boolean set true false 
                    .add("first_name", c.getFirstName() != null ? c.getFirstName(): "")
                    .add("email_address", c.getEmail() != null ? c.getEmail(): "")
                    .add("job_title", c.getJob_title() != null ? c.getJob_title(): "")
                    .add("business_phone", c.getBusinessPhone() != null ? c.getBusinessPhone(): "")
                    .add("home_phone", c.getHomePhone() != null ? c.getHomePhone(): "")
                    .add("mobile_phone", c.getMobilePhone() != null ? c.getMobilePhone(): "")
                    .add("fax_number", c.getFaxNumber() != null ? c.getFaxNumber(): "")
                    .add("address", c.getAddress() != null ? c.getAddress(): "")
                    .add("city", c.getCity() != null ? c.getCity(): "")
                    .add("state_province", c.getStateProvince() != null ? c.getStateProvince(): "")
                    .add("zip_postal_code", c.getPostalCode() != null ? c.getPostalCode(): "")
                    .add("country_region", c.getCountryRegion() != null ? c.getCountryRegion(): "")
                    .add("web_page", c.getWebPage() != null ? c.getWebPage(): "")
                    .add("notes", c.getNotes() != null ? c.getNotes(): "")
                    .add("attachments", c.getAttachments() != null ? c.getAttachments(): ""));

        }

        JsonArray customersList = arrBuilder.build();

        System.out.println(">>>>>customersList: " + customersList);
        return ResponseEntity.ok(customersList.toString());
    }

    @GetMapping(path = "/customer/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomerById(@PathVariable Integer cid) {
        Optional<Customers> opt = cSvc.getCustomerById(cid);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        if (opt.isEmpty()) {
            return ResponseEntity.status(404)
                    .body(builder.add("error", "not found: %s".formatted(cid))
                            .build().toString());
        }

        Customers customer = opt.get();

        builder.add("id", customer.getId())
                .add("company", customer.getCompany())
                .add("last_name", customer.getLastName())
                .add("first_name", customer.getFirstName());

        return ResponseEntity.ok(builder.build().toString());
    }

    @GetMapping(path = "customer/{cid}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrdersByCid(@PathVariable Integer cid) throws InvalidResultSetAccessException, ParseException {
        List<Orders> list = cSvc.getOrdersByCid(cid);
        JsonObjectBuilder builder = Json.createObjectBuilder();

        if (list.size() == 0 ) {
            return ResponseEntity.status(404)
                    .body(builder.add("error", "not found: %s".formatted(cid))
                            .build().toString());
        }

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Orders o : list) {
            arrBuilder.add(Json.createObjectBuilder()
                    .add("id", o.getId())
                    .add("order_date", o.getOrderDate().toString())
                    .add("shipped_date", o.getShippedDate() != null ? o.getShippedDate().toString(): "")
                    .add("shipper_Id", o.getShipperId()));
        }
        JsonArray ordersList = arrBuilder.build();

        return ResponseEntity.ok(ordersList.toString());
    }
}