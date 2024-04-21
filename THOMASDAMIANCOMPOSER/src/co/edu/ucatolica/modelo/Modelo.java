package co.edu.ucatolica.modelo;

import java.util.Random;

public class Modelo {
    private static final String[] FRASES_PRIMERA = {"mami", "bebe", "princess", "mami"};
    private static final String[] FRASES_SEGUNDA = {"yo puedo", "yo quielo", "yo vengo a", "voy a"};
    private static final String[] FRASES_TERCERA = {"encendelte", "amalte", "ligal", "jugal"};
    private static final String[] FRASES_CUARTA = {"suave", "lento", "rápido", "fuelte"};
    private static final String[] FRASES_QUINTA = {"hasta que salga el sol toda la noche", "hasta el amanecel", "todo el día"};
    private static final String[] FRASES_SEXTA = {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"};

    public String componerCancion(int numEstrofas, int numFrasesPorEstrofa) {
        StringBuilder cancion = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < numEstrofas; i++) {
            for (int j = 0; j < numFrasesPorEstrofa; j++) {
                cancion.append(FRASES_PRIMERA[random.nextInt(FRASES_PRIMERA.length)]).append(" ");
                cancion.append(FRASES_SEGUNDA[random.nextInt(FRASES_SEGUNDA.length)]).append(" ");
                cancion.append(FRASES_TERCERA[random.nextInt(FRASES_TERCERA.length)]).append(" ");
                cancion.append(FRASES_CUARTA[random.nextInt(FRASES_CUARTA.length)]).append(" ");
                cancion.append(FRASES_QUINTA[random.nextInt(FRASES_QUINTA.length)]).append(" ");
                cancion.append(FRASES_SEXTA[random.nextInt(FRASES_SEXTA.length)]).append("\n");
            }
            cancion.append("\n");
        }

        return cancion.toString();
    }
}
