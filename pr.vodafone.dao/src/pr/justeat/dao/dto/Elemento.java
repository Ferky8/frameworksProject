package pr.justeat.dao.dto;

public class Elemento {
	private int idElemento;
	private int cantidad;
	private String nombre;
	private float importe;
	private String pedido;
	
	public Elemento(){
		super();
	}
	public Elemento(int cantidad, String nombre, float importe,
			String pedido) {
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.importe = importe;
		this.pedido = pedido;
	}
	public Elemento(int idElemento, int cantidad, String nombre, float importe,
			String pedido) {
		super();
		this.idElemento = idElemento;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.importe = importe;
		this.pedido = pedido;
	}
	public int getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

}
