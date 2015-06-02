package Vistas;
import com.jgoodies.common.collect.LinkedListModel;
import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Modelos.Ingresos;
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
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JTextField txtDescripIngreso;
	private JLabel lblDescripcionIng;
	private JTextField txtCodIngreso;
	private JPanel jPanelIngresos;
	private JLabel lblTitulo;
	private JList jListBusqueda;
	private JScrollPane jScrollPanelLista;
	private JPanel jPanelLista;
	private JButton btnBuscar;
	private JLabel lblLogo;

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
				jPanelVentana.setBounds(0, 0, 478, 311);
				jPanelVentana.setLayout(null);
				{
					jPanelTitulo = new JPanel();
					jPanelVentana.add(jPanelTitulo);
					jPanelTitulo.setBounds(0, 0, 479, 77);
					jPanelTitulo.setLayout(null);
					jPanelTitulo.setBackground(new java.awt.Color(255,255,255));
					{
						lblTitulo = new JLabel();
						jPanelTitulo.add(lblTitulo);
						jPanelTitulo.add(getLblLogo());
						lblTitulo.setText("Registrar Ingresos");
						lblTitulo.setFont(new java.awt.Font("Century Gothic",2,20));
						lblTitulo.setBounds(174, 29, 170, 26);
					}
				}
				{
					jPanelIngresos = new JPanel();
					jPanelVentana.add(jPanelIngresos);
					jPanelIngresos.setBounds(63, 110, 348, 128);
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
						lblDescripcionIng.setBounds(23, 64, 74, 16);
						lblDescripcionIng.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						txtDescripIngreso = new JTextField();
						jPanelIngresos.add(txtDescripIngreso);
						txtDescripIngreso.setBounds(97, 61, 205, 23);
					}
					{
						lblClasificacion = new JLabel();
						jPanelIngresos.add(lblClasificacion);
						lblClasificacion.setText("Clasificación");
						lblClasificacion.setBounds(17, 94, 79, 16);
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
						cmbClasificacion.setBounds(96, 91, 206, 23);
						cmbClasificacion.setFont(new java.awt.Font("Verdana",0,11));
					}
					{
						btnBuscar = new JButton();
						jPanelIngresos.add(btnBuscar);
						btnBuscar.setBounds(189, 27, 33, 23);
						btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
						btnBuscar.setActionCommand("Buscar");
					}
				}
				{
					btnGuardar = new JButton();
					jPanelVentana.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(21, 268, 121, 29);
					btnGuardar.setFont(new java.awt.Font("Verdana",0,11));
					btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
					btnGuardar.setActionCommand("Guardar");

				}
				{
					btnLimpiar = new JButton();
					jPanelVentana.add(btnLimpiar);
					btnLimpiar.setText("Limpiar");
					btnLimpiar.setBounds(177, 268, 121, 29);
					btnLimpiar.setFont(new java.awt.Font("Verdana",0,11));
					btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
					btnLimpiar.setActionCommand("Limpiar");
				}
				{
					btnSalir = new JButton();
					jPanelVentana.add(btnSalir);
					jPanelVentana.add(getJPanelLista());
					btnSalir.setText("Salir");
					btnSalir.setBounds(333, 268, 121, 29);
					btnSalir.setFont(new java.awt.Font("Verdana",0,11));
					btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
					btnSalir.setActionCommand("Salir");
				}
			}
			pack();
			this.setSize(494, 350);
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
			this.btnLimpiar.addActionListener(accion);
			this.btnSalir.addActionListener(accion);
			this.btnBuscar.addActionListener(accion);
			
		}

		//LimpiarCampos
		public void limpiarCampos() {
			txtCodIngreso.setText("");
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
		
		private JLabel getLblLogo() {
			if(lblLogo == null) {
				lblLogo = new JLabel();
				lblLogo.setBounds(5, 9, 157, 65);
				lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/LogoRuta2.jpg")));
			}
			return lblLogo;
		}
		
		
		private JPanel getJPanelLista() {
			if(jPanelLista == null) {
				jPanelLista = new JPanel();
				//jPanelLista.setLayout(jPanelListaLayout);
				jPanelLista.setBounds(18, 89, 439, 171);
				jPanelLista.setBorder(BorderFactory.createTitledBorder("Listado de Ingresos"));
				jPanelLista.add(getJScrollPanelLista());
			}
			return jPanelLista;
		}
		
		private JScrollPane getJScrollPanelLista() {
			if(jScrollPanelLista == null) {
				jScrollPanelLista = new JScrollPane();
				jScrollPanelLista.setPreferredSize(new java.awt.Dimension(403, 133));
				jScrollPanelLista.setViewportView(getJListBusqueda());
			}
			return jScrollPanelLista;
		}
		
		private JList getJListBusqueda() {
			if(jListBusqueda == null) {
				ListModel jListBusquedaModel = 
						new DefaultComboBoxModel(
								new String[] {  });
				jListBusqueda = new JList();
				jListBusqueda.setModel(jListBusquedaModel);
				jListBusqueda.setPreferredSize(new java.awt.Dimension(385, 508));
				jListBusqueda.addMouseListener(mouseListener);
			}
			return jListBusqueda;
		}
		
		
		//EVENTO
				MouseListener mouseListener = new MouseAdapter() {
				      public void mouseClicked(MouseEvent mouseEvent) {
				        JList theList = (JList) mouseEvent.getSource();
				        if (mouseEvent.getClickCount() == 2) {
				          int index = theList.locationToIndex(mouseEvent.getPoint());
				          if (index >= 0) {
				            Object o = theList.getModel().getElementAt(index);
				            ItemSeleccionado();
				            ActivarComponentes();
				          }
				        }
				      }
				    };
				    
				    
				    public void DesactivarComponentes(){
						this.jPanelIngresos.setVisible(false);
						this.jListBusqueda.setVisible(true);
						this.jPanelLista.setVisible(true);
					}
					
					public void ActivarComponentes(){
						this.jPanelIngresos.setVisible(true);
						this.jPanelLista.setVisible(false);
						this.jListBusqueda.setVisible(false);
						this.btnGuardar.setEnabled(true);
					}
					
					
					public void llenarLista(){
						this.DesactivarComponentes();
						this.btnGuardar.setEnabled(false);
						LinkedListModel<String> ingresos=new LinkedListModel<>();
						try {
							for(int i=0; i<ingDao.obtenerTodos().size();i++){
								if(ingDao.obtenerTodos().get(i).getClasifIngreso().equalsIgnoreCase(this.getCmbClasificacion().getSelectedItem().toString())==true)
									ingresos.add(ingDao.obtenerTodos().get(i).getDescripcion());
								else
									if(this.getCmbClasificacion().getSelectedItem().toString().equals("Seleccione una opción")) 
									ingresos.add(ingDao.obtenerTodos().get(i).getDescripcion());
							}
							jListBusqueda.setModel(ingresos);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}


				public void ItemSeleccionado(){
					try {
							
							Ingresos ingreso= ingDao.obtenerTodos().get(jListBusqueda.getSelectedIndex());
						
							this.txtDescripIngreso.setText(ingreso.getDescripcion());
							this.txtCodIngreso.setText(ingreso.getCodIngreso());
							this.cmbClasificacion.setSelectedItem(ingreso.getClasifIngreso());
							this.btnGuardar.setEnabled(true);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				public int ItemSelec(){
					int selection;
					return selection=jListBusqueda.getSelectedIndex();
				}

}
