package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DelincuenteModel {
	
	private Connection con;
	private Statement instruccion; //Representa la consulta de BD que vamos a lanzar.
	private ResultSet delincuentesSet; //Lista de usuarios en formato Sql
	
	private String todosSql = "select id,nombre,edad,sexo,nacionalidad,direccion,poblacion,antecedentes from delincuentes";
	
	public DelincuenteModel() {
		con = ConexionDB.getConexion();
	}

	public Delincuente[] getDelincuentes() {
		List<Delincuente> delincuentesList = new ArrayList<Delincuente>();
		
		
		try {
			instruccion = con.createStatement();
			delincuentesSet = instruccion.executeQuery(todosSql);						
			
			while(delincuentesSet.next()){
				int id = delincuentesSet.getInt("id");
				String nombre = delincuentesSet.getString("nombre");
				String edad = Integer.toString(delincuentesSet.getInt("edad"));//Convertimos de int a String
				String sexo = delincuentesSet.getString("sexo");
				String nacionalidad = delincuentesSet.getString("nacionalidad");
				String direccion = delincuentesSet.getString("direccion");
				String poblacion = delincuentesSet.getString("poblacion");
				String antecedentes = delincuentesSet.getString("antecedentes");
				
				Delincuente del = new Delincuente(id, nombre, edad, sexo, nacionalidad, direccion, poblacion, antecedentes);
				
				delincuentesList.add(del);
			}
			
			instruccion.close();
			
			return (Delincuente[]) delincuentesList.toArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

	public void salvarAntecedentes(String text) {
		// TODO Programar salvarAntecedentes
		
	}

}
