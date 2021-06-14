package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import modelo.Articulo;
import modelo.Habitacion;
import modelo.Pedido;
import vista.UI;

public class ParaUI extends UI {
	Facade facade;
	ArrayList<Articulo> solicitados = new ArrayList<>();

	public ParaUI() {
		facade = new Facade();
		addPanelAltaEvents();
		addPanelConsultaEvents();
	}

	private void addPanelAltaEvents() {
		getJtxtHabitacionAlta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarHabitacion();
			}
		});
		getBtnCancelarAlta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTodo();
				solicitados = new ArrayList<>();
			}
		});
		getJtxtArticuloAlta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anhadirArticulo();
			}
		});
		getJtxtHabitacionAlta().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarTodo();
				solicitados = new ArrayList<>();
			}
		});

		getBtnFinalizarPedidoAlta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					facade.setPedidoPath(getJtxtHabitacionAlta().getText());
					facade.addPedido(new Pedido(facade.getUltimoPedido(), solicitados));
					limpiarTodo();
					getJtxtMensajeAlta().setText("Pedido realizado con exito");
				} catch (Exception e1) {
					limpiarTodo();
					getJtxtMensajeAlta().setText("Ha ocurrido un error, pedido cancelado");
				}
			}
		});

	}

	private void addPanelConsultaEvents() {
		getJtxtHabitacionConsulta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarPedido();
			}
		});

		getJtxtHabitacionConsulta().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!getJtAreaConsumicionesConsulta().getText().isEmpty()) {
					limpiarTodoConsulta();
				}
			}
		});
		getJtxtpedidoConsulta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarPedido();
			}
		});
	}

	private void limpiarTodo() {
		String cadena = "";
		getJtxtHabitacionAlta().setEditable(true);
		getJtxtHabitacionAlta().setFocusable(true);
		getJtAreaConsumicionesAlta().setText(cadena);
		getJtxtHabitacionAlta().setText(cadena);
		getJtxtArticuloAlta().setText(cadena);
		getJtxtMensajeAlta().setText(cadena);
		getLblTotalAlta().setText(cadena);

	}

	private void limpiarTodoConsulta() {
		String cadena = "";
		getJtxtHabitacionConsulta().setEditable(true);
		getJtxtHabitacionConsulta().setFocusable(true);
		getJtAreaConsumicionesConsulta().setText(cadena);
		getJtxtHabitacionConsulta().setText(cadena);
		getJtxtpedidoConsulta().setText(cadena);
		getJtxtMensajeConsulta().setText(cadena);

	}

	private void comprobarHabitacion() {
		Habitacion h;
		try {
			int idIntroducida = Integer.valueOf(getJtxtHabitacionAlta().getText());
			h = facade.getHabitacion(idIntroducida);
			if (h != null && h.isOcupada()) {
				getJtxtHabitacionAlta().setEditable(false);
				getJtxtHabitacionAlta().setFocusable(false);
			} else {
				getJtxtMensajeAlta().setText("Id de habitación incorrecto o habitación ocupada");
				getJtxtHabitacionAlta().setText("");
			}
		} catch (NumberFormatException e) {
			getJtxtMensajeAlta().setText("Valor incorrecto, introduzca un numero");
			getJtxtHabitacionAlta().setText("");
		}
	}

	private void comprobarPedido() {
		Habitacion h;
		try {
			int idIntroducida = Integer.valueOf(getJtxtHabitacionConsulta().getText());
			h = facade.getHabitacion(idIntroducida);
			if (h != null && h.isOcupada() && !getJtxtpedidoConsulta().getText().isEmpty()) {
				getPedidoConsulta();
			} else {
				getJtxtMensajeConsulta().setText("Id de habitación incorrecto o habitación ocupada");
				getJtxtHabitacionConsulta().setText("");
			}
		} catch (NumberFormatException e) {
			getJtxtMensajeConsulta().setText("Valor incorrecto, introduzca un numero");
			getJtxtHabitacionConsulta().setText("");
		}
	}

	private void anhadirArticulo() {
		Articulo a;
		try {
			int idIntroducida = Integer.valueOf(getJtxtArticuloAlta().getText());
			a = facade.getArticulo(idIntroducida);
			if (a != null) {
				getJtxtArticuloAlta().setText("");
				getJtAreaConsumicionesAlta().setText(getJtAreaConsumicionesAlta().getText() + a.toString() + "\n");
				solicitados.add(a);
				getLblTotalAlta().setText(this.calcularPrecio(solicitados));
			} else {
				getJtxtMensajeAlta().setText("ID de articulo incorrecto");
				getJtxtArticuloAlta().setText("");
			}
		} catch (NumberFormatException e) {
			getJtxtMensajeAlta().setText("Valor incorrecto, introduzca un numero");
			getJtxtArticuloAlta().setText("");
		}
	}

	private String calcularPrecio(ArrayList<Articulo> articulos) {
		float total = 0;
		for (Articulo articulo : articulos) {
			total += articulo.getPrecio();
		}
		return String.valueOf(total);
	}

	private void getPedidoConsulta() {
		try {
			Habitacion h;
			int idIntroducida = Integer.valueOf(getJtxtHabitacionConsulta().getText());
			h = facade.getHabitacion(idIntroducida);
			Pedido a;
			int idPedido = Integer.valueOf(getJtxtpedidoConsulta().getText());
			facade.setPedidoPath(getJtxtHabitacionConsulta().getText());
			try {
				a = facade.getPedido(idPedido);
				getLblTotalConsulta().setText("0");
				for (Articulo articulo : a.getArticulosSolicitados()) {
					getJtAreaConsumicionesConsulta()
							.setText(getJtAreaConsumicionesConsulta().getText() + articulo.toString() + "\n");
					getLblTotalConsulta().setText(
							String.valueOf(articulo.getPrecio()+Float.valueOf(getLblTotalConsulta().getText())));
				}
			} catch (Exception e) {
				getJtxtMensajeConsulta().setText("Error, revise su id de pedido o articulo");
				getJtxtHabitacionConsulta().setText("");
				getJtxtpedidoConsulta().setText("");
			}
		} catch (NumberFormatException e) {
			getJtxtMensajeConsulta().setText("Error, revise su id de pedido o articulo");
			getJtxtHabitacionConsulta().setText("");
			getJtxtpedidoConsulta().setText("");
		}
	}
}
