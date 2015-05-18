package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Local;
import Modelos.Ruta;
import Modelos.Hibernate.Daos.LocalDao;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaLocal;

public class ControladorRegistrarLocal implements ActionListener, KeyListener{
	
	private VistaLocal VLocal;
	private Local local;
	private LocalDao localDao;
	private Ruta ruta;
	private RutaDao rutaDao;
	
	
	public ControladorRegistrarLocal(){
		
		VLocal= new VistaLocal();
		local=new Local();
		localDao=new LocalDao();
		ruta= new Ruta();
		rutaDao= new RutaDao();
		
		VLocal.setVisible(true);
		VLocal.setResizable(false);	
		VLocal.agregarListener(this);
		VLocal.agregarKey(this);
	
	}
	public int VerificarLocal(){
		String cod = VLocal.getTxtCodigo();
		int locales;
		try {
			locales = localDao.obtenerTodos().size();
			for(int i=0;i<locales;i++){
				if(localDao.obtenerTodos().get(i).getCodLocal().equals(cod))
					return i;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equalsIgnoreCase("Limpiar")) {
				VLocal.LimpiarCampos();
			}
		else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			VLocal.cerrarVentana();
			//VLocal.ActivarComponentes();
			//VLocal.LimpiarCampos();
		}else 
			if(ae.getActionCommand().equalsIgnoreCase("Modificar"))
			{
				if(VLocal.ItemSelec()!=-1){
				
				VLocal.ItemSeleccionado();
				VLocal.ActivarComponentes();
				}else 
					JOptionPane.showMessageDialog(null,"Seleccione un elemento","Atencion!",
							JOptionPane.ERROR_MESSAGE);
					
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			VLocal.llenarLista();
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){			
			//PARA VERIFICAR QUE LOS CAMPOS NO ESTEN VACIOS	
			if(VLocal.getTxtNombre().equals("")||VLocal.getCmbTipo().getSelectedItem().equals("Seleccione una opción")
					||VLocal.getCanon().equals("")){	
				JOptionPane.showMessageDialog(null,"Verifique que todos los campos estén llenos","Atencion!",
						JOptionPane.ERROR_MESSAGE);
			}else{
				
				//Verificando la modificacion de el local
				if(this.VerificarLocal()==-1){
			local.setCodLocal(VLocal.getTxtCodigo());
			local.setNombre(VLocal.getTxtNombre());
			local.setStatus("Disponible");
			
			float canon= Float.parseFloat(VLocal.getCanon());
			local.setCanon(canon);
			
			//Convertir en un String el valor que me traigo del combo
			String tipo = (String) VLocal.getCmbTipo().getSelectedItem();
			local.setTipo(tipo);
			
			try {
				local.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
				localDao.agregarLocal(local);
				VLocal.LimpiarCampos();
				JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	
			}else{//Existe el codigo entonces solo actualizo
				local.setCodLocal(VLocal.getTxtCodigo());
				local.setNombre(VLocal.getTxtNombre());
				local.setStatus("Disponible");
				
				float canon= Float.parseFloat(VLocal.getCanon());
				local.setCanon(canon);
				
				//Convertir en un String el valor que me traigo del combo
				String tipo = (String) VLocal.getCmbTipo().getSelectedItem();
				local.setTipo(tipo);
				
				try {
					local.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
					localDao.actualizarLocal(this.VerificarLocal(), local);
					VLocal.LimpiarCampos();
					JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}}
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
		char c = e.getKeyChar();
		if (!Character.isDigit(e.getKeyChar()) && c!='.')
			e.consume();
	}
}
	
	


