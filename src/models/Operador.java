package models;

public class Operador {

	private String nombre;

	public Operador(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre;
	}

	public void asignarPedido(Pedido pedido) {
		if (pedido.getEstado() == Estado.ASIGNACION_PENDIENTE) {
			for (Repartidor repartidor : Mediador.getInstancia().getRepartidores()) {
				if (repartidor.getpPendientes().size() < 10) {
					for (Zona zona : repartidor.getZonasCubiertas()) {
						if (zona.abarcaDireccion(pedido.getDirEntrega())) {
							Mediador.getInstancia().asignarPedido(repartidor, pedido);
							return;
						}
					}
				}
			}
			System.out.println("No hay repartidores disponibles");
		}
	}
}
