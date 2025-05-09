package com.example.parcialapp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    TextView txtNombre, txtProfesion, txtApodo;
    ImageView img;
    Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtNombre = findViewById(R.id.txtNombre);
        txtProfesion = findViewById(R.id.txtProfesion);
        txtApodo = findViewById(R.id.txtApodo);
        img = findViewById(R.id.imgDetalle);
        btnCerrar = findViewById(R.id.btnCerrar);

        Usuario u = (Usuario) getIntent().getSerializableExtra("usuario");

        txtNombre.setText(u.getNombre());
        txtProfesion.setText("Profesión: " + u.getProfesion());
        txtApodo.setText("Apodo: " + u.getApodo());
        Picasso.get().load(u.getImagen()).into(img);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("sesion", Context.MODE_PRIVATE);
                preferences.edit().clear().apply();
                startActivity(new Intent(DetalleActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
