package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;

	public boolean salir;

	public void actualizar() { // Detecta si se han pulsado las teclas
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		salir = teclas[KeyEvent.VK_ESCAPE];
	}

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}

}
