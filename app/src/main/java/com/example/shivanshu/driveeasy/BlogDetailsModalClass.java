package com.example.shivanshu.driveeasy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shivanshu on 12/2/2017.
 */

class BlogDetailsModalClass {
@Expose
    @SerializedName("response")
    DlDetails dlDetails;

    public static class DlDetails {
        @Expose
        @SerializedName("dl_no")
        String dlNo;
        @Expose
        @SerializedName("date_of_issue")
        String DateOfissue;
        @Expose
        @SerializedName("expire_on")
        String ExpiryDate;
        @Expose
        @SerializedName("name")
        String Name;
        @Expose
        @SerializedName("dob")
        String Dob;

        public String getDateOfissue() {
            return DateOfissue;
        }

        public String getDlNo() {
            return dlNo;
        }

        public String getDob() {
            return Dob;
        }

        public String getExpiryDate() {
            return ExpiryDate;
        }

        public String getName() {
            return Name;
        }
    }

    public DlDetails getDlDetails() {
        return dlDetails;
    }
    @Expose
    @SerializedName("status")
    String Status;

    public String getStatus() {
        return Status;
    }
}
