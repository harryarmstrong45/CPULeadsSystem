package com.example.httpurlconnectionexample;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Lead implements Serializable {

    /**
     Represents a Lead object.
     */
    private String id, source, status, reason_disqualified, type, vendor_id, linkedin, role, rating, company_id;
    private final List<String> sources = Arrays.asList("Website", "Telephone", "Email");
    private final List<String> statuses = Arrays.asList("New", "Working", "Qualified", "Disqualified", "Customer");
    private final List<String> types = Arrays.asList("Commercial", "Educational", "Domestic");
    private final List<String> roles = Arrays.asList("IT", "Marketing", "Sales");
    private final List<String> ratings = Arrays.asList("A", "B", "C", "D");

    /**
     Constructs a new Lead object with the specified attributes.
     @param id The ID of the lead.
     @param source The source of the lead.
     @param status The status of the lead.
     @param reason_disqualified The reason for disqualifying the lead.
     @param type The type of the lead.
     @param vendor_id The ID of the vendor associated with the lead.
     @param linkedin The LinkedIn profile URL of the lead.
     @param role The role of the lead.
     @param rating The rating of the lead.
     @param company_id The ID of the company associated with the lead.
     */
    public Lead(String id, String source, String status,
                String reason_disqualified, String type, String vendor_id, String linkedin,
                String role, String rating, String company_id) {
        this.id = id;
        this.source = source;
        this.status = status;
        this.reason_disqualified = reason_disqualified;
        this.type = type;
        this.vendor_id = vendor_id;
        this.linkedin = linkedin;
        this.role = role;
        this.rating = rating;
        this.company_id = company_id;
    }

    /**
     * To String for Lead
     */
    public Lead () {}
    @Override
    public String toString() {
        return "Lead " + '\n' +
                "id = " + id + '\n' +
                "source = " + source + '\n' +
                "status = " + status + '\n' +
                "reason_disqualified = " + reason_disqualified + '\n' +
                "type = " + type + '\n' +
                "vendor_id = " + vendor_id + '\n' +
                "linkedin = " + linkedin + '\n' +
                "role = " + role + '\n' +
                "rating = " + rating + '\n' +
                "company_id = " + company_id ;
    }

    //Setter for ID
    public void setId(String id) {
        this.id = id;
    }

    //Setter for Source
    public void setSource(String source) {
        this.source = source;
    }

    //Setter for Status
    public void setStatus(String status) {
        this.status = status;
    }

    //Setter for Reason Disqualified
    public void setReason_disqualified(String reason_disqualified) {
        this.reason_disqualified = reason_disqualified;
    }

    //Setter for Type
    public void setType(String type) {
        this.type = type;
    }

    //Setter for VendorID
    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    //Setter for LinkedInProfile
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    //Setter for Role
    public void setRole(String role) {
        this.role = role;
    }

    //Setter for Rating
    public void setRating(String rating) {
        this.rating = rating;
    }

    //Setter for CompanyID
    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    //Getter for ID
    public String getId() {
        return id;
    }

    //Getter for Source
    public String getSource() {
        return source;
    }

    //Getter for Status
    public String getStatus() {
        return status;
    }

    //Getter for Reason Disqualified
    public String getReason_disqualified() {
        return reason_disqualified;
    }

    //Getter for Type
    public String getType() {
        return type;
    }

    //Getter for Vendor
    public String getVendor_id() {
        return vendor_id;
    }

    //Getter for LinkedIn Profile
    public String getLinkedin() {
        return linkedin;
    }

    //Getter for Role
    public String getRole() {
        return role;
    }

    //Getter for rating
    public String getRating() {
        return rating;
    }

    //Getter for Company
    public String getCompany_id() {
        return company_id;
    }

    public List<String> getSources() {
        return sources;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getRatings() {
        return ratings;
    }
}
