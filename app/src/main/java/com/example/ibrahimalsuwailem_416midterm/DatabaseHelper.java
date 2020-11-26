package com.example.ibrahimalsuwailem_416midterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "city.db";
    public static final String TABLE_NAME = "residents";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_SURNAME = "Surname";
    public static final String COLUMN_PHONE = "Phone-number";
    public static final String COLUMN_IQAMA = "personal-ID-number";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE "+TABLE_NAME+"("
                        +COLUMN_ID+" INTEGER PRIMARY KEY, "
                        +COLUMN_NAME+" TEXT NOT NULL, "
                        +COLUMN_SURNAME+" TEXT NOT NULL, "
                        +COLUMN_PHONE+" TEXT NOT NULL, "
                        +COLUMN_IQAMA+" TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addData(String name, String surname, String phone, String iqama){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SURNAME, surname);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_IQAMA, iqama);
        long result = db.insert(TABLE_NAME, null, values);

        if(result == -1){
            return false;
        } else{
            return true;
        }
    }

    public Integer deleteIqama(String iqama){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "personal-ID-number = ?", new String[] {iqama});
    }

    public Integer deleteID(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }

    public Cursor find(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor x = db.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_SURNAME, COLUMN_PHONE, COLUMN_IQAMA}, COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if(x != null){
            x.moveToFirst();
        }
        return x;
    }

    public Cursor findName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor x = db.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_SURNAME, COLUMN_PHONE, COLUMN_IQAMA}, COLUMN_NAME + "=?", new String[]{String.valueOf(name)}, null, null, null, null);
        if(x != null){
            x.moveToFirst();
        }
        return x;
    }
}