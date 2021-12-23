package com.example.validacion.presentacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.validacion.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /**
         * Clase MenuInflater que controla el menú
         *
         */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Definicion de la funcionalidad para que se ejute cada vez que se le da click a un item del menú
     *
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /**
         * Se declara como va a tomar los items
         *
         */
        int id = item.getItemId();

        /**
         * Toma el id y lo compara con lo que esta en R de productosOpcion
         *
         */
        if(id == R.id.agregarProductos){
            Toast.makeText(getApplicationContext(),"Aquí podrá agregar los productos", Toast.LENGTH_LONG).show();
            Intent productosPantalla = new Intent(this, MainActivity2.class);
            startActivity(productosPantalla);
        }
        if(id == R.id.catalogoProductos){
            Toast.makeText(getApplicationContext(),"Aquí verá el catalogo productos", Toast.LENGTH_LONG).show();
            Intent productosPantalla = new Intent(this, MainActivity3.class);
            startActivity(productosPantalla);
        }

        return super.onOptionsItemSelected(item);
    }
}
