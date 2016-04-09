package pr.justeat.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.NotFoundException;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Pedido;

public class ClienteResource {
	
	private String dni;
	
	public ClienteResource(String dni) throws SQLException {
		this.dni = dni;
		if(GestorBD.getInstance().obtenerCliente(dni) == null) throw new NotFoundException("Get: Cliente with " + dni +  " not found");
	}
			
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Cliente getCliente() throws SQLException {
		Cliente cliente = GestorBD.getInstance().obtenerCliente(dni);
		return cliente;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putCliente(@Context UriInfo uriInfo, Cliente cliente) throws SQLException {
		Response res;
		if (!dni.equals(cliente.getDni())){
			res = Response.status(409).entity("Put: Cliente with " + cliente.getDni() +  " does not match with current cliente").build();
		}else{
			res = Response.noContent().build(); // Code: 204
			GestorBD.getInstance().actualizarCliente(dni, cliente);
		}
		return res;
	}
	
	@DELETE
	public void deleteCliente() throws SQLException {
		GestorBD.getInstance().borrarCliente(dni);
	}
		
	@GET
	@Path("pedidos")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Pedido> pedidos() throws SQLException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.addAll( GestorBD.getInstance().obtenerPedidosCliente(dni) );
		return pedidos; 
	}
}
