package com.example.homepagemod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInPage extends AppCompatActivity implements View.OnClickListener{

    private Button bLogin, bRegisterHere;
    private EditText etUsername, etPassword;
    private DataBaseHelper db;
    private Session session;

    // = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        db = new DataBaseHelper(this);
        session = new Session(this);

        bLogin = (Button) findViewById(R.id.bLogin);
        bRegisterHere = (Button) findViewById(R.id.bRegisterHere);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogin.setOnClickListener(this);
        bRegisterHere.setOnClickListener(this);


        if(session.loggedIn()){
            startActivity(new Intent(LogInPage.this, WelcomePage.class));
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegisterHere:
                startActivity(new Intent(LogInPage.this, RegisterActivity.class));
                break;
            case R.id.bLogin:
                login();
                break;
            default:

        }
    }

    public void login(){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if(db.getUser(username,password)){
            session.setLoggedIn(true);
            startActivity(new Intent(LogInPage.this, WelcomePage.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Wrong username/password", Toast.LENGTH_SHORT).show();
        }

    }








        /*bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                *//*String newEntry = etUsername.getText().toString();
                if(etUsername.length()!=0){
                    AddData(newEntry);

                }else{
                    ToastMsg("You must put some text in the field!");
                }

                Video example https://www.youtube.com/watch?v=aQAIMY-HzL8
                *//*







                etUsername = (EditText) findViewById(R.id.etUsername);
                String str = etUsername.getText().toString();
                etPassword = (EditText)findViewById(R.id.etPassword);
                String pass = etPassword.getText().toString();


                //Opens database to look into the matching passwords and usernames
                String password = mDataBaseHelper.searchPass(str);

                if(pass.equals(password)) {

                    Intent bLoginIntent = new Intent(LogInPage.this, MainActivity.class);
                    LogInPage.this.startActivity(bLoginIntent);

                }else{
                    //Checks to see if the Uername and the Password match in the database
                    Toast temp = Toast.makeText(LogInPage.this, "Username and Password do not match", Toast.LENGTH_SHORT);
                    temp.show();

                }


            }
        });


        bRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bRegiserHereIntent = new Intent(LogInPage.this, RegisterActivity.class);
                LogInPage.this.startActivity(bRegiserHereIntent);

            }
        });

    }
*/
   /* public void AddData(String newEntry){
        boolean insertData = mDataBaseHelper.addData(newEntry);

        if(insertData){
            ToastMsg("Data Successfully Inserted!");
        }else{
            ToastMsg("Something went wrong");
        }


    }*/


    /*private void ToastMsg(String msg){

        Toast.makeText(this.msg, Toast.LENGTH_SHORT).show();


    }*/


        /*public void onLogInClick(View v){
        if(v.getId() == R.id.bLogin) {

            EditText Username = (EditText) findViewById(R.id.etUsername);
            String str = Username.getText().toString();
            EditText Password = (EditText)findViewById(R.id.etPassword);
            String pass = Password.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){
                Intent nextIntent = new Intent(LogInPage.this, MainActivity.class);
                LogInPage.this.startActivity(nextIntent);
            }else{
                Toast temp = Toast.makeText(LogInPage.this, "Username and Password do not match", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
         if(v.getId() == R.id.bRegisterHere){
             Intent nextIntent = new Intent(LogInPage.this, RegisterActivity.class);
             LogInPage.this.startActivity(nextIntent);
         }

    }*/
}
