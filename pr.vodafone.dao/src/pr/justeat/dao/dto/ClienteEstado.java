package pr.justeat.dao.dto;

public class ClienteEstado {
	String dni;
	boolean entregado;
	
	public ClienteEstado(String dni, boolean entregado) {
		this.dni = dni;
		this.entregado = entregado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
}
