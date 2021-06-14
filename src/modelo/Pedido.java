package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Indicable<Integer>,Serializable{
	int id;
	ArrayList<Articulo> articulosSolicitados;
	
	
	public Pedido(int id, ArrayList<Articulo> articulosSolicitados) {
		super();
		this.id = id;
		this.articulosSolicitados = articulosSolicitados;
	}
	
	public void addArticulo(Articulo articulo) {
		this.articulosSolicitados.add(articulo);
	}

	@Override
	public Integer getKey() {
		return this.id;
	}

	@Override
	public void setKey(Integer t) {
		this.id = t;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Articulo> getArticulosSolicitados() {
		return articulosSolicitados;
	}

	public void setArticulosSolicitados(ArrayList<Articulo> articulosSolicitados) {
		this.articulosSolicitados = articulosSolicitados;
	}
	
}
