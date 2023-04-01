package geometria;

public class Auxiliar {
	public static boolean estaArriba(Coordenada a, Coordenada b) {
		return a.getAltitud() > b.getAltitud();
	}

	public static boolean estaAbajo(Coordenada a, Coordenada b) {
		return a.getAltitud() < b.getAltitud();
	}

	public static boolean estaIzquierda(Coordenada a, Coordenada b) {
		return a.getLatitud() < b.getLatitud();
	}

	public static boolean estaDerecha(Coordenada a, Coordenada b) {
		return a.getLatitud() > b.getLatitud();
	}
	
	public static boolean estaArribaI(Coordenada a, Coordenada b) {
		return a.getAltitud() >= b.getAltitud();
	}

	public static boolean estaAbajoI(Coordenada a, Coordenada b) {
		return a.getAltitud() <= b.getAltitud();
	}

	public static boolean estaIzquierdaI(Coordenada a, Coordenada b) {
		return a.getLatitud() <= b.getLatitud();
	}

	public static boolean estaDerechaI(Coordenada a, Coordenada b) {
		return a.getLatitud() >= b.getLatitud();
	}
}
