package com.example.homepagemod;

import java.io.StringReader;
import java.util.Map;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by alice on 6/5/2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL = "files.000webhost.com/Register.php";

    private Map<String, String> parans;

    public RegisterRequest(String name,String username, String cont, Response.Listener<String> listener){


    }

}

//Error here for the StringRequest because we need to make a class or import from the volley server. 
