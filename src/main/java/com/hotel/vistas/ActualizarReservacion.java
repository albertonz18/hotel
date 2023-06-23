package com.hotel.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.hotel.dao.ReservaDAO;


public class ActualizarReservacion extends JFrame {
	
	
	private static final long serialVersionUID = 1L;


	private JPanel paneReservar;

	
	public String empresa = "Hotel The Peninsula";
	private JTextField txDias;
	private JTextField txTotal;
	
	private Double precio = 1800.00d;
	
	public int dias = 0;
	private JTextField txReservacion;
	private JTextField txCliente;
	

	public ActualizarReservacion( int id,String idCliente, String fechaEntrada,String fechaSalida,String diasR,String total,String formaDePago, String nReservacion) {
		
				
		setTitle(empresa + " - Reservar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 409);
		paneReservar = new JPanel();
		paneReservar.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneReservar);
		paneReservar.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Actualizar Reservacion");
		labelTitulo.setBounds(114, 22, 369, 46);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		paneReservar.add(labelTitulo);
		
		JLabel labelCuadroAcceso = new JLabel("");
		labelCuadroAcceso.setBounds(114, 22, 369, 46);
		labelCuadroAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuadroAcceso.setVerticalAlignment(SwingConstants.TOP);
		labelCuadroAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroAcceso.setBackground(new Color(255, 255, 255,190));
		paneReservar.add(labelCuadroAcceso);
		labelCuadroAcceso.setOpaque(isOpaque());
		
		JDateChooser dateEntrada = new JDateChooser();
		dateEntrada.setDateFormatString("yyyy-MM-dd");
		dateEntrada.setBounds(278, 111, 182, 25);
		paneReservar.add(dateEntrada);
		JDateChooser dateSalida = new JDateChooser();
		dateSalida.setDateFormatString("yyyy-MM-dd");
		dateSalida.setBounds(278, 146, 182, 25);
		paneReservar.add(dateSalida);
		
		
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(508, 285, 80, 74);
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(new Color(240, 240, 240,240));
		btnSalir.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/Salir.png")));
		paneReservar.add(btnSalir);
		
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
		
		JButton btnAtras = new JButton("");
		btnAtras.setBounds(10, 285, 80, 74);
		btnAtras.setToolTipText("Salir");
		btnAtras.setBackground(new Color(240, 240, 240,240));
		btnAtras.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/atras.png")));
		paneReservar.add(btnAtras);
		
		ActionListener atras = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BuscarReserva.main(null);
				dispose();
	
			}
		};
		
		btnAtras.addActionListener(atras);
		
		txDias = new JTextField();
		txDias.setEditable(false);
		txDias.setBounds(278, 181, 182, 25);
		paneReservar.add(txDias);
		txDias.setColumns(10);
		
		txTotal = new JTextField();
		txTotal.setEditable(false);
		txTotal.setColumns(10);
		txTotal.setBounds(278, 216, 182, 25);
		paneReservar.add(txTotal);
		
		JLabel labelTitulo_1 = new JLabel("Fecha de entrada:  ");
		labelTitulo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1.setBackground(new Color(255, 255, 255,190));
		labelTitulo_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1.setBounds(136, 111, 140, 25);
		labelTitulo_1.setOpaque(isOpaque());
		paneReservar.add(labelTitulo_1);
		
		JLabel labelTitulo_1_1 = new JLabel("Fecha de salida:  ");
		labelTitulo_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_1.setOpaque(true);
		labelTitulo_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_1.setBounds(136, 146, 140, 25);
		paneReservar.add(labelTitulo_1_1);
		
		JLabel labelTitulo_1_2 = new JLabel("Dias de Hospedaje:  ");
		labelTitulo_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_2.setOpaque(true);
		labelTitulo_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_2.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_2.setBounds(136, 179, 140, 25);
		paneReservar.add(labelTitulo_1_2);
		
		JLabel labelTitulo_1_3 = new JLabel("Total:  ");
		labelTitulo_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3.setOpaque(true);
		labelTitulo_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3.setBounds(136, 216, 140, 25);
		paneReservar.add(labelTitulo_1_3);
		
		JLabel labelTitulo_1_3_1 = new JLabel("Forma de Pago:  ");
		labelTitulo_1_3_1.setOpaque(true);
		labelTitulo_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3_1.setBounds(136, 250, 140, 25);
		paneReservar.add(labelTitulo_1_3_1);
		
		JLabel labelTitulo_1_3_1_1 = new JLabel("N° de Reservacion:  ");
		labelTitulo_1_3_1_1.setOpaque(true);
		labelTitulo_1_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3_1_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3_1_1.setBounds(136, 284, 140, 25);
		paneReservar.add(labelTitulo_1_3_1_1);
		
		JLabel labelTitulo_1_3_1_1_1 = new JLabel("N° de Cliente:  ");
		labelTitulo_1_3_1_1_1.setOpaque(true);
		labelTitulo_1_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTitulo_1_3_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		labelTitulo_1_3_1_1_1.setBackground(new Color(255, 255, 255, 190));
		labelTitulo_1_3_1_1_1.setBounds(136, 75, 140, 25);
		paneReservar.add(labelTitulo_1_3_1_1_1);
		
		txCliente = new JTextField();
		txCliente.setColumns(10);
		txCliente.setBounds(278, 75, 182, 25);
		paneReservar.add(txCliente);
		
		txCliente.setText(idCliente);
		
		txReservacion = new JTextField();
		txReservacion.setColumns(10);
		txReservacion.setBounds(278, 284, 182, 25);
		
		paneReservar.add(txReservacion);
		
		txReservacion.setText(String.valueOf(ReservaDAO.retornaID(empresa)));
		
		JComboBox<String> boxFPago = new JComboBox<String>();
		boxFPago.setBounds(278, 251, 182, 25);
		boxFPago.addItem("Seleccione Forma de Pago");
		boxFPago.addItem("Efectivo");
		boxFPago.addItem("Tarjeta de Credito");
		boxFPago.addItem("Tranferencia");
		paneReservar.add(boxFPago);
		
		
		txCliente.setText(idCliente);
		dateEntrada.setDate(java.sql.Date.valueOf(fechaEntrada));
		dateSalida.setDate(java.sql.Date.valueOf(fechaSalida));
		txDias.setText(diasR);
		txTotal.setText(total);
		boxFPago.setSelectedItem(formaDePago);
		txReservacion.setText(nReservacion);
		
			
	
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnCalcular.setBackground(new Color(200,150,41));
		btnCalcular.setBounds(136, 327, 148, 32);
		paneReservar.add(btnCalcular);
		btnCalcular.setOpaque(isOpaque());
		
		ActionListener calcular = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(dateEntrada.getDate() != null && dateSalida.getDate() != null) {
					Calendar entrada = dateEntrada.getCalendar();
					Calendar salida = dateSalida.getCalendar();
					dias = -1;
					
					while (entrada.before(salida) || entrada.equals(salida)) {
						dias++;
						entrada.add(Calendar.DATE, 1);									
					}
					
					Double precioHospedaje = (dias*precio);
					
					txDias.setText(String.valueOf(dias));
					txTotal.setText(String.valueOf(precioHospedaje));					
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione Fecha de Salida y Entrada.", empresa + " - Faltan Fechas", 0);
				}
				
				

			}
		};
		
		btnCalcular.addActionListener(calcular);
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnActualizar.setBackground(new Color(200,150,41));
		btnActualizar.setBounds(316, 327, 148, 32);
		paneReservar.add(btnActualizar);
		btnActualizar.setOpaque(isOpaque());
		
		ActionListener reserva = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(dateEntrada.getDate() != null && 
				   dateSalida.getDate() != null && 
				   boxFPago.getSelectedItem() != "Seleccione Forma de Pago" &&
				   txReservacion.getText().length() != 0 &&
				   txDias.getText().length() != 0 &&
				   txTotal.getText().length() != 0) {

					String fEntrada = ((JTextField)dateEntrada.getDateEditor().getUiComponent()).getText();
					String fSalida = ((JTextField)dateSalida.getDateEditor().getUiComponent()).getText();
					String formaPago = String.valueOf(boxFPago.getSelectedItem());
					String diasHospedaje = String.valueOf(txDias.getText());
					String costoTotal = String.valueOf(txTotal.getText());
					String nReserva = txReservacion.getText();
					String nCliente = String.valueOf(txCliente.getText());
		
					
					ReservaDAO.actualizarRegistro(Integer.valueOf(id), nCliente, fEntrada, fSalida, diasHospedaje,costoTotal, formaPago, nReserva);
					BuscarReserva.main(null);
					dispose();

				}else {
					JOptionPane.showMessageDialog(null, "¡Llene todos los datos y presione calcular!", empresa + " - Faltan Fechas", 0);
				}
				
				
			}
		};
		
		btnActualizar.addActionListener(reserva);
		
		JLabel labelFondoReserva = new JLabel("");
		labelFondoReserva.setBounds(-18, 0, 633, 380);
		labelFondoReserva.setIcon(new ImageIcon(ActualizarReservacion.class.getResource("/com/hotel/imagenes/recepcion.png")));
		paneReservar.add(labelFondoReserva);
		



	}
}
