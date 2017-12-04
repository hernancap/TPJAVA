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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
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
				
			}
		});
		btnVerReservas.setBounds(254, 32, 170, 23);
		contentPane.add(btnVerReservas);
		
		JButton btnGesRes = new JButton("Gestionar reservas");
		btnGesRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ingreso in = new Ingreso();
				
				in.ventanaUsu(usuario);
				
			}
		});
		btnGesRes.setBounds(74, 32, 170, 23);
		contentPane.add(btnGesRes);
		
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
		
		JButton btnGestionUsu = new JButton("Gestionar usuarios");
		btnGestionUsu.addActionListener(new ActionListener() {
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
		btnGestionUsu.setBounds(254, 101, 170, 23);
		contentPane.add(btnGestionUsu);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 135, 414, 2);
		contentPane.add(separator_1);
		
		JLabel lblElementos = new JLabel("Elementos");
		lblElementos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElementos.setBounds(10, 148, 414, 14);
		contentPane.add(lblElementos);
		
		JButton btnGestionElem = new JButton("Gestionar elementos");
		btnGestionElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GestionElementos frame = new GestionElementos();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
				
				
				
			}
		});
		btnGestionElem.setBounds(254, 173, 170, 23);
		contentPane.add(btnGestionElem);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 207, 414, 2);
		contentPane.add(separator_2);
		
		JLabel lblTiposDeElemento = new JLabel("Tipos de Elemento");
		lblTiposDeElemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiposDeElemento.setBounds(10, 220, 414, 14);
		contentPane.add(lblTiposDeElemento);
		
		JButton btnGestionTipos = new JButton("Gestionar tipos");
		btnGestionTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GestionTipos frame = new GestionTipos();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnGestionTipos.setBounds(254, 245, 170, 23);
		contentPane.add(btnGestionTipos);
	}
}
