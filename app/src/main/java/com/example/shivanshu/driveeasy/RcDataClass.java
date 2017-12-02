package com.example.shivanshu.driveeasy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shivanshu on 12/2/2017.
 */

class RcDataClass {
    @Expose
    @SerializedName("response")
    RcDetails RcDetails;

    public static class RcDetails {
        @Expose
        @SerializedName("rc_no")
        String RcNo;
        @Expose
        @SerializedName("date_of_issue")
        String DateOfissue;
        @Expose
        @SerializedName("vehicle_no")
        String VehicleNo;
        @Expose
        @SerializedName("name")
        String Name;
        @Expose
        @SerializedName("dob")
        String Dob;
        @Expose
        @SerializedName("expiry_date")
        String ExpiryDate;

        public String getDateOfissue() {
            return DateOfissue;
        }

        public String getRcNo() {
            return RcNo;
        }

        public String getDob() {
            return Dob;
        }

        public String getVehicleNo() {
            return VehicleNo;
        }

        public String getName() {
            return Name;
        }

        public String getExpiryDate() {
            return ExpiryDate;
        }
    }

    public RcDetails getRcDetails() {
        return RcDetails;
    }
    @Expose
    @SerializedName("status")
    String Status;

    public String getStatus() {
        return Status;
    }

}
