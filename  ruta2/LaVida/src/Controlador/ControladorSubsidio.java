package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelos.Socio;
import Modelos.Subsidio;
import Modelos.Hibernate.Daos.SocioDao;
import Modelos.Hibernate.Daos.SubsidioDao;
import Vistas.VistaAlquiler;
import Vistas.VistaCargarIngresos;
import Vistas.VistaCargarSubsidio;

public class ControladorSubsidio implements ActionListener {

	private VistaCargarSubsidio vcSub;
	private SocioDao socioDao= new SocioDao();
	private Subsidio subsidio= new Subsidio();
	private SubsidioDao subDao= new SubsidioDao();
	Date fecha= new Date();
	
	public ControladorSubsidio() {
		vcSub= new VistaCargarSubsidio();
		vcSub= VistaCargarSubsidio.obtenerInstancia();
		vcSub.setLocationRelativeTo(null);
		vcSub.setVisible(true);
		vcSub.agregarListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
			this.BuscarSocio();
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){
			this.GuardarSubsidioSocio();
			vcSub.LimpiarCampos();
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			vcSub.LimpiarCampos();
		}
	}
	
	public void BuscarSocio(){
		Socio socio= new Socio();
		try {
			socio= socioDao.buscarPorNroSocio(vcSub.getTxtCodSocio());
			if(socio!=null)
			{
				vcSub.setTxtNomApe(socio.getNombre()+" "+socio.getApellido());
				vcSub.setTxtCodSubsidio(this.GenerarCodigo());
			}
				
			else
			{
				JOptionPane.showMessageDialog(null,"El socio no existe","Atencion!",
						JOptionPane.INFORMATION_MESSAGE);
				vcSub.LimpiarCampos();
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void GuardarSubsidioSocio(){
		try {
		subsidio.setCodigo(vcSub.getTxtCodigoSubsidio());
		subsidio.setFecha(fecha);
		subsidio.setMonto(Float.parseFloat(vcSub.getTxtMontoSubsidio()));
		subsidio.setSocio(socioDao.buscarPorNroSocio(vcSub.getTxtCodSocio()));
		subsidio.setStatus('A');
		subDao.agregarSubsidio(subsidio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String GenerarCodigo(){
		int cant=0;
		try {
			cant = subDao.obtenerTodos().size()+1;
			
			if(cant<10)
			{
				return "SUB000"+cant;
			}else if(cant<100)
				return "SUB00"+cant;
			else if(cant<1000)
				return "SUB0"+cant;
			else
				return "SUB"+cant;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}
