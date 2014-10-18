package Vistas;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


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
public class VistaAvanceArrendatario extends javax.swing.JFrame {
	private JPanel jPanelTitulo;
	private JLabel lblLogo;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnBuscar;
	private JTextField txtCedArrendatario;
	private JPanel jPanelDatosArrendatario;
	private JLabel lblCedArrendatario;
	private JPanel jPanelDatosAvance;
	private JLabel lblTitulo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaAvanceArrendatario inst = new VistaAvanceArrendatario();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public VistaAvanceArrendatario() {
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
			//	jPanelTitulo.setLayout(jPanelTitulo);
				jPanelTitulo.setBounds(12, 17, 604, 73);
				jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
				jPanelTitulo.setLayout(null);
				{
					lblLogo = new JLabel();
					jPanelTitulo.add(lblLogo);
					lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
					lblLogo.setBounds(12, 6, 152, 61);
				}
				{
					lblTitulo = new JLabel();
					jPanelTitulo.add(lblTitulo);
					lblTitulo.setText("Registrar Avances por Arrendatario");
					lblTitulo.setBounds(189, 26, 386, 27);
					lblTitulo.setFont(new java.awt.Font("Century Gothic",2,20));
				}
			}
			{
				jPanelDatosAvance = new JPanel();
				getContentPane().add(jPanelDatosAvance);
				//jPanelDatosAvance.setLayout(jPanelDatosAvanceLayout);
				jPanelDatosAvance.setBounds(12, 189, 235, 263);
				jPanelDatosAvance.setBorder(BorderFactory.createTitledBorder("Datos del Avance"));
				jPanelDatosAvance.setLayout(null);
			}
			{
				jPanelDatosArrendatario = new JPanel();
				getContentPane().add(jPanelDatosArrendatario);
				jPanelDatosArrendatario.setBounds(12, 115, 604, 62);
				//jPanelDatosSocio.setLayout(jPanelDatosSocioLayout);
				jPanelDatosArrendatario.setBorder(BorderFactory.createTitledBorder("Datos del Arrendatario"));
				jPanelDatosArrendatario.setLayout(null);
				{
					lblCedArrendatario = new JLabel();
					jPanelDatosArrendatario.add(lblCedArrendatario);
					lblCedArrendatario.setText("Cédula:");
					lblCedArrendatario.setBounds(19, 29, 51, 16);
				}
				{
					txtCedArrendatario = new JTextField();
					jPanelDatosArrendatario.add(txtCedArrendatario);
					txtCedArrendatario.setBounds(70, 26, 106, 23);
				}
				{
					btnBuscar = new JButton();
					jPanelDatosArrendatario.add(btnBuscar);
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscar.setBounds(190, 26, 30, 23);
				}
				{
					lblNombre = new JLabel();
					jPanelDatosArrendatario.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(254, 29, 60, 16);
				}
				{
					txtNombre = new JTextField();
					jPanelDatosArrendatario.add(txtNombre);
					txtNombre.setBounds(312, 26, 275, 23);
				}
			}
			pack();
			this.setSize(644, 502);
	

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
