package modelo;

public class Bebida extends Articulo {

	boolean alcoholica;
	
	public Bebida(int id, String nombre, float precio, boolean alcoholica) {
		super(id, nombre, precio);
		this.alcoholica = alcoholica;
	}

	public boolean isAlcoholica() {
		return alcoholica;
	}

	public void setAlcoholica(boolean alcoholica) {
		this.alcoholica = alcoholica;
	}

	@Override
	public String toString() {
		if (alcoholica) {
			return super.toString()+" y que tiene alcohol";			
		}else {
			return super.toString()+" y que no tiene alcohol";	
		}
	}
	
}
