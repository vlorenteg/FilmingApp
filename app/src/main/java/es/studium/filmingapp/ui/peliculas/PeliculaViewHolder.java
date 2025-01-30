package es.studium.filmingapp.ui.peliculas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.filmingapp.R;

// Se usa dentro del PeliculaAdapter para enlazar las vistas de cada elemento del RecyclerView con los datos de una Pelicula

// ViewHolder para el adaptador del RecyclerView
public class PeliculaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imagen;
    TextView titulo;
    // Listener para manejar clics en los elementos del RecyclerView
    private final RecyclerViewOnItemClickListener listener;

    // Constructor que recibe la vista del ítem y el listener de clics
    public PeliculaViewHolder(@NonNull View v, @NonNull RecyclerViewOnItemClickListener listener) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.imagen);
        titulo = (TextView) v.findViewById(R.id.titulo);
        this.listener = listener;
        v.setOnClickListener(this);
    }

    // Método que se ejecuta cuando se hace clic en un ítem
    @Override
    public void onClick(View v) {
        listener.onClick(v, getAbsoluteAdapterPosition());
    }
}
