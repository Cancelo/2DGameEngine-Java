package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Teclado;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static volatile boolean enFuncionamiento = false;

	private static final String NOMBRE = "Juego";

	private static int aps = 0;
	private static int fps = 0;

	private static JFrame ventana;// Thread1
	private static Thread thread; // Thread2
	private static Teclado teclado;

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		teclado = new Teclado();
		addKeyListener(teclado);

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout()); // -------
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public static void main(String[] args) { // Thread1
		Juego juego = new Juego();
		juego.iniciar();

	}

	private synchronized void iniciar() {
		enFuncionamiento = true;

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actualizar() {
		teclado.actualizar();

		if (teclado.arriba) {
			System.out.println("arriba");
		}
		if (teclado.abajo) {
			System.out.println("abajo");
		}
		if (teclado.izquierda) {
			System.out.println("izquierda");
		}
		if (teclado.derecha) {
			System.out.println("derecha");
		}

		aps++;
	}

	private void mostrar() {
		fps++;
	}

	public void run() { // Thread2
		final int NS_POR_SEGUNDO = 1000000000; // nanosegundos en un segundo
		final byte APS_OBJETIVO = 60; // actualizaciones por segundo = 60
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0; // cantidad de tiempo transcurrido hasta actualizacion

		requestFocus(); // Focus activo en ventana

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime(); // referencia tiempo

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}

			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}
