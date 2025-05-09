package com.example.parcialapp2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioAdaptador.OnUsuarioClickListener {

    RecyclerView rcv_usuarios;
    UsuarioAdaptador adaptador;
    List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ahora usa activity_main.xml

        rcv_usuarios = findViewById(R.id.rcv_usuarios);
        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));

        listaUsuarios.add(new Usuario("https://i.pinimg.com/736x/34/68/a5/3468a52634ba9421a56148982f92fdf8.jpg", "Andrew Garfield", "Actor", "Spider-Man"));
        listaUsuarios.add(new Usuario("https://m.media-amazon.com/images/I/61g7HDxmyzL._AC_SL1500_.jpg", "Ken Carson", "Artist", "YVL"));
        listaUsuarios.add(new Usuario("https://www.grooveyard.ca/wp-content/uploads/harlowjack-come-home-poster.jpg", "Jack Harlow", "Artista", "Jack"));

        adaptador = new UsuarioAdaptador(this, listaUsuarios, this);
        rcv_usuarios.setAdapter(adaptador);
    }

    @Override
    public void onUsuarioClick(Usuario usuario) {
        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}
