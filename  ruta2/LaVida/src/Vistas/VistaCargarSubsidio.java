package Vistas;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class VistaCargarSubsidio extends javax.swing.JFrame {
	private JPanel jPanelTitulo;
	private JLabel lblLogo;
	private JPanel jPanelDatosSocio;
	private JButton btnLimpiar;
	private JLabel jLabel1;
	private JLabel lblBs;
	private JButton btnCancelar;
	private JTextField txtNomApe;
	private JButton btnGuardar;
	private JTextField txtMontoSubsidio;
	private JLabel lblMontoSubsidio;
	private JPanel jPanelSubsidio;
	private JLabel lblNombre;
	private JButton btnBuscarSocio;
	private JTextField txtCodSocio;
	private JLabel lblCodigo;
	private JLabel lblTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaCargarSubsidio inst = new VistaCargarSubsidio();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private static VistaCargarSubsidio vCargar=null;
	
	public static VistaCargarSubsidio obtenerInstancia(){
		if(vCargar==null)
			vCargar= new VistaCargarSubsidio();
		
		return vCargar;
		
	}

	public VistaCargarSubsidio() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelTitulo = new JPanel();
				getContentPane().add(jPanelTitulo);
				jPanelTitulo.setBounds(0, 1, 520, 80);
				jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
				jPanelTitulo.setLayout(null);
				{
					lblLogo = new JLabel();
					jPanelTitulo.add(lblLogo);
					lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
					lblLogo.setBounds(12, 5, 152, 61);
				}
				{
					lblTitulo = new JLabel();
					jPanelTitulo.add(lblTitulo);
					lblTitulo.setText("Cargar Subsidio por Socio");
					lblTitulo.setBounds(176, 19, 320, 34);
					lblTitulo.setFont(new java.awt.Font("Century Gothic",1,24));
				}
			}
			{
				jPanelDatosSocio = new JPanel();
				getContentPane().add(jPanelDatosSocio);
				jPanelDatosSocio.setBounds(12, 105, 496, 71);
				jPanelDatosSocio.setLayout(null);
				jPanelDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				{
					lblCodigo = new JLabel();
					jPanelDatosSocio.add(lblCodigo);
					lblCodigo.setText("Código:");
					lblCodigo.setBounds(17, 30, 53, 16);
				}
				{
					txtCodSocio = new JTextField();
					jPanelDatosSocio.add(txtCodSocio);
					txtCodSocio.setBounds(66, 27, 66, 23);
					txtCodSocio.setActionCommand("BSocioTecla");
				}
				{
					btnBuscarSocio = new JButton();
					jPanelDatosSocio.add(btnBuscarSocio);
					btnBuscarSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarSocio.setBounds(144, 27, 30, 23);
					btnBuscarSocio.setActionCommand("BuscarSocio");
				}
				{
					lblNombre = new JLabel();
					jPanelDatosSocio.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(197, 30, 56, 16);
				}
				{
					txtNomApe = new JTextField();
					jPanelDatosSocio.add(txtNomApe);
					txtNomApe.setBounds(253, 27, 208, 23);
				}
			}
			{
				jPanelSubsidio = new JPanel();
				getContentPane().add(jPanelSubsidio);
				jPanelSubsidio.setBounds(12, 182, 496, 66);
				jPanelSubsidio.setBorder(BorderFactory.createTitledBorder("Datos del Subsidio"));
				jPanelSubsidio.setLayout(null);
				{
					lblMontoSubsidio = new JLabel();
					jPanelSubsidio.add(lblMontoSubsidio);
					lblMontoSubsidio.setText("Monto:");
					lblMontoSubsidio.setBounds(17, 33, 53, 16);
				}
				{
					txtMontoSubsidio = new JTextField();
					jPanelSubsidio.add(txtMontoSubsidio);
					jPanelSubsidio.add(getJLabel1());
					txtMontoSubsidio.setBounds(67, 30, 194, 23);
				}
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setBounds(57, 260, 111, 29);
				btnGuardar.setActionCommand("Guardar");
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				getContentPane().add(getBtnLimpiar());
				btnCancelar.setText("Salir");
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setBounds(195, 261, 131, 28);
				btnCancelar.setActionCommand("Salir");
			}
			pack();
			this.setSize(536, 339);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public String getTxtNomApe() {
		return txtNomApe.getText();
	}

	public void setTxtNomApe(String txtNomApe) {
		this.txtNomApe.setText(txtNomApe);
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public String getTxtMontoSubsidio() {
		return txtMontoSubsidio.getText();
	}

	public void setTxtMontoSubsidio(String txtMontoSubsidio) {
		this.txtMontoSubsidio.setText(txtMontoSubsidio);
	}

	public JButton getBtnBuscarSocio() {
		return btnBuscarSocio;
	}

	public void setBtnBuscarSocio(JButton btnBuscarSocio) {
		this.btnBuscarSocio = btnBuscarSocio;
	}

	public String getTxtCodSocio() {
		return txtCodSocio.getText();
	}

	public void setTxtCodSocio(String txtCodSocio) {
		this.txtCodSocio.setText(txtCodSocio);
	}
	
	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnBuscarSocio.addActionListener(accion);
		this.btnCancelar.addActionListener(accion);
		this.txtCodSocio.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
	}
	
	public void LimpiarCampos(){
		this.txtCodSocio.setText("");
		this.txtMontoSubsidio.setText("");
		this.txtNomApe.setText("");
	}
	
	private JLabel getLblBs() {
		if(lblBs == null) {
			lblBs = new JLabel();
			lblBs.setText("Bs.");
			lblBs.setBounds(438, 29, 41, 16);
		}
		return lblBs;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Bs.");
			jLabel1.setBounds(273, 33, 39, 16);
		}
		return jLabel1;
	}
	
	private JButton getBtnLimpiar() {
		if(btnLimpiar == null) {
			btnLimpiar = new JButton();
			btnLimpiar.setText("Limpiar");
			btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
			btnLimpiar.setBounds(352, 260, 127, 29);
			btnLimpiar.setActionCommand("Limpiar");
		}
		return btnLimpiar;
	}

	public void BloquearNombreSoc() {
		txtNomApe.setEditable(false);
			}

	public void cerrarVentana() {
		// TODO Auto-generated method stub
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,
				"¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
		if (ValorDevuelto == 0) {
			this.dispose();
		}
	}
	
	public boolean Camposllenos() {

		// variable local
		boolean CamposLLenos = false;

		if (this.txtCodSocio.getText().equals("")) {
			// si falta el codigo
			JOptionPane.showMessageDialog(null, "Debe ingresar el número de socio",
					"Error", 0);
			this.txtCodSocio.requestFocus();
			CamposLLenos = false;
			
		} else if (this.txtMontoSubsidio.getText().equals("")) {
			// si falta la cedula
			JOptionPane.showMessageDialog(null,
					"Debe ingresar un monto válido", "Error", 0);
			this.txtMontoSubsidio.requestFocus();
			CamposLLenos = false;
			
		} else {
			// sino falta nada
			CamposLLenos = true;
		}
		// retornamos el valor de la validacion
		return CamposLLenos;
	}
}
