package com.example.homepagemod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bRegister;
    private EditText etName, etUsername, etPassword, etConPass, etCarType, etPlate, etEmail;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = new DataBaseHelper(this);
        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConPass = (EditText) findViewById(R.id.etConPass);
        etCarType = (EditText) findViewById(R.id.etCarType);
        etPlate = (EditText) findViewById(R.id.etPlate);
        etEmail = (EditText) findViewById(R.id.etEmail);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);


    }
        @Override
            public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bRegister:
                    register();
                    break;
                //can create another case for a log in button
                /*case R.id.bLogin:
                    startActivity(new Intent(RegisterActivity.this, LogInPage.class);
                    finish();
                    break;
                */
                default:
            }

        }

        private void register() {
            String name = etName.getText().toString();
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String conpassword = etConPass.getText().toString();
            String cartype = etCarType.getText().toString();
            String licenseplate = etPlate.getText().toString();
            String email = etEmail.getText().toString();

            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || conpassword.isEmpty() || cartype.isEmpty() || licenseplate.isEmpty() || email.isEmpty()) {
                displayToast("Some fields are not filled in");
            } else {
                db.addData(name, username, password, cartype, licenseplate, email);
                displayToast("User registed");
                finish();
            }
        }
        private void displayToast(String msg) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        }


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

