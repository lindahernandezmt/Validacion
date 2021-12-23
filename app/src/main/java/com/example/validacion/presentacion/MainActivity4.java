package com.example.validacion.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.validacion.R;

public class MainActivity4 extends AppCompatActivity {

    private int id = 0;
    private String name = "";
    private String description = "";
    private String price = "";
    private byte[] image;

    private ImageView imgProduct;
    private TextView tvName, tvDescription, tvId, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        try{
            Intent intent = getIntent();
            id = intent.getIntExtra("id",0);
            name = intent.getStringExtra("name");
            description = intent.getStringExtra("description");
            image = intent.getByteArrayExtra("image");
            price = intent.getStringExtra("price");

            tvName = (TextView) findViewById(R.id.name);
            tvDescription = (TextView) findViewById(R.id.description);
            tvPrice = (TextView) findViewById(R.id.price);
            imgProduct = (ImageView) findViewById(R.id.image);

            tvName.setText(name);
            tvDescription.setText(description);
            tvPrice.setText(price);
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            imgProduct.setImageBitmap(bitmap);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }
}