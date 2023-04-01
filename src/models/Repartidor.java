package models;

import java.util.ArrayList;
import java.util.List;

import models.Zona.BuilderZona;

public class Repartidor {
	private String nombre;
	private List<Zona> zonasCubiertas;
	private List<Pedido> pEntregados;
	private List<Pedido> pPendientes;

	public List<Zona> getZonasCubiertas() {
		return zonasCubiertas;
	}

	public List<Pedido> getpEntregados() {
		return pEntregados;
	}

	public List<Pedido> getpPendientes() {
		return pPendientes;
	}

	
	public void entregarPedidos() {
		while(pPendientes.size()!=0) {
			entregarPedido(pPendientes.get(0));
		}
	}
	
	public void entregarPedido(Pedido pedido) {
		if (pPendientes.contains(pedido)) {
				pedido.setEstado(Estado.ENTREGADO);
				System.out.println((pPendientes.remove(pedido) ? "El pedido "+pedido+" ha sido entregado" : "Ocurrio un error"));
				pEntregados.add(pedido);
		}
	}

	public Repartidor(String nombre, Zona zona) {
		this.nombre = nombre;
		zonasCubiertas = new ArrayList<Zona>();
		pEntregados = new ArrayList<Pedido>();
		pPendientes = new ArrayList<Pedido>();
		zonasCubiertas.add(zona);
	}

	public void agregarZona(Zona zona) {
		if (zona == null) {
			return;
		}
		zonasCubiertas.add(zona);
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "nombre: " + nombre + ", zonasCubiertas: " + zonasCubiertas;
	}
	
}
