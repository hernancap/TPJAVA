package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlElemento;
import controlers.CtrlTipoElem;
import entity.Elemento;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import entity.TipoElemento;

public class GestionElementos extends JFrame {

	private JPanel contentPane;
	
	private CtrlElemento ctrlElem = new CtrlElemento();
	private ArrayList<Elemento> listaElem = new ArrayList<Elemento>();
	private Elemento elem = new Elemento();
	
	private CtrlTipoElem ctrlTipo = new CtrlTipoElem();
	
	private String teSelec;
	
	private boolean editar = false;
	private JTable table;
	private JTextField txtNombre;

	

	/**
	 * Create the frame.
	 */
	public GestionElementos() {
		setTitle("Elementos");
		
		listaElem = ctrlElem.mostrarElem();

		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(264, 11, 1, 239);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 244, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		lblTipoDeElemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeElemento.setBounds(275, 11, 149, 14);
		contentPane.add(lblTipoDeElemento);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(275, 67, 149, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre (Opcional)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(275, 54, 149, 14);
		contentPane.add(lblNewLabel);
		
		ArrayList<TipoElemento> tipoElem = new ArrayList<TipoElemento>();
		
		tipoElem = ctrlTipo.mostrarTipos();
		
		JComboBox boxTipo = new JComboBox();
		boxTipo.setBounds(275, 23, 149, 20);
		contentPane.add(boxTipo);
		
		for (int x=0; x<tipoElem.size(); x++){			
			
			boxTipo.addItem(tipoElem.get(x).getNombreTipo());
		}
		boxTipo.setSelectedIndex(-1);
	    
		boxTipo.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	teSelec = (String) boxTipo.getSelectedItem();
	        }
	    });
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreElem;
				
				if (validarCampos(boxTipo) == false){
					
					JOptionPane.showMessageDialog(null, "No has completado todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
				
				if (txtNombre.getText().isEmpty()){
					
					nombreElem = teSelec;
					
				} else{
					
					nombreElem = txtNombre.getText();
				}
					
				
				elem.setNombre(nombreElem);
				elem.setTipo(new TipoElemento());
				elem.getTipo().setNombreTipo(teSelec);
				
				
				
				ctrlElem.nuevoElem(elem, editar);
								
				dispose();
			
				
				}
			
			}
		});
		btnAgregar.setBounds(309, 227, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				int indice=table.convertRowIndexToModel(table.getSelectedRow());
				if (indice == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona un elemento a editar");
				}	
				else{	

				elem = listaElem.get(indice);
				
				txtNombre.setText(elem.getNombre());
				boxTipo.setSelectedItem(elem.getTipo().getNombreTipo());

				editar = true;
				
				
				}
				
				
			
			}
		});
		btnEditar.setBounds(10, 227, 116, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indice=table.convertRowIndexToModel(table.getSelectedRow());
				if (indice == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona un elemento a eliminar");
				}	
				else{	
				
				elem  = listaElem.get(indice);
				
				ctrlElem.eliminarElem(elem);
				dispose();
				
				
				
				
				}
				
			}
		});
		btnEliminar.setBounds(136, 227, 118, 23);
		contentPane.add(btnEliminar);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listaElem, table);
		//
		BeanProperty<Elemento, String> elementoBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("tipo.nombreTipo");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Tipo de elemento").setEditable(false);
		//
		jTableBinding.bind();
	}
	
	private boolean validarCampos(JComboBox<String> boxTipo) {
		
		if(boxTipo.getSelectedIndex() != (-1)){
				
			
			return true;
			
			
		}else {  return false;}

		
		
		
	}
}
