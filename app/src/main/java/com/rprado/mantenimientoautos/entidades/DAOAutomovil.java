package com.rprado.mantenimientoautos.entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.rprado.mantenimientoautos.util.BDAutomovil;
import com.rprado.mantenimientoautos.util.Constantes;

import java.util.ArrayList;

public class DAOAutomovil {

    BDAutomovil bdAutomovil;
    SQLiteDatabase database;

    public DAOAutomovil (Context context) {bdAutomovil = new BDAutomovil(context);}
    public void OpenDB(){ database = bdAutomovil.getWritableDatabase();}


    public void registrarAutomovil(Automovil automovil){
        try {
            ContentValues values = new ContentValues();
            values.put("plaAut",automovil.getPlaca());
            values.put("proAut",automovil.getPropietario());
            values.put("marAut",automovil.getMarca());
            values.put("fabAut",automovil.getFabricacion());
            values.put("repAut",automovil.getReparado());
            database.insert(Constantes.NOMBRETABLA, null,values);

        }catch (Exception e){
            Log.d("===>>>",e.getMessage());
        }
    }

    public void modificarAutomovil(Automovil automovil){
        try {
            ContentValues values = new ContentValues();
            values.put("plaAut",automovil.getPlaca());
            values.put("proAut",automovil.getPropietario());
            values.put("marAut",automovil.getMarca());
            values.put("fabAut",automovil.getFabricacion());
            values.put("repAut",automovil.getReparado());
            database.update(Constantes.NOMBRETABLA,values,"id="+automovil.getId(),null);
        }catch (Exception e){
            Log.d("===>>>",e.getMessage());
        }
    }


    public void eliminarAutomovil(int id){
        try {
            database.delete(Constantes.NOMBRETABLA, "id="+id,null);
        }catch (Exception e){
            Log.d("===>>>",e.getMessage());
        }
    }

    public ArrayList<Automovil> cargarAutomoviles(){
        ArrayList<Automovil> lista = new ArrayList<>();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM "+Constantes.NOMBRETABLA,null);
            while (cursor.moveToNext()){
                lista.add(new Automovil(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                ));

                System.out.println("getdata:"+cursor.getString(1));
            }
        }catch (Exception e){
            Log.d("===>>>",e.getMessage());
        }
        return lista;
    }


}
