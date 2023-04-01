package models;

import java.util.ArrayList;
import java.util.List;

public class Mediador {
	private static Mediador instancia = null;
	private List<Pedido> pSolicitudes;
	private List<Operador> operadores;
	private List<Repartidor> repartidores;

	private Mediador() {
		pSolicitudes = new ArrayList<Pedido>();
		operadores = new ArrayList<Operador>();
		repartidores = new ArrayList<Repartidor>();
	}

	public static Mediador getInstancia() {
		if (instancia == null) {
			instancia = new Mediador();
		}
		return instancia;
	}

	public void crearPedido(Pedido pedido) {
		pSolicitudes.add(pedido);
		System.out.println("Pedido creado: " + pedido);
		if (operadores.size() == 0) {
			System.out.println("No hay operadores disponibles");
			return;
		}
		System.out.println("Notificando a los operadores...");
		notificarOperadores(pedido);

	}

	private void notificarOperadores(Pedido pedido) {
		for (Operador operador : operadores) {
			operador.asignarPedido(pedido);
		}
	}

	public List<Operador> getOperadores() {
		return operadores;
	}

	public List<Repartidor> getRepartidores() {
		return repartidores;
	}

	public void asignarPedido(Repartidor repartidor, Pedido pedido) {
		pedido.setEstado(Estado.PENDIENTE);
		repartidor.getpPendientes().add(pedido);
		System.out.println("Se ha asignado el pedido " + pedido + " al repartidor: " + repartidor.getNombre() + ",ID: "
				+ repartidor.hashCode());
		pSolicitudes.remove(pedido);
	}
	
	public void reasignarPedidos() {
		while(pSolicitudes.size()!=0) {
			notificarOperadores(pSolicitudes.get(0));
		}
	}

	public void agregarRepartidor(String nombre, Zona zona) {
		if (zona != null) {
			Repartidor repartidor = new Repartidor(nombre, zona);
			repartidores.add(repartidor);
			System.out.println("Nuevo repartidor agregado al sistema: " + repartidor);
		} else {
			System.out.println("La zona ingresada no existe");
		}
	}
	
	public void agregarOperador(String nombre) {
		Operador operador = new Operador(nombre);
		operadores.add(operador);
		System.out.println("Nuevo operador agregado al sistema: " + operador);
		
	}

}
