package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelos.Arrendatario;
import Modelos.Hibernate.Daos.ArrendatarioDao;
import Modelos.Hibernate.Daos.EgresosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaArrendatario;

public class ControladorArrendatario implements ActionListener {
	
	private VistaArrendatario vArrendatario= new VistaArrendatario();
	private ArrendatarioDao arrenDao= new ArrendatarioDao();
	private EgresosDao Dao = new EgresosDao(); 
	private Arrendatario arren= new Arrendatario();
	
	ControladorAvance avance;
	ControladorVehiculo vehiculo;

	public ControladorArrendatario() {
		super();
		 vArrendatario = new VistaArrendatario();
		 vArrendatario.obtenerInstancia();
		 vArrendatario.setLocationRelativeTo(null);
		 vArrendatario.setVisible(true);
		 vArrendatario.agregarListener(this);

}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Limpiar")){
			
			vArrendatario.limpiarCampos();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			
			vArrendatario.cerrarVentana();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
			try {
				this.modificar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Siguiente")){
			if(vArrendatario.CamposLlenos()==true) {
			   if(vArrendatario.Seleccion()==1)
				   avance =  new ControladorAvance(vArrendatario);
			   else if(vArrendatario.Seleccion()==2)
				   vehiculo= new ControladorVehiculo(vArrendatario);
			}
		}else if(ae.getActionCommand().equalsIgnoreCase("BuscarCedTecl")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void AgregarArrendatario() throws Exception{
		
		RutaDao rutaDao = new RutaDao();
		
		arren.setCedula(vArrendatario.getTxtCedulaRif());
		arren.setApellido(vArrendatario.getTxtApellido());
		arren.setDireccion(vArrendatario.getTxtDireccion());
		arren.setNombre(vArrendatario.getTxtNombre());
		arren.setStatus("Activo");
		arren.setTelefono(Integer.parseInt(vArrendatario.getTxtTelefono()));
		arren.setMonto(Float.parseFloat(vArrendatario.getTxtMonto()));
		arren.setRuta(rutaDao.obtenerRuta("J-306-902686"));
		
			arrenDao.agregarArrendatario(arren);
			vArrendatario.limpiarCampos();
			
		
	}
	
	
	private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vArrendatario.getTxtCedulaRif().equals("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Cédula", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vArrendatario.getTxtCedulaRif(); 
			System.out.println(arrenDao.encontrar(codi));
			if (arrenDao.encontrar(codi)) { 
				arren = arrenDao.buscarPorCedulaArrendatario(codi);

				String nombre;
				String direc;
				String ced;
				String ape;
				Integer telef;
				Float monto;

				nombre = arren.getNombre();
				vArrendatario.setTxtNombre(nombre);
				direc = arren.getDireccion();
				vArrendatario.setTxtDireccion(direc);
				ced = arren.getCedula();
				vArrendatario.setTxtCedulaRif(ced.toString());
				ape = arren.getApellido();
				vArrendatario.setTxtApellido(ape);
				telef = arren.getTelefono();
				vArrendatario.setTxtTelefono(telef.toString());
				monto = arren.getMonto();
				vArrendatario.setTxtMonto(monto.toString());
				
			//	this.cargarListadoDeAvances();
			} else
				JOptionPane.showMessageDialog(null, "El Arrendatario no existe", "Atención!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	private void modificar() throws Exception {
		if (vArrendatario.CamposLlenos() == true) {
			
			Integer nro = Integer.parseInt(vArrendatario.getTxtCedulaRif());
			arrenDao.encontrar(nro.toString());
			
			arren.setCedula(vArrendatario.getTxtCedulaRif());
			arren.setApellido(vArrendatario.getTxtApellido());
			arren.setDireccion(vArrendatario.getTxtDireccion());
			arren.setNombre(vArrendatario.getTxtNombre());
			arren.setStatus("Activo");
			arren.setTelefono(Integer.parseInt(vArrendatario.getTxtTelefono()));
			arren.setMonto(Float.parseFloat(vArrendatario.getTxtMonto()));
			RutaDao rutaDao = new RutaDao();
			arren.setRuta(rutaDao.obtenerRuta("J-306-902686"));
			
			arrenDao.actualizarArrendatario((nro), arren);
			
			JOptionPane.showMessageDialog(null, "Arrendatario Modificado con exito");
			arren = new Arrendatario();
			vArrendatario.limpiarCampos();

			
		} else
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
	}
	
	
}
