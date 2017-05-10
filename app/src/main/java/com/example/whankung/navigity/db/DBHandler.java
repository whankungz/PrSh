package com.example.whankung.navigity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.whankung.navigity.services.Disease.DRequest;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * Created by macbookpro on 5/5/2017 AD.
 */

public class DBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    //  private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
    private static final String TABLE_CONTACTS = "Disease";
    private static final String KEY_NAME_D = "dName";
    private static final String KEY_NAME_H = "hName";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_NAME_D + " TEXT,"
                + KEY_NAME_H + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }


    public List<DRequest> getAllShops() {
        List<DRequest> dList = new ArrayList<DRequest>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DRequest d = new DRequest();
                d.setDiseaseName(cursor.getString(0));
                d.setHerb(cursor.getString(1));

// Adding contact to list
                dList.add(d);
            } while (cursor.moveToNext());
        }

// return contact list
        return dList;
    }
    public void addContact(DRequest dRequest) {

      SQLiteDatabase db = this.getWritableDatabase();
      //  SQLiteDatabase db =getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_D, dRequest.getDiseaseName()); // Contact Name
        values.put(KEY_NAME_H, dRequest.getHerb()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);

        db.close(); // Closing database connection

    }


}