package com.example.homepagemod;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by alice on 5/31/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    //columns and names for columns.

    private static final String TAG = "DataBaseHelper";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "rucharged.db"; //name of the database
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";                       // col 1
    private static final String COLUMN_NAME = "name";                   // col 2
    private static final String COLUMN_USERNAME = "username";           // col 3
    private static final String COLUMN_PASSWORD = "password";           // col 4
    private static final String COLUMN_CARTYPE = "cartype";             // col 5
    private static final String COLUMN_LICENSEPLATE = "licenseplate";   // col 6
    private static final String COLUMN_EMAIL = "email";                 // col 7

    SQLiteDatabase db;

    //constructor
    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE" + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT)"
                + COLUMN_ID +"TEXT" //query that we create to execute
                + COLUMN_NAME +"TEXT"
                + COLUMN_USERNAME +"TEXT"
                + COLUMN_PASSWORD +"TEXT"
                + COLUMN_CARTYPE +"TEXT"
                + COLUMN_LICENSEPLATE +"TEXT"
                + COLUMN_EMAIL +"TEXT";

        db.execSQL(createTable); // executes the query you pass inside this method. Our query is createTable
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j){
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Storing the details into the database

    public boolean addData(String name, String username, String password, String CarType, String LicensePlate, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_CARTYPE, CarType);
        values.put(COLUMN_LICENSEPLATE, LicensePlate);
        values.put(COLUMN_EMAIL, email);

        long result = db.insert(TABLE_NAME, null, values);

        Log.d(TAG, "addDate: Adding to" + TABLE_NAME + result);

        //If the data is inserted incorrectly it will return the following
        if(result == -1) {
            return false;
        }else{
            return true;
        }

    }

    public boolean getUser(String username, String password){
        //HashMap<String, String> user = new HashMap<String, String>();

        String selectQuery = "select + from " + TABLE_NAME + "where" + COLUMN_USERNAME + "="
                + "'" + username + "'" + " and where" + COLUMN_PASSWORD + "=" + "'" + password +"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Move the cursor to the first row
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            //user.put("email", cursor.getString(1));
            return true;
        }

        cursor.close();
        db.close();
        return false;
    }






    /*private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

*/








    /*public void insertContact(Contact c ){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);

        values.put(COLUMN_NAME, c.getFullName());
        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_CARTYPE, c.getCarType());
        values.put(COLUMN_LICENSEPLATE, c.getLicensePlate());
        values.put(COLUMN_EMAIL, c.getEmail());

        //insert contact into the data base
        db.insert(TABLE_NAME, null, values);

    }
    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "select Username, pass from" +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String username, password;
        password = "Not found";
        if(cursor.moveToFirst()){
            do{
                username = cursor.getString(0);
                password = cursor.getString(1);

                if(username.equals(uname)){
                    password = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return password;
    }*/



}
