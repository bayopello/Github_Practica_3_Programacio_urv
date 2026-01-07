package tests;

import dades.ActivitatPeriodica;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestActivitatPeriodica {

    public static void main(String[] args) {

        ActivitatPeriodica ap = new ActivitatPeriodica(
                "Ioga Setmanal",
                LocalDate.of(2025, 9, 15),
                10,
                DayOfWeek.MONDAY,
                LocalTime.of(18, 0),
                20,
                30.0,
                "Centre Esportiu",
                "Tarragona"
        );

        System.out.println(ap);
        System.out.println("Centre: " + ap.getCentre());
        System.out.println("Ciutat: " + ap.getCiutat());
        System.out.println("Setmanes: " + ap.getNombreSetmanes());
    }
}
