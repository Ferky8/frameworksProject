package pr.justeat.dao.test;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import pr.justeat.dao.dto.Cliente;

public class TestREST {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		
		// Get XML for application
		try{
			Cliente[] array = service.path("rest").path("clientes").accept(MediaType.APPLICATION_XML).get(Cliente[].class);
			System.out.println("clientes.GET('application/xml').results (con un ARRAY): ");
			for(int i=0;i<array.length;i++) System.out.println(array[i].getDni() + "\t" + array[i].getNombre());	
		}catch(UniformInterfaceException e){ // if code != 20x exception is thrown
			ClientResponse r = e.getResponse();
			System.out.println("clientes.GET('application/xml').status: " + r.getStatus());
			System.out.println("clientes.GET('application/xml').entity: " + r.getEntity(String.class));
		}

		// POST
		Cliente cliente = new Cliente("444", "Prueba prueba", "Calle YYY, Portugalete", "prueba@deusto.es" );
		// TYPE is the type of content consumes by the service/method
		// ACCEPT is the type of content returned by the service/method
		// PUT is the type of operation invoked. The first param is the content returned and the second one the values received.
		ClientResponse cr1 = service.path("rest").path("clientes").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, cliente);
		if (cr1.getStatus() == 201){ // Return code should be 201 == created resource
			System.out.println("clientes.POST('application/xml').status: " + cr1.getStatus());
			System.out.println("clientes.POST('application/xml').location: " + cr1.getLocation());
			
		}else{ // Or code 409 == resource already exists 
			System.out.println("clientes.POST('application/xml').status: " + cr1.getStatus());
			System.out.println("clientes.POST('application/xml').entity: " + cr1.getEntity(String.class));
		}
		
		// POST (with error)
		try{
			Cliente cliente2 = new Cliente("444", "Prueba prueba", "Calle YYY, Portugalete", "prueba@deusto.es" );
			service.path("rest").path("clientes").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(cliente2);
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clientes.POST('application/xml').status: " + r.getStatus());
			System.out.println("clientes.POST('application/xml').entity: " + r.getEntity(String.class));
		}

		// PUT
		Cliente cliente3 = new Cliente("444", "Prueba2", "Calle YYY, Portugalete", "prueba@deusto.es" );
		ClientResponse cr3 = service.path("rest").path("clientes").path(cliente3.getDni()).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, cliente3);
		if (cr3.getStatus() == 201){
			System.out.println("clientes.{id}.PUT('application/xml').status: " + cr3.getStatus());
			System.out.println("clientes.{id}.PUT('application/xml').location: " + cr3.getLocation());
		}else if (cr3.getStatus() == 204){
				System.out.println("clientes.{id}.PUT('application/xml').status: " + cr3.getStatus());
		}else{
			System.out.println("clientes.{id}.PUT('application/xml').status: " + cr3.getStatus());
			System.out.println("clientes.{id}.PUT('application/xml').entity: " + cr3.getEntity(String.class));
		}

		// Get JSON for application		
		ClientResponse cr4 = service.path("rest").path("clientes").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (cr4.getStatus() == 200){
			System.out.println("clientes.GET('application/json').status: " + cr4.getStatus());
			System.out.println("clientes.GET('application/json').results (con una LIST): ");
			List<Cliente> lista = cr4.getEntity(new GenericType<List<Cliente>>(){}); 
			for(int i=0;i<lista.size();i++) System.out.println(lista.get(i).getDni() + "\t" + lista.get(i).getNombre());			
		}else{
			System.out.println("clientes.GET('application/json').status: " + cr4.getStatus());
			System.out.println("clientes.GET('application/json').entity: " + cr4.getEntity(String.class));
		}
		
		// DELETE
		try{
			service.path("rest").path("clientes").path("3").delete();
			System.out.println("Cliente 3 deleted");
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clientes.{id}.DEL.status: " + r.getStatus());
			System.out.println("clientes.{id}.DEL.entity: " + r.getEntity(String.class));
		}		
	
		try{
			// Get JSON for application
			System.out.println("clientes.GET('application/json').results (directamente imprimiendo): ");
			System.out.println(service.path("rest").path("clientes").accept(MediaType.APPLICATION_JSON).get(String.class));
			// Get the summary of Cliente with id 1
			//System.out.println(service.path("rest").path("clientes").path("1").path("summary").queryParam("param", "nada").accept(MediaType.TEXT_PLAIN).get(String.class));		
		}catch(UniformInterfaceException e){
			ClientResponse r = e.getResponse();
			System.out.println("clientes.GET.status: " + r.getStatus());
			System.out.println("clientes.GET.entity: " + r.getEntity(String.class));
		}	
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/mdiss.justeat.dao").build();
	}
}
