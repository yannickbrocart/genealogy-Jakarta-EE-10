/**
 * 
 */
package com.yannickbrocart.genealogy.ddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class Ddb {

	private static Connection connection = null;
		
	/**
	 * @return Connection
	 */
	public static Connection getConnection() {
		if (connection == null) {
			try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/genealogy?serverTimezone=UTC", "root", "P@ssw0rd");
			} catch (SQLException e) {
				 throw new DdbException(e.getMessage());
			}
		}
		return connection;
	}
	
	/**
	 * @return void
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            throw new DdbException(e.getMessage());
	        }
	    }
	}
	
	/**
	 * @return void
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
	        try {
	        	resultSet.close();
	        } catch (SQLException e) {
	            throw new DdbException(e.getMessage());
	        }
	    }
	}
	
	/**
	 * @return void
	 */
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
	        try {
	        	preparedStatement.close();
	        } catch (SQLException e) {
	            throw new DdbException(e.getMessage());
	        }
	    }
	}
	
	/**
	 * @return void
	 */
	public static void closeStatement(Statement statement) {
		if (statement != null) {
	        try {
	        	statement.close();
	        } catch (SQLException e) {
	            throw new DdbException(e.getMessage());
	        }
	    }
	}
}