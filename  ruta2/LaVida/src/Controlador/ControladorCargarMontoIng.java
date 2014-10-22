package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelos.Historial;
import Modelos.Ingresos;
import Modelos.Hibernate.Daos.HistorialDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Vistas.VistaCargarIngresos;

public class ControladorCargarMontoIng implements ActionListener, KeyListener {

	private VistaCargarIngresos vCargarI;
	private IngresosDao ingDao= new IngresosDao();
	private Ingresos ingreso= new Ingresos();
	private Ingresos ingHist= new Ingresos();
	private Historial hist= new Historial();
	private HistorialDao histDao= new HistorialDao();
	
	public ControladorCargarMontoIng() {
		super();
		vCargarI= new VistaCargarIngresos();
		vCargarI= VistaCargarIngresos.obtenerInstancia();
		vCargarI.setLocationRelativeTo(null);
		vCargarI.setVisible(true);
		vCargarI.agregarListener(this);
		vCargarI.agregarKey(this);
		vCargarI.LlenarListaIng();
		// TODO Auto-generated constructor stub
	}
	
	public String generarCodHistorial() throws Exception{
			String cod = "";
			int num= histDao.obtenerTodos().size()+1;
			if(num<10)
			{
				cod= ("H000"+num);
			}else if(num<100)
			{
				cod=("H00"+num);
			}
			else if(num<1000)
			{
				cod=("H0"+num);
			}
			return cod;
	
		
	}
	
	public void actualizarIngreso(){
		
		float monto = Float.parseFloat(vCargarI.getTxtMontoIng());
		try {
			ingreso= ingDao.buscarPorCodIngreso(vCargarI.getTxtCodIng());
			ingreso.setMonto(monto);
			ingDao.actualizarIngresos(vCargarI.itemSeleccionado(), ingreso);
			JOptionPane.showMessageDialog(null,"Monto registrado con exito","Atención",
					JOptionPane.INFORMATION_MESSAGE);
			vCargarI.limpiarCampos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void IngresosHistorial(){
		try {
			ingHist= vCargarI.ingresoSeleccionado();
			System.out.println(ingHist.getDescripcion());
			System.out.println(ingHist.getCodIngreso());
			float monto= ingHist.getMonto();
			hist.setCodHistorial(this.generarCodHistorial());
			hist.setIngresos(ingHist);
			hist.setFecha(new Date());
			hist.setMonto(monto);
			
			histDao.agregarHistorial(hist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("Buscar")){
			
		}else if(ae.getActionCommand().equals("Guardar")){
			this.IngresosHistorial();
			this.actualizarIngreso();
		}else if(ae.getActionCommand().equals("Modificar"))
		{
			
		}else if(ae.getActionCommand().equals("Salir")){
			
		}else if(ae.getActionCommand().equalsIgnoreCase("BIngreTecla")){
			
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
