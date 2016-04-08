package pr.justeat.resources;

import java.net.URI;
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

import pr.justeat.dao.dto.Cliente;


// Will map the resource to the URL todos
@Path("/todos")
public class ClientesResource {
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	// Return the list of todos for applications
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Cliente> getTodos() {
		List<Cliente> todos = new ArrayList<Cliente>();
		todos.addAll( TodoDao.instance().getModel().values() );
		return todos; 
	}
	
	// returns the number of todos
	// Use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = TodoDao.instance().getModel().size();
		return String.valueOf(count);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response newCliente(Cliente cliente) {
		Response res;
		if(TodoDao.instance().getModel().containsKey(cliente.getId())) {
			res = Response.status(409).entity("Post: Cliente with " + cliente.getId() +  " already exists").build();
		}else{
			URI uri = uriInfo.getAbsolutePathBuilder().path(cliente.getId()).build();
			res = Response.created(uri).entity(cliente).build(); // Code: 201
			TodoDao.instance().getModel().put(cliente.getId(), cliente);
		}		
		return res;
	}
	
	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{cliente}")
	public ClienteResource getCliente(
			@PathParam("cliente") String id) {
		return new ClienteResource(id);
	}
}
