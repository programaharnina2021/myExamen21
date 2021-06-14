package utiles;

public class DatadorArticulos {
	// Aqui os doy la relacion de los veinte articulos
	// id del 1 al 20
	public String nombre[] = { "Hamburguesa", "Sushi", "Croqueta", "Falafel", "Langosta", "Filete", "Merluza", "pulpo",
			"Pollo", "Lechuga", "Cerveza", "Tonica", "Cola", "Vermu", "Vino", "Agua", "Mosto", "Zumo", "Aperol",
			"Sidra" };
	public float precios[] = { 9, 8, 2.5f, 6.3f, 18, 9.5f, 10, 14.5f, 5, 2, 1.5f, 2, 2, 2.5f, 4.5f, 0.5f, 1.5f, 2, 5.4f,
			2.3f };
	// los diez primeros son alimentos y los diez ultimos bebidas
	// Temperaturas de los diez primeros
	public Temperatura temperatura[] = { Temperatura.caliente, Temperatura.frio, Temperatura.caliente, Temperatura.caliente,
			Temperatura.templado, Temperatura.caliente, Temperatura.caliente, Temperatura.frio, Temperatura.templado,
			Temperatura.frio };
	public boolean alcocholicas[] = { true, false, false, true, true, false, false, false, false, true };

}
