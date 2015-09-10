package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class CuadroVacio extends Cuadro {

	public CuadroVacio(Sprite sprite) {
		super(sprite);
	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x, y, this);
	}
}
