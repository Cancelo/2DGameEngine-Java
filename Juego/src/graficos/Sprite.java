package graficos;

public final class Sprite {
	private final int lado;

	private int x;
	private int y;

	public int[] pixeles;
	private HojaSprites hoja;

	// Colección de sprites
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite HIERBA = new Sprite(32, 0, 0, HojaSprites.bosque);
	public static final Sprite TIERRA = new Sprite(32, 1, 0, HojaSprites.bosque);
	public static final Sprite BORDE_TIERRA = new Sprite(32, 2, 0,
			HojaSprites.bosque);
	public static final Sprite TIERRA_ALT = new Sprite(32, 3, 0,
			HojaSprites.bosque);
	public static final Sprite HIERBA_ESQUINA = new Sprite(32, 4, 0,
			HojaSprites.bosque);
	public static final Sprite PIEDRA_MURO = new Sprite(32, 5, 0,
			HojaSprites.bosque);
	public static final Sprite PIEDRA_MURO_UNION_HIERBA = new Sprite(32, 6, 0,
			HojaSprites.bosque);
	public static final Sprite CUEVA_ESQUINA = new Sprite(32, 7, 0,
			HojaSprites.bosque);
	public static final Sprite CUEVA_SUPERIOR = new Sprite(32, 8, 0,
			HojaSprites.bosque);
	public static final Sprite CUEVA = new Sprite(32, 9, 0, HojaSprites.bosque);
	public static final Sprite HIEBA_TIERRA_CUEVA = new Sprite(32, 0, 1,
			HojaSprites.bosque);
	public static final Sprite CUEVA_LATERAL_MEDIO = new Sprite(32, 7, 1,
			HojaSprites.bosque);
	public static final Sprite CUEVA_LATERAL_BASE = new Sprite(32, 8, 1,
			HojaSprites.bosque);
	public static final Sprite CUEVA_BASE = new Sprite(32, 9, 1,
			HojaSprites.bosque);

	// Fin de la colección

	public Sprite(final int lado, final int columna, final int fila,
			final HojaSprites hoja) {
		this.lado = lado;

		pixeles = new int[lado * lado];

		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;

		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x)
						+ (y + this.y) * hoja.obtenAncho()];
			}
		}
	}

	// Constructor para cuadro de un color, sin cargar .png
	public Sprite(final int lado, final int color) {
		this.lado = lado;
		pixeles = new int[lado * lado];

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}

	}

	public int obtenLado() {
		return lado;
	}
}
