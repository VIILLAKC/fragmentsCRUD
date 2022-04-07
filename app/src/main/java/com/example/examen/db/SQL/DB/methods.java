package com.example.examen.db.SQL.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.examen.db.SQL.DB.Helper;

import java.util.ArrayList;


public class methods extends Helper{
    //le decimos que ocuparemos un contexto
    Context context;


    //constructor de esta clase
    public methods(@Nullable Context context) {
        super(context);
        //usamos el contexto creado
        this.context = context;
    }

    //metodo para insertar a la base de datos
    public long insertarComic(String nombre, String editorial, String costo){
        //usamos un id = 0 para comprobar que se guardaron los datos
        long id = 0;
        //try catch para que no truene el programa si algo salio mal
        try {
            Helper DBhelper = new Helper(context);
            SQLiteDatabase db = DBhelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("editorial", editorial);
            valores.put("costo", costo);
            id = db.insert(TABLE_COMICS, null, valores);

        }catch (Exception ex){
            ex.toString();
            id = 0;
            return id;
        }
        return  id;
    }

    //metodo para elimar usando id
    public long eliminarComic(int id){
        try {
            Helper DBhelper = new Helper(context);
            SQLiteDatabase db = DBhelper.getWritableDatabase();
           db.delete(TABLE_COMICS,"id = " + id, null);
        }catch (Exception ex){
            ex.toString();
            id = 0;
            return id;
        }
        return  id;
    }

    //metodo para actualizar
    public  long actualizarComiscs(int id, String nombre, String editorial, String costo){
        //try catch para que no truene el programa si algo salio mal
        try {
            Helper DBhelper = new Helper(context);
            SQLiteDatabase db = DBhelper.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("nombre", nombre);
            valores.put("editorial", editorial);
            valores.put("costo", costo);
            db.update(TABLE_COMICS,valores,"id = " + id,null);
        }catch (Exception ex){
            ex.toString();
            id = 0;
            return  id;
        }
        return  id;
    }

    //Esta clase es para crear un array list
    public ArrayList<String> mostrarSpiner(){
        Helper DBhelper = new Helper(context);
        SQLiteDatabase db = DBhelper.getWritableDatabase();

        ArrayList<String> listaComics = new ArrayList<>();
        Cursor cursorComics = null;

        cursorComics = db.rawQuery("SELECT * FROM " + TABLE_COMICS, null);

        if (cursorComics.moveToFirst()){
            do {
                listaComics.add(cursorComics.getString(1));
            }while (cursorComics.moveToNext());
        }
        cursorComics.close();
        return listaComics;
    }


}


