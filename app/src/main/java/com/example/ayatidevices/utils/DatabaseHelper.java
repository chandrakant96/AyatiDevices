package com.example.ayatidevices.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String TAG = "DatabaseHelper";

    private SQLiteDatabase db;
    private int connection_count = 0;

    private final String USERS_TABLE = "users_table";

    private final String USER_ID = "id";
    private final String USER_TYPE = "user_type";
    private final String USER_NAME = "user_name";
    private final String USER_NUMBER = "user_number";
    private final String USER_CITY = "user_city";
    private final String USER_DOB = "user_dob";
    private final String USER_PREVIOUS_ULCER_HISTORY = "previous_ulcer_history";
    private final String USER_SERVER_UPLOAD_FLAG = "server_upload_flag";
    private final String USER_FIREBASE_ID = "firebase_id";
    private final String USER_CREATED_AT = "created_at";

    // Create user table SQL query
    private final String CREATE_USER_TABLE =
            "CREATE TABLE " + USERS_TABLE + "("
                    + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USER_TYPE + " TEXT,"
                    + USER_NAME + " TEXT,"
                    + USER_NUMBER + " TEXT,"
                    + USER_CITY + " TEXT,"
                    + USER_DOB + " TEXT,"
                    + USER_PREVIOUS_ULCER_HISTORY + " TEXT,"
                    + USER_SERVER_UPLOAD_FLAG + " TEXT,"
                    + USER_FIREBASE_ID + " TEXT,"
                    + USER_CREATED_AT + " TEXT"
                    + ")";

    private final String POSITION_ONE_TABLE = "position_one_table";

    private final String POSITION_ONE_ID = "position_one_id";
    private final String POSITION_ONE_USER_ID = "position_one_user_id";
    private final String POSITION_ONE_USER_TYPE = "position_one_user_type";
    private final String POSITION_ONE_USER_FIREBASE_ID = "position_one_user_firebase_id";
    private final String POSITION_ONE_LEG_POSITION = "position_one_leg_position";
    private final String POSITION_ONE_DATA_F = "position_one_data_f";
    private final String POSITION_ONE_DATA_D = "position_one_data_d";
    private final String POSITION_ONE_VPT = "position_one_vpt";
    private final String POSITION_ONE_TPT = "position_one_tpt";
    private final String POSITION_ONE_SEVERITY = "position_one_severity";
    private final String POSITION_ONE_DATE = "position_one_date";
    private final String POSITION_ONE_SERVER_UPLOAD_FLAG = "position_one_server_upload_flag";
    private final String POSITION_ONE_FIREBASE_ID = "position_one_firebase_id";
    private final String POSITION_ONE_IMEI = "position_one_imei";


    // Create position one table SQL query
    private final String CREATE_POSITION_ONE_TABLE =
            "CREATE TABLE " + POSITION_ONE_TABLE + "("
                    + POSITION_ONE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + POSITION_ONE_USER_ID + " TEXT,"
                    + POSITION_ONE_USER_TYPE + " TEXT,"
                    + POSITION_ONE_USER_FIREBASE_ID + " TEXT,"
                    + POSITION_ONE_LEG_POSITION + " TEXT,"
                    + POSITION_ONE_DATA_F + " TEXT,"
                    + POSITION_ONE_DATA_D + " TEXT,"
                    + POSITION_ONE_VPT + " TEXT,"
                    + POSITION_ONE_TPT + " TEXT,"
                    + POSITION_ONE_SEVERITY + " TEXT,"
                    + POSITION_ONE_DATE + " TEXT,"
                    + POSITION_ONE_SERVER_UPLOAD_FLAG + " TEXT,"
                    + POSITION_ONE_FIREBASE_ID + " TEXT,"
                    + POSITION_ONE_IMEI + " TEXT"
                    + ")";


    private final String POSITION_TWO_TABLE = "position_two_table";

    private final String POSITION_TWO_ID = "position_two_id";
    private final String POSITION_TWO_USER_ID = "position_two_user_id";
    private final String POSITION_TWO_USER_TYPE = "position_two_user_type";
    private final String POSITION_TWO_USER_FIREBASE_ID = "position_two_user_firebase_id";
    private final String POSITION_TWO_LEG_POSITION = "position_two_leg_position";
    private final String POSITION_TWO_DATA_F = "position_two_data_f";
    private final String POSITION_TWO_DATA_D = "position_two_data_d";
    private final String POSITION_TWO_VPT = "position_two_vpt";
    private final String POSITION_TWO_TPT = "position_two_tpt";
    private final String POSITION_TWO_SEVERITY = "position_two_severity";
    private final String POSITION_TWO_DATE = "position_two_date";
    private final String POSITION_TWO_SERVER_UPLOAD_FLAG = "position_two_server_upload_flag";
    private final String POSITION_TWO_FIREBASE_ID = "position_two_firebase_id";
    private final String POSITION_TWO_IMEI = "position_two_imei";


    // Create position two table SQL query
    private final String CREATE_POSITION_TWO_TABLE =
            "CREATE TABLE " + POSITION_TWO_TABLE + "("
                    + POSITION_TWO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + POSITION_TWO_USER_ID + " TEXT,"
                    + POSITION_TWO_USER_TYPE + " TEXT,"
                    + POSITION_TWO_USER_FIREBASE_ID + " TEXT,"
                    + POSITION_TWO_LEG_POSITION + " TEXT,"
                    + POSITION_TWO_DATA_F + " TEXT,"
                    + POSITION_TWO_DATA_D + " TEXT,"
                    + POSITION_TWO_VPT + " TEXT,"
                    + POSITION_TWO_TPT + " TEXT,"
                    + POSITION_TWO_SEVERITY + " TEXT,"
                    + POSITION_TWO_DATE + " TEXT,"
                    + POSITION_TWO_SERVER_UPLOAD_FLAG + " TEXT,"
                    + POSITION_TWO_FIREBASE_ID + " TEXT,"
                    + POSITION_TWO_IMEI + " TEXT"
                    + ")";


    private final String POSITION_THREE_TABLE = "position_three_table";

    private final String POSITION_THREE_ID = "position_three_id";
    private final String POSITION_THREE_USER_ID = "position_three_user_id";
    private final String POSITION_THREE_USER_TYPE = "position_three_user_type";
    private final String POSITION_THREE_USER_FIREBASE_ID = "position_three_user_firebase_id";
    private final String POSITION_THREE_LEG_POSITION = "position_three_leg_position";
    private final String POSITION_THREE_DATA_F = "position_three_data_f";
    private final String POSITION_THREE_DATA_D = "position_three_data_d";
    private final String POSITION_THREE_VPT = "position_three_vpt";
    private final String POSITION_THREE_TPT = "position_three_tpt";
    private final String POSITION_THREE_SEVERITY = "position_three_severity";
    private final String POSITION_THREE_DATE = "position_three_date";
    private final String POSITION_THREE_SERVER_UPLOAD_FLAG = "position_three_server_upload_flag";
    private final String POSITION_THREE_FIREBASE_ID = "position_three_firebase_id";
    private final String POSITION_THREE_IMEI = "position_three_imei";


    // Create position three table SQL query
    private final String CREATE_POSITION_THREE_TABLE =
            "CREATE TABLE " + POSITION_THREE_TABLE + "("
                    + POSITION_THREE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + POSITION_THREE_USER_ID + " TEXT,"
                    + POSITION_THREE_USER_TYPE + " TEXT,"
                    + POSITION_THREE_USER_FIREBASE_ID + " TEXT,"
                    + POSITION_THREE_LEG_POSITION + " TEXT,"
                    + POSITION_THREE_DATA_F + " TEXT,"
                    + POSITION_THREE_DATA_D + " TEXT,"
                    + POSITION_THREE_VPT + " TEXT,"
                    + POSITION_THREE_TPT + " TEXT,"
                    + POSITION_THREE_SEVERITY + " TEXT,"
                    + POSITION_THREE_DATE + " TEXT,"
                    + POSITION_THREE_SERVER_UPLOAD_FLAG + " TEXT,"
                    + POSITION_THREE_FIREBASE_ID + " TEXT,"
                    + POSITION_THREE_IMEI + " TEXT"
                    + ")";


    private final String POSITION_FOUR_TABLE = "position_four_table";

    private final String POSITION_FOUR_ID = "position_four_id";
    private final String POSITION_FOUR_USER_ID = "position_four_user_id";
    private final String POSITION_FOUR_USER_TYPE = "position_four_user_type";
    private final String POSITION_FOUR_USER_FIREBASE_ID = "position_four_user_firebase_id";
    private final String POSITION_FOUR_LEG_POSITION = "position_four_leg_position";
    private final String POSITION_FOUR_DATA_F = "position_four_data_f";
    private final String POSITION_FOUR_DATA_D = "position_four_data_d";
    private final String POSITION_FOUR_VPT = "position_four_vpt";
    private final String POSITION_FOUR_TPT = "position_four_tpt";
    private final String POSITION_FOUR_SEVERITY = "position_four_severity";
    private final String POSITION_FOUR_DATE = "position_four_date";
    private final String POSITION_FOUR_SERVER_UPLOAD_FLAG = "position_four_server_upload_flag";
    private final String POSITION_FOUR_FIREBASE_ID = "position_four_firebase_id";
    private final String POSITION_FOUR_IMEI = "position_four_imei";


    // Create position four table SQL query
    private final String CREATE_POSITION_FOUR_TABLE =
            "CREATE TABLE " + POSITION_FOUR_TABLE + "("
                    + POSITION_FOUR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + POSITION_FOUR_USER_ID + " TEXT,"
                    + POSITION_FOUR_USER_FIREBASE_ID + " TEXT,"
                    + POSITION_FOUR_USER_TYPE + " TEXT,"
                    + POSITION_FOUR_LEG_POSITION + " TEXT,"
                    + POSITION_FOUR_DATA_F + " TEXT,"
                    + POSITION_FOUR_DATA_D + " TEXT,"
                    + POSITION_FOUR_VPT + " TEXT,"
                    + POSITION_FOUR_TPT + " TEXT,"
                    + POSITION_FOUR_SEVERITY + " TEXT,"
                    + POSITION_FOUR_DATE + " TEXT,"
                    + POSITION_FOUR_SERVER_UPLOAD_FLAG + " TEXT,"
                    + POSITION_FOUR_FIREBASE_ID + " TEXT,"
                    + POSITION_FOUR_IMEI + " TEXT"
                    + ")";


    private final String POSITION_FIVE_TABLE = "position_five_table";

    private final String POSITION_FIVE_ID = "position_five_id";
    private final String POSITION_FIVE_USER_ID = "position_five_user_id";
    private final String POSITION_FIVE_USER_FIREBASE_ID = "position_five_user_firebase_id";
    private final String POSITION_FIVE_USER_TYPE = "position_five_user_type";
    private final String POSITION_FIVE_LEG_POSITION = "position_five_leg_position";
    private final String POSITION_FIVE_DATA_F = "position_five_data_f";
    private final String POSITION_FIVE_DATA_D = "position_five_data_d";
    private final String POSITION_FIVE_VPT = "position_five_vpt";
    private final String POSITION_FIVE_TPT = "position_five_tpt";
    private final String POSITION_FIVE_SEVERITY = "position_five_severity";
    private final String POSITION_FIVE_DATE = "position_five_date";
    private final String POSITION_FIVE_SERVER_UPLOAD_FLAG = "position_five_server_upload_flag";
    private final String POSITION_FIVE_FIREBASE_ID = "position_five_firebase_id";
    private final String POSITION_FIVE_IMEI = "position_five_imei";


    // Create position five table SQL query
    private final String CREATE_POSITION_FIVE_TABLE =
            "CREATE TABLE " + POSITION_FIVE_TABLE + "("
                    + POSITION_FIVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + POSITION_FIVE_USER_ID + " TEXT,"
                    + POSITION_FIVE_USER_TYPE + " TEXT,"
                    + POSITION_FIVE_USER_FIREBASE_ID + " TEXT,"
                    + POSITION_FIVE_LEG_POSITION + " TEXT,"
                    + POSITION_FIVE_DATA_F + " TEXT,"
                    + POSITION_FIVE_DATA_D + " TEXT,"
                    + POSITION_FIVE_VPT + " TEXT,"
                    + POSITION_FIVE_TPT + " TEXT,"
                    + POSITION_FIVE_SEVERITY + " TEXT,"
                    + POSITION_FIVE_DATE + " TEXT,"
                    + POSITION_FIVE_SERVER_UPLOAD_FLAG + " TEXT,"
                    + POSITION_FIVE_FIREBASE_ID + " TEXT,"
                    + POSITION_FIVE_IMEI + " TEXT"
                    + ")";


    public DatabaseHelper(Context context) {
        super(context, "betic_db", null, 1);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_POSITION_ONE_TABLE);
        db.execSQL(CREATE_POSITION_TWO_TABLE);
        db.execSQL(CREATE_POSITION_THREE_TABLE);
        db.execSQL(CREATE_POSITION_FOUR_TABLE);
        db.execSQL(CREATE_POSITION_FIVE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed

        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + POSITION_ONE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + POSITION_TWO_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + POSITION_THREE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + POSITION_FOUR_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + POSITION_FIVE_TABLE);
            // Create tables again
            onCreate(db);
        }
    }

    private void openDatabase() {
        db = this.getWritableDatabase();
        connection_count++;
    }


    private void closeDatabase() {
        if (connection_count > 0) {
            db.close();
            connection_count--;
        }
    }


