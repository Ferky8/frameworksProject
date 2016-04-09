package pr.justeat.resources;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.dto.Pedido;


// Will map the resource to the URL todos
@Path("/pedidos")
public class PedidosResource {
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	// Return the list of todos for applications
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Pedido> getPedidos() throws SQLException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.addAll( GestorBD.getInstance().obtenerPedidos() );
		return pedidos; 
	}
	
	// returns the number of todos
	// Use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() throws SQLException {
		int count = GestorBD.getInstance().contarPedidos();
		return String.valueOf(count);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response newPedido(Pedido pedido) throws SQLException {
		Response res;
		if(GestorBD.getInstance().obtenerPedido(pedido.getIdPedido()) != null) {
			res = Response.status(409).entity("Post: Pedido with " + pedido.getIdPedido() +  " already exists").build();
		}else{
			URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(pedido.getIdPedido())).build();
			res = Response.created(uri).entity(pedido).build(); // Code: 201
			GestorBD.getInstance().insertarPedido(pedido);;
		}		
		return res;
	}
	
	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{pedido}")
	public PedidoResource getPedido(
			@PathParam("pedido") int id) throws SQLException {
		return new PedidoResource(id);
	}
}
