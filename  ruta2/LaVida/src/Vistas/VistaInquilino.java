package Vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

import Modelos.Hibernate.Daos.InquilinoDao;


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
public class VistaInquilino extends javax.swing.JFrame {
	private JPanel jpDatosInquilino;
	private JTextField txtCedulaRif;
	private JLabel lblNombre;
	private JLabel lblLogo;
	private JPanel panelEncabez;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private ButtonGroup btnGroupTipoPersona;
	private JButton btnBuscarRif;
	private JLabel lblTitulo;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JComboBox cmbTipoPerson;
	private JTextField txtNombre;
	private JLabel lblTelefono;
	private JLabel txtTipoPerson;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JButton btnBuscarCed;
	private JLabel lblCedulaRif;
	
	//Mis datos
	InquilinoDao daoInquilino= new InquilinoDao();
	VistaAlquiler vistaAlq= new VistaAlquiler();

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaInquilino inst = new VistaInquilino();
				inst.setLocation(400, 200);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaInquilino vInq=null;
private JTextField txtRif;
private JLabel lblRif;
private JRadioButton rbtnJuridico;
private JRadioButton rbtnNatural;
private JLabel lblTipo;

	public static VistaInquilino obtenerInstancia(){
		if(vInq==null)
			vInq= new VistaInquilino();
		return vInq;
	}
	
