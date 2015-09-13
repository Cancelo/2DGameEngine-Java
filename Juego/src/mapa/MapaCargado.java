package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class
					.getResource(ruta));
			ancho = imagen.getWidth();
			alto = imagen.getHeight();

			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
			case 0x91cf30:
				cuadrosCatalogo[i] = Cuadro.HIERBA;
				continue;
			case 0xbd892e:
				cuadrosCatalogo[i] = Cuadro.TIERRA;
				continue;
			case 0x8ab82d:
				cuadrosCatalogo[i] = Cuadro.BORDE_TIERRA;
				continue;

			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
