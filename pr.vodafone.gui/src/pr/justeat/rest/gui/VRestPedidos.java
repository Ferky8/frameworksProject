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
public class VRestPedidos extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JCheckBox checkEntregado;
	private JLabel labelEmail;
	private JLabel labelDireccion;
	private JLabel labelNombre;
	private JTextField cajaRestaurante;
	private JLabel jLabelRestaurante;
	private JLabel jLabelTipoEntrega;
	private JLabel jLabelFecha;
	private JLabel labelDNI;
	private JTextField cajaPromocion;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel2;
	private JButton botonCerrar;
	private JButton botonGuardar;
	private JButton botonNueva;
	private JButton botonEditar;
	private JButton botonElementos;
	private JTable tablaLineas;
	private JScrollPane jScrollPane1;
	private JLabel jLabelTipoPago;
	private JTextField cajaTipoPago;
	private JTextField cajaTipoEntrega;
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
				VRestPedidos inst = new VRestPedidos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VRestPedidos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gestión de Pedidos");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 116);
				jPanel1.setFont(new java.awt.Font("Dialog",1,10));
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Datos Cliente", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("DNI:");
					jLabel1.setBounds(11, 22, 62, 16);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Nombre:");
					jLabel2.setBounds(11, 44, 62, 16);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("Dirección:");
					jLabel6.setBounds(11, 66, 62, 16);
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("Email:");
					jLabel7.setBounds(11, 89, 62, 16);
				}
				{
					labelDNI = new JLabel();
					jPanel1.add(labelDNI);
					labelDNI.setText("xxxxxxxxxx");
					labelDNI.setBounds(80, 22, 263, 16);
					labelDNI.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelNombre = new JLabel();
					jPanel1.add(labelNombre);
					labelNombre.setText("xxxxxxxxxx");
					labelNombre.setBounds(80, 44, 263, 16);
					labelNombre.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelDireccion = new JLabel();
					jPanel1.add(labelDireccion);
					labelDireccion.setText("xxxxxxxxxx");
					labelDireccion.setBounds(80, 66, 263, 16);
					labelDireccion.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelEmail = new JLabel();
					jPanel1.add(labelEmail);
					labelEmail.setText("xxxxxxxxxx");
					labelEmail.setBounds(80, 89, 263, 16);
					labelEmail.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 140, 360, 145);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Pedidos Realizados", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 84);
					{
						TableModel jTable1Model = 
							new DefaultTableModel(
									new String[] { "Restaurante", "Fecha", "Entregado", "Promoción" }, 2);
						tablaLineas = new JTable();
						jScrollPane1.setViewportView(tablaLineas);
						tablaLineas.setModel(jTable1Model);
					}
				}
				{
					botonElementos = new JButton();
					jPanel2.add(botonElementos);
					botonElementos.setText("Ver Elementos...");
					botonElementos.setBounds(234, 113, 114, 23);
					botonElementos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonFacturas.actionPerformed, event="+evt);
							//TODO add your code for botonFacturas.actionPerformed
							botonVerFacturas();
						}
					});
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Editar");
					botonEditar.setBounds(159, 113, 70, 23);
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
				jPanel3.setBounds(13, 297, 359, 173);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Edición", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabelRestaurante = new JLabel();
					jPanel3.add(jLabelRestaurante);
					jLabelRestaurante.setText("Restaurante:");
					jLabelRestaurante.setBounds(10, 24, 64, 16);
				}
				{
					cajaRestaurante = new JTextField();
					jPanel3.add(cajaRestaurante);
					cajaRestaurante.setBounds(86, 21, 87, 23);
				}
				{
					cajaFecha = new JTextField();
					jPanel3.add(cajaFecha);
					cajaFecha.setBounds(86, 50, 87, 23);
				}
				{
					jLabelFecha = new JLabel();
					jPanel3.add(jLabelFecha);
					jLabelFecha.setText("Fecha:");
					jLabelFecha.setBounds(10, 53, 71, 16);
				}
				{
					jLabelTipoEntrega = new JLabel();
					jPanel3.add(jLabelTipoEntrega);
					jLabelTipoEntrega.setText("Tipo Entrega:");
					jLabelTipoEntrega.setBounds(10, 81, 71, 16);
				}
				{
					cajaTipoEntrega = new JTextField();
					jPanel3.add(cajaTipoEntrega);
					cajaTipoEntrega.setBounds(85, 78, 263, 23);
				}
				{
					cajaTipoPago = new JTextField();
					jPanel3.add(cajaTipoPago);
					cajaTipoPago.setBounds(85, 107, 263, 23);
				}
				{
					jLabelTipoPago = new JLabel();
					jPanel3.add(jLabelTipoPago);
					jLabelTipoPago.setText("Tipo Pago:");
					jLabelTipoPago.setBounds(10, 110, 71, 16);
				}
				{
					botonNueva = new JButton();
					jPanel3.add(botonNueva);
					botonNueva.setText("Nueva");
					botonNueva.setBounds(183, 21, 78, 23);
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
					botonGuardar.setBounds(266, 21, 82, 23);
					botonGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonGuardar.actionPerformed, event="+evt);
							//TODO add your code for botonGuardar.actionPerformed
							botonGuardar();
						}
					});
				}
				{
					jLabel9 = new JLabel();
					jPanel3.add(jLabel9);
					jLabel9.setText("Promoción:");
					jLabel9.setBounds(10, 138, 71, 16);
				}
				{
					cajaPromocion = new JTextField();
					jPanel3.add(cajaPromocion);
					cajaPromocion.setBounds(87, 135, 261, 23);
				}
				{
					checkEntregado = new JCheckBox();
					jPanel3.add(checkEntregado);
					checkEntregado.setText("Entregado");
					checkEntregado.setBounds(197, 51, 69, 20);
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Cerrar");
				botonCerrar.setBounds(295, 476, 78, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonCerrar.actionPerformed, event="+evt);
						//TODO add your code for botonCerrar.actionPerformed
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(400, 544);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void botonEditar(){
		
	}
	private void botonVerFacturas(){
		
	}
	private void botonNueva(){
		
	}
	private void botonGuardar(){
		
	}
	private void botonCerrar(){
		
	}
}
