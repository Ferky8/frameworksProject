package pr.justeat.rest.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.List;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import pr.justeat.rest.entity.Cliente;
import pr.justeat.rest.entity.Elemento;
import pr.justeat.rest.entity.Pedido;

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

	private static final long serialVersionUID = 1L;
	
	private JPanel jPanel1;
	private JLabel labelTipoPago;
	private JLabel labelTipoEntrega;
	private JLabel labelFecha;
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
	private JTable tablaElementos;
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
	private WebResource service;
	private Pedido p;
	private List<Elemento> elementos;
	private Elemento se;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VRestElementos inst = new VRestElementos(null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VRestElementos(Pedido p) {
		super();
		this.p = p;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
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
					labelRestaurante.setText(p != null ? p.getRestaurante() : "xxxxxxxxxx");
					labelRestaurante.setBounds(92, 22, 102, 16);
					labelRestaurante.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelFecha = new JLabel();
					jPanel1.add(labelFecha);
					labelFecha.setText(p != null ? p.getFecha() : "xxxxxxxxxx");
					labelFecha.setBounds(92, 44, 102, 16);
					labelFecha.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelTipoEntrega = new JLabel();
					jPanel1.add(labelTipoEntrega);
					labelTipoEntrega.setText(p != null ? p.getTipoEntrega() : "xxxxxxxxxx");
					labelTipoEntrega.setBounds(92, 66, 102, 16);
					labelTipoEntrega.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelTipoPago = new JLabel();
					jPanel1.add(labelTipoPago);
					labelTipoPago.setText(p != null ? p.getTipoPago() : "xxxxxxxxxx");
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
					labelPromocion.setText(p != null ? p.getPromocion() : "xxxxxxxxxx");
					labelPromocion.setBounds(263, 22, 87, 16);
					labelPromocion.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					labelActiva = new JLabel();
					jPanel1.add(labelActiva);
					labelActiva.setText(p != null ? (p.isEntregado() ? "Si" : "No") : "xxxxxxxxxx");
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
						
						tablaElementos = new JTable();
						jScrollPane1.setViewportView(tablaElementos);
						cargarTablaElementos();
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
	
	private void cargarTablaElementos() {
		elementos = null;
		ClientResponse cr = service.path("rest").path("pedidos").path(Integer.toString(p.getIdPedido())).path("elementos").accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		if (cr.getStatus() == 200){
			System.out.println("elementos.GET('application/json').status: " + cr.getStatus());
			System.out.println("elementos.GET('application/json').results (con una LIST): ");
			elementos = cr.getEntity(new GenericType<List<Elemento>>(){}); 		
		}else{
			System.out.println("elementos.GET('application/json').status: " + cr.getStatus());
			System.out.println("elementos.GET('application/json').entity: " + cr.getEntity(String.class));
		}
		
		DefaultTableModel jTable1Model = 
        		new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				//All cells can`t be edited
				return false;
			}
		};
		
		jTable1Model.addColumn("Id");
		jTable1Model.addColumn("Nombre");
		jTable1Model.addColumn("Cantidad");
		jTable1Model.addColumn("Importe"); 
        
        for(Elemento e : elementos) {
        	Object[] fila = new Object[4];
        	fila[0] = e.getIdElemento();
        	fila[1] = e.getNombre();
        	fila[2] = e.getCantidad();
        	fila[3] = e.getImporte();
        	jTable1Model.addRow(fila);
        }
        
        tablaElementos.setModel(jTable1Model);
	}
	
	private void botonEditar(){
		int elementoRow = tablaElementos.getSelectedRow();
		
		se = elementos.get(elementoRow);
		cajaNombre.setText(se.getNombre());
		cajaCantidad.setText(Integer.toString(se.getCantidad()));
		cajaImporte.setText(Float.toString(se.getImporte()));
	}
	private void botonBorrar(){
		int elementoRow = tablaElementos.getSelectedRow();
		if(elementoRow >= 0) {
			se = elementos.get(elementoRow);
			
			try{
				service.path("rest").path("elementos").path(Integer.toString(se.getIdElemento())).delete();
				System.out.println("Elemento " + Integer.toString(se.getIdElemento()) + " deleted");
			}catch(UniformInterfaceException e){
				ClientResponse r = e.getResponse();
				System.out.println("elementos.{id}.DEL.status: " + r.getStatus());
				System.out.println("elementos.{id}.DEL.entity: " + r.getEntity(String.class));
			}	
			
			cargarTablaElementos();
		}
	}
	private void botonNueva(){
		cajaNombre.setText("");
		cajaCantidad.setText("");
		cajaImporte.setText("");
	}
	private void botonGuardar(){
		Elemento e = new Elemento();
		e.setNombre(cajaNombre.getText());
		e.setCantidad(Integer.parseInt(cajaCantidad.getText()));
		e.setImporte(Float.parseFloat(cajaImporte.getText()));
		e.setPedido(p.getIdPedido());
		
		
		ClientResponse cr = service.path("rest").path("elementos").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, e);
		if (cr.getStatus() == 201){ // Return code should be 201 == created resource
			System.out.println("elementos.POST('application/xml').status: " + cr.getStatus());
			System.out.println("elementos.POST('application/xml').location: " + cr.getLocation());
			
		}else{ // Or code 409 == resource already exists 
			System.out.println("elementos.POST('application/xml').status: " + cr.getStatus());
			System.out.println("elementos.POST('application/xml').entity: " + cr.getEntity(String.class));
			ClientResponse cr2 = service.path("rest").path("elementos").path(Integer.toString(e.getIdElemento())).type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, e);
			if (cr2.getStatus() == 201){
				System.out.println("elementos.{id}.PUT('application/xml').status: " + cr2.getStatus());
				System.out.println("elementos.{id}.PUT('application/xml').location: " + cr2.getLocation());
			}else if (cr2.getStatus() == 204){
					System.out.println("elementos.{id}.PUT('application/xml').status: " + cr2.getStatus());
			}else{
				System.out.println("elementos.{id}.PUT('application/xml').status: " + cr2.getStatus());
				System.out.println("elementos.{id}.PUT('application/xml').entity: " + cr2.getEntity(String.class));
			}
		}
		cargarTablaElementos();
	}
	private void botonCerrar(){
		this.dispose();
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/mdiss.justeat.dao").build();
	}
}
