package sg.edu.nus.iss.day21WS.Repository;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day21WS.model.Customers;
import sg.edu.nus.iss.day21WS.model.Orders;

import static sg.edu.nus.iss.day21WS.Repository.Queries.*;

@Repository
public class CustomersRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Customers> getAllCustomers(Integer offset, Integer limit) {

        final List<Customers> customers = new LinkedList<>();

        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS, limit, offset);

        while (result.next()) {
            Customers customer = Customers.create(result);
            customers.add(customer);
        }

        return customers;
    }

    public Optional<Customers> getCustomerById(Integer cid) {
        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_CUSTOMERS_BY_ID, cid);

        if (!result.next()){
            return Optional.empty();
        }
        return Optional.of(Customers.create(result));
    }

    public List<Orders> getOrdersByCid(Integer cid) throws InvalidResultSetAccessException, ParseException {
        final List<Orders> orders = new LinkedList<>();

        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_ORDERS_BY_CID, cid);

        while (result.next()) {
            Orders order = Orders.create(result);
            orders.add(order);
        }

        return orders;
    }
    
}
