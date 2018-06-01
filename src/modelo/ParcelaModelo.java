package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ParcelaModelo extends Conector {
	
	/**
	 * Este metodo recoge todas las parcelas de la tabla parcelas que estan almacenadas en la base de datos y mete en un arrayList para luego devolverlo
	 * @return parcelas
	 */
	
	public ArrayList<Parcela> selectAll(){
		
		try {
			ArrayList<Parcela> parcelas = new ArrayList();
			Statement st = super.conexion.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM parcelas");
			
			while(rs.next()){
				Parcela parcela = new Parcela();
				
				parcela.setId(rs.getInt("id"));
				parcela.setNumero(rs.getString("numero"));
				parcela.setM_cuadrados(rs.getInt("m_cuadrados"));
				parcela.setPrecio_dia(rs.getDouble("precio_dia"));
				
				parcelas.add(parcela);
			}
			
			return parcelas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Este metodo recoge de la tabla parcelas la parcela correspondiente segun el id de parcela que reciba por parametro
	 * @param id_parcela
	 * @return parcela
	 */
	
	public Parcela selectPorId(int id_parcela){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM parcelas WHERE id = ?");
			
			pst.setInt(1, id_parcela);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Parcela parcela = new Parcela();
				parcela.setId(id_parcela);
				parcela.setM_cuadrados(rs.getInt("m_cuadrados"));
				parcela.setNumero(rs.getString("numero"));
				parcela.setPrecio_dia(rs.getDouble("precio_dia"));
				
				return parcela;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	
		
	}

}
