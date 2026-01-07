package dades;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Activitat periòdica del programa Benestar URV
 */
public class ActivitatPeriodica extends Activitat {

    private DayOfWeek diaSetmana;
    private LocalTime hora;
    private int nombreSetmanes;
    private String centre;
    private String ciutat;

    public ActivitatPeriodica(String nom, LocalDate dataInici, int nombreSetmanes,
                              DayOfWeek diaSetmana, LocalTime hora,
                              int placesMaximes, double preu,
                              String centre, String ciutat) {

        this.nom = nom;
        this.dataInici = dataInici;
        this.nombreSetmanes = nombreSetmanes;
        this.diaSetmana = diaSetmana;
        this.hora = hora;
        this.placesMaximes = placesMaximes;
        this.preu = preu;
        this.centre = centre;
        this.ciutat = ciutat;

        this.dataFi = dataInici.plusWeeks(nombreSetmanes);
    }

    public DayOfWeek getDiaSetmana() {
        return diaSetmana;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getNombreSetmanes() {
        return nombreSetmanes;
    }

    public String getCentre() {
        return centre;
    }

    public String getCiutat() {
        return ciutat;
    }

    @Override
    public String toString() {
        return "Activitat Periòdica: " + nom +
               " (" + diaSetmana + " a les " + hora + ")";
    }
}
