package Vistas;
import java.awt.LayoutManager;
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
import javax.swing.SwingUtilities;

import Modelos.Arrendatario;
import Modelos.Ruta;
import Modelos.Hibernate.Daos.RutaDao;


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
public class VistaArrendatario extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaArrendatario inst = new VistaArrendatario();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static VistaArrendatario vArrendatario=null;
	private JLabel lbl;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblNombre;
	private JButton btnSiguiente;
	private JRadioButton jRadioButtonNo;
	private JRadioButton jRadioButtonSi;
	private ButtonGroup buttonGroupTieneAvance;
	private JTextField txtMonto;
	private JLabel lblPregunta;
	private JPanel jpImagen;
	private JLabel jLabel1;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnLimpiar;
	private JLabel lblBsF;
	private JLabel lblMonto;
	private JLabel lblCedulaRif;
	private JTextField txtNombre;
	private JTextField txtCedulaRif;
	private JButton btnBuscar;
	private JTextField txtTelefono;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JPanel jPanelDatosArrendatario;
	private JPanel jPanelTitulo;
	
	private RutaDao rutaDao= new RutaDao();
	
	public static VistaArrendatario obtenerInstancia(){
		if(vArrendatario==null)
			vArrendatario= new VistaArrendatario();
		return vArrendatario;
	}
	
	public VistaArrendatario() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelDatosArrendatario = new JPanel();
				getContentPane().add(jPanelDatosArrendatario);
				jPanelDatosArrendatario.setBounds(18, 105, 504, 161);
				jPanelDatosArrendatario.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
				jPanelDatosArrendatario.setLayout(null);
				{
					lblCedulaRif = new JLabel();
					jPanelDatosArrendatario.add(lblCedulaRif);
					lblCedulaRif.setText("Cédula:");
					lblCedulaRif.setBounds(29, 21, 48, 16);
				}
				{
					txtCedulaRif = new JTextField();
					jPanelDatosArrendatario.add(txtCedulaRif);
					txtCedulaRif.setBounds(89, 18, 121, 23);
				}
				{
					btnBuscar = new JButton();
					jPanelDatosArrendatario.add(btnBuscar);
					btnBuscar.setBounds(216, 13, 34, 28);
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscar.setActionCommand("Buscar");
				}
				{
					lblNombre = new JLabel();
					jPanelDatosArrendatario.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(28, 54, 54, 16);
				}
				{
					txtNombre = new JTextField();
					jPanelDatosArrendatario.add(txtNombre);
					txtNombre.setBounds(89, 51, 162, 23);
				}
				{
					lblApellido = new JLabel();
					jPanelDatosArrendatario.add(lblApellido);
					lblApellido.setText("Apellido:");
					lblApellido.setBounds(263, 54, 56, 16);
				}
				{
					txtApellido = new JTextField();
					jPanelDatosArrendatario.add(txtApellido);
					txtApellido.setBounds(319, 51, 168, 23);
				}
				{
					lblDireccion = new JLabel();
					jPanelDatosArrendatario.add(lblDireccion);
					lblDireccion.setText("Dirección:");
					lblDireccion.setBounds(25, 94, 59, 16);
				}
				{
					txtDireccion = new JTextField();
					jPanelDatosArrendatario.add(txtDireccion);
					txtDireccion.setBounds(88, 85, 399, 35);
				}
				{
					lblMonto = new JLabel();
					jPanelDatosArrendatario.add(lblMonto);
					lblMonto.setText("Monto:");
					lblMonto.setBounds(25, 128, 59, 16);
				}
				{
					txtMonto = new JTextField();
					jPanelDatosArrendatario.add(txtMonto);
					txtMonto.setBounds(88, 125, 101, 22);
				}
				{
					lblTelefono = new JLabel();
					jPanelDatosArrendatario.add(lblTelefono);
					lblTelefono.setText("Teléfono:");
					lblTelefono.setBounds(261, 21, 59, 16);
				}
				{
					txtTelefono = new JTextField();
					jPanelDatosArrendatario.add(txtTelefono);
					txtTelefono.setBounds(320, 18, 167, 23);
				}
				{
					lblBsF = new JLabel();
					jPanelDatosArrendatario.add(lblBsF);
					jPanelDatosArrendatario.add(getLblPregunta());
					jPanelDatosArrendatario.add(getJRadioButtonSi());
					jPanelDatosArrendatario.add(getJRadioButtonNo());
					lblBsF.setText("BsF.");
					lblBsF.setBounds(192, 128, 59, 16);
				}
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(47, 283, 110, 26);
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setActionCommand("Cancelar");
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Modifcar");
				btnModificar.setBounds(160, 283, 110, 26);
				btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/kwrite_22x22.png")));
				btnModificar.setActionCommand("Modificar");
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(275, 283, 110, 26);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setActionCommand("Limpiar");
			}
			{
				lbl = new JLabel();
				getContentPane().add(lbl);
				getContentPane().add(getJLabel1());
				getContentPane().add(getJpImagen());
				getContentPane().add(getBtnSiguiente());
				//getContentPane().add(jPanelTitulo);
				lbl.setText("Registrar Arrendatario");
				lbl.setBounds(228, 49, 219, 24);
				lbl.setFont(new java.awt.Font("Century Gothic",2,20));
			}
			pack();
			this.setSize(558, 373);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	
	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public void setTxtDireccion(String txtDireccion) {
		this.txtDireccion.setText(txtDireccion);
	}

	public String getTxtMonto() {
		return txtMonto.getText();
	}

	public void setTxtMonto(String txtMonto) {
		this.txtMonto.setText(txtMonto);
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public String getTxtCedulaRif() {
		return txtCedulaRif.getText();
	}

	public void setTxtCedulaRif(String txtCedulaRif) {
		this.txtCedulaRif.setText(txtCedulaRif);
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}

		//agregar listeners
		public void agregarListener(ActionListener accion) {
			this.btnSiguiente.addActionListener(accion);
			this.btnModificar.addActionListener(accion);
			this.btnLimpiar.addActionListener(accion);
			this.btnBuscar.addActionListener(accion);
			this.btnCancelar.addActionListener(accion);
		}

		//LimpiarCampos
		public void limpiarCampos() {
			txtApellido.setText("");
			txtDireccion.setText("");
			txtNombre.setText("");
			txtTelefono.setText("");
			txtCedulaRif.setText("");
			txtMonto.setText("");
		
		}

		public boolean CamposLlenos(){
			boolean CamposLLenos= false;
			
			if(txtCedulaRif.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe ingresar la cedula",
						"Error", 0);
				this.txtCedulaRif.requestFocus();
				CamposLLenos=false;
			}else if(txtApellido.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Verifique",
						"Error", 0);
				this.txtApellido.requestFocus();
				CamposLLenos=false;
			}else if(txtDireccion.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe ingresar la direccion del arrendatario",
						"Error", 0);
				this.txtDireccion.requestFocus();
				CamposLLenos=false;
			}else if(txtNombre.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del arrendatario",
						"Error", 0);
				this.txtNombre.requestFocus();
				CamposLLenos=false;
			}else if(txtTelefono.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe ingresar el telefono del arrendatario",
						"Error", 0);
				this.txtTelefono.requestFocus();
				CamposLLenos=false;
			}else if(txtMonto.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe ingresar el monto del deposito",
						"Error", 0);
				this.txtMonto.requestFocus();
				CamposLLenos=false;
			}else if(this.Seleccion()==0)
			{
				JOptionPane.showMessageDialog(null, "Debe responder la pregunta",
						"Error", 0);
			}
				CamposLLenos=true;
			
			return CamposLLenos;
			
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
		
		private JLabel getJLabel1() {
			if(jLabel1 == null) {
				jLabel1 = new JLabel();
				jLabel1.setBounds(26, 23, 481, 75);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			}
			return jLabel1;
		}
		
		private JPanel getJpImagen() {
			if(jpImagen == null) {
				jpImagen = new JPanel();
				jpImagen.setBounds(23, 26, 493, 68);
				jpImagen.setBackground(new java.awt.Color(255,255,255));
			}
			return jpImagen;
		}

		public String llenarCodigo() {
			VistaAvance vavance =new VistaAvance();
		vavance.setTxtNroSocio(this.getTxtCedulaRif());
		return vavance.getTxtNroSocio();
		}
		
		public String llenarNombre() {
			VistaAvance vavance =new VistaAvance();
		vavance.setTxtNomSocio(this.getTxtNombre()+" "+this.getTxtApellido());
		System.out.println(getTxtNombre());
		return vavance.getTxtNombre();
		}
		
		
		public int Selec(){
			if (this.Seleccion()==1){
				return 1;
			}else
					return 2;
				
		}
		
		
		public String llenarCodigo2() {
			VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNroSocio(this.getTxtCedulaRif());
		return vvehiculo.getTxtNroSocio();
		}
		
		public String llenarNombre2() {
			VistaVehiculo vvehiculo =new VistaVehiculo();
		vvehiculo.setTxtNomSocio(this.getTxtNombre()+" "+this.getTxtApellido());
		System.out.println(getTxtNombre());
		return vvehiculo.getTxtNomSocio();
		}
		
		private JLabel getLblPregunta() {
			if(lblPregunta == null) {
				lblPregunta = new JLabel();
				lblPregunta.setText("¿Tiene Avance?");
				lblPregunta.setBounds(246, 129, 120, 16);
			}
			return lblPregunta;
		}
		
		private ButtonGroup getButtonGroupTieneAvance() {
			if(buttonGroupTieneAvance == null) {
				buttonGroupTieneAvance = new ButtonGroup();
			}
			return buttonGroupTieneAvance;
		}
		
		private JRadioButton getJRadioButtonSi() {
			if(jRadioButtonSi == null) {
				jRadioButtonSi = new JRadioButton();
				jRadioButtonSi.setText("Si");
				jRadioButtonSi.setBounds(338, 127, 37, 20);
				getButtonGroupTieneAvance().add(jRadioButtonSi);
				getButtonGroupTieneAvance().add(jRadioButtonSi);
			}
			return jRadioButtonSi;
		}
		
		private JRadioButton getJRadioButtonNo() {
			if(jRadioButtonNo == null) {
				jRadioButtonNo = new JRadioButton();
				jRadioButtonNo.setText("No");
				jRadioButtonNo.setBounds(382, 127, 56, 20);
				getButtonGroupTieneAvance().add(jRadioButtonNo);
			}
			return jRadioButtonNo;
		}
		
		private JButton getBtnSiguiente() {
			if(btnSiguiente == null) {
				btnSiguiente = new JButton();
				btnSiguiente.setText("Siguiente");
				btnSiguiente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sig.png")));
				btnSiguiente.setBounds(396, 284, 103, 23);
				btnSiguiente.setActionCommand("Siguiente");
				
			}
			return btnSiguiente;
		}
		
		public int Seleccion(){
			if(jRadioButtonSi.isSelected()==true)
				return 1;
			if(jRadioButtonNo.isSelected()==true)
				return 2;
			
			return 0;
		}
		
		public Arrendatario GuardarArrendatario() {
			Arrendatario arren= new Arrendatario();
			Ruta ruta= new Ruta();
			Date f= new Date();
			
			arren.setCedula(getTxtCedulaRif());
			arren.setApellido(getTxtApellido());
			arren.setDireccion(getTxtDireccion());
			if(this.getTxtMonto().equals("")){
				arren.setMonto((float) 0);
			}else
				arren.setMonto(Float.parseFloat(getTxtMonto()));
			
			arren.setNombre(getTxtNombre());
			arren.setStatus("Activo");
			if(this.getTxtTelefono().equals("")){
				arren.setTelefono(0);
			}else
				arren.setTelefono(Integer.parseInt(getTxtTelefono()));
			try {
				arren.setRuta(rutaDao.buscarPorCodRuta("J-306-902686"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return arren;
		}
}
