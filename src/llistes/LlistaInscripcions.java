package dades;

import java.io.Serializable;

/**
 * Llista d'inscripcions
 */
public class LlistaInscripcions implements Serializable {

    private static class Node implements Serializable {
        Inscripcio inscripcio;
        Node seguent;

        Node(Inscripcio i) {
            inscripcio = i;
            seguent = null;
        }
    }

    private Node primer;

    public LlistaInscripcions() {
        primer = null;
    }

    /**
     * Afegeix una inscripció a la llista
     */
    public void afegir(Inscripcio i) {
        Node nou = new Node(i);
        nou.seguent = primer;
        primer = nou;
    }

    /**
     * Elimina una inscripció
     */
    public boolean eliminar(Inscripcio i) {
        Node actual = primer;
        Node anterior = null;

        while (actual != null) {
            if (actual.inscripcio.equals(i)) {
                if (anterior == null) {
                    primer = actual.seguent;
                } else {
                    anterior.seguent = actual.seguent;
                }
                return true;
            }
            anterior = actual;
            actual = actual.seguent;
        }
        return false;
    }

    /**
     * Retorna el nombre d'inscripcions
     */
    public int mida() {
        int count = 0;
        Node actual = primer;
        while (actual != null) {
            count++;
            actual = actual.seguent;
        }
        return count;
    }
}
