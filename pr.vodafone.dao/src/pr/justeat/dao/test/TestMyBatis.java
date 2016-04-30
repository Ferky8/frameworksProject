package pr.justeat.dao.test;

import java.util.Iterator;
import java.util.List;

import pr.justeat.dao.ClienteDAO;
import pr.justeat.dao.ElementoDAO;
import pr.justeat.dao.PedidoDAO;
import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;

public class TestMyBatis {
	
	public static void main(String[] args) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		ElementoDAO elementoDAO = new ElementoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

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
			
			pedidoDAO.setPedidoEntregado(1234, false);
			System.out.println("Pedido 1234 actualizado con exito.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		try {
			Cliente cl = clienteDAO.getCliente(111);
			System.out.println("*** CLIENTE CON EL DNI 111 ***");
			System.out.println(cl.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Cliente> clientes = clienteDAO.getClientes();
			Iterator<Cliente> i = clientes.iterator();
			System.out.println("*** TODOS LOS CLIENTES ***");
			while (i.hasNext()){
				Cliente cl =(Cliente)i.next();
				System.out.println(cl.getNombre());
			}
			System.out.println(clientes.size() + " clientes encontrados.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			Cliente cl = new Cliente();
			cl.setDni("111");
			cl.setNombre("Nuevo Nombre");
			cl.setDireccion("Nueva Direccion");
			cl.setEmail("Nuevo email");

			clienteDAO.updateCliente(cl);
			System.out.println("Cliente actualizado con exito.");
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
		
		try {
			List<Elemento> elementos = elementoDAO.getElementosByPedido(1234);
			Iterator<Elemento> i = elementos.iterator();
			System.out.println("*** ELEMENTOS DEL PEDIDO 1234 ***");
			while (i.hasNext()){
				Elemento elem =(Elemento)i.next();
				System.out.println(elem.getNombre());
			}
			System.out.println(elementos.size() + " elementos encontrados.");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
