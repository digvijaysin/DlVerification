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
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
EditText AadharNumber,DlNumber,RcNumber;
    LinearLayout ProgressBar;
    CardView cardView;
    TextView Progress;
    Button submit;
    static  int count=0;
    static boolean state=true;
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
ProgressBar =(LinearLayout)findViewById(R.id._progress_war);
        submit.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {


            cardView.setVisibility(View.GONE);
            Progress.setText("Please wait we are validating you...");
            ProgressBar.setVisibility(View.VISIBLE);
            Call<AadharDetailClass> fetchAadahrDetail = RetrofitObject.getRetrofitObject("http://private-686ca-aadhaarverification.apiary-mock.com/").getAadharDetails(AadharNumber.getText().toString());
            fetchAadahrDetail.enqueue(new Callback<AadharDetailClass>() {
                @Override
                public void onResponse(Call<AadharDetailClass> call, Response<AadharDetailClass> response) {
                    AadharDetailClass aadharDetailClass = response.body();
                    if (aadharDetailClass.getStatus().equals("ok")) {
                        final FinalSubmissionForm finalSubmissionForm = new FinalSubmissionForm();
                        finalSubmissionForm.setFullName(aadharDetailClass.getAadharDetail().getName());
                        finalSubmissionForm.setDOB(aadharDetailClass.getAadharDetail().getDob());
                        finalSubmissionForm.setAddress(aadharDetailClass.getAadharDetail().getAddress());
                        finalSubmissionForm.setAadharCardNumber(aadharDetailClass.getAadharDetail().getAadharNumber());
                        final String name = finalSubmissionForm.getFullName();
                        final String Dob = finalSubmissionForm.getDOB();

                        Call<BlogDetailsModalClass> fetchWordListCall = RetrofitObject.getRetrofitObject("http://private-a2403-dlverification.apiary-mock.com/").getDLList(DlNumber.getText().toString());
                        fetchWordListCall.enqueue(new Callback<BlogDetailsModalClass>() {
                            @Override
                            public void onResponse(Call<BlogDetailsModalClass> call, Response<BlogDetailsModalClass> response) {
                                Progress.setText("Please wait while we fetch Your Driving License Details...");
                                BlogDetailsModalClass blogDetailsModalClass = response.body();
                                if (blogDetailsModalClass.getStatus().equals("ok")) {
                                    BlogDetailsModalClass.DlDetails dlDetails = blogDetailsModalClass.getDlDetails();

                                    if (dlDetails.getName().equals(name) && dlDetails.getDob().equals(Dob)) {

                                        finalSubmissionForm.setDlNumber(dlDetails.getDlNo());
                                        //finalSubmissionForm.setDOB(dlDetails.getDob());
                                        //finalSubmissionForm.setFullName(dlDetails.getName());
                                        finalSubmissionForm.setIssueDate(dlDetails.getDateOfissue());
                                        finalSubmissionForm.setValidity(dlDetails.getExpiryDate());

                                        Call<RcDataClass> fetchWordListCall = RetrofitObject.getRetrofitObject("http://private-c8cb7b-rcverification.apiary-mock.com/").getRcList(RcNumber.getText().toString());
                                        fetchWordListCall.enqueue(new Callback<RcDataClass>() {
                                            @Override
                                            public void onResponse(Call<RcDataClass> call, Response<RcDataClass> response) {
                                                Progress.setText("Please wait while we fetch Your Registration Certificate Details...");
                                                RcDataClass rcDataClass = response.body();
                                                if (rcDataClass.getStatus().equals("ok")) {
                                                    RcDataClass.RcDetails details = rcDataClass.getRcDetails();
                                                    if (details.getName().equals(name) && details.getDob().equals(Dob)) {
                                                        finalSubmissionForm.setRcNumber(details.getRcNo());
                                                        finalSubmissionForm.setRcIssueDate(details.getDateOfissue());
                                                        finalSubmissionForm.setRcExpiry(details.getExpiryDate());
                                                        finalSubmissionForm.setModelNo(details.getVehicleNo());
                                                        Intent intent = Main2Activity.getintent(getApplicationContext(), finalSubmissionForm);
                                                        ProgressBar.setVisibility(View.GONE);
                                                        cardView.setVisibility(View.VISIBLE);
                                                        startActivity(intent);
                                                    } else {
                                                        ProgressBar.setVisibility(View.GONE);
                                                        cardView.setVisibility(View.VISIBLE);
                                                        Toast.makeText(getApplicationContext(), "Name and Dob on Rc Don't match with Aadhar Details", Toast.LENGTH_LONG).show();

                                                    }

                                                } else {
                                                    ProgressBar.setVisibility(View.GONE);
                                                    cardView.setVisibility(View.VISIBLE);
                                                    Toast.makeText(getApplicationContext(), "Registration Number is Invalid...", Toast.LENGTH_LONG).show();
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<RcDataClass> call, Throwable t) {

                                            }
                                        });
                                    } else {
                                        ProgressBar.setVisibility(View.GONE);
                                        cardView.setVisibility(View.VISIBLE);
                                        Toast.makeText(getApplicationContext(), "Driving License Number is Invalid...", Toast.LENGTH_LONG).show();

                                    }

                                } else {
                                    cardView.setVisibility(View.VISIBLE);
                                    ProgressBar.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(), "Name and DOB do not match with aadhar card detail... ", Toast.LENGTH_LONG).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<BlogDetailsModalClass> call, Throwable t) {
                                Log.d("digvijay", t.toString());
                            }
                        });

                    } else {

                        cardView.setVisibility(View.VISIBLE);
                        ProgressBar.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Invalid Aadhar Number....", Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<AadharDetailClass> call, Throwable t) {

                }
            });

        }
    }


