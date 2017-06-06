package com.example.homepagemod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etName = (EditText)findViewById(R.id.etName);
        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etPassword = (EditText)findViewById(R.id.etPassword);
        final EditText etConPass = (EditText)findViewById(R.id.etConPass);
        final EditText etCarType = (EditText)findViewById(R.id.etCarType);
        final EditText etPlate = (EditText)findViewById(R.id.etPlate);
        final EditText etEmail = (EditText)findViewById(R.id.etEmail);
        final Button bRegister = (Button)findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bRegisterIntent = new Intent(RegisterActivity.this, LogInPage.class);
                RegisterActivity.this.startActivity(bRegisterIntent);

            }
        });










    }

    /*public void onRegisterClick(View v) {
        if (v.getId() == R.id.bLogin) {

            EditText etName = (EditText) findViewById(R.id.etName);
            EditText etUsername = (EditText) findViewById(R.id.etUsername);
            EditText etPassword = (EditText) findViewById(R.id.etPassword);
            EditText etConPass = (EditText) findViewById(R.id.etConPass);
            EditText etCarType = (EditText) findViewById(R.id.etCarType);
            EditText etPlate = (EditText) findViewById(R.id.etPlate);
            EditText etEmail = (EditText) findViewById(R.id.etEmail);

            String Namestr = etName.getText().toString();
            String Usernamestr = etUsername.getText().toString();
            String Passwordstr = etPassword.getText().toString();
            String ConPassstr = etConPass.getText().toString();
            String CarTypestr = etCarType.getText().toString();
            String Platestr = etPlate.getText().toString();
            String Emailstr = etEmail.getText().toString();

            if (!Passwordstr.equals(ConPassstr)) {
                //msg popup saying the passwords do not match

                Toast pass = Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT);
                pass.show();


            } else {
                //put the info into database

                Contact c = new Contact();
                c.setFullName(Namestr);
                c.setUsername(Usernamestr);
                c.setCarType(CarTypestr);
                c.setLicensePlate(Platestr);
                c.setEmail(Emailstr);

                helper.insertContact(c);
            }

            Button bRegister = (Button) findViewById(R.id.bRegister);

            bRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent bRegisterIntent = new Intent(RegisterActivity.this, LogInPage.class);
                    RegisterActivity.this.startActivity(bRegisterIntent);
                    //changes the activity from Register to Login activity

                }
            });


        }
    }*/
}
