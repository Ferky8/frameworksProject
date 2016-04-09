package pr.justeat.dao;

import java.sql.*;
import java.util.Base64.Decoder;

import java.util.Vector;

import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;
import pr.justeat.dao.dto.Restaurante;

public class GestorBD {

	public static GestorBD instance;	
	
	private Connection con;
    
    private String dataSource = "//localhost/justeat";
    private String username = "root";
    private String password = "";
    private String driver = "com.mysql.jdbc.Driver";
    private String protocol = "jdbc:mysql";    
    
    
    public static GestorBD getInstance(){
		if (instance == null) instance = new GestorBD();
		return instance;
	}
    
    public GestorBD(){
    	try {
			instance.conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public GestorBD(String dataSource, String username, String password){
    	this.dataSource = dataSource;
    	this.username = username;
    	this.password = password;
    }
    
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(driver);        
        String url = protocol + ":" + dataSource;
        con = DriverManager.getConnection(url, username, password);               
    }
    
    public void desconectar() throws SQLException{
        con.close();
    }    
    
    public Cliente obtenerCliente(String dni) throws SQLException{        
    	Cliente cliente = null;
    	String select = "select * from CLIENTES where dni='" + dni +"'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	cliente = new Cliente();
        	cliente.setDni(rs.getString("dni"));
        	cliente.setNombre(rs.getString("nombre"));
        	cliente.setDireccion(rs.getString("direccion"));
        	cliente.setEmail(rs.getString("email"));
        }
        rs.close();
        stmt.close();  
        return cliente;
    }
    
