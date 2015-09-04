package mapa;

import graficos.Pantalla;

public abstract class Mapa {
	private int ancho;
	private int alto;

	private int[] cuadros; // Tiles

	public Mapa(int ancho, int alto) { // Constructor - Mapa aleatorio
		this.ancho = ancho;
		this.alto = alto;

		cuadros = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) { // Constructor - Mapa desde ruta
		cargarMapa(ruta);
	}

	private void generarMapa() {
	}

	private void cargarMapa(String ruta) {
	}

	public void actualizar() {
	}

	public void mostrar(int compensacionX, int compensacioY, Pantalla pantalla) {
	}
}
