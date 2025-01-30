
package es.studium.filmingapp.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentSeriesBinding;

// Este fragmento es responsable de la interfaz principal donde se muestra la lista de series utilizando RecyclerView


// Definición de la clase SeriesFragment que extiende de Fragment
public class SeriesFragment extends Fragment {
    private FragmentSeriesBinding binding;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    // Método que se ejecuta cuando se crea la vista del Fragment
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Se obtiene una instancia del ViewModel asociado a este Fragment
        SeriesViewModel seriesViewModel =
                new ViewModelProvider(this).get(SeriesViewModel.class);

        // Se crea una lista de objetos Pelicula con sus imágenes y títulos
        List items = new ArrayList();
        items.add(new Serie(R.drawable.bad, R.string.tituloSerie1));
        items.add(new Serie(R.drawable.peaky, R.string.tituloSerie2));
        items.add(new Serie(R.drawable.aqui, R.string.tituloSerie3));
        items.add(new Serie(R.drawable.serrano, R.string.tituloSerie4));

        // Se infla el layout usando ViewBinding en lugar de findViewById
        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Se obtiene la referencia al RecyclerView
        recycler = (RecyclerView) root.findViewById(R.id.myRecyclerViewSeries);
        recycler.setHasFixedSize(true);

        // Se define el LayoutManager como LinearLayoutManager para mostrar los elementos en lista
        lManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(lManager);

        // Se asigna un adaptador al RecyclerView con los elementos y un listener para clics
        recycler.setAdapter(new SerieAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                Navigation.findNavController(v).navigate(R.id.nav_series_to_series_imagen, bundle);
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
