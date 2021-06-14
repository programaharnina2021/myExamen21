package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame {

	private final JPanel contentPane;
	private PanelAltaPedido panelAltaPedido;
	private PanelConsultaPedido panelConsultaPedido;

	

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 496);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Alta");
		menuBar.add(mnNewMenu);

		panelConsultaPedido=new PanelConsultaPedido();
		panelAltaPedido=new PanelAltaPedido();
		PanelTotal panelTotal=new PanelTotal();
	
		JMenuItem mntmAltaPedido = new JMenuItem("Alta Pedido");
		mntmAltaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)contentPane.getLayout()).show(contentPane, "alta");
			}
		});
		mnNewMenu.add(mntmAltaPedido);

		JMenu mnNewMenu_1 = new JMenu("Consulta");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmConsultaPedido = new JMenuItem("Gestion Pedido");
		mntmConsultaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)contentPane.getLayout()).show(contentPane, "consulta");
			}
		});
		mnNewMenu_1.add(mntmConsultaPedido);

		JMenuItem mntmConsultaTotal = new JMenuItem("Consulta Total");
		mntmConsultaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((CardLayout)contentPane.getLayout()).show(contentPane, "total");
			}
		});
		mnNewMenu_1.add(mntmConsultaTotal);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(panelAltaPedido, "alta");
		contentPane.add(panelConsultaPedido, "consulta");
		contentPane.add(panelTotal, "total");
		
	}

	public JTextField getJtxtHabitacionConsulta() {
		return panelConsultaPedido.getJtxtHabitacion();
	}

	public JTextField getJtxtpedidoConsulta() {
		return panelConsultaPedido.getJtxtPedido();
	}

	public JTextField getJtxtMensajeConsulta() {
		return panelConsultaPedido.getJtxtMensaje();
	}

	public JLabel getLblTotalConsulta() {
		return panelConsultaPedido.getLblTotal();
	}

	public JTextArea getJtAreaConsumicionesConsulta() {
		return panelConsultaPedido.getJtAreaConsumiciones();
	}

	public JTextField getJtxtHabitacionAlta() {
		return panelAltaPedido.getJtxtHabitacion();
	}

	public JTextField getJtxtArticuloAlta() {
		return panelAltaPedido.getJtxtArticulo();
	}

	public JTextArea getJtAreaConsumicionesAlta() {
		return panelAltaPedido.getJtAreaConsumiciones();
	}

	public JTextField getJtxtMensajeAlta() {
		return panelAltaPedido.getJtxtMensaje();
	}

	public JLabel getLblTotalAlta() {
		return panelAltaPedido.getLblTotal();
	}

	public JButton getBtnFinalizarPedidoAlta() {
		return panelAltaPedido.getBtnFinalizarPedido();
	}

}
