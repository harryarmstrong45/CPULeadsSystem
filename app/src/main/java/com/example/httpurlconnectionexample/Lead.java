package com.example.httpurlconnectionexample;

public class Lead {
    String id;
    String source;
    String status;
    String reason_disqualified;
    String type;
    String vendor_id;
    String linkedin;
    String role;
    String rating;
    String company_id;


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
}
