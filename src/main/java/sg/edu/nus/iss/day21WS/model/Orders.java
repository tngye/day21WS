package sg.edu.nus.iss.day21WS.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Orders {
    private int id;
    private int employeeId;
    private int customerId;
    private Date orderDate;
    private Date shippedDate;
    private int shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private Double shippingFee;
    private Double taxes;
    private String paymentType;
    private Date paidDate;
    private String notes;
    private Double taxRate;
    private int taxStatusId;
    private int statusId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    public int getShipperId() {
        return shipperId;
    }
    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public String getShipCity() {
        return shipCity;
    }
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }
    public String getShipStateProvince() {
        return shipStateProvince;
    }
    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }
    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }
    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }
    public String getShipCountryRegion() {
        return shipCountryRegion;
    }
    public void setShipCountryRegion(String shipCountryRegion) {
        this.shipCountryRegion = shipCountryRegion;
    }
    public Double getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }
    public Double getTaxes() {
        return taxes;
    }
    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public Date getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public int getTaxStatusId() {
        return taxStatusId;
    }
    public void setTaxStatusId(int taxStatusId) {
        this.taxStatusId = taxStatusId;
    }
    public int getStatusId() {
        return statusId;
    }
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public static Orders create(SqlRowSet result) throws InvalidResultSetAccessException, ParseException {
        Orders order = new Orders();
        order.setId(result.getInt("id"));
        order.setEmployeeId(result.getInt("employee_id"));
        order.setCustomerId(result.getInt("customer_id"));

        Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(result.getString("order_date").substring(0, 10));
        order.setOrderDate(orderDate);

        String sd = result.getString("shipped_date");
        if(sd != null){
        Date shippedDate = new SimpleDateFormat("yyyy-MM-dd").parse(sd.substring(0, 10));
        order.setShippedDate(shippedDate);
        }

        order.setShipperId(result.getInt("shipper_id"));
        order.setShipName(result.getString("ship_name"));
        order.setShipAddress(result.getString("ship_address"));
        order.setShipCity(result.getString("ship_city"));
        order.setShipStateProvince(result.getString("ship_state_province"));
        order.setShipZipPostalCode(result.getString("ship_zip_postal_code"));
        order.setShipCountryRegion(result.getString("ship_country_region"));
        order.setShippingFee(result.getDouble("shipping_fee"));
        order.setTaxes(result.getDouble("taxes"));
        order.setPaymentType(result.getString("payment_type"));

        String pd = result.getString("paid_date");
        if (pd!=null){
        Date paidDate = new SimpleDateFormat("yyyy-MM-dd").parse(pd.substring(0, 10));
        order.setPaidDate(paidDate);
        }
        order.setNotes(result.getString("notes"));
        order.setTaxRate(result.getDouble("tax_rate"));
        order.setTaxStatusId(result.getInt("tax_status_id"));
        order.setStatusId(result.getInt("status_id"));
        return order;
    }
    

}
