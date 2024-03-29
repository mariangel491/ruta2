package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.AvanceArrendatario;
import Modelos.Socio;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.AvanceArrendatarioDao;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaArrendatario;
import Vistas.VistaAvance;
import Vistas.VistaAvanceArren;
import Vistas.VistaSocio;
import Vistas.VistaVehiculo;


public class ControladorAvance implements ActionListener, KeyListener {
	
	private VistaAvance vAvance;
	private VistaSocio vSocio;
	private VistaArrendatario vArrendatario;
	private VistaAvanceArren vAvanceArren;
	
	AvanceDao avanceDao = new AvanceDao();
	private SocioDao socioDao = new SocioDao();
	ArrendatarioDao arrenDao = new ArrendatarioDao();
	AvanceArrendatarioDao avanceArrenDao= new AvanceArrendatarioDao();
	
	Avance avance = new Avance();
	Socio socio= new Socio();
	Arrendatario arrendatario= new Arrendatario();
	AvanceArrendatario avanceArrend= new AvanceArrendatario();
	Socio socioprueba= new Socio();
	Arrendatario arrendatarioPrueba= new Arrendatario();
	ControladorVehiculo vehiculo;
	
	public ControladorAvance(String resp) {
		super();
		// TODO Auto-generated constructor stub
		vAvance = new VistaAvance();
		vAvance = vAvance.obtenerInstancia();
		vAvance.setLocationRelativeTo(null);
		vAvance.setVisible(true);
		vAvance.agregarListener(this);
		vAvance.limpiarTablaAvances();
		vAvance.agregarKeyTel(this);
		vAvance.OcultarBotones();
		
		/*vAvanceArren = new VistaAvanceArren();
		vAvanceArren = vAvanceArren.obtenerInstancia();
		vAvanceArren.setLocationRelativeTo(null);
		vAvanceArren.setVisible(true);
		vAvanceArren.agregarListener(this);
		vAvanceArren.limpiarTablaAvances();*/
		
		if(resp.equals("Avance")){
		this.asignarCod();
		}
		/*if(resp.equals("Avance Arrendatario")){
			//vAvance.CambiarNombrePanel();
			this.asignarCodArrend();
			
		}*/
	}
	

