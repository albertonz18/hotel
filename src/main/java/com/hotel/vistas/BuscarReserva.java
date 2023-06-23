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
import com.hotel.dao.ReservaDAO;
import com.hotel.modelo.DatosReserva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BuscarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel paneBuscar;
	

	String titulo="Buscar";
	
	private JTable tableBuscar;
	private JTextField txCampoBuscar;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarReserva frame = new BuscarReserva();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuscarReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 417);
		paneBuscar = new JPanel();
		paneBuscar.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneBuscar);
		paneBuscar.setLayout(null);
		
		txCampoBuscar = new JTextField();
		txCampoBuscar.setVisible(false);
		txCampoBuscar.setBounds(238, 66, 214, 22);
		paneBuscar.add(txCampoBuscar);
		txCampoBuscar.setColumns(10);
		
		
		JComboBox<String> boxFPago = new JComboBox<String>();
	
		boxFPago.setBounds(238, 66, 214, 22);
		boxFPago.addItem("Seleccione Forma de Pago");
		boxFPago.addItem("Efectivo");
		boxFPago.addItem("Tarjeta de Credito");
		boxFPago.addItem("Tranferencia");
		paneBuscar.add(boxFPago);
		boxFPago.setVisible(false);
		

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 99, 590, 191);
		paneBuscar.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane_1, null);
		
		JComboBox<String> comboSelector = new JComboBox<String>();
		comboSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				tabbedPane.setTitleAt(0, String.valueOf(comboSelector.getSelectedItem()));
				
				if(comboSelector.getSelectedItem() == "FormaDePago") {
					boxFPago.setVisible(true);					
					txCampoBuscar.setVisible(false);
					;
					
				}else if(comboSelector.getSelectedItem() == "Todas las Reservaciones" && comboSelector.getSelectedItem() == "Seleccione Busqueda" ){
					boxFPago.setVisible(false);					
					txCampoBuscar.setVisible(false);
					txCampoBuscar.setText("");
					
				}else {
				
					txCampoBuscar.setVisible(true);					
					boxFPago.setVisible(false);					
				}

			}
		});

		comboSelector.setBounds(20, 66, 214, 22);
		paneBuscar.add(comboSelector);
		comboSelector.addItem("Todas las Reservaciones");
		comboSelector.addItem("NumReservacion");
		comboSelector.addItem("Cliente");
		comboSelector.addItem("FormaDePago");
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setOpaque(true);
		btnBuscar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnBuscar.setBackground(new Color(200, 150, 41));
		btnBuscar.setBounds(462, 62, 148, 32);
		paneBuscar.add(btnBuscar);
		String titulos [] = {"id","NumReservacion", "Cliente", "FechaEntrada", "FechaSalida", "Dias", "Total","FormaDePago"};
		ActionListener buscar = new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(comboSelector.getSelectedItem() == "Todas las Reservaciones") {
					
					String info[][]= obtenerDatos();
					
					tableBuscar = new JTable(info,titulos);
					scrollPane_1.setViewportView(tableBuscar);
					
					}else {
						
						if(comboSelector.getSelectedItem()=="FormaDePago") {
							String info[][]= obtenerDatosFiltro(String.valueOf(comboSelector.getSelectedItem()),String.valueOf(boxFPago.getSelectedItem()));
							
							
							tableBuscar = new JTable(info,titulos);
							scrollPane_1.setViewportView(tableBuscar);
						}else {
							
							String info[][]= obtenerDatosFiltro(String.valueOf(comboSelector.getSelectedItem()),String.valueOf(txCampoBuscar.getText()));
							
							tableBuscar = new JTable(info,titulos);
							scrollPane_1.setViewportView(tableBuscar);
								
						}
						
					}
				
			}
		};
		
		btnBuscar.addActionListener(buscar);
		
		
		
		JLabel labelCuadroAcceso = new JLabel("Buscar Reservaciones");
		labelCuadroAcceso.setBounds(114, 5, 369, 46);
		labelCuadroAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		labelCuadroAcceso.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		labelCuadroAcceso.setBackground(new Color(255, 255, 255,190));
		paneBuscar.add(labelCuadroAcceso);
		labelCuadroAcceso.setOpaque(isOpaque());
		
		JButton btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(new Color(240, 240, 240,240));
		btnSalir.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/Salir.png")));
		btnSalir.setBounds(544, 293, 80, 74);
		paneBuscar.add(btnSalir);
		
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
		btnAtras.setBounds(10, 293, 80, 74);
		btnAtras.setToolTipText("Salir");
		btnAtras.setBackground(new Color(240, 240, 240,240));
		btnAtras.setIcon(new ImageIcon(Acceso.class.getResource("/com/hotel/imagenes/atras.png")));
		paneBuscar.add(btnAtras);
		
		ActionListener atras = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EligeBuscar.main(null);
				dispose();
	
			}
		};
		
		btnAtras.addActionListener(atras);
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnBorrar.setBackground(new Color(200,150,41));
		btnBorrar.setBounds(207, 335, 148, 32);
		paneBuscar.add(btnBorrar);
		btnBorrar.setOpaque(isOpaque());
		
		ActionListener borrar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "¿Desea borrar el registro, esta accion no se puede deshacer")==JOptionPane.OK_OPTION) {
					ReservaDAO.eliminar(tableBuscar);
					String info[][]= obtenerDatos();
					
					tableBuscar = new JTable(info,titulos);
					scrollPane_1.setViewportView(tableBuscar);
				}
			}
		};
		
		btnBorrar.addActionListener(borrar);
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnActualizar.setBackground(new Color(200,150,41));
		btnActualizar.setBounds(374, 335, 148, 32);
		paneBuscar.add(btnActualizar);
		btnActualizar.setOpaque(isOpaque());
		
		ActionListener actualizar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int fila = tableBuscar.getSelectedRow();
				
				int id = Integer.parseInt(tableBuscar.getValueAt(fila, 0).toString());
				String numReservacion = tableBuscar.getValueAt(fila, 1).toString();
				String cliente = tableBuscar.getValueAt(fila, 2).toString();
				String fechaEntrada = tableBuscar.getValueAt(fila, 3).toString();
				String fechaSalida = tableBuscar.getValueAt(fila, 4).toString();
				String dias = tableBuscar.getValueAt(fila, 5).toString();
				String total = tableBuscar.getValueAt(fila, 6).toString();
				String fPago = tableBuscar.getValueAt(fila, 7).toString();
				
				ActualizarReservacion actualizarReserva = new ActualizarReservacion(id, cliente, fechaEntrada, fechaSalida, dias, total, fPago, numReservacion);
				actualizarReserva.setVisible(true);
				dispose();
				
			}
		};
		
		btnActualizar.addActionListener(actualizar);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuscarReserva.class.getResource("/com/hotel/imagenes/registro-hotel.jpg")));
		lblNewLabel.setBounds(-21, 0, 655, 378);
		paneBuscar.add(lblNewLabel);
		

		


	}
	


	private String[][] obtenerDatos() {
		
		
		ArrayList<DatosReserva> lista = ReservaDAO.buscarDatos(); 
		
		String matrizInfo[][] = new String[lista.size()][8];
		
		for (int i=0; i < lista.size(); i++) {
			matrizInfo[i][0]=lista.get(i).getId()+"";
			matrizInfo[i][1]=lista.get(i).getnReservacion()+"";
			matrizInfo[i][2]=lista.get(i).getCliente()+"";
			matrizInfo[i][3]=lista.get(i).getFechaEntrada()+"";
			matrizInfo[i][4]=lista.get(i).getFechaSalida()+"";
			matrizInfo[i][5]=lista.get(i).getDiasHospedaje()+"";
			matrizInfo[i][6]=lista.get(i).getCostoHospedaje()+"";
			matrizInfo[i][7]=lista.get(i).getFormaDePago()+"";
		}
		
		return matrizInfo;
	}
	
	private String[][] obtenerDatosFiltro(String filtro,String parametro) {
		
		
		ArrayList<DatosReserva> lista = ReservaDAO.buscarDatos(filtro,parametro); 
		
		String matrizInfo[][] = new String[lista.size()][8];
		
		for (int i=0; i < lista.size(); i++) {
			matrizInfo[i][0]=lista.get(i).getId()+"";
			matrizInfo[i][1]=lista.get(i).getnReservacion()+"";
			matrizInfo[i][2]=lista.get(i).getCliente()+"";
			matrizInfo[i][3]=lista.get(i).getFechaEntrada()+"";
			matrizInfo[i][4]=lista.get(i).getFechaSalida()+"";
			matrizInfo[i][5]=lista.get(i).getDiasHospedaje()+"";
			matrizInfo[i][6]=lista.get(i).getCostoHospedaje()+"";
			matrizInfo[i][7]=lista.get(i).getFormaDePago()+"";
		}
		
		if(lista.size()==0) {
			JOptionPane.showMessageDialog(null,"No hay registros con esos parametros.","Sin Datos" , 0);;
		}
			return matrizInfo ;
		
			
		
	}
	
}
