package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import Modelos.Avance;
import Modelos.Marca;
import Modelos.Socio;
import Modelos.Vehiculo;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.MarcaDao;
import Modelos.Hibernate.Daos.SocioDao;
import Modelos.Hibernate.Daos.VehiculoDao;
import Vistas.VistaArrendatario;
import Vistas.VistaAvance;
import Vistas.VistaSocio;
import Vistas.VistaVehiculo;



public class ControladorVehiculo implements ActionListener {
	
	//cuuando se guarde el inquilino poner lq vista invisible y traerse
	/*los datos de inquilino a la vista de alquiler y al guardar alquiler destruir
	 * ambas ventanas*/
	
	private VistaVehiculo vVehiculo;
	protected VistaSocio vSocio;
	//private VistaAvance vAcance;
	
	VehiculoDao vehiculoDao = new VehiculoDao();
	Vehiculo vehiculo = new Vehiculo();
	private Socio socio = new Socio();
	private Avance avan = new Avance();
	
	private SocioDao socioDao = new SocioDao();
	private MarcaDao marcaDao= new MarcaDao();
	VehiculoDao vehDao= new VehiculoDao();
	private AvanceDao avanceDao = new AvanceDao();
	
	private List<Avance> listaAvancesSocio=new ArrayList<>();

	ControladorAvance Cavance;
	ControladorSocio Csocio;
	
