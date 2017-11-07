	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class PanelReservas extends JPanel implements ActionListener {
	// un panel q muestra las reservas

	/* atributos */

	private JLabel etiqueta;
	private JButton botonCrearReserva;
	private JButton botonCancelarReserva;
	private JTable tablaReservas;
	private JScrollPane scrollpane;
	private JPanel panelBotonera;

	private Aplicacion aplicacion;
	private PanelVuelos panelVuelos;

	/* constructores */

	public PanelReservas(Aplicacion aplicacion) {
		super();
		this.aplicacion = aplicacion;
		inicializarPanel();
	};

	public void inicializarPanel() {
		this.setLayout(new BorderLayout());
		creamosTablaReservas();
		creamosBotonera();
		creamosEtiqueta();

	}

	public void creamosBotonera() {

		JPanel panelBotonera = new JPanel();

		botonCrearReserva = new JButton("Crear Reserva");

		botonCancelarReserva = new JButton("Cancelar Reserva");

		this.add(panelBotonera, BorderLayout.SOUTH);

		panelBotonera.add(botonCrearReserva);

		panelBotonera.add(botonCancelarReserva);

		// panelBotonera.setBackground(Color.yellow);

		botonCrearReserva.addActionListener(this);
		botonCancelarReserva.addActionListener(this);

		panelBotonera.setPreferredSize(new Dimension(490, 50));
	}

	public void creamosEtiqueta() {
		etiqueta = new JLabel("Panel Reservas");
		this.add(etiqueta, BorderLayout.NORTH);
	}

	public void creamosTablaReservas() {

		tablaReservas = new JTable(aplicacion.getGestorReservas());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(490, 240));
		tablaReservas.setPreferredSize(new Dimension(490, 240));
		scrollPane.setViewportView(tablaReservas);

		this.add(scrollPane, BorderLayout.CENTER);

	}

	/* Funcionalidad para los Botones */

	public void actionPerformed(ActionEvent event) {



		if (event.getSource() == this.botonCrearReserva) {

			aplicacion.cambiarAPanel("VUELOS");

			aplicacion.getGestorReservas().iniciarProcesoCreacionReserva();

		} else if (event.getSource() == this.botonCancelarReserva) {

			int row = this.tablaReservas.getSelectedRow();

			if (row != -1) {

				Reserva r = aplicacion.getGestorReservas().getListaReservas().get(row); 
				aplicacion.getGestorReservas().cancelarReserva(r);

			}else{
				JOptionPane.showMessageDialog(aplicacion,
						"Debe seleccionar la reserva que desea cancelar", "Atención!!",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}

}