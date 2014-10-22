package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





import Modelos.Socio;
import Modelos.Avance;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.RutaDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaAvance;
import Vistas.VistaSocio;
import Vistas.VistaVehiculo;
import Vistas.vTablaAvance;



public class ControladorSocio implements ActionListener {
	
	protected VistaSocio vSocio;
	private VistaAvance vAvance;
	SocioDao socioDao = new SocioDao();
	AvanceDao avanceDao = new AvanceDao();
	RutaDao rutaDao= new RutaDao();
	Socio socio = new Socio();
	
	ControladorVehiculo vehiculo;
	ControladorAvance avance;

	public ControladorSocio() {
		vSocio = new VistaSocio();
		vSocio.setLocationRelativeTo(null);
		vSocio.setVisible(true);
		vSocio.agregarListener(this);
	}
	
	/*public ControladorSocio(VistaVehiculo vh) {
		vSocio = new VistaSocio();
		vSocio.setLocationRelativeTo(null);
		vSocio.setVisible(true);
		vSocio.agregarListener(this);
		vSocio.setTxtNroSocio(vh.llenarCodigo());
		vSocio.setTxtNomSocio(vh.llenarNombre());
	  
	}*/

	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getActionCommand().equalsIgnoreCase("Agregar Avance")) {

		/*	if (this.vAvance.CamposllenosAvance()) { //aqui hay dudas,necesito saber si puedo
				this.agregarAvanceSocio();			//implementar un controlador dentro de otro.?
			} else*/
				vSocio.mostrarMensaje("Debe llenar todos los campos de avance");
		} else 
			if (a.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			if (a.getActionCommand().equalsIgnoreCase("Cancelar")) {
			vSocio.cerrarVentana();
		} else 
			if (a.getActionCommand().equalsIgnoreCase("Limpiar")) {
			vSocio.limpiarCampos();
		}else 
			if (a.getActionCommand().equalsIgnoreCase("Siguiente")) {
				if(vSocio.CamposllenosSocio()==true){
					avance =  new ControladorAvance(vSocio);
					//vSocio.este();
				 //vehiculo = new ControladorVehiculo(vSocio);  ///Hay que probar que resultado da esto?
				} else
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del Socio", "Atenci�n!", JOptionPane.ERROR_MESSAGE);
		}
		if (a.getActionCommand().equalsIgnoreCase("Modificar")) {
			try {
				this.registrarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BuscarNumSocTeclado")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BusCedTeclado")){
			try {
				this.BuscarSocioCed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void BuscarSocioCed() throws Exception {

		// TODO Auto-generated method stub
		if (vSocio.getTxtCedSocio().equals("")) {
			vSocio.mostrarMensaje("Debe llenar el campo codigo");
		} 
		else {
			
			String cedula = vSocio.getTxtCedSocio(); //convertir en integer.. o usar codigo como String

			if (socioDao.encontrarCed(cedula)) { 
				socio = socioDao.buscarPorCedula(cedula);
				
				String codigo, nombre, direc, ced, ape;
				Integer telef;

				codigo = socio.getNroSocio();
				vSocio.setTxtNroSocio(codigo);
				nombre = socio.getNombre();
				vSocio.setTxtNomSocio(nombre);
				direc = socio.getDireccion();
				vSocio.setTxtDirecSocio(direc);
				ced = socio.getCedula();
				vSocio.setTxtCedSocio(ced);
				ape = socio.getApellido();
				vSocio.setTxtApellidoSoc(ape);
				telef = socio.getTelefono();
				vSocio.setTxtTelefono(telef.toString());
				
			} else
				vSocio.mostrarMensaje("El socio no existe");
		}
	}
	
	
		private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vSocio.getTxtNroSocio().equals("")) {

			vSocio.mostrarMensaje("Debe llenar el campo codigo");
			
		} 
		else {
			
			String codi = vSocio.getTxtNroSocio(); //convertir en integer.. o usar codigo como String

			if (socioDao.encontrar(codi)) { 
				socio = socioDao.buscarPorNroSocio(codi);
				

				String codigo;
				String nombre;
				String direc;
				String ced;
				String ape;
				Integer telef;

				codigo = socio.getNroSocio();
				vSocio.setTxtNroSocio(codigo);
				nombre = socio.getNombre();
				vSocio.setTxtNomSocio(nombre);
				direc = socio.getDireccion();
				vSocio.setTxtDirecSocio(direc);
				ced = socio.getCedula();
				vSocio.setTxtCedSocio(ced);
				ape = socio.getApellido();
				vSocio.setTxtApellidoSoc(ape);
				telef = socio.getTelefono();
				vSocio.setTxtTelefono(telef.toString());
				
			//	this.cargarListadoDeAvances();
			} else
				vSocio.mostrarMensaje("El socio no existe");
		}
	}
	
	

	/*protected void cargarListadoDeAvances() {
		if (socio.getAvances().size() > 0) {
			List<Avance> avances = socio.getAvances();
			vAvance.setListado(new vTablaAvance(avances)); // cargar la tabla
		}
	}*/
	
	public void registrarSocio() throws Exception {
		Date fechaIngreso= new Date();
		if (this.vSocio.CamposllenosSocio() == true) {

			Socio socio = new Socio();
			socio.setNroSocio(vSocio.getTxtNroSocio());
			socio.setCedula(vSocio.getTxtCedSocio());
			socio.setNombre(vSocio.getTxtnomSocio());
			socio.setApellido(vSocio.getTxtapellidoSoc());
			socio.setDireccion(vSocio.getTxtdirecSocio());
			socio.setTelefono(Integer.parseInt(vSocio.getTxttelefono()));
			socio.setFechaIngreso(fechaIngreso);
			socio.setStatus('A');
			socio.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
			//socio.setAvances(avances);
			//socio.setVehiculos(vehiculos);
			
			//setear todos los atri de socio...
			String codi = socio.getNroSocio();
			if(!socioDao.encontrar(codi))
			{
				socio.setMontoAhorro(0);
				socioDao.agregarSocio(socio);
			}
			//socio = socioDao.buscarPorNroSocio(codi);
			
		/*	for(Avance avan : this.socio.getAvances()){
				avan.setSocio(socio);
				if(!avanceDao.encontrar(avan.getCedula()))
					avanceDao.agregarAvance(avan);
			}*/
			
			vSocio.mostrarMensaje("Socio Registrado con exito");
			
		} else
			this.vSocio.mostrarMensaje("Debe llenar todos los campos");
	} 

	

}
