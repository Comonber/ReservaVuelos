
public class Reserva {
	
	/*atributos*/
	
	private Usuario usuario;
	private Vuelo  vuelo;
	private int codReserva;
	private String plazaAvion;  // asiento fisico , es decir el asiento 15A por ejemplo
	private TipoPlaza tipoPlaza;  
	
	/*contructoras*/


	public Reserva(){};
	
	public Reserva(Usuario usuario, Vuelo vuelo ,int codReserva,String plazaAvion){	
		this.usuario=usuario;
		this.vuelo=vuelo;
		this.codReserva=codReserva;
		this.plazaAvion=plazaAvion;}
	
	/*accesoras*/
	
	public Usuario getUsuario(){return usuario;}
	public Vuelo getVuelo(){return vuelo;}
	public int getCodReserva(){return codReserva;}
	public String getPlazaAvion(){return plazaAvion;}
	public TipoPlaza getTipoPlaza() {return tipoPlaza;}
	
	
	/*mutadoras*/
	
	public void setUsuario(Usuario u){usuario=u;}
	public void setVuelo(Vuelo v){vuelo=v;}
	public void setCodReserva(int cod){codReserva= cod;}
	public void setPlazaAvion (String plaza){plazaAvion= plaza;}
	public void setTipoPlaza(TipoPlaza _tipoPlaza) {tipoPlaza = _tipoPlaza;}
	
	/*metodos*/
	
	public String toString(){return "usuario: "+usuario+"vuelo: "+vuelo+"plaza del Avion: "+plazaAvion+"Codigo: "+codReserva;}
	
	

	
	
	

}
