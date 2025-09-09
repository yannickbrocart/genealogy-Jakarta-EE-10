/**
 * 
 */
package com.yannickbrocart.genealogy.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.Genealogy;
import com.yannickbrocart.genealogy.bean.User;
import com.yannickbrocart.genealogy.bean.enums.GenealogyStatusType;
import com.yannickbrocart.genealogy.dao.GenealogyDAO;
import com.yannickbrocart.genealogy.ddb.Ddb;

/**
 * GenealogyDAOJdbcImpl
 */
public class GenealogyDaoJdbcImpl implements GenealogyDAO {

	private Connection connection;
	private	ResultSet resultSet;
	private PreparedStatement preparedStatement;
	List<Genealogy> genealogies = new ArrayList<>();
	
	private static final String INSERT_GENEALOGY =
			"INSERT INTO genealogy (genealogy.id, name, creation_time, last_access_time, last_modified_time, created_by_id, last_modified_by_id, status) "
	      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_GENEALOGY_BY_ID = 
			"SELECT genealogy.id, name, creation_time, last_access_time, last_modified_time, created_by_id, last_modified_by_id, status, "
		  + "creator.fistname, creator.lastname, creator.username, creator.email, creator.registration_date, creator.role, creator.is_verified, " 
		  + "modifier.fistname, modifier.lastname, modifier.username, modifier.email, modifier.registration_date, modifier.role, modifier.is_verified "
		  + "FROM genealogy "
		  + "INNER JOIN user AS creator  ON genealogy.created_by_id = creator.id "
		  + "INNER JOIN user AS modifier ON genealogy.last_modified_by_id = modifier.id"
		  + "WHERE genealogy.id = ?";
	private static final String SELECT_GENEALOGY_BY =
		    "SELECT genealogy.id, name, creation_time, last_access_time, last_modified_time, created_by_id, last_modified_by_id, status, "
		  + "creator.firstname, creator.lastname, creator.username, creator.email, creator.registration_date, creator.roles, creator.is_verified, " 
		  + "modifier.firstname, modifier.lastname, modifier.username, modifier.email, modifier.registration_date, modifier.roles, modifier.is_verified "
		  + "FROM genealogy "
		  + "INNER JOIN user AS creator  ON genealogy.created_by_id = creator.id "
		  + "INNER JOIN user AS modifier ON genealogy.last_modified_by_id = modifier.id"
		  + "WHERE ? = ?";
	private static final String SELECT_ALL_GENEALOGIES =
		  	"SELECT genealogy.id, name, creation_time, last_access_time, last_modified_time, created_by_id, last_modified_by_id, status, "
		  + "creator.firstname, creator.lastname, creator.username, creator.email, creator.registration_date, creator.roles, creator.is_verified, " 
		  + "modifier.firstname, modifier.lastname, modifier.username, modifier.email, modifier.registration_date, modifier.roles, modifier.is_verified "
		  + "FROM genealogy "
		  + "INNER JOIN user AS creator  ON genealogy.created_by_id = creator.id "
		  + "INNER JOIN user AS modifier ON genealogy.last_modified_by_id = modifier.id";
	private static final String UPDATE_GENEALOGY =
		    "UPDATE genealogy SET name = ?, creation_time = ?, last_access_time = ?, last_modified_time = ?, created_by_id = ?, "
		  + "last_modified_by_id = ?, status = ? "
		  + "WHERE genealogy.id = ?";
	private static final String DELETE_GENEALOGY =
	   		"DELETE FROM genealogy WHERE genealogy.id = ?";
	
	public GenealogyDaoJdbcImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean createGenealogy(Genealogy genealogy) {
		return false;
	}

	@Override
	public Optional<Genealogy> findGenealogyById(long id) {
		return Optional.empty();
	}

	@Override
	public List<Genealogy> findGenealogiesBy(String attribute) {
		return null;
	}

	@Override
	public List<Genealogy> findAllGenealogies() {
		try {
			preparedStatement = connection.prepareStatement(SELECT_ALL_GENEALOGIES);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				User creatorUser = new User();
				User modifierUser = new User();
				Genealogy genealogy = new Genealogy();
				
				genealogy.setId(resultSet.getLong(1));
				genealogy.setName(resultSet.getString(2));
				genealogy.setCreationTime(resultSet.getObject(3, LocalDateTime.class));
				genealogy.setLastAccessTime(resultSet.getObject(4, LocalDateTime.class));
				genealogy.setLastModifiedTime(resultSet.getObject(5, LocalDateTime.class));
				creatorUser.setLogin(resultSet.getString(9));
				genealogy.setCreatedBy(creatorUser);				
				modifierUser.setLogin(resultSet.getString(10));
				genealogy.setLastModifiedBy(modifierUser);				
				genealogy.setStatus(GenealogyStatusType.valueOf(resultSet.getString(8).toUpperCase()));
				genealogies.add(genealogy);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
//			Ddb.closeConnection(connection);
			Ddb.closePreparedStatement(preparedStatement);
			Ddb.closeResultSet(resultSet);
		}
		return genealogies;
	}

	@Override
	public boolean updateGenealogy(long id, Genealogy genealogy) {
		return false;
	}

	@Override
	public boolean deleteGenealogy(long id) {
		return false;
	}

}
