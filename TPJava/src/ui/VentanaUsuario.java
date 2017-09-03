package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.beansbinding.ObjectProperty;
import entity.Persona;
import entity.TipoElemento;

import org.jdesktop.beansbinding.ELProperty;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controlers.CtrlPersona;
import controlers.CtrlReserva;
import controlers.CtrlTipoElem;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.Font;
import org.jdesktop.swingbinding.JComboBoxBinding;
import javax.swing.JTextArea;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	
	
	private ArrayList<Persona> pers;
	private ArrayList<TipoElemento> tipoElem;
	

	private CtrlPersona ctrlPers;
	private CtrlTipoElem ctrlTipo = new CtrlTipoElem();
	private CtrlReserva ctrlRes = new CtrlReserva();

	private JComboBox boxTipoElem;
	

	/**
	 * Create the frame.
	 */
	public VentanaUsuario(Persona usuario) {
		setResizable(false);
		setTitle("Reservas");
	
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBienvenido = new JLabel(usuario.getNombre() + " " + usuario.getApellido());
		lblBienvenido.setBounds(10, 11, 257, 14);
		contentPane.add(lblBienvenido);
		
		JButton btnVerReservas = new JButton("Ver mis reservas");
		btnVerReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerReservas.setBounds(268, 7, 156, 23);
		contentPane.add(btnVerReservas);
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		lblTipoDeElemento.setBounds(10, 103, 88, 14);
		contentPane.add(lblTipoDeElemento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		contentPane.add(separator);
		
		
		ArrayList<TipoElemento> tipoElem = new ArrayList<TipoElemento>();
		
		tipoElem = ctrlTipo.mostrarTipos();
		
		boxTipoElem = new JComboBox();
		boxTipoElem.setBounds(108, 100, 126, 20);
		contentPane.add(boxTipoElem);
		for (int x=0; x<tipoElem.size(); x++){			
			
			boxTipoElem.addItem(tipoElem.get(x).getNombreTipo());
		}
		
		

		
			
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 140, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 177, 46, 14);
		contentPane.add(lblHora);
		
		JComboBox<String> boxHora = new JComboBox();
		boxHora.setBounds(108, 174, 126, 20);
		contentPane.add(boxHora);
	    boxHora.addItem("06:00");
	    boxHora.addItem("07:00");
	    boxHora.addItem("08:00");
	    boxHora.addItem("09:00");
	    boxHora.addItem("10:00");
	    boxHora.addItem("11:00");
	    boxHora.addItem("12:00");
	    boxHora.addItem("13:00");
	    boxHora.addItem("14:00");
	    boxHora.addItem("15:00");
	    boxHora.addItem("16:00");
	    boxHora.addItem("17:00");
	    boxHora.addItem("18:00");
	    boxHora.addItem("19:00");
	    boxHora.addItem("20:00");
	    boxHora.addItem("21:00");
	    boxHora.addItem("22:00");
	    boxHora.addItem("23:00");
	    boxHora.addItem("24:00");
	    
	    boxHora.setSelectedIndex(-1);
	    
	    String horaSelec = (String) boxHora.getSelectedItem();  // --------------------------------------

	    
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 137, 126, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Detalle (Opcional):");
		lblNewLabel.setBounds(268, 100, 156, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtDetalle = new JTextArea();
		txtDetalle.setLineWrap(true);
		txtDetalle.setWrapStyleWord(true);
		txtDetalle.setBounds(268, 114, 156, 80);
		contentPane.add(txtDetalle);
		initDataBindings();
		
		JButton btnBuscarElem = new JButton("Buscar Elementos");
		btnBuscarElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dia = Integer.toString(dateChooser.getCalendar().get(Calendar.YEAR));
				String mes = Integer.toString(dateChooser.getCalendar().get(Calendar.MONTH) + 1);
				String a�o = Integer.toString(dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH));
				
				String fechaSelec = (a�o + "-" + mes + "-" + dia + " " + horaSelec);
				String textDet = txtDetalle.getText();
				String teSelec = (String) boxTipoElem.getSelectedItem();
				
				ctrlRes.buscarReserva(fechaSelec, textDet, teSelec);
				
				

			}
		});
		btnBuscarElem.setBounds(134, 218, 172, 32);
		contentPane.add(btnBuscarElem);
		
		JLabel lblNuevaReserva = new JLabel("Nueva reserva");
		lblNuevaReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setBounds(10, 49, 414, 23);
		contentPane.add(lblNuevaReserva);
		

		
		
	}
	protected void initDataBindings() {
	}
}