package es.studium.filmingapp.ui.series;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.studium.filmingapp.R;


public class SeriesFragmentDetails extends Fragment {

    // Claves para los argumentos que se pueden pasar al fragmento
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ImageView imgS;
    ImageView imgSEnlarged;
    TextView directorS;
    TextView repartoS;
    TextView clasificacionS;
    TextView sinopsisS;
    TextView temporadasTotalS;
    TextView temporada1, temporada2, temporada3, temporada4, temporada5, temporada6, temporada7, temporada8, temporada9;
    TextView temporada1lista, temporada2lista, temporada3lista, temporada4lista, temporada5lista, temporada6lista, temporada7lista, temporada8lista, temporada9lista;

    String actionBarTitle;

    public SeriesFragmentDetails() {
        // Constructor vacío necesario para el fragmento
    }

    // Método para crear una nueva instancia del fragmento con argumentos
    public static SeriesFragmentDetails newInstance(String param1, String param2) {
        SeriesFragmentDetails fragment = new SeriesFragmentDetails();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos la vista del fragmento con su layout correspondiente
        View root = inflater.inflate(R.layout.fragment_series_details, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            // Obtenemos la posición de la serie seleccionada, con valor predeterminado 0
            int seriesPosition = bundle.getInt("position", 0) + 1;

            // Vinculamos los elementos de la interfaz con las vistas del layout
            imgS = root.findViewById(R.id.imageViewS2);
            imgSEnlarged = root.findViewById(R.id.imageViewS2enlarged);
            directorS = root.findViewById(R.id.textViewDirectorS);
            repartoS = root.findViewById(R.id.textViewRepartoS);
            clasificacionS = root.findViewById(R.id.textViewClasificacionS);
            sinopsisS = root.findViewById(R.id.textViewSinopsisS);
            temporadasTotalS = root.findViewById(R.id.textViewTemporadasTotal);
            temporada1 = root.findViewById(R.id.buttonTemporada1);
            temporada1lista = root.findViewById(R.id.textViewTemporada1Lista);
            temporada2 = root.findViewById(R.id.buttonTemporada2);
            temporada2lista = root.findViewById(R.id.textViewTemporada2Lista);
            temporada3 = root.findViewById(R.id.buttonTemporada3);
            temporada3lista = root.findViewById(R.id.textViewTemporada3Lista);
            temporada4 = root.findViewById(R.id.buttonTemporada4);
            temporada4lista = root.findViewById(R.id.textViewTemporada4Lista);
            temporada5 = root.findViewById(R.id.buttonTemporada5);
            temporada5lista = root.findViewById(R.id.textViewTemporada5Lista);
            temporada6 = root.findViewById(R.id.buttonTemporada6);
            temporada6lista = root.findViewById(R.id.textViewTemporada6Lista);
            temporada7 = root.findViewById(R.id.buttonTemporada7);
            temporada7lista = root.findViewById(R.id.textViewTemporada7Lista);
            temporada8 = root.findViewById(R.id.buttonTemporada8);
            temporada8lista = root.findViewById(R.id.textViewTemporada8Lista);
            temporada9 = root.findViewById(R.id.buttonTemporada9);
            temporada9lista = root.findViewById(R.id.textViewTemporada9Lista);

            AppCompatActivity activity = (AppCompatActivity) requireActivity();
            ActionBar actionBar = activity.getSupportActionBar();

            switch (seriesPosition) {
                case 1:
                    imgS.setImageResource(R.drawable.bad);
                    imgSEnlarged.setImageResource(R.drawable.bad);
                    directorS.setText(getResources().getString(R.string.directorSerie1));
                    repartoS.setText(getResources().getString(R.string.repartoSerie1));
                    clasificacionS.setText(getResources().getString(R.string.clasificacionSerie1));
                    sinopsisS.setText(getResources().getString(R.string.sinopsisSerie1));
                    temporadasTotalS.setText(R.string.temporadasTotalSerie1);
                    temporada1.setText(R.string.temporada1NumeroEpisodiosSerie1);
                    temporada1lista.setText(R.string.temporada1ListaSerie1);
                    temporada2.setText(R.string.temporada2NumeroEpisodiosSerie1);
                    temporada2lista.setText(R.string.temporada2ListaSerie1);
                    temporada3.setText(R.string.temporada3NumeroEpisodiosSerie1);
                    temporada3lista.setText(R.string.temporada3ListaSerie1);
                    temporada4.setText(R.string.temporada4NumeroEpisodiosSerie1);
                    temporada4lista.setText(R.string.temporada4ListaSerie1);
                    temporada5.setText(R.string.temporada5NumeroEpisodiosSerie1);
                    temporada5lista.setText(R.string.temporada5ListaSerie1);
                    temporada6.setVisibility(View.GONE);
                    temporada6lista.setVisibility(View.GONE);
                    temporada7.setVisibility(View.GONE);
                    temporada7lista.setVisibility(View.GONE);
                    temporada8.setVisibility(View.GONE);
                    temporada8lista.setVisibility(View.GONE);
                    temporada9.setVisibility(View.GONE);
                    temporada9lista.setVisibility(View.GONE);
                    actionBarTitle = getResources().getString(R.string.tituloSerie1);
                    break;
                case 2:
                    imgS.setImageResource(R.drawable.peaky);
                    imgSEnlarged.setImageResource(R.drawable.peaky);
                    directorS.setText(getResources().getString(R.string.directorSerie2));
                    repartoS.setText(getResources().getString(R.string.repartoSerie2));
                    clasificacionS.setText(getResources().getString(R.string.clasificacionSerie2));
                    sinopsisS.setText(getResources().getString(R.string.sinopsisSerie2));
                    temporadasTotalS.setText(R.string.temporadasTotalSerie2);
                    temporada1.setText(R.string.temporada1NumeroEpisodiosSerie2);
                    temporada1lista.setText(R.string.temporada1ListaSerie2);
                    temporada2.setText(R.string.temporada2NumeroEpisodiosSerie2);
                    temporada2lista.setText(R.string.temporada2ListaSerie2);
                    temporada3.setText(R.string.temporada3NumeroEpisodiosSerie2);
                    temporada3lista.setText(R.string.temporada3ListaSerie2);
                    temporada4.setText(R.string.temporada4NumeroEpisodiosSerie2);
                    temporada4lista.setText(R.string.temporada4ListaSerie2);
                    temporada5.setText(R.string.temporada5NumeroEpisodiosSerie2);
                    temporada5lista.setText(R.string.temporada5ListaSerie2);
                    temporada6.setText(R.string.temporada6NumeroEpisodiosSerie2);
                    temporada6lista.setText(R.string.temporada6ListaSerie2);
                    temporada7.setVisibility(View.GONE);
                    temporada7lista.setVisibility(View.GONE);
                    temporada8.setVisibility(View.GONE);
                    temporada8lista.setVisibility(View.GONE);
                    temporada9.setVisibility(View.GONE);
                    temporada9lista.setVisibility(View.GONE);
                    actionBarTitle = getResources().getString(R.string.tituloSerie2);
                    break;
                case 3:
                    imgS.setImageResource(R.drawable.aqui);
                    imgSEnlarged.setImageResource(R.drawable.aqui);
                    directorS.setText(getResources().getString(R.string.directorSerie3));
                    repartoS.setText(getResources().getString(R.string.repartoSerie3));
                    clasificacionS.setText(getResources().getString(R.string.clasificacionSerie3));
                    sinopsisS.setText(getResources().getString(R.string.sinopsisSerie3));
                    temporadasTotalS.setText(R.string.temporadasTotalSerie3);
                    temporada1.setText(R.string.temporada1NumeroEpisodiosSerie3);
                    temporada1lista.setText(R.string.temporada1ListaSerie3);
                    temporada2.setText(R.string.temporada2NumeroEpisodiosSerie3);
                    temporada2lista.setText(R.string.temporada2ListaSerie3);
                    temporada3.setText(R.string.temporada3NumeroEpisodiosSerie3);
                    temporada3lista.setText(R.string.temporada3ListaSerie3);
                    temporada4.setText(R.string.temporada4NumeroEpisodiosSerie3);
                    temporada4lista.setText(R.string.temporada4ListaSerie3);
                    temporada5.setText(R.string.temporada5NumeroEpisodiosSerie3);
                    temporada5lista.setText(R.string.temporada5ListaSerie3);
                    temporada6.setVisibility(View.GONE);
                    temporada6lista.setVisibility(View.GONE);
                    temporada7.setVisibility(View.GONE);
                    temporada7lista.setVisibility(View.GONE);
                    temporada8.setVisibility(View.GONE);
                    temporada8lista.setVisibility(View.GONE);
                    temporada9.setVisibility(View.GONE);
                    temporada9lista.setVisibility(View.GONE);
                    actionBarTitle = getResources().getString(R.string.tituloSerie3);
                    break;
                case 4:
                    imgS.setImageResource(R.drawable.serrano);
                    imgSEnlarged.setImageResource(R.drawable.serrano);
                    directorS.setText(getResources().getString(R.string.directorSerie4));
                    repartoS.setText(getResources().getString(R.string.repartoSerie4));
                    clasificacionS.setText(getResources().getString(R.string.clasificacionSerie4));
                    sinopsisS.setText(getResources().getString(R.string.sinopsisSerie4));
                    temporadasTotalS.setText(R.string.temporadasTotalSerie4);
                    temporada1.setText(R.string.temporada1NumeroEpisodiosSerie4);
                    temporada1lista.setText(R.string.temporada1ListaSerie4);
                    temporada2.setText(R.string.temporada2NumeroEpisodiosSerie4);
                    temporada2lista.setText(R.string.temporada2ListaSerie4);
                    temporada3.setText(R.string.temporada3NumeroEpisodiosSerie4);
                    temporada3lista.setText(R.string.temporada3ListaSerie4);
                    temporada4.setText(R.string.temporada4NumeroEpisodiosSerie4);
                    temporada4lista.setText(R.string.temporada4ListaSerie4);
                    temporada5.setText(R.string.temporada5NumeroEpisodiosSerie4);
                    temporada5lista.setText(R.string.temporada5ListaSerie4);
                    temporada6.setText(R.string.temporada6NumeroEpisodiosSerie4);
                    temporada6lista.setText(R.string.temporada6ListaSerie4);
                    temporada7.setText(R.string.temporada7NumeroEpisodiosSerie4);
                    temporada7lista.setText(R.string.temporada7ListaSerie4);
                    temporada8.setText(R.string.temporada8NumeroEpisodiosSerie4);
                    temporada8lista.setText(R.string.temporada8ListaSerie4);
                    temporada9.setVisibility(View.GONE);
                    temporada9lista.setVisibility(View.GONE);
                    actionBarTitle = getResources().getString(R.string.tituloSerie4);
                    break;
            }
            if (actionBar != null) {
                actionBar.setTitle(actionBarTitle);
            }

            // Configuramos los eventos de clic para mostrar la imagen en grande
            imgS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imgSEnlarged.getVisibility() == View.INVISIBLE) {
                        imgSEnlarged.bringToFront();
                        imgSEnlarged.setVisibility(View.VISIBLE);
                    }

                }
            });

            // Ocultamos la imagen ampliada al hacer clic sobre ella
            imgSEnlarged.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imgSEnlarged.getVisibility() == View.VISIBLE) {
                        imgSEnlarged.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
        return root;
    }
}
