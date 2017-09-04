package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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

import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.TipoElemento;

import org.jdesktop.beansbinding.ELProperty;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controlers.CtrlElemento;
import controlers.CtrlPersona;
import controlers.CtrlReserva;
import controlers.CtrlTipoElem;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.Font;
import org.jdesktop.swingbinding.JComboBoxBinding;
import javax.swing.JTextArea;
import java.awt.Dialog.ModalExclusionType;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	
	private String horaSelec;
	private String teSelec;
	
	
	private ArrayList<Persona> pers;
	private ArrayList<TipoElemento> tipoElem;
	private ArrayList<Elemento> elemDisp;
	
	private Reserva nuevaRes = new Reserva();
	
	private CtrlPersona ctrlPers;
	private CtrlTipoElem ctrlTipo = new CtrlTipoElem();
	private CtrlReserva ctrlRes = new CtrlReserva();
	private CtrlElemento ctrlElem = new CtrlElemento();

	private JComboBox boxTipoElem;
	private JTextField txtTiempoRes;
	

	/**
	 * Create the frame.
	 */
	public VentanaUsuario(Persona usuario) {
		setResizable(false);
		setTitle("Reservas");
	
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 317);
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
				
				//-------------------------------------------------------------------
			}
		});
		btnVerReservas.setBounds(372, 7, 156, 23);
		contentPane.add(btnVerReservas);
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		lblTipoDeElemento.setBounds(10, 103, 134, 14);
		contentPane.add(lblTipoDeElemento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 534, 2);
		contentPane.add(separator);
		
		
		ArrayList<TipoElemento> tipoElem = new ArrayList<TipoElemento>();
		
		tipoElem = ctrlTipo.mostrarTipos();
		
		boxTipoElem = new JComboBox();
		boxTipoElem.setBounds(154, 100, 126, 20);
		contentPane.add(boxTipoElem);
		for (int x=0; x<tipoElem.size(); x++){			
			
			boxTipoElem.addItem(tipoElem.get(x).getNombreTipo());
		}
		boxTipoElem.setSelectedIndex(-1);
	    
		boxTipoElem.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	teSelec = (String) boxTipoElem.getSelectedItem();
	        }
	    });
		
		

		
			
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 140, 134, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 177, 134, 14);
		contentPane.add(lblHora);
		
		JComboBox<String> boxHora = new JComboBox();
		boxHora.setBounds(154, 174, 126, 20);
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
	    
	    boxHora.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	horaSelec = ((String) boxHora.getSelectedItem() + ":00");
	        }
	    });
	      

	    
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(154, 137, 126, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Detalle (Opcional):");
		lblNewLabel.setBounds(331, 100, 156, 14);
		contentPane.add(lblNewLabel);
		
		txtTiempoRes = new JTextField();
		txtTiempoRes.setHorizontalAlignment(SwingConstants.CENTER);
		txtTiempoRes.setBounds(154, 210, 46, 20);
		contentPane.add(txtTiempoRes);
		txtTiempoRes.setColumns(10);
		
		JComboBox boxTiempoRes = new JComboBox();
		boxTiempoRes.setBounds(210, 210, 70, 20);
		contentPane.add(boxTiempoRes);
		boxTiempoRes.addItem("Horas");
		boxTiempoRes.addItem("Días");
		boxTiempoRes.setSelectedIndex(0);
		 
		
		
		
		JTextArea txtDetalle = new JTextArea();
		txtDetalle.setLineWrap(true);
		txtDetalle.setWrapStyleWord(true);
		txtDetalle.setBounds(331, 114, 193, 102);
		contentPane.add(txtDetalle);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtDetalle.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		initDataBindings();
		
		JButton btnBuscarElem = new JButton("Buscar Elementos");
		btnBuscarElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String año = Integer.toString(dateChooser.getCalendar().get(Calendar.YEAR));
				String mes = Integer.toString(dateChooser.getCalendar().get(Calendar.MONTH) + 1);
				String dia = Integer.toString(dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH));
				
				String fechaSelec = (año + "-" + mes + "-" + dia + " " + horaSelec);
				String textDet = txtDetalle.getText();
				
				int tiempoRes = Integer.parseInt(txtTiempoRes.getText());
				int horasRes = 0;	
				
				String tipoTiempoSelec = (String) boxTiempoRes.getSelectedItem();

				
				System.out.println(tiempoRes);
				
				System.out.println(tiempoRes);

				
				if (tipoTiempoSelec == "Días"){
					horasRes = (tiempoRes * 24);
					
					System.out.println(horasRes);
					
					System.out.println(horasRes);

					
					

				} else{ horasRes = tiempoRes;}
				
				
				elemDisp = ctrlElem.buscarElemento(fechaSelec, teSelec, horasRes);
				
				if(elemDisp != null ){

				
				mostrarElem(elemDisp);
				nuevaRes.setDetalle(textDet);
				nuevaRes.setFechayhora(fechaSelec);
				nuevaRes.setTiempoUso(horasRes);
				nuevaRes.setTipo(new TipoElemento());
				nuevaRes.getTipo().setNombreTipo(teSelec);
				nuevaRes.setPersona(new Persona());
				nuevaRes.getPersona().setId(usuario.getId());
				
				}
				else{
				
				JOptionPane.showMessageDialog(null, "No hay elementos disponibles");}

				

			}


		});
		btnBuscarElem.setBounds(199, 245, 172, 32);
		contentPane.add(btnBuscarElem);
		
		JLabel lblNuevaReserva = new JLabel("Nueva reserva");
		lblNuevaReserva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNuevaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaReserva.setBounds(10, 49, 534, 23);
		contentPane.add(lblNuevaReserva);
		
		JLabel lblTiempoDeReserva = new JLabel("Tiempo de Reserva");
		lblTiempoDeReserva.setBounds(10, 213, 134, 14);
		contentPane.add(lblTiempoDeReserva);
		


			
		
		

		
		
	}
	
	public VentanaUsuario() {}

	protected void initDataBindings() {
	}
	
	private void mostrarElem(ArrayList<Elemento> elemDisp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarElem frame = new SeleccionarElem(elemDisp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
	}
	
	void agregarRes(Elemento elemSel){
		
		nuevaRes.getElemento().setIdElem(elemSel.getIdElem());
		
	}
	

	
	
}
