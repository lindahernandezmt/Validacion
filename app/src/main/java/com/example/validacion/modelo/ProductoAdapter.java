package com.example.validacion.modelo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.validacion.R;
import com.example.validacion.presentacion.MainActivity3;
import com.example.validacion.presentacion.MainActivity4;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

        Context context;
        ArrayList<productos> productos;
        LayoutInflater inflater;

        public ProductoAdapter(Context context, ArrayList<productos> productos) {
            this.context = context;
            this.productos = productos;
        }

        @Override
        public int getCount() {
            return productos.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.producto_model, null);
            }

            ImageView imageView = convertView.findViewById(R.id.imgItemModel);
            TextView campo1 = convertView.findViewById(R.id.tvNameModel);
            TextView campo2 = convertView.findViewById(R.id.tvDescriptionModel);
            Button button = convertView.findViewById(R.id.button);

            productos producto = productos.get(position);
            byte[] image = producto.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);


            campo1.setText(producto.getName());
            campo2.setText(producto.getDescription());
            imageView.setImageBitmap(bitmap);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, MainActivity4.class);
                    intent.putExtra("name",producto.getName());
                    intent.putExtra("description",producto.getDescription());
                    intent.putExtra("price",producto.getPrice());
                    intent.putExtra("id",producto.getId());
                    context.startActivity(intent);
                }
            });

            return convertView;
        }
}
