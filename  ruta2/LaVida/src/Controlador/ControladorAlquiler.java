package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Alquiler;
import Modelos.Ingresos;
import Modelos.Inquilino;
import Modelos.Local;
import Modelos.Hibernate.Daos.AlquilerDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.LocalDao;
import Vistas.VistaAlquiler;
import Vistas.VistaAvance;
import Vistas.VistaInquilino;
import Vistas.VistaSocio;

public class ControladorAlquiler implements ActionListener, KeyListener, MouseListener {
	
	private VistaAlquiler vAlquiler;
	private Alquiler alquiler = new Alquiler();
	private AlquilerDao alqDao = new AlquilerDao();
	private LocalDao localDao = new LocalDao();
	private InquilinoDao inqDao= new InquilinoDao();
	private IngresosDao ingresosDao= new IngresosDao();
	
	private Local localito=new Local();
	private Inquilino busqueda= new Inquilino();
    
	public ControladorAlquiler(){
		vAlquiler = new VistaAlquiler();
		vAlquiler = VistaAlquiler.obtenerInstancia();
		vAlquiler.setLocationRelativeTo(null);
		vAlquiler.setVisible(true);
		vAlquiler.agregarListener(this);
		vAlquiler.agregarKey(this);
		vAlquiler.agregarMouse(this);
		try {
			vAlquiler.LlenarCombos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public ControladorAlquiler(VistaInquilino vi) {
		super();
		vAlquiler = new VistaAlquiler();
		vAlquiler = VistaAlquiler.obtenerInstancia();
		vAlquiler.setLocationRelativeTo(null);
		vAlquiler.setVisible(true);
		vAlquiler.agregarListener(this);
		vAlquiler.agregarKey(this);
		vAlquiler.agregarMouse(this);
		vAlquiler.EliminarDatosCombo();
		vAlquiler.setTxtCedRifInq(vi.llenarCodigo());
		vAlquiler.setTxtNombre(vi.llenarNombre());
		vAlquiler.Bloquear();
	
		try {
			vAlquiler.LlenarCombos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void ActualizarLocal(){
		String nombre =(String) vAlquiler.getCmbNombreLocal().getSelectedItem();
		Local l= new Local();
		try {
		for(int i=0; i<localDao.obtenerTodos().size();i++)
		{
			if(localDao.obtenerTodos().get(i).getNombre().equals(nombre)){
				l=localDao.obtenerTodos().get(i);
				l.setCanon(Float.parseFloat(vAlquiler.getTxtMontoCanon()));			
					localDao.actualizarLocal(i, l);
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ActualizarMontoVigi(){
		Ingresos ing= new Ingresos();
		
		try {
			for(int i=0; i< ingresosDao.obtenerTodos().size();i++){
				String tipo= ingresosDao.obtenerTodos().get(i).getClasifIngreso();
				if(tipo.equals("Alquiler")){
					if(ingresosDao.obtenerTodos().get(i).getDescripcion().equals("Vigilancia"))
					{
						ing=ingresosDao.obtenerTodos().get(i);
						ing.setMonto(Float.parseFloat(vAlquiler.getTxtMontoVigi()));
						System.out.println(vAlquiler.getTxtMontoVigi());
						ingresosDao.actualizarIngresos(i, ing);
					}
				}}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if (ae.getActionCommand().equalsIgnoreCase("BuscarInq")) {
			try {
				vAlquiler.BuscarInquilino();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (ae.getActionCommand().equalsIgnoreCase("Salir")) {
			vAlquiler.cerrarVentana();
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar"))
		{
			this.GuardarAlquiler();
			
		}else if(ae.getActionCommand().equals("ModificarCanon"))
				{
					if(vAlquiler.getTxtMontoCanon().equals("")){
						JOptionPane.showMessageDialog(null,"Debe seleccionar un item","Atencion!",
								JOptionPane.INFORMATION_MESSAGE);
					}else
						vAlquiler.DesbloquearCanon();
					
				}else if(ae.getActionCommand().equals("GuardarModCanon")){
					
					vAlquiler.BotonGuardar();
					vAlquiler.ActualizarValores();
					//this.ActualizarLocal();			
				}else if(ae.getActionCommand().equals("CancelarCanon")){
					MouseEvent me = null;
					vAlquiler.InforSelecCombo(me);
					vAlquiler.BotonGuardar();
				}else if(ae.getActionCommand().equals("CancelarVigi")){
					vAlquiler.CargarMontoVigilancia();
					vAlquiler.GuardarMontoVigi();
				}else if(ae.getActionCommand().equals("ModificarMontoVigi")){
					if(vAlquiler.getTxtMontoCanon().equals("")){
						JOptionPane.showMessageDialog(null,"Debe seleccionar un item","Atencion!",
								JOptionPane.INFORMATION_MESSAGE);
					}else
						vAlquiler.DesbloquearMontoVigi();
				}else if(ae.getActionCommand().equals("GuardarVigi")){
					vAlquiler.GuardarMontoVigi();
					this.ActualizarMontoVigi();
				}
		
	}
	/*if (c == '.' && vAlquiler.getTxtMontoAlq().contains(".")) {
		key.consume();
		}*/

	
	
	@Override
	public void keyTyped(KeyEvent key) {
		char c = key.getKeyChar();
		if (!Character.isDigit(key.getKeyChar()) && c!='.')
			key.consume();
			
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void GuardarAlquiler(){
		vAlquiler.ValidarCampos();
		if(vAlquiler.validarFechas()==3){
				alquiler.setFechaInicio(vAlquiler.getFechaIni());
				alquiler.setFechaFin(vAlquiler.getFechaFin());
		
				alquiler.setCodAlquiler(vAlquiler.getTxtCodAlquiler());
				int posi=0;
				try {
						//Para el local
			
						String nombre=(String) vAlquiler.getCmbNombreLocal().getSelectedItem();
						for(int i =0;i< localDao.obtenerTodos().size(); i++){
							if(localDao.obtenerTodos().get(i).getNombre().equals(nombre)){
								localito= localDao.obtenerTodos().get(i);
								System.out.println("locallll: "+localito.getNombre());
								posi=i;		
							}
						}
		
						//Para el inquilino
						for(int i=0; i<inqDao.obtenerTodos().size();i++)
						{
							if(inqDao.obtenerTodos().get(i).getCedula().equals(vAlquiler.getCedRif())){
							
								busqueda= inqDao.obtenerTodos().get(i);
							}else if(inqDao.obtenerTodos().get(i).getRif().equals(vAlquiler.getCedRif())){
								busqueda= inqDao.obtenerTodos().get(i);
							}
						}
						
						alquiler.setCodInquilino(busqueda);
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				alquiler.setCodLocal(localito);
				alquiler.setStatus("Activo");
				//Transformando un String a Float
				    try {
				    	float monto = Float.parseFloat(vAlquiler.getTxtMontoDepositoS());
						alquiler.setMonto(monto);
				    } catch (NumberFormatException e) {
				    	JOptionPane.showMessageDialog(null,"El monto debe ser un número","Atencion!",
								JOptionPane.ERROR_MESSAGE);
				    }
				
				try {
					Local localAct=new Local();
					localAct=localito;
					localAct.setStatus("Ocupado");
					alqDao.agregarAlquiler(alquiler);
					localDao.actualizarLocal(posi,localAct);
					vAlquiler.limpiarCampos();
					
					
					JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
							JOptionPane.INFORMATION_MESSAGE);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
	}

	@Override
	public void mouseClicked(MouseEvent mE) {
		// TODO Auto-generated method stub
		vAlquiler.CargarMontoVigilancia();
		vAlquiler.InforSelecCombo(mE);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent mE) {
		// TODO Auto-generated method stub
		/*vAlquiler.CargarMontoVigilancia();
		vAlquiler.InforSelecCombo(mE);*/
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}