package es.studium.filmingapp.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.studium.filmingapp.R;
import es.studium.filmingapp.databinding.FragmentSeriesImagenBinding;

public class SeriesImagenFragment extends Fragment {
    // Variable para manejar el binding y acceder a los elementos del layout
    private FragmentSeriesImagenBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout usando ViewBinding
        binding = FragmentSeriesImagenBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Obtén la posición del Bundle
        Bundle bundle = getArguments();
        int position = bundle != null ? bundle.getInt("position") : -1;

        // Establece la imagen en base a la posición
        if (position != -1) {
            switch (position) {
                case 0:
                    binding.imageView.setImageResource(R.drawable.bad);
                    break;
                case 1:
                    binding.imageView.setImageResource(R.drawable.peaky);
                    break;
                case 2:
                    binding.imageView.setImageResource(R.drawable.aqui);
                    break;
                case 3:
                    binding.imageView.setImageResource(R.drawable.serrano);
                    break;
            }
        }

        // Configura el botón para navegar al detalle
        binding.imageView.setOnClickListener(v -> {
            // Usamos la posición que ya obtuviste
            Bundle bundleDetails = new Bundle();
            bundleDetails.putInt("position", position); // Usamos la posición dinámica
            Navigation.findNavController(v).navigate(R.id.nav_series_imagen_to_series_details, bundleDetails);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
