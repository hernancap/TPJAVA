package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlReserva;
import entity.Persona;
import entity.Reserva;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	private CtrlReserva ctrlRes = new CtrlReserva();
	private ArrayList<Reserva> listRes = new ArrayList<Reserva>();





	public VentanaAdmin(Persona usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerReservas = new JButton("Ver lista de reservas");
		btnVerReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listRes = ctrlRes.mostrarReservas();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TablaReservas frame = new TablaReservas(listRes);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
				
			// corregir 2 bugs ---------------------------------------------------------------------------------	
			
				
				
				
			}
		});
		btnVerReservas.setBounds(254, 32, 170, 23);
		contentPane.add(btnVerReservas);
		
		JButton btnNewButton = new JButton("Gestionar reservas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ingreso in = new Ingreso();
				
				in.ventanaUsu(usuario);
				
			}
		});
		btnNewButton.setBounds(74, 32, 170, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 414, 2);
		contentPane.add(separator);
		
		JLabel lblReservas = new JLabel("Reservas");
		lblReservas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservas.setBounds(10, 11, 414, 14);
		contentPane.add(lblReservas);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarios.setBounds(10, 79, 414, 14);
		contentPane.add(lblUsuarios);
		
		JButton btnNewButton_1 = new JButton("Gestionar usuarios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GestionUsuarios frame = new GestionUsuarios();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(254, 101, 170, 23);
		contentPane.add(btnNewButton_1);
	}
}
