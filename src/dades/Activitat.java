package dades;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Activitat {

    protected String nom;
    protected String[] colectius; // PDI, PTGAS, Estudiants
    protected LocalDate dataIniciInscripcio;
    protected LocalDate dataFiInscripcio;

    public Activitat(String nom, String[] colectius, LocalDate dataIniciInscripcio, LocalDate dataFiInscripcio) {
        this.nom = nom;
        this.colectius = colectius;
        this.dataIniciInscripcio = dataIniciInscripcio;
        this.dataFiInscripcio = dataFiInscripcio;
    }

    // Getters i Setters (els que ja tenies estan bé)
    public String getNom() { return nom; }
    public String[] getColectius() { return colectius; }
    public LocalDate getDataIniciInscripcio() { return dataIniciInscripcio; }
    public LocalDate getDataFiInscripcio() { return dataFiInscripcio; }

    // Mètodes abstractes
    public abstract boolean esActivaEnData(LocalDate avui);
    public abstract String toStringDetallat();
    
    // Nou mètode per retornar l'string en format CSV per guardar al fitxer
    public abstract String formataPerFitxer(); 

    // Mètode comú
    public boolean esEnPeriodeInscripcio(LocalDate avui) {
        return (avui.isEqual(dataIniciInscripcio) || avui.isAfter(dataIniciInscripcio))
                && (avui.isEqual(dataFiInscripcio) || avui.isBefore(dataFiInscripcio));
    }

    // Validació genèrica
    public void valida() throws BenestarException {
        if (nom == null || nom.isEmpty()) throw new BenestarException("El nom no pot ser buit.");
        if (dataFiInscripcio.isBefore(dataIniciInscripcio)) {
            throw new BenestarException("La data fi d'inscripció no pot ser anterior a l'inici.");
        }
    }
    
    @Override
    public String toString() {
        return "Activitat: " + nom + " (" + Arrays.toString(colectius) + ")";
    }
}

