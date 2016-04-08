package pr.justeat.resources;

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

import pr.justeat.dao.dto.Cliente;

public class ClienteResource {
	
	private String id;
	
	public ClienteResource(String id) {
		this.id = id;
		if(!TodoDao.instance().getModel().containsKey(id)) throw new NotFoundException("Get: Todo with " + id +  " not found");
	}
			
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Cliente getTodo() {
		Cliente cliente = TodoDao.instance().getModel().get(id);
		return cliente;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putTodo(@Context UriInfo uriInfo, Cliente cliente) {
		Response res;
		if (!id.equals(cliente.getId())){
			res = Response.status(409).entity("Put: Todo with " + cliente.getId() +  " does not match with current todo").build();
		}else{
			res = Response.noContent().build(); // Code: 204
			TodoDao.instance().getModel().put(cliente.getId(), cliente);
		}
		return res;
	}
	
	@DELETE
	public void deleteTodo() {
		TodoDao.instance().getModel().remove(id);
	}
		
	@GET
	@Path("summary")
	@Produces(MediaType.TEXT_PLAIN)
	public String summary(@QueryParam("param") String param) {
		Cliente cliente = TodoDao.instance().getModel().get(id);
		return cliente.getSummary() + " y el parametro recibido (" + param + ")";
	}
}
