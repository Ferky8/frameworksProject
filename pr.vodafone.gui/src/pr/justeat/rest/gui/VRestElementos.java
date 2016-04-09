package pr.justeat.rest.gui;
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
public class VRestElementos extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel labelTipoPago;
	private JLabel labelTipoEntrega;
	private JLabel labelFecha;
	private JTextField cajaId;
	private JLabel jLabel3;
	private JLabel jLabelNombre;
	private JLabel jLabelCantidad;
	private JLabel labelRestaurante;
	private JLabel jLabelTipoPago;
	private JLabel jLabelTipoEntrega;
	private JLabel jLabelFecha;
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonNueva;
	private JButton botonEditar;
	private JButton botonBorrar;
	private JTable tablaFacturas;
	private JLabel labelActiva;
	private JLabel labelPromocion;
	private JLabel jLabelEntregado;
	private JLabel jLabel10;
	private JScrollPane jScrollPane1;
	private JLabel jLabelImporte;
	private JTextField cajaImporte;
	private JTextField cajaNombre;
	private JTextField cajaCantidad;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabelRestaurante;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VRestElementos inst = new VRestElementos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VRestElementos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gesti\u00F3n de Elementos");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 116);
				jPanel1.setFont(new java.awt.Font("Dialog",1,10));
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos Pedido", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabelRestaurante = new JLabel();
					jPanel1.add(jLabelRestaurante);
					jLabelRestaurante.setText("Restaurante:");
					jLabelRestaurante.setBounds(11, 22, 70, 16);
				}
				{
					jLabelFecha = new JLabel();
					jPanel1.add(jLabelFecha);
					jLabelFecha.setText("Fecha:");
					jLabelFecha.setBounds(11, 44, 70, 16);
				}
				{
					jLabelTipoEntrega = new JLabel();
					jPanel1.add(jLabelTipoEntrega);
					jLabelTipoEntrega.setText("Tipo entrega:");
					jLabelTipoEntrega.setBounds(11, 66, 70, 16);
				}
				{
					jLabelTipoPago = new JLabel();
					jPanel1.add(jLabelTipoPago);
					jLabelTipoPago.setText("Tipo pago:");
					jLabelTipoPago.setBounds(11, 89, 79, 16);
				}
				{
					labelRestaurante = new JLabel();
					jPanel1.add(labelRestaurante);
					labelRestaurante.setText("xxxxxxxxxx");
					labelRestaurante.setBounds(92, 22, 102, 16);
					labelRestaurante.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelFecha = new JLabel();
					jPanel1.add(labelFecha);
					labelFecha.setText("xxxxxxxxxx");
					labelFecha.setBounds(92, 44, 102, 16);
					labelFecha.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelTipoEntrega = new JLabel();
					jPanel1.add(labelTipoEntrega);
					labelTipoEntrega.setText("xxxxxxxxxx");
					labelTipoEntrega.setBounds(92, 66, 102, 16);
					labelTipoEntrega.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelTipoPago = new JLabel();
					jPanel1.add(labelTipoPago);
					labelTipoPago.setText("xxxxxxxxxx");
					labelTipoPago.setBounds(92, 89, 102, 16);
					labelTipoPago.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jLabel10 = new JLabel();
					jPanel1.add(jLabel10);
					jLabel10.setText("Promoción:");
					jLabel10.setBounds(195, 22, 65, 16);
				}
				{
					jLabelEntregado = new JLabel();
					jPanel1.add(jLabelEntregado);
					jLabelEntregado.setText("Entregado:");
					jLabelEntregado.setBounds(195, 44, 65, 16);
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
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Elementos del Pedido", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
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
					cajaCantidad = new JTextField();
					jPanel3.add(cajaCantidad);
					cajaCantidad.setBounds(86, 50, 262, 23);
				}
				{
					jLabelCantidad = new JLabel();
					jPanel3.add(jLabelCantidad);
					jLabelCantidad.setText("Cantidad:");
					jLabelCantidad.setBounds(10, 53, 71, 16);
				}
				{
					jLabelNombre = new JLabel();
					jPanel3.add(jLabelNombre);
					jLabelNombre.setText("Nombre:");
					jLabelNombre.setBounds(10, 81, 57, 16);
				}
				{
					cajaNombre = new JTextField();
					jPanel3.add(cajaNombre);
					cajaNombre.setBounds(86, 78, 262, 23);
				}
				{
					cajaImporte = new JTextField();
					jPanel3.add(cajaImporte);
					cajaImporte.setBounds(86, 107, 262, 23);
				}
				{
					jLabelImporte = new JLabel();
					jPanel3.add(jLabelImporte);
					jLabelImporte.setText("Importe:");
					jLabelImporte.setBounds(10, 110, 71, 16);
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
