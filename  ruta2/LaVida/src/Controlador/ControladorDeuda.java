package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelos.Deuda;
import Modelos.Ingresos;
import Modelos.Socio;
import Modelos.Hibernate.Daos.AvanceDao;
import Modelos.Hibernate.Daos.DeudaDao;
import Modelos.Hibernate.Daos.IngresosDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaDeuda;

public class ControladorDeuda implements ActionListener, KeyListener {


	private VistaDeuda vDeuda = new VistaDeuda();
	private SocioDao socioDao = new SocioDao();
	private IngresosDao ingDao= new IngresosDao();
	private DeudaDao deudaDao= new DeudaDao();
	private AvanceDao avanceDao= new AvanceDao();
	//private Deuda deuda= new Deuda();
	
	public ControladorDeuda() {
		
		vDeuda = new VistaDeuda();
		vDeuda.setLocationRelativeTo(null);
		vDeuda.setVisible(true);
		vDeuda.agregarListener(this);
		//vDeuda.agregarKey(this);
	}

	
	private void BuscarSocio() throws Exception {

		// TODO Auto-generated method stub
		if (vDeuda.getTxtNroSocio().equals(null)) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Nro. de Socio", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = vDeuda.getTxtNroSocio(); 
			if (socioDao.encontrar(codi)) { 
				Socio socio = socioDao.buscarPorNroSocio(codi);

				String codigo;
				String nombre;

				codigo = socio.getNroSocio();
				vDeuda.setTxtNroSocio(codigo);

				nombre = socio.getNombre();
				vDeuda.setTxtNomSocio(nombre);
				
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
			System.out.println("buscando");
			this.cargarDeudaTodosSocios();
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			
		}
	}
	
	/*ESTO ES PARA OBTENER LOS VALORES BOOLEANOS DE LA TABLA
	 * TableModel model = table . getModel (); 
for ( int i =  0 ; i < model . getRowCount (); i ++)  { 
    if (( Boolean ) model . getValueAt ( i ,  0 ))  { 
        // eliminar la fila 
     } 
}*/
	
	public int ValidarMesSig(){
		Date fecha = new Date();
		if(fecha.getMonth()==12){
			return 1;
		}else
			return fecha.getMonth()+1;
		
	}
	
	
	public int ValidadMesAnterior(){
		Date fecha = new Date();
		if(fecha.getMonth()==1){
			return 12;
		}else
			return fecha.getMonth()-1;
	}
	
	public Deuda guardarDeuda(Date fecha, float monto, Socio socio, String codigo, String descrip, String status){
		Deuda deuda= new Deuda();
		deuda.setFecha(fecha);
		deuda.setMonto(monto);
		deuda.setSocio(socio);
		deuda.setCodigo(codigo);
		deuda.setDescripcion(descrip);
		deuda.setStatus(status);
		System.out.println(fecha.toString()+socio.getApellido()+codigo+ descrip+status);
		return deuda;
	}
	
	public String GenerarCodigoDeuda(){
		
		int cantDeuda;
		try {
			cantDeuda = deudaDao.obtenerTodos().size()+1;
		
			if(cantDeuda<10)
			{
				return ("D000"+cantDeuda);			
			}else if(cantDeuda<100)
			{
				 return ("D00"+cantDeuda);
			}else if(cantDeuda<1000)
			{
				return("D0"+cantDeuda);
			}else{
				return("D"+cantDeuda);
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public int mayorMes(){
		int mayor=0, mes,otroMes, cant;
		try {
				if(deudaDao.obtenerTodos().size()==1)
				mayor= deudaDao.obtenerTodos().get(0).getFecha().getMonth();
			else{
				cant=deudaDao.obtenerTodos().size();
				for(int i=0; i<cant;i++)
				{
						mes=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
						if(i+1<cant)
							otroMes= deudaDao.obtenerTodos().get(i+1).getFecha().getMonth();
						else
							otroMes=deudaDao.obtenerTodos().get(i).getFecha().getMonth();
					if(mes>otroMes)
						 mayor=mes;
					else if(mes<otroMes)
						mayor=otroMes;
					else
						mayor=mes;	
				}
				return mayor;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return mayor;
	}

	
	
	public void cargarDeudaTodosSocios(){
		try {
	
		Date fecha = new Date();
		Deuda deuda= new Deuda();
		Ingresos ing= new Ingresos();
		int cont=0;
		int anno=fecha.getYear();
		
		int fin= socioDao.obtenerTodos().size();
		this.mayorMes();
		ing=ingDao.buscarPorCodIngreso("﻿I0001");
		System.out.println("mayor mes: "+this.mayorMes());
		if(fecha.getMonth()>this.mayorMes())
		{	
					while(cont<fin){
						Socio socio=new Socio();
						socio=socioDao.obtenerTodos().get(cont);
						
							deuda.setFecha(fecha);
							deuda.setMonto(ing.getMonto());
							deuda.setSocio(socio);
							deuda.setCodigo(this.GenerarCodigoDeuda());
							deuda.setDescripcion(ing.getDescripcion());
							deuda.setStatus("A");
							
							deudaDao.agregarEgresos(deuda);
							this.DeudaConductorSoc(socio);
						cont++;
					}
		}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	
	public void DeudaConductorSoc(Socio socio){
		Deuda deuda= new Deuda();
		Date f= new Date();
		try {
			Ingresos ing=ingDao.buscarPorCodIngreso("I0002");
			
					deuda.setFecha(f);
					deuda.setMonto(ing.getMonto()*this.cantSocios(socio));
					deuda.setSocio(socio);
					deuda.setCodigo(this.GenerarCodigoDeuda());
					deuda.setDescripcion(ing.getDescripcion());
					deuda.setStatus("A");
					
					deudaDao.agregarEgresos(deuda);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int cantSocios(Socio socio){
		int contador=0;
		
		try {
			for(int i=0; i< avanceDao.obtenerTodos().size();i++)
			{
				if(avanceDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(socio.getNroSocio())){
					contador++;
				}
			}
			
		return contador;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contador;
	}
	
	
	

}