	/*public ControladorAvance(VistaArrendatario va){
		vAvanceArren = new VistaAvanceArren();
		vAvanceArren = vAvanceArren.obtenerInstancia();
		vAvanceArren.setLocationRelativeTo(null);
		vAvanceArren.setVisible(true);
		vAvanceArren.agregarListener(this);
		vAvanceArren.CambiarNombrePanel();
		
		//if (va.Selec()==1){
		vAvanceArren.setTxtNroSocio(va.llenarCodigo());
		vAvanceArren.setTxtNomSocio(va.llenarNombre());
		//}
		try {
			this.obtenerAvanceArren();
			this.asignarCodArrend();
			arrendatarioPrueba= va.GuardarArrendatario();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/
	


	public ControladorAvance(VistaSocio vs) {
		super();
		// TODO Auto-generated constructor stub
		vAvance = new VistaAvance();
		vAvance = vAvance.obtenerInstancia();
		vAvance.setLocationRelativeTo(null);
		vAvance.setVisible(true);
		vAvance.agregarListener(this);
		vAvance.OcultarBotones();
		//if(vs.Selec()==1){
		vAvance.setTxtNroSocio(vs.llenarCodigo());
		vAvance.setTxtNomSocio(vs.llenarNombre());
		//}
		try {
			this.obtenerAvance();
			this.asignarCod();
			socioprueba= vs.GuardarSocio();
			
			vAvance.GuardarSocio(socioprueba);
			vAvance.RetornaSocio();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//PARA GENERAR EL CODIGO AUTOM�TICAMENTE
	public String asignarCod(){
		Integer nro_avances=0;
	
		try {
			nro_avances= avanceDao.obtenerTodos().size()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return "A"+nro_avances.toString();	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
				try {
					this.BuscarSocio();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if (a.getActionCommand().equalsIgnoreCase("BuscarArrendatario")) {
			try {
			//	this.BuscarArrendatario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("GuardarArrendatario")) {
			try {
			//	this.registrarAvanceArren();                   revisar esto que esta aqui para confirmar.....
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.limpiarTodo();
		}
		else if (a.getActionCommand().equalsIgnoreCase("Limpiar")) {
			this.limpiarTodo();
			vAvance.regresar();
		}else if (a.getActionCommand().equalsIgnoreCase("Modificar")) {
			
			try {
				
				this.modificarAvance();
				this.obtenerAvance();
				vAvance.OcultarBotones();
				vAvance.regresar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("Cancelar")) {
			vAvance.cerrarVentana();
			//vSocio.cerrarVentana();
			try {
			//	this.registrarAvanceSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("BuscarAvanceArrendatario")) {
			try {
			//	this.BuscarAvanceArren();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("BuscarAvance")) {
			try {
				this.BuscarAvanceSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("Siguiente")) {
			//vAvance.LlenarListaAvancesPrueba();
			
			if(vAvance.CamposllenosSocio() ==true){
				vehiculo =  new ControladorVehiculo(vAvance);
			}
			
		}
		else if (a.getActionCommand().equalsIgnoreCase("Agregar Avance")) {
			if (this.vAvance.CamposllenosAvance()) {
				this.agregarAvanceSocio();
				//this.asignarCod();
				
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del avance", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
			
		}else if (a.getActionCommand().equalsIgnoreCase("AgregarAvanceArrend")) {
			if (this.vAvanceArren.CamposllenosAvance()) {
		//		this.agregarAvanceArren();
			//	this.asignarCodArrend();
				
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del avance", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
			
		}else if(a.getActionCommand().equalsIgnoreCase("BCedAvanSocTecla")){
			try {
				this.BuscarAvanceSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BNroSocTecla")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BArrendatTecla")){
			try {
			//	this.BuscarArrendatario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BCedAvanArrendTecla")){
			try {
		//		this.BuscarAvanceArren();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (a.getActionCommand().equalsIgnoreCase("Eliminar Avance")) {
			
			System.out.println(vAvance.filaSeleccionada());
		
				vAvance.removerFila();
				this.removerElementoSocio();
			} else
				JOptionPane.showMessageDialog(null, "El avance ha sido eliminado", "Atenci�n!", JOptionPane.INFORMATION_MESSAGE);
				
		//}
	}

	
	
	protected void cargarListadoDeAvances() throws Exception {		
		String cod, apellido, nombre,ced, direccion, fecha="";
		String telefono;
		
		if(socio.getAvances().size()>0)
		{
			List<Avance>avances= socio.getAvances();
			vAvance.limpiarTablaAvances();
			for(int i=0;i<avances.size();i++)
			{
				//cod=avances.get(i).getCodAvance();
				apellido=avances.get(i).getApellido();
				nombre=avances.get(i).getNombre();
				telefono=avances.get(i).getTelefono().toString();
				direccion=avances.get(i).getDireccion();
				ced= avances.get(i).getCedula();
				Date f= new Date();
				fecha= f.toString();
				
				vAvance.agregarFila(/*cod, */apellido, nombre, ced, telefono, direccion, fecha);
				
			}	
		}	
	}
	
	public ArrayList<Avance> obtenerAvance() throws Exception{
		ArrayList<Avance> listado = new ArrayList<Avance>();
		for(int i = 0; i < avanceDao.obtenerTodos().size(); i++)
			if(avanceDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(vAvance.getTxtNroSocio()))
				listado.add(avanceDao.obtenerTodos().get(i));
		
		socio.setAvances(listado);
		this.cargarListadoDeAvances();
		
		return listado;
	
	}
	

	
	private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vAvance.getTxtNroSocio().equals(null)) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Nro. de Socio", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vAvance.getTxtNroSocio(); 
			if (socioDao.encontrar(codi)) { 
				socio = socioDao.buscarPorNroSocio(codi);

				String codigo;
				String nombre;

				codigo = socio.getNroSocio();
				vAvance.setTxtNroSocio(codigo);

				nombre = socio.getNombre();
				vAvance.setTxtNomSocio(nombre+" "+socio.getApellido());
				
	
			//	this.cargarListadoDeAvances();  // RECORDAR TRAERSE LA LISTA DE TODOOS LOS AVANCES DE ESE SOCIO.!!!!
				this.obtenerAvance();
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	private void BuscarAvanceSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vAvance.getTxtCedula().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Cedula de Avance", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String cod = vAvance.getTxtCedula();
			if (avanceDao.encontrarPorCedula(cod)) { 
				avance = avanceDao.buscarPorCedulaAvance(cod);

				String codigo;
				String nombre;
				
				
				String nom;
				String ape;
				String ced;
				String dire;
				Integer telef;
				

				codigo = avance.getSocio().getNroSocio();
				vAvance.setTxtNroSocio(codigo);
				nombre = avance.getSocio().getNombre();
				vAvance.setTxtNomSocio(nombre+" "+ avance.getSocio().getApellido());
				
						
				nom = avance.getNombre();
				vAvance.setTxtNombre(nom);
				ape = avance.getApellido();
				vAvance.setTxtApellido(ape);
				/*ced = avance.getCedula();
				vAvance.setTxtCedula(ced);*/
				dire = avance.getDireccion();
				vAvance.setTxtDireccion(dire);
				telef = avance.getTelefono();
				vAvance.setTxtTelefono(telef.toString());
				
				vAvance.MostarBotones();
				
			} else
				JOptionPane.showMessageDialog(null, "El avance no existe", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void agregarAvanceSocio() {
		try {
			
			String cedula = vAvance.getTxtCedula();
			String nombre = vAvance.getTxtNombre();
			String apellido = vAvance.getTxtApellido();
			Integer telefono = Integer.parseInt(vAvance.getTxtTelefono());
			String direccion = vAvance.getTxtDireccion();
		//	String codAvance = vAvance.getTxtCodAvance();
			Date fecha= new Date();
			
			Avance avance = new Avance();
			avance.setNombre(nombre);
			avance.setCedula(cedula);
			avance.setApellido(apellido);
			avance.setDireccion(direccion);
			avance.setTelefono(telefono);
			avance.setCodAvance(this.asignarCod()); //debe generarse auto..??
			avance.setFechaIngreso(fecha);
			
			socio.getAvances().add(avance);
			this.cargarListadoDeAvances();
			
			vAvance.limpiarCamposAvance();
		
		} catch (Exception e) {
			// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
			JOptionPane.showMessageDialog(null,e.toString());
		}

	}
	
	/*private void modificar() throws Exception {
		
		if (vAvance.CamposllenosSocio() == true) {
			socio.setNombre(vAvance.getTxtNomSocio());
			String nro = vAvance.getTxtNroSocio();
			socioDao.encontrar(nro);
			
			System.out.println("que imprime la busqueda" + " " + socioDao.encontrar(nro));
			
			//socioDao.actualizarSocio(Integer.parseInt(nro), socio);
			socioDao.actualizarSocio(socio);
			for (Avance a : socio.getAvances()) {
				a.setSocio(socio);
				if (!avanceDao.encontrar(a.getCedula()))
					avanceDao.agregarAvance(a);
			}
			JOptionPane.showMessageDialog(null, "Avance Modificado con exito");
			avance = new Avance();
			vAvance.limpiarCampos();
			this.limpiarTodo();
			//vgrupocola.enabledCampos(false);
		} else
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
	}*/
	
	private void modificarAvance() throws Exception {
		
		
		 String ced="", codSocio=vAvance.getTxtNroSocio();
		 int posi= this.buscarAvance(ced,codSocio);		
		 
		 if (vAvance.CamposllenosAvance() == true) {
			 
			 avance.setNombre(vAvance.getTxtNombre());
			 avance.setApellido(vAvance.getTxtApellido());
			 avance.setDireccion(vAvance.getTxtDireccion().toUpperCase());
			 avance.setTelefono(Integer.parseInt(vAvance.getTxtTelefono()));
			
			 vAvance.limpiarTablaAvances();
			 avanceDao.actualizarAvance(avance);
			 
			 JOptionPane.showMessageDialog(null, "Se ha modificado el Avance exitosamente", "Atenci�n!", JOptionPane.INFORMATION_MESSAGE);
			 
		 }
			
					vAvance.limpiarCamposAvance();
	}
	
	
	public int buscarAvance (String ced, String codSocio) throws Exception
	{	
		
		
		System.out.println(avanceDao.ObtenerPorSocios(codSocio).size());
		for (int i=0; i<avanceDao.ObtenerPorSocios(codSocio).size(); i++){
	      
	        if (avanceDao.ObtenerPorSocios(codSocio).get(i).equals(vAvance.getTxtCedula()))
	        	  return i;
	        System.out.println(i+"buscar Avance ");
		}
		return -1;
	 }

	
	private void limpiarTodo() {
		vAvance.limpiarTablaAvances();
		avance = new Avance();
		vAvance.limpiarCamposAvance();
		vAvance.limpiarCamposSocio();
	}
	
	public void removerElementoSocio(){
		
		if(vAvance.filaSeleccionada()>0)
			socio.getAvances().remove(vAvance.filaSeleccionada());
	
		
	}
	
	/*private void registrarAvanceSocio() throws Exception {
		System.out.println("registrando");
		if (this.vAvance.CamposllenosSocio() == true) {

			Socio socio = new Socio();		
		//BUSCAR EL SOCIO
			String codi = vAvance.getTxtNroSocio();
			
				if(!socioDao.encontrar(codi))
				{
					socioDao.agregarSocio(socioprueba);
				}
				socio = socioDao.buscarPorNroSocio(codi);
				
			for(Avance avan : this.socio.getAvances())
			{
				avan.setSocio(socio);
				avan.setCodAvance(this.asignarCod());
				if(!avanceDao.encontrar(avan.getCodAvance()))
					{
						avanceDao.agregarAvance(avan);
					}
			}			
		} else
			this.vSocio.mostrarMensaje("Debe llenar todos los campos");
	} */
	
	
	/////***********************METODOS ARRENDATARIO-AVANCE**************************///
	
	public String asignarCodArrend(){
		Integer nro_avances=0;
		try {
			nro_avances = avanceArrenDao.obtenerTodos().size()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "C"+nro_avances.toString();
		
	}
	
	
	public ArrayList<AvanceArrendatario> obtenerAvanceArren() throws Exception{
		ArrayList<AvanceArrendatario> listado = new ArrayList<AvanceArrendatario>();
		for(int i = 0; i < avanceArrenDao.obtenerTodos().size(); i++)
			if(avanceArrenDao.obtenerTodos().get(i).getArrendatario().getCedula().equals(vAvance.getTxtNroSocio()))
				listado.add(avanceArrenDao.obtenerTodos().get(i));
		
		arrendatario.setAvances(listado);
		this.cargarListadoDeAvancesArren();
		
		return listado;
	}
	
	protected void cargarListadoDeAvancesArren() throws Exception {		
		String cod, apellido, nombre,ced, direccion, fecha="";
		String telefono;
		
		if(arrendatario.getAvances().size()>0)
		{
			List<AvanceArrendatario> avances= arrendatario.getAvances();
			vAvance.limpiarTablaAvances();
			for(int i=0;i<avances.size();i++)
			{
				cod=avances.get(i).getCodAvance();
				apellido=avances.get(i).getApellido();
				nombre=avances.get(i).getNombre();
				telefono=avances.get(i).getTelefono().toString();
				direccion=avances.get(i).getDireccion();
				ced= avances.get(i).getCedula();
				Date f= new Date();
				fecha= f.toString();
				vAvance.agregarFila(/*cod, */apellido, nombre, ced, telefono, direccion, fecha);
				
			}	
		}	
	}
	
	/*private void agregarAvanceArren() {
		try {
			
			String cedula = vAvance.getTxtCedula();
			String nombre = vAvance.getTxtNombre();
			String apellido = vAvance.getTxtApellido();
			Integer telefono = Integer.parseInt(vAvance.getTxtTelefono());
			String direccion = vAvance.getTxtDireccion();
			Date fecha= new Date();
			
			AvanceArrendatario avance = new AvanceArrendatario();
			avance.setNombre(nombre);
			avance.setCedula(cedula);
			avance.setApellido(apellido);
			avance.setDireccion(direccion);
			avance.setTelefono(telefono);
			avance.setCodAvance(this.asignarCodArrend()); //debe generarse auto..??
			avance.setFechaIngreso(fecha);
			
			arrendatario.getAvances().add(avance);
			this.cargarListadoDeAvancesArren();
		
			vAvance.limpiarCampos();
		
		} catch (Exception e) {
			// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
			JOptionPane.showMessageDialog(null,e.toString());
		}

	}
	
	
	private void BuscarArrendatario() throws Exception {

		// TODO Auto-generated method stub
		if (vAvance.getTxtNroSocio().equals(null)) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo codigo arrendatario", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vAvance.getTxtNroSocio(); 
			if (arrenDao.encontrar(codi)) { 
				arrendatario = arrenDao.buscarPorCedulaArrendatario(codi);

				String codigo;
				String nombre;

				codigo = arrendatario.getCedula();
				vAvance.setTxtNroSocio(codigo);

				nombre = arrendatario.getNombre();
				vAvance.setTxtNomSocio(nombre+" "+arrendatario.getApellido());
				
	
			//	this.cargarListadoDeAvances();  // RECORDAR TRAERSE LA LISTA DE TODOOS LOS AVANCES DE ESE SOCIO.!!!!
				this.obtenerAvanceArren();
			} else
				JOptionPane.showMessageDialog(null, "El  arrendatario no existe", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void BuscarAvanceArren() throws Exception {

		// TODO Auto-generated method stub
		if (vAvance.getTxtCedula().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo C�digo de Avance", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String cod = vAvance.getTxtCedula();
			if (avanceArrenDao.encontrar(cod)) { 
				avanceArrend = avanceArrenDao.buscarPorCodAvanceArren(cod);

				String codigo;
				String nombre;
				
				
				String nom, ape, ced, dire, codi;
				//Date fecha;
				Integer telef;
				

				codigo = avanceArrend.getArrendatario().getCedula();
				vAvance.setTxtNroSocio(codigo);
				nombre = avanceArrend.getArrendatario().getNombre();
				vAvance.setTxtNomSocio(nombre+" "+ avanceArrend.getArrendatario().getApellido());
				
				
				//codi = avanceArrend.getCodAvance();
				nom = avanceArrend.getNombre();
				vAvance.setTxtNombre(nom);
				ape = avanceArrend.getApellido();
				vAvance.setTxtApellido(ape);
				ced = avanceArrend.getCedula();
				vAvance.setTxtCedula(ced);
				dire = avanceArrend.getDireccion();
				vAvance.setTxtDireccion(dire);
				telef = avanceArrend.getTelefono();
				vAvance.setTxtTelefono(telef.toString());
				
			//	this.cargarListadoDeAvances();
			} else
				JOptionPane.showMessageDialog(null, "El avance no existe", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		}
	}*/
	
	
/*	private void registrarAvanceArren() throws Exception {
		System.out.println("registrando");
		if (this.vAvance.CamposllenosSocio() == true) {

			Arrendatario arren = new Arrendatario();		
		//BUSCAR EL Arrendatario
			String codi = vAvance.getTxtNroSocio();
			
				if(!arrenDao.encontrar(codi))
				{
					arrenDao.agregarArrendatario(arren);
				}
				arren = arrenDao.buscarPorCedulaArrendatario(codi);
				
			for(AvanceArrendatario avan : this.arrendatario.getAvances())
			{
				avan.setArrendatario(arrendatario);
				if(!avanceArrenDao.encontrar(avan.getCodAvance()))
					{
						avanceArrenDao.agregarAvance(avan);
					}
			}			
		} else
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
	} 
*/	
	/*private void modificarAvanceArren() throws Exception {
		if (vAvance.CamposllenosSocio() == true) {
			socio.setNombre(vAvance.getTxtNomSocio());
			String nro = vAvance.getTxtNroSocio();
			socioDao.encontrar(nro);
			//socioDao.actualizarSocio(Integer.parseInt(nro), socio);
			socioDao.actualizarSocio(socio);
			for (Avance a : socio.getAvances()) {
				a.setSocio(socio);
				if (!avanceDao.encontrar(a.getCedula()))
					avanceDao.agregarAvance(a);
			}
			JOptionPane.showMessageDialog(null, "Avance Modificado con exito");
			avance = new Avance();
			vAvance.limpiarCampos();
			this.limpiarTodo();
			//vgrupocola.enabledCampos(false);
		} else
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
	}
	
	
public void removerElementoArren(){
		
		if(vAvance.filaSeleccionada()>=0)
			arrendatario.getAvances().remove(vAvance.filaSeleccionada());
	}
*/

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyTyped(KeyEvent key) {
	// TODO Auto-generated method stub
	char c = key.getKeyChar();
	if (!Character.isDigit(key.getKeyChar()) && c!='-' && c!='.')
		key.consume();
		
}
	
}
