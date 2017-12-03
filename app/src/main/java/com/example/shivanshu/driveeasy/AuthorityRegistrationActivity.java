package com.example.shivanshu.driveeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorityRegistrationActivity extends AppCompatActivity {

    EditText etPoliceId;
    EditText AadharNumber;
    LinearLayout ProgressBar;
    TextView Progress;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_registration_actitivty);
        initiateViews();

    }

    private void initiateViews() {
        etPoliceId = (EditText) findViewById(R.id.police_id_number);
        AadharNumber = (EditText) findViewById(R.id.aadhar_numbmer);
        ProgressBar = (LinearLayout) findViewById(R.id.progress_war);
        Progress = (TextView) findViewById(R.id.progress_text);
        cardView = (CardView) findViewById(R.id.card_view);
    }

    public void onSubmit(View v) {
        if (etPoliceId.getText().toString().equals("")) {
            etPoliceId.setError("Please type your unique police id");
        } else if (AadharNumber.getText().toString().equals("")) {
            AadharNumber.setError("Please type your aadhaar number");
        } else {
            Progress.setText("Please wait we are validating you...");
            ProgressBar.setVisibility(View.VISIBLE);
            cardView.setVisibility(View.GONE);
            Call<AadharDetailClass> fetchAadahrDetail = RetrofitObject.getRetrofitObject("http://private-686ca-aadhaarverification.apiary-mock.com/").getAadharDetails(AadharNumber.getText().toString());
            fetchAadahrDetail.enqueue(new Callback<AadharDetailClass>() {
                @Override
                public void onResponse(Call<AadharDetailClass> call, Response<AadharDetailClass> response) {
                    AadharDetailClass aadharDetailClass = response.body();
                    if (aadharDetailClass.getStatus().equals("ok")) {
                        final FinalSubmissionForm finalSubmissionForm = new FinalSubmissionForm();
                        finalSubmissionForm.setFullName(aadharDetailClass.getAadharDetail().getName());
                        finalSubmissionForm.setDOB(aadharDetailClass.getAadharDetail().getDob());
//                        finalSubmissionForm.setAddress(aadharDetailClass.getAadharDetail().getAddress());
//                        finalSubmissionForm.setAadharCardNumber(aadharDetailClass.getAadharDetail().getAadharNumber());
//                        final String name = finalSubmissionForm.getFullName();
                        final String name="Harshit Agarwal";
                        final String Dob = finalSubmissionForm.getDOB();

                        Call<BlogDetailsModalClass> fetchWordListCall = RetrofitObject.getRetrofitObject("http://private-a1db2-policeidverification.apiary-mock.com/").getPoliceIdList(etPoliceId.getText().toString());
                        fetchWordListCall.enqueue(new Callback<BlogDetailsModalClass>() {
                            @Override
                            public void onResponse(Call<BlogDetailsModalClass> call, Response<BlogDetailsModalClass> response) {
                                Progress.setText("Please wait while we fetch Your Police License Details...");
                                BlogDetailsModalClass blogDetailsModalClass = response.body();
                                if (blogDetailsModalClass.getStatus().equals("ok")) {
                                    BlogDetailsModalClass.DlDetails dlDetails = blogDetailsModalClass.getDlDetails();

//                                    if (dlDetails.getName().equals(name) && dlDetails.getDob().equals(Dob)) {
//
//                                        finalSubmissionForm.setDlNumber(dlDetails.getDlNo());
//                                        //finalSubmissionForm.setDOB(dlDetails.getDob());
//                                        //finalSubmissionForm.setFullName(dlDetails.getName());
////                                        finalSubmissionForm.setIssueDate(dlDetails.getDateOfissue());
////                                        finalSubmissionForm.setValidity(dlDetails.getExpiryDate());
////                                        Intent intent = PoliceAuthVerification.getintent(getApplicationContext(), finalSubmissionForm);
////                                        ProgressBar.setVisibility(View.GONE);
////                                        cardView.setVisibility(View.VISIBLE);
////                                        startActivity(intent);
//                                    } else {
//                                        ProgressBar.setVisibility(View.GONE);
//                                        cardView.setVisibility(View.VISIBLE);
//                                        Toast.makeText(getApplicationContext(), "Police License Number is Invalid...", Toast.LENGTH_LONG).show();
//
//                                    }
//
//                                } else {
//                                    cardView.setVisibility(View.VISIBLE);
//                                    ProgressBar.setVisibility(View.GONE);
//                                    Toast.makeText(getApplicationContext(), "Name and DOB do not match with aadhar card detail... ", Toast.LENGTH_LONG).show();
//
//                                }
                                    Intent intent=new Intent(getApplicationContext(),PoliceAuthVerification.class);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onFailure(Call<BlogDetailsModalClass> call, Throwable t) {
                                Log.d("Harshit",t.toString());
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<AadharDetailClass> call, Throwable t) {
                    Log.d("Harshit",t.toString());
                }
            });
        }
    }
}