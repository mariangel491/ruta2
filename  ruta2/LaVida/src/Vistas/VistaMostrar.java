package Vistas;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import Controlador.ControladorInquilino;
import Controlador.ControladorMostrarResultados;
import Modelos.Hibernate.Daos.EgresosDao;
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
public class VistaMostrar extends javax.swing.JFrame {
	private JPanel jPanelMostrar;
	private JList jListResultados;
	private JButton btnSalir;
	private JTextPane jTextPane1;
	private JButton btnAceptar;

	//Mis datos
	IngresosDao daoIng= new IngresosDao();
	EgresosDao daoEg= new EgresosDao();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VistaMostrar inst = new VistaMostrar();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VistaMostrar() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanelMostrar = new JPanel();
				getContentPane().add(jPanelMostrar);
				jPanelMostrar.setBounds(0, 0, 265, 262);
				jPanelMostrar.setLayout(null);
				{
					ListModel jListResultadosModel = 
							new DefaultComboBoxModel(
									new String[] {});
					jListResultados = new JList();
					jPanelMostrar.add(jListResultados);
					jListResultados.setModel(jListResultadosModel);
					jListResultados.setBounds(12, 37, 241, 172);
				}
				{
					btnAceptar = new JButton();
					jPanelMostrar.add(btnAceptar);
					btnAceptar.setText("Aceptar");
					btnAceptar.setBounds(53, 228, 55, 23);
				}
				{
					btnSalir = new JButton();
					jPanelMostrar.add(btnSalir);
					btnSalir.setText("Salir");
					btnSalir.setBounds(144, 228, 51, 23);
				}
			}
			{
				jTextPane1 = new JTextPane();
				getContentPane().add(jTextPane1);
				jTextPane1.setBounds(277, 38, 132, 171);
			}
			pack();
			this.setSize(437, 377);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public void CrearNuevaVentana(int num){
		int ValorDevuelto = JOptionPane.showConfirmDialog(null,
				"¿Desea consultar la lista de ingresos?", "Advertencia", JOptionPane.YES_NO_OPTION);
		if (ValorDevuelto == 0) {
			ControladorMostrarResultados controlador= new ControladorMostrarResultados();	
			if(num==1)
			{
				this.LlenarEgresos();
			}
		}
	}
	public void LlenarIngresos(){
		try {
			DefaultListModel Modelo = new DefaultListModel ();
			for(int i=0; i<daoIng.obtenerTodos().size();i++){
				Modelo.addElement(daoIng.obtenerTodos().get(i).getDescripcion());
			}
			jListResultados.setModel(Modelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LlenarEgresos(){
		try {
			DefaultListModel Modelo = new DefaultListModel ();
			for(int i=0; i<daoEg.obtenerTodos().size();i++){
				Modelo.addElement(daoEg.obtenerTodos().get(i).getDescripcion());
			}
			jListResultados.setModel(Modelo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
