package es.studium.filmingapp.ui.peliculas;

// Se usa en otras clases para almacenar y mostrar las películas en la interfaz de usuario.
public class Pelicula {
    private final int imagen;
    private final int titulo;

    // Constructor de la clase Pelicula
    // Recibe dos parámetros: imagen (id del recurso drawable) y titulo (id del recurso string)
    public Pelicula(int imagen, int titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    // Método getter para obtener la imagen de la película
    public int getImagen() {
        return imagen;
    }

    // Método getter para obtener el título de la película
    public int getTitulo() {
        return titulo;
    }
}
