package models;

import java.util.ArrayList;
import java.util.List;

import geometria.Coordenada;

public class Cliente {
	private String nombre;
	private Coordenada direccion;
	private List<Pedido> pRecibidos;
	private List<Pedido> pSolicitados;

	public String getNombre() {
		return nombre;
	}

	public Coordenada getDireccion() {
		return direccion;
	}

	public List<Pedido> getpRecibidos() {
		return pRecibidos;
	}

	public List<Pedido> getpSolicitados() {
		return pSolicitados;
	}

	public Cliente(String nombre, Coordenada direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		pRecibidos = new ArrayList<Pedido>();
		pSolicitados = new ArrayList<Pedido>();
	}

	public void crearPedido(PedidoDTO pSoli) {
		pSoli.setCliente(this);
		pSoli.setDirEntrega(this.getDireccion());
		Pedido pedido = new Pedido(pSoli);
		Mediador.getInstancia().crearPedido(pedido);
	}

	public void setDireccion(Coordenada direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + ", direccion:" + direccion;
	}

}
