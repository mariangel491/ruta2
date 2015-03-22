package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Arrendatario;
import Modelos.AvanceArrendatario;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.AvanceArrendatarioDao;
import Vistas.VistaArrendatario;
import Vistas.VistaAvanceArren;

public class ControladorAvanceArrendatario implements ActionListener {

		
		private VistaArrendatario vArrendatario;
		private VistaAvanceArren vAvanceArren;
		
		ArrendatarioDao arrenDao = new ArrendatarioDao();
		AvanceArrendatarioDao avanceArrenDao= new AvanceArrendatarioDao();
		
		Arrendatario arrendatario= new Arrendatario();
		AvanceArrendatario avanceArrend= new AvanceArrendatario();
		Arrendatario arrendatarioPrueba= new Arrendatario();
		ControladorVehiculo vehiculo;
		
		public ControladorAvanceArrendatario(String resp) {
			super();
			// TODO Auto-generated constructor stub
			
			vAvanceArren = new VistaAvanceArren();
			vAvanceArren = vAvanceArren.obtenerInstancia();
			vAvanceArren.setLocationRelativeTo(null);
			vAvanceArren.setVisible(true);
			vAvanceArren.agregarListener(this);
			vAvanceArren.limpiarTablaAvances();
			
			if(resp.equals("Avance Arrendatario")){
				//vAvance.CambiarNombrePanel();
				this.asignarCodArrend();
				
			}
		}
		

		public ControladorAvanceArrendatario(VistaArrendatario va){
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
		
		}
		
		
		
		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			 if (a.getActionCommand().equalsIgnoreCase("BuscarArrendatario")) {
				try {
					this.BuscarArrendatario();
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
			}
			else if (a.getActionCommand().equalsIgnoreCase("Cancelar")) {
				vAvanceArren.cerrarVentana();
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
					this.BuscarAvanceArren();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (a.getActionCommand().equalsIgnoreCase("Siguiente")) {
				//vAvance.LlenarListaAvancesPrueba();
				
				if(vAvanceArren.CamposllenosSocio() ==true){
					vehiculo =  new ControladorVehiculo(vAvanceArren);
				}
				
			}
			else  if (a.getActionCommand().equalsIgnoreCase("AgregarAvanceArrend")) {
				if (this.vAvanceArren.CamposllenosAvance()) {
					this.agregarAvanceArren();
				//	this.asignarCodArrend();
					
				} else
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del avance", "Atención!", JOptionPane.ERROR_MESSAGE);
				
			}else if(a.getActionCommand().equalsIgnoreCase("BArrendatTecla")){
				try {
					this.BuscarArrendatario();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(a.getActionCommand().equalsIgnoreCase("BCedAvanArrendTecla")){
				try {
					this.BuscarAvanceArren();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (a.getActionCommand().equalsIgnoreCase("Eliminar Avance Arrendatario")) {
			
					vAvanceArren.removerFila();
					this.removerElementoArren();
				} else
					JOptionPane.showMessageDialog(null, "El avance ha sido eliminado", "Atención!", JOptionPane.INFORMATION_MESSAGE);
					
			//}
		}

		
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
				if(avanceArrenDao.obtenerTodos().get(i).getArrendatario().getCedula().equals(vAvanceArren.getTxtNroSocio()))
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
				vAvanceArren.limpiarTablaAvances();
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
					vAvanceArren.agregarFila(/*cod, */apellido, nombre, ced, telefono, direccion, fecha);
					
				}	
			}	
		}
		
		private void agregarAvanceArren() {
			try {
				
				String cedula = vAvanceArren.getTxtCedula();
				String nombre = vAvanceArren.getTxtNombre();
				String apellido = vAvanceArren.getTxtApellido();
				Integer telefono = Integer.parseInt(vAvanceArren.getTxtTelefono());
				String direccion = vAvanceArren.getTxtDireccion();
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
			
				vAvanceArren.limpiarCampos();
			
			} catch (Exception e) {
				// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
				JOptionPane.showMessageDialog(null,e.toString());
			}

		}
		
		
		private void BuscarArrendatario() throws Exception {

			// TODO Auto-generated method stub
			if (vAvanceArren.getTxtNroSocio().equals(null)) {

				JOptionPane.showMessageDialog(null, "Debe llenar el campo codigo arrendatario", "Atención!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				
				String codi = vAvanceArren.getTxtNroSocio(); 
				if (arrenDao.encontrar(codi)) { 
					arrendatario = arrenDao.buscarPorCedulaArrendatario(codi);

					String codigo;
					String nombre;

					codigo = arrendatario.getCedula();
					vAvanceArren.setTxtNroSocio(codigo);

					nombre = arrendatario.getNombre();
					vAvanceArren.setTxtNomSocio(nombre+" "+arrendatario.getApellido());
					
		
				//	this.cargarListadoDeAvances();  // RECORDAR TRAERSE LA LISTA DE TODOOS LOS AVANCES DE ESE SOCIO.!!!!
					this.obtenerAvanceArren();
				} else
					JOptionPane.showMessageDialog(null, "El  arrendatario no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		private void BuscarAvanceArren() throws Exception {

			// TODO Auto-generated method stub
			if (vAvanceArren.getTxtCedula().equalsIgnoreCase("")) {

				JOptionPane.showMessageDialog(null, "Debe llenar el campo Código de Avance", "Atención!", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				
				String cod = vAvanceArren.getTxtCedula();
				if (avanceArrenDao.encontrar(cod)) { 
					avanceArrend = avanceArrenDao.buscarPorCodAvanceArren(cod);

					String codigo;
					String nombre;
					
					
					String nom, ape, ced, dire, codi;
					//Date fecha;
					Integer telef;
					

					codigo = avanceArrend.getArrendatario().getCedula();
					vAvanceArren.setTxtNroSocio(codigo);
					nombre = avanceArrend.getArrendatario().getNombre();
					vAvanceArren.setTxtNomSocio(nombre+" "+ avanceArrend.getArrendatario().getApellido());
					
					
					//codi = avanceArrend.getCodAvance();
					nom = avanceArrend.getNombre();
					vAvanceArren.setTxtNombre(nom);
					ape = avanceArrend.getApellido();
					vAvanceArren.setTxtApellido(ape);
					ced = avanceArrend.getCedula();
					vAvanceArren.setTxtCedula(ced);
					dire = avanceArrend.getDireccion();
					vAvanceArren.setTxtDireccion(dire);
					telef = avanceArrend.getTelefono();
					vAvanceArren.setTxtTelefono(telef.toString());
					
				//	this.cargarListadoDeAvances();
				} else
					JOptionPane.showMessageDialog(null, "El avance no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	
		private void modificarAvanceArren() throws Exception {
			if (vAvanceArren.CamposllenosSocio() == true) {
				arrendatario.setNombre(vAvanceArren.getTxtNomSocio());
				String nro = vAvanceArren.getTxtNroSocio();
				arrenDao.encontrar(nro);
				arrenDao.actualizarSocio(Integer.parseInt(nro), socio);
				for (Avance a : socio.getAvances()) {
					a.setSocio(socio);
					if (!avanceDao.encontrar(a.getCedula()))
						avanceDao.agregarAvance(a);
				}
				JOptionPane.showMessageDialog(null, "Avance Modificado con exito");
				avance = new Avance();
				vAvanceArren.limpiarCampos();
				this.limpiarTodo();
				//vgrupocola.enabledCampos(false);
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		}
		
		
	public void removerElementoArren(){
			
			if(vAvanceArren.filaSeleccionada()>=0)
				arrendatario.getAvances().remove(vAvanceArren.filaSeleccionada());
		}


}
