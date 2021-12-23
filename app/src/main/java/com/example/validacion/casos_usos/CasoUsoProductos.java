package com.example.validacion.casos_usos;

import android.database.Cursor;

public class CasoUsoProductos {
    public String cursorToString(Cursor cursor){
        if(cursor.getCount() == 0){
            return "No Hay Datos";
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("ID: "+cursor.getString(0)+"\n");
                buffer.append("NAME: "+cursor.getString(1)+"\n\n");
                buffer.append("DESCRIPTION: "+cursor.getString(3)+"\n\n");
                buffer.append("PRICE: "+cursor.getString(4)+"\n\n");
            }
            return buffer.toString();
        }
    }
}
