package com.example.examen.db.SQL.DB;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Comicon";
    public static final String TABLE_COMICS =  "comics";



    public Helper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

//esta es la tabla aqui escribes los campos de tu tabla para la bd
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_COMICS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "editorial TEXT NOT NULL," +
                "costo INT NOT NULL)");
    }

    //esta funcion no se modifica, es por si no existe la tabla que se cree
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_COMICS);
        onCreate(sqLiteDatabase);
    }
}