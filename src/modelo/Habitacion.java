package modelo;

import java.io.Serializable;

public class Habitacion implements Serializable, Indicable<Integer> {

	private int id;
	private boolean ocupada;

	public Habitacion(int id, boolean ocupada) {
		super();
		this.id = id;
		this.ocupada = ocupada;
	}

	public int getId() {
		return id;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (ocupada ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public Integer getKey() {
		return id;
	}

	@Override
	public void setKey(Integer t) {
		this.id=(int) t;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", ocupada=" + ocupada + "]";
	}


}