	public VistaInquilino() {
		super();
		initGUI();
		this.txtCodigo.setEnabled(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jpDatosInquilino = new JPanel();
				getContentPane().add(jpDatosInquilino);
				jpDatosInquilino.setBounds(10, 88, 459, 187);
				jpDatosInquilino.setBorder(BorderFactory.createTitledBorder("Datos del Inquilino"));
				jpDatosInquilino.setLayout(null);
				jpDatosInquilino.add(getRbtnNatural());
				{
					lblCedulaRif = new JLabel();
					jpDatosInquilino.add(lblCedulaRif);
					lblCedulaRif.setText("Cédula:");
					lblCedulaRif.setBounds(30, 55, 79, 16);
				}
				{
					txtCedulaRif = new JTextField();
					jpDatosInquilino.add(txtCedulaRif);
					txtCedulaRif.setBounds(89, 52, 103, 23);
				}
				{
					btnBuscarCed = new JButton();
					jpDatosInquilino.add(btnBuscarCed);
					btnBuscarCed.setBounds(198, 51, 34, 27);
					btnBuscarCed.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarCed.setActionCommand("BuscarCedula");
				}
				{
					btnBuscarRif = new JButton();
					jpDatosInquilino.add(btnBuscarRif);
					btnBuscarRif.setBounds(415, 51, 34, 27);
					btnBuscarRif.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarRif.setActionCommand("BuscarRif");
				}
				{
					lblNombre = new JLabel();
					jpDatosInquilino.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(29, 87, 54, 16);
				}
				{
					txtNombre = new JTextField();
					jpDatosInquilino.add(txtNombre);
					txtNombre.setBounds(90, 84, 149, 23);
				}
				{
					lblApellido = new JLabel();
					jpDatosInquilino.add(lblApellido);
					lblApellido.setText("Apellido:");
					lblApellido.setBounds(252, 87, 56, 16);
				}
				{
					txtApellido = new JTextField();
					jpDatosInquilino.add(txtApellido);
					txtApellido.setBounds(308, 84, 139, 23);
				}
				{
					lblDireccion = new JLabel();
					jpDatosInquilino.add(lblDireccion);
					lblDireccion.setText("Dirección:");
					lblDireccion.setBounds(29, 122, 59, 16);
				}
				{
					txtDireccion = new JTextField();
					jpDatosInquilino.add(txtDireccion);
					txtDireccion.setBounds(90, 114, 354, 34);
				}
				{
					lblTelefono = new JLabel();
					jpDatosInquilino.add(lblTelefono);
					lblTelefono.setText("Teléfono:");
					lblTelefono.setBounds(29, 158, 59, 16);
				}
				{
					txtTelefono = new JTextField();
					jpDatosInquilino.add(txtTelefono);
					txtTelefono.setBounds(90, 155, 111, 23);
				}
				{
					txtTipoPerson = new JLabel();
					jpDatosInquilino.add(txtTipoPerson);
					txtTipoPerson.setText("Tipo:");
					txtTipoPerson.setBounds(216, 158, 54, 16);
				}
				{
					ComboBoxModel cmbTipoPersonModel = 
							new DefaultComboBoxModel(
									new String[] { "Natural", "Júridica" });
					cmbTipoPerson = new JComboBox();
					jpDatosInquilino.add(cmbTipoPerson);
					jpDatosInquilino.add(getLblTipo());
					jpDatosInquilino.add(getRbtnJuridico());
					jpDatosInquilino.add(getLblRif());
					jpDatosInquilino.add(getTxtRif());
					jpDatosInquilino.add(getLblCodigo());
					jpDatosInquilino.add(getTxtCodigo());
					cmbTipoPerson.setModel(cmbTipoPersonModel);
					cmbTipoPerson.setBounds(254, 155, 191, 23);
				}
			}
			{
				panelEncabez = new JPanel();
				getContentPane().add(panelEncabez);
				panelEncabez.setLayout(null);
				panelEncabez.setBounds(12, 9, 457, 73);
				panelEncabez.setBackground(new java.awt.Color(255,255,255));
				{
					lblTitulo = new JLabel();
					panelEncabez.add(lblTitulo);
					lblTitulo.setText("Registrar Inquilino");
					lblTitulo.setBounds(196, 27, 166, 24);
					lblTitulo.setFont(new java.awt.Font("Century Gothic",0,18));			
				}
				{
					lblLogo = new JLabel();
					lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
					lblLogo.setBounds(12, 5, 152, 61);
					panelEncabez.add(lblLogo);	
				}
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(17, 282, 110, 26);
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setActionCommand("Cancelar");
			}
			{
				btnModificar = new JButton();
				getContentPane().add(btnModificar);
				btnModificar.setText("Modifcar");
				btnModificar.setBounds(131, 282, 110, 26);
				btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/kwrite_22x22.png")));
				btnModificar.setActionCommand("Modificar");
			}
			{
				btnLimpiar = new JButton();
				getContentPane().add(btnLimpiar);
				btnLimpiar.setText("Limpiar");
				btnLimpiar.setBounds(245, 282, 110, 26);
				btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
				btnLimpiar.setActionCommand("Limpiar");
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setBounds(358, 282, 110, 26);
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setActionCommand("Guardar");
			}
			pack();
			this.setSize(497, 361);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JLabel getLblTipo() {
		if(lblTipo == null) {
			lblTipo = new JLabel();
			lblTipo.setText("Tipo :");
			lblTipo.setBounds(261, 18, 30, 16);
		}
		return lblTipo;
	}
	
	private JRadioButton getRbtnNatural() {
		if(rbtnNatural == null) {
			rbtnNatural = new JRadioButton();
			rbtnNatural.setText("Natural");
			rbtnNatural.setBounds(304, 16, 57, 20);
			getBtnGroupTipoPersona().add(rbtnNatural);
		
		}
		return rbtnNatural;
	}
	
	private JRadioButton getRbtnJuridico() {
		if(rbtnJuridico == null) {
			rbtnJuridico = new JRadioButton();
			rbtnJuridico.setText("Jurídico");
			rbtnJuridico.setBounds(378, 16, 59, 20);
			getBtnGroupTipoPersona().add(rbtnJuridico);
		}
		return rbtnJuridico;
	}
	
	private JLabel getLblRif() {
		if(lblRif == null) {
			lblRif = new JLabel();
			lblRif.setText("Rif:");
			lblRif.setBounds(252, 55, 23, 16);
		}
		return lblRif;
	}
	
	private JTextField getTxtRif() {
		if(txtRif == null) {
			txtRif = new JTextField();
			txtRif.setBounds(281, 52, 128, 23);
		}
		return txtRif;
	}
	private ButtonGroup getBtnGroupTipoPersona() {
		if(btnGroupTipoPersona == null) {
			btnGroupTipoPersona = new ButtonGroup();
			
		}
		return btnGroupTipoPersona;
	}
	
	private JLabel getLblCodigo() {
		if(lblCodigo == null) {
			lblCodigo = new JLabel();
			lblCodigo.setText("Código: ");
			lblCodigo.setBounds(32, 22, 51, 16);
		}
		return lblCodigo;
	}
	
	public JTextField getTxtCodigo() {
		if(txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setBounds(89, 19, 143, 23);
			txtCodigo.setActionCommand("BInquiTecla");
		}
		return txtCodigo;
	}
	
	public String getCodigo(){
		return this.txtCodigo.getText();
	}
	public String getTxtCedulaRif() {
		return txtCedulaRif.getText();
	}

	public void setTxtCedulaRif(String txtCedula) {
		this.txtCedulaRif.setText(txtCedula);
	}

	public JComboBox getCmbTipoPerson() {
		return cmbTipoPerson;
	}

	public void setCmbTipoPerson(JComboBox cmbTipoPerson) {
		this.cmbTipoPerson = cmbTipoPerson;
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String Nombre) {
		this.txtNombre.setText(Nombre);
	}

	public JLabel getTxtTipoPerson() {
		return txtTipoPerson;
	}

	public void setTxtTipoPerson(JLabel txtTipoPerson) {
		this.txtTipoPerson = txtTipoPerson;
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String Telefono) {
		this.txtTelefono.setText(Telefono);
	}

	public String getTxtDireccion() {
		return txtDireccion.getText();
	}

	public void setTxtDireccion(String txtDireccion) {
		this.txtDireccion.setText(txtDireccion);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}
	
	public void setTxtRif(String txtRif) {
		this.txtRif.setText(txtRif);
	}
	
	public String getTxtRif1(){
		return txtRif.getText();
	}

	
	public String llenarCodigo() {
		VistaAlquiler valquiler =new VistaAlquiler();
	valquiler.setTxtCedRifInq(this.getTxtCedulaRif());
	return valquiler.getCedRif();
	}
	
	public String llenarNombre() {
		VistaAlquiler valquiler =new VistaAlquiler();
	valquiler.setTxtNombre(this.getTxtNombre()+" "+this.getTxtApellido());
	return valquiler.getTxtNombreInqui();
	}
	
			//agregar listeners
			public void agregarListener(ActionListener accion) {
				this.btnGuardar.addActionListener(accion);
				this.btnModificar.addActionListener(accion);
				this.btnBuscarCed.addActionListener(accion);
				this.btnCancelar.addActionListener(accion);
				this.btnLimpiar.addActionListener(accion);
				this.btnBuscarRif.addActionListener(accion);
				
			}

			//LimpiarCampos
			public void limpiarCampos() {
				txtApellido.setText("");
				txtCedulaRif.setText("");
				txtDireccion.setText("");
				txtNombre.setText("");
				txtTelefono.setText("");
				txtRif.setText("");
				this.MostrarVentana();
				
			}

		public boolean mostrarTipo() {
				if (rbtnNatural.isSelected())
				{
					return true;	
					}
				else {
					return false;		
				  }
			}
		
		public void BloquearCamposNatural(){
				this.txtRif.setEnabled(false);
				this.rbtnNatural.setSelected(true);
				this.rbtnJuridico.setEnabled(false);
				this.rbtnNatural.setEnabled(false);
				this.btnBuscarRif.setEnabled(false);
		}
		
		public void BloquearCamposJuridicos(){

			this.txtCedulaRif.setEnabled(false);
			this.txtApellido.setEnabled(false);
			this.rbtnJuridico.setSelected(true);
			this.rbtnJuridico.setEnabled(false);
			this.rbtnNatural.setEnabled(false);
			this.cmbTipoPerson.setSelectedIndex(1);
			this.btnBuscarCed.setEnabled(false);
		
		}
		
		public void MostrarVentana(){
			btnGroupTipoPersona.clearSelection();
			txtRif.setEnabled(true);
			txtCedulaRif.setEnabled(true);
			txtApellido.setEnabled(true);
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
				public void GenerarCodigo(){
				int cantInq=0;
				try {
					cantInq = daoInquilino.obtenerTodos().size()+1;
					if(cantInq<10)
					{
						this.txtCodigo.setText("IN"+"000"+cantInq);
					}else if(cantInq<100)
					{
						this.txtCodigo.setText("IN"+"00"+cantInq);
						
					}else if(cantInq<1000)
						this.txtCodigo.setText("IN"+"0"+cantInq);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
				
			/*public void stateChanged(ChangeEvent e) 
			{
			//Si el JRadioButton está seleccionado, entonces lleno el JComboBox con los siguientes elementos.
			if (radio1.isSelected())
			{
			combo1.removeAllItems();
			combo1.addItem("Radio1 Seleccionado");
			}

			if (radio2.isSelected())
			{
			combo1.removeAllItems();
			combo1.addItem("Radio2 Seleccionado");
			}

			if (radio3.isSelected())
			{
			combo1.removeAllItems();
			combo1.addItem("Radio3 Seleccionado");
			} 
			}

			public void itemStateChanged(ItemEvent e)
			{
			if (e.getSource()==combo1) 
			{
			String seleccionado=(String)combo1.getSelectedItem();
			setTitle(seleccionado);
			}
			}*/
				
			public void agregarKey(KeyListener a) {
					txtCedulaRif.addKeyListener(a);
					txtTelefono.addKeyListener(a);
				}

}
