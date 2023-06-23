package com.hotel.vistas;

import java.awt.Color;

import com.hotel.dao.ClienteDAO;
import com.hotel.modelo.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class RegistroCliente extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel paneRegistro;
	private JTextField txNombre;
	private JTextField txApellido;
	private JTextField txCorreoCliente;
	public String empresa = "Hotel The Peninsula";
	private JTextField txNumCliente;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente frame = new RegistroCliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 417);
		paneRegistro = new JPanel();
		paneRegistro.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneRegistro);
		paneRegistro.setLayout(null);
		
		JLabel labelCuadroAcceso = new JLabel("Registrar Cliente");
		labelCuadroAcceso.setBounds(114, 22, 369, 46);
		labelCuadroAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuadroAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroAcceso.setBackground(new Color(255, 255, 255,190));
		paneRegistro.add(labelCuadroAcceso);
		labelCuadroAcceso.setOpaque(isOpaque());
		
		JDateChooser dateNacimiento = new JDateChooser();
		dateNacimiento.setDateFormatString("yyyy-MM-dd");
		dateNacimiento.setBounds(214, 147, 307, 25);
		paneRegistro.add(dateNacimiento);
		
		JLabel labelTitulo_1 = new JLabel("Nombres:  ");
		labelTitulo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1.setBackground(new Color(255, 255, 255,190));
		labelTitulo_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1.setBounds(48, 79, 161, 25);
		labelTitulo_1.setOpaque(isOpaque());
		paneRegistro.add(labelTitulo_1);
		
		JLabel labelTitulo_1_1 = new JLabel("Apellidos:  ");
		labelTitulo_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_1.setOpaque(true);
		labelTitulo_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_1.setBounds(48, 114, 161, 25);
		paneRegistro.add(labelTitulo_1_1);
		
		JLabel labelTitulo_1_2 = new JLabel("Fecha de Nacimiento:  ");
		labelTitulo_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_2.setOpaque(true);
		labelTitulo_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_2.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_2.setBounds(48, 147, 161, 25);
		paneRegistro.add(labelTitulo_1_2);
		
		JLabel labelTitulo_1_3 = new JLabel("Correo Electronico:  ");
		labelTitulo_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3.setOpaque(true);
		labelTitulo_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3.setBounds(48, 184, 161, 25);
		paneRegistro.add(labelTitulo_1_3);
		
		JLabel labelTitulo_1_3_1_1 = new JLabel("Numero de Cliente:  ");
		labelTitulo_1_3_1_1.setOpaque(true);
		labelTitulo_1_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3_1_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3_1_1.setBounds(48, 220, 161, 25);
		paneRegistro.add(labelTitulo_1_3_1_1);
		
		txNumCliente = new JTextField();
		txNumCliente.setEditable(false);
		txNumCliente.setColumns(10);
		txNumCliente.setBounds(214, 220, 86, 23);
		paneRegistro.add(txNumCliente);
		
		txNombre = new JTextField();
		txNombre.setBounds(214, 80, 307, 23);
		paneRegistro.add(txNombre);
		txNombre.setColumns(10);
		
		txApellido = new JTextField();
		txApellido.setColumns(10);
		txApellido.setBounds(214, 115, 307, 23);
		paneRegistro.add(txApellido);
		
		txCorreoCliente = new JTextField();
		txCorreoCliente.setColumns(10);
		txCorreoCliente.setBounds(214, 184, 307, 23);
		paneRegistro.add(txCorreoCliente);
		
		
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(new Color(240, 240, 240,240));
		btnSalir.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/Salir.png")));
		btnSalir.setBounds(544, 293, 80, 74);
		paneRegistro.add(btnSalir);
		
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
		
		
		
		
		JButton btnRegistrar = new JButton("Reservar");
		btnRegistrar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnRegistrar.setBackground(new Color(200,150,41));
		btnRegistrar.setBounds(373, 291, 148, 32);
		paneRegistro.add(btnRegistrar);
		btnRegistrar.setOpaque(isOpaque());
		
		ActionListener registrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				
				
				if(txNombre.getText().length() != 0 && 
				   txApellido.getText().length() != 0 && 
				   dateNacimiento.getDate() != null && 
				   txCorreoCliente.getText().length() != 0) {
					
					String nombre = txNombre.getText();
					String apellido = txApellido.getText();
					String fNacimiento = ((JTextField)dateNacimiento.getDateEditor().getUiComponent()).getText();
					String telefono = txCorreoCliente.getText();
					String correoDuplicado = String.valueOf(txCorreoCliente.getText());
					
					
					
					try {
						Cliente nvoCliente = new Cliente(nombre, apellido, fNacimiento, telefono);
						ClienteDAO.guardar(nvoCliente, empresa,correoDuplicado,txNumCliente);
						txNumCliente.setText(ClienteDAO.retornaID(nvoCliente, empresa));
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Error al Registrar SQL",empresa + " + Error",0);
					}
					
					
					
					RegistroReservacion nvaReserva = new RegistroReservacion(ClienteDAO.retornaID(correoDuplicado, empresa));
					nvaReserva.setVisible(true);
					dispose();
					
					
				}else {
					JOptionPane.showMessageDialog
					(null,"Por Favor llene todos los campos y precione buscar para obtener el numero de cliente",empresa +" - Error en Registro.",0);
				}
				
			}
		};
		
		btnRegistrar.addActionListener(registrar);
		
		JButton btnAtras = new JButton("");
		btnAtras.setBounds(10, 285, 80, 74);
		btnAtras.setToolTipText("Salir");
		btnAtras.setBackground(new Color(240, 240, 240,240));
		btnAtras.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/atras.png")));
		paneRegistro.add(btnAtras);
		
		ActionListener atras = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EligeAccion.main(null);
				dispose();
	
			}
		};
		
		btnAtras.addActionListener(atras);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegistroCliente.class.getResource("/com/hotel/imagenes/registro-hotel.jpg")));
		lblNewLabel.setBounds(-21, 0, 655, 378);
		paneRegistro.add(lblNewLabel);
		

		

		

		
		

	}
}
