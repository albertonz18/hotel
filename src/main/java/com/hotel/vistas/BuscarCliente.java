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
import com.hotel.dao.ClienteDAO;
import com.hotel.modelo.Cliente;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel paneBuscar;
	

	String titulo="Buscar";
	
	private JTable tableBuscar;
	private JTextField textField;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente frame = new BuscarCliente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuscarCliente() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 433);
		paneBuscar = new JPanel();
		paneBuscar.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paneBuscar);
		paneBuscar.setLayout(null);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(238, 66, 200, 22);
		paneBuscar.add(textField);
		textField.setColumns(10);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 99, 590, 199);
		paneBuscar.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Clientes", null, scrollPane_1, null);
		
		
		JComboBox<String> comboSelector = new JComboBox<String>();
		comboSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboSelector.getSelectedItem() != "Todos los clientes") {
					textField.setVisible(true);
				}else {
					textField.setVisible(false);
				}
			}
		});

		comboSelector.setBounds(20, 66, 214, 22);
		paneBuscar.add(comboSelector);
		comboSelector.addItem("Todos los clientes");
		comboSelector.addItem("Correo");
		comboSelector.addItem("Numero de Cliente");

		
		
		JButton btnBuscar = new JButton("Buscar");
		
		String titulos [] = {"Cliente","Nombre","Apellido","FNacimiento","Correo"};
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(comboSelector.getSelectedItem() == "Todos los clientes") {
						String info[][]= obtenerDatos();
						
						tableBuscar = new JTable(info,titulos);
						scrollPane_1.setViewportView(tableBuscar);
				}else if(comboSelector.getSelectedItem() == "Correo") {
					String filtroCombo=String.valueOf(comboSelector.getSelectedItem());
					
					String info[][]= obtenerDatos("Correo",String.valueOf(textField.getText()));
						
						tableBuscar = new JTable(info,titulos);
						scrollPane_1.setViewportView(tableBuscar);
						
						System.out.println(String.valueOf(filtroCombo)+"-"+String.valueOf(textField.getText()));

				}else if(comboSelector.getSelectedItem() == "Numero de Cliente") {
					String filtroCombo=String.valueOf(comboSelector.getSelectedItem());
					
					String info[][]= obtenerDatos("Id",Integer.valueOf(textField.getText()));
						
						tableBuscar = new JTable(info,titulos);
						scrollPane_1.setViewportView(tableBuscar);
						
						System.out.println(String.valueOf(filtroCombo)+"-"+String.valueOf(textField.getText()));

				}else {
					System.out.println("ERror");
				}
				
			}
		});
		btnBuscar.setOpaque(true);
		btnBuscar.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		btnBuscar.setBackground(new Color(200, 150, 41));
		btnBuscar.setBounds(462, 62, 148, 32);
		paneBuscar.add(btnBuscar);
		
		
		
		JLabel labelCuadroAcceso = new JLabel("Buscar Clientes");
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
		btnSalir.setBounds(544, 309, 80, 74);
		paneBuscar.add(btnSalir);
		
		ActionListener salir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int confirmado = JOptionPane.showConfirmDialog(null,"¿Confirma que desea Salir?");

						if (JOptionPane.OK_OPTION == confirmado) {
							EligeAccion.main(null);
							dispose();								
						}else {
							
						}
			}
		};
		
		btnSalir.addActionListener(salir);
		
		JButton btnAtras = new JButton("");
		btnAtras.setBounds(10, 309, 80, 74);
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
					ClienteDAO.eliminar(tableBuscar);
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
				String nombre = tableBuscar.getValueAt(fila, 1).toString();
				String apellido = tableBuscar.getValueAt(fila, 2).toString();
				String fNacimiento = tableBuscar.getValueAt(fila, 3).toString();
				String correo = tableBuscar.getValueAt(fila, 4).toString();
				
				try {
					ActualizarCliente actualizar = new ActualizarCliente(id, nombre, apellido,fNacimiento, correo);
					actualizar.setVisible(true);
					dispose();
					
				} catch (Exception errorActualizar) {
					errorActualizar.printStackTrace();
				}
				
				
				
			}
		};
		
		btnActualizar.addActionListener(actualizar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BuscarCliente.class.getResource("/com/hotel/imagenes/cliente.jpg")));
		lblNewLabel.setBounds(-21, 0, 655, 394);
		paneBuscar.add(lblNewLabel);
		

		


	}


	private String[][] obtenerDatos() {
		

		ArrayList<Cliente> lista = ClienteDAO.buscarDatos(); 
		
	String matrizInfo[][] = new String[lista.size()][5];
		
		for (int i=0; i < lista.size(); i++) {
			matrizInfo[i][0]=String.valueOf(lista.get(i).getId());
			matrizInfo[i][1]=lista.get(i).getNombre();
			matrizInfo[i][2]=lista.get(i).getApellido();
			matrizInfo[i][3]=lista.get(i).getfNacimiento();
			matrizInfo[i][4]=lista.get(i).getCorreoCliente();
			
		}
		
		return matrizInfo;
		
	
	}
	
	private String[][] obtenerDatos(String filtro,String parametro) {
		
	ArrayList<Cliente> lista = ClienteDAO.buscarDatos(filtro, parametro); 
		
	String matrizInfo[][] = new String[lista.size()][5];
		
		for (int i=0; i < lista.size(); i++) {
			matrizInfo[i][0]=String.valueOf(lista.get(i).getId());
			matrizInfo[i][1]=lista.get(i).getNombre();
			matrizInfo[i][2]=lista.get(i).getApellido();
			matrizInfo[i][3]=lista.get(i).getfNacimiento();
			matrizInfo[i][4]=lista.get(i).getCorreoCliente();
		}
		
		return matrizInfo;
	}
private String[][] obtenerDatos(String filtro,Integer parametro) {
		
	ArrayList<Cliente> lista = ClienteDAO.buscarDatos(filtro, parametro); 
		
	String matrizInfo[][] = new String[lista.size()][5];
		
		for (int i=0; i < lista.size(); i++) {
			matrizInfo[i][0]=String.valueOf(lista.get(i).getId());
			matrizInfo[i][1]=lista.get(i).getNombre();
			matrizInfo[i][2]=lista.get(i).getApellido();
			matrizInfo[i][3]=lista.get(i).getfNacimiento();
			matrizInfo[i][4]=lista.get(i).getCorreoCliente();
		}
		
		if(lista.size()==0) {
			JOptionPane.showMessageDialog(null,"No hay registros con esos parametros.","Sin Datos" , 0);;
		}
		
		return matrizInfo;
	}
	
	public void actualizarDatos(JTable tabla) {
		
	}
	
	
}
