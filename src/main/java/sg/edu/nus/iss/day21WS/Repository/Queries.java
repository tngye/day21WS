package sg.edu.nus.iss.day21WS.Repository;

public class Queries {
    public static final String SQL_SELECT_ALL_CUSTOMERS = "select * from customers limit ? offset ?";
    public static final String SQL_SELECT_CUSTOMERS_BY_ID = "select * from customers where id = ?";
    public static final String SQL_SELECT_ORDERS_BY_CID = "select * from orders where customer_id = ?";
}
