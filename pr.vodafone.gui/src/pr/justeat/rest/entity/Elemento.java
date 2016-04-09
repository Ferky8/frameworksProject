package pr.justeat.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Elemento {
	private int idElemento;
	private int cantidad;
	private String nombre;
	private float importe;
	private int pedido;
	
	public Elemento(){
		
	}
	public Elemento(int cantidad, String nombre, float importe,
			int pedido) {
		
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.importe = importe;
		this.pedido = pedido;
	}
	public Elemento(int idElemento, int cantidad, String nombre, float importe,
			int pedido) {
		
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
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

}
