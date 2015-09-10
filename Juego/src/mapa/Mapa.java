package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;

	protected int[] cuadros; // Tiles

	public Mapa(int ancho, int alto) { // Constructor - Mapa aleatorio
		this.ancho = ancho;
		this.alto = alto;

		cuadros = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) { // Constructor - Mapa desde ruta
		cargarMapa(ruta);
	}

	protected void generarMapa() {
	}

	private void cargarMapa(String ruta) {
	}

	public void actualizar() {
	}

	// "Traduce" de tama�o Tile(Cuadro) a tama�o pixel
	public void mostrar(final int compensacionX, final int compensacionY,
			final Pantalla pantalla) {

		pantalla.estableceDiferencia(compensacionX, compensacionY);

		int o = compensacionX >> 5; // Bit Shifting = /32
		int e = (compensacionX + pantalla.obtenAncho() + Cuadro.LADO) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.obtenAlto() + Cuadro.LADO) >> 5;

		for (int y = n; y < s; y++) {
			for (int x = 0; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla);
			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Cuadro.VACIO;
		}
		switch (cuadros[x + y * ancho]) {
		case 0:
			return Cuadro.ASFALTO;
			// case 1:
			// case 2:
			// case 3:

		default:
			return Cuadro.VACIO;
		}
	}
}
