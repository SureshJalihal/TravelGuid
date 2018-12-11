package com.example.admin.trave2explore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    private EditText TextEmailID;
    private EditText TextPassword;
    private FirebaseAuth firebaseAuth;
    private Button SavetoFireStore;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SavetoFireStore = (Button) findViewById(R.id.Login);
        TextEmailID = (EditText) findViewById(R.id.EmailId);
        TextPassword = (EditText) findViewById(R.id.Password);
        firebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        final String EmailI=TextEmailID.getText().toString();
        final String password=TextPassword.getText().toString();


        SavetoFireStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextEmailID.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Enter EmailID", Toast.LENGTH_LONG).show();
                    TextEmailID.requestFocus();
                }

                if (TextPassword.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Enter EmailID and Password", Toast.LENGTH_LONG).show();
                    TextPassword.requestFocus();
                }

                btnUserLogIn(view);
                String Email = TextEmailID.getText().toString();
                String Password = TextPassword.getText().toString();

                Map<String, String> userMap = new HashMap<>();
                userMap.put("EmailId", Email);
                userMap.put("Password", Password);


                mFirestore.collection("Users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(LoginActivity.this, "Username And Password Added To FireStore", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


    public void btnUserLogIn(View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"Please Wait...","Processing...",true);
        (firebaseAuth.signInWithEmailAndPassword(TextEmailID.getText().toString(),TextPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            //user is succesfully registered

                            Toast.makeText(LoginActivity.this,"User LOGIN Successfully DONE", Toast.LENGTH_LONG).show();
                            Intent i =new Intent(LoginActivity.this,homepage.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else{
                            Log.e("Error. LOGIN Again", task.getException().toString());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String error =e.getMessage();
                Toast.makeText(LoginActivity.this,"Error:"+error,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
