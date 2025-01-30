package es.studium.filmingapp.ui.series;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.filmingapp.R;

// Es el adaptador del RecyclerView, que conecta la lista de objetos Serie con el RecyclerView en la UI.
// La lista de objetos Serie se pasa a esta clase, que se encarga de crear y llenar los elementos visuales de cada serie en la vista utilizando un ViewHolder
// Utiliza el RecyclerViewOnItemClickListener para gestionar los clics en los elementos de la lista.

public class SerieAdapter extends RecyclerView.Adapter<SerieViewHolder> {
    List<Serie> items;
    // Interfaz para manejar los clics en los elementos del RecyclerView.
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;
    // Constructor del adaptador que recibe la lista de películas y el listener de clics.
    public SerieAdapter(@NonNull List<Serie> items, @NonNull RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.items = items;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    // Método que se llama cuando se necesita crear un nuevo ViewHolder.
    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Infla (crea) la vista de cada elemento desde serie_card.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.serie_card, viewGroup, false);
        return new SerieViewHolder(v, recyclerViewOnItemClickListener);
    }

    // Método que se llama para actualizar un ViewHolder con los datos correspondientes.
    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.titulo.setText(items.get(i).getTitulo());
    }

    // Método que devuelve la cantidad total de elementos en la lista.
    @Override
    public int getItemCount() {
        return items.size();
    }
}
