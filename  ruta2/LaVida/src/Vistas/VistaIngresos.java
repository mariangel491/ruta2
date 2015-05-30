package Vistas;
import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Modelos.Hibernate.Daos.IngresosDao;
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
public class VistaIngresos extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanelVentana;
	private JPanel jPanelTitulo;
	private JLabel lblCodIngreso;
	private JLabel lblClasificacion;
	private JComboBox cmbClasificacion;
	private JButton btnSalir;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JTextField txtDescripIngreso;
	private JLabel lblDescripcionIng;
	private JTextField txtCodIngreso;
	private JPanel jPanelIngresos;
	private JLabel lblTitulo;

	private IngresosDao ingDao= new IngresosDao();
	
	
/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaIngresos inst = new VistaIngresos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
private static VistaIngresos vIg=null;
	
	public static VistaIngresos obtenerInstancia(){
		if(vIg==null)
			vIg= new VistaIngresos();
		return vIg;
	}
	
	public VistaIngresos() {
		super();
		initGUI();
		try {
			this.GenerarCodigo();
			this.txtCodIngreso.setEnabled(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelVentana = new JPanel();
				getContentPane().add(jPanelVentana, "Center");
				jPanelVentana.setBounds(0, 0, 384, 262);
				jPanelVentana.setLayout(null);
				{
					jPanelTitulo = new JPanel();
					jPanelVentana.add(jPanelTitulo);
					jPanelTitulo.setBounds(0, 0, 384, 75);
					jPanelTitulo.setLayout(null);
					{
						lblTitulo = new JLabel();
						jPanelTitulo.add(lblTitulo);
						lblTitulo.setText("Registrar Ingresos");
						lblTitulo.setFont(new java.awt.Font("Century Gothic",3,20));
						lblTitulo.setBounds(158, 24, 170, 26);
					}
				}
				{
					jPanelIngresos = new JPanel();
					jPanelVentana.add(jPanelIngresos);
					jPanelIngresos.setBounds(40, 94, 360, 122);
					jPanelIngresos.setBorder(BorderFactory.createTitledBorder("Datos de los Ingresos"));
					jPanelIngresos.setLayout(null);
					{
						lblCodIngreso = new JLabel();
						jPanelIngresos.add(lblCodIngreso);
						lblCodIngreso.setText("Código");
						lblCodIngreso.setBounds(42, 30, 49, 16);
						lblCodIngreso.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						txtCodIngreso = new JTextField();
						jPanelIngresos.add(txtCodIngreso);
						txtCodIngreso.setBounds(97, 27, 86, 23);
					}
					{
						lblDescripcionIng = new JLabel();
						jPanelIngresos.add(lblDescripcionIng);
						lblDescripcionIng.setText("Descripción ");
						lblDescripcionIng.setBounds(23, 58, 74, 16);
						lblDescripcionIng.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						txtDescripIngreso = new JTextField();
						jPanelIngresos.add(txtDescripIngreso);
						txtDescripIngreso.setBounds(97, 55, 205, 23);
					}
					{
						lblClasificacion = new JLabel();
						jPanelIngresos.add(lblClasificacion);
						lblClasificacion.setText("Clasificación");
						lblClasificacion.setBounds(17, 86, 79, 16);
						lblClasificacion.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						ComboBoxModel cmbClasificacionModel = 
								new DefaultComboBoxModel(
										new String[] { "Seleccione una opción", "Ruta" 
												,"Fondo de Choque", "Alquiler" });
						cmbClasificacion = new JComboBox();
						jPanelIngresos.add(cmbClasificacion);
						cmbClasificacion.setModel(cmbClasificacionModel);
						cmbClasificacion.setBounds(96, 83, 206, 23);
						cmbClasificacion.setFont(new java.awt.Font("Verdana",0,11));
					}
				}
				{
					btnGuardar = new JButton();
					jPanelVentana.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(15, 228, 101, 23);
					btnGuardar.setFont(new java.awt.Font("Verdana",0,11));
					btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
					btnGuardar.setActionCommand("Guardar");

				}
				{
					btnModificar = new JButton();
					jPanelVentana.add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(131, 228, 114, 23);
					btnModificar.setFont(new java.awt.Font("Verdana",0,11));
					btnModificar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Lists.gif")));
					btnModificar.setActionCommand("Modificar");
				}
				{
					btnSalir = new JButton();
					jPanelVentana.add(btnSalir);
					btnSalir.setText("Salir");
					btnSalir.setBounds(266, 228, 72, 23);
					btnSalir.setFont(new java.awt.Font("Verdana",0,11));
					btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
					btnSalir.setActionCommand("Salir");
				}
			}
			pack();
			this.setSize(460, 318);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	public String getTxtDescripIngreso() {
		return txtDescripIngreso.getText();
	}

	public void setTxtDescripIngreso(String DescripIngreso) {
		this.txtDescripIngreso.setText(DescripIngreso);
		}

	public String getTxtCodIngreso() {
		return txtCodIngreso.getText();
	}

	public void setTxtCodIngreso(String CodIngreso) {
		this.txtCodIngreso.setText(CodIngreso);
	}
	
	public JComboBox getCmbClasificacion() {
		return cmbClasificacion;
	}

	public void setCmbClasificacion(JComboBox cmbClasificacion) {
		this.cmbClasificacion = cmbClasificacion;
	}

		//agregar listeners
		public void agregarListener(ActionListener accion) {
			this.btnGuardar.addActionListener(accion);
			this.btnModificar.addActionListener(accion);
			this.btnSalir.addActionListener(accion);
			
		}

		//LimpiarCampos
		public void limpiarCampos() {
			//txtCodIngreso.setText("");
			txtDescripIngreso.setText("");
			cmbClasificacion.setSelectedItem("Seleccione una opción");
			try {
				this.GenerarCodigo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		public void GenerarCodigo() throws Exception{
			String cod="";
			int cantIng= ingDao.obtenerTodos().size()+1;
			if(cantIng<10)
			{
				cod=("I000"+cantIng);
				
				this.setTxtCodIngreso(cod);
				
			}else if(cantIng<100)
			{
				cod="I00"+cantIng;
				
				this.setTxtCodIngreso(cod);
			}else if(cantIng<1000)
			{
				cod="I0"+cantIng;
				this.setTxtCodIngreso(cod);
			}else{
				cod="I"+cantIng;
				
				this.setTxtCodIngreso(cod);
				}
			}
		
		
		
}
