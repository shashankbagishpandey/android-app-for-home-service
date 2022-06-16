package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    TextView date;
    EditText address;
    RadioButton slot;
    RadioGroup rg;
    DatePickerDialog picker;
    DatabaseReference detailDBRef;
    FirebaseDatabase firebaseDatabase;  //instance like table name



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address=(EditText) findViewById(R.id.detail_address);
        date=(TextView)findViewById(R.id.detail_date);
        rg=(RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();



        firebaseDatabase=FirebaseDatabase.getInstance("https://test-495ce-default-rtdb.asia-southeast1.firebasedatabase.app/");
        detailDBRef=firebaseDatabase.getReference("ddetail");




        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cl=Calendar.getInstance();
                int day=cl.get(Calendar.DAY_OF_MONTH);
                int month=cl.get(Calendar.MONTH);
                int year=cl.get(Calendar.YEAR);

                picker=new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofMonth){
                        date.setText( dayofMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                picker.show();
            }
        });

        Button nxt=findViewById(R.id.detail_next);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectslot=rg.getCheckedRadioButtonId();
                slot=findViewById(selectslot);

                String add=address.getText().toString();
                String  sl;
                String service_date=date.getText().toString();
                if(TextUtils.isEmpty(add)){

                }else if(rg.getCheckedRadioButtonId() ==-1){
                }else if(TextUtils.isEmpty(service_date)){

                }
                else{
                    sl=slot.getText().toString();
                    detailadding(add,sl,service_date);
//                    detailDBRef.setValue("detailll");


                }
            }
        });

    }

    private void detailadding(String add, String sl,String service_date) {
        detail detail=new detail(service_date,sl,add);
        detailDBRef.push().setValue(detail);
        Intent i=new Intent(getApplicationContext(),reqsubmit.class);
        startActivity(i);
        finish();
//        to store in firebase



//
//        Toast.makeText(servicedetail.this,"data added",Toast.LENGTH_SHORT).show();


    }
}