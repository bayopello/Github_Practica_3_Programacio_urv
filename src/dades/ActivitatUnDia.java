package dades;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActivitatUnDia extends Activitat {
    private LocalDate dataActivitat;
    private LocalTime horaActivitat;
    private int maxPlaces;
    private double preu;
    private String ciutat;

    public ActivitatUnDia(String nom, String[] colectius, LocalDate dataIniciInscripcio, 
                          LocalDate dataFiInscripcio, LocalDate dataActivitat, 
                          LocalTime horaActivitat, int maxPlaces, double preu, String ciutat) {
        super(nom, colectius, dataIniciInscripcio, dataFiInscripcio);
        this.dataActivitat = dataActivitat;
        this.horaActivitat = horaActivitat;
        this.maxPlaces = maxPlaces;
        this.preu = preu;
        this.ciutat = ciutat;
    }

    @Override
    public boolean esActivaEnData(LocalDate avui) {
        // Una activitat d'un dia només és activa aquell dia
        return avui.isEqual(dataActivitat);
    }

    public int getMaxPlaces() { return maxPlaces; }
    public double getPreu() { return preu; }

    @Override
    public void valida() throws BenestarException {
        super.valida(); // Crida la validació del pare
        if (preu < 0) throw new BenestarException("El preu no pot ser negatiu.");
        if (maxPlaces <= 0) throw new BenestarException("Les places han de ser > 0.");
        if (dataActivitat.isBefore(dataFiInscripcio)) throw new BenestarException("L'activitat no pot ser abans de tancar inscripcions.");
    }

    @Override
    public String toStringDetallat() {
        return "Taller/Seminari (1 dia): " + nom + "\n" +
               "Data: " + dataActivitat + " Hora: " + horaActivitat + "\n" +
               "Lloc: " + ciutat + " | Preu: " + preu + "€ | Places: " + maxPlaces;
    }

    @Override
    public String formataPerFitxer() {
        // Format: Tipus;Nom;Col1,Col2;IniciInsc;FiInsc;DataAct;Hora;Places;Preu;Ciutat
        String cols = String.join(",", colectius);
        return "UnDia;" + nom + ";" + cols + ";" + dataIniciInscripcio + ";" + 
               dataFiInscripcio + ";" + dataActivitat + ";" + horaActivitat + ";" + 
               maxPlaces + ";" + preu + ";" + ciutat;
    }
}