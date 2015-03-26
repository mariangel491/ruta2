package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.AvanceArrendatario;
import Modelos.Marca;
import Modelos.Socio;
import Modelos.Vehiculo;
import Modelos.VehiculoArrendatario;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.AvanceArrendatarioDao;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.MarcaDao;
import Modelos.Hibernate.Daos.SocioDao;
import Modelos.Hibernate.Daos.VehiculoArrendatarioDao;
import Modelos.Hibernate.Daos.VehiculoDao;
import Vistas.VistaArrendatario;
import Vistas.VistaAvance;
import Vistas.VistaAvanceArren;
import Vistas.VistaSocio;
import Vistas.VistaVehiculo;



public class ControladorVehiculo implements ActionListener {
	
	//cuuando se guarde el inquilino poner lq vista invisible y traerse
	/*los datos de inquilino a la vista de alquiler y al guardar alquiler destruir
	 * ambas ventanas*/
	
	private VistaVehiculo vVehiculo;
	protected VistaSocio vSocio;
	
	VehiculoDao vehiculoDao = new VehiculoDao();
	Vehiculo vehiculo = new Vehiculo();
	Arrendatario arrendatario= new Arrendatario();
	private Socio socio = new Socio();
	private Avance avan = new Avance();
	Arrendatario arrendatarioPrueba= new Arrendatario();
	Socio socioPrueba = new Socio();
	
	VehiculoArrendatario vehiArren= new VehiculoArrendatario();
	private SocioDao socioDao = new SocioDao();
	private MarcaDao marcaDao= new MarcaDao();
	VehiculoDao vehDao= new VehiculoDao();
	private AvanceDao avanceDao = new AvanceDao();
	ArrendatarioDao arrenDao = new ArrendatarioDao();
	AvanceArrendatarioDao avanceArrenDao = new AvanceArrendatarioDao();
	VehiculoArrendatarioDao vehArrenDao = new VehiculoArrendatarioDao();
	
	private List<Avance> listaAvancesSocio=new ArrayList<>();
	private List<AvanceArrendatario> listaAvancesArren=new ArrayList<>();

	ControladorAvance Cavance;
	ControladorSocio Csocio;
	
