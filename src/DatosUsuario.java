import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DatosUsuario extends JPanel implements ActionListener { // en esta clase es donde tengo q meter
	//los JtextField para q la  tia del telefono meta a pepito

	/*atributos*/
	
	private JButton botonSiguiente;
	private JLabel etiqueta;
	
	private JTextField campoNombre;
	private JLabel insertaNombre;
	
	private JTextField campoDni;
	private JLabel insertaDni;
	
	private JTextField campoPasaporte;
	private JLabel insertaPasaporte;
	
	private JTextField campoTarjeta;
	private JLabel insertaTarjeta;
	
	private Aplicacion aplicacion;
	
	
	/*Constructoras*/
	
		public DatosUsuario(Aplicacion aplicacion){
			
			super();
			this.aplicacion= aplicacion;
			inicializarPanel();}
		
		
		private void inicializarPanel(){
			this.setLayout(new BorderLayout());
			creamosBotonera();
			creamosSeccionTexto();
			creamosEtiqueta();}
		
	
		
		private void creamosBotonera(){
			
			//Creamos la botonera
			
			JPanel panelBotonera = new JPanel();
			panelBotonera.setPreferredSize(new Dimension(490,50));
			
			//Creamos el boton y le añadimos un escuchador
			
			botonSiguiente = new JButton("Siguiente");
			botonSiguiente.addActionListener(this);
			
			//añadimos el boton a la botonera
			
			panelBotonera.add(botonSiguiente);
			
			//añadimos la Botonera al Panel "Datos de Usuario"
			
			this.add(panelBotonera, BorderLayout.SOUTH);
            
		     
		}
			
		
		
		public void creamosSeccionTexto(){
			
			JPanel panelTexto = new JPanel();
			panelTexto.setLayout(new GridLayout(5,2)); //5 filas , 2 columnas
			panelTexto.setPreferredSize(new Dimension(490,50));
			
			//Creamos las etiquetas
			
			insertaNombre= new JLabel("Nombre: " ,JLabel.LEFT);
			insertaDni = new JLabel("DNI: " ,JLabel.LEFT);
			insertaPasaporte = new JLabel("Pasaporte: "  ,JLabel.LEFT);
			insertaTarjeta = new JLabel("Numero de Tarjeta: "  ,JLabel.LEFT);
			
			//Creamos los campos de texto
			
			campoPasaporte = new JTextField();
			campoDni = new JTextField();
			campoTarjeta = new JTextField();
			campoNombre= new JTextField();
			
			//colocamos las etiquetas y los campos de texto en el panel Texto
			
			panelTexto.add(insertaNombre);
			panelTexto.add(campoNombre);
			
			panelTexto.add(insertaDni);
			panelTexto.add(campoDni);
			
			panelTexto.add(insertaPasaporte);
			panelTexto.add(campoPasaporte);
			
			panelTexto.add(insertaTarjeta);
			panelTexto.add(campoTarjeta);
			
			// colocamos el panelTexto en nuetro panel de DatosUsuario
			
			
			this.add(panelTexto,BorderLayout.CENTER);}
			

			
		public void creamosEtiqueta() {
			etiqueta = new JLabel("Datos de Usuario");
		    this.add(etiqueta,BorderLayout.NORTH);} 
		
		
		
		
		 public void limpiarDatos() {

			    campoPasaporte.setText("");

	            campoDni.setText("");

	            campoTarjeta.setText("");

	            campoNombre.setText("");

	      }
			
		
		/*Apuntes de Teoria:
		 * 
		 * El metodo equals() comprueba si un objeto es igual a otro (objeto).
		 * Concretamente equals(String) sirve para saber si dos objetos contienen la misma sentencia
		 * de caracteres.
		 * 
		 * Si se comparan dos referencias con el operador de igualdad (==), lo que se comprueba 
		 * es si estan apuntando al mismo objeto.
		 */
		
		
		public boolean validarTextoIntroducido(){
			
			boolean datosValidos= true;
			
		    	if((campoNombre.getText().trim().equals(""))||(campoDni.getText().trim().equals(""))||
				(campoPasaporte.getText().trim().equals(""))||(campoTarjeta.getText().trim().equals("")))
		    	{datosValidos= false;
		    	JOptionPane.showMessageDialog(aplicacion, "Por favor rellene todos los campos", "Atencion!!", JOptionPane.ERROR_MESSAGE);}
		    	
		  return datosValidos;
		}
			
		/*Funcionalidad para los Botones*/
		
		public void actionPerformed(ActionEvent event) {
			
			Usuario u = new Usuario();

			if (this.validarTextoIntroducido()) {

                u.setNombre(campoNombre.getText()); //recogemos la informacion que se ha introducido en los campos de texto

                u.setDni(campoDni.getText());

                u.setPasaporte(campoPasaporte.getText());

                u.setNumTarjeta(campoTarjeta.getText());



                aplicacion.getGestorReservas().finalizadoProcesoRecogerDatosUsuario(u);

                aplicacion.cambiarAPanel("EXTRACTO");

}
	            }

	    
			
			
		}	
	
