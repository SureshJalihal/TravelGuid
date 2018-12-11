package com.example.admin.trave2explore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.PatternMatcher;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.common.UserRecoverableException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {

    private Button buttonRegister;
    private EditText TextEmailID;
    private EditText TextPassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        buttonRegister = (Button) findViewById(R.id.register);
        TextEmailID = (EditText) findViewById(R.id.EmailID);
        TextPassword = (EditText) findViewById(R.id.Password);
        firebaseAuth = FirebaseAuth.getInstance();

        final String EmailID=TextEmailID.getText().toString();
        final String EPassword=TextPassword.getText().toString();


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(SignIn.this, "Register Button Clicked", Toast.LENGTH_LONG).show();
                if (TextEmailID.getText().toString().equals("")) {
                    Toast.makeText(SignIn.this, "Enter EmailID", Toast.LENGTH_LONG).show();
                    TextEmailID.requestFocus();
                }

                if (TextPassword.getText().toString().equals("")) {
                    Toast.makeText(SignIn.this, "Enter EmailID and Password", Toast.LENGTH_LONG).show();
                    TextPassword.requestFocus();
                }
                btnregister(v);
            }
        });
    }
        public void btnregister (View v)


        {
            final ProgressDialog progressDialog = ProgressDialog.show(SignIn.this, "Please Wait...", "Processing...", true);
            (firebaseAuth.createUserWithEmailAndPassword(TextEmailID.getText().toString(), TextPassword.getText().toString()))
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override

                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {

                                //user is succesfully registered

                                Toast.makeText(SignIn.this, "User Resgistered Successfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(SignIn.this, LoginActivity.class);
                            } else if (!task.isSuccessful()) {
                                Log.e("Error. Register Again", task.getException().toString());
                                Toast.makeText(SignIn.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                            finish();
                        }
                    });

        }
    }

