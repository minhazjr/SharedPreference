package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView1, textView2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);

        button1=findViewById(R.id.storeId);
        button2=findViewById(R.id.LoadId);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadData();
            }
        });


    }

    public void saveData(){
        String fname=editText1.getText().toString();
        String lname=editText2.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences("myFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("fnameKey", fname);
        editor.putString("lnameKey", lname);
        editor.commit();
        Toast.makeText(MainActivity.this,"Save Successfully",Toast.LENGTH_SHORT).show();
    }

    public void LoadData(){

        SharedPreferences sharedPreferences=getSharedPreferences("myFile", Context.MODE_PRIVATE);


            if (sharedPreferences.contains("fnameKey") && sharedPreferences.contains("lnameKey")){

            String FirstName=  sharedPreferences.getString("fnameKey","First Name Not Found");
            String LastName= sharedPreferences.getString("lnameKey","Last Name Not Found");
            textView1.setText(FirstName);
            textView2.setText(LastName);

            }
            else {
                Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_SHORT).show();

            }

    }

}