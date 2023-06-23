package com.hotel.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class EligeAccion extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel paneElegir;
	
	public String empresa = "Hotel The Peninsula";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EligeAccion frame = new EligeAccion();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null); 
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EligeAccion() {
		setTitle(empresa + " - Elige Accion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 335);
		paneElegir = new JPanel();
		paneElegir.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneElegir);
		paneElegir.setLayout(null);
		
		JLabel labelTituloAcceso = new JLabel("Elige una Accion.");
		labelTituloAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		labelTituloAcceso.setBounds(93, 52, 369, 46);
		paneElegir.add(labelTituloAcceso);
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(new Color(240, 240, 240,240));
		btnSalir.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/Salir.png")));
		btnSalir.setBounds(480, 211, 80, 74);
		paneElegir.add(btnSalir);
		
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
		
		JButton btnReservar = new JButton("");
		btnReservar.setBackground(new Color(240, 240, 240,240));
		btnReservar.setIcon(new ImageIcon(EligeAccion.class.getResource("/com/hotel/imagenes/Registrar.png")));
		btnReservar.setBounds(164, 128, 80, 74);
		btnReservar.setToolTipText("Crear Reservacion.");
		paneElegir.add(btnReservar);
		
		ActionListener reservar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
							RegistroCliente.main(null);
	         				dispose();
			}								
			};
		
		btnReservar.addActionListener(reservar);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Hacer una Busqueda.");
		btnBuscar.setBackground(new Color(240, 240, 240,240));
		btnBuscar.setIcon(new ImageIcon(EligeAccion.class.getResource("/com/hotel/imagenes/buscar.png")));
		btnBuscar.setBounds(305, 128, 80, 74);
		paneElegir.add(btnBuscar);
		
		ActionListener buscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					EligeBuscar.main(null);
					dispose();								
			}
		};
		
		btnBuscar.addActionListener(buscar);
		
		JButton btnAtras = new JButton("");
		btnAtras.setBounds(10, 211, 80, 74);
		btnAtras.setToolTipText("Salir");
		btnAtras.setBackground(new Color(240, 240, 240,240));
		btnAtras.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/atras.png")));
		paneElegir.add(btnAtras);
		
		ActionListener atras = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Acceso.main(null);
				dispose();
	
			}
		};
		
		btnAtras.addActionListener(atras);

		
		JLabel labelCuadroElegir = new JLabel("");
		labelCuadroElegir.setVerticalAlignment(SwingConstants.TOP);
		labelCuadroElegir.setOpaque(true);
		labelCuadroElegir.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuadroElegir.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroElegir.setBackground(new Color(255, 255, 255, 190));
		labelCuadroElegir.setBounds(93, 52, 369, 46);
		paneElegir.add(labelCuadroElegir);
		
		JLabel labelFondoElegir = new JLabel("");
		labelFondoElegir.setVerticalAlignment(SwingConstants.TOP);
		labelFondoElegir.setIcon(new ImageIcon(EligeAccion.class.getResource("/com/hotel/imagenes/elige_Accion.png")));
		labelFondoElegir.setBounds(0, 0, 570, 296);
		paneElegir.add(labelFondoElegir);
		

		

		

		

	}
}
