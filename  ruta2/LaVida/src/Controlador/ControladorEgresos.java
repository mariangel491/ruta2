package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelos.Egresos;
import Modelos.Ruta;
import Modelos.Hibernate.Daos.EgresosDao;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaEgresos;
import Vistas.VistaMostrar;

public class ControladorEgresos implements ActionListener, KeyListener{
	
	private VistaEgresos vEgresos= new VistaEgresos();
	private Egresos egresos= new Egresos();
	private EgresosDao egresosDao = new EgresosDao();
	private Ruta ruta= new Ruta();
	private RutaDao rutaDao= new RutaDao();
	private VistaMostrar mostrar = new VistaMostrar();
	
	
	public ControladorEgresos(){
		vEgresos= new VistaEgresos();
		egresos = new Egresos();
		egresosDao=new EgresosDao();
		ruta= new Ruta();
		rutaDao= new RutaDao();
		vEgresos.setLocationRelativeTo(null);
		vEgresos.setVisible(true);
		vEgresos.setResizable(false);	
		vEgresos.agregarListener(this);
		vEgresos.ActivarComponentes();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			vEgresos.llenarLista();
			vEgresos.DesactivarComponentes();
		//	ControladorMostrarResultados mo= new ControladorMostrarResultados();   //OJO CON ESTO QUE HACE???
		//	mostrar.CrearNuevaVentana(1);
		}else 
		if (ae.getActionCommand().equalsIgnoreCase("Limpiar")) {
			vEgresos.limpiarCampos();
			vEgresos.ActivarComponentes();
			}
		else if(ae.getActionCommand().equalsIgnoreCase("Salir")){
			vEgresos.cerrarVentana();

		}else if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
			System.out.println("Modificandoooo");
		/*}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){          //OJO CON ESTE PORQUE INGRESOS Y PORQUE 2 BUSCAR???
			System.out.println("buscar");
			ControladorIngresos ingresos=new ControladorIngresos();*/
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){			
			
			//PARA VERIFICAR QUE LOS CAMPOS NO ESTEN VACIOS
			if(vEgresos.getTxtCodEgresO().equals("") || vEgresos.getTxtDescripcion().equals("")||
					vEgresos.getCmbClasificacion().getSelectedItem().equals(null))
			{
				JOptionPane.showMessageDialog(null,"Verifique que ningún campo esté vacio","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}	
			
		egresos.setCodEgreso(vEgresos.getTxtCodEgresO());
		egresos.setDescripcion(vEgresos.getTxtDescripcion());
		
		String tipo = (String) vEgresos.getCmbClasificacion().getSelectedItem();
		egresos.setClasificacion(tipo);
		
			
			try {
				egresos.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
				egresosDao.agregarEgresos(egresos);
				vEgresos.limpiarCampos();
				JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	

		}else if(ae.getActionCommand().equalsIgnoreCase("BEgreTecla")){
			
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

