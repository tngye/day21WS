package sg.edu.nus.iss.day21WS.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Customers {
    private int id;
    private String company;
    private String lastName;
    private String firstName;
    private String email;
    private String job_title;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String countryRegion;
    private String webPage;
    private String notes;
    private String attachments;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    public String getBusinessPhone() {
        return businessPhone;
    }
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getFaxNumber() {
        return faxNumber;
    }
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountryRegion() {
        return countryRegion;
    }
    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }
    public String getWebPage() {
        return webPage;
    }
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getAttachments() {
        return attachments;
    }
    public void setAttachments(String attachements) {
        this.attachments = attachements;
    }


    public static Customers create(SqlRowSet rs) {
        Customers customer = new Customers();
        customer.setId(rs.getInt("id"));
        customer.setCompany(rs.getString("company"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setEmail(rs.getString("email_address"));
        customer.setJob_title(rs.getString("job_title"));
        customer.setBusinessPhone(rs.getString("business_phone"));
        customer.setHomePhone(rs.getString("home_phone"));
        customer.setMobilePhone(rs.getString("mobile_phone"));
        customer.setFaxNumber(rs.getString("fax_number"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setStateProvince(rs.getString("state_province"));
        customer.setPostalCode(rs.getString("zip_postal_code"));
        customer.setCountryRegion(rs.getString("country_region"));
        customer.setWebPage(rs.getString("web_page"));
        customer.setNotes(rs.getString("notes"));
        customer.setAttachments(rs.getString("attachments"));
        return customer;
    }

    

}
