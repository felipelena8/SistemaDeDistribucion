package geometria;

public class Coordenada {
	private double altitud;
	private double latitud;
	
	public Coordenada(double latitud, double altitud) {
		this.altitud =altitud;
		this.latitud= latitud;
	}

	public double getAltitud() {
		return altitud;
	}

	public double getLatitud() {
		return latitud;
	}

	@Override
	public String toString() {
		return "(" +latitud + ", " + altitud + ")";
	}
	
}
