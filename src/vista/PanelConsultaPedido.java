package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConsultaPedido extends JPanel {
	protected JTextField jtxtHabitacion;
	protected JTextField jtxtPedido;
	protected JTextField jtxtMensaje;
	protected JLabel lblTotal;
	protected JTextArea jtAreaConsumiciones;


	/**
	 * Create the panel.
	 */
	public PanelConsultaPedido() {
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

		JLabel lblPedido = new JLabel("Pedido");
		add(lblPedido, "cell 3 3,alignx trailing");

		jtxtPedido = new JTextField();

		add(jtxtPedido, "cell 4 3,alignx leading");
		jtxtPedido.setColumns(10);

		JLabel lblConsumiciones = new JLabel("Consumiciones");
		add(lblConsumiciones, "cell 1 5");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 6 4 1,grow");

		jtAreaConsumiciones = new JTextArea();
		jtAreaConsumiciones.setFont(new Font("Arial", Font.PLAIN, 16));
		jtAreaConsumiciones.setText(" ");
		scrollPane.setViewportView(jtAreaConsumiciones);

		lblTotal = new JLabel(" ");
		lblTotal.setBackground(Color.WHITE);
		add(lblTotal, "cell 4 8,growx,aligny bottom");

		JLabel lblTotals = new JLabel("Total");
		add(lblTotals, "cell 3 8");

		JLabel lblMensaje = new JLabel("Mensaje");
		add(lblMensaje, "cell 1 9");

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

	public JTextField getJtxtHabitacion() {
		return jtxtHabitacion;
	}

	public JTextField getJtxtPedido() {
		return jtxtPedido;
	}

	public JTextField getJtxtMensaje() {
		return jtxtMensaje;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public JTextArea getJtAreaConsumiciones() {
		return jtAreaConsumiciones;
	}
}
