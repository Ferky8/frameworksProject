package pr.justeat.struts2;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.PedidoDAO;
import pr.justeat.dao.dto.Cliente;
import pr.justeat.dao.dto.Pedido;

public class ClienteAction extends ActionSupport implements Preparable {

	private Log logger = LogFactory.getLog(this.getClass());

	private Cliente cliente = null;
	private String dni;
	
	public Cliente getCliente() {
        return this.cliente;
    }
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void prepare() throws Exception {
		GestorBD gbd = new GestorBD();
		gbd.conectar();
		this.cliente = gbd.obtenerCliente(dni);
		gbd.desconectar();
	}
	
}
