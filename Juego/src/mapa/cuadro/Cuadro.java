package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
	public int x;
	public int y;

	public Sprite sprite;

	public static final int LADO = 32;

	// Colección de cuadros
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
	public static final Cuadro HIERBA = new Cuadro(Sprite.HIERBA);
	public static final Cuadro TIERRA = new Cuadro(Sprite.TIERRA);
	public static final Cuadro BORDE_TIERRA = new Cuadro(Sprite.BORDE_TIERRA);
	public static final Cuadro TIERRA_ALT = new Cuadro(Sprite.TIERRA_ALT);
	public static final Cuadro HIERBA_ESQUINA = new Cuadro(
			Sprite.HIERBA_ESQUINA);
	public static final Cuadro PIEDRA_MURO = new Cuadro(Sprite.PIEDRA_MURO);
	public static final Cuadro PIEDRA_MURO_UNION_HIERBA = new Cuadro(
			Sprite.PIEDRA_MURO_UNION_HIERBA);
	public static final Cuadro CUEVA_ESQUINA = new Cuadro(Sprite.CUEVA_ESQUINA);
	public static final Cuadro CUEVA_SUPERIOR = new Cuadro(
			Sprite.CUEVA_SUPERIOR);
	public static final Cuadro CUEVA = new Cuadro(Sprite.CUEVA);
	public static final Cuadro HIERBA_TIERRA_ESQUINA = new Cuadro(
			Sprite.HIERBA_TIERRA_ESQUINA);
	public static final Cuadro CUEVA_LATERAL_MEDIO = new Cuadro(
			Sprite.CUEVA_LATERAL_MEDIO);
	public static final Cuadro CUEVA_LATERAL_BASE = new Cuadro(
			Sprite.CUEVA_LATERAL_BASE);
	public static final Cuadro CUEVA_BASE = new Cuadro(Sprite.CUEVA_BASE);

	// Fin de la colección

	public Cuadro(Sprite sprite) {
		this.sprite = sprite;
	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}

	public boolean solido() {
		return false;
	}
}
