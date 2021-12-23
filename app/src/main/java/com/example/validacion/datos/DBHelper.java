package com.example.validacion.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, "flash.db", null, 1);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTOS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME VARCHAR, " +
                "IMAGE BLOB," +
                "DESCRIPTION VARCHAR," +
                "PRICE STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
    }

    //Funciones presonalizadas
    public void insertProductos(String name, byte[] image, String description, String price){
        String sql = "INSERT INTO PRODUCTOS VALUES(null, ?, ?, ?, ?)";
        SQLiteStatement statement= sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);
        statement.bindString(3, description);
        statement.bindString(4, price);

        statement.executeInsert();
    }

    public Cursor getProductos(){
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS", null);
        return cursor;
    }

    public Cursor getProductosById(String id){
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM PRODUCTOS WHERE ID="+id, null);
        return cursor;
    }

    public void deleteProductos(String id){
        sqLiteDatabase.execSQL("DELETE FROM PRODUCTOS WHERE id = "+id);
    }

    public void updateProductos(String id, String name, byte[] image, String description, String price){
        String sql = "UPDATE PRODUCTOS " +
                "SET NAME=?," +
                "IMAGE=?," +
                "DESCRIPTION=?," +
                "PRICE=?";
        SQLiteStatement statement= sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);
        statement.bindString(3, description);
        statement.bindString(4, price);

        statement.executeUpdateDelete();
    }
}
