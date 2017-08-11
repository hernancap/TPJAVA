package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import data.Conexion;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCescritorio extends JFrame {
	private static JTextField txtUsuario;
	private static JTextField textContraseña;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCescritorio frame = new ABMCescritorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public ABMCescritorio() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 41, 134, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 104, 116, 52);
		getContentPane().add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(147, 59, 134, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.addActionListener(new ActionListener(){
			
			
            public void actionPerformed(ActionEvent e){
            	
            	login();
            }
		});
		textContraseña = new JPasswordField();
		textContraseña.setBounds(147, 122, 134, 20);
		getContentPane().add(textContraseña);
		textContraseña.setColumns(10);
		textContraseña.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
            	
            	login();
            	
            }
		});
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login();
			}
		});
		btnEntrar.setBounds(216, 208, 105, 31);
		getContentPane().add(btnEntrar);
	}
	

	private void login(){
		String usu;
		String pass;
		String usuEncon = null;
		
		
		
		
		usu=(txtUsuario.getText());
		pass=(textContraseña.getText());
		
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement(
					"select usuario, contraseña from persona where contraseña=? and usuario=?");
			stmt.setString(1, pass);
			stmt.setString(2, usu);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
			usuEncon=rs.getString("usuario");
			
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			Conexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
		
		if(usuEncon != null){
			System.out.println("Ingreso Correcto");
			dispose();
			
			nuevaVentana();
	
		
			
		}
		else{
		System.out.println("Ingreso incorrecto");
		JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");}
			
		
		
			
	}
	
	private void nuevaVentana(){
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCescritorio2 frame = new ABMCescritorio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	

}




