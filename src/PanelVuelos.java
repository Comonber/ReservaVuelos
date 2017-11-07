import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PanelVuelos extends JPanel implements ActionListener { 
																	
	// muestra	los	vuelos	disponibles en mi	compañia
											
																	
	/* atributos */

	private JLabel etiqueta;

	private JButton botonSiguiente;
	private JTable tablaVuelos;
	private JScrollPane scroll;
	private DatosUsuario datosUsuario;
	private Aplicacion aplicacion;
	private ButtonGroup grupoBotones;
	private JRadioButton turista;
	private JRadioButton business;

	/* constructores */

	public PanelVuelos(Aplicacion aplicacion) {
		super();
		this.aplicacion = aplicacion;
		inicializarPanel();
	}

	private void inicializarPanel() {
		this.setLayout(new BorderLayout());
		creamosTablaVuelos();
		creamosBotonera();
		creamosEtiqueta();
	}

	public void creamosBotonera() {

		JPanel panelBotonera = new JPanel();

		botonSiguiente = new JButton("Siguiente");

		 grupoBotones = new ButtonGroup();
		turista = new JRadioButton("Turista");
		business = new JRadioButton("Business");
		grupoBotones.add(turista);
		grupoBotones.add(business);

		this.add(panelBotonera, BorderLayout.SOUTH);

		panelBotonera.add(botonSiguiente);
		panelBotonera.add(turista);
		panelBotonera.add(business);

		botonSiguiente.addActionListener(this);
		turista.addActionListener(this);
		business.addActionListener(this);

		// panelBotonera.setBackground(Color.yellow);

		panelBotonera.setPreferredSize(new Dimension(490, 50));

	}
	
	
	public void cargarDatos(){turista.setSelected(true);} // se selecciona el tipo de vuelo turista por defecto
	

	public void creamosEtiqueta() {
		etiqueta = new JLabel("Panel de Vuelos");
		this.add(etiqueta, BorderLayout.NORTH);
	}

	public void creamosTablaVuelos() {

		tablaVuelos = new JTable(aplicacion.getGestorVuelos());
		scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(490, 240));
		tablaVuelos.setPreferredSize(new Dimension(490, 240));
		scroll.setViewportView(tablaVuelos);

		this.add(scroll, BorderLayout.CENTER);
	}

	/* funcionalidad para los botones */

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.botonSiguiente) {

			int row = this.tablaVuelos.getSelectedRow();

			if (row != -1) {

				Vuelo vuelo = this.aplicacion.getGestorVuelos()
						.getListaVuelos().get(row);

				TipoPlaza tipoPlaza = null;
				Usuario u = null;

				if (this.turista.isSelected())

					tipoPlaza = TipoPlaza.TURISTA;

				else

					tipoPlaza = TipoPlaza.BUSINESS;

				aplicacion.getGestorReservas()
						.finalizadoProcesoRecogerDatosVuelo(vuelo, tipoPlaza);

				aplicacion.cambiarAPanel("USUARIO");
				// cambiamos al panel Datos de Usuario para que se puedan
				// introducir sus datos
               
				aplicacion.getGestorUsuarios().anadirUsuario(u);
			}
			// añadimos el usuarios a nuetra coleccion de usuarios en el
			// arraylist

		 else 
			{JOptionPane.showMessageDialog(aplicacion,
					"Por favor seleccione un vuelo", "alert",
					JOptionPane.ERROR_MESSAGE);}
			// El JOptionPane es un dialago para sacar un mensaje de error (es
			// como la ventana de error que saca Windows)
		

	}

}}
