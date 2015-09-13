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
			case 0xff91cf30:
				cuadrosCatalogo[i] = Cuadro.HIERBA;
				continue;
			case 0xffbd892e:
				cuadrosCatalogo[i] = Cuadro.TIERRA;
				continue;
			case 0xff8ab82d:
				cuadrosCatalogo[i] = Cuadro.BORDE_TIERRA;
				continue;
			case 0xff3c5607:
				cuadrosCatalogo[i] = Cuadro.TIERRA_ALT;
				continue;
			case 0xff855f1d:
				cuadrosCatalogo[i] = Cuadro.HIERBA_ESQUINA;
				continue;
			case 0xffa3a69e:
				cuadrosCatalogo[i] = Cuadro.PIEDRA_MURO;
				continue;
			case 0xff8ca561:
				cuadrosCatalogo[i] = Cuadro.PIEDRA_MURO_UNION_HIERBA;
				continue;
			case 0xff948b7f:
				cuadrosCatalogo[i] = Cuadro.CUEVA_ESQUINA;
				continue;
			case 0xff6c5f49:
				cuadrosCatalogo[i] = Cuadro.CUEVA_SUPERIOR;
				continue;
			case 0xff836d46:
				cuadrosCatalogo[i] = Cuadro.CUEVA;
				continue;
			case 0xff2e4717:
				cuadrosCatalogo[i] = Cuadro.HIERBA_TIERRA_ESQUINA;
				continue;
			case 0xff4e432f:
				cuadrosCatalogo[i] = Cuadro.CUEVA_LATERAL_MEDIO;
				continue;
			case 0xff6c501e:
				cuadrosCatalogo[i] = Cuadro.CUEVA_LATERAL_BASE;
				continue;
			case 0xff513f20:
				cuadrosCatalogo[i] = Cuadro.CUEVA_BASE;
				continue;

			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
			}
		}
	}
}
