
public class Avion {
	
	/*atributos*/
	
	private final int maxT= 100; //maximo nº de asientos en turista
	private final int maxB= 20; // maximo nº de asientos en business
	private int asientosTurista[];
	private int asientosBusiness[];
	private String idAvion;
	
	/*contructores*/
	
	public Avion(){
	
	int	asientosTurista[] = new int [maxT];
	int asientosBusiness[] =new int [maxB];
	String idAvion= "";}
	
	public Avion (String idAvion){this.idAvion=idAvion;}

	
	
	public String getIdAvion(){return idAvion;}
	public void setIdAvion (String _idAvion){ idAvion= _idAvion;}

	
	
	//para q quiero  un toString en esta clase??
	
	
}
