package co.edu.ucatolica.vista;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    private JFileChooser fileChooser;

    public Vista() {
        setScanner(new Scanner(System.in));
        fileChooser = new JFileChooser();
    }

    public int mostrarMenu() {
        String[] opciones = {"Crear y guardar canción", "Seleccionar y mostrar canción", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        return seleccion + 1; // Ajustar al índice base 1
    }

    public int[] obtenerParametros() {
        int[] parametros = new int[2];
        String numEstrofasString = JOptionPane.showInputDialog(null, "Ingrese el número de estrofas:");
        String numFrasesString = JOptionPane.showInputDialog(null, "Ingrese el número de frases por estrofa:");
        parametros[0] = Integer.parseInt(numEstrofasString);
        parametros[1] = Integer.parseInt(numFrasesString);
        return parametros;
    }

    public String elegirRutaArchivo() {
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            return archivoSeleccionado.getAbsolutePath();
        }
        return null;
    }

    public void guardarCancionEnArchivo(String cancion, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write(cancion);
            mostrarMensaje("Canción guardada exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            mostrarMensaje("Error al guardar la canción en el archivo.");
            e.printStackTrace();
        }
    }

    public String elegirArchivo() {
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            return archivoSeleccionado.getAbsolutePath();
        }
        return null;
    }

    public String leerCancionDesdeArchivo(String rutaArchivo) {
        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarCancion(String cancion) {
        JOptionPane.showMessageDialog(null, cancion);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}

















