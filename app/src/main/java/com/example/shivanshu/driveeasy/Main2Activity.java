package com.example.shivanshu.driveeasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
//ListView listView;
    TextView Name,AadharCard,Adress,Dob,DlNo,DlIssued,DlExp,RcNo,RcIssued,RcExpired,ModelNumber;
    Button submitButton;
    static FinalSubmissionForm Data;
    public static Intent getintent(Context c, FinalSubmissionForm finalSubmissionForm)
    {
        Intent intent=new Intent(c,Main2Activity.class);
        Data=finalSubmissionForm;
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  listView=(ListView)findViewById(R.id.list_item);
        Name=(TextView)findViewById(R.id.full_name);
        AadharCard=(TextView)findViewById(R.id.aadhar_num);
        Adress=(TextView)findViewById(R.id.address);
        Dob=(TextView)findViewById(R.id.dob);
        DlNo=(TextView)findViewById(R.id.driving_license);
        DlIssued=(TextView)findViewById(R.id.dl_issued);
        DlExp=(TextView)findViewById(R.id.dl_expiry);
        RcNo=(TextView)findViewById(R.id.rc_num);
        RcIssued=(TextView)findViewById(R.id.rc_issued);
        RcExpired=(TextView)findViewById(R.id.rc_expiry);
        ModelNumber=(TextView)findViewById(R.id.model_num);
        submitButton=(Button)findViewById(R.id.final_button);
        Name.setText(Data.getFullName());
        AadharCard.setText(Data.getAadharCardNumber());
        Adress.setText(Data.getAddress());
        Dob.setText(Data.getDOB());
        DlNo.setText(Data.getDlNumber());
        DlIssued.setText(Data.getIssueDate());
        DlExp.setText(Data.getValidity());
        RcNo.setText(Data.getRcNumber());
        RcIssued.setText(Data.getRcIssueDate());
        RcExpired.setText(Data.getRcExpiry());
        ModelNumber.setText(Data.getVehicalNo());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
