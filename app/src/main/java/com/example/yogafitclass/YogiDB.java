package com.example.yogafitclass;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class YogiDB {


    public static String TABLE_NAME="Yogis";
    public static String FIELD_ID = "id";
    public static String FIELD_NAME = "name";
    public static String FIELD_AUTHOR = "author";
    public static String FIELD_DETAILS = "details";
    public static String FIELD_PRICE = "price";
    public static String FIELD_IMAGE = "image";

    public static String CREATE_TABLE_SQL="CREATE TABLE TABLE_NAME ( "+FIELD_ID+" INTEGER, "+FIELD_NAME+" TEXT, "+FIELD_AUTHOR+" TEXT, "+FIELD_DETAILS+" TEXT, "+FIELD_PRICE+" NUMERIC, "+FIELD_IMAGE+" TEXT, PRIMARY KEY("+FIELD_ID+" AUTOINCREMENT))";
    public static String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;

    public static ArrayList<Yogi> getAllYogi(DatabaseHelper dbHelper){
        Yogi anItem;
        ArrayList<Yogi> data = new ArrayList<>();
        Cursor cursor = dbHelper.getAllRecords(TABLE_NAME, null);
        Log.d("DATABASE OPERATIONS", cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name = cursor.getString(1);
            String author= cursor.getString(2);
            String detail= cursor.getString(3);
            String price= cursor.getString(4);
            String image= cursor.getString(5);
            anItem = new Yogi(id, name, author, detail, price, image);
            data.add(anItem);

        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static ArrayList<Yogi> findContact(DatabaseHelper dbHelper, String key) {
        Yogi anItem;
        ArrayList<Yogi> data = new ArrayList<>();
        String where = FIELD_NAME +" like '%"+key+"%'";

        Cursor cursor = dbHelper.getSomeRecords(TABLE_NAME, null, where);
        Log.d("DATABASE OPERATIONS",  where+", "+cursor.getCount()+",  "+cursor.getColumnCount());
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name = cursor.getString(1);
            String author= cursor.getString(2);
            String detail= cursor.getString(3);
            String price= cursor.getString(4);
            String image= cursor.getString(5);
            anItem = new Yogi(id, name, author, detail, price, image);
            data.add(anItem);
        }
        Log.d("DATABASE OPERATIONS",data.toString());
        return data;
    }

    public static boolean insert(DatabaseHelper dbHelper, String id, String name, String author, String detail, String price, String image) {
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_AUTHOR, author);
        contentValues.put(FIELD_DETAILS, detail);
        contentValues.put(FIELD_PRICE, price);
        contentValues.put(FIELD_IMAGE, image);

        boolean res = dbHelper.insert(TABLE_NAME,contentValues);
        return res;
    }

    public static boolean update(DatabaseHelper dbHelper, String id, String name, String author, String detail, String price, String image) {
        //ContentValues  allows to define key value pairs.
        //The key represents the table column identifier and the value represents the content for the table record in this column.
        //ContentVales can be used for insert and update operations over table

        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_AUTHOR, author);
        contentValues.put(FIELD_DETAILS, detail);
        contentValues.put(FIELD_PRICE, price);
        contentValues.put(FIELD_IMAGE, image);

        String where = FIELD_ID +" = "+id;
        boolean res = dbHelper.update(TABLE_NAME,contentValues,where );
        return res;
    }

    public static boolean delete(  DatabaseHelper dbHelper, String id){
        Log.d("DATABASE OPERATIONS", "DELETE DONE");
        String where = FIELD_ID + " = "+id;
        boolean res =  dbHelper.delete(TABLE_NAME, where);
        return  res;
    }
}