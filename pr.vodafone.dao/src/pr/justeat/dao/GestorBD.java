package pr.justeat.dao;

import java.sql.*;

import java.util.Vector;

import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Factura;
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
        Pedido linea = null;
    	String select = "select * from LINEAS where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	linea = new Pedido();
        	linea.setRestaurante(rs.getString("restaurante"));
        	linea.setFecha(rs.getString("fecha"));
        	linea.setEntregado(rs.getBoolean("entregado"));
        	linea.setTipoEntrega(rs.getString("tipoEntrega"));
        	linea.setTipoPago(rs.getString("tipoPago"));
        	linea.setPromocion(rs.getString("promocion"));
        	linea.setDni(rs.getString("dni"));
        }
        rs.close();
        stmt.close();  
        return linea;
    }
    
    public Vector<Pedido> obtenerPedidos() throws SQLException{        
        Vector<Pedido> lineas = new Vector<Pedido>();
    	String select = "select * from LINEAS order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido linea = new Pedido();
        	linea.setRestaurante(rs.getString("restaurante"));
        	linea.setFecha(rs.getString("fecha"));
        	linea.setEntregado(rs.getBoolean("entregado"));
        	linea.setTipoEntrega(rs.getString("tipoEntrega"));
        	linea.setTipoPago(rs.getString("tipoPago"));
        	linea.setPromocion(rs.getString("promocion"));
        	linea.setDni(rs.getString("dni"));
        	lineas.add(linea);
        }
        rs.close();
        stmt.close();  
        return lineas;
    }
    
    public Vector<Pedido> obtenerPedidosEntregados(boolean entregado) throws SQLException{        
        Vector<Pedido> lineas = new Vector<Pedido>();
    	String select = "select * from LINEAS where entregado=" + entregado + " order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido linea = new Pedido();
        	linea.setRestaurante(rs.getString("restaurante"));
        	linea.setFecha(rs.getString("fecha"));
        	linea.setEntregado(rs.getBoolean("entregado"));
        	linea.setTipoEntrega(rs.getString("tipoEntrega"));
        	linea.setTipoPago(rs.getString("tipoPago"));
        	linea.setPromocion(rs.getString("promocion"));
        	linea.setDni(rs.getString("dni"));
        	lineas.add(linea);
        }
        rs.close();
        stmt.close();  
        return lineas;
    }
    
    public Vector<Pedido> obtenerPedidosCliente(String dni) throws SQLException{        
        Vector<Pedido> lineas = new Vector<Pedido>();
    	String select = "select * from LINEAS where dni='" + dni + "' order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido linea = new Pedido();
        	linea.setRestaurante(rs.getString("restaurante"));
        	linea.setFecha(rs.getString("fecha"));
        	linea.setEntregado(rs.getBoolean("entregado"));
        	linea.setTipoEntrega(rs.getString("tipoEntrega"));
        	linea.setTipoPago(rs.getString("tipoPago"));
        	linea.setPromocion(rs.getString("promocion"));
        	linea.setDni(rs.getString("dni"));
        	lineas.add(linea);
        }
        rs.close();
        stmt.close();  
        return lineas;
    }
    
    public Vector<Pedido> obtenerPedidosEntregadosCliente(String dni, boolean entregado) throws SQLException{        
        Vector<Pedido> lineas = new Vector<Pedido>();
    	String select = "select * from LINEAS where dni='" + dni + "' AND entregado=" + entregado + " order by fecha";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Pedido linea = new Pedido();
        	linea.setRestaurante(rs.getString("restaurante"));
        	linea.setFecha(rs.getString("fecha"));
        	linea.setEntregado(rs.getBoolean("entregado"));
        	linea.setTipoEntrega(rs.getString("tipoEntrega"));
        	linea.setTipoPago(rs.getString("tipoPago"));
        	linea.setPromocion(rs.getString("promocion"));
        	linea.setDni(rs.getString("dni"));
        	lineas.add(linea);
        }
        rs.close();
        stmt.close();  
        return lineas;
    }
    
    public void insertarPedido(Pedido linea) throws SQLException{
        String insert = "insert into LINEAS " +
                        "(restaurante, fecha, entregado, tipoEntrega, tipoPago, promocion, dni) " +
                        "VALUES ('" + linea.getRestaurante() +
                        "','" + linea.getFecha() +
                        "'," + linea.isEntregado() +
                        ",'" + linea.getTipoEntrega() +
                        "','" + linea.getTipoPago() +
                        "','" + linea.getPromocion() +
                        "','"  + linea.getDni() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();        
    }
    
    public void actualizarPedido(String restaurante, Pedido linea) throws SQLException{
        String update = "update LINEAS set restaurante='" + linea.getRestaurante() + 
        				"', fecha='" + linea.getFecha() +
        				"', entregado=" + linea.isEntregado() +
        				", tipoEntrega='" + linea.getTipoEntrega() +
        				"', tipoPago='" + linea.getTipoPago() +
        				"', promocion='" + linea.getPromocion() +
        				"', dni='" + linea.getDni() +
        				"' where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void entregadorPedido(String restaurante, boolean entregado) throws SQLException{
        String update = "update LINEAS set entregado=" + entregado + " where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarPedido(String restaurante) throws SQLException{
       	String delete = "delete from LINEAS where restaurante='" + restaurante + "'";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarPedidos() throws SQLException{
       	String delete = "delete from LINEAS";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarPedidos() throws SQLException{
    	String count = "select count(*) from LINEAS";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(count);
        rs.next();
        int numFilas = rs.getInt(1);
        rs.close();
        stmt.close();      
        return numFilas;
    }

    public Factura obtenerFactura(int idFactura) throws SQLException{        
        Factura factura = null;
    	String select = "select * from FACTURAS where idFactura=" + idFactura;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()){
        	factura = new Factura();
        	factura.setIdFactura(rs.getInt("idFactura"));
        	factura.setFecha(rs.getString("fecha"));
        	factura.setPeriodo(rs.getString("periodo"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setTelefono(rs.getString("telefono"));
        }
        rs.close();
        stmt.close();  
        return factura;
    }    
    public Vector<Factura> obtenerFacturas() throws SQLException{        
        Vector<Factura> facturas = new Vector<Factura>();
    	String select = "select * from FACTURAS order by fecha desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Factura factura = new Factura();
        	factura.setIdFactura(rs.getInt("idFactura"));
        	factura.setFecha(rs.getString("fecha"));
        	factura.setPeriodo(rs.getString("periodo"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setTelefono(rs.getString("telefono"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }    
    public Vector<Factura> obtenerFacturasLinea(String telefono) throws SQLException{        
        Vector<Factura> facturas = new Vector<Factura>();
    	String select = "select * from FACTURAS where telefono='" + telefono + "' order by fecha desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Factura factura = new Factura();
        	factura.setIdFactura(rs.getInt("idFactura"));
        	factura.setFecha(rs.getString("fecha"));
        	factura.setPeriodo(rs.getString("periodo"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setTelefono(rs.getString("telefono"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }

    public Vector<Factura> obtenerFacturasCliente(String dni) throws SQLException{        
        Vector<Factura> facturas = new Vector<Factura>();
    	String select = "select * from FACTURAS as F, LINEAS as L where f.telefono=l.telefono and l.dni='" + dni + "' order by f.telefono, f.fecha desc";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()){
        	Factura factura = new Factura();
        	factura.setIdFactura(rs.getInt("idFactura"));
        	factura.setFecha(rs.getString("fecha"));
        	factura.setPeriodo(rs.getString("periodo"));
        	factura.setImporte(rs.getFloat("importe"));
        	factura.setTelefono(rs.getString("telefono"));
        	facturas.add(factura);
        }
        rs.close();
        stmt.close();  
        return facturas;
    }
    
    public int insertarFactura(Factura factura) throws SQLException{
        String insert = "insert into FACTURAS " +
                        "(fecha, periodo, importe, telefono) " +
                        "VALUES ('" + factura.getFecha() +
                        "','" + factura.getPeriodo() +
                        "'," + factura.getImporte() +
                        ",'"  + factura.getTelefono() + "')";                        
        Statement stmt = con.createStatement();
        stmt.executeUpdate(insert);
        stmt.close();
        
        String max = "select MAX(idFactura) as id from FACTURAS";
        Statement stmt1 = con.createStatement();
        ResultSet rs = stmt1.executeQuery(max);
        int id = 0;
        if (rs.next()){
        	id = rs.getInt("id");
        }
        stmt1.close();
        factura.setIdFactura(id);
        return id;
    }
    
    public void actualizarFactura(int idFactura, Factura factura) throws SQLException{
        String update = "update FACTURAS set idFactura=" + factura.getIdFactura() + 
        				", fecha='" + factura.getFecha() +
        				"', periodo='" + factura.getPeriodo() +
        				"', importe=" + factura.getImporte() +
        				", telefono='" + factura.getTelefono() +
        				"' where idFactura=" + idFactura;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(update);
        stmt.close();                
    }
    
    public void borrarFactura(int idFactura) throws SQLException{
       	String delete = "delete from FACTURAS where idFactura=" + idFactura;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public void borrarFacturas() throws SQLException{
       	String delete = "delete from FACTURAS";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(delete);
        stmt.close();	                  
    }

    public int contarFacturas() throws SQLException{
    	String count = "select count(*) from FACTURAS";
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
