package dao.concretas;

import dao.base.DAOMultiObjetosGenerica;

public class DaoUnitario<T, K> {
	private String path;
	private DAOMultiObjetosGenerica<T, K> daoArchivo;

	public DaoUnitario(String path,DAOMultiObjetosGenerica<T, K> daoArchivo) {
		super();
		this.path = path;
		this.daoArchivo = daoArchivo;
	}

	public boolean add(T t) {
		return daoArchivo.graba(t);
	}

	public T buscar(K k) {
		return (T) daoArchivo.recupera(k);
	}

	public T get(int posicion) {
		return (T) daoArchivo.recupera(posicion);
	}

}
