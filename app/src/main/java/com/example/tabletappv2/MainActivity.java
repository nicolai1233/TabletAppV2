package com.example.tabletappv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TextView mPassword,mUsername, mFaliledText;
    private Button mLogin;
    private FirebaseAuth fAuth;
    private ProgressBar mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();
        createWigedt();

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInformation();
            }
        });

    }


    public void checkInformation() {
        mBar.setVisibility(View.VISIBLE);


        String email = mUsername.getText().toString().trim();

        String password = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            mBar.setVisibility(View.GONE);
            mUsername.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            mBar.setVisibility(View.GONE);
            mPassword.setError("Password is Required");
            return;
        }

        login(email, password);

    }


    public void login(String name, String password){
        fAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    goToMainScreen();

                }
                mBar.setVisibility(View.INVISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mUsername.setError("Username or password was worng");
            }
        });
    }


    public void goToMainScreen(){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }


    public void createWigedt(){
        mPassword = findViewById(R.id.loginPasswordPt);
        mUsername = findViewById(R.id.loginUsernamePT);
        mLogin = findViewById(R.id.loginBtn);
        mFaliledText = findViewById(R.id.faliledToLoginText);
        mBar = findViewById(R.id.loginSpinner);

    }


}