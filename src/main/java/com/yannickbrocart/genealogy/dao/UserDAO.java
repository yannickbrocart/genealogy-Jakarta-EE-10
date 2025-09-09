/**
 * 
 */
package com.yannickbrocart.genealogy.dao;

import java.util.List;
import java.util.Optional;

import com.yannickbrocart.genealogy.bean.User;

/**
 * UserDAO
 */
public interface UserDAO {
	
	/**
	 * @return boolean
	 */
    public boolean createUser(User user);
	
    /**
	 * @return Optional<User>
	 */
    public Optional<User> findUserById(long id);
	
	/**
	 * @return List<User>
	 */
	public List<User> findUsersBy(String attribute);
	
	/**
	 * @return List<User>
	 */
	public List<User> findAllUsers();
	
	/**
	 * @return boolean
	 */
	public boolean updateUser(long id, User user);
	
	/**
	 * @return boolean
	 */
	public boolean deleteUser(long id);
	
}