package pr.vodafone.rest.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class VRestFacturas extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel labelDatos;
	private JLabel labelVoz;
	private JLabel labelAntiguedad;
	private JTextField cajaId;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel labelTelefono;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonNueva;
	private JButton botonEditar;
	private JButton botonBorrar;
	private JTable tablaFacturas;
	private JLabel labelActiva;
	private JLabel labelPromocion;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JScrollPane jScrollPane1;
	private JLabel jLabel8;
	private JTextField cajaImporte;
	private JTextField cajaPeriodo;
	private JTextField cajaFecha;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VRestFacturas inst = new VRestFacturas();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VRestFacturas() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gestión de Facturas");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 116);
				jPanel1.setFont(new java.awt.Font("Dialog",1,10));
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos Línea", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Teléfono:");
					jLabel1.setBounds(11, 22, 70, 16);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Antiguedad:");
					jLabel2.setBounds(11, 44, 70, 16);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("Tarifa voz:");
					jLabel6.setBounds(11, 66, 70, 16);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("Tarifa datos:");
					jLabel7.setBounds(11, 89, 79, 16);
				}
				{
					labelTelefono = new JLabel();
					jPanel1.add(labelTelefono);
					labelTelefono.setText("xxxxxxxxxx");
					labelTelefono.setBounds(92, 22, 102, 16);
					labelTelefono.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelAntiguedad = new JLabel();
					jPanel1.add(labelAntiguedad);
					labelAntiguedad.setText("xxxxxxxxxx");
					labelAntiguedad.setBounds(92, 44, 102, 16);
					labelAntiguedad.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelVoz = new JLabel();
					jPanel1.add(labelVoz);
					labelVoz.setText("xxxxxxxxxx");
					labelVoz.setBounds(92, 66, 102, 16);
					labelVoz.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelDatos = new JLabel();
					jPanel1.add(labelDatos);
					labelDatos.setText("xxxxxxxxxx");
					labelDatos.setBounds(92, 89, 102, 16);
					labelDatos.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jLabel10 = new JLabel();
					jPanel1.add(jLabel10);
					jLabel10.setText("Promoción:");
					jLabel10.setBounds(195, 22, 65, 16);
				}
				{
					jLabel11 = new JLabel();
					jPanel1.add(jLabel11);
					jLabel11.setText("Activa:");
					jLabel11.setBounds(195, 44, 65, 16);
				}
				{
					labelPromocion = new JLabel();
					jPanel1.add(labelPromocion);
					labelPromocion.setText("xxxxxxxxxx");
					labelPromocion.setBounds(263, 22, 87, 16);
					labelPromocion.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelActiva = new JLabel();
					jPanel1.add(labelActiva);
					labelActiva.setText("Si");
					labelActiva.setBounds(263, 44, 87, 16);
					labelActiva.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 140, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Facturas Disponibles", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						TableModel jTable1Model = 
							new DefaultTableModel(
									new String[] { "Id", "Fecha", "Periodo", "Importe" }, 2);
						tablaFacturas = new JTable();
						jScrollPane1.setViewportView(tablaFacturas);
						tablaFacturas.setModel(jTable1Model);
					}
				}
				{
					botonBorrar = new JButton();
					jPanel2.add(botonBorrar);
					botonBorrar.setText("Borrar");
					botonBorrar.setBounds(266, 113, 82, 23);
					botonBorrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonBorrar.actionPerformed, event="+evt);
							//TODO add your code for botonBorrar.actionPerformed
							botonBorrar();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Editar");
					botonEditar.setBounds(185, 113, 76, 23);
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
				jPanel3.setBounds(13, 297, 359, 145);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Edición", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel3 = new JLabel();
					jPanel3.add(jLabel3);
					jLabel3.setText("Id:");
					jLabel3.setBounds(10, 24, 64, 16);
				}
				{
					cajaId = new JTextField();
					jPanel3.add(cajaId);
					cajaId.setBounds(86, 21, 83, 23);
				}
				{
					cajaFecha = new JTextField();
					jPanel3.add(cajaFecha);
					cajaFecha.setBounds(86, 50, 262, 23);
				}
				{
					jLabel5 = new JLabel();
					jPanel3.add(jLabel5);
					jLabel5.setText("Fecha:");
					jLabel5.setBounds(10, 53, 71, 16);
				}
				{
					jLabel4 = new JLabel();
					jPanel3.add(jLabel4);
					jLabel4.setText("Periodo:");
					jLabel4.setBounds(10, 81, 57, 16);
				}
				{
					cajaPeriodo = new JTextField();
					jPanel3.add(cajaPeriodo);
					cajaPeriodo.setBounds(86, 78, 262, 23);
				}
				{
					cajaImporte = new JTextField();
					jPanel3.add(cajaImporte);
					cajaImporte.setBounds(86, 107, 262, 23);
				}
				{
					jLabel8 = new JLabel();
					jPanel3.add(jLabel8);
					jLabel8.setText("Importe:");
					jLabel8.setBounds(10, 110, 71, 16);
				}
				{
					botonNueva = new JButton();
					jPanel3.add(botonNueva);
					botonNueva.setText("Nueva");
					botonNueva.setBounds(181, 21, 78, 23);
					botonNueva.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonNueva.actionPerformed, event="+evt);
							//TODO add your code for botonNueva.actionPerformed
							botonNueva();
						}
					});
				}
				{
					botonGuardar = new JButton();
					jPanel3.add(botonGuardar);
					botonGuardar.setText("Guardar");
					botonGuardar.setBounds(264, 21, 84, 23);
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
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Cerrar");
				botonCerrar.setBounds(294, 450, 79, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonCerrar.actionPerformed, event="+evt);
						//TODO add your code for botonCerrar.actionPerformed
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(400, 521);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void botonEditar(){
		
	}
	private void botonBorrar(){
		
	}
	private void botonNueva(){
		
	}
	private void botonGuardar(){
		
	}
	private void botonCerrar(){
		
	}
}
