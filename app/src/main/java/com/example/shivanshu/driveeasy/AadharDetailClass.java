package com.example.shivanshu.driveeasy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shivanshu on 12/2/2017.
 */

public class AadharDetailClass {
    @Expose
    @SerializedName("response")
    AadharDetail aadharDetail;

    static class AadharDetail {
        @Expose
        @SerializedName("name")
        String name;

        public String getName() {
            return name;
        }
        @Expose
        @SerializedName("dob")
        String dob;

        public String getDob() {
            return dob;
        }
        @Expose
        @SerializedName("address")
        String Address;

        public String getAddress() {
            return Address;
        }
        @Expose
        @SerializedName("aadhaar_no")
        String AadharNumber;

        public String getAadharNumber() {
            return AadharNumber;
        }
    }

    public AadharDetail getAadharDetail() {
        return aadharDetail;
    }
    @Expose
    @SerializedName("status")
    String Status;

    public String getStatus() {
        return Status;
    }
}
