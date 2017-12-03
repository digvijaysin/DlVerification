package com.example.shivanshu.driveeasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PoliceAuthVerification extends AppCompatActivity {

    TextView Name,AadharCard,Adress,Dob,DlNo,DlIssued,DlExp,RcNo,RcIssued,RcExpired,ModelNumber;
    Button submitButton;
    static FinalSubmissionForm Data;
    private EditText AadharNumber;
    private LinearLayout ProgressBar;
    private TextView Progress;
    private CardView cardView;

    public static Intent getintent(Context c, FinalSubmissionForm finalSubmissionForm)
    {
        Intent intent=new Intent(c,Main2Activity.class);
        Data=finalSubmissionForm;
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_auth_verification);
        initiateViews();
    }

    private void initiateViews() {
        AadharNumber = (EditText) findViewById(R.id.aadhar_numbmer);
        ProgressBar = (LinearLayout) findViewById(R.id.progress_war);
        Progress = (TextView) findViewById(R.id.progress_text);
        cardView = (CardView) findViewById(R.id.card_view);
    }

    public void onSubmit(View view){
        if (AadharNumber.getText().toString().equals("")) {
            AadharNumber.setError("Please type your aadhaar number");
        } else {
            Progress.setText("Please wait we are validating you...");
            ProgressBar.setVisibility(View.VISIBLE);
            cardView.setVisibility(View.GONE);
            Intent intent=new Intent(this,PoliceAuthVerification.class);
            startActivity(intent);
        }
    }
}
