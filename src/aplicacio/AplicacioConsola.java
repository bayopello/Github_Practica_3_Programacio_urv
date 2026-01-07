package aplicacio;

import dades.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AplicacioConsola {
    
    private static LlistaActivitats lesMevesActivitats;
    private static LocalDate dataAvui;
    private static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 0. Càrrega inicial
            lesMevesActivitats = GestorFitxers.carregarActivitats("activitats.txt");
            dataAvui = LocalDate.now(); // Per defecte
            
            int opcio;
            do {
                mostrarMenu();
                opcio = Integer.parseInt(teclat.nextLine());
                tractarOpcio(opcio);
            } while (opcio != 22);
            
            // Guardar al sortir
            System.out.println("Vols guardar canvis? (S/N)");
            if (teclat.nextLine().equalsIgnoreCase("S")) {
                GestorFitxers.guardarActivitats(lesMevesActivitats, "activitats.txt");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PROGRAMA BENESTAR ---");
        System.out.println("Data actual del sistema: " + dataAvui);
        System.out.println("1. Canviar data del sistema");
        System.out.println("3. Mostrar activitats en període d'inscripció");
        System.out.println("7. Veure detall d'una activitat");
        System.out.println("11. Mostrar usuaris apuntats a una activitat");
        System.out.println("13. Afegir nova activitat d'Un Dia");
        System.out.println("22. Sortir");
        System.out.print("Escull opció: ");
    }

    private static void tractarOpcio(int opcio) {
        switch (opcio) {
            case 1: // Canviar data
                System.out.print("Introdueix data (AAAA-MM-DD): ");
                dataAvui = LocalDate.parse(teclat.nextLine());
                break;

            case 3: // Activitats en inscripció
                System.out.println("Activitats obertes a data " + dataAvui + ":");
                for (int i = 0; i < lesMevesActivitats.getNumElements(); i++) {
                    Activitat a = lesMevesActivitats.getActivitat(i);
                    if (a.esEnPeriodeInscripcio(dataAvui)) {
                        // Aquí caldria comprovar places disponibles també si tinguéssim la llista d'inscripcions
                        System.out.println("- " + a.getNom()); 
                    }
                }
                break;

            case 7: // Detall activitat
                System.out.print("Nom de l'activitat: ");
                String nomBuscat = teclat.nextLine();
                Activitat a = lesMevesActivitats.getActivitatPerNom(nomBuscat);
                if (a != null) {
                    System.out.println(a.toStringDetallat());
                } else {
                    System.out.println("Activitat no trobada.");
                }
                break;

            case 11: // Usuaris apuntats
                System.out.println("Opció 11: Per implementar aquesta opció cal la classe LlistaInscripcions i Usuari.");
                System.out.println("Lògica: Buscar activitat -> Buscar a LlistaInscripcions filtrant per l'activitat -> Mostrar alies.");
                break;

            case 13: // Afegir activitat un dia
                try {
                    afegirActivitatUnDia();
                } catch (BenestarException e) {
                    System.out.println("Error creant activitat: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error de format: " + e.getMessage());
                }
                break;
                
            case 22:
                System.out.println("Adéu!");
                break;
                
            default:
                System.out.println("Opció no implementada en aquest exemple.");
        }
    }

    private static void afegirActivitatUnDia() throws BenestarException {
        System.out.print("Nom: "); String nom = teclat.nextLine();
        System.out.print("Col·lectius (separats per coma, ex: PDI,Estudiants): "); 
        String[] cols = teclat.nextLine().split(",");
        System.out.print("Data Inici Inscripció (AAAA-MM-DD): "); LocalDate ini = LocalDate.parse(teclat.nextLine());
        System.out.print("Data Fi Inscripció (AAAA-MM-DD): "); LocalDate fi = LocalDate.parse(teclat.nextLine());
        
        System.out.print("Data Activitat (AAAA-MM-DD): "); LocalDate dataAct = LocalDate.parse(teclat.nextLine());
        System.out.print("Hora Activitat (HH:MM): "); LocalTime hora = LocalTime.parse(teclat.nextLine());
        System.out.print("Places màximes: "); int places = Integer.parseInt(teclat.nextLine());
        System.out.print("Preu: "); double preu = Double.parseDouble(teclat.nextLine());
        System.out.print("Ciutat: "); String ciutat = teclat.nextLine();

        ActivitatUnDia nova = new ActivitatUnDia(nom, cols, ini, fi, dataAct, hora, places, preu, ciutat);
        nova.valida(); // Validem abans d'afegir
        lesMevesActivitats.afegirActivitat(nova);
        System.out.println("Activitat afegida correctament.");
    }
}