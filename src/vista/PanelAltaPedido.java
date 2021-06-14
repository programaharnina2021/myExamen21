package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelAltaPedido extends JPanel {
	protected JTextField jtxtHabitacion;
	protected JTextField jtxtArticulo;
	protected JTextField jtxtMensaje;
	protected JLabel lblTotal;
	protected JButton btnFinalizarPedido;
	protected JTextArea jtAreaConsumiciones;
	
	public PanelAltaPedido() {
		setSize(new Dimension(800, 500));
		setLayout(new MigLayout("", "[][grow][grow][][grow][]", "[][][][][][][grow][][][][][]"));
		
		JLabel lblHotelLaPonia = new JLabel("Hotel La ponia");
		lblHotelLaPonia.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(lblHotelLaPonia, "cell 1 1 2 1,growx");
		
		JLabel lblHabitacion = new JLabel("habitacion");
		add(lblHabitacion, "cell 1 3,alignx trailing");
		
		jtxtHabitacion = new JTextField();
		add(jtxtHabitacion, "cell 2 3,alignx leading");
		jtxtHabitacion.setColumns(10);
		
		JLabel lblArticulo = new JLabel("Articulo");
		add(lblArticulo, "cell 3 3,alignx trailing");
		
		jtxtArticulo = new JTextField();
		add(jtxtArticulo, "cell 4 3,alignx leading");
		jtxtArticulo.setColumns(10);
		
		JLabel lblConsumiciones = new JLabel("Consumiciones");
		add(lblConsumiciones, "cell 1 5");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 6 4 1,grow");
		
		jtAreaConsumiciones = new JTextArea();
		jtAreaConsumiciones.setFont(new Font("Arial", Font.PLAIN, 16));
		jtAreaConsumiciones.setEditable(false);
		scrollPane.setViewportView(jtAreaConsumiciones);
		
		JButton btnCancelar = new JButton("Cancelar Pedido");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTodo();
			}
		});
		add(btnCancelar, "cell 1 7,growx");
		
		lblTotal = new JLabel(" ");
		lblTotal.setBackground(Color.WHITE);
		add(lblTotal, "cell 4 8,growx,aligny bottom");
		
		JLabel lblTotals = new JLabel("Total");
		add(lblTotals, "cell 3 8");
		
		JLabel lblMensaje = new JLabel("Mensaje");
		add(lblMensaje, "cell 1 9");
		
		btnFinalizarPedido = new JButton("Finalizar Pedido");

		add(btnFinalizarPedido, "cell 4 9,growx");
		
		JLabel label = new JLabel(" ");
		label.setMaximumSize(new Dimension(30, 20));
		add(label, "cell 5 9");
		
		jtxtMensaje = new JTextField();
		jtxtMensaje.setBackground(Color.WHITE);
		jtxtMensaje.setDisabledTextColor(Color.WHITE);
		jtxtMensaje.setEditable(false);
		add(jtxtMensaje, "cell 1 10 4 1,growx");
		jtxtMensaje.setColumns(10);
	}

	protected void limpiarTodo() {
		String cadena="";
		getJtxtHabitacion().setEditable(true);
		getJtAreaConsumiciones().setText(cadena);
		getJtxtHabitacion().setText(cadena);
		getJtxtArticulo().setText(cadena);
		getJtxtMensaje().setText(cadena);
		getLblTotal().setText(cadena);
		
	}

	public JTextField getJtxtHabitacion() {
		return jtxtHabitacion;
	}

	public JTextField getJtxtArticulo() {
		return jtxtArticulo;
	}

	public JTextField getJtxtMensaje() {
		return jtxtMensaje;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public JButton getBtnFinalizarPedido() {
		return btnFinalizarPedido;
	}

	public JTextArea getJtAreaConsumiciones() {
		return jtAreaConsumiciones;
	}
}
