package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;







import Modelos.Beneficiario;
import Modelos.Socio;
import Modelos.Hibernate.Daos.BeneficiarioDao;
import Modelos.Hibernate.Daos.SocioDao;
import Vistas.VistaBeneficiario;

public class ControladorBeneficiario implements ActionListener, KeyListener {

	private VistaBeneficiario Vbenef= new VistaBeneficiario();
	private BeneficiarioDao benefDao= new BeneficiarioDao();
	private Beneficiario benef= new Beneficiario();
	private SocioDao socioDao= new SocioDao();
	private Socio socio = new Socio();

	public ControladorBeneficiario() {
		super();
		
		Vbenef.obtenerInstancia();
		Vbenef.setLocationRelativeTo(null);
		Vbenef.setVisible(true);
		Vbenef.agregarListener(this);
		Vbenef.OcultarBotones();
		Vbenef.Ocultar();
		Vbenef.agregarKey(this);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().equalsIgnoreCase("BuscarSocio")) {
			
			try {
				this.BuscarSocio();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Buscar")){
			try {
				this.BuscarBenef();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ae.getActionCommand().equalsIgnoreCase("AgregarBeneficiario")){
			
			if (Vbenef.CamposLlenosBenef()==true) {
				this.agregarBeneficiario();
				Vbenef.MostarListado();
				
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos del Beneficiario", "Atención!", JOptionPane.ERROR_MESSAGE);
			

		}else if(ae.getActionCommand().equalsIgnoreCase("EliminarBenef")){
							try {
					this.ElimLogicoLista(Vbenef.cedula());		
					Vbenef.removerFila();
					this.removerElementoB();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Vbenef.MostarListado();
			/*	
			} else
				JOptionPane.showMessageDialog(null, "Debe seleccionar algun elemento de la lista de Beneficiarios", "Atención!", JOptionPane.ERROR_MESSAGE);
			*/

		}else if(ae.getActionCommand().equalsIgnoreCase("Limpiar")){
			Vbenef.limpiarCamposBenef();
			Vbenef.limpiarCamposSocio();
			Vbenef.regresar();
			Vbenef.limpiarTablaBeneficiarios();
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Modificar")){
			
			try {
				
				this.modificarBene();
				this.obtenerBeneficiarios();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(ae.getActionCommand().equalsIgnoreCase("Guardar")){
			

				if (Vbenef.CamposllenosSocio() == true) {
					Socio socio = new Socio();
					
					String nro = (Vbenef.getTxtNroSocio());
				
					try {
						if (!socioDao.encontrar(nro))
							socioDao.agregarSocio(socio);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						socio = socioDao.buscarPorNroSocio(nro);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (Beneficiario bene : this.socio.getBeneficiarios()) {
						bene.setSocio(socio);
						bene.setStatus("Activo");
						try {
							if (!benefDao.encontrar(bene.getCedBeneficiario()))
								benefDao.agregarBeneficiario(bene);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					JOptionPane.showMessageDialog(null, "Beneficiario registrado con exito", "Atención!", JOptionPane.INFORMATION_MESSAGE);
					
					Vbenef.limpiarCamposSocio();
					Vbenef.limpiarTablaBeneficiarios();
					
				} else
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Atención!", JOptionPane.INFORMATION_MESSAGE);
			}
			
		
		
			/*if(Vbenef.CamposLlenosBenef()==true)
			{
			
				benef.setCedBeneficiario(Vbenef.getTxtCedulaRif());
				
				benef.setApellido(Vbenef.getTxtApellido());
				benef.setDireccion(Vbenef.getTxtDireccion());
				benef.setNombre(Vbenef.getTxtNombre());
				benef.setSocio(Vbenef.SocioBusc());
				benef.setStatus("Activo");
				int telefono= Integer.parseInt(Vbenef.getTxtTelefono());
				benef.setTelefono(telefono);
				
				
				
				try {
					benefDao.agregarBeneficiario(benef);
					Vbenef.limpiarCamposBenef();
					Vbenef.limpiarCamposSocio();
					Vbenef.limpiarTablaBeneficiarios();
					
					JOptionPane.showMessageDialog(null,"Registro exitoso","Atencion!",
							JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
				
		}

	
	public void BuscarSocio() throws Exception{
		
		if (Vbenef.getTxtNroSocio().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Nro. de Socio", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String codi = Vbenef.getTxtNroSocio(); 
			if (socioDao.encontrar(codi)) { 
				socio = socioDao.buscarPorNroSocio(codi);

				String codigo;
				String nombre;

				codigo = socio.getNroSocio();
				Vbenef.setTxtNroSocio(codigo);

				nombre = socio.getNombre();
				String apellido = socio.getApellido();
				Vbenef.setTxtNombreSocio(nombre+ " "+apellido);
				
				Vbenef.OcultarListado(this.obtenerBeneficiarios());
				this.obtenerBeneficiarios();
			} else
				JOptionPane.showMessageDialog(null, "El socio no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
			
	
	public int buscarBene (String ced) throws Exception
	{	
		for (int i=0; i<benefDao.obtenerTodos().size(); i++){
	      
	        if (benefDao.obtenerTodos().get(i).getCedBeneficiario().equals(Vbenef.getTxtCedulaRif()))
	        	  return i;
		}
		return -1;
	 }
	
/*	public void EliminarBene(String ced) throws Exception
	{	
		boolean enc=false;
		for (int i=0; i<benefDao.obtenerTodos().size(); i++){
	        if (benefDao.obtenerTodos().get(i).getCedBeneficiario().equals(Vbenef.cedula()))
	        {
	        	enc=true;
	        	System.out.println("beneficiario:  "+ benefDao.obtenerTodos().get(i).getCedBeneficiario());
	        	benefDao.eliminarBeneficiario(benefDao.obtenerTodos().get(i));
	        } 
		}
	
	 }
*/	
	
	private void ElimLogicoLista(String ced) throws Exception{{
			 int posi= this.buscarBene(ced);		
			 	benef=benefDao.buscarPorCedula(ced);
				 benef.setStatus("Inactivo");
				 benefDao.actualizarBeneficiario(posi, benef);
	}}
	
	
	public int buscarBene2 (String ced) throws Exception
	{	
		for (int i=0; i<benefDao.obtenerTodos().size(); i++){
	        if (benefDao.obtenerTodos().get(i).getCedBeneficiario().equals(socio.getBeneficiarios().
	        		get(Vbenef.filaSeleccionada()).getCedBeneficiario()))
	        	  return i;
		}
		return -1;
	 }
		
	private void modificarBene() throws Exception {
		
		
		 String ced="";
		 int posi= this.buscarBene(ced);		
		 
		 if (Vbenef.CamposLlenosBenef() == true) {
			 
			 benef.setNombre(Vbenef.getTxtNombre());
			 benef.setApellido(Vbenef.getTxtApellido());
			 benef.setDireccion(Vbenef.getTxtDireccion().toUpperCase());
			 benef.setFechanacimiento(Vbenef.getFechaNaci());
			 benef.setEdad(Integer.parseInt(Vbenef.getTxtEdad()));
			 benef.setParentesco(Vbenef.getCmbParentesco());
			 benef.setTelefono(Integer.parseInt(Vbenef.getTxtTelefono()));
			 benef.setStatus(Vbenef.getCmbEstado());
			
			 Vbenef.limpiarTablaBeneficiarios();
			 benefDao.actualizarBeneficiario(posi, benef);
			 
			 JOptionPane.showMessageDialog(null, "Se ha modificado el Beneficiario exitosamente", "Atención!", JOptionPane.INFORMATION_MESSAGE);
			 
		 }
			
					Vbenef.limpiarCamposBenef();
	}

	
public ArrayList<Beneficiario> obtenerBeneficiarios() throws Exception{
	ArrayList<Beneficiario> listado = new ArrayList<Beneficiario>();
	
	for(int i = 0; i < benefDao.obtenerTodos().size(); i++)
		if(benefDao.obtenerTodos().get(i).getSocio().getNroSocio().equals(Vbenef.getTxtNroSocio()))
			if(benefDao.obtenerTodos().get(i).getStatus().equals("Activo"))
				listado.add(benefDao.obtenerTodos().get(i));
	
	socio.setBeneficiarios(listado);
	
	this.cargarListadoDeBeneficiarios();
	
	return listado;
}


protected void cargarListadoDeBeneficiarios() throws Exception {
	
	
	if(socio.getBeneficiarios().size()>0)
	{
		List<Beneficiario> benefi = socio.getBeneficiarios();
		Vbenef.limpiarTablaBeneficiarios();
		for(int i=0; i<benefi.size(); i++)
		{	
			String cedula = benefi.get(i).getCedBeneficiario();
			String nombre = benefi.get(i).getNombre()+" "+benefi.get(i).getApellido();
			Integer edad = benefi.get(i).getEdad();
			String parentesco = benefi.get(i).getParentesco();
			String direc = benefi.get(i).getDireccion();
			Integer telefono = benefi.get(i).getTelefono();			
			
			Vbenef.agregarFila(cedula, nombre, edad.toString(), parentesco, direc, telefono.toString());
		}		

	}
}
	

//OJOOOOOO
public void removerElementoB(){
	
	if(Vbenef.filaSeleccionada()>=0)
		socio.getBeneficiarios().remove(Vbenef.filaSeleccionada());
}

public void removerElementoBeneficiario(String ced) throws Exception{	
	 	benef=benefDao.buscarPorCedula(ced);
		benefDao.eliminarBeneficiario(benef);
}

	
	public void BuscarBenef() throws Exception {
		
		if (Vbenef.getTxtCedulaRif().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(null, "Debe llenar el campo Cédula del Beneficiario", "Atención!", JOptionPane.ERROR_MESSAGE);
		} 
		else {
			
			String ced = Vbenef.getTxtCedulaRif();
			if (benefDao.encontrar(ced)) { 
				benef = benefDao.buscarPorCedula(ced);

				
				String nroSoc;
				String nombre;
				
				String nom;
				String ape;
				String cedu;
				Date fecha;
				Integer edad;
				String paren;
				String dire;
				Integer telef;
				String status;
				

				nroSoc = benef.getSocio().getNroSocio();
				Vbenef.setTxtNroSocio(nroSoc);
				nombre = benef.getSocio().getNombre();
				Vbenef.setTxtNombreSocio(nombre+" "+benef.getSocio().getApellido());
				
							
				nom = benef.getNombre();
				Vbenef.setTxtNombre(nom);
				ape = benef.getApellido();
				Vbenef.setTxtApellido(ape);
				cedu = benef.getCedBeneficiario();
				Vbenef.setTxtCedulaRif(cedu);
				fecha = benef.getFechanacimiento();
				Vbenef.setFechaNaci(fecha);
				edad = benef.getEdad();
				Vbenef.setTxtEdad(edad.toString());
				paren = benef.getParentesco();
				Vbenef.setCmbParentesco(paren);
				dire = benef.getDireccion();
				Vbenef.setTxtDireccion(dire);
				telef = benef.getTelefono();
				Vbenef.setTxtTelefono(telef.toString());
				status = benef.getStatus();
				Vbenef.setCmbEstado(status);
				
				Vbenef.MostarBotones();
				Vbenef.editar();
				
			} else
				JOptionPane.showMessageDialog(null, "El beneficiario no existe", "Atención!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void agregarBeneficiario() {
		try {
			
			String cedula = Vbenef.getTxtCedulaRif();
			String nombre = Vbenef.getTxtNombre();
			String apellido = Vbenef.getTxtApellido();
			Date FechaNaci = Vbenef.getFechaNaci();
			Integer edad = Integer.parseInt(Vbenef.getTxtEdad());
			String parentesco = Vbenef.getCmbParentesco();
			Integer telefono = Integer.parseInt(Vbenef.getTxtTelefono());
			String direccion = Vbenef.getTxtDireccion();
			
			Beneficiario bene = new Beneficiario();
			bene.setNombre(nombre);
			bene.setCedBeneficiario(cedula);
			bene.setApellido(apellido);
			bene.setFechanacimiento(FechaNaci);
			bene.setEdad(edad);
			bene.setParentesco(parentesco);
			bene.setDireccion(direccion);
			bene.setTelefono(telefono);
			
			socio.getBeneficiarios().add(bene);
			this.cargarListadoDeBeneficiarios();
		
			Vbenef.limpiarCamposBenef();
		
		} catch (Exception e) {
			// Mensaje de Dialogo en caso de que ocurra cualquier otra excepcion
			JOptionPane.showMessageDialog(null,e.toString());
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
