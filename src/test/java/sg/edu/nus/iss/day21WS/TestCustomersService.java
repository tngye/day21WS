package sg.edu.nus.iss.day21WS;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.InvalidResultSetAccessException;

import sg.edu.nus.iss.day21WS.Repository.CustomersRepo;
import sg.edu.nus.iss.day21WS.model.Customers;
import sg.edu.nus.iss.day21WS.model.Orders;
import sg.edu.nus.iss.day21WS.services.CustomersService;

@SpringBootTest
@AutoConfigureMockMvc
public class TestCustomersService {

    @Autowired
    private CustomersService cSvc;

    @Test
    void ShouldReturn3Customers() {
        Integer count = 10;

        List<Customers> list = cSvc.getAllCustomers(0, count);

        assertEquals(count, list.size(), "Expect %s customers. Got %s".formatted(count, list.size()));

    }

    @Test
    void ShouldReturn4Orders() throws InvalidResultSetAccessException, ParseException {
        Integer id = 10;
        Integer count = 4;

        List<Orders> orders = cSvc.getOrdersByCid(id);

        assertEquals(count, orders.size(), "Expect %s customers. Got %s".formatted(count, orders.size()));
    }

    // @MockBean
    // private CustomersRepo cRepo;

    // @Test
    // void ShouldReturnCustomerById() {
    //     Integer id = 101;

    //     Customers cTest = new Customers();
    //     cTest.setId(id);
    //     cTest.setFirstName("Zac");
    //     cTest.setLastName("Ng");

    //     Mockito.when(cRepo.getCustomerById(id))
    //             .thenReturn(Optional.of(cTest));

    //     Optional<Customers> cGet = cSvc.getCustomerById(id);

    //     assertTrue(cGet.isPresent(), "Should found gid %d".formatted(id));
    // }

}
