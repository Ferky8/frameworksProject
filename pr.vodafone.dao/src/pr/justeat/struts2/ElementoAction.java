package pr.justeat.struts2;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import pr.justeat.dao.ElementoDAO;
import pr.justeat.dao.dto.Elemento;

public class ElementoAction extends ActionSupport implements Preparable {

	private Log logger = LogFactory.getLog(this.getClass());

	private List<Elemento> elementos = null;
	private int idPedido;
	private ElementoDAO elementoDAO = new ElementoDAO();
	
	public List<Elemento> getElementos() {
        return this.elementos;
    }
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public void prepare() throws Exception {
		this.elementos = elementoDAO.getElementosByPedido(idPedido);
	}	
}
