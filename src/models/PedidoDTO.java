package models;

import java.util.Date;

import geometria.Coordenada;

public class PedidoDTO {
	private Cliente cliente;
	private String descripcion;
	private Date fechaSolicitud;
	private Coordenada dirEntrega;

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
	
	public PedidoDTO(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDirEntrega(Coordenada dirEntrega) {
		this.dirEntrega = dirEntrega;
	}
	
	
}
