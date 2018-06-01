package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaModelo extends Conector{
	/**
	 * Este metodo sirve para insertar la reserva en la base de datos
	 * @param reserva
	 */
	public void GuardarReserva(Reserva reserva){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO reservas "
					+ "(nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva, luz, id_parcela) VALUES(?,?,?,?,?,?,?,?)");
			
			pst.setString(1, reserva.getNombre_usuario());
			pst.setString(2, reserva.getApellido_usuario());
			pst.setString(3, reserva.getDni_usuario());
			pst.setInt(4, reserva.getNumero_usuarios());
			pst.setDate(5, new java.sql.Date(reserva.getInicio_reserva().getTime()));
			pst.setDate(6, new java.sql.Date(reserva.getFin_reserva().getTime()));
			pst.setBoolean(7, reserva.getLuz());
			pst.setInt(8, reserva.getParcela().getId());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
