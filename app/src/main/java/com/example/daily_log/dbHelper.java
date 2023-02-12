package com.example.daily_log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";


    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_SALAH = "salah";
    private static final String COLUMN_JAMMAT = "jammat";
    private static final String COLUMN_RAKAT = "rakat";
    private static final String COLUMN_TAHAJUD = "tahajud";

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_DATE + " TEXT,"
                + COLUMN_SALAH + " TEXT,"
                + COLUMN_JAMMAT + " INTEGER,"
                + COLUMN_RAKAT + " TEXT,"
                + COLUMN_TAHAJUD + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, student.getDate());
        values.put(COLUMN_SALAH, student.getSalah());
        values.put(COLUMN_JAMMAT, student.isJammat());
        values.put(COLUMN_RAKAT, student.getRakat());
        values.put(COLUMN_TAHAJUD, student.isTahajud());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return res;
    }
}
