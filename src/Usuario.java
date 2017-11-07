
public class Usuario{
	
	/*atributos*/
	
	private String nombre;
	private String pasaporte;
	private String dni;      
	private String numTarjeta;
	
	
	/*contructoras*/
	
	public Usuario(){};
	
	public Usuario (String nombre,String  pasaporte,String dni,String numTarjeta){
		
		this.nombre=nombre;
		this.pasaporte=pasaporte;
		this.dni=dni;
		this.numTarjeta=numTarjeta;}
		
	/*accesoras*/
	
	public String getNombre(){return nombre;}
	public String getPasaporte(){return pasaporte;}
	public String getDni(){return dni;}
	public String getNumTarjeta(){return numTarjeta;}
	
	/*mutadoras*/ 
	
	public void setNombre(String name){ nombre= name;}
	public void setPasaporte (String passport){pasaporte = passport;}
	public void setDni(String _dni){dni= _dni;}
	public void setNumTarjeta(String _numTarjeta){numTarjeta= _numTarjeta;} 
	
  /*metodos*/
	
	public String toString(){return "nombre"+ nombre+"pasaporte"+pasaporte+"dni"+dni+"tarjeta de credito"+numTarjeta;}
}
