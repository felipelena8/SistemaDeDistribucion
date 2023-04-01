package models;

import java.util.Date;

import geometria.Coordenada;

public class Pedido {
	private Cliente cliente;
	private String descripcion;
	private Date fechaSolicitud;
	private Coordenada dirEntrega;
	private Estado estado;
	
	public Cliente getCliente() {
		return cliente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public Coordenada getDirEntrega() {
		return dirEntrega;
	}
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Pedido(PedidoDTO p) {
		this.cliente = p.getCliente();
		this.descripcion = p.getDescripcion();
		this.fechaSolicitud = p.getFechaSolicitud();
		this.dirEntrega = p.getDirEntrega();
		this.estado = Estado.ASIGNACION_PENDIENTE;
	}
	@Override
	public String toString() {
		return "Descripcion: " + descripcion + ", dirEntrega:" + dirEntrega + ", realizada por el cliente: " + cliente;
	}

	
}
