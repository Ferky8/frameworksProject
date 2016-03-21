package pr.justeat.sw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pr.justeat.dao.InsertarRestaurante;
import pr.justeat.dao.JusteatSWStub;
import pr.justeat.dao.dto.xsd.Restaurante;

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
public class VSWRestaurantes extends javax.swing.JFrame {
	private JTextField cajaId;
	private JLabel jLabelId;
	private JLabel jLabelTipoComida;
	private JLabel jLabelNombre;
	private JButton botonCargar;
	private JTextField cajaOfertaActual;
	private JLabel jLabelOfertaActual;
	private JTextField cajaTiempoMedio;
	private JTextField cajaPrecioMedio;
	private JLabel jLabelTiempoMedio;
	private JLabel jLabelPrecioMedio;
	private JButton botonCerrar;
	private JButton botonEnviar;
	private JButton botonEditar;
	private JTable tablaRestaurantes;
	private JScrollPane jScrollPane1;
	private JLabel jLabelPuntuacion;
	private JTextField cajaPuntuacion;
	private JTextField cajaTipoComida;
	private JTextField cajaNombre;
	private JPanel jPanel3;
	private JPanel jPanel2;
	
	private RestauranteList restaurantes;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VSWRestaurantes inst = new VSWRestaurantes();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VSWRestaurantes() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gestión de Alta de Restaurantes");
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setFont(new java.awt.Font("Dialog",0,8));
				jPanel2.setBounds(13, 12, 360, 214);
				jPanel2.setLayout(null);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Restaurantes Recibidos", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));				
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(12, 24, 336, 152);
					{
						TableModel jTable1Model = 
							new DefaultTableModel(
									new String[] { "Id", "Nombre", "Tipo comida", "Puntuacion" }, 6);
						tablaRestaurantes = new JTable();
						jScrollPane1.setViewportView(tablaRestaurantes);
						tablaRestaurantes.setModel(jTable1Model);
					}
				}
				{
					botonEditar = new JButton();
					jPanel2.add(botonEditar);
					botonEditar.setText("Editar");
					botonEditar.setBounds(272, 182, 76, 23);
					botonEditar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonEditar.actionPerformed, event="+evt);
							//TODO add your code for botonEditar.actionPerformed
							botonEditar();
						}
					});
				}
				{
					botonCargar = new JButton();
					jPanel2.add(botonCargar);
					botonCargar.setText("Cargar Restaurantes...");
					botonCargar.setBounds(100, 182, 165, 23);
					botonCargar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonCargar.actionPerformed, event="+evt);
							//TODO add your code for botonEditar.actionPerformed
							botonCargar();
						}
					});
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setFont(new java.awt.Font("Dialog",0,8));
				jPanel3.setBounds(13, 232, 359, 254);
				jPanel3.setLayout(null);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Asignación de Precios Promocionales", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,10), new java.awt.Color(0,0,0)));
				{
					jLabelId = new JLabel();
					jPanel3.add(jLabelId);
					jLabelId.setText("Id:");
					jLabelId.setBounds(10, 24, 64, 16);
				}
				{
					cajaId = new JTextField();
					jPanel3.add(cajaId);
					cajaId.setBounds(99, 21, 71, 23);
					cajaId.setEditable(false);
				}
				{
					cajaNombre = new JTextField();
					jPanel3.add(cajaNombre);
					cajaNombre.setBounds(99, 50, 249, 23);
					cajaNombre.setEditable(false);
				}
				{
					jLabelNombre = new JLabel();
					jPanel3.add(jLabelNombre);
					jLabelNombre.setText("Nombre:");
					jLabelNombre.setBounds(10, 53, 71, 16);
				}
				{
					jLabelTipoComida = new JLabel();
					jPanel3.add(jLabelTipoComida);
					jLabelTipoComida.setText("Tipo de Comida:");
					jLabelTipoComida.setBounds(10, 81, 57, 16);
				}
				{
					cajaTipoComida = new JTextField();
					jPanel3.add(cajaTipoComida);
					cajaTipoComida.setBounds(99, 78, 249, 23);
					cajaTipoComida.setEditable(false);
				}
				{
					cajaPuntuacion = new JTextField();
					jPanel3.add(cajaPuntuacion);
					cajaPuntuacion.setBounds(99, 107, 249, 23);
					cajaPuntuacion.setEditable(false);
				}
				{
					jLabelPuntuacion = new JLabel();
					jPanel3.add(jLabelPuntuacion);
					jLabelPuntuacion.setText("Puntuacion:");
					jLabelPuntuacion.setBounds(10, 110, 71, 16);
				}
				{
					botonEnviar = new JButton();
					jPanel3.add(botonEnviar);
					botonEnviar.setText("Enviar");
					botonEnviar.setBounds(274, 222, 74, 23);
					botonEnviar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("botonEnviar.actionPerformed, event="+evt);
							//TODO add your code for botonEnviar.actionPerformed
							botonEnviar();
						}
					});
				}
				{
					jLabelPrecioMedio = new JLabel();
					jPanel3.add(jLabelPrecioMedio);
					jLabelPrecioMedio.setText("Precio medio:");
					jLabelPrecioMedio.setBounds(10, 138, 83, 15);
				}
				{
					jLabelTiempoMedio = new JLabel();
					jPanel3.add(jLabelTiempoMedio);
					jLabelTiempoMedio.setText("Tiempo medio:");
					jLabelTiempoMedio.setBounds(10, 167, 83, 16);
				}
				{
					cajaPrecioMedio = new JTextField();
					jPanel3.add(cajaPrecioMedio);
					cajaPrecioMedio.setBounds(99, 135, 249, 23);
				}
				{
					cajaTiempoMedio = new JTextField();
					jPanel3.add(cajaTiempoMedio);
					cajaTiempoMedio.setBounds(99, 164, 249, 23);
				}
				{
					jLabelOfertaActual = new JLabel();
					jPanel3.add(jLabelOfertaActual);
					jLabelOfertaActual.setText("Oferta Actual:");
					jLabelOfertaActual.setBounds(10, 196, 90, 16);
				}
				{
					cajaOfertaActual = new JTextField();
					jPanel3.add(cajaOfertaActual);
					cajaOfertaActual.setBounds(99, 193, 249, 23);
				}
			}
			{
				botonCerrar = new JButton();
				getContentPane().add(botonCerrar);
				botonCerrar.setText("Cerrar");
				botonCerrar.setBounds(157, 492, 79, 23);
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonCerrar.actionPerformed, event="+evt);
						//TODO add your code for botonCerrar.actionPerformed
						botonCerrar();
					}
				});
			}
			pack();
			this.setSize(400, 559);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void botonEditar(){
		
		int restauranteRow = tablaRestaurantes.getSelectedRow();
		
		Restaurante res = restaurantes.getRestauranteList().get(restauranteRow);
		cajaId.setText(res.getIdRestaurante());
		cajaNombre.setText(res.getNombre());
		cajaOfertaActual.setText(Float.toString(res.getOfertaActual()));
		cajaPrecioMedio.setText(Float.toString(res.getPrecioMedio()));
		cajaPuntuacion.setText(Float.toString(res.getPuntuacion()));
		cajaTiempoMedio.setText(Float.toString(res.getTiempoMedio()));
		cajaTipoComida.setText(res.getTipoComida());
	}
	
	private void botonCargar(){		
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fichero = jfc.getSelectedFile();
			System.out.println(fichero.getAbsolutePath());
			
			try {
				// create a JAXBContext capable of handling classes generated into
	            // the primer.po package
	            JAXBContext jc = JAXBContext.newInstance(RestauranteList.class);
	            
	            // create an Unmarshaller
	            Unmarshaller u = jc.createUnmarshaller();
	            System.out.println(u);
	            System.out.println(fichero);
	            // unmarshal a po instance document into a tree of Java content
	            // objects composed of classes from the primer.po package.
	            restaurantes = (RestauranteList)u.unmarshal(fichero);

	            
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
	    		jTable1Model.addColumn("Tipo comida");
	    		jTable1Model.addColumn("Puntuación");
	            
	            
	            
	            for(Restaurante restaurante : restaurantes.getRestauranteList()) {
	            	Object[] fila = new Object[4];
	            	fila[0] = restaurante.getIdRestaurante();
	            	fila[1] = restaurante.getNombre();
	            	fila[2] = restaurante.getTipoComida();
	            	fila[3] = restaurante.getPuntuacion();
	            	jTable1Model.addRow(fila);
	            }
	            
	            tablaRestaurantes.setModel(jTable1Model);
	            
	           
	            
	        } catch( JAXBException je ) {
	            je.printStackTrace();
	        }
		}
	}
	
	private void botonEnviar(){
		Restaurante restaurante = new Restaurante();
		restaurante.setIdRestaurante(cajaId.getText());
		restaurante.setNombre(cajaNombre.getText());
		restaurante.setTipoComida(cajaTipoComida.getText());
		restaurante.setPuntuacion(Float.parseFloat(cajaPuntuacion.getText()));
		restaurante.setPrecioMedio(Float.parseFloat(cajaPrecioMedio.getText()));
		restaurante.setTiempoMedio(Float.parseFloat(cajaTiempoMedio.getText()));
		restaurante.setOfertaActual(Float.parseFloat(cajaOfertaActual.getText()));
		
		JusteatSWStub stub;
		try {
			stub = new JusteatSWStub("http://localhost:8080/axis2/services/JusteatSW");
			InsertarRestaurante irOper = new InsertarRestaurante();
			irOper.setRestaurante(restaurante);
            stub.insertarRestaurante(irOper);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void botonCerrar(){
		System.exit(0);
	}
}
