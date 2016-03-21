package pr.justeat.dao.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Restaurante {
	private String idRestaurante;
	private String nombre;
	private String tipoComida;
	private float precioMedio;
	private float puntuacion;
	private float tiempoMedio;
	private float ofertaActual;
	
	
	public Restaurante() {
		
	}

	public Restaurante(String idRestaurante, String nombre, String tipoComida, float precioMedio,
			float puntuacion, float tiempoMedio, float ofertaActual) {
		
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
	
	@XmlElement
	public void setIdRestaurante(String idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipoComida() {
		return tipoComida;
	}
	
	@XmlElement
	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}
	
	public float getPrecioMedio() {
		return precioMedio;
	}
	
	@XmlElement
	public void setPrecioMedio(float precioMedio) {
		this.precioMedio = precioMedio;
	}
	
	public float getPuntuacion() {
		return puntuacion;
	}
	
	@XmlElement
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public float getTiempoMedio() {
		return tiempoMedio;
	}
	
	@XmlElement
	public void setTiempoMedio(float tiempoMedio) {
		this.tiempoMedio = tiempoMedio;
	}
	
	public float getOfertaActual() {
		return ofertaActual;
	}
	
	@XmlElement
	public void setOfertaActual(float ofertaActual) {
		this.ofertaActual = ofertaActual;
	}
}
