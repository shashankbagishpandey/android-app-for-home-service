package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

public class otpverification extends AppCompatActivity {

    TextView getotp;
    EditText enternumber;
    ProgressBar progressBar;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        getSupportActionBar().hide();

        enternumber=findViewById(R.id.input_mobile_field);
        getotp=findViewById(R.id.getotp);
        mAuth =FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressbar_sending_otp);

        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!enternumber.getText().toString().trim().isEmpty()){

                    if (enternumber.getText().toString().trim().length()==10){

                        progressBar.setVisibility(View.VISIBLE);
                        getotp.setVisibility(View.INVISIBLE);
                        otpsend();

//                            progressBar.setVisibility(View.VISIBLE);
//                            getotp.setVisibility(View.INVISIBLE);

//                         PhoneAuthOptions options =
//                                 PhoneAuthOptions.newBuilder(mAuth)
//                                         .setPhoneNumber(enternumber)       // Phone number to verify
//                                         .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                                         .setActivity(this)                 // Activity (for callback binding)
//                                         .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                                         .build();
//                         PhoneAuthProvider.verifyPhoneNumber(options);

//
                    }else {
                        Toast.makeText(otpverification.this,"please enter the correct number",Toast.LENGTH_SHORT).show();

                    }

                }else{
                    Toast.makeText(otpverification.this,"enter  mobile number",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void otpsend(){

        progressBar.setVisibility(View.VISIBLE);
        getotp.setVisibility(View.INVISIBLE);




        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                getotp.setVisibility(View.VISIBLE);

                Toast.makeText(otpverification.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                progressBar.setVisibility(View.GONE);
                getotp.setVisibility(View.VISIBLE);

                Intent i=new Intent(getApplicationContext(),otpsent.class);
                i.putExtra("mobile",enternumber.getText().toString().trim());
                i.putExtra("verificationId",verificationId);
                startActivity(i);
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+enternumber.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
}