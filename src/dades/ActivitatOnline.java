package dades;

import java.time.LocalDate;

/**
 * Activitat online del programa Benestar URV
 */
public class ActivitatOnline extends Activitat {

    private int diesVisualitzacio;
    private String enllac;

    public ActivitatOnline(String nom, LocalDate dataInici,
                           int diesVisualitzacio, String enllac) {

        this.nom = nom;
        this.dataInici = dataInici;
        this.diesVisualitzacio = diesVisualitzacio;
        this.enllac = enllac;

        this.placesMaximes = Integer.MAX_VALUE;
        this.preu = 0.0;
        this.dataFi = dataInici.plusDays(diesVisualitzacio);
    }

    public int getDiesVisualitzacio() {
        return diesVisualitzacio;
    }

    public String getEnllac() {
        return enllac;
    }

    @Override
    public String toString() {
        return "Activitat Online: " + nom + " (" + enllac + ")";
    }
}
