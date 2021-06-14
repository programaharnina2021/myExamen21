package control;

import java.util.ArrayList;

import dao.base.DAOMultiObjetosGenerica;
import dao.concretas.DaoLista;
import dao.concretas.DaoUnitario;
import dao.serializado.GrabadorSerializado;
import dao.serializado.RecuperadorIndexadoSerializado;
import modelo.Articulo;
import modelo.Habitacion;
import modelo.Pedido;
import utiles.CreadorArticulos;
import utiles.CreadorHabitaciones;

public class Facade {
	public DaoLista<ArrayList<Habitacion>, Habitacion, Integer> daoHabitaciones = new DaoLista<>("habitacion.hab",
			new CreadorHabitaciones().getHabitaciones());
	public DaoLista<ArrayList<Articulo>, Articulo, Integer> daoArticulos = new DaoLista<>("articulos.rt",
			new CreadorArticulos().getArticulos());
	public DaoUnitario<Pedido, Integer> daoPedido;
	String extension = "ped";

	public void grabarPedidoActual(int habitacion, ArrayList<Articulo> articulos) {
		String string = String.valueOf(habitacion) + extension;
		daoPedido = new DaoUnitario<>(string, new DAOMultiObjetosGenerica<>(string, new GrabadorSerializado<>(),
				new RecuperadorIndexadoSerializado<>()));
		int ultimo = getUltimoPedido();
		daoPedido.add(new Pedido(ultimo + 1, articulos));
	}

	private int getUltimoPedido() {
		daoPedido.get(0);
		return 0;
	}

}
