package es.studium.filmingapp.ui.peliculas;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import es.studium.filmingapp.R;

public class PeliculasFragmentDetails extends Fragment {

    // Claves para los argumentos que se pueden pasar al fragmento
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    // Componentes de la interfaz de usuario
    ImageView img;
    ImageView imgEnlarged;
    TextView director;
    TextView reparto;
    TextView clasificacion;
    TextView sinopsis;

    String actionBarTitle;


    public PeliculasFragmentDetails() {
        // Constructor vacío necesario para el fragmento
    }

    // Método para crear una nueva instancia del fragmento con argumentos
    public static PeliculasFragmentDetails newInstance(String param1, String param2) {
        PeliculasFragmentDetails fragment = new PeliculasFragmentDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Recuperamos los argumentos pasados al fragmento
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos la vista del fragmento con su layout correspondiente
        View root = inflater.inflate(R.layout.fragment_peliculas_details, container, false);
        Bundle bundle = getArguments(); // Obtenemos los argumentos pasados al fragmento

        if (bundle != null) {
            // Obtenemos la posición de la película seleccionada, con valor predeterminado 0
            int peliculaPosicion = bundle != null ? bundle.getInt("position", 0) : 0; // Aquí obtenemos la posición

            // Vinculamos los elementos de la interfaz con las vistas del layout
            img = root.findViewById(R.id.imageViewP2);
            imgEnlarged = root.findViewById(R.id.imageViewP2enlarged);
            director = root.findViewById(R.id.textViewDirector);
            reparto = root.findViewById(R.id.textViewReparto);
            clasificacion = root.findViewById(R.id.textViewClasificacion);
            sinopsis = root.findViewById(R.id.textViewSinopsis);

            // Obtenemos la barra de acción desde la actividad contenedora
            AppCompatActivity activity = (AppCompatActivity) requireActivity();
            ActionBar actionBar = activity.getSupportActionBar();

            // Asignamos la información correspondiente a cada película según su posición
            switch (peliculaPosicion) {
                case 0:
                    img.setImageResource(R.drawable.memento);
                    imgEnlarged.setImageResource(R.drawable.memento);
                    director.setText(getResources().getString(R.string.director1));
                    reparto.setText(getResources().getString(R.string.reparto1));
                    clasificacion.setText(getResources().getString(R.string.clasificacion1));
                    sinopsis.setText(getResources().getString(R.string.sinopsis1));
                    actionBarTitle = getResources().getString(R.string.titulo1);
                    break;
                case 1:
                    img.setImageResource(R.drawable.apocalypse);
                    imgEnlarged.setImageResource(R.drawable.apocalypse);
                    director.setText(getResources().getString(R.string.director2));
                    reparto.setText(getResources().getString(R.string.reparto2));
                    clasificacion.setText(getResources().getString(R.string.clasificacion2));
                    sinopsis.setText(getResources().getString(R.string.sinopsis2));
                    actionBarTitle = getResources().getString(R.string.titulo2);
                    break;
                case 2:
                    img.setImageResource(R.drawable.origen);
                    imgEnlarged.setImageResource(R.drawable.origen);
                    director.setText(getResources().getString(R.string.director3));
                    reparto.setText(getResources().getString(R.string.reparto3));
                    clasificacion.setText(getResources().getString(R.string.clasificacion3));
                    sinopsis.setText(getResources().getString(R.string.sinopsis3));
                    actionBarTitle = getResources().getString(R.string.titulo3);
                    break;
                case 3:
                    img.setImageResource(R.drawable.show);
                    imgEnlarged.setImageResource(R.drawable.show);
                    director.setText(getResources().getString(R.string.director4));
                    reparto.setText(getResources().getString(R.string.reparto4));
                    clasificacion.setText(getResources().getString(R.string.clasificacion4));
                    sinopsis.setText(getResources().getString(R.string.sinopsis4));
                    actionBarTitle = getResources().getString(R.string.titulo4);
                    break;
                case 4:
                    img.setImageResource(R.drawable.blade);
                    imgEnlarged.setImageResource(R.drawable.blade);
                    director.setText(getResources().getString(R.string.director5));
                    reparto.setText(getResources().getString(R.string.reparto5));
                    clasificacion.setText(getResources().getString(R.string.clasificacion5));
                    sinopsis.setText(getResources().getString(R.string.sinopsis5));
                    actionBarTitle = getResources().getString(R.string.titulo5);
                    break;
                case 5:
                    img.setImageResource(R.drawable.interstellar);
                    imgEnlarged.setImageResource(R.drawable.interstellar);
                    director.setText(getResources().getString(R.string.director6));
                    reparto.setText(getResources().getString(R.string.reparto6));
                    clasificacion.setText(getResources().getString(R.string.clasificacion6));
                    sinopsis.setText(getResources().getString(R.string.sinopsis6));
                    actionBarTitle = getResources().getString(R.string.titulo6);
                    break;
            }

            // Establecemos el título de la barra de acción
            if (actionBar != null) {
                actionBar.setTitle(actionBarTitle);
            }

            // Configuramos los eventos de clic para mostrar la imagen en grande
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imgEnlarged.getVisibility() == View.INVISIBLE) {
                        imgEnlarged.setVisibility(View.VISIBLE);
                        imgEnlarged.bringToFront();
                    }
                }
            });

            // Ocultamos la imagen ampliada al hacer clic sobre ella
            imgEnlarged.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imgEnlarged.getVisibility() == View.VISIBLE) {
                        imgEnlarged.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }

        return root;
    }
}

