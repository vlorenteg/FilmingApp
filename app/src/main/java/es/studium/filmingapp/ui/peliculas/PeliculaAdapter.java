package es.studium.filmingapp.ui.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.filmingapp.R;

// Es el adaptador del RecyclerView, que conecta la lista de objetos Pelicula con el RecyclerView en la UI.
// La lista de objetos Pelicula se pasa a esta clase, que se encarga de crear y llenar los elementos visuales de cada película en la vista utilizando un ViewHolder
// Utiliza el RecyclerViewOnItemClickListener para gestionar los clics en los elementos de la lista.

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaViewHolder> {
    // Lista de objetos Pelicula que representarán los datos en el RecyclerView.
    List<Pelicula> items;
    // Interfaz para manejar los clics en los elementos del RecyclerView.
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    // Constructor del adaptador que recibe la lista de películas y el listener de clics.
    public PeliculaAdapter(@NonNull List<Pelicula> items, @NonNull RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.items = items; // Se asigna la lista de películas al adaptador.
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener; // Se asigna el listener.
    }

    // Método que se llama cuando se necesita crear un nuevo ViewHolder.
    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Infla (crea) la vista de cada elemento desde pelicula_card.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pelicula_card, viewGroup, false);
        // Retorna una nueva instancia de PeliculaViewHolder con la vista inflada y el listener
        return new PeliculaViewHolder(v, recyclerViewOnItemClickListener);
    }

    // Método que se llama para actualizar un ViewHolder con los datos correspondientes.
    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder viewHolder, int i) {
        // Se asigna la imagen del objeto Pelicula correspondiente en la posición i.
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        // Se asigna el título de la película correspondiente en la posición i.
        viewHolder.titulo.setText(items.get(i).getTitulo());
    }

    // Método que devuelve la cantidad total de elementos en la lista.
    @Override
    public int getItemCount() {
        return items.size();
    }
}
