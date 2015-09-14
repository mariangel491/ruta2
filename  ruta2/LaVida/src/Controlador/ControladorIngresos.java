package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelos.Ingresos;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaIngresos;
import Vistas.VistaMostrar;

public class ControladorIngresos implements ActionListener, KeyListener {
	
	private RutaDao ruta = new RutaDao();
	private Ingresos ing= new Ingresos();
	private VistaIngresos VIng;
	private IngresosDao ingDao= new IngresosDao();
	private VistaMostrar mostrar= new VistaMostrar();
	
	
	public ControladorIngresos() {
		
		VIng= new VistaIngresos();
		VIng= VIng.obtenerInstancia();
		VIng.setLocationRelativeTo(null);
		VIng.setVisible(true);
		VIng.setResizable(false);	
		VIng.agregarListener(this);
		VIng.ActivarComponentes();
		

	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equalsIgnoreCase("Limpiar")){
				VIng.limpiarCampos();
				VIng.ActivarComponentes();
		}else if(ae.getActionCommand().equalsIgnoreCase("Salir")){
			VIng.cerrarVentana();
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
				VIng.llenarLista();
				VIng.DesactivarComponentes();
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){	
			//Para verificar que los campos no estén vacios
				if(VIng.getTxtCodIngreso().equals("")||
				   VIng.getTxtDescripIngreso().equals("")||
				   VIng.getCmbClasificacion().getSelectedItem().equals("Seleccione una opción")){
					JOptionPane.showMessageDialog(null,"Verifique que ningún campo esté vacio","Atencion!",
							JOptionPane.ERROR_MESSAGE);	
				}else{
				
				//Para llenar los datos del ingreso
				
				
				ing.setDescripcion(VIng.getTxtDescripIngreso());
			
				String clasif= (String) VIng.getCmbClasificacion().getSelectedItem();
				
				try {
					ing.setCodIngreso(VIng.getTxtCodIngreso());
					
					ing.setClasifIngreso(clasif);
					ing.setRuta(ruta.buscarPorCodRuta("J-306-902686"));
					Date fechaIngreso = new Date();
					ing.setFechaIng(fechaIngreso);
					ing.setMonto(0);
					ingDao.agregarIngresos(ing);
					JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
							JOptionPane.INFORMATION_MESSAGE);	
					VIng.limpiarCampos();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
			
	

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
