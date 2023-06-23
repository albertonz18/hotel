package com.hotel.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotel.factory.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Acceso extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel paneAcceso;
	private JTextField txUsuario;
	private JPasswordField passContrasena;
	public String empresa = "Hotel The Peninsula";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Acceso() {
		setTitle(empresa + " - Acceso");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 406);
		paneAcceso = new JPanel();
		paneAcceso.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneAcceso);
		paneAcceso.setLayout(null);
		
		JLabel labelTituloAcceso = new JLabel("Acceso");
		labelTituloAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		labelTituloAcceso.setBounds(114, 97, 369, 46);
		paneAcceso.add(labelTituloAcceso);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNombre.setBounds(91, 139, 164, 32);
		paneAcceso.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblContrasea.setBounds(91, 172, 164, 32);
		paneAcceso.add(lblContrasea);
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(new Color(240, 240, 240,240));
		btnSalir.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/Salir.png")));
		btnSalir.setBounds(486, 282, 80, 74);
		paneAcceso.add(btnSalir);
		
		ActionListener salir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma que desea Salir?");

						if (JOptionPane.OK_OPTION == confirmado) {
							Bienvenida.main(null);
							dispose();								
						}else {
							
						}
			}
		};
		
		btnSalir.addActionListener(salir);
		
		
		
		txUsuario = new JTextField();
		txUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		txUsuario.setBounds(261, 139, 196, 26);
		paneAcceso.add(txUsuario);
		txUsuario.setColumns(10);
		
		
		passContrasena = new JPasswordField();
		passContrasena.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		passContrasena.setEchoChar('*');
		passContrasena.setBounds(261, 172, 196, 26);
		paneAcceso.add(passContrasena);
		
		JCheckBox checkBoxContrasena = new JCheckBox("Ver Contraseña");
		checkBoxContrasena.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		checkBoxContrasena.setBounds(350, 198, 107,23);
		paneAcceso.add(checkBoxContrasena);
		checkBoxContrasena.setOpaque(false);
		
		ActionListener verPass = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBoxContrasena.isSelected()) {
					passContrasena.setEchoChar((char) 0);
				}else {
					passContrasena.setEchoChar('*');
				}
				
			}
		};
		
		checkBoxContrasena.addActionListener(verPass);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnIngresar.setBackground(new Color(200,150,41));
		btnIngresar.setBounds(240, 224, 148, 32);
		paneAcceso.add(btnIngresar);
		btnIngresar.setOpaque(isOpaque());
		

		


		
		ActionListener ingresar = new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(txUsuario.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"Por favor coloque el Usuario.",empresa +" - Coloque el Usuario.", 0);
					return;
				}else if (passContrasena.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"Por favor coloque la Contraseña.",empresa +" - Falta Contraseña.", 0);
					return;
				}else {
					try {
						Connection conexion = new ConnectionFactory().recuperaConexion();
						String usuario = txUsuario.getText();
						String contraseña = passContrasena.getText();
						String consultaSQL = "select * from Empleados where correoUsuario = '" + usuario + "' and passwordUsuario ='" + contraseña + "';";
						ResultSet resultadoConsulta = conexion.createStatement().executeQuery(consultaSQL);
						
						if(resultadoConsulta.next()) {
							JOptionPane.showMessageDialog(null,"¡Ingreso Correcto!",empresa +" - Ingreso Correcto.",JOptionPane.INFORMATION_MESSAGE);
							EligeAccion.main(null);
							dispose();
						}else {
							JOptionPane.showMessageDialog
							(null,"¡El Usuario o Contraseña son INCORRECTOS, por favor intente de nuevo!",empresa +" - Datos Incorrectos.",0);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
											
					
				}
				
			}
		};
		
		btnIngresar.addActionListener(ingresar);

		

		

		JLabel labelCuadroAcceso = new JLabel("");
		labelCuadroAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuadroAcceso.setVerticalAlignment(SwingConstants.TOP);
		labelCuadroAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroAcceso.setBackground(new Color(255, 255, 255,190));
		labelCuadroAcceso.setBounds(114, 90, 369, 184);
		paneAcceso.add(labelCuadroAcceso);
		labelCuadroAcceso.setOpaque(isOpaque());
		
		JLabel labelFondoAcceso = new JLabel("Acceso");
		labelFondoAcceso.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/lobby.jpg")));
		labelFondoAcceso.setBounds(0, 0, 581, 367);
		paneAcceso.add(labelFondoAcceso);

		

		

		
		

		
		
		

		
	}
}
