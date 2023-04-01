package pruebas;

import geometria.Coordenada;
import geometria.Recta;
import models.Cliente;
import models.Mediador;
import models.PedidoDTO;
import models.Repartidor;
import models.Zona;
import models.Zona.BuilderZona;

public class Main {

	public static void main(String[] args) {
		Mediador mediador = Mediador.getInstancia();
		
		Cliente cliente1 = new Cliente("Felipe", new Coordenada(120, 120));
		
		mediador.agregarRepartidor("Juan Correo", new BuilderZona().setIzqArriba(0, 120).setDerArriba(30, 140).setIzqAbajo(10, 0).setDerAbajo(70, 20).build());
		//Zona zona = new Zona.BuilderZona().setIzqArriba(0,200).setDerArriba(200, 200).setIzqAbajo(0, 0).setDerAbajo(200,0).build();
		
		cliente1.crearPedido(new PedidoDTO("Iphone 14"));
		
		mediador.agregarOperador("Julian");
		
		Cliente cliente2 = new Cliente("Tomas", new Coordenada(60, 220));
		cliente2.crearPedido(new PedidoDTO("PS5"));
		
		cliente1.setDireccion(new Coordenada(20, 60));
		
		cliente1.crearPedido(new PedidoDTO("Monitor Samsung"));
		
		mediador.agregarRepartidor("Estaban", new BuilderZona().setIzqArriba(20, 300).setDerArriba(120, 280).setIzqAbajo(20, 140).setDerAbajo(120, 160).build());
		mediador.agregarRepartidor("Ricardo", new BuilderZona().setIzqArriba(30, 140).setDerArriba(120, 160).setIzqAbajo(70, 20).setDerAbajo(160, 40).build());
		
		mediador.reasignarPedidos();
		
		Repartidor repartidorEsteban = mediador.getRepartidores().get(1);
		repartidorEsteban.entregarPedidos();

	}

}
