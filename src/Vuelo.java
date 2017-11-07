public class Vuelo {

	/* atributos */

	private String origen;
	private String destino;
	private String codVuelo;
	private int tarifaBusiness;
	private int tarifaTurista ;
	private Avion avion;
	private String fecha;

	
	/* Contructoras */

	public Vuelo() {
	};

	
	public Vuelo(String origen, String destino, String codVuelo, int tarifaTurista, int tarifaBusiness,
			Avion avion, String tipo, String fecha) {

		this.origen = origen;
		this.destino = destino;
		this.codVuelo = codVuelo;
        this.avion = avion;
        this.fecha = fecha;
		this.tarifaTurista= tarifaTurista;
		this.tarifaBusiness= tarifaBusiness;
	}

	/* accesoras */

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	
	public int getTarifaBusiness() {
		return tarifaBusiness;
	}

	public int getTarifaTurista() {
		return tarifaTurista;
	}	
		
	
	public Avion getAvion() {
		return avion;
	}


	public String getFecha() {
		return fecha;
	}
	
	/*Mutadoras*/
	
	
	
	public void setTarifaBusiness(int tarifaBusiness) {
		this.tarifaBusiness = tarifaBusiness;
	}

	public void setTarifaTurista(int tarifaTurista) {
		this.tarifaTurista = tarifaTurista;
	}
	
	public void setOrigen(String _origen) {
		origen = _origen;
	}

	public void setDestino(String _destino) {
		destino = _destino;
	}

	public void setCodVuelo(String _codVuelo) {
		codVuelo = _codVuelo;
	}



	public void setAvion(Avion _avion) {
		avion = _avion;
	}
	
	public void setFecha(String _fecha) {
		fecha = _fecha;
	}
	
	
	/* metodos */

	public String toString() {
		return "el origen es: " + origen + "el destino es: " + destino
				+ "y el codigo de vuelo es: "
				+ codVuelo + "tarifas: " + tarifaTurista +tarifaBusiness + "fecha: " + fecha;
	}

	
	
	
	
	public int calcularTarifa(TipoPlaza tipo) {
		int tarifa= 0;
		
		if (tipo.equals(tipo.TURISTA)) // funciona xq es un String , es decir un objeto

		{
			tarifa = tarifaTurista;
		}

		else

		if (tipo.equals(tipo.BUSINESS))

		{
			tarifa = tarifaBusiness;
		}

		return tarifa;
	}
	
	
}
