package Vistas;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class VistaDeuda extends javax.swing.JFrame {
	private JPanel jpDatosSocio;
	private JLabel lblNroSocio;
	private JTextField txtTotal;
	private JLabel lblTotal;
	private JButton btnCerrar;
	private JTable jtLDeudas;
	private JScrollPane spListadoDeudas;
	private JPanel jpDeudas;
	private JButton btnBuscar;
	private JTextField txtNomSocio;
	private JLabel lblNomSocio;
	private JTextField txtNroSocio;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaDeuda inst = new VistaDeuda();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VistaDeuda() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jpDatosSocio = new JPanel();
				getContentPane().add(jpDatosSocio);
				jpDatosSocio.setBounds(12, 58, 504, 59);
				jpDatosSocio.setBorder(BorderFactory.createTitledBorder("Datos del Socio"));
				jpDatosSocio.setToolTipText("Datos Socio");
				jpDatosSocio.setLayout(null);
				{
					lblNroSocio = new JLabel();
					jpDatosSocio.add(lblNroSocio);
					lblNroSocio.setText("Número de Socio:");
					lblNroSocio.setBounds(24, 26, 112, 16);
					lblNroSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNroSocio = new JTextField();
					jpDatosSocio.add(txtNroSocio);
					txtNroSocio.setBounds(137, 23, 39, 23);
				}
				{
					lblNomSocio = new JLabel();
					jpDatosSocio.add(lblNomSocio);
					lblNomSocio.setBounds(223, 26, 68, 16);
					lblNomSocio.setText("Nombre: ");
					lblNomSocio.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtNomSocio = new JTextField();
					jpDatosSocio.add(txtNomSocio);
					txtNomSocio.setBounds(280, 23, 217, 23);
				}
				{
					btnBuscar = new JButton();
					jpDatosSocio.add(btnBuscar);
					btnBuscar.setBounds(178, 17, 31, 31);
					btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
					btnBuscar.setActionCommand("BuscarSocio");
				}
			}
			{
				jpDeudas = new JPanel();
				getContentPane().add(jpDeudas);
				jpDeudas.setBounds(12, 129, 504, 174);
				jpDeudas.setBorder(BorderFactory.createTitledBorder("Listado de Deudas del Socio"));
				jpDeudas.setLayout(null);
				{
					spListadoDeudas = new JScrollPane();
					jpDeudas.add(spListadoDeudas);
					spListadoDeudas.setBounds(17, 25, 476, 83);
					{
						TableModel jtLDeudasModel = 
								new DefaultTableModel(
										new String[][] { { "One", "Two" }, { "Three", "Four" } },
										new String[] { "Código", "Descripción", "Monto","Seleccionar" });
						jtLDeudas = new JTable();
						spListadoDeudas.setViewportView(jtLDeudas);
						jtLDeudas.setModel(jtLDeudasModel);
						jtLDeudas.getTableHeader().setVisible(true);
					}
				}
				{
					lblTotal = new JLabel();
					jpDeudas.add(lblTotal);
					lblTotal.setText("Total :");
					lblTotal.setBounds(271, 137, 43, 16);
					lblTotal.setFont(new java.awt.Font("Verdana",0,12));
				}
				{
					txtTotal = new JTextField();
					jpDeudas.add(txtTotal);
					txtTotal.setEditable(false);
					txtTotal.setBounds(332, 134, 106, 23);
				}
			}
			{
				btnCerrar = new JButton();
				getContentPane().add(btnCerrar);
				btnCerrar.setText("Salir");
				btnCerrar.setBounds(204, 315, 92, 28);
				btnCerrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
			}
			pack();
			this.setSize(544, 392);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	public String getTxtNomSocio() {
		return txtNomSocio.getText();
	}

	public void setTxtNomSocio(String NomSocio) {
		txtNomSocio.setText(NomSocio); 
	}

	public String getTxtNroSocio() {
		return txtNroSocio.getText();
	}

	public void setTxtNroSocio(String NroSocio) {
		txtNroSocio.setText(NroSocio);
	}
	
	public String getTxtTotal() {
		return txtTotal.getText();
	}
	
	public void setTxtTotal(String Total) {
		txtTotal.setText(Total);
	}
	

	//LimpiarCampos
		public void limpiarCampos() {
			txtNomSocio.setText("");
			txtNroSocio.setText("");
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
	
	//Agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnCerrar.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		}

}
