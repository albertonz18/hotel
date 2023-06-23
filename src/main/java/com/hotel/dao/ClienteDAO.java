package com.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Cliente;




public class ClienteDAO {
	

	
	

	public static void guardar(Cliente nvoCliente,String empresa,String correoDuplicado, JTextField txNumCliente) {
		
		try {

			
			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			PreparedStatement prepararSentecia = enlazar.prepareStatement
					("INSERT INTO Clientes(Nombre,Apellido,FNacimiento,Correo) Values(?,?,?,?)");
					prepararSentecia.setString(1,nvoCliente.getNombre());
					prepararSentecia.setString(2,nvoCliente.getApellido());
					prepararSentecia.setDate(3,java.sql.Date.valueOf(nvoCliente.getfNacimiento()));
					prepararSentecia.setString(4,nvoCliente.getCorreoCliente());
					prepararSentecia.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registro Correcto de Cliente",empresa +" - ¡Registo Correcto!.",JOptionPane.INFORMATION_MESSAGE);
					
					prepararSentecia.close();
					enlazar.close();
					

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Cliente Duplicado");
			txNumCliente.setText(String.valueOf(ClienteDAO.retornaID(correoDuplicado, empresa)));
			JOptionPane.showMessageDialog(null,"Bienvenido de nuevo " + nvoCliente.getNombre(),empresa +" - ¡Registo Correcto!.",JOptionPane.INFORMATION_MESSAGE);
			e1.printStackTrace();
			
		}	
		
	
	}
	

	
	
	public static String retornaID(Cliente nvoCliente, String empresa) {
		
		String nombre = nvoCliente.getNombre();
		String apellido = nvoCliente.getApellido();
		String FNacimiento = nvoCliente.getfNacimiento();
		String correo = nvoCliente.getCorreoCliente();
		
		String idCliente = null;
		
		try {

			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			String query = "select id from Clientes Where nombre= ?  and apellido=?and FNacimiento=? and Correo=?;";
			PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
			prepararSentecia.setString(1, nombre);
			prepararSentecia.setString(2, apellido);
			prepararSentecia.setString(3, FNacimiento);
			prepararSentecia.setString(4,correo);
			ResultSet resultado = prepararSentecia.executeQuery();
			
			
			while(resultado.next()) {
				idCliente = String.valueOf(resultado.getInt("id"));
				
			}
			
			resultado.close();
			prepararSentecia.close();
			enlazar.close();
			
			
						
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error en Base de Datos", empresa + " - Faltan Fechas", 0);
		}
		
		return idCliente;					
	}
	
public static String retornaID(String correo, String empresa) {
		
	Integer idCliente = null;
	
	try {

		ConnectionFactory conexion = new ConnectionFactory();
		Connection enlazar = conexion.recuperaConexion();
		String query = "select Id from Clientes where Correo='"+correo+"';";
		PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
		ResultSet resultado = prepararSentecia.executeQuery();
				while(resultado.next()) {
			idCliente = resultado.getInt("id");
			
		}
		
		resultado.close();
		prepararSentecia.close();
		enlazar.close();
		
		
					
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null,"Error en Base de Datos", empresa + " - Faltan Fechas", 0);
	}
	
	return String.valueOf(idCliente);					
	}
	
	
