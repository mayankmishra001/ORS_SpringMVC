/*
 * @author Mayank
 */
package in.co.rays.project_0.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class UserDTO.
 */
@Entity
@Table(name="st_user")
public class UserDTO extends BaseDTO {

	
	 /** The Constant ACTIVE. */
 	public static final String ACTIVE = "Active";
	 
	 /** The Constant INACTIVE. */
 	public static final String INACTIVE = "Inactive";
	
	/** The first name. */
	@Column(name="FIRST_NAME",length=50)
	private String firstName;
	
	/** The last name. */
	@Column(name="LAST_NAME",length=50)
    private String lastName;
	
	/** The login. */
	@Column(name="LOGIN",length=50)
	private String login;
	
	/** The password. */
	@Column(name="PASSWORD",length=50)
	private String password;
	
	/** The confirm password. */
	@Column(name="CONFIRM_PASSWORD",length=50)
	private String confirmPassword;
	
	/** The dob. */
	@Column(name="DOB")
	private Date dob;
	
	/** The mobile no. */
	@Column(name="MOBILE_NO",length=15)
	private String mobileNo;
	
	/** The role id. */
	@Column(name="ROLE_ID")
	private long roleId;
	
	/** The un successful login. */
	@Column(name = "UNSUCCESSFUL_LOGIN")
    private int unSuccessfulLogin;
	
	/** The gender. */
	@Column(name="GENDER",length=10)
	private String gender;
	
	/** The last login. */
	@Column(name = "LAST_LOGIN", length = 50)
    private Timestamp lastLogin;
	
	/** The lock. */
	@Column(name = "USER_LOCK", length = 10)
    private String lock = INACTIVE;
	
	/** The registered IP. */
	@Column(name = "REGISTERED_IP", length = 20)
    private String registeredIP;
	
	/** The last login IP. */
	@Column(name = "LAST_LOGIN_IP", length = 20)
    private String lastLoginIP;

	
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the confirm password.
	 *
	 * @return the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the un successful login.
	 *
	 * @return the un successful login
	 */
	public int getUnSuccessfulLogin() {
		return unSuccessfulLogin;
	}

	/**
	 * Sets the un successful login.
	 *
	 * @param unSuccessfulLogin the new un successful login
	 */
	public void setUnSuccessfulLogin(int unSuccessfulLogin) {
		this.unSuccessfulLogin = unSuccessfulLogin;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Gets the lock.
	 *
	 * @return the lock
	 */
	public String getLock() {
		return lock;
	}

	/**
	 * Sets the lock.
	 *
	 * @param lock the new lock
	 */
	public void setLock(String lock) {
		this.lock = lock;
	}

	/**
	 * Gets the registered IP.
	 *
	 * @return the registered IP
	 */
	public String getRegisteredIP() {
		return registeredIP;
	}

	/**
	 * Sets the registered IP.
	 *
	 * @param registeredIP the new registered IP
	 */
	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	/**
	 * Gets the last login IP.
	 *
	 * @return the last login IP
	 */
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	/**
	 * Sets the last login IP.
	 *
	 * @param lastLoginIP the new last login IP
	 */
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(BaseDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dto.DropdownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	/* (non-Javadoc)
	 * @see in.co.rays.project_0.dto.DropdownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}

		
}