	public ControladorVehiculo(String resp) {
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		try {
			vVehiculo.LlenarComboMarca();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vVehiculo.agregarListener(this);
		
			if(resp.equals("Vehiculo Arrendatario")){
				vVehiculo.CambiarNombrePanel();
			
			}
	}
	
	
	public ControladorVehiculo(VistaAvance va) {
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		vVehiculo.limpiarCampos();
		vVehiculo.agregarListener(this);
		System.out.println("entro por");
		
		////si viene de socio
		socioPrueba= va.RetornaSocio();
		arrendatarioPrueba= va.RetornaArrendatario();
	System.out.println("por socio"+socioPrueba.getNombre());
	System.out.println("por arrendatario"+arrendatarioPrueba.getNombre());
	System.out.println(!socioPrueba.equals(null));
	
		if (!socioPrueba.equals(null))
		{
			//socioPrueba = va.GuardarSocio();
			
			vVehiculo.setTxtNroSocio(va.llenarCodigo()); 
			vVehiculo.setTxtNomSocio(va.llenarNombre());
			listaAvancesSocio= va.LlenarListaAvances();
			
			System.out.println("lista avances socios "+ listaAvancesSocio.size());
			
			for(int i=0; i<va.LlenarListaAvances().size();i++)
			{
				vVehiculo.setCmbConductor(va.LlenarListaAvances().get(i).getNombre()+ " "+
						va.LlenarListaAvances().get(i).getApellido());
			}
			
			try {
				vVehiculo.LlenarComboMarca();
				vVehiculo.OcultarListado(this.obtenerVehiculos());	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//else{
			/*arrendatarioPrueba= va.RetornaArrendatario();
		System.out.println(arrendatarioPrueba.getCedula());
			if(arrendatarioPrueba!=null){
				
				vVehiculo.setTxtNroSocio(va.llenarCodigo()); 
				vVehiculo.setTxtNomSocio(va.llenarNombre());
				listaAvancesArren= va.LlenarListaAvancesArren();
				for(int i=0; i<va.LlenarListaAvancesArren().size();i++)
				{
					vVehiculo.setCmbConductor(va.LlenarListaAvancesArren().get(i).getNombre()+ " "+
							va.LlenarListaAvancesArren().get(i).getApellido());
				}
				
				try {
					vVehiculo.LlenarComboMarca();
					this.obtenerVehiculoArren();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			//}
		//	}
			
			
	}

public ControladorVehiculo(VistaAvanceArren vaa) {
	vVehiculo = new VistaVehiculo();
	vVehiculo = vVehiculo.obtenerInstancia();
	vVehiculo.setLocationRelativeTo(null);
	vVehiculo.setVisible(true);
	vVehiculo.limpiarCampos();
	vVehiculo.agregarListener(this);
	vVehiculo.CambiarNombrePanel();
	System.out.println("entro por vistaArren");


	arrendatarioPrueba= vaa.RetornaArrendatario();
	System.out.println(arrendatarioPrueba.getCedula()+ "que esta imprimiendo??");
		if(arrendatarioPrueba!=null){
		
			vVehiculo.setTxtNroSocio(vaa.llenarCodigo()); 
			vVehiculo.setTxtNomSocio(vaa.llenarNombre());
			listaAvancesArren= vaa.LlenarListaAvancesArren();
			for(int i=0; i<vaa.LlenarListaAvancesArren().size();i++)
			{
				vVehiculo.setCmbConductor(vaa.LlenarListaAvancesArren().get(i).getNombre()+ " "+
						vaa.LlenarListaAvancesArren().get(i).getApellido());
			}
		
			try {
				vVehiculo.LlenarComboMarca();
				this.obtenerVehiculoArren();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public ControladorVehiculo(VistaSocio vs) {
		// TODO Auto-generated constructor stub
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		vVehiculo.agregarListener(this);
		vVehiculo.limpiarCampos();
		vVehiculo.CambiarNombrePanel();
		try {
			vVehiculo.LlenarComboMarca();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (vs.Selec()==2){
			vVehiculo.setTxtNroSocio(vs.llenarCodigo2()); 
			vVehiculo.setTxtNomSocio(vs.llenarNombre2());
			
			vVehiculo.setCmbConductor(vs.llenarNombre2());
		}
			
		try {
			this.obtenerVehiculoArren();
			socioPrueba= vs.GuardarSocio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public ControladorVehiculo(VistaArrendatario vA) {
		// TODO Auto-generated constructor stub
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		vVehiculo.agregarListener(this);
		vVehiculo.limpiarCampos();
		vVehiculo.CambiarNombrePanel();
		try {
			vVehiculo.LlenarComboMarca();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (vA.Selec()==2){
			vVehiculo.setTxtNroSocio(vA.llenarCodigo2()); 
			vVehiculo.setTxtNomSocio(vA.llenarNombre2());
			
			vVehiculo.setCmbConductor(vA.llenarNombre2());
		}
			
		try {
			this.obtenerVehiculoArren();
			arrendatarioPrueba= vA.GuardarArrendatario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
			try {
				vVehiculo.limpiarTablaVehiculos();
				this.BuscarSocio();
				this.CargarComboAvance(this.AvancesporSocio(vVehiculo.getTxtNroSocio()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	else if (a.getActionCommand().equalsIgnoreCase("BuscarArrendatario")) {
		try {
			this.BuscarArrendatario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if (a.getActionCommand().equalsIgnoreCase("GuardarArrendatario")) {
		try {
			this.registrarTodoArren();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.limpiarTodo();
	
	}else if (a.getActionCommand().equalsIgnoreCase("AgregarVehiculoArrend")) {
		if (vVehiculo.CamposllenosSocio() && vVehiculo.CamposllenosVehiculo()) {
			this.agregarVehiculoArren();
			
		} else
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del avance", "Atención!", JOptionPane.ERROR_MESSAGE);
		
	}
		else if (a.getActionCommand().equalsIgnoreCase("Limpiar")) {
			vVehiculo.limpiarCampos();
		}
		else if (a.getActionCommand().equalsIgnoreCase("Atras")) {
			//	this.vVehiculo.setVisible(false);
				vVehiculo.limpiarCampos();
				vVehiculo.dispose();
			
		}
		/*else if (a.getActionCommand().equalsIgnoreCase("Siguente")) {
				if(vVehiculo.CamposllenosSocio()==true){
					Cavance =  new ControladorAvance(vSocio);
			}}*/
		else if (a.getActionCommand().equalsIgnoreCase("BuscarPlaca")) {
		try {
			this.BuscarVehiculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("Guardar")) {
			try {
				//this.registrarSocio();
				this.registrarPrueba();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("AgregarVehiculo")) {
			if (this.vVehiculo.CamposllenosVehiculo()) {
				vVehiculo.MostarListado();
				this.agregarVehiculo();
				 
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del vehiculo", "Atención!", JOptionPane.ERROR_MESSAGE);
			

			
			/*List<Vehiculo> listado = null;
			Vector<String> ve;
			//DateFormat dt = DateFormat.getDateInstance();
			//List<Vehiculo> aux = vehiculoDao.obtenerTodos();
				//	if(aux.get)){
		    try {
				listado = vehiculoDao.obtenerTodosxSocio(this.mostrarVenc());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if(listado.size() == 0)
		    	JOptionPane.showMessageDialog(null, this, "No existen vehiculos que cumplan con ese criterio", 0);
		    else
				for(int i = 0; i < listado.size(); i++){
					ve  = new Vector<String>();
					ve.add(listado.get(i).getPlaca());
				    ve.add(listado.get(i).getSerialCarroceria());
					ve.add(listado.get(i).getAnno().toString());
					ve.add(listado.get(i).getMarca());
					vVehiculo.agregarFila(ve); 
				}*/
			
		}
		else if (a.getActionCommand().equalsIgnoreCase("Eliminar Vehiculo")) {
		//	vVehiculo.removerFila();
			this.removerElementoVehiculo();
		}else if(a.getActionCommand().equalsIgnoreCase("BSocTecla")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BPlacVehSocTecla")){
			try {
				this.BuscarVehiculo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BArrendTecl")){
			try {
				this.BuscarArrendatario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BVehArrenTecl")){
			try {
				this.BuscarVehiculoArren();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  }
	
	
	public void comboAvance() throws Exception{
		
		for(int i=0; i<avanceDao.obtenerTodos().size();i++)
		{
			if(avanceDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(vVehiculo.getTxtNroSocio()))
			vVehiculo.setCmbConductor(avanceDao.obtenerTodos().get(i).getNombre()+ " "+
					avanceDao.obtenerTodos().get(i).getApellido());
		}
	}
	
	
	private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vVehiculo.getTxtNroSocio().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Nro. de Socio", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vVehiculo.getTxtNroSocio(); 
			if (socioDao.encontrar(codi)) { 
				socio = socioDao.buscarPorNroSocio(codi);

				String codigo;
				String nombre;

				codigo = socio.getNroSocio();
				vVehiculo.setTxtNroSocio(codigo);

				nombre = socio.getNombre() + " " + socio.getApellido();
				vVehiculo.setTxtNomSocio(nombre);
				
				this.obtenerVehiculos();
				vVehiculo.OcultarListado(this.obtenerVehiculos());	
				this.comboAvance();
				
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public void BuscarAvances(String ava) throws Exception {
		
		Avance avan = new Avance();
		System.out.println("esta llamando al metodo");
		System.out.println(vVehiculo.getTxtNroSocio());
		if (avanceDao.encontrarCod(vVehiculo.getTxtNroSocio())) {
			avan = avanceDao.buscarPorCodSocio(vVehiculo.getTxtNroSocio());
			System.out.println(avan.getApellido());
			
			vVehiculo.setCmbConductor(avan.getNombre() +" "+ avan.getApellido());
			System.out.println(avan.getNombre()+avan.getApellido());
			
		}
	}
	
	 
	
	private void BuscarVehiculo() throws Exception {

		// TODO Auto-generated method stub
		if (vVehiculo.getTxtPlaca().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo placa del Vehiculo", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			
			if (vehiculoDao.encontrar(this.vVehiculo.getTxtPlaca())) { 
				vehiculo = vehiculoDao.buscarPorPlaca(this.vVehiculo.getTxtPlaca());

				String codigo;
				String nombre;
				
				String placa;
				String serial;
				Marca marca;
				Integer año, nropuestos;
				String avance;
				

				codigo = socio.getNroSocio();
				vVehiculo.setTxtNroSocio(codigo);
				nombre = socio.getNombre();
				vVehiculo.setTxtNomSocio(nombre);
				
				placa = vehiculo.getPlaca();
				vVehiculo.setTxtPlaca(placa);
				serial = vehiculo.getSerialCarroceria();
				vVehiculo.setTxtSerial(serial);
				marca = vehiculo.getMarca();
				vVehiculo.setCmbMarcaP(marca.getDescripcion());
				año = vehiculo.getAnno();
				vVehiculo.setTxtAnno(año.toString());
				nropuestos = vehiculo.getNropuestos();
				vVehiculo.setNroPuestos(nropuestos.toString());
				avance = vehiculo.getAvance();
				System.out.println(avance);
				//vVehiculo.setCmbConductorP(avance);
				
				this.BuscarAvances(avance);
			//	vVehiculo.eliminarConductores();
				
				//vVehiculo.setCmbConductor(Integer.parseInt(avance.getNombre()+avance.getApellido()));

			} else
				JOptionPane.showMessageDialog(null, "El vehiculo no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	private void agregarVehiculo() {
		try {
			
			String placa = vVehiculo.getTxtPlaca();
			String serial = vVehiculo.getTxtSerial();
			int marca = vVehiculo.getCmbMarca();
			int año = Integer.parseInt(vVehiculo.getTxtAnno());
		//	int avance = vVehiculo.getCmbConductorInt();
			int cant_puestos= Integer.parseInt(vVehiculo.getNroPuestos());
			String avanceprueba= vVehiculo.getCmbConductor();
			
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setPlaca(placa);
			vehiculo.setSerialCarroceria(serial);
			vehiculo.setMarca(marcaDao.obtenerTodos().get(marca));
			vehiculo.setAnno(año);
			vehiculo.setNropuestos(cant_puestos);
			
/*			System.out.println("avance  " +avanceprueba);
			for(int l=0; l<this.listaAvancesSocio.size();l++){	
					if(avanceprueba.equals(this.listaAvancesSocio.get(l).getNombre()+" "+
					    this.listaAvancesSocio.get(l).getApellido()))
							vehiculo.setAvance(this.listaAvancesSocio.get(l).getCodAvance());*/
						
			
			//este metodo es de prueba...
			System.out.println("avance  " +avanceprueba);
			System.out.println(listaAvancesSocio.size());
			for(int l=0; l<this.listaAvancesSocio.size();l++){	
					if(avanceprueba.equals(this.listaAvancesSocio.get(l).getNombre()+" "+
					    this.listaAvancesSocio.get(l).getApellido()))
							vehiculo.setAvance(this.listaAvancesSocio.get(l).getCodAvance());
			}
			
			socio.getVehiculos().add(vehiculo); 
			this.cargarListadoDeVehiculos();
			
			//avanceprueba=new String();
			//vVehiculo.eliminarConductorCombo();
			vVehiculo.limpiarCamposVehiculo();
		
		} catch (Exception e) {
			// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
			JOptionPane.showMessageDialog(null,e.toString());
		}

	}
	
	
/*	public String traerNombreyApe(List<Vehiculo> vehi, int posi) throws Exception {
		
		String avan="";
		String codi = vehi.get(posi).getAvance();
		
		if(avanceDao.encontrar(codi)){
			Avance sera = avanceDao.buscarPorCodAvance(codi);
			avan = sera.getNombre()+" "+sera.getApellido();
		}
		return avan;
	}*/
	
	public String traerNombreyApe(List<Vehiculo> vehi, int posi) throws Exception {
		
		String avan="";
		Avance sera;
		String codi = vehi.get(posi).getAvance();
		System.out.println("nuevo metooodooo. " +codi);
		List<Avance> Avances = this.AvancesporSocio(vehi.get(posi).getSocio().getNroSocio());
		System.out.println(Avances.size());
		for(int i=0; i < Avances.size();i++)
		{
			System.out.println("avances por socio" +Avances.get(i).getCodAvance());
			if(Avances.get(i).getCodAvance().equalsIgnoreCase(codi))
			{
				System.out.println("entro en el if");
				sera = Avances.get(i);
				avan = sera.getNombre()+" "+sera.getApellido();
			}
		}
		return avan;
	}
	
	public void avanceNombre(List<Vehiculo> vehi, int pos){
		Vehiculo veh= new Vehiculo();
		veh.setAvance(vVehiculo.getCmbConductor());
		
		vehi.add(pos, veh);
	}
	
	protected void cargarListadoDeVehiculos() throws Exception {
		
		
		if(socio.getVehiculos().size()>0)
		{
			List<Vehiculo> vehiculos = socio.getVehiculos();
			vVehiculo.limpiarTablaVehiculos();
			for(int i=0; i<vehiculos.size(); i++)
			{
				//this.avanceNombre(vehiculos, i);
				String placa = vehiculos.get(i).getPlaca();
				String serial = vehiculos.get(i).getSerialCarroceria();
				String marca = vehiculos.get(i).getMarca().getDescripcion().toString();
				Integer año = vehiculos.get(i).getAnno();
				Integer nropstos= vehiculos.get(i).getNropuestos();
				String avance = vVehiculo.getCmbConductor();//vehiculos.get(i).getAvance();
				System.out.println(avance+"del metodo");
					
				//System.out.println(avance);
		//	String avance= this.traerNombreyApe(vehiculos, i);
						vVehiculo.getCmbConductor();
					
				//	String avance = vehiculos.get(i).getNombre()+" "+vehiculos.get(i).getAvance().getApellido();
				
				vVehiculo.agregarFila(placa, serial, marca, año.toString(),nropstos.toString(), avance);
				
			}
		}		
	}
	
	/*public boolean encontrarAvanceSocio(){
		boolean enc=true;
		String codavan;
		try {
			for(int i = 0; i < vehiculoDao.obtenerTodos().size(); i++)
			{
				if(vehiculoDao.obtenerTodos().get(i).getAvance().equals("null")){
					codavan=vehiculoDao.obtenerTodos().get(i).getAvance().getCodAvance();
						if(avanceDao.buscarPorCodAvance(codavan).getSocio().getNroSocio().equals(vVehiculo.getTxtNroSocio()));
					{
						return enc=true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}*/
	
	public ArrayList<Vehiculo> obtenerVehiculos() throws Exception{
		ArrayList<Vehiculo> listado = new ArrayList<Vehiculo>();
		
		for(int i = 0; i < vehiculoDao.obtenerTodos().size(); i++)
			if(vehiculoDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(vVehiculo.getTxtNroSocio()))
					listado.add(vehiculoDao.obtenerTodos().get(i));
		
		socio.setVehiculos(listado);
		this.cargarListadoDeVehiculos();
		
		return listado;
	}
	
	private void registrarSocio() throws Exception {

		
			Socio socio = new Socio();
						
			//setear todos los atri de socio...
			String codi = vVehiculo.getTxtNroSocio();
				System.out.println(codi);
			socio = socioDao.buscarPorNroSocio(codi);
			
			for(Vehiculo veh : this.socio.getVehiculos()){
				veh.setSocio(socio);
					if(!vehDao.encontrar(veh.getPlaca()))
					{
					//	System.out.println("veh: "+veh.getSocio().getNombre());
					//	veh.setSocio(socioDao.buscarPorNroSocio("null")); ////*****AQUI NO SE ESTA TRAYENDO EL COD DEL SOCIO***/////
						vehDao.agregarVehiculo(veh);
					}
			}
			
		
			
		//	vSocio.mostrarMensaje("Socio Registrado con exito");
			
		} //else
		//	this.vSocio.mostrarMensaje("Debe llenar todos los campos");
		
	public void removerElementoVehiculo(){
		if(vVehiculo.filaSeleccionada()>=0){
			socio.getVehiculos().remove(vVehiculo.filaSeleccionada());
		}
	}
	
	public List<Avance> AvancesporSocio(String nroSocio){
		ArrayList<Avance> listaAvan= new ArrayList<>();
		
		try {
			for(int i=0;i < avanceDao.obtenerTodos().size();i++){
				if(avanceDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(nroSocio))
					listaAvan.add(avanceDao.obtenerTodos().get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAvan;
	}
	
	public void CargarComboAvance(List<Avance> lista){
		for(int i=0;i<lista.size();i++){
			vVehiculo.setCmbConductor(lista.get(i).getNombre()+" "+lista.get(i).getApellido());
		}
	}
	
	/*public void guardarTodo(){
		String avanceprueba,placa,serial,marca,anno,puestos;
		//boolean encontroSocio=false, encontroAvance=false;
		
		try {
				System.out.println(vVehiculo.getTblListadoVehiculo().getRowCount());
				for(int k=0; k<vVehiculo.getTblListadoVehiculo().getRowCount();k++)
				{
					Vehiculo veh= new Vehiculo();
					
					placa=(String) vVehiculo.getTblListadoVehiculo().getValueAt(k,0);
					serial=(String)vVehiculo.getTblListadoVehiculo().getValueAt(k,1);
					marca=(String) vVehiculo.getTblListadoVehiculo().getValueAt(k,2);
					anno=(String) vVehiculo.getTblListadoVehiculo().getValueAt(k,3);
					puestos=(String) vVehiculo.getTblListadoVehiculo().getValueAt(k,4);
					avanceprueba=(String) vVehiculo.getTblListadoVehiculo().getValueAt(k,5);
					
					if(vehDao.encontrar(placa)==false)
					{
						veh.setPlaca(placa);
						veh.setSerialCarroceria(serial);
						veh.setCodMarca(marcaDao.buscarPorNombre(marca));
						veh.setAnno(Integer.parseInt(anno));
						veh.setNropuestos(Integer.parseInt(puestos));
						for(int i=0; i< listaAvancesSocio.size();i++)
						{
							if(avanceprueba.equals(listaAvancesSocio.get(i).getNombre()+" "+listaAvancesSocio.get(i).getApellido()))
								avan= listaAvancesSocio.get(i);
						}
						for(int l=0; l<avanceDao.obtenerTodos().size();l++){	
						//veh.setAvance(this.guardarAvance(avan));
							if(avanceprueba.equals(avanceDao.obtenerTodos().get(l).getNombre()+" "+avanceDao.obtenerTodos().get(l).getApellido()))
							veh.setAvance(avanceprueba);(listaAvancesSocio.get(0)
											avanceDao.obtenerTodos().get(l));
						}
						for(int i=0; i<socioDao.obtenerTodos().size();i++){	
							
							if(socioDao.obtenerTodos().get(i).getNroSocio().equals(vVehiculo.getTxtNroSocio())){
								veh.setSocio(socioDao.obtenerTodos().get(i));
								}
							System.out.println(socioDao.obtenerTodos().get(i).getNroSocio());
						}		
						//veh.setSocio(socio);
						//System.out.println("socio del socio: "+ socio.getNroSocio());
						vehiculoDao.agregarVehiculo(veh);
					}	
				}
				
				JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
						JOptionPane.INFORMATION_MESSAGE);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	//////////////****************************METODO DE PRUEBA(no esta a prueba de fallos)*****************************////////////////////
	
	
	public String asignarCodAvance(){
		Integer nro_avances=0;
	
		try {
			nro_avances= avanceDao.obtenerTodos().size()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return "A"+nro_avances.toString();	
	}

	private void registrarPrueba() throws Exception {
		
		if (vVehiculo.CamposllenosSocio() == true) {

			Socio socio = new Socio();		
		//BUSCAR EL SOCIO
			String codi = vVehiculo.getTxtNroSocio();
			
				if(!socioDao.encontrar(codi))
				{
					socioDao.agregarSocio(socioPrueba);
				}
				socio = socioDao.buscarPorNroSocio(codi);
				
			for(Avance avan : this.listaAvancesSocio) //////aqui dudas... va el get o va la lista de la vista llenarAvances
			{
				avan.setSocio(socio);
				avan.setCodAvance(this.asignarCodAvance());
				if(!avanceDao.encontrarPorCedula(avan.getCedula()))
					{
						avanceDao.agregarAvance(avan);
					}
			}
			
			for(Vehiculo vehi : vVehiculo.LlenarListaVehiculos()) //////aqui dudas... va el get o va la lista de la vista llenarvehiculos
			{
				
				vehi.setSocio(socio);
				//Asignar al avance
				System.out.println("probando daooo "+ avanceDao.ObtenerPorSocios(socio.getNroSocio()).size());
				for(Avance avance : avanceDao.ObtenerPorSocios(codi)) {
					if(((avance.getNombre()+" "+avance.getApellido()).equalsIgnoreCase(vehi.getAvance())))
					{
						vehi.setAvance(avance.getCodAvance());
						//break;
					}
				}	
				if(!vehiculoDao.encontrar(vehi.getPlaca()))
					{
						vehiculoDao.agregarVehiculo(vehi);;
					}
			}			
		} else
			this.vSocio.mostrarMensaje("Debe llenar todos los campos");
	} 
	
	
	
	
	
	
		
		///**************************** METODOS ARRENDATARIO-VEHICULO*************************************////
		
		
		
	public ArrayList<VehiculoArrendatario> obtenerVehiculoArren() throws Exception{
			ArrayList<VehiculoArrendatario> listado = new ArrayList<VehiculoArrendatario>();
			for(int i = 0; i < vehArrenDao.obtenerTodos().size(); i++)
				if(vehArrenDao.obtenerTodos().get(i).getArrendatario().getCedula().equals(vVehiculo.getTxtNroSocio()))
					listado.add(vehArrenDao.obtenerTodos().get(i));
			
			arrendatario.setVehiculos(listado);
			this.cargarListadoDeVehiculosArren();
			
			return listado;
	}
	
	public String traerNombreyApe1(List<VehiculoArrendatario> vehi, int posi) throws Exception {
		
		String avan="";
		String codi = vehi.get(posi).getAvance();
		VistaArrendatario vA = new VistaArrendatario();
		if(vA.Selec()==2)
			avan = vVehiculo.getCmbConductor();
		else
		if(avanceArrenDao.encontrar(codi)){
			AvanceArrendatario sera = avanceArrenDao.buscarPorCodAvanceArren(codi);
			avan = sera.getNombre()+" "+sera.getApellido();
		}
		return avan;
	}
		
		protected void cargarListadoDeVehiculosArren() throws Exception {
			
			
			if(arrendatario.getVehiculos().size()>0)
			{
				List<VehiculoArrendatario> vehiculos = arrendatario.getVehiculos();
				vVehiculo.limpiarTablaVehiculos();
				for(int i=0; i<vehiculos.size(); i++)
				{
					String placa = vehiculos.get(i).getPlaca();
					String serial = vehiculos.get(i).getSerialCarroceria();
					String marca = vehiculos.get(i).getCodMarca().getDescripcion().toString();
					Integer año = vehiculos.get(i).getAnno();
					Integer nropstos= vehiculos.get(i).getNropuestos();
					//String avance = vehiculos.get(i).getAvance();
					
				
					String avance= this.traerNombreyApe1(vehiculos, i);
						
					//	String avance = vehiculos.get(i).getNombre()+" "+vehiculos.get(i).getAvance().getApellido();
					
					vVehiculo.agregarFila(placa, serial, marca, año.toString(),nropstos.toString(), avance);
				}
			}		
		}
		
		
		private void BuscarArrendatario() throws Exception {

			// TODO Auto-generated method stub
			if (vVehiculo.getTxtNroSocio().equals(null)) {

				JOptionPane.showMessageDialog(null, "Debe llenar el campo codigo arrendatario", "Atención!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				
				String codi = vVehiculo.getTxtNroSocio(); 
				if (arrenDao.encontrar(codi)) { 
					arrendatario = arrenDao.buscarPorCedulaArrendatario(codi);

					String codigo;
					String nombre;

					codigo = arrendatario.getCedula();
					vVehiculo.setTxtNroSocio(codigo);

					nombre = arrendatario.getNombre();
					vVehiculo.setTxtNomSocio(nombre+" "+arrendatario.getApellido());
					
		
				//	this.cargarListadoDeAvances();  // RECORDAR TRAERSE LA LISTA DE TODOOS LOS AVANCES DE ESE SOCIO.!!!!
					this.obtenerVehiculoArren();
				} else
					JOptionPane.showMessageDialog(null, "El  arrendatario no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		private void BuscarVehiculoArren() throws Exception {

			// TODO Auto-generated method stub
			if (vVehiculo.getTxtPlaca().equalsIgnoreCase("")) {

				JOptionPane.showMessageDialog(null, "Debe llenar el campo placa del Vehiculo", "Atención!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				
				
				if (vehArrenDao.encontrar(this.vVehiculo.getTxtPlaca())) { 
				 vehiArren = vehArrenDao.buscarPorPlaca(vVehiculo.getTxtPlaca());

					String codigo;
					String nombre;
					
					String placa;
					String serial;
					Marca marca;
					Integer año;
					String avance;
					

					codigo = socio.getNroSocio();
					vVehiculo.setTxtNroSocio(codigo);
					nombre = socio.getNombre();
					vVehiculo.setTxtNomSocio(nombre);
					
					placa = vehiculo.getPlaca();
					vVehiculo.setTxtPlaca(placa);
					serial = vehiculo.getSerialCarroceria();
					vVehiculo.setTxtSerial(serial);
					marca = vehiculo.getMarca();
					vVehiculo.setCmbMarca(Integer.parseInt(marca.getCodMarca()));
					año = vehiculo.getAnno();
					vVehiculo.setTxtAnno(año.toString());
					//avance = vehiculo.getAvance();
					
				//	this.BuscarAvances();
				//	vVehiculo.eliminarConductores();
					
					//vVehiculo.setCmbConductor(Integer.parseInt(avance.getNombre()+avance.getApellido()));

				} else
					JOptionPane.showMessageDialog(null, "El vehiculo no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void BuscarAvancesArrendatario() throws Exception {
			
			AvanceArrendatario avan = new AvanceArrendatario();
			
			if (avanceDao.encontrarCod(vVehiculo.getTxtNroSocio())) {
				avan = avanceArrenDao.buscarPorCodArrendatario(vVehiculo.getTxtNroSocio());
				
				vVehiculo.setCmbConductor(Integer.parseInt(avan.getNombre()+avan.getApellido()));
				
			}
		}
		
		
		private void agregarVehiculoArren() {
			try {
				
				String placa = vVehiculo.getTxtPlaca();
				String serial = vVehiculo.getTxtSerial();
				int marca = vVehiculo.getCmbMarca();
				int año = Integer.parseInt(vVehiculo.getTxtAnno());
			//	int avance = vVehiculo.getCmbConductorInt();
				int cant_puestos= Integer.parseInt(vVehiculo.getNroPuestos());
				String avanceprueba= vVehiculo.getCmbConductor();
				
				VehiculoArrendatario vehiculo = new VehiculoArrendatario();
				vehiculo.setPlaca(placa);
				vehiculo.setSerialCarroceria(serial);
				vehiculo.setCodMarca(marcaDao.obtenerTodos().get(marca));
				vehiculo.setAnno(año);
				vehiculo.setNropuestos(cant_puestos);
					
				if (avanceArrenDao.obtenerTodos().size()==0)
					vehiculo.setAvance(avanceprueba);
				else{
				for(int l=0; l<avanceArrenDao.obtenerTodos().size();l++){	
					//veh.setAvance(this.guardarAvance(avan));
						if(avanceprueba.equals(avanceArrenDao.obtenerTodos().get(l).getNombre()+" "+avanceArrenDao.obtenerTodos().get(l).getApellido()))
						vehiculo.setAvance(avanceDao.obtenerTodos().get(l).getCodAvance());
					}
				}
				arrendatario.getVehiculos().add(vehiculo); 
				this.cargarListadoDeVehiculosArren();
				
				vVehiculo.eliminarConductorCombo();
				vVehiculo.limpiarCamposVehiculo();
			
			} catch (Exception e) {
				// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
				JOptionPane.showMessageDialog(null,e.toString());
			}

		}
		
		
		/*private void registrarVehiculoArren() throws Exception {
			System.out.println("registrando");
			if (this.vVehiculo.CamposllenosSocio() == true) {

				Arrendatario arren = new Arrendatario();		
			//BUSCAR EL Arrendatario
				String codi = vVehiculo.getTxtNroSocio();
				
					if(!arrenDao.encontrar(codi))
					{
						arrenDao.agregarArrendatario(arren);
					}
					arren = arrenDao.buscarPorCedulaArrendatario(codi);
					
				for(VehiculoArrendatario vehi : this.arrendatario.getVehiculos())
				{
					vehi.setArrendatario(arrendatario);
					if(!vehArrenDao.encontrar(vehi.getPlaca()))
						{
							vehArrenDao.agregarVehiculoArren(vehi);
						}
				}			
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Atención!", JOptionPane.ERROR_MESSAGE);
		} */
		
		private void modificarVehiculoArren() throws Exception {
			if (vVehiculo.CamposllenosSocio() == true) {
				arrendatario.setNombre(vVehiculo.getTxtNomSocio());
				String nro = vVehiculo.getTxtNroSocio();
				arrenDao.encontrar(nro);
				arrenDao.actualizarArrendatario(Integer.parseInt(nro), arrendatario);
				for (VehiculoArrendatario a : arrendatario.getVehiculos()) {
					a.setArrendatario(arrendatario);
					if (!vehArrenDao.encontrar(a.getPlaca()))
						vehArrenDao.agregarVehiculoArren(a);
				}
				JOptionPane.showMessageDialog(null, "Vehiculo Modificado con éxito");
				vehiArren = new VehiculoArrendatario();
				vVehiculo.limpiarCampos();
				this.limpiarTodo();
				//vgrupocola.enabledCampos(false);
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}
		
		
		private void limpiarTodo() {
			vVehiculo.limpiarTablaVehiculos();
			vehiculo = new Vehiculo();
			vVehiculo.limpiarCampos();
		}
		
	public void removerElementoArren(){
			
			if(vVehiculo.filaSeleccionada()>=0)
				arrendatario.getVehiculos().remove(vVehiculo.filaSeleccionada());
		}
	
	
	
	public String asignarCodAvanceArren(){
		Integer nro_avances=0;
	
		try {
			nro_avances= avanceArrenDao.obtenerTodos().size()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return "AA"+nro_avances.toString();	
	}

	private void registrarTodoArren() throws Exception {
		
		if (vVehiculo.CamposllenosSocio() == true) {

			Arrendatario arren = new Arrendatario();		
		//BUSCAR EL SOCIO
			String codi = vVehiculo.getTxtNroSocio();
			
				if(!arrenDao.encontrar(codi))
				{
					System.out.println(!arrenDao.encontrar(codi));
					System.out.println(arrendatarioPrueba.getApellido());
					arrenDao.agregarArrendatario(arrendatarioPrueba);
				}
				arren = arrenDao.buscarPorCedulaArrendatario(codi);
				
			for(AvanceArrendatario avan : this.listaAvancesArren) //////aqui dudas... va el get o va la lista de la vista llenarAvances
			{
				avan.setArrendatario(arren);
				avan.setCodAvance(this.asignarCodAvanceArren());
				if(!avanceArrenDao.encontrarCedArrendatario(avan.getCedula()))
					{
						avanceArrenDao.agregarAvance(avan);
					}
			}
			
			for(VehiculoArrendatario vehi : vVehiculo.LlenarListaVehiculosArren()) //////aqui dudas... va el get o va la lista de la vista llenarvehiculos
			{
				
				vehi.setArrendatario(arren);
				//Asignar al avance
				for(AvanceArrendatario avance : avanceArrenDao.ObtenerPorArrendatarios(codi)) {
					if(((avance.getNombre()+" "+avance.getApellido()).equalsIgnoreCase(vehi.getAvance())))
					{
						vehi.setAvance(avance.getCodAvance());
					}
				}	
				if(!vehArrenDao.encontrar(vehi.getPlaca()))
					{
						vehArrenDao.agregarVehiculoArren(vehi);
					}
			}			
		} else
			this.vSocio.mostrarMensaje("Debe llenar todos los campos");
	} 
	
	
	
	
}
	