    public Vector<Cliente> obtenerClientes() throws SQLException{        
        Vector<Cliente> clientes = new Vector<Cliente>();
    	String select = "select * from CLIENTES";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Cliente cliente = new Cliente();
        	cliente.setDni(rs.getString("dni"));
        	cliente.setNombre(rs.getString("nombre"));
        	cliente.setDireccion(rs.getString("direccion"));
        	cliente.setEmail(rs.getString("email"));
        	clientes.add(cliente);
        }
        rs.close();
        stmt.close();  
        return clientes;
    }
    
    public Vector<Cliente> obtenerClientesPorNombre(String nombre) throws SQLException{        
        Vector<Cliente> clientes = new Vector<Cliente>();
    	String select = "select * from CLIENTES where nombre like '%" + nombre + "%'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Cliente cliente = new Cliente();
        	cliente.setDni(rs.getString("dni"));
        	cliente.setNombre(rs.getString("nombre"));
        	cliente.setDireccion(rs.getString("direccion"));
        	cliente.setEmail(rs.getString("email"));
        	clientes.add(cliente);
        }
        rs.close();
        stmt.close();  
        return clientes;
    }
    
    public void insertarCliente(Cliente cliente) throws SQLException{
        String insert = "insert into CLIENTES " +
                        "(dni, nombre, direccion, email) " +
                        "VALUES ('" + cliente.getDni() +
                        "','" + cliente.getNombre() +
                        "','" + cliente.getDireccion() +
                        "','"  + cliente.getEmail() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
    public void actualizarCliente(String dni, Cliente cliente) throws SQLException{
        String update = "update CLIENTES set dni='" + cliente.getDni() + 
        				"', nombre='" + cliente.getNombre() +
        				"', direccion='" + cliente.getDireccion() +
        				"', email='" + cliente.getEmail() +
        				"' where dni='" + dni + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarCliente(String dni) throws SQLException{
       	String delete = "delete from CLIENTES where dni='" + dni + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarClientes() throws SQLException{
       	String delete = "delete from CLIENTES";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarClientes() throws SQLException{
    	String count = "select count(*) from CLIENTES";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(count);
        rs.next();
        int numFilas = rs.getInt(1);
        rs.close();
        stmt.close();      
        return numFilas;
    }
    
    public Pedido obtenerPedido(int idPedido) throws SQLException{        
        Pedido pedido = null;
    	String select = "select * from PEDIDOS where idPedido='" + idPedido + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	pedido = new Pedido();
        	pedido.setRestaurante(rs.getString("restaurante"));
        	pedido.setFecha(rs.getString("fecha"));
        	pedido.setEntregado(rs.getBoolean("entregado"));
        	pedido.setTipoEntrega(rs.getString("tipoEntrega"));
        	pedido.setTipoPago(rs.getString("tipoPago"));
        	pedido.setPromocion(rs.getString("promocion"));
        	pedido.setDni(rs.getString("dni"));
        }
        rs.close();
        stmt.close();  
        return pedido;
    }
    
    public Vector<Pedido> obtenerPedidos() throws SQLException{        
        Vector<Pedido> pedidos = new Vector<Pedido>();
    	String select = "select * from PEDIDOS order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido pedido = new Pedido();
        	pedido.setRestaurante(rs.getString("restaurante"));
        	pedido.setFecha(rs.getString("fecha"));
        	pedido.setEntregado(rs.getBoolean("entregado"));
        	pedido.setTipoEntrega(rs.getString("tipoEntrega"));
        	pedido.setTipoPago(rs.getString("tipoPago"));
        	pedido.setPromocion(rs.getString("promocion"));
        	pedido.setDni(rs.getString("dni"));
        	pedidos.add(pedido);
        }
        rs.close();
        stmt.close();  
        return pedidos;
    }
    
    public Vector<Pedido> obtenerPedidosEntregados(boolean entregado) throws SQLException{        
        Vector<Pedido> pedidos = new Vector<Pedido>();
    	String select = "select * from PEDIDOS where entregado=" + entregado + " order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido pedido = new Pedido();
        	pedido.setRestaurante(rs.getString("restaurante"));
        	pedido.setFecha(rs.getString("fecha"));
        	pedido.setEntregado(rs.getBoolean("entregado"));
        	pedido.setTipoEntrega(rs.getString("tipoEntrega"));
        	pedido.setTipoPago(rs.getString("tipoPago"));
        	pedido.setPromocion(rs.getString("promocion"));
        	pedido.setDni(rs.getString("dni"));
        	pedidos.add(pedido);
        }
        rs.close();
        stmt.close();  
        return pedidos;
    }
    
    public Vector<Pedido> obtenerPedidosCliente(String dni) throws SQLException{        
        Vector<Pedido> pedidos = new Vector<Pedido>();
    	String select = "select * from PEDIDOS where dni='" + dni + "' order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido pedido = new Pedido();
        	pedido.setRestaurante(rs.getString("restaurante"));
        	pedido.setFecha(rs.getString("fecha"));
        	pedido.setEntregado(rs.getBoolean("entregado"));
        	pedido.setTipoEntrega(rs.getString("tipoEntrega"));
        	pedido.setTipoPago(rs.getString("tipoPago"));
        	pedido.setPromocion(rs.getString("promocion"));
        	pedido.setDni(rs.getString("dni"));
        	pedidos.add(pedido);
        }
        rs.close();
        stmt.close();  
        return pedidos;
    }
    
    public Vector<Pedido> obtenerPedidosEntregadosCliente(String dni, boolean entregado) throws SQLException{        
        Vector<Pedido> pedidos = new Vector<Pedido>();
    	String select = "select * from PEDIDOS where dni='" + dni + "' AND entregado=" + entregado + " order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido pedido = new Pedido();
        	pedido.setRestaurante(rs.getString("restaurante"));
        	pedido.setFecha(rs.getString("fecha"));
        	pedido.setEntregado(rs.getBoolean("entregado"));
        	pedido.setTipoEntrega(rs.getString("tipoEntrega"));
        	pedido.setTipoPago(rs.getString("tipoPago"));
        	pedido.setPromocion(rs.getString("promocion"));
        	pedido.setDni(rs.getString("dni"));
        	pedidos.add(pedido);
        }
        rs.close();
        stmt.close();  
        return pedidos;
    }
    
    public void insertarPedido(Pedido pedido) throws SQLException{
    	int entregado = 0;
    	if(pedido.isEntregado())
    		entregado = 1;
        String insert = "insert into PEDIDOS " +
                        "(idPedido, restaurante, fecha, entregado, tipoEntrega, tipoPago, promocion, dni) " +
                        "VALUES ('" + pedido.getIdPedido() +
                        "','" + pedido.getRestaurante() +
                        "','" + pedido.getFecha() +
                        "','" + entregado +
                        "','" + pedido.getTipoEntrega() +
                        "','" + pedido.getTipoPago() +
                        "','" + pedido.getPromocion() +
                        "','"  + pedido.getDni() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
    public void actualizarPedido(int idPedido, Pedido pedido) throws SQLException{
        String update = "update PEDIDOS set restaurante='" + pedido.getRestaurante() + 
        				"', fecha='" + pedido.getFecha() +
        				"', entregado=" + pedido.isEntregado() +
        				", tipoEntrega='" + pedido.getTipoEntrega() +
        				"', tipoPago='" + pedido.getTipoPago() +
        				"', promocion='" + pedido.getPromocion() +
        				"', dni='" + pedido.getDni() +
        				"' where idPedido='" + idPedido + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void entregarPedido(int idPedido, boolean entregado) throws SQLException{
        String update = "update PEDIDOS set entregado=" + entregado + " where idPedido='" + idPedido + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarPedido(int idPedido) throws SQLException{
       	String delete = "delete from PEDIDOS where idPedido='" + idPedido + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarPedidos() throws SQLException{
       	String delete = "delete from PEDIDOS";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarPedidos() throws SQLException{
    	String count = "select count(*) from PEDIDOS";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(count);
        rs.next();
        int numFilas = rs.getInt(1);
        rs.close();
        stmt.close();      
        return numFilas;
    }

    public Elemento obtenerElemento(int idElemento) throws SQLException{        
        Elemento elemento = null;
    	String select = "select * from ELEMENTOS where idElemento=" + idElemento;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	elemento = new Elemento();
        	elemento.setIdElemento(rs.getInt("idElemento"));
        	elemento.setCantidad(rs.getInt("cantidad"));
        	elemento.setNombre(rs.getString("nombre"));
        	elemento.setImporte(rs.getFloat("importe"));
        	elemento.setPedido(rs.getInt("pedido"));
        }
        rs.close();
        stmt.close();  
        return elemento;
    }    
    public Vector<Elemento> obtenerElementos() throws SQLException{        
        Vector<Elemento> elementos = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS order by cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento elemento = new Elemento();
        	elemento.setIdElemento(rs.getInt("idElemento"));
        	elemento.setCantidad(rs.getInt("cantidad"));
        	elemento.setNombre(rs.getString("nombre"));
        	elemento.setImporte(rs.getFloat("importe"));
        	elemento.setPedido(rs.getInt("pedido"));
        	elementos.add(elemento);
        }
        rs.close();
        stmt.close();  
        return elementos;
    }    
    public Vector<Elemento> obtenerElementosPedido(int pedido) throws SQLException{        
        Vector<Elemento> elementos = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS where pedido=" + pedido + " order by cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento elemento = new Elemento();
        	elemento.setIdElemento(rs.getInt("idElemento"));
        	elemento.setCantidad(rs.getInt("cantidad"));
        	elemento.setNombre(rs.getString("nombre"));
        	elemento.setImporte(rs.getFloat("importe"));
        	elemento.setPedido(rs.getInt("pedido"));
        	elementos.add(elemento);
        }
        rs.close();
        stmt.close();  
        return elementos;
    }

    public Vector<Elemento> obtenerElementosCliente(String dni) throws SQLException{        
        Vector<Elemento> elementos = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS as E, PEDIDOS as P where e.pedido=p.idPedido and p.dni='" + dni + "' order by e.pedido, e.cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento elemento = new Elemento();
        	elemento.setIdElemento(rs.getInt("idElemento"));
        	elemento.setCantidad(rs.getInt("cantidad"));
        	elemento.setNombre(rs.getString("nombre"));
        	elemento.setImporte(rs.getFloat("importe"));
        	elemento.setPedido(rs.getInt("pedido"));
        	elementos.add(elemento);
        }
        rs.close();
        stmt.close();  
        return elementos;
    }
    
    public int insertarElemento(Elemento elemento) throws SQLException{
        String insert = "insert into ELEMENTOS " +
                        "(cantidad, nombre, importe, pedido) " +
                        "VALUES ('" + elemento.getCantidad() +
                        "','" + elemento.getNombre() +
                        "'," + elemento.getImporte() +
                        ",'"  + elemento.getPedido() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();
        
        String max = "select MAX(idElemento) as id from ELEMENTOS";
        Statement stmt1 = con.createStatement();
        ResultSet rs = stmt1.executeQuery(max);
        int id = 0;
        if (rs.next()){
        	id = rs.getInt("id");
        }
        stmt1.close();
        elemento.setIdElemento(id);
        return id;
    }
    
    public void actualizarElemento(int idElemento, Elemento elemento) throws SQLException{
        String update = "update ELEMENTOS set idElemento=" + elemento.getIdElemento() + 
        				", cantidad='" + elemento.getCantidad() +
        				"', nombre='" + elemento.getNombre() +
        				"', importe=" + elemento.getImporte() +
        				", pedido='" + elemento.getPedido() +
        				"' where idElemento=" + idElemento;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarElemento(int idElemento) throws SQLException{
       	String delete = "delete from ELEMENTOS where idElemento=" + idElemento;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarElementos() throws SQLException{
       	String delete = "delete from ELEMENTOS";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarElementos() throws SQLException{
    	String count = "select count(*) from ELEMENTOS";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(count);
        rs.next();
        int numFilas = rs.getInt(1);
        rs.close();
        stmt.close();      
        return numFilas;
    }
  
    public Restaurante obtenerRestaurante(String idRestaurante) throws SQLException{        
        Restaurante restaurante = null;
    	String select = "select * from RESTAURANTES where idRestaurante='" + idRestaurante + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	restaurante = new Restaurante();
        	restaurante.setIdRestaurante(rs.getString("idRestaurante"));
        	restaurante.setNombre(rs.getString("nombre"));
        	restaurante.setTipoComida(rs.getString("tipoComida"));
        	restaurante.setPrecioMedio(rs.getFloat("precioMedio"));
        	restaurante.setPuntuacion(rs.getFloat("puntuacion"));
        	restaurante.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	restaurante.setOfertaActual(rs.getFloat("ofertaActual"));        	
        }
        rs.close();
        stmt.close();  
        return restaurante;
    }
    
    public Vector<Restaurante> obtenerRestaurantes() throws SQLException{        
        Vector<Restaurante> restaurantees = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante restaurante = new Restaurante();
        	restaurante.setIdRestaurante(rs.getString("idRestaurante"));
        	restaurante.setNombre(rs.getString("nombre"));
        	restaurante.setTipoComida(rs.getString("tipoComida"));
        	restaurante.setPrecioMedio(rs.getFloat("precioMedio"));
        	restaurante.setPuntuacion(rs.getFloat("puntuacion"));
        	restaurante.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	restaurante.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	restaurantees.add(restaurante);
        }
        rs.close();
        stmt.close();  
        return restaurantees;
    }
    
    public Vector<Restaurante> obtenerRestaurantesPorNombre(String nombre) throws SQLException{        
        Vector<Restaurante> restaurantees = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where nombre like '%" + nombre + "%' order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante restaurante = new Restaurante();
        	restaurante.setIdRestaurante(rs.getString("idRestaurante"));
        	restaurante.setNombre(rs.getString("nombre"));
        	restaurante.setTipoComida(rs.getString("tipoComida"));
        	restaurante.setPrecioMedio(rs.getFloat("precioMedio"));
        	restaurante.setPuntuacion(rs.getFloat("puntuacion"));
        	restaurante.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	restaurante.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	restaurantees.add(restaurante);
        }
        rs.close();
        stmt.close();  
        return restaurantees;
    }

    public Vector<Restaurante> obtenerRestaurantesPorTipoComida(String tipoComida) throws SQLException{        
        Vector<Restaurante> restaurantees = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where tipoComida like '%" + tipoComida + "%' order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante restaurante = new Restaurante();
        	restaurante.setIdRestaurante(rs.getString("idRestaurante"));
        	restaurante.setNombre(rs.getString("nombre"));
        	restaurante.setTipoComida(rs.getString("tipoComida"));
        	restaurante.setPrecioMedio(rs.getFloat("precioMedio"));
        	restaurante.setPuntuacion(rs.getFloat("puntuacion"));
        	restaurante.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	restaurante.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	restaurantees.add(restaurante);
        }
        rs.close();
        stmt.close();  
        return restaurantees;
    }

    public Vector<Restaurante> obtenerRestaurantesPorPrecioMedio(float min, float max) throws SQLException{        
        Vector<Restaurante> restaurantees = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where precioMedio >= " + min + " AND precioMedio <= " + max + " order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante restaurante = new Restaurante();
        	restaurante.setIdRestaurante(rs.getString("idRestaurante"));
        	restaurante.setNombre(rs.getString("nombre"));
        	restaurante.setTipoComida(rs.getString("tipoComida"));
        	restaurante.setPrecioMedio(rs.getFloat("precioMedio"));
        	restaurante.setPuntuacion(rs.getFloat("puntuacion"));
        	restaurante.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	restaurante.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	restaurantees.add(restaurante);
        }
        rs.close();
        stmt.close();  
        return restaurantees;
    }

    
    public void insertarRestaurante(Restaurante restaurante) throws SQLException{
    	try {
			conectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
        String insert = "insert into RESTAURANTES " +
                        "(idRestaurante, nombre, tipoComida, precioMedio, puntuacion, tiempoMedio, ofertaActual) " +
                        "VALUES ('" + restaurante.getIdRestaurante() +
                        "','" + restaurante.getNombre() +
                        "','" + restaurante.getTipoComida() +
                        "'," + restaurante.getPrecioMedio() +
                        "," + restaurante.getPuntuacion() +
                        "," + restaurante.getTiempoMedio() +
                        ","  + restaurante.getOfertaActual() + ")";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();
        
        desconectar();
    }
    
    public void actualizarRestaurante(String idRestaurante, Restaurante restaurante) throws SQLException{
        String update = "update RESTAURANTES set idRestaurante='" + restaurante.getIdRestaurante() + 
        				"', nombre='" + restaurante.getNombre() +
        				"', tipoComida='" + restaurante.getTipoComida() +
        				"', precioMedio=" + restaurante.getPrecioMedio() +
        				", puntuacion=" + restaurante.getPuntuacion() +
        				", tiempoMedio=" + restaurante.getTiempoMedio() +
        				", ofertaActual=" + restaurante.getOfertaActual() +
        				" where idRestaurante='" + idRestaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarRestaurante(String idRestaurante) throws SQLException{
       	String delete = "delete from RESTAURANTES where idRestaurante='" + idRestaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarRestaurantes() throws SQLException{
       	String delete = "delete from RESTAURANTES";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarRestaurantes() throws SQLException{
    	String count = "select count(*) from RESTAURANTES";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(count);
        rs.next();
        int numFilas = rs.getInt(1);
        rs.close();
        stmt.close();      
        return numFilas;
    }
}
