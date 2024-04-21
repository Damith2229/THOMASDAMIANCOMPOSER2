package co.edu.ucatolica.controlador;

import co.edu.ucatolica.modelo.Modelo;
import co.edu.ucatolica.vista.Vista;

public class Controlador {
    private Vista vista;
    private Modelo modelo;

    public Controlador() {
        this.vista = new Vista();
        this.modelo = new Modelo();
    }

    public void iniciarPrograma() {
        while (true) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    crearYGuardarCancion();
                    break;
                case 2:
                    mostrarCancionGuardada();
                    break;
                case 3:
                    return; // Salir del programa
                default:
                    vista.mostrarMensaje("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void crearYGuardarCancion() {
        int[] parametros = vista.obtenerParametros();
        int numEstrofas = parametros[0];
        int numFrasesPorEstrofa = parametros[1];
        String cancion = modelo.componerCancion(numEstrofas, numFrasesPorEstrofa);
        String rutaArchivo = vista.elegirRutaArchivo();
        if (rutaArchivo != null) {
            vista.guardarCancionEnArchivo(cancion, rutaArchivo);
        }
    }

    private void mostrarCancionGuardada() {
        String rutaArchivo = vista.elegirArchivo();
        if (rutaArchivo != null) {
            String cancion = vista.leerCancionDesdeArchivo(rutaArchivo);
            if (cancion != null) {
                vista.mostrarCancion(cancion);
            } else {
                vista.mostrarMensaje("Error al leer la canción desde el archivo.");
            }
        }
    }
}





