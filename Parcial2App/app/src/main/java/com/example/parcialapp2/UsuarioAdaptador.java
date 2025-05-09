package com.example.parcialapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;
    private Context context;
    private OnUsuarioClickListener listener;

    public UsuarioAdaptador(Context context, List<Usuario> datos, OnUsuarioClickListener listener) {
        this.context = context;
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
	holder.btnLogin.setOnClickListener(v -> {
	    Intent i = new Intent(context, DetalleActivity.class);
	    i.putExtra("usuario", dato);
	    context.startActivity(i);
	});
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface OnUsuarioClickListener {
        void onUsuarioClick(Usuario usuario);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_usuario, txt_profesion_usuario, txt_apodo_usuario;
        ImageView img_user;
        Button btnLogin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_profesion_usuario = itemView.findViewById(R.id.txt_profesion_usuario);
            txt_apodo_usuario = itemView.findViewById(R.id.txt_apodo_usuario);
            img_user = itemView.findViewById(R.id.img_user);
            btnLogin = itemView.findViewById(R.id.btnLogin);
        }

        public void bind(Usuario dato) {
            txt_nombre_usuario.setText(dato.getNombre());
            txt_profesion_usuario.setText(dato.getProfesion());
            txt_apodo_usuario.setText(dato.getApodo());
            Picasso.get().load(dato.getImagen()).into(img_user);
        }
    }
}
