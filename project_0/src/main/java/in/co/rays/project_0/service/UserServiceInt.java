/*
 * @author Mayank
 */
package in.co.rays.project_0.service;

import java.util.List;

import in.co.rays.project_0.dto.RoleDTO;
import in.co.rays.project_0.dto.UserDTO;
import in.co.rays.project_0.exception.ApplicationException;
import in.co.rays.project_0.exception.DuplicateRecordException;


/**
 * The Interface UserServiceInt.
 */
public interface UserServiceInt {
	
	/**
	 * Adds the.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(UserDTO dto)throws DuplicateRecordException;
	
	/**
	 * Register user.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 * @throws ApplicationException the application exception
	 */
	public long registerUser(UserDTO dto) throws DuplicateRecordException,ApplicationException;

	/**
	 * Update.
	 *
	 * @param dto the dto
	 */
	public void update(UserDTO dto);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(long id);
	
	/**
	 * Find by login.
	 *
	 * @param login the login
	 * @return the user DTO
	 */
	public UserDTO findByLogin(String login);

	/**
	 * Find by PK.
	 *
	 * @param pk the pk
	 * @return the user DTO
	 */
	public UserDTO findByPK(long pk);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(UserDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(UserDTO dto);
	
	/**
	 * Change password.
	 *
	 * @param id the id
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 * @return true, if successful
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public boolean changePassword(Long id, String oldPassword,String newPassword) throws DuplicateRecordException;

	/**
	 * Authenticate.
	 *
	 * @param dto the dto
	 * @return the user DTO
	 */
	public UserDTO authenticate(UserDTO dto);
	
	/**
	 * Lock.
	 *
	 * @param login the login
	 * @return true, if successful
	 */
	public boolean lock(String login);
	
	/**
	 * Reset password.
	 *
	 * @param login the login
	 * @return true, if successful
	 * @throws ApplicationException the application exception
	 */
	public boolean resetPassword(String login) throws ApplicationException;
	
	/**
	 * Forget password.
	 *
	 * @param login the login
	 * @return true, if successful
	 * @throws ApplicationException the application exception
	 */
	public boolean forgetPassword(String login) throws ApplicationException;
	
	/**
	 * Gets the role.
	 *
	 * @param dto the dto
	 * @return the role
	 */
	public RoleDTO getRole(UserDTO dto);
	
	/**
	 * Update access.
	 *
	 * @param dto the dto
	 * @return the user DTO
	 */
	public UserDTO updateAccess(UserDTO dto);
}
