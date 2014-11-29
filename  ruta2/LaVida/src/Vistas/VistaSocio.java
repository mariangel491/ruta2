package Vistas;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import Modelos.Socio;
import Modelos.Hibernate.Daos.RutaDao;
import Vistas.VistaAvance;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VistaSocio extends javax.swing.JFrame {
	private JTextField txtNroSocio;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JTextField txtApellidoSoc;
	private JTextField txtNomSocio;
	private JLabel lblNomSocio;
	private JLabel lblApellidoSocio;
	private JPanel jpDatosBasicos;
	private JButton btnRA;
	private JButton btnRS;
	private JButton btnRV;
	private JPanel jpLogo;
	private JLabel lblSocio;
	private JTextField txtCedSocio;
	private JLabel lblCedSocio;
	private JLabel lblNroSocio;
	private JPanel jpSocio;
	private JTextField txtDirecSocio;
	private JButton btnBuscarCed;
	private JButton btnBuscarSocio;
	private JButton btnLimpiar;
	private ButtonGroup buttonGroupTieneAvance;
	private JRadioButton rbtnNo;
	private JRadioButton rbtnSI;
	private JLabel lblPregunta;
	private JLabel lblImagen;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private JLabel lblDirecSocio;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaSocio inst = new VistaSocio();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaSocio vSocio=null;
	
	public static VistaSocio obtenerInstancia(){
		if(vSocio==null)
			vSocio= new VistaSocio();
		return vSocio;
	}
	
	public VistaSocio() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(587, 393);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(630, 429));
			getContentPane().setLayout(null);
			this.setTitle("Registrar Socio");
			{
				jpSocio = new JPanel();
				getContentPane().add(jpSocio, "Center");
				getContentPane().add(getJpLogo());
				getContentPane().add(getJbtnRV());
				getContentPane().add(getJbtnRA());
				getContentPane().add(getJbtnRS());
				getContentPane().add(getJpDatosBasicos());
				getContentPane().add(getJbtnSiguiente());
				getContentPane().add(getJbtnCancelar());
				getContentPane().add(getJbtnModificar());
				getContentPane().add(getBtnLimpiar());
				jpSocio.setLayout(null);
				jpSocio.setBounds(12, 118, 582, 68);
				jpSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				{
					lblNroSocio = new JLabel();
					jpSocio.add(lblNroSocio);
					lblNroSocio.setText("Número de Socio:");
					lblNroSocio.setBounds(28, 27, 116, 16);
					lblNroSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					lblCedSocio = new JLabel();
					jpSocio.add(lblCedSocio);
					lblCedSocio.setText("Cedula:");
					lblCedSocio.setBounds(345, 27, 56, 16);
					lblCedSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNroSocio = new JTextField();
					jpSocio.add(txtNroSocio);
					txtNroSocio.setBounds(150, 24, 71, 23);
					txtNroSocio.setActionCommand("BuscarNumSocTeclado");
				}
				{
					txtCedSocio = new JTextField();
					jpSocio.add(txtCedSocio);
					jpSocio.add(getJbtnBuscarSocio());
					jpSocio.add(getJbtnBuscarCed());
					txtCedSocio.setBounds(407, 24, 81, 23);
					txtCedSocio.setActionCommand("BusCedTeclado");
				}
				
			}
			pack();
			this.setSize(630, 429);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JPanel getJpLogo() {
		if(jpLogo == null) {
			jpLogo = new JPanel();
		//	jpLogo.setLayout(jpLogoLayout);
			jpLogo.setBounds(0, 7, 613, 75);
			jpLogo.setLayout(null);
			jpLogo.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jpLogo.setBackground(new java.awt.Color(255,255,255));
			jpLogo.add(getLblSocio());
			jpLogo.add(getLblImagen());
		}
		return jpLogo;
	}

	private JButton getJbtnRV() {
		if(btnRV == null) {
			btnRV = new JButton();
			btnRV.setText("Registrar Vehículo");
			btnRV.setBounds(409, 84, 208, 29);
			btnRV.setFont(new java.awt.Font("Century Gothic",0,12));
		}
		return btnRV;
	}
	
	private JButton getJbtnRS() {
		if(btnRS == null) {
			btnRS = new JButton();
			btnRS.setText("Registrar Socio");
			btnRS.setBounds(0, 84, 201, 29);
			btnRS.setFont(new java.awt.Font("Century Gothic",0,12));
		}
		return btnRS;
	}
	
	private JButton getJbtnRA() {
		if(btnRA == null) {
			btnRA = new JButton();
			btnRA.setText("Registrar Avance");
			btnRA.setBounds(201, 84, 208, 29);
			btnRA.setFont(new java.awt.Font("Century Gothic",0,12));
		}
		return btnRA;
	}
	
	private JPanel getJpDatosBasicos() {
		if(jpDatosBasicos == null) {
			jpDatosBasicos = new JPanel();
			//jpDatosBasicos.setLayout(jpDatosBasicosLayout);
			jpDatosBasicos.setBounds(15, 192, 577, 132);
			jpDatosBasicos.setBorder(BorderFactory.createTitledBorder(""));
			jpDatosBasicos.setLayout(null);
			jpDatosBasicos.add(getLblApellidoSocio());
			jpDatosBasicos.add(getLblNomSocio());
			jpDatosBasicos.add(getTxtNomSocio());
			jpDatosBasicos.add(getTxtApellidoSoc());
			jpDatosBasicos.add(getLblTelefono());
			jpDatosBasicos.add(getTxtTelefono());
			jpDatosBasicos.add(getTxtDirecSocio());
			jpDatosBasicos.add(getLblDirecSocio());
			jpDatosBasicos.add(getLblPregunta());
			jpDatosBasicos.add(getRbtnSI());
			jpDatosBasicos.add(getRbtnNo());
		}
		return jpDatosBasicos;
	}

	private JLabel getLblApellidoSocio() {
		if(lblApellidoSocio == null) {
			lblApellidoSocio = new JLabel();
			lblApellidoSocio.setText("Apellido:");
			lblApellidoSocio.setFont(new java.awt.Font("Verdana",0,12));
			lblApellidoSocio.setBounds(36, 44, 66, 16);
		}
		return lblApellidoSocio;
	}
	
	private JLabel getLblNomSocio() {
		if(lblNomSocio == null) {
			lblNomSocio = new JLabel();
			lblNomSocio.setText("Nombre:");
			lblNomSocio.setFont(new java.awt.Font("Verdana",0,12));
			lblNomSocio.setBounds(36, 16, 56, 16);
		}
		return lblNomSocio;
	}
	
	private JTextField getTxtNomSocio() {
		if(txtNomSocio == null) {
			txtNomSocio = new JTextField();
			txtNomSocio.setBounds(120, 13, 398, 23);
		}
		return txtNomSocio;
	}
	
	private JTextField getTxtApellidoSoc() {
		if(txtApellidoSoc == null) {
			txtApellidoSoc = new JTextField();
			txtApellidoSoc.setBounds(120, 41, 398, 23);
		}
		return txtApellidoSoc;
	}

	private JLabel getLblTelefono() {
		if(lblTelefono == null) {
			lblTelefono = new JLabel();
			lblTelefono.setText("Teléfono: ");
			lblTelefono.setBounds(34, 107, 66, 16);
			lblTelefono.setFont(new java.awt.Font("Verdana",0,12));
		}
		return lblTelefono;
	}
	
	private JTextField getTxtTelefono() {
		if(txtTelefono == null) {
			txtTelefono = new JTextField();
			txtTelefono.setBounds(121, 98, 191, 23);
		}
		return txtTelefono;
	}
	
	private JTextField getTxtDirecSocio() {
		if(txtDirecSocio == null) {
			txtDirecSocio = new JTextField();
			txtDirecSocio.setBounds(120, 70, 398, 22);
		}
		return txtDirecSocio;
	}
	
	private JLabel getLblDirecSocio() {
		if(lblDirecSocio == null) {
			lblDirecSocio = new JLabel();
			lblDirecSocio.setText("Dirección: ");
			lblDirecSocio.setBounds(31, 74, 66, 16);
			lblDirecSocio.setFont(new java.awt.Font("Verdana",0,12));
		}
		return lblDirecSocio;
	}
	
	private JButton getJbtnSiguiente() {
		if(btnSiguiente == null) {
			btnSiguiente = new JButton();
			btnSiguiente.setText("Siguiente");
			btnSiguiente.setBounds(454, 342, 126, 28);
			btnSiguiente.setFont(new java.awt.Font("Century Gothic",0,12));
			btnSiguiente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sig.png")));
			btnSiguiente.setActionCommand("Siguiente");
		}
		return btnSiguiente;
	}
	
	private JButton getJbtnCancelar() {
		if(btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(33, 342, 126, 28);
			btnCancelar.setFont(new java.awt.Font("Century Gothic",0,12));
			btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
			btnCancelar.setActionCommand("Cancelar");
		}
		return btnCancelar;
	}
	
	private JButton getJbtnModificar() {
		if(btnModificar == null) {
			btnModificar = new JButton();
			btnModificar.setText("Modificar");
			btnModificar.setBounds(313, 342, 126, 28);
			btnModificar.setFont(new java.awt.Font("Century Gothic",0,12));
			btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/kwrite_22x22.png")));
			btnModificar.setActionCommand("Modificar");
		}
		return btnModificar;
	}
	
	private JButton getJbtnBuscarSocio() {
		if(btnBuscarSocio == null) {
			btnBuscarSocio = new JButton();
			btnBuscarSocio.setBounds(233, 21, 32, 31);
			btnBuscarSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
			btnBuscarSocio.setActionCommand("BuscarSocio");
		}
		return btnBuscarSocio;
	}
	
	private JButton getJbtnBuscarCed() {
		if(btnBuscarCed == null) {
			btnBuscarCed = new JButton();
			btnBuscarCed.setBounds(500, 20, 32, 31);
			btnBuscarCed.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
			btnBuscarCed.setActionCommand("BuscarCedula");
		}
		return btnBuscarCed;
	}
		

	public void setTxtNroSocio(String NroSocio) {
		// TODO Auto-generated method stub
		this.txtNroSocio.setText(NroSocio);
		
	}
	
	public void setTxtApellidoSoc(String ApellidoSoc) {
		// TODO Auto-generated method stub
		this.txtApellidoSoc.setText(ApellidoSoc);
		
	}
	
	public void setTxtCedSocio(String CedSocio) {
		// TODO Auto-generated method stub
		this.txtCedSocio.setText(CedSocio);
		
	}
	
	public void setTxtDirecSocio(String DirecSocio) {
		// TODO Auto-generated method stub
		this.txtDirecSocio.setText(DirecSocio);
		
	}
	
	public void setTxtTelefono(String Telefono) {
		// TODO Auto-generated method stub
		this.txtTelefono.setText(Telefono);
		
	}

	public void setTxtNomSocio(String NomSocio) {
		// TODO Auto-generated method stub
		this.txtNomSocio.setText(NomSocio);		
		
	}

	public String getTxtNroSocio() {
		// TODO Auto-generated method stub
		return txtNroSocio.getText();
	}

	public String getTxttelefono() {
		// TODO Auto-generated method stub
		return txtTelefono.getText();
	}
	
	public String getTxtdirecSocio() {
		// TODO Auto-generated method stub
		return txtDirecSocio.getText();
	}
	
	public String getTxtapellidoSoc() {
		// TODO Auto-generated method stub
		return txtApellidoSoc.getText();
	}
	
	public String getTxtCedSocio() {
		// TODO Auto-generated method stub
		return txtCedSocio.getText();
	}

	public String getTxtnomSocio() {
		// TODO Auto-generated method stub
		return txtNomSocio.getText();
	}

	//agregar listeners
		public void agregarListener(ActionListener accion) {
			this.btnBuscarCed.addActionListener(accion);
			this.btnModificar.addActionListener(accion);
			this.btnCancelar.addActionListener(accion);
			this.btnBuscarSocio.addActionListener(accion);
			this.btnSiguiente.addActionListener(accion);
			this.btnRA.addActionListener(accion);
			this.btnRS.addActionListener(accion);
			this.btnRV.addActionListener(accion);
			this.txtCedSocio.addActionListener(accion);
			this.txtNroSocio.addActionListener(accion);
			
		}
		
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
		}

	// validar q todos los campos esten llenos

		public boolean CamposllenosSocio() {

			// variable local
			boolean CamposLLenos = false;

			if (this.txtNroSocio.getText().equals("")) {
				// si falta el codigo
				JOptionPane.showMessageDialog(null, "Debe ingresar el número de socio",
						"Error", 0);
				this.txtNroSocio.requestFocus();
				CamposLLenos = false;
				
			} else if (this.txtCedSocio.equals("")) {
				// si falta la cedula
				JOptionPane.showMessageDialog(null,
						"Debe ingresar la cedula del socio", "Error", 0);
				this.txtCedSocio.requestFocus();
				CamposLLenos = false;
				
			} else if (this.txtNomSocio.equals("")) {
				// si falta el nombre
				JOptionPane.showMessageDialog(null,
						"Debe ingresar el nombre del socio", "Error", 0);
				this.txtNomSocio.requestFocus();
				CamposLLenos = false;
				
			} else if (this.txtApellidoSoc.equals("")) {
				// si falta el apellido
				JOptionPane.showMessageDialog(null,
						"Debe ingresar el apellido del socio", "Error", 0);
				this.txtApellidoSoc.requestFocus();
				CamposLLenos = false;
				
			} else if (this.txtDirecSocio.equals("")) {
				// si falta la direccion
				JOptionPane.showMessageDialog(null,
						"Debe ingresar la dirección del socio", "Error", 0);
				this.txtDirecSocio.requestFocus();
				CamposLLenos = false;
				
			} else if (this.txtTelefono.equals("")) {
				// si falta el telefono
				JOptionPane.showMessageDialog(null,
						"Debe ingresar el teléfono del socio", "Error", 0);
				this.txtTelefono.requestFocus();
				CamposLLenos = false;
			} else {
				// sino falta nada
				CamposLLenos = true;
			}
			// retornamos el valor de la validacion
			return CamposLLenos;
		}
		
		
		public String llenarCodigo() {
			VistaAvance vavance =new VistaAvance();
		vavance.setTxtNroSocio(this.getTxtNroSocio());
		return vavance.getTxtNroSocio();
		}
		
		public String llenarNombre() {
			VistaAvance vavance =new VistaAvance();
		vavance.setTxtNomSocio(this.getTxtnomSocio()+" "+this.getTxtapellidoSoc());
		return vavance.getTxtNomSocio();
		}
		
		public String llenarCodigo2() {
			VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNroSocio(this.getTxtNroSocio());
		return vvehiculo.getTxtNroSocio();
		}
		
		public String llenarNombre2() {
			VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNomSocio(this.getTxtnomSocio()+" "+this.getTxtapellidoSoc());
		System.out.println(getTxtnomSocio());
		return vvehiculo.getTxtNomSocio();
		}
		
	//LimpiarCampos
	public void limpiarCampos() {
		
		txtNomSocio.setText("");
		txtNroSocio.setText("");
		txtApellidoSoc.setText("");
		txtCedSocio.setText("");
		txtDirecSocio.setText("");
		txtTelefono.setText("");
	}


	// cerrar Ventana
	public void cerrarVentana() {
		// TODO Auto-generated method stub
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (ValorDevuelto == 0) {
			this.dispose();
		}

}
	
	public Socio GuardarSocio(){
		Socio soc= new Socio();
		RutaDao rutaDao= new RutaDao();
		Date f= new Date();
		
		soc.setCedula(getTxtCedSocio());
		soc.setApellido(this.getTxtapellidoSoc());
		soc.setDireccion(getTxtdirecSocio());
		soc.setFechaIngreso(f);
		soc.setNombre(getTxtnomSocio());
		soc.setTelefono(Integer.parseInt(getTxttelefono()));
		soc.setMontoAhorro(0);
		soc.setNroSocio(getTxtNroSocio());
		soc.setStatus('A');
		try {
			soc.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return soc;
	}
	
	private JLabel getLblSocio() {
		if(lblSocio == null) {
			lblSocio = new JLabel();
			lblSocio.setText("Registrar Socio");
			lblSocio.setBounds(241, 24, 173, 26);
			lblSocio.setFont(new java.awt.Font("Century Gothic",2,20));
		}
		return lblSocio;
	}
	
	private JLabel getLblImagen() {
		if(lblImagen == null) {
			lblImagen = new JLabel();
			lblImagen.setBounds(1, 1, 234, 76);
			lblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
		}
		return lblImagen;
	}
	
	private JLabel getLblPregunta() {
		if(lblPregunta == null) {
			lblPregunta = new JLabel();
			lblPregunta.setText("¿Tiene Avanve?");
			lblPregunta.setBounds(328, 101, 122, 16);
		}
		return lblPregunta;
	}
	
	private JRadioButton getRbtnSI() {
		if(rbtnSI == null) {
			rbtnSI = new JRadioButton();
			rbtnSI.setText("Si");
			rbtnSI.setBounds(422, 99, 43, 20);
			getButtonGroupTieneAvance().add(rbtnSI);
		}
		return rbtnSI;
	}
	
	private JRadioButton getRbtnNo() {
		if(rbtnNo == null) {
			rbtnNo = new JRadioButton();
			rbtnNo.setText("No");
			rbtnNo.setBounds(470, 99, 45, 20);
			getButtonGroupTieneAvance().add(rbtnNo);
		}
		return rbtnNo;
	}
	
	
	public void prueba(boolean dato) {
		if (dato==true)
		this.rbtnSI.setSelected(true);
		else
			this.rbtnNo.setSelected(true);
	}
	
	public int Seleccion(){
		if(this.rbtnSI.isSelected()==true)
			return 1;
		if(this.rbtnNo.isSelected()==true)
			return 2;
		
		return 0;	
	}
	
	
	public int Selec(){
		if (this.Seleccion()==1){
			return 1;
		}else
				return 2;
			
	}
	
	public boolean Tiene() {
		if (this.rbtnSI.isSelected()==true)
		{
			return true;	
			}
		else {
			return false;		
		  }
	}
	
	
	private ButtonGroup getButtonGroupTieneAvance() {
		if(buttonGroupTieneAvance == null) {
			buttonGroupTieneAvance = new ButtonGroup();
		}
		return buttonGroupTieneAvance;
	}
	
	private JButton getBtnLimpiar() {
		if(btnLimpiar == null) {
			btnLimpiar = new JButton();
			btnLimpiar.setText("Limpiar");
			btnLimpiar.setBounds(172, 342, 127, 28);
			btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
			btnLimpiar.setFont(new java.awt.Font("Century Gothic",0,12));
			btnLimpiar.setActionCommand("Limpiar");
		}
		return btnLimpiar;
	}

}
