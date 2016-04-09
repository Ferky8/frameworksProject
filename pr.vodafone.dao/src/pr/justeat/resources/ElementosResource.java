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
import pr.justeat.dao.dto.Elemento;


// Will map the resource to the URL todos
@Path("/elementos")
public class ElementosResource {
	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	// Return the list of todos for applications
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Elemento> getElementos() throws SQLException {
		List<Elemento> elementos = new ArrayList<Elemento>();
		elementos.addAll( GestorBD.getInstance().obtenerElementos() );
		return elementos; 
	}
	
	// returns the number of todos
	// Use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() throws SQLException {
		int count = GestorBD.getInstance().contarElementos();
		return String.valueOf(count);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response newElemento(Elemento elemento) throws SQLException {
		Response res;
		if(GestorBD.getInstance().obtenerElemento(elemento.getIdElemento()) != null) {
			res = Response.status(409).entity("Post: Elemento with " + elemento.getIdElemento() +  " already exists").build();
		}else{
			URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(elemento.getIdElemento())).build();
			res = Response.created(uri).entity(elemento).build(); // Code: 201
			GestorBD.getInstance().insertarElemento(elemento);;
		}		
		return res;
	}
	
	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{elemento}")
	public ElementoResource getElemento(
			@PathParam("elemento") int id) throws SQLException {
		return new ElementoResource(id);
	}
}
