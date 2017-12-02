package com.example.shivanshu.driveeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorityRegistrationActivity extends AppCompatActivity {

    EditText etPoliceId;
    EditText etAadhaar;
    LinearLayout progressBar;
    CardView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_registration_actitivty);
        initiateViews();

    }

    private void initiateViews() {
        etPoliceId= (EditText) findViewById(R.id.police_id_number);
        etAadhaar= (EditText) findViewById(R.id.aadhar_numbmer);
        progressBar= (LinearLayout) findViewById(R.id.progress_war);
        cv= (CardView) findViewById(R.id.card_view);
    }
    public void onSubmit(View v){
        if (etPoliceId.getText().toString().equals("")){
            etPoliceId.setError("Please type your unique police id");
        }else if (etAadhaar.getText().toString().equals("")){
            etAadhaar.setError("Please type your aadhaar number");
        }else{
            cv.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Call<BlogDetailsModalClass> fetchWordListCall= RetrofitObject.getRetrofitObject("http://private-a1db2-policeidverification.apiary-mock.com").getPoliceIdList(etPoliceId.getText().toString());
            fetchWordListCall.enqueue(new Callback<BlogDetailsModalClass>() {
                @Override
                public void onResponse(Call<BlogDetailsModalClass> call, Response<BlogDetailsModalClass> response) {
                    final Response<BlogDetailsModalClass> policeIdResponse = response;
                    progressBar.setVisibility(View.GONE);
                    cv.setVisibility(View.VISIBLE);
                    //TODO aadhaar
                }

                @Override
                public void onFailure(Call<BlogDetailsModalClass> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    cv.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
