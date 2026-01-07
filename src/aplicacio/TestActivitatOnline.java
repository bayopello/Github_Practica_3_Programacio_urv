package tests;

import dades.ActivitatOnline;
import java.time.LocalDate;

public class TestActivitatOnline {

    public static void main(String[] args) {

        ActivitatOnline ao = new ActivitatOnline(
                "Mindfulness Online",
                LocalDate.of(2025, 10, 1),
                30,
                "https://urv.cat/mindfulness"
        );

        System.out.println(ao);
        System.out.println("Dies visualització: " + ao.getDiesVisualitzacio());
        System.out.println("Enllaç: " + ao.getEnllac());
    }
}
