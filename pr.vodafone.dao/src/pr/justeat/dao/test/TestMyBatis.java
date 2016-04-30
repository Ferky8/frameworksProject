package pr.justeat.dao.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import pr.justeat.dao.ElementoDAO;
import pr.justeat.dao.PedidoDAO;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;

public class TestMyBatis {
	
	public static void main(String[] args) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		ElementoDAO elementoDAO = new ElementoDAO();

		try {
			Pedido ped = pedidoDAO.getPedido(1234);
			System.out.println("*** PEDIDO CON EL ID 1234 ***");
			System.out.println(ped.getPromocion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			boolean entregado = true;
			List<Pedido> pedidos = pedidoDAO.getPedidosByEstado(entregado);
			Iterator<Pedido> i = pedidos.iterator();
			System.out.println("*** PEDIDOS ENTREGADOS ***");
			while (i.hasNext()){
				Pedido ped =(Pedido)i.next();
				System.out.println(ped.getPromocion());
			}
			System.out.println(pedidos.size() + " pedidos encontrados.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			List<Pedido> pedidos = pedidoDAO.getPedidosByCliente("111");
			Iterator<Pedido> i = pedidos.iterator();
			System.out.println("*** PEDIDOS DEL CLIENTE 111 ***");
			while (i.hasNext()){
				Pedido ped =(Pedido)i.next();
				System.out.println(ped.getPromocion());
			}
			System.out.println(pedidos.size() + " pedidos encontrados.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			boolean entregado = true;
			List<Pedido> pedidos = pedidoDAO.getPedidosByClienteAndEstado("111", entregado);
			Iterator<Pedido> i = pedidos.iterator();
			System.out.println("*** PEDIDOS DEL CLIENTE 111 Y ENTREGADOS ***");
			while (i.hasNext()){
				Pedido ped =(Pedido)i.next();
				System.out.println(ped.getPromocion());
			}
			System.out.println(pedidos.size() + " pedidos encontrados.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			Pedido ped = new Pedido();
			ped.setIdPedido(1234);
			ped.setRestaurante("1");
			ped.setFecha("2016-04-30");
			ped.setEntregado(true);
			ped.setTipoEntrega("He");
			ped.setTipoPago("sido");
			ped.setPromocion("actualizado");
			ped.setDni("111");

			pedidoDAO.updatePedido(ped);
			System.out.println("Pedido actualizado con exito.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {	
			Elemento elem = elementoDAO.getElementoPorId(1);
			System.out.println("*** ELEMENTO CON EL ID 1 ***");
			System.out.println(elem.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
