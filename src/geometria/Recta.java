package geometria;

public class Recta {
	private Coordenada puntoA, puntoB;
	private double pendiente;
	private double ordenadaOrigen;
	public Recta(Coordenada puntoA, Coordenada puntoB) {
		this.puntoA = puntoA;
		this.puntoB = puntoB;
		pendiente = calcularPendiente();
		ordenadaOrigen = calcularOrdenadaOrigen();
	}
	private double calcularOrdenadaOrigen() {
		return puntoA.getAltitud() - puntoA.getLatitud()*pendiente;
	}
	
	private double calcularPendiente() {
		return (puntoA.getAltitud()-puntoB.getAltitud())/(puntoA.getLatitud() - puntoB.getLatitud());
	}

	private double getPendiente() {
		return pendiente;
	}
	
	public Coordenada obtenerPuntoEnX(double x) {
		if(pendiente == Double.POSITIVE_INFINITY || pendiente == Double.NEGATIVE_INFINITY) {
			return puntoB;
		}
		return new Coordenada(x, pendiente*x + ordenadaOrigen);
	}
	
	public Coordenada obtenerPuntoEnY(double y) {
		if(pendiente == Double.POSITIVE_INFINITY || pendiente == Double.NEGATIVE_INFINITY) {
			return puntoB;
		}
		return new Coordenada((y-ordenadaOrigen)/pendiente, y);
	}
	
}
