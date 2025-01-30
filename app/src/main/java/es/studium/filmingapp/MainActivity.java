package es.studium.filmingapp;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import es.studium.filmingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Se infla el layout de la actividad utilizando ViewBinding, y se configura la vista de contenido
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Establece la barra de acción en la actividad usando el toolbar del layout
        setSupportActionBar(binding.appBarMain.toolbar);

        // Obtiene las referencias a los elementos del layout: el DrawerLayout y el NavigationView
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configura el AppBarConfiguration, especificando los destinos de navegación principales
        // y vinculando el DrawerLayout para abrir y cerrar el menú lateral
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_peliculas, R.id.nav_series)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // Este método maneja la navegación hacia atrás cuando el usuario presiona el ícono de flecha en la barra de acción
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
