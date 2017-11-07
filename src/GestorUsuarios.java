import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;


public class GestorUsuarios   {
	
	
	/*Atributos*/
	
	ArrayList<Usuario> listaUsuarios ;   
	 
	/*Constructora*/
	
	public GestorUsuarios(){ listaUsuarios= new ArrayList<Usuario>();}
		
	
	/* metodos propios de la coleccion*/
	
	public void anadirUsuario(Usuario u){ listaUsuarios.add(u);}
	
	public void borrarUsuario(Usuario u){listaUsuarios.remove(u);}
	
	public Usuario buscarUsuario(String dni){ // entiendase  por dni ,  cualquier numero de identificacion personal , apra aquellos paises en los q no se usa dni
		
		Iterator<Usuario> it =  listaUsuarios.iterator();
    	 
    	  Usuario u = null;
    	  
    	 while (it.hasNext())
    	  {
    		 u=it.next();
    		 if (u.getDni()== dni){
    			 return u;
    	  }
    	  else
    	     {return null;}
    	}
    	 
    	return u; 
     }
	

	

}


