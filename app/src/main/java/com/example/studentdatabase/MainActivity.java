package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etName, etAge, etAddress;
Button button;
StudentDatabaseSource studentDatabaseSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        studentDatabaseSource = new StudentDatabaseSource (this);
        etName = findViewById (R.id.etname);
        etAge = findViewById (R.id.etage);
        etAddress = findViewById (R.id.etaddress);


        button = findViewById (R.id.btn1);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                StudentModel studentModel = new StudentModel (etName.getText ().toString (), Integer.valueOf (etAge.getText ().toString ()), etAddress.getText ().toString ());


                boolean status = studentDatabaseSource.AddStudent (studentModel);
                if(status){
                    Toast.makeText (MainActivity.this, " Saved", Toast.LENGTH_SHORT).show ();
                }else
                    Toast.makeText (MainActivity.this,"Not Saved",Toast.LENGTH_SHORT).show ();
            }
        });
    }
}