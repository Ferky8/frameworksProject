package pr.justeat.rest.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
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
public class VRestClientes extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton botonBuscar;
	private JTextField cajaDni;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton botonSalir;
	private JButton botonGuardar;
	private JButton botonNuevo;
	private JButton botonEditar;
	private JButton botonPedidos;
	private JTable tablaClientes;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JTextField cajaEmail;
	private JTextField cajaDireccion;
	private JTextField cajaNombre;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JButton botonTodos;
	private JTextField cajaDniBuscar;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VRestClientes inst = new VRestClientes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VRestClientes() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gestión de Clientes");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 56);
				jPanel1.setFont(new java.awt.Font("Dialog",0,8));
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Búsqueda", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("DNI:");
					jLabel1.setBounds(11, 22, 23, 16);
				}
				{
					cajaDniBuscar = new JTextField();
					jPanel1.add(cajaDniBuscar);
					cajaDniBuscar.setBounds(46, 19, 141, 23);
				}
				{
					botonBuscar = new JButton();
					jPanel1.add(botonBuscar);
					botonBuscar.setText("Buscar");
					botonBuscar.setBounds(193, 19, 82, 23);
					botonBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonBuscar.actionPerformed, event="+evt);
							//TODO add your code for botonBuscar.actionPerformed
							botonBuscar();
						}
					});
				}
				{
					botonTodos = new JButton();
					jPanel1.add(botonTodos);
					botonTodos.setText("Todos");
					botonTodos.setBounds(280, 19, 70, 23);
					botonTodos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonTodos.actionPerformed, event="+evt);
							//TODO add your code for botonTodos.actionPerformed
							botonTodos();
						}
					});
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 78, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						TableModel jTable1Model = 
							new DefaultTableModel(
									new String[] { "DNI", "Nombre", "Dirección", "Email" }, 2);
						tablaClientes = new JTable();
						jScrollPane1.setViewportView(tablaClientes);
						tablaClientes.setModel(jTable1Model);
					}
				}
				{
					botonPedidos = new JButton();
					jPanel2.add(botonPedidos);
					botonPedidos.setText("Pedidos...");
					botonPedidos.setBounds(250, 113, 98, 23);
					botonPedidos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonLineas.actionPerformed, event="+evt);
							//TODO add your code for botonLineas.actionPerformed
							botonVerLineas();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Editar");
					botonEditar.setBounds(175, 113, 70, 23);
					botonEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonEditar.actionPerformed, event="+evt);
							//TODO add your code for botonEditar.actionPerformed
							botonEditar();
						}
					});
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setFont(new java.awt.Font("Dialog",0,8));
				jPanel3.setBounds(13, 235, 359, 143);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Edición", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel3 = new JLabel();
					jPanel3.add(jLabel3);
					jLabel3.setText("DNI:");
					jLabel3.setBounds(10, 24, 23, 16);
				}
				{
					cajaDni = new JTextField();
					jPanel3.add(cajaDni);
					cajaDni.setBounds(74, 21, 95, 23);
				}
				{
					cajaNombre = new JTextField();
					jPanel3.add(cajaNombre);
					cajaNombre.setBounds(74, 50, 274, 23);
				}
				{
					jLabel5 = new JLabel();
					jPanel3.add(jLabel5);
					jLabel5.setText("Nombre:");
					jLabel5.setBounds(10, 53, 57, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel3.add(jLabel4);
					jLabel4.setText("Dirección:");
					jLabel4.setBounds(10, 81, 57, 16);
				}
				{
					cajaDireccion = new JTextField();
					jPanel3.add(cajaDireccion);
					cajaDireccion.setBounds(74, 78, 274, 23);
				}
				{
					cajaEmail = new JTextField();
					jPanel3.add(cajaEmail);
					cajaEmail.setBounds(74, 107, 274, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Email:");
					jLabel8.setBounds(10, 110, 37, 16);
				}
				{
					botonNuevo = new JButton();
					jPanel3.add(botonNuevo);
					botonNuevo.setText("Nuevo");
					botonNuevo.setBounds(181, 21, 73, 23);
					botonNuevo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonNuevo.actionPerformed, event="+evt);
							//TODO add your code for botonNuevo.actionPerformed
							botonNuevo();
						}
					});
				}
				{
					botonGuardar = new JButton();
					jPanel3.add(botonGuardar);
					botonGuardar.setText("Guardar");
					botonGuardar.setBounds(259, 21, 89, 23);
					botonGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonGuardar.actionPerformed, event="+evt);
							//TODO add your code for botonGuardar.actionPerformed
							botonGuardar();
						}
					});
				}
			}
			{
				botonSalir = new JButton();
				getContentPane().add(botonSalir);
				botonSalir.setText("Salir");
				botonSalir.setBounds(297, 384, 75, 23);
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonSalir.actionPerformed, event="+evt);
						//TODO add your code for botonSalir.actionPerformed
						botonSalir();
					}
				});
			}
			pack();
			this.setSize(400, 452);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void botonBuscar(){
		
	}
	private void botonTodos(){
		
	}
	private void botonEditar(){
		
	}
	private void botonVerLineas(){
		
	}
	private void botonNuevo(){
		
	}
	private void botonGuardar(){
		
	}
	private void botonSalir(){
		System.exit(0);
	}
}
