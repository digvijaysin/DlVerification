package com.example.shivanshu.driveeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void onAuthorityClick(View view){
        Intent intent=new Intent(this,AuthorityRegistrationActivity.class);
        startActivity(intent);
    }
    public void onPublicClick(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}