public static ArrayList<Cliente> buscarDatos() {
		
		ConnectionFactory conexion = new ConnectionFactory();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente datos;
		
		Connection enlazar;
		try {
			enlazar = conexion.recuperaConexion();
			
			String query = "select id,nombre,apellido,FNacimiento,Correo from clientes;";
			PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
			ResultSet resultado = prepararSentecia.executeQuery();
			
			while(resultado.next()) {
				datos = new Cliente() ;
				datos.setId(Integer.valueOf(resultado.getString("Id")));
				datos.setNombre(resultado.getString("Nombre"));
				datos.setApellido(resultado.getString("Apellido"));
				datos.setCorreoCliente(resultado.getString("Correo"));
				datos.setfNacimiento(resultado.getString("FNacimiento"));
	
				lista.add(datos);
			}
			resultado.close();
			prepararSentecia.close();
			enlazar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return lista;
		
	}


public static ArrayList<Cliente> buscarDatos(String filtro,String parametro) {
	ConnectionFactory conexion = new ConnectionFactory();
	
	ArrayList<Cliente> lista = new ArrayList<Cliente>();
	Cliente datos;
	
	Connection enlazar;
	try {
		enlazar = conexion.recuperaConexion();
		
		String query = "select id,nombre,apellido,FNacimiento,Correo from Clientes WHERE "+filtro+"=?;";
		PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
		prepararSentecia.setString(1, parametro);
		
		
		ResultSet resultado = prepararSentecia.executeQuery();
	
		
		while(resultado.next()) {
			datos = new Cliente() ;
			datos.setId(Integer.valueOf(resultado.getString("Id")));
			datos.setNombre(resultado.getString("Nombre"));
			datos.setApellido(resultado.getString("Apellido"));
			datos.setCorreoCliente(resultado.getString("Correo"));
			datos.setfNacimiento(resultado.getString("FNacimiento"));

			lista.add(datos);
		}
		resultado.close();
		prepararSentecia.close();
		enlazar.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	return lista;
}
public static ArrayList<Cliente> buscarDatos(String filtro,Integer parametro) {
	ConnectionFactory conexion = new ConnectionFactory();
	
	ArrayList<Cliente> lista = new ArrayList<Cliente>();
	Cliente datos;
	
	Connection enlazar;
	try {
		enlazar = conexion.recuperaConexion();
		
		String query = "select id,nombre,apellido,FNacimiento,Correo from Clientes WHERE "+filtro+"="+parametro+";";
		PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
		
		
		ResultSet resultado = prepararSentecia.executeQuery();
	
		
		while(resultado.next()) {
			datos = new Cliente() ;
			datos.setId(Integer.valueOf(resultado.getString("Id")));
			datos.setNombre(resultado.getString("Nombre"));
			datos.setApellido(resultado.getString("Apellido"));
			datos.setCorreoCliente(resultado.getString("Correo"));
			datos.setfNacimiento(resultado.getString("FNacimiento"));

			lista.add(datos);
		}
		resultado.close();
		prepararSentecia.close();
		enlazar.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	return lista;
}



public static void actualizarRegistro(String id,String nombre,String apellido,String fNacimiento, String correo) {
	

	int idCliente = Integer.valueOf(id);
	String nombreCliente = String.valueOf(nombre);
	String apellidoCliente = String.valueOf(apellido);
	Date fNacimientoCliente = java.sql.Date.valueOf(fNacimiento);
	String correoCliente = String.valueOf(correo);
	
	try {

		
		ConnectionFactory conexion = new ConnectionFactory();
		Connection enlazar = conexion.recuperaConexion();
		PreparedStatement prepararSentecia = enlazar.prepareStatement
				("update clientes set nombre=?, apellido=?,fNacimiento=?, Correo=? where id=?;");
				prepararSentecia.setString(1,nombreCliente);
				prepararSentecia.setString(2,apellidoCliente);
				prepararSentecia.setDate(3,fNacimientoCliente);
				prepararSentecia.setString(4,correoCliente);
				prepararSentecia.setInt(5,idCliente);
				prepararSentecia.executeUpdate();
				System.out.println(id+""+nombre+""+apellido+""+fNacimiento+""+correo);
				JOptionPane.showMessageDialog(null,"Se Actualizo el cliente correctamente.","¡Registo Correcto!.",JOptionPane.INFORMATION_MESSAGE);
				

				
				prepararSentecia.close();
				enlazar.close();	

		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1);
		
	
	}					
}
	
public static void eliminar(JTable tableBuscar) {
	int fila = tableBuscar.getSelectedRow();
	
	int id = Integer.parseInt(tableBuscar.getValueAt(fila, 0).toString());

	
	try {

		
		ConnectionFactory conexion = new ConnectionFactory();
		Connection enlazar = conexion.recuperaConexion();
		PreparedStatement prepararSentecia = enlazar.prepareStatement
				("delete from clientes where id=?;");
				prepararSentecia.setInt(1,id);
				prepararSentecia.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Ha Eliminado el Cliente correctamente","¡Eliminacion Correcta!.",JOptionPane.INFORMATION_MESSAGE);

				
				prepararSentecia.close();
				enlazar.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1);

	}					
	

}
	
	
}
	
	