	public ControladorVehiculo(ControladorSocio Csocio) {
		this.Csocio = Csocio;
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
	}
	
	
	public ControladorVehiculo(VistaAvance va) {
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		vVehiculo.agregarListener(this);
		vVehiculo.setTxtNroSocio(va.llenarCodigo()); 
		vVehiculo.setTxtNomSocio(va.llenarNombre());
		listaAvancesSocio= va.LlenarListaAvances();
		for(int i=0; i<va.LlenarListaAvances().size();i++)
		{
			vVehiculo.setCmbConductor(va.LlenarListaAvances().get(i).getNombre()+ " "+
					va.LlenarListaAvances().get(i).getApellido());
		}
		
		try {
			vVehiculo.LlenarComboMarca();
			this.obtenerVehiculos();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public ControladorVehiculo(VistaArrendatario vArrendatario) {
		// TODO Auto-generated constructor stub
		vVehiculo = new VistaVehiculo();
		vVehiculo = vVehiculo.obtenerInstancia();
		vVehiculo.setLocationRelativeTo(null);
		vVehiculo.setVisible(true);
		vVehiculo.agregarListener(this);
		vVehiculo.setTxtNroSocio(vArrendatario.llenarCodigo()); 
		vVehiculo.setTxtNomSocio(vArrendatario.llenarNombre());

	/*	try {
			this.obtenerAvanceArren();
			this.asignarCodArrend();
			arrendatarioPrueba= va.GuardarArrendatario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
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
		else if (a.getActionCommand().equalsIgnoreCase("Limpiar")) {
			vVehiculo.limpiarCampos();
		}
		else if (a.getActionCommand().equalsIgnoreCase("Atras")) {
				this.vVehiculo.setVisible(false);
			
		}
		else if (a.getActionCommand().equalsIgnoreCase("Siguente")) {
				if(vVehiculo.CamposllenosSocio()==true){
					Cavance =  new ControladorAvance(vSocio);
			}}
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
				this.registrarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("AgregarVehiculo")) {
			System.out.println("agregando vehiculo");
			if (this.vVehiculo.CamposllenosVehiculo()) {
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

				nombre = socio.getNombre();
				vVehiculo.setTxtNomSocio(nombre);
				
				this.obtenerVehiculos();
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public void BuscarAvances() throws Exception {
		
		Avance avan = new Avance();
		
		if (avanceDao.encontrarCod(vVehiculo.getTxtNroSocio())) {
			avan = avanceDao.buscarPorCodSocio(vVehiculo.getTxtNroSocio());
			
			vVehiculo.setCmbConductor(Integer.parseInt(avan.getNombre()+avan.getApellido()));
			
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
				marca = vehiculo.getCodMarca();
				vVehiculo.setCmbMarca(Integer.parseInt(marca.getCodMarca()));
				año = vehiculo.getAnno();
				vVehiculo.setTxtAnno(año.toString());
				//avance = vehiculo.getAvance();
				
				this.BuscarAvances();
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
			Integer año = Integer.parseInt(vVehiculo.getTxtAnno());
		//	int avance = vVehiculo.getCmbConductorInt();
			Integer cant_puestos= Integer.parseInt(vVehiculo.getNroPuestos());
			String avanceprueba= vVehiculo.getCmbConductor();
			
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setPlaca(placa);
			vehiculo.setSerialCarroceria(serial);
			vehiculo.setCodMarca(marcaDao.obtenerTodos().get(marca));
			vehiculo.setAnno(año);
			vehiculo.setNropuestos(cant_puestos);
				
			for(int l=0; l<avanceDao.obtenerTodos().size();l++){	
				//veh.setAvance(this.guardarAvance(avan));
					if(avanceprueba.equals(avanceDao.obtenerTodos().get(l).getNombre()+" "+avanceDao.obtenerTodos().get(l).getApellido()))
					vehiculo.setAvance(avanceDao.obtenerTodos().get(l).getCodAvance());
				}
			socio.getVehiculos().add(vehiculo); 
			this.cargarListadoDeVehiculos();
			
			vVehiculo.eliminarConductorCombo();
			vVehiculo.limpiarCamposVehiculo();
		
		} catch (Exception e) {
			// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
			JOptionPane.showMessageDialog(null,e.toString());
		}

	}
	
	
	public String traerNombreyApe(List<Vehiculo> vehi, int posi) throws Exception {
		
		String avan="";
		String codi = vehi.get(posi).getAvance();
		
		if(avanceDao.encontrar(codi)){
			Avance sera = avanceDao.buscarPorCodAvance(codi);
			avan = sera.getNombre()+" "+sera.getApellido();
		}
		return avan;
	}
	
	protected void cargarListadoDeVehiculos() throws Exception {
		
		
		if(socio.getVehiculos().size()>0)
		{
			List<Vehiculo> vehiculos = socio.getVehiculos();
			vVehiculo.limpiarTablaVehiculos();
			for(int i=0; i<vehiculos.size(); i++)
			{
				String placa = vehiculos.get(i).getPlaca();
				String serial = vehiculos.get(i).getSerialCarroceria();
				String marca = vehiculos.get(i).getCodMarca().getDescripcion().toString();
				Integer año = vehiculos.get(i).getAnno();
				Integer nropstos= vehiculos.get(i).getNropuestos();
				//String avance = vehiculos.get(i).getAvance();
				
			
				String avance= this.traerNombreyApe(vehiculos, i);
					
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
			
		/*	else {
					if(vehiculoDao.obtenerTodos().get(i).getSocio().getNroSocio().equals("null")
							&&encontrarAvanceSocio()==true){
						listado.add(vehiculoDao.obtenerTodos().get(i));	
					}
				}*/
		
		socio.setVehiculos(listado);
		System.out.println(listado.get(0).getAvance());
		System.out.println(listado.get(1).getAvance());
		System.out.println(listado.get(2).getAvance());
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
				//veh.setSocio(socio);
				System.out.println(socio.getNombre());
					if(!vehDao.encontrar(veh.getPlaca()))
					{
					//	System.out.println("veh: "+veh.getSocio().getNombre());
						veh.setSocio(socioDao.buscarPorNroSocio("null"));
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
	
	public void guardarTodo(){
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
						/*for(int i=0; i< listaAvancesSocio.size();i++)
						{
							if(avanceprueba.equals(listaAvancesSocio.get(i).getNombre()+" "+listaAvancesSocio.get(i).getApellido()))
								avan= listaAvancesSocio.get(i);
						}*/
						for(int l=0; l<avanceDao.obtenerTodos().size();l++){	
						//veh.setAvance(this.guardarAvance(avan));
							if(avanceprueba.equals(avanceDao.obtenerTodos().get(l).getNombre()+" "+avanceDao.obtenerTodos().get(l).getApellido()))
							veh.setAvance(avanceprueba);/*(*//*listaAvancesSocio.get(0)*/
											/*avanceDao.obtenerTodos().get(l));*/
						}
						/*for(int i=0; i<socioDao.obtenerTodos().size();i++){	
							
							if(socioDao.obtenerTodos().get(i).getNroSocio().equals(vVehiculo.getTxtNroSocio())){
								veh.setSocio(socioDao.obtenerTodos().get(i));
								}
							System.out.println(socioDao.obtenerTodos().get(i).getNroSocio());
						}		*/
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
		
	}
	
}
