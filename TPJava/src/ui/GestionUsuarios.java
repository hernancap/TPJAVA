package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlPersona;
import controlers.CtrlReserva;
import entity.Persona;
import entity.Reserva;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class GestionUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private ArrayList<Persona> listPer = new ArrayList<Persona>();
	private Persona per = new Persona();
	private CtrlPersona ctrlPer = new CtrlPersona();
	private JButton btnEliminar;
	private JButton btnEditar;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private boolean editar = false;

// falta: dispose en botones eliminar y agregar, validar todos los campos, agrandar ventana-------------------------------------------

	/**
	 * Create the frame.
	 */
	public GestionUsuarios() {
		
		listPer = ctrlPer.mostrarPersona();
	
		
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 375, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indicePer=table.convertRowIndexToModel(table.getSelectedRow());
				if (indicePer == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona un usuario a eliminar");
				}	
				else{	
				
				per = listPer.get(indicePer);
				
				ctrlPer.eliminarPer(per);
				dispose();
				
				
				}
				
				
			
			}
		});
		btnEliminar.setBounds(203, 281, 182, 23);
		contentPane.add(btnEliminar);
		
		
		JCheckBox chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setBounds(414, 253, 124, 23);
		contentPane.add(chkHabilitado);
		
		JComboBox boxCateg = new JComboBox();
		boxCateg.setBounds(414, 232, 124, 20);
		contentPane.add(boxCateg);

		boxCateg.addItem("admin");
		boxCateg.addItem("usuario");
		boxCateg.addItem("encargado");

		boxCateg.setSelectedIndex(-1);
		
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				int indicePer=table.convertRowIndexToModel(table.getSelectedRow());
				if (indicePer == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona un usuario a editar");
				}	
				else{	

				per = listPer.get(indicePer);
				
				txtDni.setText(per.getDni());
				txtApellido.setText(per.getApellido());
				txtContraseña.setText(per.getContraseña());
				txtNombre.setText(per.getNombre());
				txtUsuario.setText(per.getUsuario());
				boxCateg.setSelectedItem(per.getCategoria());
				chkHabilitado.setSelected((per.getHabilitado() == 1));
				editar = true;
				
				
				}
				
				
			}
		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				per.setApellido(txtApellido.getText());
				per.setCategoria(((String) boxCateg.getSelectedItem()));
				per.setContraseña(txtContraseña.getText());
				per.setDni(txtDni.getText());
				per.setNombre(txtNombre.getText());
				per.setUsuario(txtUsuario.getText());
				if (chkHabilitado.isSelected()){ 
					per.setHabilitado(1);
				} else {per.setHabilitado(0);}
				
				ctrlPer.nuevaPersona(per, editar);
								
				
			}
		});
		btnAgregar.setBounds(414, 281, 124, 23);
		contentPane.add(btnAgregar);
		
		
		
		btnEditar.setBounds(10, 281, 183, 23);
		contentPane.add(btnEditar);
		
		txtDni = new JTextField();
		
		
		txtDni.setBounds(414, 33, 124, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(414, 20, 124, 14);
		contentPane.add(lblDni);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(402, 11, 2, 293);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(414, 62, 124, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(414, 75, 124, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(414, 106, 124, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(414, 118, 124, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(414, 149, 124, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(414, 161, 124, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(414, 192, 124, 14);
		contentPane.add(lblContrasea);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(414, 204, 124, 20);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
		

		

		
		
		
		
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listPer, table);
		//
		BeanProperty<Persona, String> personaBeanProperty = BeanProperty.create("usuario");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Usuario");
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Nombre");
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Apellido");
		//
		BeanProperty<Persona, String> personaBeanProperty_3 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("DNI");
		//
		BeanProperty<Persona, String> personaBeanProperty_4 = BeanProperty.create("contraseña");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("Contrase\u00F1a");
		//
		BeanProperty<Persona, Integer> personaBeanProperty_5 = BeanProperty.create("habilitado");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("Habilitado");
		//
		BeanProperty<Persona, String> personaBeanProperty_6 = BeanProperty.create("categoria");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("Categoria");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