//    public void insertUser(UserPojo userPojo) {
//
//        openDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(USER_TYPE, userPojo.user_type);
//        contentValues.put(USER_NAME, userPojo.name);
//        contentValues.put(USER_NUMBER, userPojo.number);
//        contentValues.put(USER_CITY, userPojo.city);
//        contentValues.put(USER_DOB, userPojo.dob);
//        contentValues.put(USER_PREVIOUS_ULCER_HISTORY, userPojo.previous_ulcer_history);
//        contentValues.put(USER_SERVER_UPLOAD_FLAG, userPojo.server_upload_flag);
//        contentValues.put(USER_FIREBASE_ID, userPojo.firebase_id);
//        contentValues.put(USER_CREATED_AT, userPojo.created_at);
//
//        db.insert(USERS_TABLE, null, contentValues);
//        closeDatabase();
//
//    }
//
//
//
//    public void updateUser(UserPojo userPojo) {
//
//        openDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(USER_TYPE, userPojo.user_type);
//        contentValues.put(USER_NAME, userPojo.name);
//        contentValues.put(USER_NUMBER, userPojo.number);
//        contentValues.put(USER_CITY, userPojo.city);
//        contentValues.put(USER_DOB, userPojo.dob);
//        contentValues.put(USER_PREVIOUS_ULCER_HISTORY, userPojo.previous_ulcer_history);
//        contentValues.put(USER_SERVER_UPLOAD_FLAG, userPojo.server_upload_flag);
//        contentValues.put(USER_FIREBASE_ID, userPojo.firebase_id);
//        contentValues.put(USER_CREATED_AT, userPojo.created_at);
//
//        db.update(USERS_TABLE, contentValues,USER_ID+"=?",new String[]{userPojo.id});
//        closeDatabase();
//
//    }
//
//    public boolean checkUserNumberExists(String number) {
//        boolean flag = false;
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//            cursor = db.query(USERS_TABLE, null, USER_NUMBER + " =? ", new String[]{number}, null, null, null);
//            if (cursor != null && cursor.getCount() > 0) {
//                flag = true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//
//        return flag;
//    }
//
//
//    public boolean checkUserloginCredential(String number, String dob) {
//
//        boolean flag = false;
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//            cursor = db.query(USERS_TABLE, null, USER_NUMBER + " =? AND " + USER_DOB + " = ?", new String[]{number, dob}, null, null, null);
//            if (cursor != null && cursor.getCount() > 0) {
//                flag = true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//
//        return flag;
//    }
//
//
//    public ArrayList<UserPojo> getAllUserWithServerFlagNo() {
//
//        UserPojo userPojo = null;
//        Cursor cursor = null;
//        ArrayList<UserPojo> list = new ArrayList<UserPojo>();
//
//        openDatabase();
//
//        try {
//
//            cursor = db.query(USERS_TABLE, null, USER_SERVER_UPLOAD_FLAG+"=?", new String[]{Utility.SERVER_FLAG_NO}, null, null, null);
//            if (cursor != null && cursor.getCount() > 0) {
//                cursor.moveToFirst();
//
//
//                do{
//
//                    userPojo = new UserPojo();
//
//                    userPojo.id = cursor.getString(cursor.getColumnIndex(USER_ID));
//                    userPojo.user_type = cursor.getString(cursor.getColumnIndex(USER_TYPE));
//                    userPojo.name = cursor.getString(cursor.getColumnIndex(USER_NAME));
//                    userPojo.number = cursor.getString(cursor.getColumnIndex(USER_NUMBER));
//                    userPojo.city = cursor.getString(cursor.getColumnIndex(USER_CITY));
//                    userPojo.dob = cursor.getString(cursor.getColumnIndex(USER_DOB));
//                    userPojo.previous_ulcer_history = cursor.getString(cursor.getColumnIndex(USER_PREVIOUS_ULCER_HISTORY));
//                    userPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(USER_SERVER_UPLOAD_FLAG));
//                    userPojo.firebase_id = cursor.getString(cursor.getColumnIndex(USER_FIREBASE_ID));
//                    userPojo.created_at = cursor.getString(cursor.getColumnIndex(USER_CREATED_AT));
//
//                    list.add(userPojo);
//
//
//                }while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//
//        return list;
//    }
//
//
//    public UserPojo getUser(String number, String dob) {
//
//        UserPojo userPojo = null;
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//            cursor = db.query(USERS_TABLE, null, USER_NUMBER + " =? AND " + USER_DOB + " = ?", new String[]{number, dob}, null, null, null);
//            if (cursor != null && cursor.getCount() > 0) {
//                cursor.moveToFirst();
//
//                userPojo = new UserPojo();
//
//                userPojo.id = cursor.getString(cursor.getColumnIndex(USER_ID));
//                userPojo.user_type = cursor.getString(cursor.getColumnIndex(USER_TYPE));
//                userPojo.name = cursor.getString(cursor.getColumnIndex(USER_NAME));
//                userPojo.number = cursor.getString(cursor.getColumnIndex(USER_NUMBER));
//                userPojo.city = cursor.getString(cursor.getColumnIndex(USER_CITY));
//                userPojo.dob = cursor.getString(cursor.getColumnIndex(USER_DOB));
//                userPojo.previous_ulcer_history = cursor.getString(cursor.getColumnIndex(USER_PREVIOUS_ULCER_HISTORY));
//                userPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(USER_SERVER_UPLOAD_FLAG));
//                userPojo.firebase_id = cursor.getString(cursor.getColumnIndex(USER_FIREBASE_ID));
//                userPojo.created_at = cursor.getString(cursor.getColumnIndex(USER_CREATED_AT));
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//
//        return userPojo;
//    }
//
//
//    public void insertPositionOne(PositionOnePojo positionOnePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_ONE_USER_ID, positionOnePojo.user_id);
//        contentValues.put(POSITION_ONE_USER_TYPE, positionOnePojo.user_type);
//        contentValues.put(POSITION_ONE_USER_FIREBASE_ID, positionOnePojo.user_firebase_id);
//        contentValues.put(POSITION_ONE_LEG_POSITION, positionOnePojo.leg_position);
//        contentValues.put(POSITION_ONE_DATA_F, positionOnePojo.data_f);
//        contentValues.put(POSITION_ONE_DATA_D, positionOnePojo.data_d);
//        contentValues.put(POSITION_ONE_VPT, positionOnePojo.vpt);
//        contentValues.put(POSITION_ONE_TPT, positionOnePojo.tpt);
//        contentValues.put(POSITION_ONE_SEVERITY, positionOnePojo.severity);
//        contentValues.put(POSITION_ONE_DATE, positionOnePojo.date);
//        contentValues.put(POSITION_ONE_SERVER_UPLOAD_FLAG, positionOnePojo.server_upload_flag);
//        contentValues.put(POSITION_ONE_FIREBASE_ID, positionOnePojo.firebase_id);
//        contentValues.put(POSITION_ONE_IMEI, positionOnePojo.imei);
//
//        db.insert(POSITION_ONE_TABLE, null, contentValues);
//        closeDatabase();
//
//    }
//
//
//    public void updatePositionOne(PositionOnePojo positionOnePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_ONE_USER_ID, positionOnePojo.user_id);
//        contentValues.put(POSITION_ONE_USER_TYPE, positionOnePojo.user_type);
//        contentValues.put(POSITION_ONE_USER_FIREBASE_ID, positionOnePojo.user_firebase_id);
//        contentValues.put(POSITION_ONE_LEG_POSITION, positionOnePojo.leg_position);
//        contentValues.put(POSITION_ONE_DATA_F, positionOnePojo.data_f);
//        contentValues.put(POSITION_ONE_DATA_D, positionOnePojo.data_d);
//        contentValues.put(POSITION_ONE_VPT, positionOnePojo.vpt);
//        contentValues.put(POSITION_ONE_TPT, positionOnePojo.tpt);
//        contentValues.put(POSITION_ONE_SEVERITY, positionOnePojo.severity);
//        contentValues.put(POSITION_ONE_DATE, positionOnePojo.date);
//        contentValues.put(POSITION_ONE_SERVER_UPLOAD_FLAG, positionOnePojo.server_upload_flag);
//        contentValues.put(POSITION_ONE_FIREBASE_ID, positionOnePojo.firebase_id);
//        contentValues.put(POSITION_ONE_IMEI, positionOnePojo.imei);
//
//        db.update(POSITION_ONE_TABLE, contentValues, POSITION_ONE_ID + "=?", new String[]{positionOnePojo.id});
//        closeDatabase();
//
//    }
//
//    public PositionOnePojo checkLastPositionOneTable(String user_id, String leg_position) {
//        PositionOnePojo positionOnePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_USER_ID + "=? AND " + POSITION_ONE_LEG_POSITION + "=?", new String[]{user_id, leg_position}, null, null, POSITION_ONE_DATE + " DESC");
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionOnePojo = new PositionOnePojo();
//
//
//                positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionOnePojo;
//    }
//
//
//    public PositionOnePojo getDataUsingIDFromPositionOneTable(String id) {
//        PositionOnePojo positionOnePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_ID + "=?", new String[]{id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionOnePojo = new PositionOnePojo();
//
//
//                positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionOnePojo;
//    }
//
//
//    public ArrayList<PositionOnePojo> getDataWithServerFlagNoUsingUserIdFromPositionOneTable(String user_id) {
//
//
//        Log.e(TAG, "getDataWithServerFlagNoUsingUserIdFromPositionOneTable()");
//
//        ArrayList<PositionOnePojo> list = new ArrayList<PositionOnePojo>();
//        PositionOnePojo positionOnePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_USER_ID + "=? AND " + POSITION_ONE_SERVER_UPLOAD_FLAG + " =?", new String[]{user_id,Utility.SERVER_FLAG_NO}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//
//
//                cursor.moveToFirst();
//
//                do {
//                            positionOnePojo = new PositionOnePojo();
//
//                            positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                            positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                            positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                            positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                            positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                            positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                            positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                            positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                            positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                            positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                            positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                            positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                            positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                            positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//                            list.add(positionOnePojo);
//
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public ArrayList<PositionOnePojo> getRecentDataFromPositionOneTable(String user_id, String leg_type, String result_count) {
//
//
//        Log.e(TAG, "getRecentDataFromPositionOneTable()");
//
//        ArrayList<PositionOnePojo> list = new ArrayList<PositionOnePojo>();
//        PositionOnePojo positionOnePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_LEG_POSITION + "=? AND " + POSITION_ONE_USER_ID + " =?", new String[]{leg_type, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//
//                Log.e(TAG, "user_id = " + user_id + " leg_type = " + leg_type + " result_count = " + result_count);
//                Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                    if (result_count.trim().trim().equalsIgnoreCase(Utility.LAST_FIVE.trim())) {
//
//                        if (count < 5) {
//
//                            positionOnePojo = new PositionOnePojo();
//
//
//                            positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                            positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                            positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                            positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                            positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                            positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                            positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                            positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                            positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                            positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                            positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                            positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                            positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                            positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//                            list.add(positionOnePojo);
//                        }
//                    }
//
//                    count++;
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public void insertPositionTwo(PositionTwoPojo positionTwoPojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_TWO_USER_ID, positionTwoPojo.user_id);
//        contentValues.put(POSITION_TWO_USER_TYPE, positionTwoPojo.user_type);
//        contentValues.put(POSITION_TWO_USER_FIREBASE_ID, positionTwoPojo.user_firebase_id);
//        contentValues.put(POSITION_TWO_LEG_POSITION, positionTwoPojo.leg_position);
//        contentValues.put(POSITION_TWO_DATA_F, positionTwoPojo.data_f);
//        contentValues.put(POSITION_TWO_DATA_D, positionTwoPojo.data_d);
//        contentValues.put(POSITION_TWO_VPT, positionTwoPojo.vpt);
//        contentValues.put(POSITION_TWO_TPT, positionTwoPojo.tpt);
//        contentValues.put(POSITION_TWO_SEVERITY, positionTwoPojo.severity);
//        contentValues.put(POSITION_TWO_DATE, positionTwoPojo.date);
//        contentValues.put(POSITION_TWO_SERVER_UPLOAD_FLAG, positionTwoPojo.server_upload_flag);
//        contentValues.put(POSITION_TWO_FIREBASE_ID, positionTwoPojo.firebase_id);
//        contentValues.put(POSITION_TWO_IMEI, positionTwoPojo.imei);
//
//        db.insert(POSITION_TWO_TABLE, null, contentValues);
//        closeDatabase();
//
//    }
//
//
//    public void updatePositionTwo(PositionTwoPojo positionTwoPojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_TWO_USER_ID, positionTwoPojo.user_id);
//        contentValues.put(POSITION_TWO_USER_TYPE, positionTwoPojo.user_type);
//        contentValues.put(POSITION_TWO_USER_FIREBASE_ID, positionTwoPojo.user_firebase_id);
//        contentValues.put(POSITION_TWO_LEG_POSITION, positionTwoPojo.leg_position);
//        contentValues.put(POSITION_TWO_DATA_F, positionTwoPojo.data_f);
//        contentValues.put(POSITION_TWO_DATA_D, positionTwoPojo.data_d);
//        contentValues.put(POSITION_TWO_VPT, positionTwoPojo.vpt);
//        contentValues.put(POSITION_TWO_TPT, positionTwoPojo.tpt);
//        contentValues.put(POSITION_TWO_SEVERITY, positionTwoPojo.severity);
//        contentValues.put(POSITION_TWO_DATE, positionTwoPojo.date);
//        contentValues.put(POSITION_TWO_SERVER_UPLOAD_FLAG, positionTwoPojo.server_upload_flag);
//        contentValues.put(POSITION_TWO_FIREBASE_ID, positionTwoPojo.firebase_id);
//        contentValues.put(POSITION_TWO_IMEI, positionTwoPojo.imei);
//
//        db.update(POSITION_TWO_TABLE, contentValues, POSITION_TWO_ID + "=?", new String[]{positionTwoPojo.id});
//        closeDatabase();
//
//    }
//
//    public PositionTwoPojo checkLastPositionTwoTable(String user_id, String leg_position) {
//        PositionTwoPojo positionTwoPojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_USER_ID + "=? AND " + POSITION_TWO_LEG_POSITION + "=?", new String[]{user_id, leg_position}, null, null, POSITION_TWO_DATE + " DESC");
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionTwoPojo = new PositionTwoPojo();
//
//
//                positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionTwoPojo;
//    }
//
//
//    public PositionTwoPojo getDataUsingIdFromPositionTwoTable(String id) {
//        PositionTwoPojo positionTwoPojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_ID + "=?", new String[]{id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionTwoPojo = new PositionTwoPojo();
//
//
//                positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionTwoPojo;
//    }
//
//
//    public ArrayList<PositionTwoPojo> getRecentDataFromPositionTwoTable(String user_id, String leg_type, String result_count) {
//
//        ArrayList<PositionTwoPojo> list = new ArrayList<PositionTwoPojo>();
//        PositionTwoPojo positionTwoPojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_LEG_POSITION + "=? AND " + POSITION_TWO_USER_ID + "=?", new String[]{leg_type, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                    if (result_count.trim().equalsIgnoreCase(Utility.LAST_FIVE)) {
//
//                        if (count < 5) {
//
//                            positionTwoPojo = new PositionTwoPojo();
//
//
//                            positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                            positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                            positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                            positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                            positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                            positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                            positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                            positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                            positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                            positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                            positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                            positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                            positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                            positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//                            list.add(positionTwoPojo);
//                        }
//                    }
//
//                    count++;
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//
//    public ArrayList<PositionTwoPojo> getDataWithServerFlagNoUsingUserIdFromPositionTwoTable(String user_id) {
//
//        ArrayList<PositionTwoPojo> list = new ArrayList<PositionTwoPojo>();
//        PositionTwoPojo positionTwoPojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_SERVER_UPLOAD_FLAG + "=? AND " + POSITION_TWO_USER_ID + "=?", new String[]{Utility.SERVER_FLAG_NO, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                            positionTwoPojo = new PositionTwoPojo();
//
//
//                            positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                            positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                            positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                            positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                            positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                            positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                            positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                            positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                            positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                            positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                            positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                            positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                            positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                            positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//                            list.add(positionTwoPojo);
//
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public void insertPositionThree(PositionThreePojo positionThreePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_THREE_USER_ID, positionThreePojo.user_id);
//        contentValues.put(POSITION_THREE_USER_TYPE, positionThreePojo.user_type);
//        contentValues.put(POSITION_THREE_USER_FIREBASE_ID, positionThreePojo.user_firebase_id);
//        contentValues.put(POSITION_THREE_LEG_POSITION, positionThreePojo.leg_position);
//        contentValues.put(POSITION_THREE_DATA_F, positionThreePojo.data_f);
//        contentValues.put(POSITION_THREE_DATA_D, positionThreePojo.data_d);
//        contentValues.put(POSITION_THREE_VPT, positionThreePojo.vpt);
//        contentValues.put(POSITION_THREE_TPT, positionThreePojo.tpt);
//        contentValues.put(POSITION_THREE_SEVERITY, positionThreePojo.severity);
//        contentValues.put(POSITION_THREE_DATE, positionThreePojo.date);
//        contentValues.put(POSITION_THREE_SERVER_UPLOAD_FLAG, positionThreePojo.server_upload_flag);
//        contentValues.put(POSITION_THREE_FIREBASE_ID, positionThreePojo.firebase_id);
//        contentValues.put(POSITION_THREE_IMEI, positionThreePojo.imei);
//
//
//        db.insert(POSITION_THREE_TABLE,null,contentValues);
//
//       db.insert(POSITION_THREE_TABLE, null, contentValues);
//
//       closeDatabase();
//
//    }
//
//
//    public void updatePositionThree(PositionThreePojo positionThreePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_THREE_USER_ID, positionThreePojo.user_id);
//        contentValues.put(POSITION_THREE_USER_TYPE, positionThreePojo.user_type);
//        contentValues.put(POSITION_THREE_USER_FIREBASE_ID, positionThreePojo.user_firebase_id);
//        contentValues.put(POSITION_THREE_LEG_POSITION, positionThreePojo.leg_position);
//        contentValues.put(POSITION_THREE_DATA_F, positionThreePojo.data_f);
//        contentValues.put(POSITION_THREE_DATA_D, positionThreePojo.data_d);
//        contentValues.put(POSITION_THREE_VPT, positionThreePojo.vpt);
//        contentValues.put(POSITION_THREE_TPT, positionThreePojo.tpt);
//        contentValues.put(POSITION_THREE_SEVERITY, positionThreePojo.severity);
//        contentValues.put(POSITION_THREE_DATE, positionThreePojo.date);
//        contentValues.put(POSITION_THREE_SERVER_UPLOAD_FLAG, positionThreePojo.server_upload_flag);
//        contentValues.put(POSITION_THREE_FIREBASE_ID, positionThreePojo.firebase_id);
//        contentValues.put(POSITION_THREE_IMEI, positionThreePojo.imei);
//
//        db.update(POSITION_THREE_TABLE, contentValues, POSITION_THREE_ID + "=?", new String[]{positionThreePojo.id});
//        closeDatabase();
//
//    }
//
//    public PositionThreePojo checkLastPositionThreeTable(String user_id, String leg_position) {
//        PositionThreePojo positionThreePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_USER_ID + "=? AND " + POSITION_THREE_LEG_POSITION + "=?", new String[]{user_id, leg_position}, null, null, POSITION_THREE_DATE + " DESC");
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionThreePojo = new PositionThreePojo();
//
//
//                positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionThreePojo;
//    }
//
//
//    public PositionThreePojo getDataUsingIDFromPositionThreeTable(String id) {
//        PositionThreePojo positionThreePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_ID + "=?", new String[]{id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionThreePojo = new PositionThreePojo();
//
//
//                positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionThreePojo;
//    }
//
//
//    public ArrayList<PositionThreePojo> getRecentDataFromPositionThreeTable(String user_id, String leg_type, String result_count) {
//
//        ArrayList<PositionThreePojo> list = new ArrayList<PositionThreePojo>();
//        PositionThreePojo positionThreePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_LEG_POSITION + "=? AND " + POSITION_THREE_USER_ID + "=?", new String[]{leg_type, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                    if (result_count.trim().equalsIgnoreCase(Utility.LAST_FIVE)) {
//
//                        if (count < 5) {
//
//                            positionThreePojo = new PositionThreePojo();
//
//
//                            positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                            positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                            positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                            positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                            positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                            positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                            positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                            positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                            positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                            positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                            positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                            positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                            positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                            positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//                            list.add(positionThreePojo);
//                        }
//                    }
//
//
//                    count++;
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//
//    public ArrayList<PositionThreePojo> getDataWithServerFlagNoUsingUserIdFromPositionThreeTable(String user_id) {
//
//        ArrayList<PositionThreePojo> list = new ArrayList<PositionThreePojo>();
//        PositionThreePojo positionThreePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_SERVER_UPLOAD_FLAG + "=? AND " + POSITION_THREE_USER_ID + "=?", new String[]{Utility.SERVER_FLAG_NO, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//
//                            positionThreePojo = new PositionThreePojo();
//
//
//                            positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                            positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                            positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                            positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                            positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                            positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                            positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                            positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                            positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                            positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                            positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                            positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                            positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                            positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//                            list.add(positionThreePojo);
//
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public void insertPositionFour(PositionFourPojo positionFourPojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_FOUR_USER_ID, positionFourPojo.user_id);
//        contentValues.put(POSITION_FOUR_USER_FIREBASE_ID, positionFourPojo.user_firebase_id);
//        contentValues.put(POSITION_FOUR_USER_TYPE, positionFourPojo.user_type);
//        contentValues.put(POSITION_FOUR_LEG_POSITION, positionFourPojo.leg_position);
//        contentValues.put(POSITION_FOUR_DATA_F, positionFourPojo.data_f);
//        contentValues.put(POSITION_FOUR_DATA_D, positionFourPojo.data_d);
//        contentValues.put(POSITION_FOUR_VPT, positionFourPojo.vpt);
//        contentValues.put(POSITION_FOUR_TPT, positionFourPojo.tpt);
//        contentValues.put(POSITION_FOUR_SEVERITY, positionFourPojo.severity);
//        contentValues.put(POSITION_FOUR_DATE, positionFourPojo.date);
//        contentValues.put(POSITION_FOUR_SERVER_UPLOAD_FLAG, positionFourPojo.server_upload_flag);
//        contentValues.put(POSITION_FOUR_FIREBASE_ID, positionFourPojo.firebase_id);
//        contentValues.put(POSITION_FOUR_IMEI, positionFourPojo.imei);
//
//        db.insert(POSITION_FOUR_TABLE, null, contentValues);
//        closeDatabase();
//
//    }
//
//
//    public void updatePositionFour(PositionFourPojo positionFourPojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_FOUR_USER_ID, positionFourPojo.user_id);
//        contentValues.put(POSITION_FOUR_USER_FIREBASE_ID, positionFourPojo.user_firebase_id);
//        contentValues.put(POSITION_FOUR_USER_TYPE, positionFourPojo.user_type);
//        contentValues.put(POSITION_FOUR_LEG_POSITION, positionFourPojo.leg_position);
//        contentValues.put(POSITION_FOUR_DATA_F, positionFourPojo.data_f);
//        contentValues.put(POSITION_FOUR_DATA_D, positionFourPojo.data_d);
//        contentValues.put(POSITION_FOUR_VPT, positionFourPojo.vpt);
//        contentValues.put(POSITION_FOUR_TPT, positionFourPojo.tpt);
//        contentValues.put(POSITION_FOUR_SEVERITY, positionFourPojo.severity);
//        contentValues.put(POSITION_FOUR_DATE, positionFourPojo.date);
//        contentValues.put(POSITION_FOUR_SERVER_UPLOAD_FLAG, positionFourPojo.server_upload_flag);
//        contentValues.put(POSITION_FOUR_FIREBASE_ID, positionFourPojo.firebase_id);
//        contentValues.put(POSITION_FOUR_IMEI, positionFourPojo.imei);
//
//        db.update(POSITION_FOUR_TABLE, contentValues, POSITION_FOUR_ID + "=?", new String[]{positionFourPojo.id});
//        closeDatabase();
//
//    }
//
//
//    public PositionFourPojo checkLastPositionFourTable(String user_id, String leg_position) {
//        PositionFourPojo positionFourPojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_USER_ID + "=? AND " + POSITION_FOUR_LEG_POSITION + "=?", new String[]{user_id, leg_position}, null, null, POSITION_FOUR_DATE + " DESC");
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionFourPojo = new PositionFourPojo();
//
//
//                positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionFourPojo;
//    }
//
//
//    public PositionFourPojo getDataUsingIDFromPositionFourTable(String id) {
//        PositionFourPojo positionFourPojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_ID + "=?", new String[]{id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionFourPojo = new PositionFourPojo();
//
//
//                positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionFourPojo;
//    }
//
//
//    public ArrayList<PositionFourPojo> getRecentDataFromPositionFourTable(String user_id, String leg_type, String result_count) {
//
//        ArrayList<PositionFourPojo> list = new ArrayList<PositionFourPojo>();
//        PositionFourPojo positionFourPojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_LEG_POSITION + "=? AND " + POSITION_FOUR_USER_ID + "=?", new String[]{leg_type, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                    if (result_count.trim().equalsIgnoreCase(Utility.LAST_FIVE)) {
//
//                        if (count < 5) {
//
//                            positionFourPojo = new PositionFourPojo();
//
//
//                            positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                            positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                            positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                            positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                            positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                            positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                            positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                            positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                            positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                            positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                            positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                            positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                            positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                            positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//                            list.add(positionFourPojo);
//                        }
//                    }
//
//                    count++;
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//
//    public ArrayList<PositionFourPojo> getDataWithServerFlagNoUsingUserIdFromPositionFourTable(String user_id) {
//
//        ArrayList<PositionFourPojo> list = new ArrayList<PositionFourPojo>();
//        PositionFourPojo positionFourPojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_SERVER_UPLOAD_FLAG + "=? AND " + POSITION_FOUR_USER_ID + "=?", new String[]{Utility.SERVER_FLAG_NO, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                            positionFourPojo = new PositionFourPojo();
//
//                            positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                            positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                            positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                            positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                            positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                            positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                            positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                            positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                            positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                            positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                            positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                            positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                            positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                            positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//                            list.add(positionFourPojo);
//
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public void insertPositionFive(PositionFivePojo positionFivePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_FIVE_USER_ID, positionFivePojo.user_id);
//        contentValues.put(POSITION_FIVE_USER_TYPE, positionFivePojo.user_type);
//        contentValues.put(POSITION_FIVE_USER_FIREBASE_ID, positionFivePojo.user_firebase_id);
//        contentValues.put(POSITION_FIVE_LEG_POSITION, positionFivePojo.leg_position);
//        contentValues.put(POSITION_FIVE_DATA_F, positionFivePojo.data_f);
//        contentValues.put(POSITION_FIVE_DATA_D, positionFivePojo.data_d);
//        contentValues.put(POSITION_FIVE_VPT, positionFivePojo.vpt);
//        contentValues.put(POSITION_FIVE_TPT, positionFivePojo.tpt);
//        contentValues.put(POSITION_FIVE_SEVERITY, positionFivePojo.severity);
//        contentValues.put(POSITION_FIVE_DATE, positionFivePojo.date);
//        contentValues.put(POSITION_FIVE_SERVER_UPLOAD_FLAG, positionFivePojo.server_upload_flag);
//        contentValues.put(POSITION_FIVE_FIREBASE_ID, positionFivePojo.firebase_id);
//        contentValues.put(POSITION_FIVE_IMEI, positionFivePojo.imei);
//
//        db.insert(POSITION_FIVE_TABLE, null, contentValues);
//        closeDatabase();
//
//    }
//
//
//    public void updatePositionFive(PositionFivePojo positionFivePojo) {
//
//        openDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_FIVE_USER_ID, positionFivePojo.user_id);
//        contentValues.put(POSITION_FIVE_USER_FIREBASE_ID, positionFivePojo.user_firebase_id);
//        contentValues.put(POSITION_FIVE_USER_TYPE, positionFivePojo.user_type);
//        contentValues.put(POSITION_FIVE_LEG_POSITION, positionFivePojo.leg_position);
//        contentValues.put(POSITION_FIVE_DATA_F, positionFivePojo.data_f);
//        contentValues.put(POSITION_FIVE_DATA_D, positionFivePojo.data_d);
//        contentValues.put(POSITION_FIVE_VPT, positionFivePojo.vpt);
//        contentValues.put(POSITION_FIVE_TPT, positionFivePojo.tpt);
//        contentValues.put(POSITION_FIVE_SEVERITY, positionFivePojo.severity);
//        contentValues.put(POSITION_FIVE_DATE, positionFivePojo.date);
//        contentValues.put(POSITION_FIVE_SERVER_UPLOAD_FLAG, positionFivePojo.server_upload_flag);
//        contentValues.put(POSITION_FIVE_FIREBASE_ID, positionFivePojo.firebase_id);
//        contentValues.put(POSITION_FIVE_IMEI, positionFivePojo.imei);
//
//        db.update(POSITION_FIVE_TABLE, contentValues, POSITION_FIVE_ID + "=?", new String[]{positionFivePojo.id});
//        closeDatabase();
//
//    }
//
//
//    public PositionFivePojo checkLastPositionFiveTable(String user_id, String leg_position) {
//        PositionFivePojo positionFivePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_USER_ID + "=? AND " + POSITION_FIVE_LEG_POSITION + "=?", new String[]{user_id, leg_position}, null, null, POSITION_FIVE_DATE + " DESC");
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionFivePojo = new PositionFivePojo();
//
//
//                positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionFivePojo;
//    }
//
//
//    public PositionFivePojo getDataUsingIDFromPositionFiveTable(String id) {
//        PositionFivePojo positionFivePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_ID + "=?", new String[]{id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                positionFivePojo = new PositionFivePojo();
//
//
//                positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return positionFivePojo;
//    }
//
//
//    public ArrayList<PositionFivePojo> getRecentDataFromPositionFiveTable(String user_id, String leg_type, String result_count) {
//
//        ArrayList<PositionFivePojo> list = new ArrayList<PositionFivePojo>();
//        PositionFivePojo positionFivePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//            cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_LEG_POSITION + "=? AND " + POSITION_FIVE_USER_ID + "=?", new String[]{leg_type, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//
//                    if (result_count.trim().equalsIgnoreCase(Utility.LAST_FIVE)) {
//
//                        if (count < 5) {
//
//                            positionFivePojo = new PositionFivePojo();
//
//
//                            positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                            positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                            positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                            positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                            positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                            positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                            positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                            positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                            positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                            positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                            positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                            positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                            positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                            positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//                            list.add(positionFivePojo);
//                        }
//                    }
//
//                    count++;
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//
//
//    public ArrayList<PositionFivePojo> getDataWithServerFlagNoUsingUserIdFromPositionFiveTable(String user_id) {
//
//        ArrayList<PositionFivePojo> list = new ArrayList<PositionFivePojo>();
//        PositionFivePojo positionFivePojo = null;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//           cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_SERVER_UPLOAD_FLAG + "=? AND " + POSITION_FIVE_USER_ID + "=?", new String[]{Utility.SERVER_FLAG_NO, user_id}, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//
//                cursor.moveToFirst();
//
//                do {
//
//                            positionFivePojo = new PositionFivePojo();
//
//                            positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                            positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                            positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                            positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                            positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                            positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                            positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                            positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                            positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                            positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                            positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                            positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                            positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                            positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//                            list.add(positionFivePojo);
//
//                }
//                while (cursor.moveToNext());
//
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public ArrayList<Object> getRecordsFromPositionTableWithDate(String user_id, String position, String leg_type, Date from_date, Date to_date) {
//
//        ArrayList<Object> list = new ArrayList<Object>();
//        PositionOnePojo positionOnePojo = null;
//        PositionTwoPojo positionTwoPojo = null;
//        PositionThreePojo positionThreePojo = null;
//        PositionFourPojo positionFourPojo = null;
//        PositionFivePojo positionFivePojo = null;
//
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//            if (position.equalsIgnoreCase(Utility.POSITION_ONE_NUMBER)) {
//
//                cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_LEG_POSITION + "=? AND " + POSITION_ONE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, null);
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (isDateInBetweenIncludingEndPoints(from_date, to_date, AppController.getInstance().convertStringDateDDMMYYYYHHMMSSToDate(cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE))))) {
//
//                            positionOnePojo = new PositionOnePojo();
//
//                            positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                            positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                            positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                            positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                            positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                            positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                            positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                            positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                            positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                            positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                            positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                            positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                            positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                            positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//                            list.add(positionOnePojo);
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_TWO_NUMBER)) {
//
//                cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_LEG_POSITION + "=? AND " + POSITION_TWO_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, null);
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (isDateInBetweenIncludingEndPoints(from_date, to_date, AppController.getInstance().convertStringDateDDMMYYYYHHMMSSToDate(cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE))))) {
//
//                            positionTwoPojo = new PositionTwoPojo();
//
//                            positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                            positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                            positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                            positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                            positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                            positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                            positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                            positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                            positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                            positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                            positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                            positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                            positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                            positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//                            list.add(positionTwoPojo);
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_THREE_NUMBER)) {
//
//
//                cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_LEG_POSITION + "=? AND " + POSITION_THREE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, null);
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (isDateInBetweenIncludingEndPoints(from_date, to_date, AppController.getInstance().convertStringDateDDMMYYYYHHMMSSToDate(cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE))))) {
//
//                            positionThreePojo = new PositionThreePojo();
//
//                            positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                            positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                            positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                            positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                            positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                            positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                            positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                            positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                            positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                            positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                            positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                            positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                            positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                            positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//                            list.add(positionThreePojo);
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_FOUR_NUMBER)) {
//
//                cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_LEG_POSITION + "=? AND " + POSITION_FOUR_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, null);
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (isDateInBetweenIncludingEndPoints(from_date, to_date, AppController.getInstance().convertStringDateDDMMYYYYHHMMSSToDate(cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE))))) {
//
//                            positionFourPojo = new PositionFourPojo();
//
//                            positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                            positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                            positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                            positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                            positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                            positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                            positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                            positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                            positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                            positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                            positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                            positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                            positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                            positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//                            list.add(positionFourPojo);
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_FIVE_NUMBER)) {
//
//                cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_LEG_POSITION + "=? AND " + POSITION_FIVE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, null);
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (isDateInBetweenIncludingEndPoints(from_date, to_date, AppController.getInstance().convertStringDateDDMMYYYYHHMMSSToDate(cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE))))) {
//
//                            positionFivePojo = new PositionFivePojo();
//
//                            positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                            positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                            positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                            positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                            positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                            positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                            positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                            positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                            positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                            positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                            positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                            positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                            positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                            positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//                            list.add(positionFivePojo);
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    public ArrayList<Object> getRecordsFromPositionTable(String user_id, String position, String leg_type) {
//
//        ArrayList<Object> list = new ArrayList<Object>();
//        PositionOnePojo positionOnePojo = null;
//        PositionTwoPojo positionTwoPojo = null;
//        PositionThreePojo positionThreePojo = null;
//        PositionFourPojo positionFourPojo = null;
//        PositionFivePojo positionFivePojo = null;
//
//        int count = 0;
//
//        Cursor cursor = null;
//
//        openDatabase();
//
//        try {
//
//            if (position.equalsIgnoreCase(Utility.POSITION_ONE_NUMBER)) {
//
//                cursor = db.query(POSITION_ONE_TABLE, null, POSITION_ONE_LEG_POSITION + "=? AND " + POSITION_ONE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, POSITION_ONE_DATE + " DESC");
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (count < 5) {
//
//                            positionOnePojo = new PositionOnePojo();
//
//                            positionOnePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_ID));
//                            positionOnePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_ID));
//                            positionOnePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_TYPE));
//                            positionOnePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_USER_FIREBASE_ID));
//                            positionOnePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_ONE_LEG_POSITION));
//                            positionOnePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_F));
//                            positionOnePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATA_D));
//                            positionOnePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_VPT));
//                            positionOnePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_ONE_TPT));
//                            positionOnePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SEVERITY));
//                            positionOnePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_ONE_DATE));
//                            positionOnePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_ONE_SERVER_UPLOAD_FLAG));
//                            positionOnePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_ONE_FIREBASE_ID));
//                            positionOnePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_ONE_IMEI));
//
//                            list.add(positionOnePojo);
//
//                            count++;
//
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_TWO_NUMBER)) {
//
//                cursor = db.query(POSITION_TWO_TABLE, null, POSITION_TWO_LEG_POSITION + "=? AND " + POSITION_TWO_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, POSITION_TWO_DATE + " DESC");
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (count < 5) {
//
//                            positionTwoPojo = new PositionTwoPojo();
//
//                            positionTwoPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_ID));
//                            positionTwoPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_ID));
//                            positionTwoPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_TYPE));
//                            positionTwoPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_USER_FIREBASE_ID));
//                            positionTwoPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_TWO_LEG_POSITION));
//                            positionTwoPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_F));
//                            positionTwoPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATA_D));
//                            positionTwoPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_VPT));
//                            positionTwoPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_TWO_TPT));
//                            positionTwoPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SEVERITY));
//                            positionTwoPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_TWO_DATE));
//                            positionTwoPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_TWO_SERVER_UPLOAD_FLAG));
//                            positionTwoPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_TWO_FIREBASE_ID));
//                            positionTwoPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_TWO_IMEI));
//
//                            list.add(positionTwoPojo);
//                            count++;
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_THREE_NUMBER)) {
//
//
//                cursor = db.query(POSITION_THREE_TABLE, null, POSITION_THREE_LEG_POSITION + "=? AND " + POSITION_THREE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, POSITION_THREE_DATE + " DESC");
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (count < 5) {
//
//                            positionThreePojo = new PositionThreePojo();
//
//                            positionThreePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_ID));
//                            positionThreePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_ID));
//                            positionThreePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_FIREBASE_ID));
//                            positionThreePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_THREE_USER_TYPE));
//                            positionThreePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_THREE_LEG_POSITION));
//                            positionThreePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_F));
//                            positionThreePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATA_D));
//                            positionThreePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_VPT));
//                            positionThreePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_THREE_TPT));
//                            positionThreePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SEVERITY));
//                            positionThreePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_THREE_DATE));
//                            positionThreePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_THREE_SERVER_UPLOAD_FLAG));
//                            positionThreePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_THREE_FIREBASE_ID));
//                            positionThreePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_THREE_IMEI));
//
//                            list.add(positionThreePojo);
//
//                            count ++;
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_FOUR_NUMBER)) {
//
//                cursor = db.query(POSITION_FOUR_TABLE, null, POSITION_FOUR_LEG_POSITION + "=? AND " + POSITION_FOUR_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, POSITION_FOUR_DATE+" DESC");
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (count<5) {
//
//                            positionFourPojo = new PositionFourPojo();
//
//                            positionFourPojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_ID));
//                            positionFourPojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_ID));
//                            positionFourPojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_FIREBASE_ID));
//                            positionFourPojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_USER_TYPE));
//                            positionFourPojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_LEG_POSITION));
//                            positionFourPojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_F));
//                            positionFourPojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATA_D));
//                            positionFourPojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_VPT));
//                            positionFourPojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_TPT));
//                            positionFourPojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SEVERITY));
//                            positionFourPojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_DATE));
//                            positionFourPojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_SERVER_UPLOAD_FLAG));
//                            positionFourPojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_FIREBASE_ID));
//                            positionFourPojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FOUR_IMEI));
//
//                            list.add(positionFourPojo);
//
//                            count++;
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            } else if (position.equalsIgnoreCase(Utility.POSITION_FIVE_NUMBER)) {
//
//                cursor = db.query(POSITION_FIVE_TABLE, null, POSITION_FIVE_LEG_POSITION + "=? AND " + POSITION_FIVE_USER_ID + " =? ", new String[]{leg_type, user_id}, null, null, POSITION_FIVE_DATE+" DESC");
//
//                if (cursor != null && cursor.getCount() > 0) {
//
//                    Log.e(TAG, "cursor.getCount() = " + cursor.getCount());
//
//                    cursor.moveToFirst();
//
//                    do {
//
//                        if (count<5) {
//
//                            positionFivePojo = new PositionFivePojo();
//
//                            positionFivePojo.id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_ID));
//                            positionFivePojo.user_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_ID));
//                            positionFivePojo.user_firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_FIREBASE_ID));
//                            positionFivePojo.user_type = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_USER_TYPE));
//                            positionFivePojo.leg_position = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_LEG_POSITION));
//                            positionFivePojo.data_f = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_F));
//                            positionFivePojo.data_d = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATA_D));
//                            positionFivePojo.vpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_VPT));
//                            positionFivePojo.tpt = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_TPT));
//                            positionFivePojo.severity = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SEVERITY));
//                            positionFivePojo.date = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_DATE));
//                            positionFivePojo.server_upload_flag = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_SERVER_UPLOAD_FLAG));
//                            positionFivePojo.firebase_id = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_FIREBASE_ID));
//                            positionFivePojo.imei = cursor.getString(cursor.getColumnIndex(POSITION_FIVE_IMEI));
//
//                            list.add(positionFivePojo);
//
//                            count++;
//                        }
//
//                    }
//                    while (cursor.moveToNext());
//                }
//
//            }
//
//        } catch (Exception e) {
//
//        } finally {
//
//            if (cursor != null) {
//                cursor.close();
//            }
//            closeDatabase();
//        }
//        return list;
//    }
//
//
//    private boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date) {
//
////        Log.e(TAG, "min = " + min.toString() + " max = " + max.toString() + " date = " + date.toString());
//
//        return !(date.before(min) || date.after(max));
//    }
//
//
//    public void updateUserInAllPositionTable(UserPojo userPojo) {
//
//        openDatabase();
//
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(POSITION_ONE_USER_FIREBASE_ID, userPojo.firebase_id);
//        db.update(POSITION_ONE_TABLE, contentValues,POSITION_ONE_USER_ID+"=?",new String[]{userPojo.id});
//
//        contentValues = new ContentValues();
//        contentValues.put(POSITION_TWO_USER_FIREBASE_ID, userPojo.firebase_id);
//        db.update(POSITION_TWO_TABLE, contentValues,POSITION_TWO_USER_ID+"=?",new String[]{userPojo.id});
//
//        contentValues = new ContentValues();
//        contentValues.put(POSITION_THREE_USER_FIREBASE_ID, userPojo.firebase_id);
//        db.update(POSITION_THREE_TABLE, contentValues,POSITION_THREE_USER_ID+"=?",new String[]{userPojo.id});
//
//
//        contentValues = new ContentValues();
//        contentValues.put(POSITION_FOUR_USER_FIREBASE_ID, userPojo.firebase_id);
//        db.update(POSITION_FOUR_TABLE, contentValues,POSITION_FOUR_USER_ID+"=?",new String[]{userPojo.id});
//
//        contentValues = new ContentValues();
//        contentValues.put(POSITION_FIVE_USER_FIREBASE_ID, userPojo.firebase_id);
//        db.update(POSITION_FIVE_TABLE, contentValues,POSITION_FIVE_USER_ID+"=?",new String[]{userPojo.id});
//
//
//        closeDatabase();
//
//    }


}