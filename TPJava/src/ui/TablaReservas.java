package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Elemento;
import entity.Reserva;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controlers.CtrlReserva;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaReservas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private Reserva res = new Reserva();
	private CtrlReserva ctrlRes = new CtrlReserva();



	// falta: no mostrar reservas anteriores-----------------------------------------------------------------------------------


	public TablaReservas(ArrayList<Reserva> listRes) {
		setResizable(false);
		setAlwaysOnTop(true);

		
		reservas = listRes;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 535, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnEliminarReserva = new JButton("Eliminar Reserva");
		btnEliminarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int indiceRes=table.convertRowIndexToModel(table.getSelectedRow());
				if (indiceRes == (-1) ){
						
					JOptionPane.showMessageDialog(null, "Selecciona una reserva a eliminar");
				}	
				else{	
				
				res = reservas.get(indiceRes);
				
				ctrlRes.eliminarRes(res);
				dispose();
				
				}
				
				
			}
		});
		btnEliminarReserva.setBounds(365, 260, 170, 23);
		contentPane.add(btnEliminarReserva);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, reservas, table);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("ID Reserva");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_1 = BeanProperty.create("tipo.nombreTipo");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("Nombre Tipo");
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty_2 = BeanProperty.create("elemento.idElem");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("ID Elemento");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_3 = BeanProperty.create("fechayhora");
		jTableBinding.addColumnBinding(reservaBeanProperty_3).setColumnName("Fecha y Hora");
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty_4 = BeanProperty.create("tiempoUso");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("Tiempo de uso (Horas)");
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty_5 = BeanProperty.create("persona.id");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("ID Usuario");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_6 = BeanProperty.create("detalle");
		jTableBinding.addColumnBinding(reservaBeanProperty_6).setColumnName("Detalle");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
