package com.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.DatosReserva;
import com.hotel.vistas.EligeAccion;

public class ReservaDAO {

	public static void guardar(DatosReserva nvaReserva,Integer numCliente, String empresa) {
		try {
			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			PreparedStatement prepararSentecia = enlazar.prepareStatement
					("INSERT INTO Reservaciones(FechaEntrada,FechaSalida,FormaDePago,Dias,Total,NumReservacion,Cliente) Values(?,?,?,?,?,?,?)");
					prepararSentecia.setDate(1,java.sql.Date.valueOf(nvaReserva.getFechaEntrada()));
					prepararSentecia.setDate(2,java.sql.Date.valueOf(nvaReserva.getFechaSalida()));
					prepararSentecia.setString(3,nvaReserva.getFormaDePago());
					prepararSentecia.setInt(4,nvaReserva.getDiasHospedaje());
					prepararSentecia.setDouble(5,nvaReserva.getCostoHospedaje());
					prepararSentecia.setString(6,nvaReserva.getnReservacion());
					prepararSentecia.setInt(7,numCliente);
					prepararSentecia.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registro Correcto",empresa +" - ¡Reserva Correcta!.",JOptionPane.INFORMATION_MESSAGE);
					EligeAccion.main(null);
					System.out.println("Captura de datosReserva Correcto!");
					
					
					prepararSentecia.close();
					enlazar.close();
					
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error en Base de Datos", empresa + " - Faltan Fechas", 0);
		}	
	
	}
	
	public static Integer retornaID( String empresa) {
		
		Integer idReserva = null;
		
		try {

			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			String query = "select max(id) from reservaciones;";
			PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
			ResultSet resultado = prepararSentecia.executeQuery();
			
			while(resultado.next()) {
				idReserva = resultado.getInt("max(id)");
				
			}
			
			resultado.close();
			prepararSentecia.close();
			enlazar.close();
			
			
						
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error en Base de Datos", empresa + " - Faltan Fechas", 0);
		}
		
		return idReserva+1;					
	}
	
	
	public static ArrayList<DatosReserva> buscarDatos() {
		
		ConnectionFactory conexion = new ConnectionFactory();
		
		ArrayList<DatosReserva> lista = new ArrayList<DatosReserva>();
		DatosReserva datos;
		
		Connection enlazar;
		try {
			enlazar = conexion.recuperaConexion();
			
			String query = "select id, FechaEntrada,FechaSalida,FormaDePago,Dias,Total,NumReservacion,Cliente from reservaciones;";
			PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
			ResultSet resultado = prepararSentecia.executeQuery();
			
			while(resultado.next()) {
				datos = new DatosReserva() ;
				datos.setId((resultado.getInt("id")));
				datos.setnReservacion((resultado.getString("NumReservacion")));
				datos.setCliente(resultado.getInt("Cliente"));
				datos.setFechaEntrada(resultado.getString("FechaEntrada"));
				datos.setFechaSalida(resultado.getString("FechaSalida"));
				datos.setFormaDePago(resultado.getString("FormaDePago"));
				datos.setDiasHospedaje(resultado.getInt("Dias"));
				datos.setCostoHospedaje(resultado.getDouble("Total"));
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

	public static ArrayList<DatosReserva> buscarDatos(String filtro,String parametro) {
		
		ConnectionFactory conexion = new ConnectionFactory();
		
		ArrayList<DatosReserva> lista = new ArrayList<DatosReserva>();
		DatosReserva datos;
		
		Connection enlazar;
		try {
			enlazar = conexion.recuperaConexion();
			
			String query = "select id, FechaEntrada,FechaSalida,FormaDePago,Dias,Total,NumReservacion,Cliente from reservaciones where "+filtro+"='"+parametro+"';";
			PreparedStatement prepararSentecia = enlazar.prepareStatement(query);
			ResultSet resultado = prepararSentecia.executeQuery();
			
			while(resultado.next()) {
				datos = new DatosReserva() ;
				datos.setId((resultado.getInt("id")));
				datos.setnReservacion((resultado.getString("id")));
				datos.setnReservacion((resultado.getString("NumReservacion")));
				datos.setCliente(resultado.getInt("Cliente"));
				datos.setFechaEntrada(resultado.getString("FechaEntrada"));
				datos.setFechaSalida(resultado.getString("FechaSalida"));
				datos.setFormaDePago(resultado.getString("FormaDePago"));
				datos.setDiasHospedaje(resultado.getInt("Dias"));
				datos.setCostoHospedaje(resultado.getDouble("Total"));
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
	
	public static void eliminar(JTable tableBuscar) {
		int fila = tableBuscar.getSelectedRow();
		
		int id = Integer.parseInt(tableBuscar.getValueAt(fila, 0).toString());

		
		try {

			
			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			PreparedStatement prepararSentecia = enlazar.prepareStatement
					("delete from Reservaciones where id=?;");
					prepararSentecia.setInt(1,id);
					prepararSentecia.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Ha Eliminado el registro correctamente.","¡Eliminacion Correcta!.",JOptionPane.INFORMATION_MESSAGE);
					
					prepararSentecia.close();
					enlazar.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);

		}					
	}
	
	public static void actualizarRegistro(int id,String idCliente,String fechaEntrada,String fechaSalida,String dias,String costo, String fPago, String nReserva) {
		
		int idReserva = Integer.valueOf(id);
		int idClienteReserva = Integer.valueOf(idCliente);
		Date fechaEntradaReserva = java.sql.Date.valueOf(fechaEntrada);
		Date fechaSalidaReserva = java.sql.Date.valueOf(fechaSalida);
		Integer diasReserva = Integer.valueOf(dias);
		Double costoReserva = Double.valueOf(costo);
		String fPagoReserva = String.valueOf(fPago);
		String nReservaReserva = String.valueOf(nReserva);
		
		try {

			
			ConnectionFactory conexion = new ConnectionFactory();
			Connection enlazar = conexion.recuperaConexion();
			PreparedStatement prepararSentecia = enlazar.prepareStatement
					("update Reservaciones set FechaEntrada=?, FechaSalida=?,FormaDePago=?, Dias=?, Total=?,NumReservacion=?,Cliente=? where id=?;");
					prepararSentecia.setDate(1,fechaEntradaReserva);
					prepararSentecia.setDate(2,fechaSalidaReserva);
					prepararSentecia.setString(3,fPagoReserva);
					prepararSentecia.setInt(4,diasReserva);
					prepararSentecia.setDouble(5,costoReserva);
					prepararSentecia.setString(6,nReservaReserva);
					prepararSentecia.setInt(7,idClienteReserva);
					prepararSentecia.setInt(8,idReserva);
					prepararSentecia.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Se Actualizo la reservacion correctamente.","¡Actualizacion Correcta!.",JOptionPane.INFORMATION_MESSAGE);
					
					
					prepararSentecia.close();
					enlazar.close();
					

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			
		
		}					
	}


}
