package pr.justeat.dao.dto;

public class Pedido {
	private String restaurante;
	private String fecha;
	private boolean entregado;
	private String tipoEntrega;
	private String tipoPago;
	private String promocion;
	private String dni;

	public Pedido(){
		super();
	}
	public Pedido(String restaurante, String fecha, boolean entregado,
			String tipoEntrega, String tipoPago, String promocion, String dni) {
		super();
		this.restaurante = restaurante;
		this.fecha = fecha;
		this.entregado = entregado;
		this.tipoEntrega = tipoEntrega;
		this.tipoPago = tipoPago;
		this.promocion = promocion;
		this.dni = dni;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public String getTipoEntrega() {
		return tipoEntrega;
	}
	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public String getPromocion() {
		return promocion;
	}
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
