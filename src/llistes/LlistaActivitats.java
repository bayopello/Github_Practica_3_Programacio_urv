package llistes;

public class LlistaActivitats {
    private Activitat[] llista;
    private int nElem;

    public LlistaActivitats(int midaInicial) {
        llista = new Activitat[midaInicial];
        nElem = 0;
    }

    public void afegirActivitat(Activitat a) {
        if (nElem >= llista.length) {
            resize();
        }
        llista[nElem] = a;
        nElem++;
    }

    private void resize() {
        // Doblem la capacitat
        Activitat[] novaLlista = new Activitat[llista.length * 2];
        for (int i = 0; i < nElem; i++) {
            novaLlista[i] = llista[i];
        }
        llista = novaLlista;
    }

    public Activitat getActivitat(int index) {
        if (index >= 0 && index < nElem) {
            return llista[index];
        }
        return null;
    }
    
    // Buscar per nom
    public Activitat getActivitatPerNom(String nom) {
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getNom().equalsIgnoreCase(nom)) {
                return llista[i];
            }
        }
        return null;
    }

    public int getNumElements() {
        return nElem;
    }
    
    public Activitat[] getArray() {
        // Retornem una còpia neta sense els nulls del final
        Activitat[] resultat = new Activitat[nElem];
        for (int i = 0; i < nElem; i++) {
            resultat[i] = llista[i];
        }
        return resultat;
    }
}
