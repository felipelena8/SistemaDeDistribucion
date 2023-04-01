package models;

import geometria.Auxiliar;
import geometria.Coordenada;
import geometria.Recta;

public class Zona {
	Coordenada izqArriba, derArriba, izqAbajo, derAbajo;

	public Coordenada getIzqArriba() {
		return izqArriba;
	}

	public Coordenada getDerArriba() {
		return derArriba;
	}

	public Coordenada getIzqAbajo() {
		return izqAbajo;
	}

	public Coordenada getDerAbajo() {
		return derAbajo;
	}

	private Zona(BuilderZona zona) {
		this.izqArriba = zona.izqArriba;
		this.derArriba = zona.derArriba;
		this.izqAbajo = zona.izqAbajo;
		this.derAbajo = zona.derAbajo;
	}

	@Override
	public String toString() {
		return izqArriba + ", " + derArriba + ", " + izqAbajo + ", " + derAbajo;
	}

	public boolean abarcaDireccion(Coordenada direccion) {
		double x = direccion.getLatitud();
		double y = direccion.getAltitud();
		Recta recta1 = new Recta(izqArriba, derArriba);
		Recta recta2 = new Recta(derArriba, derAbajo);
		Recta recta3 = new Recta(derAbajo, izqAbajo);
		Recta recta4 = new Recta(izqArriba, izqAbajo);
		return Auxiliar.estaAbajoI(direccion, recta1.obtenerPuntoEnX(x)) && Auxiliar.estaIzquierdaI(direccion, recta2.obtenerPuntoEnY(y)) && Auxiliar.estaArribaI(direccion, recta3.obtenerPuntoEnX(x)) && Auxiliar.estaDerechaI(direccion, recta4.obtenerPuntoEnY(y));
	}

	public static class BuilderZona {
		Coordenada izqArriba, derArriba, izqAbajo, derAbajo;

		public BuilderZona setIzqArriba(double latitud, double altitud) {
			this.izqArriba = new Coordenada(latitud, altitud);
			return this;
		}

		public BuilderZona setIzqAbajo(double latitud, double altitud) {
			this.izqAbajo = new Coordenada(latitud, altitud);
			return this;
		}

		public BuilderZona setDerArriba(double latitud, double altitud) {
			this.derArriba = new Coordenada(latitud, altitud);
			return this;
		}

		public BuilderZona setDerAbajo(double latitud, double altitud) {
			this.derAbajo = new Coordenada(latitud, altitud);
			return this;
		}

		public Zona build() {
			if (Auxiliar.estaArriba(derArriba, derAbajo) && Auxiliar.estaArriba(izqArriba, izqAbajo)
					&& Auxiliar.estaIzquierda(izqAbajo, derAbajo)) {
				return new Zona(this);
			}
			return null;
		}
	}

}
