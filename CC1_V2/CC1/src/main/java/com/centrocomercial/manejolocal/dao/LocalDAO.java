package com.centrocomercial.manejolocal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.centrocomercial.manejolocal.modelo.Local;

public class LocalDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/centrocomercial1?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Myeasypass.1!";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO locales" + "  (numero, nombre, tamano, vendeComida, ventas) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select numero,nombre,tamano,vendeComida,ventas from locales where numero =?";
	private static final String SELECT_ALL_USERS = "select * from locales";
	private static final String DELETE_USERS_SQL = "delete from locales where numero = ?;";
	private static final String UPDATE_USERS_SQL = "update locales set nombre =?, tamano =?, vendeComida =?, ventas =? where numero =?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertLocal(Local local) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
					preparedStatement.setString(1, local.getNumero());
					preparedStatement.setString(2, local.getNombre());
					preparedStatement.setString(3, local.getTamaño());
					preparedStatement.setString(4, local.getVendeComida());
					preparedStatement.setString(5, local.getVentas());
					
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Local selectLocal(String numero) {
		Local local = null;
		try (Connection connection = getConnection();	
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, numero);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();	
			while (rs.next()) {				
				String nombre = rs.getString("nombre");
				//String number = rs.getString("numero");
				String tamaño = rs.getString("tamano");
				String vendeComida = rs.getString("vendeComida");
				String ventas = rs.getString("ventas");
				local = new Local(nombre, numero, tamaño, vendeComida, ventas);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return local;
	}
	
	public List<Local> selectAllLocales() {

		List<Local> locales = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String number = rs.getString("numero");
				String tamaño = rs.getString("tamano");
				String vendeComida = rs.getString("vendeComida");
				String ventas = rs.getString("ventas");
				locales.add(new Local(nombre, number, tamaño, vendeComida, ventas));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return locales;
	}
	
	public boolean deleteLocal(String numero) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, numero);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateLocal(Local local) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, local.getNombre());
			statement.setString(2, local.getTamaño());
			statement.setString(3, local.getVendeComida());
			statement.setString(4, local.getVentas());
			statement.setString(5, local.getNumero());
			System.out.println(statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
