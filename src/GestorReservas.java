import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class GestorReservas extends AbstractTableModel {
	
	//atributos
	
	ArrayList<Reserva> listaReservas ;
	
	private Reserva reservaTmp;
	
	/*Constructores*/
	
	public GestorReservas(){
		super();
		listaReservas= new ArrayList<Reserva>();
	     reservaTmp = new Reserva();}
	
	/*Accesoras*/
	
	public Reserva getReservaTMP(){return reservaTmp;}
	public ArrayList<Reserva> getListaReservas(){return listaReservas;}
	
	/* metodos propios de la coleccion*/
	
	public void anadirReserva(Reserva r){ listaReservas.add(r);}
	
	public void cancelarReserva(Reserva r){listaReservas.remove(r);}
	
	
	public Reserva buscarReserva(int codReserva){
		
		Iterator<Reserva> it =  listaReservas.iterator();
		
		Reserva r = null;

		while (it.hasNext()) {
			r=it.next();
			if (r.getCodReserva() == codReserva) {
				return r;
			} else {
				return null;
			}
		}

		return r;
	}
	
	
/* metodos propios de la clase AbstracTableModel*/
	
	public int getColumnCount() { return 5; } // definimos el numero de columnas

	public int getRowCount() { return listaReservas.size();}// definimos el numero de filas
	
	
// este metodo es para saber que  clase de objeto se tiene que mostrar en cada columna 
	
	public Object getValueAt(int row, int col) {
		
		  Reserva reserva= listaReservas.get(row); 

	        String texto= null;
	        
	        
	        
	        switch(col){

	 

	        case 0: // En la columna 0 mostramos el nombre del cliente 

	               texto= reserva.getUsuario().getNombre();
                  
	               break;

	        case 1: // En la columna 1 mostramos desde donde sale el cliente 

	               texto= reserva.getVuelo().getOrigen();             
                   
	                break;

	        case 2: // En la columna 2 mostramos hasta donde va 

	               texto= reserva.getVuelo().getDestino();            
                   
	                break;

	        case 3: // En la columna 3 mostramos el tipo de vuelo que hace (turista o business)

	               texto= reserva.getVuelo().getTarifaTurista() + "/" 
	                      +reserva.getVuelo().getTarifaBusiness() ;              
                   
	                break;

	        case 4: // En la columna 4 mostramos su asiento

	               texto= reserva.getPlazaAvion();         
                   
	                break;

	        default: texto= "error";

	}
     
     return texto;

	  }
	
	//este metodo es para  poner nombre en las cabeceras de las columnas
	
	public String getColumnName(int column) {

	    String nombreCol; 
	    switch(column){



	case 0: // En la columna 0 mostramos el nombre del cliente

	   nombreCol= "Cliente";

	    break;

	case 1: // En la columna 1 mostramos el origen del cliente

	   nombreCol="Origen";

	     break;

	case 2: // En la columna 2 mostramos el destino del cliente

	   nombreCol="Destino";

	     break;

	case 3: // En la columna 3 mostramos el tipo de reserva

	   nombreCol="Business/Turista";

	     break;

	case 4: // En la columna 4 mostramos el nombre asiento  

	   nombreCol="Asiento";

	     break;

	default: nombreCol="error";}

	return nombreCol;



	}
	
	public Class getColumnClass(int c) {
		return String.class;
	}

	/*metodos*/
	
	
	
	/*	El cuerpo de este método calcula el coste a través de los datos de la reserva
	 *  y devolvería dicho coste para mostrarlo en pantalla
	 */
	
	public int calcularCoste (Reserva reserva){ 
		
		int coste;
		
		coste=reserva.getVuelo().calcularTarifa(reserva.getTipoPlaza());
		
		return coste;}
	
	
  public boolean validarTarjeta(Usuario usuario){
		
		boolean tarjetaValida;
		String activa;
		activa= "";
		
		  if (usuario.getNumTarjeta()== activa)
		      { return tarjetaValida = true;}
		  else 
		      {return tarjetaValida =false;}
		  
	}


   // En  este metodo se va a suponer que la tarjeta es valida siempre ,  dado que no contamos con una  entidad Bancaria  que  lo confirme
		
         public void pagar(int coste){
			
			JOptionPane.showMessageDialog(null, "Su reserva se ha efectuado correctamente");
				
			}
 
        	 
        	 public void iniciarProcesoCreacionReserva(){

                 this.reservaTmp= new Reserva();

                 this.reservaTmp.setCodReserva((int)System.currentTimeMillis());}

           
        	 
        	public void  finalizadoProcesoRecogerDatosVuelo(Vuelo vuelo, TipoPlaza tipoSeleccionado){
        		  
        		 this.reservaTmp.setVuelo(vuelo);
        		 this.reservaTmp.setTipoPlaza(tipoSeleccionado);	 
        	}
        	 
        	
        	
        	public void  finalizadoProcesoRecogerDatosUsuario(Usuario usuario){
      		  
       		 this.reservaTmp.setUsuario(usuario);
       		 
       	}
        	 
        	 public void finalizadoProcesoCrearReserva(){
        		 
        	 this.listaReservas.add(reservaTmp);
             this.reservaTmp= null; 
        		 
        		   
        	 }
        	 
        	
        	 
        	 
       public void   	 fireTableRowsDeleted( int firstRow, int lastRow)  {}  	 
        	 
        	 
        	 
        }
			
		


