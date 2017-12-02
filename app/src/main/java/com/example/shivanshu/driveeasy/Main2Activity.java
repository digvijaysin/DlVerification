package com.example.shivanshu.driveeasy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
//ListView listView;
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
        submitButton=(Button)findViewById(R.id.final_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
