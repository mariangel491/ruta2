package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Arrendatario;
import Modelos.Avance;
import Modelos.Prestamos;
import Modelos.Socio;
import Modelos.Hibernate.Daos.PrestamosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaFac;
import Vistas.VistaPrestamo;



public class ControladorPrestamo implements ActionListener, KeyListener {
	
	private VistaPrestamo vPrestamo;
	PrestamosDao prestamosDao = new PrestamosDao();
	Prestamos prestamos = new Prestamos();
	private SocioDao socioDao = new SocioDao();
	private Socio socio = new Socio();
	private VistaFac vistaF= new VistaFac();
	
	//PARA LO DE LOS REPORTES
	
		private VistaFac vfac;
	
	
	public ControladorPrestamo() {
		vPrestamo = new VistaPrestamo();
		vPrestamo = vPrestamo.obtenerInstancia();
		vPrestamo.setLocationRelativeTo(null);
		vPrestamo.setVisible(true);
		vPrestamo.agregarListener(this);
		vPrestamo.OcultarTodo();
		vPrestamo.limpiarCampos();
		vPrestamo.asignarCod();
		//vPrestamo.agregarKey(this);
	}
	
	public ControladorPrestamo(VistaFac vf) {
		vPrestamo = new VistaPrestamo();
		vistaF = vf;
		vPrestamo = vPrestamo.obtenerInstancia();
		vPrestamo.setLocationRelativeTo(null);
		vPrestamo.setVisible(true);
		vPrestamo.agregarListener(this);
		vPrestamo.OcultarCasiTodo();
		vPrestamo.limpiarCampos();
		vPrestamo.asignarCod();
		vPrestamo.setTxtNroSocio(vf.getTxtNroSocio());
		vPrestamo.setTxtNomSocio(vf.getTxtNombSocio()+ " " + vf.getTxtApellido().getText());
		vPrestamo.setTxtMonto(vf.getTxtMontoIngresoEgreso());
		vPrestamo.DesactivarCampos();
		
		//vPrestamo.agregarKey(this);
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
			
		}
		else if (a.getActionCommand().equalsIgnoreCase("Salir")) {
			vPrestamo.cerrarVentana();
		}
		else if (a.getActionCommand().equalsIgnoreCase("Modificar")) {
		
		}
		else if (a.getActionCommand().equalsIgnoreCase("Agregar")) {
			vPrestamo.Habilitar();
			
		}
		else if (a.getActionCommand().equalsIgnoreCase("Guardar")) {
			try {
				this.AgregarPrestamos();
				
				vPrestamo.dispose();
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BSocioTecla")){
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vPrestamo.getTxtNroSocio().equals(null)) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Nro. de Socio", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vPrestamo.getTxtNroSocio(); 
			if (socioDao.encontrar(codi)) { 
				Socio socio = socioDao.buscarPorNroSocio(codi);

				String codigo;
				String nombre;

				codigo = socio.getNroSocio();
				vPrestamo.setTxtNroSocio(codigo);

				nombre = socio.getNombre();
				vPrestamo.setTxtNomSocio(nombre);
				
				vPrestamo.OcultarListado(this.LlenarListado());
				this.LlenarListado();
				//vPrestamo.LlenarListaPrestamos(/*this.LlenarListado()*/);
				
				
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public static Date getFechaActual() {
	    Date fecha = new Date();
	    return fecha;
	}
	

	
public ArrayList<Prestamos> LlenarListado () throws Exception {
	
		ArrayList<Prestamos> listado = new ArrayList<Prestamos>();
		
		for (int i = 0; i<prestamosDao.obtenerTodos().size(); i++) {
	
			Prestamos p= new Prestamos();
			if(prestamosDao.obtenerTodos().get(i).getNroSocio().getNroSocio().equals(vPrestamo.getTxtNroSocio())) 
			{
				listado.add(prestamosDao.obtenerTodos().get(i));
				p=prestamosDao.obtenerTodos().get(i);
				vPrestamo.agregarfilaPrestamos(p.getCodPrestamo(), p.getDescripcion(), Float.toString(p.getMonto()), p.getFechaEmision().toString());
			}
		
		}
			socio.setPrestamos(listado);
		return listado;
			
	}
	
	
	public void AgregarPrestamos() throws Exception{
		
		
		prestamos.setCodPrestamo(vPrestamo.getTxtCodPrestamo());
		prestamos.setDescripcion(vPrestamo.getTxtDescripcion());
		prestamos.setFechaEmision(this.getFechaActual());
		prestamos.setMonto(Float.parseFloat(vPrestamo.getTxtMonto()));
		prestamos.setStatus('A');
		prestamos.setNroSocio(socioDao.buscarPorNroSocio(vPrestamo.getTxtNroSocio()));
		
			//prestamosDao.agregarPrestamos(prestamos);
		vPrestamo.AnnadirPrestamosProv(prestamos);
		System.out.println("tam lista prest "+ vPrestamo.getListaPrest().size());
		vistaF.agregarFilaPrestIng(vPrestamo.getTxtCodPrestamo(), vPrestamo.getTxtDescripcion(), vPrestamo.getTxtMonto());
		vistaF.LlenarLista(prestamos);
			vPrestamo.limpiarCampos();
			
	}
	
	private void actualizarStatus() throws Exception {
		
		Integer nro = Integer.parseInt(vPrestamo.getTxtNroSocio());
		prestamosDao.encontrar(nro);
		
		if(prestamos.getMonto()== 0) {
			prestamos.setStatus('C');
			prestamosDao.actualizarPrestamos(nro, prestamos);
		}
			}
			
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!Character.isDigit(e.getKeyChar()))
			e.consume();
	}

}
