package pr.justeat.struts2;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import pr.justeat.dao.GestorBD;
import pr.justeat.dao.PedidoDAO;
import pr.justeat.dao.dto.Pedido;

public class PedidoAction extends ActionSupport implements Preparable {

	private Log logger = LogFactory.getLog(this.getClass());

	private List<Pedido> pedidos = null;
	private Pedido selectedPedido = null;
	private String username;
	//private PedidoDAO pedidoDAO = new PedidoDAO();
	
	public void setSelectedPedido(Pedido pedido) {
		this.selectedPedido = pedido;
	}
	
	public Pedido getSelectedPedido() {
		return selectedPedido;
	}
	
	public List<Pedido> getPedidos() {
        return this.pedidos;
    }
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void prepare() throws Exception {
		
	}
	
	public String doListing() throws Exception {
		//this.pedidos = pedidoDAO.getPedidosByCliente("111");
		GestorBD gbd = new GestorBD();
		gbd.conectar();
		this.pedidos = gbd.obtenerPedidosRestaurante(this.username);
		gbd.desconectar();
		
		return SUCCESS;
	}
	
	public String doSelectPedido() throws Exception {
		//pedidoDAO.setPedidoEntregado(selectedPedido.getIdPedido(), true);
		GestorBD gbd = new GestorBD();
		gbd.conectar();
		Pedido pedido = gbd.obtenerPedido(selectedPedido.getIdPedido());
		gbd.entregarPedido(pedido.getIdPedido(), !pedido.isEntregado());
		this.pedidos = gbd.obtenerPedidosRestaurante(this.username);
		gbd.desconectar();
		
		return SUCCESS;
	}
	
}
