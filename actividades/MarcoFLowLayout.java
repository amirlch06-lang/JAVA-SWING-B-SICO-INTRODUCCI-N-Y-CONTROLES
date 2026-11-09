package actividades;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFLowLayout extends JFrame {
    private final JButton botonJButtonIzquierda; 
    private final JButton botonJButtonCentro; 
    private final JButton botonJButtonDerecha; 
    private final FlowLayout esquema; 
    private final Container contenedor; 

    public MarcoFLowLayout() {
        super("FlowLayout - Integrantes: amir lanegra, andre aveldaño");
        
        esquema = new FlowLayout();
        contenedor = getContentPane(); 
        setLayout(esquema);

        botonJButtonIzquierda = new JButton("amir");
        add(botonJButtonIzquierda); 
        botonJButtonIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                esquema.setAlignment(FlowLayout.LEFT);
                esquema.layoutContainer(contenedor);
            }
        });

        botonJButtonCentro = new JButton("Centro");
        add(botonJButtonCentro); 
        botonJButtonCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                esquema.setAlignment(FlowLayout.CENTER);
                esquema.layoutContainer(contenedor);
            }
        });

        botonJButtonDerecha = new JButton("andre");
        add(botonJButtonDerecha);
        botonJButtonDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                esquema.setAlignment(FlowLayout.RIGHT);
                esquema.layoutContainer(contenedor);
            }
        });
    }

    public static void main(String[] args) {
        MarcoFLowLayout marcoFlowLayout = new MarcoFLowLayout();
        marcoFlowLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoFlowLayout.setSize(400, 75);
        marcoFlowLayout.setVisible(true);
    }
}
