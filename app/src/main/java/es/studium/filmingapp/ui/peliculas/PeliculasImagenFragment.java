package es.studium.filmingapp.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentPeliculasImagenBinding;

public class PeliculasImagenFragment extends Fragment {
    // Variable para manejar el binding y acceder a los elementos del layout
    private FragmentPeliculasImagenBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout usando ViewBinding
        binding = FragmentPeliculasImagenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtén la posición del Bundle
        Bundle bundle = getArguments();
        int position = bundle != null ? bundle.getInt("position") : -1;

        // Si la posición es válida, se asigna la imagen correspondiente
        if (position != -1) {
            switch (position) {
                case 0:
                    binding.imageView.setImageResource(R.drawable.memento);
                    break;
                case 1:
                    binding.imageView.setImageResource(R.drawable.apocalypse);
                    break;
                case 2:
                    binding.imageView.setImageResource(R.drawable.origen);
                    break;
                case 3:
                    binding.imageView.setImageResource(R.drawable.show);
                    break;
                case 4:
                    binding.imageView.setImageResource(R.drawable.blade);
                    break;
                case 5:
                    binding.imageView.setImageResource(R.drawable.interstellar);
                    break;
            }
        }

        // Configura el botón para navegar al detalle
        binding.imageView.setOnClickListener(v -> {
            // Usamos la posición que ya obtuviste
            Bundle bundleDetails = new Bundle();
            bundleDetails.putInt("position", position); // Usamos la posición dinámica
            // Navegamos al fragmento de detalles usando Navigation Component
            Navigation.findNavController(v).navigate(R.id.nav_peliculas_imagen_to_peliculas_details, bundleDetails);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
