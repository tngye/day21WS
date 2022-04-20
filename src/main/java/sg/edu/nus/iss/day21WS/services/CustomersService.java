package sg.edu.nus.iss.day21WS.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day21WS.Repository.CustomersRepo;
import sg.edu.nus.iss.day21WS.model.Customers;
import sg.edu.nus.iss.day21WS.model.Orders;

@Service
public class CustomersService {
    

    @Autowired
    public CustomersRepo cRepo;

    public List<Customers> getAllCustomers(Integer offset, Integer limit){
        List<Customers> list = cRepo.getAllCustomers(offset, limit);
        return list;
    }

    public Optional<Customers> getCustomerById(Integer cid) {
        Optional<Customers> customer = cRepo.getCustomerById(cid);
        return customer;
    }

    public List<Orders> getOrdersByCid(Integer cid) throws InvalidResultSetAccessException, ParseException {
        List<Orders> list = cRepo.getOrdersByCid(cid);
        System.out.println(">>>list: " + list);
        System.out.println(">>>list: " + list.size());
        return list;
    }
}
