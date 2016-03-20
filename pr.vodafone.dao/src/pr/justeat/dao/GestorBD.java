package pr.justeat.dao;

import java.sql.*;

import java.util.Vector;

import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;
import pr.justeat.dao.dto.Restaurante;


public class GestorBD {

	private Connection con;
    
    private String dataSource = "//localhost/justeat";
    private String username = "root";
    private String password = "";
    private String driver = "com.mysql.jdbc.Driver";
    private String protocol = "jdbc:mysql";    
    
    public GestorBD(){
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
    
    public Pedido obtenerPedido(String restaurante) throws SQLException{        
        Pedido pedido = null;
    	String select = "select * from PEDIDOS where restaurante='" + restaurante + "'";
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
    	String select = "select * from PEDIDOS order by cantidad";
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
    	String select = "select * from PEDIDOS where entregado=" + entregado + " order by cantidad";
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
    	String select = "select * from PEDIDOS where dni='" + dni + "' order by cantidad";
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
    	String select = "select * from PEDIDOS where dni='" + dni + "' AND entregado=" + entregado + " order by cantidad";
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
        String insert = "insert into PEDIDOS " +
                        "(restaurante, cantidad, entregado, tipoEntrega, tipoPago, promocion, dni) " +
                        "VALUES ('" + pedido.getRestaurante() +
                        "','" + pedido.getFecha() +
                        "'," + pedido.isEntregado() +
                        ",'" + pedido.getTipoEntrega() +
                        "','" + pedido.getTipoPago() +
                        "','" + pedido.getPromocion() +
                        "','"  + pedido.getDni() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
    public void actualizarPedido(String restaurante, Pedido pedido) throws SQLException{
        String update = "update PEDIDOS set restaurante='" + pedido.getRestaurante() + 
        				"', fecha='" + pedido.getFecha() +
        				"', entregado=" + pedido.isEntregado() +
        				", tipoEntrega='" + pedido.getTipoEntrega() +
        				"', tipoPago='" + pedido.getTipoPago() +
        				"', promocion='" + pedido.getPromocion() +
        				"', dni='" + pedido.getDni() +
        				"' where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void entregadorPedido(String restaurante, boolean entregado) throws SQLException{
        String update = "update PEDIDOS set entregado=" + entregado + " where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarPedido(String restaurante) throws SQLException{
       	String delete = "delete from PEDIDOS where restaurante='" + restaurante + "'";
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
        Elemento factura = null;
    	String select = "select * from ELEMENTOS where idElemento=" + idElemento;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	factura = new Elemento();
        	factura.setIdElemento(rs.getInt("idElemento"));
        	factura.setCantidad(rs.getInt("cantidad"));
        	factura.setNombre(rs.getString("nombre"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setPedido(rs.getString("pedido"));
        }
        rs.close();
        stmt.close();  
        return factura;
    }    
    public Vector<Elemento> obtenerElementos() throws SQLException{        
        Vector<Elemento> facturas = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS order by cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento factura = new Elemento();
        	factura.setIdElemento(rs.getInt("idElemento"));
        	factura.setCantidad(rs.getInt("cantidad"));
        	factura.setNombre(rs.getString("nombre"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setPedido(rs.getString("pedido"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }    
    public Vector<Elemento> obtenerElementosLinea(String pedido) throws SQLException{        
        Vector<Elemento> facturas = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS where pedido='" + pedido + "' order by cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento factura = new Elemento();
        	factura.setIdElemento(rs.getInt("idElemento"));
        	factura.setCantidad(rs.getInt("cantidad"));
        	factura.setNombre(rs.getString("nombre"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setPedido(rs.getString("pedido"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }

    public Vector<Elemento> obtenerElementosCliente(String dni) throws SQLException{        
        Vector<Elemento> facturas = new Vector<Elemento>();
    	String select = "select * from ELEMENTOS as F, PEDIDOS as L where f.pedido=l.pedido and l.dni='" + dni + "' order by f.pedido, f.cantidad desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Elemento factura = new Elemento();
        	factura.setIdElemento(rs.getInt("idElemento"));
        	factura.setCantidad(rs.getInt("cantidad"));
        	factura.setNombre(rs.getString("nombre"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setPedido(rs.getString("pedido"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }
    
    public int insertarElemento(Elemento factura) throws SQLException{
        String insert = "insert into ELEMENTOS " +
                        "(cantidad, nombre, importe, pedido) " +
                        "VALUES ('" + factura.getCantidad() +
                        "','" + factura.getNombre() +
                        "'," + factura.getImporte() +
                        ",'"  + factura.getPedido() + "')";                        
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
        factura.setIdElemento(id);
        return id;
    }
    
    public void actualizarElemento(int idElemento, Elemento factura) throws SQLException{
        String update = "update ELEMENTOS set idElemento=" + factura.getIdElemento() + 
        				", cantidad='" + factura.getCantidad() +
        				"', nombre='" + factura.getNombre() +
        				"', importe=" + factura.getImporte() +
        				", pedido='" + factura.getPedido() +
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
        Restaurante terminal = null;
    	String select = "select * from RESTAURANTES where idRestaurante='" + idRestaurante + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	terminal = new Restaurante();
        	terminal.setIdRestaurante(rs.getString("idRestaurante"));
        	terminal.setNombre(rs.getString("nombre"));
        	terminal.setTipoComida(rs.getString("tipoComida"));
        	terminal.setPrecioMedio(rs.getFloat("precioMedio"));
        	terminal.setPuntuacion(rs.getFloat("puntuacion"));
        	terminal.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	terminal.setOfertaActual(rs.getFloat("ofertaActual"));        	
        }
        rs.close();
        stmt.close();  
        return terminal;
    }
    
    public Vector<Restaurante> obtenerRestaurantes() throws SQLException{        
        Vector<Restaurante> terminales = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante terminal = new Restaurante();
        	terminal.setIdRestaurante(rs.getString("idRestaurante"));
        	terminal.setNombre(rs.getString("nombre"));
        	terminal.setTipoComida(rs.getString("tipoComida"));
        	terminal.setPrecioMedio(rs.getFloat("precioMedio"));
        	terminal.setPuntuacion(rs.getFloat("puntuacion"));
        	terminal.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	terminal.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	terminales.add(terminal);
        }
        rs.close();
        stmt.close();  
        return terminales;
    }
    
    public Vector<Restaurante> obtenerRestaurantesPorNombre(String nombre) throws SQLException{        
        Vector<Restaurante> terminales = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where nombre like '%" + nombre + "%' order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante terminal = new Restaurante();
        	terminal.setIdRestaurante(rs.getString("idRestaurante"));
        	terminal.setNombre(rs.getString("nombre"));
        	terminal.setTipoComida(rs.getString("tipoComida"));
        	terminal.setPrecioMedio(rs.getFloat("precioMedio"));
        	terminal.setPuntuacion(rs.getFloat("puntuacion"));
        	terminal.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	terminal.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	terminales.add(terminal);
        }
        rs.close();
        stmt.close();  
        return terminales;
    }

    public Vector<Restaurante> obtenerRestauranteesPorTipoComida(String tipoComida) throws SQLException{        
        Vector<Restaurante> terminales = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where tipoComida like '%" + tipoComida + "%' order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante terminal = new Restaurante();
        	terminal.setIdRestaurante(rs.getString("idRestaurante"));
        	terminal.setNombre(rs.getString("nombre"));
        	terminal.setTipoComida(rs.getString("tipoComida"));
        	terminal.setPrecioMedio(rs.getFloat("precioMedio"));
        	terminal.setPuntuacion(rs.getFloat("puntuacion"));
        	terminal.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	terminal.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	terminales.add(terminal);
        }
        rs.close();
        stmt.close();  
        return terminales;
    }

    public Vector<Restaurante> obtenerRestaurantesPorPrecioMedioMedio(float min, float max) throws SQLException{        
        Vector<Restaurante> terminales = new Vector<Restaurante>();
    	String select = "select * from RESTAURANTES where precioMedio >= " + min + " AND precioMedio <= " + max + " order by precioMedio desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Restaurante terminal = new Restaurante();
        	terminal.setIdRestaurante(rs.getString("idRestaurante"));
        	terminal.setNombre(rs.getString("nombre"));
        	terminal.setTipoComida(rs.getString("tipoComida"));
        	terminal.setPrecioMedio(rs.getFloat("precioMedio"));
        	terminal.setPuntuacion(rs.getFloat("puntuacion"));
        	terminal.setTiempoMedio(rs.getFloat("tiempoMedio"));
        	terminal.setOfertaActual(rs.getFloat("ofertaActual"));        	
        	terminales.add(terminal);
        }
        rs.close();
        stmt.close();  
        return terminales;
    }

    
    public void insertarRestaurante(Restaurante terminal) throws SQLException{
        String insert = "insert into RESTAURANTES " +
                        "(idRestaurante, nombre, tipoComida, precioMedio, puntuacion, tiempoMedio, ofertaActual) " +
                        "VALUES ('" + terminal.getIdRestaurante() +
                        "','" + terminal.getNombre() +
                        "','" + terminal.getTipoComida() +
                        "'," + terminal.getPrecioMedio() +
                        "," + terminal.getPuntuacion() +
                        "," + terminal.getTiempoMedio() +
                        ","  + terminal.getOfertaActual() + ")";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
    public void actualizarRestaurante(String idRestaurante, Restaurante terminal) throws SQLException{
        String update = "update RESTAURANTES set idRestaurante='" + terminal.getIdRestaurante() + 
        				"', nombre='" + terminal.getNombre() +
        				"', tipoComida='" + terminal.getTipoComida() +
        				"', precioMedio=" + terminal.getPrecioMedio() +
        				", puntuacion=" + terminal.getPuntuacion() +
        				", tiempoMedio=" + terminal.getTiempoMedio() +
        				", ofertaActual=" + terminal.getOfertaActual() +
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
