package com.example.tabletappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TextView mPassword,mUsername;
    private Button mLogin;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();
        createWigedt();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainScreen();
            }
        });



    }


    public void login(){

    }


    public void goToMainScreen(){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }


    public void createWigedt(){
        mPassword = findViewById(R.id.loginPasswordPt);
        mUsername = findViewById(R.id.loginUsernamePT);
        mLogin = findViewById(R.id.loginBtn);



    }


}