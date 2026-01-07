package dades;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class GestorFitxers {

    public static void guardarActivitats(LlistaActivitats llista, String ruta) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
        for (int i = 0; i < llista.getNumElements(); i++) {
            writer.write(llista.getActivitat(i).formataPerFitxer());
            writer.newLine();
        }
        writer.close();
    }

    public static LlistaActivitats carregarActivitats(String ruta) throws IOException {
        LlistaActivitats llista = new LlistaActivitats(20);
        File f = new File(ruta);
        if (!f.exists()) return llista;

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String linia;
        while ((linia = reader.readLine()) != null) {
            String[] dades = linia.split(";");
            String tipus = dades[0];
            
            // Dades comunes
            String nom = dades[1];
            String[] colectius = dades[2].split(",");
            LocalDate iniciIns = LocalDate.parse(dades[3]);
            LocalDate fiIns = LocalDate.parse(dades[4]);

            Activitat activitat = null;

            if (tipus.equals("UnDia")) {
                LocalDate dataAct = LocalDate.parse(dades[5]);
                LocalTime horaAct = LocalTime.parse(dades[6]);
                int places = Integer.parseInt(dades[7]);
                double preu = Double.parseDouble(dades[8]);
                String ciutat = dades[9];
                
                activitat = new ActivitatUnDia(nom, colectius, iniciIns, fiIns, dataAct, horaAct, places, preu, ciutat);
            }
            // Aquí afegiries els else if per a "Periodic" i "Online"

            if (activitat != null) {
                llista.afegirActivitat(activitat);
            }
        }
        reader.close();
        return llista;
    }
}