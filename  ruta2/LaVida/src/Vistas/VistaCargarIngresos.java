package Vistas;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Modelos.Ingresos;
import Modelos.Hibernate.Daos.IngresosDao;

import com.jgoodies.common.collect.LinkedListModel;


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
public class VistaCargarIngresos extends javax.swing.JFrame {
	private JPanel jPanelVentana;
	private JPanel jPanelTitulo;
	private JPanel jPanelCargarMontos;
	private JLabel lblCodigoIng;
	private JLabel lblNombIngresos;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnGuardar;
	private JLabel lblEtiqBsF;
	private JTextField txtMontoIng;
	private JLabel lblMontoIngreso;
	private JList jListIngresos;
	private JScrollPane jScrollPaneIngresos;
	private JButton btnBuscar;
	private JTextField txtCodIng;
	private JLabel lblTitulo;

	
	//Mis datos
	DefaultListModel mod= new DefaultListModel ();
	LinkedListModel<String> ingresos=new LinkedListModel<>();
	private IngresosDao ingDao= new IngresosDao();
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaCargarIngresos inst = new VistaCargarIngresos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
private static VistaCargarIngresos vCIng=null;
	
	public static VistaCargarIngresos obtenerInstancia(){
		if(vCIng==null)
			vCIng= new VistaCargarIngresos();
		return vCIng;
	}
	
