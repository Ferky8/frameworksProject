package pr.justeat.struts2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import pr.justeat.dao.ClienteDAO;
import pr.justeat.dao.dto.Cliente;

public class ClienteAction extends ActionSupport implements Preparable {

	private Log logger = LogFactory.getLog(this.getClass());

	private Cliente cliente = null;
	private String dni;
	private ClienteDAO clienteDAO = new ClienteDAO();
	
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
		this.cliente = clienteDAO.getCliente(dni);
	}
	
}
