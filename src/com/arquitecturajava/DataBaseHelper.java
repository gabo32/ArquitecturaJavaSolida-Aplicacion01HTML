package com.arquitecturajava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/arquitecturajava";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	public int modificarRegistro(String consultaSQL){
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		try{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			if(sentencia != null){
				try{
					sentencia.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			if(conexion != null){
				try{
					conexion.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		
		return filasAfectadas;
	}
	
	public ResultSet seleccionarRegistros(String consultaSQL){
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		try{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			if(sentencia != null){
				try{
					sentencia.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			if(conexion != null){
				try{
					conexion.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		
		return filas;
	}
}
