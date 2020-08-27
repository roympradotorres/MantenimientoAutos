package com.rprado.mantenimientoautos.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDAutomovil extends SQLiteOpenHelper {
    public BDAutomovil(Context context){
        super(context,Constantes.NOMBREDB,null,Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Constantes.NOMBRETABLA+
                    "(id integer Primary Key autoincrement,"+
                    "plaAut text not null,"+
                    "proAut text not null,"+
                    "marAut text not null,"+
                    "fabAut text not null,"+
                    "repAut text not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
