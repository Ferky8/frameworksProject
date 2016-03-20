package pr.justeat.dao.dto;

public class Restaurante {
	private String idRestaurante;
	private String nombre;
	private String tipoComida;
	private float precioMedio;
	private float puntuacion;
	private float tiempoMedio;
	private float ofertaActual;
	
	public Restaurante() {
		super();
	}
	public Restaurante(String idRestaurante, String nombre, String tipoComida, float precioMedio,
			float puntuacion, float tiempoMedio, float ofertaActual) {
		super();
		this.idRestaurante = idRestaurante;
		this.nombre = nombre;
		this.tipoComida = tipoComida;
		this.precioMedio = precioMedio;
		this.puntuacion = puntuacion;
		this.tiempoMedio = tiempoMedio;
		this.ofertaActual = ofertaActual;
	}
	public String getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoComida() {
		return tipoComida;
	}
	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}
	public float getPrecioMedio() {
		return precioMedio;
	}
	public void setPrecioMedio(float precioMedio) {
		this.precioMedio = precioMedio;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
	public float getTiempoMedio() {
		return tiempoMedio;
	}
	public void setTiempoMedio(float tiempoMedio) {
		this.tiempoMedio = tiempoMedio;
	}
	public float getOfertaActual() {
		return ofertaActual;
	}
	public void setOfertaActual(float ofertaActual) {
		this.ofertaActual = ofertaActual;
	}
}
