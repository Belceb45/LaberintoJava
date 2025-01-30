package LaberintoJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Interfaz {

    protected int anchoVentana;
    protected int altoVentana;

    public void SizeVentana(int ancho, int alto) {
        this.altoVentana = alto;
        this.anchoVentana = ancho;
    }

    // Método para crear botones dinámicamente
    private JButton agregarBotones(String etiqueta, ActionListener evento) {
        JButton boton = new JButton(etiqueta);
        boton.setBackground(Color.white);
        boton.addActionListener(evento);
        return boton;
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("LABERINTOS");
        Interfaz a = new Interfaz();
        a.SizeVentana(800, 800);
        ventana.setSize(a.anchoVentana, a.altoVentana);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Panel superior con botones
        JPanel panelA = new JPanel();
        panelA.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Centrado
        panelA.setPreferredSize(new Dimension(ventana.getWidth(), 50));
        panelA.setBackground(Color.LIGHT_GRAY);

        // Crear botones con el método agregarBotones
        Interfaz interfaz = new Interfaz();
        JButton botonFijar = interfaz.agregarBotones("Fijar Laberinto", e -> System.out.println("Laberinto Fijado"));
        JButton botonInicio = interfaz.agregarBotones("Inicio", e -> System.out.println("Marcando Inicio..."));
        JButton botonFinal = interfaz.agregarBotones("Fin", e -> System.out.println("Marcando Final..."));

        // Agregar botones al panel
        panelA.add(botonFijar);
        panelA.add(botonInicio);
        panelA.add(botonFinal);

        // Panel para mostrar el laberinto
        JPanel panelB = new JPanel();
        panelB.setBackground(Color.WHITE);

        // Agregar paneles a la ventana
        ventana.add(panelA, BorderLayout.NORTH);
        ventana.add(panelB, BorderLayout.CENTER);

        // Mostrar ventana
        ventana.setVisible(true);
    }
}
