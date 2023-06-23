package com.hotel.funciones;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calcular {
	
	public Calcular(Date fechaEntrada, Date fechaSalida, Calendar entrada, Calendar salida,JTextField txHospedaje,JTextField txTotal,String empresa) {

		int dias = 0;
		Double precio = 1800.00d;
		
		if(fechaEntrada != null && fechaSalida != null) {
			
			dias = -1;
			
			while (entrada.before(salida) || entrada.equals(salida)) {
				dias++;
				entrada.add(Calendar.DATE, 1);									
			}
			
			Double precioHospedaje = (dias*precio);
			
			txHospedaje.setText(String.valueOf(dias));
			txTotal.setText(String.valueOf(precioHospedaje));					
		}else {
			JOptionPane.showMessageDialog(null, "Seleccione Fecha de Salida y Entrada.", empresa + " - Faltan Fechas", 0);
		}
		
	};


}
