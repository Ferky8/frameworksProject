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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.NotFoundException;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.dto.Elemento;
import pr.justeat.dao.dto.Pedido;

public class PedidoResource {
	
	private int id;
	
	public PedidoResource(int id) throws SQLException {
		this.id = id;
		if(GestorBD.getInstance().obtenerPedido(id) == null) throw new NotFoundException("Get: Pedido with " + id +  " not found");
	}
			
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Pedido getPedido() throws SQLException {
		Pedido pedido = GestorBD.getInstance().obtenerPedido(id);
		return pedido;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putPedido(@Context UriInfo uriInfo, Pedido pedido) throws SQLException {
		Response res;
		if (id != (pedido.getIdPedido())){
			res = Response.status(409).entity("Put: Pedido with " + pedido.getIdPedido() +  " does not match with current pedido").build();
		}else{
			res = Response.noContent().build(); // Code: 204
			GestorBD.getInstance().actualizarPedido(id, pedido);
		}
		return res;
	}
	
	@DELETE
	public void deletePedido() throws SQLException {
		GestorBD.getInstance().borrarPedido(id);
	}
		
	@GET
	@Path("elementos")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Elemento> pedidos() throws SQLException {
		List<Elemento> elementos = new ArrayList<Elemento>();
		elementos.addAll( GestorBD.getInstance().obtenerElementosPedido(id));
		return elementos; 
	}
}
