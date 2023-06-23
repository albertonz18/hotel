package com.hotel.vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;


	private JPanel paneBienvenida;
	
	
	public String empresa = "Hotel The Peninsula";


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Bienvenida() {
		setTitle(empresa + " - Bienvenido.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 380);
		paneBienvenida = new JPanel();
		paneBienvenida.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneBienvenida);
		paneBienvenida.setLayout(null);
		
		JLabel labelTituloAcceso = new JLabel("<html><center>Bienvenido<p>" + empresa + "</html>");
		labelTituloAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelTituloAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		labelTituloAcceso.setBounds(114, 97, 369, 62);
		paneBienvenida.add(labelTituloAcceso);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Bienvenida.class.getResource("/com/hotel/imagenes/Ingresar.png")));
		btnNewButton.setBounds(249, 169, 97, 94);
		paneBienvenida.add(btnNewButton);
		
		ActionListener ingresar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Acceso.main(null);
				dispose();
				
			}
		};
		
		btnNewButton.addActionListener(ingresar);
		
		JLabel labelCuadroAcceso = new JLabel("");
		labelCuadroAcceso.setVerticalAlignment(SwingConstants.TOP);
		labelCuadroAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroAcceso.setBackground(new Color(255, 255, 255,190));
		labelCuadroAcceso.setBounds(114, 90, 369, 209);
		paneBienvenida.add(labelCuadroAcceso);
		labelCuadroAcceso.setOpaque(isOpaque());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bienvenida.class.getResource("/com/hotel/imagenes/Exterior.jpg")));
		lblNewLabel.setBounds(0, 0, 614, 349);
		paneBienvenida.add(lblNewLabel);
		

	}

}
