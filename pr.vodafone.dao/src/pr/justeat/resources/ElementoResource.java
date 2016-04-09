package pr.justeat.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.NotFoundException;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.dto.Elemento;

public class ElementoResource {
	
	private int id;
	
	public ElementoResource(int id) throws SQLException {
		this.id = id;
		if(GestorBD.getInstance().obtenerElemento(id) == null) throw new NotFoundException("Get: Elemento with " + id +  " not found");
	}
			
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Elemento getElemento() throws SQLException {
		Elemento elemento = GestorBD.getInstance().obtenerElemento(id);
		return elemento;
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response putElemento(@Context UriInfo uriInfo, Elemento elemento) throws SQLException {
		Response res;
		if (id != (elemento.getIdElemento())){
			res = Response.status(409).entity("Put: Elemento with " + elemento.getIdElemento() +  " does not match with current elemento").build();
		}else{
			res = Response.noContent().build(); // Code: 204
			GestorBD.getInstance().actualizarElemento(id, elemento);
		}
		return res;
	}
	
	@DELETE
	public void deleteElemento() throws SQLException {
		GestorBD.getInstance().borrarElemento(id);
	}
}
