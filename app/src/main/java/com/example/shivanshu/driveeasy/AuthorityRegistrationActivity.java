package com.example.shivanshu.driveeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorityRegistrationActivity extends AppCompatActivity {

    EditText etPoliceId;
    EditText etAadhaar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiateViews();
        setContentView(R.layout.activity_authority_registration_actitivty);

    }

    private void initiateViews() {
        etPoliceId= (EditText) findViewById(R.id.police_id_number);
        etAadhaar= (EditText) findViewById(R.id.aadhar_numbmer);
    }
    public void onSubmit(View v){
        if (etPoliceId.getText()==null){
            etPoliceId.setError("Please type your unique police id");
        }else if (etAadhaar.getText()==null){
            etAadhaar.setError("Please type your aadhaar number");
        }else{
            Call<BlogDetailsModalClass> fetchWordListCall= RetrofitObject.getRetrofitObject("http://private-a1db2-policeidverification.apiary-mock.com").getPoliceIdList(etPoliceId.getText().toString());
            fetchWordListCall.enqueue(new Callback<BlogDetailsModalClass>() {
                @Override
                public void onResponse(Call<BlogDetailsModalClass> call, Response<BlogDetailsModalClass> response) {

                }

                @Override
                public void onFailure(Call<BlogDetailsModalClass> call, Throwable t) {

                }
            });
        }
    }
}
