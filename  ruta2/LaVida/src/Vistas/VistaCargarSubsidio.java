package Vistas;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JTextField txtCodSubsidio;
	private JLabel lblCodSub;
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
				jPanelTitulo.setBounds(12, 12, 496, 73);
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
					lblTitulo.setBounds(176, 19, 268, 34);
					lblTitulo.setFont(new java.awt.Font("Segoe UI",3,18));
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
				}
				{
					btnBuscarSocio = new JButton();
					jPanelDatosSocio.add(btnBuscarSocio);
					btnBuscarSocio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscarSocio.setBounds(144, 27, 30, 23);
					btnBuscarSocio.setActionCommand("");
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
					lblMontoSubsidio.setBounds(200, 30, 53, 16);
				}
				{
					txtMontoSubsidio = new JTextField();
					jPanelSubsidio.add(txtMontoSubsidio);
					txtMontoSubsidio.setBounds(258, 26, 129, 23);
				}
				{
					lblCodSub = new JLabel();
					jPanelSubsidio.add(lblCodSub);
					lblCodSub.setText("Código");
					lblCodSub.setBounds(17, 30, 48, 16);
				}
				{
					txtCodSubsidio = new JTextField();
					jPanelSubsidio.add(txtCodSubsidio);
					txtCodSubsidio.setBounds(65, 27, 107, 23);
				}
			}
			{
				btnGuardar = new JButton();
				getContentPane().add(btnGuardar);
				btnGuardar.setText("Guardar");
				btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
				btnGuardar.setBounds(156, 260, 84, 29);
				btnGuardar.setActionCommand("");
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/button_cancel_16x16.png")));
				btnCancelar.setBounds(276, 261, 80, 28);
				btnCancelar.setActionCommand("Cancelar");
			}
			pack();
			this.setSize(536, 339);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	public JTextField getTxtCodSubsidio() {
		return txtCodSubsidio;
	}

	public void setTxtCodSubsidio(String txtCodSubsidio) {
		this.txtCodSubsidio.setText(txtCodSubsidio);
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
	}
	
	public void LimpiarCampos(){
		this.txtCodSocio.setText("");
		this.txtCodSubsidio.setText("");
		this.txtMontoSubsidio.setText("");
		this.txtNomApe.setText("");
	}
	
	

}