	public VistaCargarIngresos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelVentana = new JPanel();
				getContentPane().add(jPanelVentana);
				jPanelVentana.setBounds(0, 0, 389, 293);
				jPanelVentana.setLayout(null);
				{
					jPanelTitulo = new JPanel();
					jPanelVentana.add(jPanelTitulo);
					jPanelTitulo.setBounds(0, 0, 390, 66);
					jPanelTitulo.setLayout(null);
					{
						lblTitulo = new JLabel();
						jPanelTitulo.add(lblTitulo);
						lblTitulo.setText("Cargar Ingresos");
						lblTitulo.setBounds(167, 26, 151, 28);
						lblTitulo.setFont(new java.awt.Font("Century Gothic",3,18));
					}
				}
				{
					jPanelCargarMontos = new JPanel();
					jPanelVentana.add(jPanelCargarMontos);
					jPanelCargarMontos.setBounds(10, 72, 369, 181);
					jPanelCargarMontos.setBorder(BorderFactory.createTitledBorder("Cargar Montos de Ingresos"));
					jPanelCargarMontos.setLayout(null);
					{
						lblCodigoIng = new JLabel();
						jPanelCargarMontos.add(lblCodigoIng);
						lblCodigoIng.setText("Código");
						lblCodigoIng.setBounds(39, 35, 39, 16);
					}
					{
						txtCodIng = new JTextField();
						jPanelCargarMontos.add(txtCodIng);
						txtCodIng.setBounds(96, 32, 101, 23);
						txtCodIng.setActionCommand("BIngreTecla");
					}
					{
						btnBuscar = new JButton();
						jPanelCargarMontos.add(btnBuscar);
						btnBuscar.setBounds(212, 29, 28, 29);
						btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/search.png")));
						btnBuscar.setActionCommand("Buscar");
					}
					{
						lblNombIngresos = new JLabel();
						jPanelCargarMontos.add(lblNombIngresos);
						lblNombIngresos.setText("Nombre");
						lblNombIngresos.setBounds(39, 69, 44, 16);
					}
					{
						jScrollPaneIngresos = new JScrollPane();
						jPanelCargarMontos.add(jScrollPaneIngresos);
						jScrollPaneIngresos.setBounds(95, 65, 184, 60);
						{
							ListModel jListIngresosModel = 
									new DefaultComboBoxModel(
											new String[] {  });
							jListIngresos = new JList();
							jScrollPaneIngresos.setViewportView(jListIngresos);
							jListIngresos.setModel(jListIngresosModel);
							jListIngresos.addMouseListener(mouseListener);
						}
					}
					{
						lblMontoIngreso = new JLabel();
						jPanelCargarMontos.add(lblMontoIngreso);
						lblMontoIngreso.setText("Monto ");
						lblMontoIngreso.setBounds(39, 140, 39, 16);
					}
					{
						txtMontoIng = new JTextField();
						jPanelCargarMontos.add(txtMontoIng);
						txtMontoIng.setBounds(96, 137, 101, 23);
					}
					{
						lblEtiqBsF = new JLabel();
						jPanelCargarMontos.add(lblEtiqBsF);
						lblEtiqBsF.setText("BsF.");
						lblEtiqBsF.setBounds(203, 140, 37, 16);
					}
				}
				{
					btnGuardar = new JButton();
					jPanelVentana.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(22, 259, 110, 23);
					btnGuardar.setFont(new java.awt.Font("Verdana",0,11));
					btnGuardar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/save.png")));
					btnGuardar.setActionCommand("Guardar");
				}
				{
					btnLimpiar = new JButton();
					jPanelVentana.add(btnLimpiar);
					btnLimpiar.setText("Limpiar");
					btnLimpiar.setBounds(147, 259, 105, 23);
					btnLimpiar.setFont(new java.awt.Font("Verdana",0,11));
					btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Limpiarcodigo_1.png")));
					btnLimpiar.setActionCommand("Limpiar");
				}
				{
					btnSalir = new JButton();
					jPanelVentana.add(btnSalir);
					btnSalir.setText("Salir");
					btnSalir.setBounds(268, 259, 98, 23);
					btnSalir.setFont(new java.awt.Font("Verdana",0,11));
					btnSalir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imagenes/exit.png")));
					btnSalir.setActionCommand("Salir");
				}
			}
			pack();
			this.setSize(405, 331);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public String getTxtMontoIng() {
		return txtMontoIng.getText();
	}

	public void setTxtMontoIng(String MontoIng) {
		txtMontoIng.setText(MontoIng);
	}

	public String getTxtCodIng() {
		return txtCodIng.getText();
	}

	public void setTxtCodIng(String CodIng) {
		txtCodIng.setText(CodIng);
	}

	//agregar listeners
	public void agregarListener(ActionListener accion) {
		this.btnGuardar.addActionListener(accion);
		this.btnBuscar.addActionListener(accion);
		this.btnLimpiar.addActionListener(accion);
		this.btnSalir.addActionListener(accion);
		this.txtCodIng.addActionListener(accion);
	}

	//LimpiarCampos
	public void limpiarCampos() {
		txtCodIng.setText("");
		txtMontoIng.setText("");
		jListIngresos.clearSelection();
		jListIngresos.removeAll();
		LlenarListaIng();
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
	
	//Cargar Ingresos
	public void LlenarListaIng(){
		try {
			for(int i=0; i<ingDao.obtenerTodos().size();i++){
				ingresos.add(i, ingDao.obtenerTodos().get(i).getDescripcion());
			}
			jListIngresos.setModel(ingresos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int itemSeleccionado(){
		return jListIngresos.getSelectedIndex();
	}
	
	public Ingresos ingresoSeleccionado() throws Exception{
		return ingDao.obtenerTodos().get(jListIngresos.getSelectedIndex());
	}
	public void ItemSeleccionado(){
		int nro_seleccionado= jListIngresos.getSelectedIndex();
		txtCodIng.setEnabled(false);
		try {
			Ingresos ing= ingDao.obtenerTodos().get(nro_seleccionado);
			txtCodIng.setText(ing.getCodIngreso());
			if(ing.getMonto()==0)
			{
				txtMontoIng.setText("");
			}else
			{
				String monto= Float.toString(ing.getMonto());
				txtMontoIng.setText(monto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		         
		          }
		        }
		      }
		    };

		    public void agregarKey(KeyListener a) {
				txtMontoIng.addKeyListener(a);
			}
}
