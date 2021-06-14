package utiles;

import java.util.ArrayList;

import modelo.Habitacion;

public class CreadorHabitaciones {
	boolean ocupadas[] = { true, true, false, false, true, false, true, true, true, false };
	ArrayList<Habitacion> habitaciones=new ArrayList<>();

	public CreadorHabitaciones() {
		super();
		for (int i = 0; i < ocupadas.length; i++) {
				habitaciones.add(new Habitacion(i, ocupadas[i]));
			}
	}
	
	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones; 
	}
}
