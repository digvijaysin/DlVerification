package com.example.shivanshu.driveeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
EditText AadharNumber,DlNumber,RcNumber;
    RelativeLayout ProgressBar;
    CardView cardView;
    TextView Progress;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AadharNumber=(EditText)findViewById(R.id.aadhar_numbmer);
        DlNumber=(EditText)findViewById(R.id.dl_number);
        RcNumber=(EditText)findViewById(R.id.rc_number);
        submit=(Button)findViewById(R.id.submit);
        cardView=(CardView)findViewById(R.id.card_view);
        Progress=(TextView)findViewById(R.id.progress_text);
ProgressBar =(RelativeLayout)findViewById(R.id._progress_war);
        submit.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        ProgressBar.setVisibility(View.VISIBLE);
        Call<BlogDetailsModalClass> fetchWordListCall= RetrofitObject.getRetrofitObject("http://private-a2403-dlverification.apiary-mock.com/").getDLList(DlNumber.getText().toString());
        fetchWordListCall.enqueue(new Callback<BlogDetailsModalClass>() {
            @Override
            public void onResponse(Call<BlogDetailsModalClass> call, Response<BlogDetailsModalClass> response) {
                Progress.setText("Please wait while we fetch Your Driving License Details...");
                BlogDetailsModalClass blogDetailsModalClass=response.body();
               BlogDetailsModalClass.DlDetails dlDetails= blogDetailsModalClass.getDlDetails();
               final FinalSubmissionForm finalSubmissionForm=new FinalSubmissionForm();
                finalSubmissionForm.setDlNumber(dlDetails.getDlNo());
                finalSubmissionForm.setDOB(dlDetails.getDob());
                finalSubmissionForm.setFullName(dlDetails.getName());
                finalSubmissionForm.setIssueDate(dlDetails.getDateOfissue());
                finalSubmissionForm.setValidity(dlDetails.getExpiryDate());

                Call<RcDataClass> fetchWordListCall= RetrofitObject.getRetrofitObject("http://private-a2403-dlverification.apiary-mock.com/").getRcList(RcNumber.getText().toString());
                 fetchWordListCall.enqueue(new Callback<RcDataClass>() {
                     @Override
                     public void onResponse(Call<RcDataClass> call, Response<RcDataClass> response) {
                         Progress.setText("Please wait while we fetch Your Registration Certificate Details...");
                         RcDataClass rcDataClass=response.body();
                        RcDataClass.RcDetails details= rcDataClass.getRcDetails();
                         finalSubmissionForm.setRcNumber(details.getRcNo());
                         finalSubmissionForm.setRcIssueDate(details.getDateOfissue());
                         finalSubmissionForm.setRcExpiry(details.getExpiryDate());
                         finalSubmissionForm.setModelNo(details.getVehicleNo());
                         Intent intent =Main2Activity.getintent(getApplicationContext(),finalSubmissionForm);
                         ProgressBar.setVisibility(View.GONE);
                         startActivity(intent);
                     }

                     @Override
                     public void onFailure(Call<RcDataClass> call, Throwable t) {

                     }
                 });

            }

            @Override
            public void onFailure(Call<BlogDetailsModalClass> call, Throwable t) {
Log.d("digvijay",t.toString());
            }
        });
    }
}
