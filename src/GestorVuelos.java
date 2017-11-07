import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.util.*;

public class GestorVuelos extends AbstractTableModel {
	
	 /*Atributos*/

	ArrayList<Vuelo> listaVuelos;
	
     /*Constructoras*/
	
	public GestorVuelos() {
		super();
		listaVuelos = new ArrayList<Vuelo>();
		
	}
     /* Accesoras*/
	
	
    public 	ArrayList<Vuelo> getListaVuelos(){
    	return listaVuelos;
    }

	/* metodos propios de la coleccion */

	public void anadirVuelo(Vuelo v) {
		listaVuelos.add(v);
	}

	public void cancelarVuelo(Vuelo c) {
		listaVuelos.remove(c);
	}

	public Vuelo buscarVuelo(String codVuelo) {
		
		Iterator<Vuelo> it = listaVuelos.iterator();

		Vuelo v = null;

		while (it.hasNext()) {
			
			v=it.next();
			if (v.getCodVuelo() == codVuelo) {
				return v;
			} else {
				return null;
			}
		}

		return v;
	}

	/* metodos propios de la clase AbstracTableModel */

	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return listaVuelos.size();
	}

	

	public Object getValueAt(int row, int col) {

		Vuelo vuelo = listaVuelos.get(row);
											

		String texto;
		texto = null;
		

		switch (col) {

		case 0: // En la columna 0 mostramos el código del vuelo

			texto = vuelo.getCodVuelo();

			break;
			
			
			
		case 1: // En la columna 1 mostramos  Origen/destino

			texto = vuelo.getOrigen() + "/" + vuelo.getDestino();

			break;
			

		case 2: // En la columna 2 mostramos  Tarifas Turista/Business

			texto = vuelo.getTarifaTurista() + "/" + vuelo.getTarifaBusiness();

			break;

		

		case 3: // En la columna 3 mostramos la fecha

			texto = vuelo.getFecha();
			break;

		case 4: // En la columna 4 mostramos el identificador del avión
			texto = vuelo.getAvion().getIdAvion();
			break;
			
		default:
			texto = "error";

		}
    return texto;
	}

	/* metodos extras de la clase AbstractTableModel */

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	

	public String getColumnName(int column) {

		String nombreCol;
		
		switch (column) {

		case 0: // En la columna 0 mostramos el nombre para la columna código
				// del vuelo

			nombreCol = "Codigo de Vuelo";

			break;

		case 1: // En la columna 1 mostramos el nombre del Origen/Destino

			
			nombreCol = "Origen/Destino";
			break;

		case 2: // En la columna 2 mostramos el nombre para el  tipo de tarifa 

			
			nombreCol = "Tarifa";
			break;

		case 3: // En la columna 3 mostramos el nombre para la columna fecha

			nombreCol = "Fecha";

			break;

		case 4: // En la columna 4 mostramos el nombre para la columna
				// identificador del avión

			nombreCol = "Id.del Avión";

			break;

		default:
			nombreCol = "error ";
		}

		return nombreCol;

	}

}
