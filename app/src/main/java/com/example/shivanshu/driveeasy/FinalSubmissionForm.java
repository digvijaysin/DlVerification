package com.example.shivanshu.driveeasy;

/**
 * Created by shivanshu on 12/2/2017.
 */

public class FinalSubmissionForm {
    private String FullName;
    private String DOB;
    private String AadharCardNumber;
    private String DlNumber;
    private String IssueDate;
    private String Validity;
    private String RcNumber;
    private String ModelNo;
    private String vehicalNo;
    private String Address;
    private String ContactNo;
    private  String RcIssueDate;
    private String RcExpiry;

    public void setAadharCardNumber(String aadharCardNumber) {
        AadharCardNumber = aadharCardNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public void setRcExpiry(String rcExpiry) {
        RcExpiry = rcExpiry;
    }

    public void setRcIssueDate(String rcIssueDate) {
        RcIssueDate = rcIssueDate;
    }

    public void setDlNumber(String dlNumber) {
        DlNumber = dlNumber;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public void setModelNo(String modelNo) {
        ModelNo = modelNo;
    }

    public void setRcNumber(String rcNumber) {
        RcNumber = rcNumber;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }

    public void setVehicalNo(String vehicalNo) {
        this.vehicalNo = vehicalNo;
    }

    public String getAadharCardNumber() {
        return AadharCardNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getDlNumber() {
        return DlNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public String getRcExpiry() {
        return RcExpiry;
    }

    public String getRcNumber() {
        return RcNumber;
    }

    public String getVehicalNo() {
        return vehicalNo;
    }

    public String getValidity() {
        return Validity;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public String getRcIssueDate() {
        return RcIssueDate;
    }

    public String getFullName() {
        return FullName;
    }
}
