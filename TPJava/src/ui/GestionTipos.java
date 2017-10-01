package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlTipoElem;
import entity.TipoElemento;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import com.toedter.calendar.JDateChooser;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionTipos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNombre;
	private JTextField txtCantMax;
	private JTextField txtHorasMax;
	private JTextField txtDiasAntic;
	private CtrlTipoElem ctrlTipo = new CtrlTipoElem();
	private ArrayList<TipoElemento> listaTip = new ArrayList<TipoElemento>();
	private TipoElemento tip = new TipoElemento();
	
	private boolean editar = false;



	/**
	 * Create the frame.
	 */
	public GestionTipos() {
		setResizable(false);
		setTitle("Tipos de Elementos");
		
		listaTip = ctrlTipo.mostrarTipos();
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 333, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(359, 11, 1, 283);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre Tipo");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(370, 11, 97, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(370, 23, 186, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cant. m\u00E1xima reservas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(370, 54, 141, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horas m\u00E1x. (0 = sin l\u00EDmite)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(370, 97, 186, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCantMax = new JTextField();
		txtCantMax.setBounds(370, 66, 186, 20);
		contentPane.add(txtCantMax);
		txtCantMax.setColumns(10);
		
		txtHorasMax = new JTextField();
		txtHorasMax.setBounds(370, 109, 186, 20);
		contentPane.add(txtHorasMax);
		txtHorasMax.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("D\u00EDas de anticipaci\u00F3n (0 = sin ant.)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(370, 140, 196, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDiasAntic = new JTextField();
		txtDiasAntic.setBounds(370, 152, 186, 20);
		contentPane.add(txtDiasAntic);
		txtDiasAntic.setColumns(10);
		
		JCheckBox chkEncarg = new JCheckBox("Solo Encargado puede reservar");
		chkEncarg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chkEncarg.setBounds(370, 179, 186, 23);
		contentPane.add(chkEncarg);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (validarCampos() == false){
					
					JOptionPane.showMessageDialog(null, "No has completado todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
				
				tip.setNombreTipo(txtNombre.getText());
				tip.setCantMaxRes(Integer.parseInt(txtCantMax.getText()));
				tip.setHorasMax(Integer.parseInt(txtHorasMax.getText()));
				tip.setMaxDiasAnticip(Integer.parseInt(txtDiasAntic.getText()));
				if (chkEncarg.isSelected()){ 
					tip.setSoloEncarg(1);;
				} else {tip.setSoloEncarg(0);}
				
				
				ctrlTipo.nuevoTipo(tip, editar);
								
				dispose();
			
				}
				
			}
		});
		btnAgregar.setBounds(402, 271, 130, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indicePer=table.convertRowIndexToModel(table.getSelectedRow());
				if (indicePer == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona un tipo a eliminar");
				}	
				else{	
				
				tip = listaTip.get(indicePer);
				
				ctrlTipo.eliminarTipo(tip);
				dispose();
				
				
				
				
				}
				}
		});
		btnEliminar.setBounds(180, 271, 163, 23);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
					int indicePer=table.convertRowIndexToModel(table.getSelectedRow());
					if (indicePer == (-1) ){
							
						JOptionPane.showMessageDialog(null, "Selecciona un tipo a editar");
					}	
					else{	

					tip = listaTip.get(indicePer);
					
					txtNombre.setText(tip.getNombreTipo());
					txtCantMax.setText(String.valueOf(tip.getCantMaxRes()));
					txtDiasAntic.setText(String.valueOf(tip.getMaxDiasAnticip()));
					txtHorasMax.setText(String.valueOf(tip.getHorasMax()));
					chkEncarg.setSelected((tip.getSoloEncarg() == 1));

					editar = true;
					
					
					}
					
					
				}
		
			
		});
		btnEditar.setBounds(10, 271, 151, 23);
		contentPane.add(btnEditar);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<TipoElemento, List<TipoElemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listaTip, table);
		//
		BeanProperty<TipoElemento, String> tipoElementoBeanProperty = BeanProperty.create("nombreTipo");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> tipoElementoBeanProperty_1 = BeanProperty.create("maxDiasAnticip");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_1).setColumnName("M\u00E1x. d\u00EDas antip.").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> tipoElementoBeanProperty_2 = BeanProperty.create("cantMaxRes");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_2).setColumnName("Cant. m\u00E1x res.").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> tipoElementoBeanProperty_3 = BeanProperty.create("soloEncarg");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_3).setColumnName("Solo encargado").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> tipoElementoBeanProperty_4 = BeanProperty.create("horasMax");
		jTableBinding.addColumnBinding(tipoElementoBeanProperty_4).setColumnName("Horas m\u00E1x.").setEditable(false);
		//
		jTableBinding.bind();
	}
	
	private boolean validarCampos() {
		
		if(!txtCantMax.getText().isEmpty() && !txtDiasAntic.getText().isEmpty() &&
				!txtHorasMax.getText().isEmpty() && !txtNombre.getText().isEmpty()){
			
			return true;
			
			
		}else {  return false;}

		
		
		
	}
}
