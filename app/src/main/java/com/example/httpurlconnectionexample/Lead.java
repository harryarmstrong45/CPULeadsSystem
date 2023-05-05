package com.example.httpurlconnectionexample;


public class Lead {
    private String id, source, status, reason_disqualified, type, vendor_id, linkedin, role, rating, company_id;


    public Lead(String id, String source, String status, String reason_disqualified, String type, String vendor_id, String linkedin, String role, String rating, String company_id) {
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
}
