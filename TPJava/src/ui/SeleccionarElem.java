package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Elemento;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class SeleccionarElem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	private ArrayList<Elemento> listaElem = new ArrayList<Elemento>();
	private Elemento elemSel;


	public SeleccionarElem(ArrayList<Elemento> elemDisp) {
		setAlwaysOnTop(true);
		
		setResizable(false);
		
		listaElem = elemDisp;
		
		
		setTitle("Seleccionar Elemento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 298, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		


		
		JLabel lblSeleccionaUnElemento = new JLabel("Selecciona un elemento para reservarlo");
		lblSeleccionaUnElemento.setBounds(10, 11, 286, 14);
		contentPane.add(lblSeleccionaUnElemento);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			int indiceElem=table.convertRowIndexToModel(table.getSelectedRow());
			if (indiceElem == (-1) ){
					
				JOptionPane.showMessageDialog(null, "Selecciona un elemento a reservar");
			}	
			else{	

			elemSel = elementoSel(indiceElem);
			
			
			VentanaUsuario vu = new VentanaUsuario();

			vu.agregarRes(elemSel);
			
			dispose();
			
			}
			
			}
		});
		btnReservar.setBounds(207, 239, 89, 23);
		contentPane.add(btnReservar);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listaElem, table);
		//
		BeanProperty<Elemento, Integer> elementoBeanProperty = BeanProperty.create("idElem");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("ID").setEditable(false);
		//
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("Nombre").setEditable(false);
		//
		jTableBinding.bind();
	}
	
	private Elemento elementoSel(int indiceElem){
		
		elemSel = listaElem.get(indiceElem);


		return elemSel;
	}
}
