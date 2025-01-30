package es.studium.filmingapp.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentPeliculasBinding;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

// Este fragmento es responsable de la interfaz principal donde se muestra la lista de películas utilizando RecyclerView


// Definición de la clase PeliculasFragment que extiende de Fragment
public class PeliculasFragment extends Fragment {
    // Variable para manejar la vinculación con el layout XML mediante ViewBinding
    private FragmentPeliculasBinding binding;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    // Método que se ejecuta cuando se crea el Fragment (antes de la creación de la vista)
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    // Método que se ejecuta cuando se crea la vista del Fragment
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Se obtiene una instancia del ViewModel asociado a este Fragment
        PeliculasViewModel peliculasViewModel =
                new ViewModelProvider(this).get(PeliculasViewModel.class);

        // Se crea una lista de objetos Pelicula con sus imágenes y títulos
        List items = new ArrayList();
        items.add(new Pelicula(R.drawable.memento, R.string.titulo1));
        items.add(new Pelicula(R.drawable.apocalypse, R.string.titulo2));
        items.add(new Pelicula(R.drawable.origen, R.string.titulo3));
        items.add(new Pelicula(R.drawable.show, R.string.titulo4));
        items.add(new Pelicula(R.drawable.blade, R.string.titulo5));
        items.add(new Pelicula(R.drawable.interstellar, R.string.titulo6));

        // Se infla el layout usando ViewBinding en lugar de findViewById
        binding = FragmentPeliculasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Se obtiene la referencia al RecyclerView
        recycler = (RecyclerView) root.findViewById(R.id.myRecyclerViewPeliculas);
        recycler.setHasFixedSize(true);

        // Se define el LayoutManager como LinearLayoutManager para mostrar los elementos en lista
        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);

        // Se asigna un adaptador al RecyclerView con los elementos y un listener para clics
        recycler.setAdapter(new PeliculaAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                // Cuando se hace clic en un elemento, se pasa su posición a otro fragmento
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                // Se navega al fragmento que muestra la imagen de la película seleccionada
                Navigation.findNavController(v).navigate(R.id.nav_peliculas_to_peliculas_imagen, bundle);
            }
        }));
        return root;
    }

    // Método que se ejecuta cuando la vista del Fragment ha sido creada
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // Método que se ejecuta cuando la vista del Fragment se destruye
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}