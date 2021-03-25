package com.example.tabletappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    private Button mLogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogScreen();
            }
        });


    }


    public void goToLogScreen(){
         Intent intnet = new Intent(this,Log.class);
         startActivity(intnet);
    }



    public void creatWigdets(){
        mLogBtn = findViewById(R.id.mainScreenGoToLogBtn);
    }

}