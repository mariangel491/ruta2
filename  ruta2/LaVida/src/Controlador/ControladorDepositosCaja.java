package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Modelos.Hibernate.Daos.CajaDao;
import Vistas.VistaCaja;
import Modelos.Avance;
import Modelos.Caja;

public class ControladorDepositosCaja implements KeyListener, ActionListener {

	private VistaCaja vcaja= new VistaCaja();
	private CajaDao daocaja = new CajaDao();
	private Caja caja= new Caja();

	//mis datos
	private List<Caja> listMovCaja= new ArrayList<>();
	private List<Caja> listMovADepositar= new ArrayList<>();
	
	
	public ControladorDepositosCaja() {
		super();
		vcaja.obtenerInstancia();
		vcaja.setLocationRelativeTo(null);
		vcaja.setVisible(true);
		vcaja.agregarKey(this);
		vcaja.agregarListener(this);
		try {
			this.obtenerDepositos();
			this.cargarListadoCaja();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equalsIgnoreCase("AgregarUno")) {
			try {
				AgregarUnElementoADep();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (ae.getActionCommand().equalsIgnoreCase("AgregarTodos")) {
			cargarAgregarTodosListadoDeposito();
			
		}else if (ae.getActionCommand().equalsIgnoreCase("QuitarUno")) {
			try {
				QuitarUnElementoDep();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (ae.getActionCommand().equalsIgnoreCase("QuitarTodos")) {
			cargarAgregarTodosListadoCaja();
		}else if (ae.getActionCommand().equalsIgnoreCase("Depositar")) {
			try {
				DepositarEfectivo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (ae.getActionCommand().equalsIgnoreCase("Cancelar")) {
			vcaja.cerrarVentana();
		}
		
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!Character.isDigit(e.getKeyChar()))
			e.consume();
	}
	
	//LLENAR LA LISTA DE CAJA TODOS LOS REGISTROS ND
	public List<Caja> obtenerDepositos() throws Exception{
		for(int i=0;i<daocaja.obtenerTodos().size();i++)
		{
			if(daocaja.obtenerTodos().get(i).getStatus().equalsIgnoreCase("ND")){
				listMovCaja.add(daocaja.obtenerTodos().get(i));
			}
		}
		return listMovCaja;
	}
	
	//Cargar el listado de la caja
	protected void cargarListadoCaja() throws Exception {		
		String descripcion, monto, tipo;
		
		if(listMovCaja.size()>0)
		{
			vcaja.limpiarTablaCaja();
			for(int i=0;i<listMovCaja.size();i++)
			{
				descripcion=listMovCaja.get(i).getFactura().getNroFactura();
				monto= String.valueOf(listMovCaja.get(i).getMontoTransaccion());
				//tipo= listMovCaja.get(i).getFactura().
				
				vcaja.agregarFilaCaja(descripcion, monto /*tipo*/);
				SumarCaja();
			}	
		}
		if(listMovCaja.size()==0)
		{
			JOptionPane.showMessageDialog(null,"No existen montos disponible para realizar un deposito","Atencion!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Totalizar los montos de las listas
	public void SumarCaja(){
		if(vcaja.getjTableCaja().getRowCount()>0)
		{
			float suma = 0;
			for(int i=0; i<vcaja.getjTableCaja().getRowCount();i++)
			{
				suma=suma+ Float.parseFloat((String) vcaja.getjTableCaja().getValueAt(i, 1));
			}
			vcaja.setTxtMontoCaja(String.valueOf(suma));
		}else
			vcaja.setTxtMontoCaja("");
	}
	
	//Totalizar la suma de la tabla
	public void SumarDeposito(){
		if(vcaja.getjTableDeposito().getRowCount()>0)
		{
			float suma = 0;
			for(int i=0; i<vcaja.getjTableDeposito().getRowCount();i++)
			{
				suma=suma+ Float.parseFloat((String) vcaja.getjTableDeposito().getValueAt(i, 1));
			}
			vcaja.setTxtMontoADepositar(String.valueOf(suma));
		}else
			vcaja.setTxtMontoADepositar("");
	}
	
	//Cargar listado a depositar
	protected void cargarListadoDepositar() throws Exception {		
		String descripcion, monto;
		if(listMovADepositar.size()>0)
		{
			vcaja.limpiarTablaDeposito();
			for(int i=0;i<listMovADepositar.size();i++)
			{
				descripcion=listMovADepositar.get(i).getFactura().getNroFactura();
				monto= String.valueOf(listMovADepositar.get(i).getMontoTransaccion());
				vcaja.agregarFilaDeposito(descripcion, monto);
			}	
		}
		if(listMovADepositar.size()==0)
			vcaja.limpiarTablaDeposito();
	}
	//Pasar tooodo lo que esta en caja, a la tabla de deposito
		public void cargarAgregarTodosListadoDeposito(){
			if(vcaja.getjTableCaja().getRowCount()>0)
			{
				listMovADepositar.addAll(listMovCaja);
				try {
					cargarListadoDepositar();
					listMovCaja.removeAll(listMovCaja);
					SumarDeposito();
					vcaja.limpiarTablaCaja();
					vcaja.setTxtMontoCaja("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	//Pasar tooodo lo que esta en depo, a la tabla de caja
		public void cargarAgregarTodosListadoCaja(){
			if(vcaja.getjTableDeposito().getRowCount()>0)
			{
				
				listMovCaja.addAll(listMovADepositar);
				try {
					cargarListadoCaja();
					listMovADepositar.removeAll(listMovADepositar);
					SumarCaja();
					vcaja.limpiarTablaDeposito();
					vcaja.setTxtMontoADepositar("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//Depositar el efectivo de la caja a las cuentas (OJOOOOO FUNCIONARA COMO UN MOIFICAR) HAY Q VER LUEGO)..
		public void DepositarEfectivo() throws Exception{
			if(vcaja.getjTableDeposito().getRowCount()>0)
			{
				for(int i=0; i<listMovADepositar.size();i++)
				{
					Caja caja= new Caja();
					caja=listMovADepositar.get(i);
					caja.setStatus("D");
					daocaja.actualizarTransaccion(caja);
					vcaja.limpiarTablaDeposito();
				}
			}
		}
		
		public void AgregarUnElementoADep() throws Exception{
			//vcaja.getjTableCaja().clearSelection();
			vcaja.getjTableDeposito().clearSelection();
			if(vcaja.getjTableCaja().getRowCount()>0)
			{
				listMovADepositar.add(listMovCaja.get(vcaja.getjTableCaja().getSelectedRow()));
				listMovCaja.remove(vcaja.getjTableCaja().getSelectedRow());
				this.cargarListadoCaja();
				this.cargarListadoDepositar();
				
				vcaja.getjTableCaja().clearSelection();
				vcaja.getjTableDeposito().clearSelection();
				
			}
		}
		
		public void QuitarUnElementoDep() throws Exception{
			
			vcaja.getjTableCaja().clearSelection();
			//vcaja.getjTableDeposito().clearSelection();
			if(vcaja.getjTableDeposito().getRowCount()>0)
			{
				if(vcaja.getjTableDeposito().getSelectedRow()!=-1)
				{
					listMovCaja.add(listMovADepositar.get(vcaja.getjTableDeposito().getSelectedRow()));
					this.cargarListadoCaja();
					listMovADepositar.remove(vcaja.getjTableDeposito().getSelectedRow());
					this.cargarListadoDepositar();
					
					vcaja.getjTableDeposito().clearSelection();
					vcaja.getjTableCaja().clearSelection();
					
				}
			}
		}
			
}
