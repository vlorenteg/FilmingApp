package es.studium.filmingapp.ui.series;

// Se usa en otras clases para almacenar y mostrar las series en la interfaz de usuario.
public class Serie {
    private final int imagen;
    private final int titulo;

    // Constructor de la clase Serie
    // Recibe dos parámetros: imagen (id del recurso drawable) y titulo (id del recurso string)
    public Serie(int imagen, int titulo) {
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public int getTitulo() {
        return titulo;
    }
}
