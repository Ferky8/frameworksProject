package pr.justeat.dao.dto;

public class PedidoEstado {
	int idPedido;
	boolean entregado;
	
	public PedidoEstado(int idPedido, boolean entregado) {
		this.idPedido = idPedido;
		this.entregado = entregado;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	
}
