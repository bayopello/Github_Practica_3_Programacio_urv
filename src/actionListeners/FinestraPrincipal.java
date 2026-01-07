package actionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraPrincipal extends JFrame {

    private JComboBox<String> selectorMesos;
    private JPanel panellCalendari;

    public FinestraPrincipal() {
        // Configuració bàsica de la finestra
        setTitle("Programa Benestar URV");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicialitzarComponents();
        
        setVisible(true);
    }

    private void inicialitzarComponents() {
        // 1. Panell Superior (Selector)
        JPanel panellSuperior = new JPanel();
        panellSuperior.add(new JLabel("Selecciona el mes a visualitzar: "));

        String[] mesos = {
            "Setembre 2025", "Octubre 2025", "Novembre 2025", "Desembre 2025"
        };
        selectorMesos = new JComboBox<>(mesos);
        
        // Acció quan canviem de mes
        selectorMesos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzarCalendari((String) selectorMesos.getSelectedItem());
            }
        });

        panellSuperior.add(selectorMesos);
        
        // Afegim panell superior al Nord
        add(panellSuperior, BorderLayout.NORTH);

        // 2. Panell Central (Calendari)
        panellCalendari = new JPanel();
        panellCalendari.setBackground(Color.WHITE);
        panellCalendari.add(new JLabel("Aquí es dibuixarà el calendari del mes seleccionat..."));
        
        add(panellCalendari, BorderLayout.CENTER);
    }

    private void actualitzarCalendari(String mesSeleccionat) {
        // Aquí aniria la lògica per pintar els dies i les activitats
        // Com que és un esquelet, només actualitzem un text o netegem el panell
        panellCalendari.removeAll();
        panellCalendari.add(new JLabel("Visualitzant activitats de: " + mesSeleccionat));
        panellCalendari.revalidate();
        panellCalendari.repaint();
    }

    // Main per provar la finestra independentment
    public static void main(String[] args) {
        // Executar en el fil d'esdeveniments de Swing
        SwingUtilities.invokeLater(() -> new FinestraPrincipal());
    }
}