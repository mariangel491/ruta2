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
import Vistas.VistaPrestamo;



public class ControladorPrestamo implements ActionListener, KeyListener {
	
	private VistaPrestamo vPrestamo;
	PrestamosDao prestamosDao = new PrestamosDao();
	Prestamos prestamos = new Prestamos();
	private SocioDao socioDao = new SocioDao();
	private Socio socio = new Socio();
	
	//PARA LO DE LOS REPORTES
	
		
	
	
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
				System.out.println(codigo);

				nombre = socio.getNombre();
				vPrestamo.setTxtNomSocio(nombre);
				System.out.println(nombre);
				
				vPrestamo.OcultarListado(this.LlenarListado());
				vPrestamo.LlenarListaPrestamos(this.LlenarListado());
				
				
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	public static Date getFechaActual() {
	    Date fecha = new Date();
	   // SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	    //return formateador.format(fecha);
	    return fecha;
	}
	

	
public ArrayList<Prestamos> LlenarListado () throws Exception {
	
		ArrayList<Prestamos> listado = new ArrayList<Prestamos>();
		
		for (int i = 0; i<prestamosDao.obtenerTodos().size(); i++) {
			if(prestamosDao.obtenerTodos().get(i).getNroSocio().equals(vPrestamo.getTxtNroSocio())) 
				System.out.println(listado.size()  +"1do");
				listado.add(prestamosDao.obtenerTodos().get(i));
				System.out.println(listado.size()  +"2do");
		
		}
			socio.setPrestamos(listado);
			System.out.println(listado.size()+  "no se");
		
		return listado;
			
	}
	
	
	public void AgregarPrestamos() throws Exception{
		
		
		prestamos.setCodPrestamo(vPrestamo.getTxtCodPrestamo());
		prestamos.setDescripcion(vPrestamo.getTxtDescripcion());
		prestamos.setFechaEmision(this.getFechaActual());
		prestamos.setMonto(Float.parseFloat(vPrestamo.getTxtMonto()));
		prestamos.setStatus('A');
		prestamos.setNroSocio(socioDao.buscarPorNroSocio(vPrestamo.getTxtNroSocio()));
		
			prestamosDao.agregarPrestamos(prestamos);
			vPrestamo.limpiarCampos();
			
	}
	
	private void actualizarStatus() throws Exception {
		
		Integer nro = Integer.parseInt(vPrestamo.getTxtNroSocio());
		prestamosDao.encontrar(nro);
		
		if(prestamos.getMonto()== 0) {
			prestamos.setStatus('C');
			prestamosDao.actualizarPrestamos(nro, prestamos);
		}
		System.out.println(prestamos.getMonto());
	
		
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
