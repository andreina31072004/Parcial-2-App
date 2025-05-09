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
        listaUsuarios.add(new Usuario("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq7ZeDo7Q6nSd88yEelqhEFG96UvQxcbJVPQ&s.jpg", "Drake", "Artista", "Champagne Papi"));
        listaUsuarios.add(new Usuario("https://media.vogue.es/photos/66bf003863d66e57219a09ec/2:3/w_2560%2Cc_limit/JDR-Or_Crop_Centre_DP-1.jpg", "Rihanna", "Artista", "Riri"));
        listaUsuarios.add(new Usuario("https://variety.com/wp-content/uploads/2024/09/GettyImages-2001553148.jpg", "Travis Scott", "Artista", "La Flame"));

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
