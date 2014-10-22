package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Modelos.Inquilino;
import Modelos.Hibernate.Daos.InquilinoDao;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaAlquiler;
import Vistas.VistaInquilino;



public class ControladorInquilino  implements ActionListener, KeyListener {
	
	private VistaInquilino vInquilino;
	private InquilinoDao inquilinoDao = new InquilinoDao();
	private Inquilino inquilino = new Inquilino();
	private RutaDao rutaDao= new RutaDao();
	
	private List<Inquilino> ListaInq= new ArrayList<>();
	
	boolean encontro=false;
	int y=-1;
	
	
	
	public ControladorInquilino() {
		super();
		// TODO Auto-generated constructor stub
		vInquilino = new VistaInquilino();
		VistaInquilino.obtenerInstancia();
		vInquilino.setResizable(false);
		vInquilino.setVisible(true);
		vInquilino.agregarListener(this);
		vInquilino.GenerarCodigo();
		vInquilino.agregarKey(this);
	}


	public ControladorInquilino(VistaAlquiler va) throws Exception {
		vInquilino = new VistaInquilino();
		VistaInquilino.obtenerInstancia();
		ListaInq= inquilinoDao.obtenerTodos();
	
		vInquilino.setResizable(false);
		vInquilino.setVisible(true);
		vInquilino.agregarListener(this);
		vInquilino.GenerarCodigo();
		
		LlenarCamposAlq(va);
	}

	public void LlenarCamposAlq(VistaAlquiler va){
		
		if(va.DevolverTipo()==true){
			vInquilino.setTxtCedulaRif(va.getCedRif());
			vInquilino.BloquearCamposNatural();
		}else
		{
			vInquilino.setTxtRif(va.getCedRif());
			vInquilino.BloquearCamposJuridicos();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getActionCommand().equalsIgnoreCase("BuscarCedula")) 
		{
			String cedula=vInquilino.getTxtCedulaRif();		
				for(int i=0;i< ListaInq.size();i++){
					System.out.println("Busqueda: "+ListaInq.get(i).getCedula());
					if(ListaInq.get(i).getCedula().equals(cedula)){
						vInquilino.setTxtNombre(ListaInq.get(i).getNombre());
						vInquilino.setTxtDireccion(ListaInq.get(i).getDireccion());
						vInquilino.setTxtApellido((ListaInq.get(i).getApellido()));
						String tlfno= Integer.toString(ListaInq.get(i).getTelefono());
						vInquilino.setTxtTelefono(tlfno);
						encontro=true;
					}
				}
			if(encontro==false){
				JOptionPane.showMessageDialog(null,"Inquilino no Registrado","Atencion!",
						JOptionPane.ERROR_MESSAGE);	
			
		}
		}else if (a.getActionCommand().equalsIgnoreCase("Limpiar")) {
			vInquilino.limpiarCampos();
		}else if (a.getActionCommand().equalsIgnoreCase("Cancelar")) {
			vInquilino.cerrarVentana();
		}else if (a.getActionCommand().equalsIgnoreCase("Guardar")) {
			
			int tlfno =0;
			//Como el tlfno es común para ambos tipos 
			if(!vInquilino.getTxtTelefono().equals("")){
				tlfno =  Integer.parseInt(vInquilino.getTxtTelefono());
			}else
				JOptionPane.showMessageDialog(null,"Verifique que los campos estén llenos","Atencion!",
						JOptionPane.ERROR_MESSAGE);	
			
			//Para asignar el codigo de manera automática
			
			System.out.println(vInquilino.mostrarTipo());
			//Si la persona es natural
			if(vInquilino.mostrarTipo()==true)
			{
				vInquilino.BloquearCamposNatural();
				if(vInquilino.getTxtCedulaRif().equals("")||vInquilino.getTxtApellido().equals("")|| 
						vInquilino.getTxtNombre().equals("")|| vInquilino.getTxtDireccion().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Verifique que los campos estén llenos","Atencion!",
							JOptionPane.ERROR_MESSAGE);	
				}else
				{			
					inquilino.setCodinquilino(vInquilino.getCodigo());
					inquilino.setCedula(vInquilino.getTxtCedulaRif());
					inquilino.setApellido(vInquilino.getTxtApellido());
					inquilino.setNombre(vInquilino.getTxtNombre());
					inquilino.setStatus("A");
					inquilino.setDireccion(vInquilino.getTxtDireccion());				
					inquilino.setTelefono(tlfno);
					inquilino.setTipo("Natural");
					inquilino.setRif("null");
					try {
						inquilino.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
						inquilinoDao.agregarInquilino(inquilino);
						
						
						JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
								JOptionPane.INFORMATION_MESSAGE);
						vInquilino.dispose();
						ControladorAlquiler Calqui = new ControladorAlquiler(vInquilino);
						vInquilino.limpiarCampos();
						vInquilino.dispose();

						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			//Si la persona es jurídica
			}else{
				if(vInquilino.getTxtRif1().equals("")||vInquilino.getTxtNombre().equals("")
						||vInquilino.getTxtDireccion().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Verifique que los campos estén llenos","Atencion!",
							JOptionPane.ERROR_MESSAGE);	
				}else{
						//System.out.println("Esta Pasando por aqui por que es juridico");
						inquilino.setCodinquilino(vInquilino.getCodigo());
						inquilino.setCedula("null");
						inquilino.setRif(vInquilino.getTxtRif1());
						inquilino.setNombre(vInquilino.getTxtNombre());
						inquilino.setApellido("null");
						inquilino.setStatus("A");
						inquilino.setDireccion(vInquilino.getTxtDireccion());
						inquilino.setTelefono(tlfno);
						inquilino.setTipo("Juridica");
						try {
							inquilino.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
							inquilinoDao.agregarInquilino(inquilino);
							vInquilino.limpiarCampos();
							JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
									JOptionPane.INFORMATION_MESSAGE);
						
							ControladorAlquiler Calqui = new ControladorAlquiler(vInquilino);
							vInquilino.limpiarCampos();
							vInquilino.dispose();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					
					}
				}
		}else if (a.getActionCommand().equalsIgnoreCase("Modificar")) {
			
		}else
			if(a.getActionCommand().equalsIgnoreCase("BuscarRif")){
				String rif=vInquilino.getTxtRif1();		
				for(int i=0;i< ListaInq.size();i++){
					System.out.println("Busqueda: "+ListaInq.get(i).getCedula());
					if(ListaInq.get(i).getRif().equals(rif)){
						vInquilino.setTxtNombre(ListaInq.get(i).getNombre());
						vInquilino.setTxtDireccion(ListaInq.get(i).getDireccion());
					
						encontro=true;
					}
				}
				
			if(encontro==false){
				JOptionPane.showMessageDialog(null,"Inquilino no Registrado","Atencion!",
						JOptionPane.ERROR_MESSAGE);	
			}
		}else if(a.getActionCommand().equalsIgnoreCase("BInquiTecla"))
		{
			
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
	public void keyTyped(KeyEvent key) {
		char c = key.getKeyChar();
		if (!Character.isDigit(key.getKeyChar()) && c!='.')
			key.consume();
			
	}


		
}

	

