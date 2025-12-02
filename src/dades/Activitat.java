package dades;

//Libreria per a utilitzar dates. Suposo que és necessària per al calendari.
import java.time.LocalDate;
import java.util.Arrays;

//*Classe base per al programa que representa una activitat del "programa Benestar URV".
public abstract  class Activitat {

    // Atributs comuns a totes les activitats en protected, te les mateixes caràcteristiques que un public però no es global.
    //TODO: DIGUEM SI AIXÒ ESTÀ BÉ O CAL CANVIAR-HO:
    protected String nom;                          // Nom únic de l'activitat?
    protected String[] colectius;                  // PDI, PTGAS, Estudiants?
    protected LocalDate dataIniciInscripcio;       // Inici del període d'inscripció? suposo que es necessari per al calendari.
    protected LocalDate dataFiInscripcio;          // Final del període d'inscripció

    // Constructor
    public Activitat(String nom, String[] colectius, LocalDate dataIniciInscripcio, LocalDate dataFiInscripcio) {
        this.nom = nom;
        this.colectius = colectius;
        this.dataIniciInscripcio = dataIniciInscripcio;
        this.dataFiInscripcio = dataFiInscripcio;
    }

    // Getters 
    public String getNom() {
        return nom;
    }

    public String[] getColectius() {
        return colectius;
    }

    public LocalDate getDataIniciInscripcio() {
        return dataIniciInscripcio;
    }

    public LocalDate getDataFiInscripcio() {
        return dataFiInscripcio;
    }

    // Setters 
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setColectius(String[] colectius) {
        this.colectius = colectius;
    }

    public void setDataIniciInscripcio(LocalDate dataIniciInscripcio) {
        this.dataIniciInscripcio = dataIniciInscripcio;
    }

    public void setDataFiInscripcio(LocalDate dataFiInscripcio) {
        this.dataFiInscripcio = dataFiInscripcio;
    }

    //  Mètodes comuns 

    /** Retorna si avui estem dins del període d’inscripció. */
    public boolean esEnPeriodeInscripcio(LocalDate avui) {
        return (avui.isEqual(dataIniciInscripcio) || avui.isAfter(dataIniciInscripcio))
                && (avui.isEqual(dataFiInscripcio) || avui.isBefore(dataFiInscripcio));
    }

    /** Cada subclasse implementarà quan és activa segons les seves dades. */
    public abstract boolean esActivaEnData(LocalDate avui);

    /** Retorna informació detallada que dependrà de la subclasse. */
    public abstract String toStringDetallat();

    @Override
    public String toString() {
        return "Activitat: " + nom +
                " | Col·lectius: " + Arrays.toString(colectius) +
                " | Inscripció: " + dataIniciInscripcio + " - " + dataFiInscripcio;
    }
}
//QUALSEVOL COSA QUE FALTI O CALGUI CANVIAR? AVISEUME

