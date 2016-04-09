package pr.justeat.dao.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;
import pr.justeat.dao.dto.Restaurante;

public class TestBD {

	public void testClientes(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Cliente cliente = new Cliente ("444", "Prueba prueba", "Calle YYY, Portugalete", "prueba@deusto.es");
			gbd.insertarCliente(cliente);
			cliente = gbd.obtenerCliente("444");
			this.visualizarCliente(cliente);
			
			cliente.setNombre("Prueba Test Prueba");
			gbd.actualizarCliente("444", cliente);
			cliente = gbd.obtenerCliente("444");
			this.visualizarCliente(cliente);
			
			gbd.borrarCliente("444");
			
			Vector<Cliente> clientes;
			clientes = gbd.obtenerClientes();
			this.visualizarClientes(clientes);
			
			clientes = gbd.obtenerClientesPorNombre("e");
			this.visualizarClientes(clientes);
			
			int count = gbd.contarClientes();
			System.out.println("Clientes = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testPedidos(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Cliente cliente = new Cliente ("111", "Prueba prueba", "Calle YYY, Portugalete", "prueba@deusto.es");
			gbd.insertarCliente(cliente);
			cliente = gbd.obtenerCliente("111");
			this.visualizarCliente(cliente);
			Restaurante restaurante = new Restaurante ("1", "RESTaurant", "Moderna", 500, 400, 300, 200);
			gbd.insertarRestaurante(restaurante);
			restaurante = gbd.obtenerRestaurante("1");
			this.visualizarRestaurante(restaurante);
			Pedido pedido = new Pedido (1456, "1", "2011-03-03", true, "Urgente", "Metalico", "Ninguna", "111");
			gbd.insertarPedido(pedido);
			pedido = gbd.obtenerPedido(1456);
			this.visualizarPedido(pedido);
			
			pedido.setPromocion("Todo gratis");
			gbd.actualizarPedido(1456, pedido);
			gbd.entregarPedido(1456, false);
			pedido = gbd.obtenerPedido(1456);
			this.visualizarPedido(pedido);
			
			gbd.borrarPedido(1456);
			
			Vector<Pedido> pedidos;
			pedidos = gbd.obtenerPedidos();
			this.visualizarPedidos(pedidos);
			
			pedidos = gbd.obtenerPedidosEntregados(true);
			this.visualizarPedidos(pedidos);
			
			pedidos = gbd.obtenerPedidosCliente("111");
			this.visualizarPedidos(pedidos);
			
			pedidos = gbd.obtenerPedidosEntregadosCliente("111", true);
			this.visualizarPedidos(pedidos);
			
			int count = gbd.contarPedidos();
			System.out.println("Pedidos = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testElementos(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Pedido pedido = new Pedido (1456, "1", "2011-03-03", true, "Urgente", "Metalico", "Ninguna", "111");
			gbd.insertarPedido(pedido);
			pedido = gbd.obtenerPedido(1456);
			this.visualizarPedido(pedido);
			Elemento elemento = new Elemento (3, "Perritos calientes", 15, 1456);
			gbd.insertarElemento(elemento);
			
			elemento = gbd.obtenerElemento(11);
			this.visualizarElemento(elemento);
			
			elemento.setImporte(elemento.getImporte() + 10);
			gbd.actualizarElemento(elemento.getIdElemento(), elemento);
			elemento = gbd.obtenerElemento(elemento.getIdElemento());
			this.visualizarElemento(elemento);
			
			//gbd.borrarElemento(3);
			
			Vector<Elemento> elementos;
			elementos = gbd.obtenerElementos();
			this.visualizarElementos(elementos);
			
			elementos = gbd.obtenerElementosPedido(666111000);
			this.visualizarElementos(elementos);
			
			elementos = gbd.obtenerElementosCliente("111");
			this.visualizarElementos(elementos);
						
			int count = gbd.contarElementos();
			System.out.println("Elementos = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	public void testRestaurantees(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
			Restaurante restaurante = new Restaurante ("4", "Manolo", "Genérica", 500, 400, 300, 200);
			gbd.insertarRestaurante(restaurante);
			
			restaurante = gbd.obtenerRestaurante("4");
			this.visualizarRestaurante(restaurante);
			
			restaurante.setPrecioMedio(1000);
			gbd.actualizarRestaurante("4", restaurante);
			restaurante = gbd.obtenerRestaurante("4");
			this.visualizarRestaurante(restaurante);
			
			gbd.borrarRestaurante("4");
			
			Vector<Restaurante> restaurantees;
			restaurantees = gbd.obtenerRestaurantes();
			this.visualizarRestaurantees(restaurantees);
			
			restaurantees = gbd.obtenerRestaurantesPorNombre("Casa");
			this.visualizarRestaurantees(restaurantees);
			
			restaurantees = gbd.obtenerRestaurantesPorTipoComida("Tradicional");
			this.visualizarRestaurantees(restaurantees);
			
			restaurantees = gbd.obtenerRestaurantesPorPrecioMedio(30, 40);
			this.visualizarRestaurantees(restaurantees);
									
			int count = gbd.contarRestaurantes();
			System.out.println("Restaurantes = " + count);
            
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public void testBorrarTodo(){
		GestorBD gbd = new GestorBD();
        try {
			gbd.conectar();
	        gbd.borrarElementos();
	        gbd.borrarPedidos();
	        gbd.borrarRestaurantes();
	        gbd.borrarClientes();
            gbd.desconectar();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private void visualizarClientes(Vector<Cliente> v){
    	Iterator<Cliente> i = v.iterator();
    	while(i.hasNext()){
    		Cliente cliente = i.next();
    		visualizarCliente(cliente);
    	}
    }
    
    private void visualizarCliente(Cliente c){
    	System.out.println(c.getDni()+ "\t" + c.getNombre()+ "\t" + c.getDireccion()+ "\t" + c.getEmail());
    }
    
    private void visualizarPedidos(Vector<Pedido> v){
    	Iterator<Pedido> i = v.iterator();
    	while(i.hasNext()){
    		Pedido pedido = i.next();
    		visualizarPedido(pedido);
    	}
    }
    
    private void visualizarPedido(Pedido l){
    	System.out.println(l.getIdPedido() + "\t" + l.getFecha() + "\t" + l.isEntregado() + "\t" + l.getTipoEntrega() + "\t" + l.getTipoPago() + "\t" + l.getPromocion() + "\t" + l.getDni());
    }
    
    private void visualizarElemento(Elemento f){
    	System.out.println(f.getIdElemento() + "\t" + f.getCantidad() + "\t" + f.getNombre() + "\t" + f.getImporte() + "\t" + f.getPedido());
    }
    
    private void visualizarElementos(Vector<Elemento> v){
    	Iterator<Elemento> i = v.iterator();
    	while(i.hasNext()){
    		Elemento elemento = i.next();
    		visualizarElemento(elemento);
    	}
    }

    private void visualizarRestaurante(Restaurante t){
    	System.out.println(t.getIdRestaurante() + "\t" + t.getNombre() + "\t" + t.getTipoComida() + "\t" + t.getPrecioMedio() + "\t" + t.getPuntuacion() + "\t" + t.getTiempoMedio() + "\t" + t.getOfertaActual());
    }
    
    private void visualizarRestaurantees(Vector<Restaurante> v){
    	Iterator<Restaurante> i = v.iterator();
    	while(i.hasNext()){
    		Restaurante restaurante = i.next();
    		visualizarRestaurante(restaurante);
    	}
    }

    
    public static void main(String[] args) {
        TestBD test = new TestBD();
        test.testClientes();
        test.testPedidos();
        test.testElementos();
        test.testRestaurantees();
        test.testBorrarTodo();
        System.out.println("Done!");
    }

}
