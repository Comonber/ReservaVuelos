import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Extracto extends JPanel implements ActionListener{
	
	/*Atributos*/
	
	private JButton botonPagar;
	private JLabel etiqueta;
	
	private JLabel nombre;
	private JLabel origen;
	private JLabel destino;
	private JLabel avion;
	private JLabel codigoVuelo;
	private JLabel fecha;
	
	
	private JLabel muestraNombre;
	private JLabel muestraOrigen;
	private JLabel muestraDestino;
	private JLabel muestraAvion;
	private JLabel muestraCodigoVuelo;
	private JLabel muestraFecha;
	
	
    private Aplicacion aplicacion;
    
    
	
	/*Constructoras*/
	
	private void inicializarPanel(){
		this.setLayout(new BorderLayout());
		creamosBotonera();
		creamosSeccionTexto();
		creamosEtiqueta();}
		 
	
	
public Extracto (Aplicacion aplicacion){
		
		super();
		this.aplicacion= aplicacion;
		inicializarPanel();}
	

	public void creamosBotonera(){
		
		// creamos la botonera
		JPanel panelBotonera = new JPanel();
		panelBotonera.setPreferredSize(new Dimension(490,50));
		
		//creamos el boton y le añadimos el escuchador
		botonPagar =new JButton("PAGAR");
		botonPagar.addActionListener(this);
		
		//añadimos el boton a la Botonera
		
		panelBotonera.add(botonPagar);
		
		// añadimos la botonera a nuestro panel
		
		this.add(panelBotonera, BorderLayout.SOUTH);
	}
	
		public void creamosSeccionTexto(){
			
			//creamos el panel de texto
			JPanel panelTexto = new JPanel();
			panelTexto.setLayout(new GridLayout(7,2));
			
			
			
			// creamos las etiquetas de texto 
			
			nombre = new JLabel("NOMBRE: ");
			origen = new JLabel("ORIGEN: ");
		    destino= new JLabel("DESTINO: ");
			avion= new JLabel("AVION: ");
		    codigoVuelo= new JLabel("COD.VUELO: ");
			fecha= new JLabel("FECHA: ");
			
			
			 muestraNombre = new JLabel();
			 muestraOrigen= new JLabel();
			 muestraDestino= new JLabel();
			 muestraAvion= new JLabel();
			 muestraCodigoVuelo= new JLabel();
			 muestraFecha= new JLabel();
			
			
			 
			
			
		     
		     //añadimos las etiquetas al Campo de Texto
		     
		     panelTexto.add(nombre);
		     panelTexto.add(muestraNombre);
		     
		     panelTexto.add(origen);
		     panelTexto.add(muestraOrigen);
		     
		     panelTexto.add(destino);
		     panelTexto.add(muestraDestino);
		     
		     panelTexto.add(avion);
		     panelTexto.add(muestraAvion);
		     
		     panelTexto.add(codigoVuelo);
		     panelTexto.add(muestraCodigoVuelo);
		     
		     panelTexto.add(fecha);
		     panelTexto.add(muestraFecha);
		     
		    
		     
		// añadimos el panelTexto a nuestro panel de Extracto
		     
		     this.add(panelTexto,BorderLayout.CENTER);
		    this. setPreferredSize(new Dimension(300,50));}
		     
		public void creamosEtiqueta() {
			etiqueta = new JLabel("Extracto");
		    this.add(etiqueta,BorderLayout.NORTH);} 
		     
		
		
 public void cargarDatos(){
			 muestraNombre.setText(aplicacion.getGestorReservas().getReservaTMP().getUsuario().getNombre());
			 muestraOrigen.setText(aplicacion.getGestorReservas().getReservaTMP().getVuelo().getOrigen());
			 muestraDestino.setText(aplicacion.getGestorReservas().getReservaTMP().getVuelo().getDestino());
			 muestraAvion.setText(aplicacion.getGestorReservas().getReservaTMP().getVuelo().getAvion().getIdAvion());
		     muestraCodigoVuelo.setText(aplicacion.getGestorReservas().getReservaTMP().getVuelo().getCodVuelo());
		     muestraFecha.setText(aplicacion.getGestorReservas().getReservaTMP().getVuelo().getFecha());
		     }
		     
		
		
		
		
	/*Funcionalidad para los Botones  ya la etiquetas*/
	
	public void actionPerformed(ActionEvent event){
		
        int coste=0 ;
       
        
        if (event.getSource()== this.botonPagar){
        	
        	
        	aplicacion.getGestorReservas().pagar(coste);
         
            aplicacion.cambiarAPanel("RESERVA");
            aplicacion.getGestorReservas().finalizadoProcesoCrearReserva();
          

        

        }
		
		
		
		
	}
	
}
	
	
	
	

