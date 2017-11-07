import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.WindowListener;

 

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

 

public class Aplicacion extends JFrame  implements WindowListener{

   /*Atributos*/

    private GestorReservas gestorReservas;

    private GestorVuelos gestorVuelos;

    private GestorUsuarios gestorUsuarios;

    private PanelReservas panelReservas;   

    private PanelVuelos panelVuelos;
    
    private DatosUsuario datosUsuario;
    
    private Extracto extracto;

    private JLabel etiqueta;

    private JPanel jpBase;

    /*constructores*/

    public Aplicacion(){

        this.gestorReservas= new GestorReservas();

        this.gestorVuelos= new GestorVuelos();
        
        this.gestorUsuarios = new GestorUsuarios();

        inicializarVentana();

        this.cargarDatosPorDefecto();}

 /*Accesores*/

    public GestorReservas getGestorReservas() {return gestorReservas;}

    public GestorVuelos getGestorVuelos() {return gestorVuelos;}

    public GestorUsuarios getGestorUsuarios(){ return gestorUsuarios;}

 /*Mutadores*/

    public void setGestorReservas(GestorReservas gestorReservas) {
    	
    	this.gestorReservas = gestorReservas;
    }

    public void setGestorVuelos(GestorVuelos gestorVuelos) {

        this.gestorVuelos = gestorVuelos;

    }

 
    public void setGestorUsuarios ( GestorUsuarios gestorUsuarios){
    	this.gestorUsuarios= gestorUsuarios;
    }

    
    
    
    public void inicializarVentana() {

        jpBase= new JPanel();

        this.getContentPane().add(jpBase);

       

        jpBase.setLayout(new BorderLayout()); //cambiamos el layout de la ventana por un borderlayout

       

        JPanel jpIzda= new JPanel();

        //jpIzda.setBackground(Color.RED);

        jpBase.add(jpIzda,BorderLayout.WEST);//metemos un panel en la izquierda

        JPanel jpDrcha= new JPanel();

        //jpDrcha.setBackground(Color.RED);

        jpBase.add(jpDrcha,BorderLayout.EAST);//metemos un panel a la derecha

        JPanel jpArriba= new JPanel();

        //jpArriba.setBackground(Color.RED);

        jpBase.add(jpArriba,BorderLayout.NORTH);//metemos un panel en el norte

        JPanel jpAbajo= new JPanel();

        //jpAbajo.setBackground(Color.RED);

        jpBase.add(jpAbajo,BorderLayout.SOUTH);//metemos un panel en el sur

       

        // Con estos paneles no hacemos nada, para que el panel del medio ocupe todo el espacio posible

       

        // inicializamos nuetros paneles

        panelReservas= new PanelReservas(this); // para poder llamar  a la aplicacion desde los paneles

        panelVuelos= new PanelVuelos(this);
        
        extracto = new Extracto(this);
        
        datosUsuario = new DatosUsuario(this);

       

        jpBase.add(panelReservas,BorderLayout.CENTER);// colocamos el panel de las Reservas en el centro de nuetra ventana

        panelReservas.setPreferredSize(new Dimension(500,300));

       // panelReservas.setBackground(Color.GRAY);

       

        panelVuelos.setPreferredSize(new Dimension(500,300));

        //panelVuelos.setBackground(Color.BLACK);

        this.setSize(600, 400); // tamaño de la ventana

        this.setVisible(true); // hacemos que la ventana sea siempe visible

        this.addWindowListener(this);
        
    }



public void cambiarAPanel(String panel){

    if (panel.equals("VUELOS")) 

    	  { jpBase.remove(panelReservas);

            jpBase.add(panelVuelos,BorderLayout.CENTER);

            jpBase.validate();}

    else 
    	
    	if (panel.equals("USUARIO"))
    		
    	  { jpBase.remove(panelVuelos);
    	    jpBase.add(datosUsuario,BorderLayout.CENTER);
    	    datosUsuario.limpiarDatos();
    	    jpBase.validate();}
    
    else
    	
    	if (panel.equals("EXTRACTO"))
    		
    	  { jpBase.remove(datosUsuario);
    	    jpBase.add(extracto,BorderLayout.CENTER);
    	    extracto.cargarDatos();
    	    jpBase.validate();}

     else
    	    	
    	 if (panel.equals("RESERVA"))
    	    		
    	   { jpBase.remove(extracto);
    	     jpBase.add(panelReservas,BorderLayout.CENTER);
    	     jpBase.validate();}


    }

       

                                                    



  
   public void windowActivated(WindowEvent arg0) {}


   public void windowClosed(WindowEvent arg0) {}

 

 

   public void windowClosing(WindowEvent arg0) {System.exit(0);}

 

 

    public void windowDeactivated(WindowEvent arg0) {}

 

   

    public void windowDeiconified(WindowEvent arg0) {}

 

   

    public void windowIconified(WindowEvent arg0) {}

 

 

    public void windowOpened(WindowEvent arg0) {}

 

 

 

    public static void main(String[] args) {

      
        Aplicacion a = new Aplicacion();   

        a.setTitle ("Vuelos Mafalda"); 
        
        
       /* a.addWindowListener( new WindowAdapter() {

            public void windowClosing( WindowEvent e ) {

              System.exit(0);

            }

          });*/

    }

    

   

   

    public void cargarDatosPorDefecto(){

        Reserva reservaDefecto= new Reserva();
      

        reservaDefecto.setCodReserva(11111);

        reservaDefecto.setTipoPlaza(TipoPlaza.TURISTA);

       

        Avion avion= new Avion();
        Avion avion2 = new Avion();
        Avion avion3 = new Avion();
        

        avion.setIdAvion("A303");

       avion2.setIdAvion("A380");
       
       avion3.setIdAvion("A470");

        Vuelo vuelo= new Vuelo();

        Vuelo vuelo2 = new Vuelo();
        
        Vuelo vuelo3 = new Vuelo();

        vuelo2.setOrigen("Barcelona");
        vuelo2.setDestino("Cadiz");

        vuelo.setCodVuelo("123F");
        vuelo2.setCodVuelo("6533H");
        vuelo3.setCodVuelo("46453G");
        
        vuelo3.setOrigen("Cadiz");
        vuelo3.setDestino("Santander");

        vuelo.setDestino("Barcelona");
        vuelo.setOrigen("Madrid");

        vuelo.setTarifaBusiness(420);
        vuelo.setTarifaTurista(200);
        vuelo2.setTarifaBusiness(800);
        vuelo2.setTarifaTurista(300);
        vuelo3.setTarifaBusiness(450);
        vuelo3.setTarifaTurista(200);

        vuelo.setAvion(avion);
        vuelo2.setAvion(avion2);
        vuelo3.setAvion(avion3);

         vuelo.setFecha("16/01/10");
         vuelo2.setFecha("08/03/10");
         vuelo3.setFecha("05/02/10");
       

        Usuario usuario= new Usuario();

        usuario.setNombre("Juan");

       

        reservaDefecto.setVuelo(vuelo);

        reservaDefecto.setUsuario(usuario);

       

        gestorReservas.anadirReserva(reservaDefecto);

        gestorVuelos.anadirVuelo(vuelo);
        gestorVuelos.anadirVuelo(vuelo2);
        gestorVuelos.anadirVuelo(vuelo3);

    }

    

    

 

 



 

 
    

 

}
    	