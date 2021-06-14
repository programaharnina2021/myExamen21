package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

public class PanelTotal extends JPanel {
	protected JTextField jtxtHabitacion;
	private JTextField jtxtTotal;
	protected JTextField jtxtMensaje;
	private JLabel lblMensaje;
	/**
	 * Create the panel.
	 */
	public PanelTotal() {
		setSize(new Dimension(800, 500));
		setLayout(new MigLayout("", "[][grow][grow][][grow][]", "[][][][][][][][][][][][][][][][]"));

		JLabel lblHotelLaPonia = new JLabel("Hotel La ponia");
		lblHotelLaPonia.setFont(new Font("Tahoma", Font.PLAIN, 33));
		add(lblHotelLaPonia, "cell 1 1 2 1,growx");

		JLabel lblHabitacion = new JLabel("habitacion");
		add(lblHabitacion, "cell 1 3,alignx trailing");

		jtxtHabitacion = new JTextField();
		add(jtxtHabitacion, "cell 2 3,alignx leading");
		jtxtHabitacion.setColumns(10);
		
		JLabel lblTotal = new JLabel("total");
		add(lblTotal, "cell 1 5,alignx trailing");
		
		jtxtTotal = new JTextField();
		jtxtTotal.setBackground(Color.WHITE);
		jtxtTotal.setEditable(false);
		add(jtxtTotal, "cell 2 5,growx");
		jtxtTotal.setColumns(10);
		
		lblMensaje = new JLabel("Mensaje");
		add(lblMensaje, "cell 1 14");
		jtxtMensaje = new JTextField();
		jtxtMensaje.setBackground(Color.WHITE);
		jtxtMensaje.setDisabledTextColor(Color.WHITE);
		jtxtMensaje.setEditable(false);
		add(jtxtMensaje, "cell 1 15 4 1,growx");
		jtxtMensaje.setColumns(10);
	}
	public JTextField getJtxtHabitacion() {
		return jtxtHabitacion;
	}
	public void setJtxtHabitacion(JTextField jtxtHabitacion) {
		this.jtxtHabitacion = jtxtHabitacion;
	}
	public JTextField getJtxtTotal() {
		return jtxtTotal;
	}
	public void setJtxtTotal(JTextField jtxtTotal) {
		this.jtxtTotal = jtxtTotal;
	}
	public JTextField getJtxtMensaje() {
		return jtxtMensaje;
	}
	public void setJtxtMensaje(JTextField jtxtMensaje) {
		this.jtxtMensaje = jtxtMensaje;
	}

}
