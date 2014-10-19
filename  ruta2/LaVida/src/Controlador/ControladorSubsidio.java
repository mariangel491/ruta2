package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
	//private Socio socio= new Socio();
	private Subsidio subsidio= new Subsidio();
	private SubsidioDao subDao= new SubsidioDao();
	Date fecha= new Date();
	
	/*
	 * 	vAlquiler = new VistaAlquiler();
		vAlquiler = VistaAlquiler.obtenerInstancia();
		vAlquiler.setLocationRelativeTo(null);
		vAlquiler.setVisible(true);
		vAlquiler.agregarListener(this);
		vAlquiler.agregarKey(this);
		vAlquiler.agregarMouse(this);
	 * */
	public ControladorSubsidio() {
		vcSub= new VistaCargarSubsidio();
		vcSub= VistaCargarSubsidio;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equalsIgnoreCase("Buscar")) {
			this.BuscarSocio();
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){
			this.GuardarSubsidioSocio();
		}else if(ae.getActionCommand().equalsIgnoreCase("Cancelar")){
			
		}
	}
	
	public void BuscarSocio(){
		Socio socio= new Socio();
		try {
			socio= socioDao.buscarPorNroSocio(vcSub.getTxtCodSocio());
			vcSub.setTxtNomApe(socio.getNombre()+" "+socio.getApellido());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void GuardarSubsidioSocio(){
		try {
		subsidio.setCodigo(this.GenerarCodigo());
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
		int cant;
		try {
			cant = subDao.obtenerTodos().size();
			
			if(cant<10)
			{
				return "S000"+cant;
			}else if(cant<100)
				return "S00"+cant;
			else if(cant<1000)
				return "S0"+cant;
			else
				return "S"+cant;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}
