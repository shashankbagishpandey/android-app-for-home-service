package com.example.test;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class otpsent extends AppCompatActivity {

    EditText inputnumber1,inputnumber2,inputnumber3,inputnumber4,inputnumber5,inputnumber6;
    private String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpsent);

        ProgressBar progressBar=findViewById(R.id.progressbar_verify_otp);

        TextView verifybuttonclick=findViewById(R.id.buttongetotp);
        TextView textresendotp=findViewById(R.id.textresendotp);

        inputnumber1=findViewById(R.id.inputotp1);
        inputnumber2=findViewById(R.id.inputotp2);
        inputnumber3=findViewById(R.id.inputotp3);
        inputnumber4=findViewById(R.id.inputotp4);
        inputnumber5=findViewById(R.id.inputotp5);
        inputnumber6=findViewById(R.id.inputotp6);

        TextView textView=findViewById(R.id.showmobilenumber);
        textView.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));
        verificationId=getIntent().getStringExtra("verificationId");


        textresendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(otpsent.this,"otp sent ",Toast.LENGTH_SHORT).show();
            }
        });

        verifybuttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                verifybuttonclick.setVisibility(View.INVISIBLE);

                if (inputnumber1.getText().toString().trim().isEmpty()
                        || inputnumber2.getText().toString().trim().isEmpty()
                        || inputnumber3.getText().toString().trim().isEmpty()
                        || inputnumber4.getText().toString().trim().isEmpty()
                        || inputnumber5.getText().toString().trim().isEmpty()
                        || inputnumber6.getText().toString().trim().isEmpty() ){

                    Toast.makeText(otpsent.this,"please enter all number",Toast.LENGTH_SHORT).show();

                }else {

                    if (verificationId!=null){

                        String code=inputnumber1.getText().toString().trim()+
                                inputnumber2.getText().toString().trim()+
                                inputnumber3.getText().toString().trim()+
                                inputnumber4.getText().toString().trim()+
                                inputnumber5.getText().toString().trim()+
                                inputnumber6.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                        FirebaseAuth
                                .getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){

                                            progressBar.setVisibility(View.VISIBLE);
                                            verifybuttonclick.setVisibility(View.INVISIBLE);


                                            Intent i=new Intent(otpsent.this,homepage.class);
                                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(i);


                                        }else {
                                            progressBar.setVisibility(View.GONE);
                                            verifybuttonclick.setVisibility(View.VISIBLE);

                                            Toast.makeText(otpsent.this,"invalid otp",Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });

                    }
                }
            }
        });

        numberotpmove();


    }

    private void numberotpmove() {

        inputnumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputnumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputnumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}