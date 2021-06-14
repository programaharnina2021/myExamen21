package modelo;

import java.io.Serializable;

public class Articulo implements Serializable, Indicable<Integer>{
	private int id;
	private String nombre;
	private float precio;

	
	
	public Articulo(int id, String nombre, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public Integer getKey() {
		return this.id;
	}

	@Override
	public void setKey(Integer t) {
		this.id=t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return this.getNombre()+" con precio "+String.valueOf(this.getPrecio());
	}
	
}
