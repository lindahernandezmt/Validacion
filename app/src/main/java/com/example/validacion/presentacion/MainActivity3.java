package com.example.validacion.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import com.example.validacion.R;
import com.example.validacion.datos.DBHelper;
import com.example.validacion.modelo.ProductoAdapter;
import com.example.validacion.modelo.productos;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private DBHelper dbHelper;
    private ArrayList<productos> productos;
    private GridView gridView;


    public ArrayList<productos> llenarLista(Cursor cursor){
        ArrayList<productos> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                com.example.validacion.modelo.productos productos = new productos(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getBlob(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                list.add(productos);
            }
            return list;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbHelper = new DBHelper(getApplicationContext());
        gridView = (GridView) findViewById(R.id.gridItem);

        Cursor cursor = dbHelper.getProductos();
        productos= llenarLista(cursor);
        ProductoAdapter productoAdapter = new ProductoAdapter(getApplicationContext(),productos);
        gridView.setAdapter(productoAdapter);
    }
}