package utiles;

import java.util.ArrayList;

import modelo.Articulo;
import modelo.Bebida;
import modelo.Comida;

public class CreadorArticulos {
	ArrayList<Articulo> articulos = new ArrayList<Articulo>();

	public CreadorArticulos() {
		super();
		DatadorArticulos d = new DatadorArticulos();
		for (int i = 0; i < d.nombre.length / 2; i++) {
			articulos.add(new Comida(i, d.nombre[i], d.precios[i], d.temperatura[i]));
			articulos.add(new Bebida(i + 10, d.nombre[i + 10], d.precios[i+10], d.alcocholicas[i]));
		}
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

}
