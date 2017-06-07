package com.example.homepagemod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    private Button bLogOut;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etLicensePlate = (EditText)findViewById(R.id.etLicensePlate);
        final TextView Welcome = (TextView)findViewById(R.id.tvWelcome);

        final Button bSpot1 = (Button)findViewById(R.id.bSpot1);
        final Button bSpot2 = (Button)findViewById(R.id.bSpot2);
        final Button bSpot3 = (Button)findViewById(R.id.bSpot3);
        final Button bSpot4 = (Button)findViewById(R.id.bSpot4);

        session = new Session(this);
        if(!session.loggedIn()){
            logout();
        }

        bLogOut = (Button)findViewById(R.id.bLogOut);


        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        bSpot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bSpot1Intent = new Intent(WelcomePage.this, Spot1Location.class );
                WelcomePage.this.startActivity(bSpot1Intent);
            }
        });

        bSpot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bSpot2Intnet = new Intent(WelcomePage.this, Spot2Location.class);
                WelcomePage.this.startActivity(bSpot2Intnet);
            }
        });

        bSpot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bSpot3Intent = new Intent(WelcomePage.this, Spot3Location.class);
                WelcomePage.this.startActivity(bSpot3Intent);
            }
        });

        bSpot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bSpot4Intent = new Intent(WelcomePage.this, Spot4Location.class);
                WelcomePage.this.startActivity(bSpot4Intent);
            }
        });
    }
    private void logout(){
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(WelcomePage.this, LogInPage.class));

    }

}

