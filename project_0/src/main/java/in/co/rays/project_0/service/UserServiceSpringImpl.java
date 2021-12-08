/*
 * @author Mayank
 */
package in.co.rays.project_0.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.project_0.dao.UserDAOInt;
import in.co.rays.project_0.dto.RoleDTO;
import in.co.rays.project_0.dto.UserDTO;
import in.co.rays.project_0.exception.ApplicationException;
import in.co.rays.project_0.exception.DuplicateRecordException;
import in.co.rays.project_0.util.EmailBuilder;

/**
 * The Class UserServiceSpringImpl.
 */
@Service(value = "userService")
public class UserServiceSpringImpl implements UserServiceInt {

	/** The dao. */
	@Autowired
	private UserDAOInt dao;

	/** The role service. */
	@Autowired
	private RoleServiceInt roleService;

	/** The mail sender. */
	@Autowired
	private JavaMailSenderImpl mailSender;

	/** The log. */
	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#add(in.co.rays.project_0.dto.
	 * UserDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		UserDTO udto = dao.findByLogin(dto.getLogin());

		if (udto != null && udto.getLogin() != null) {
			throw new DuplicateRecordException("");
		}

		System.out.println(dto.getFirstName());
		long pk = dao.add(dto);
		return pk;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#registerUser(in.co.rays.
	 * project_0.dto.UserDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long registerUser(UserDTO dto) throws DuplicateRecordException, ApplicationException {
		System.out.println("service" + dto.getDob());
		long id = add(dto);

		/*HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLogin());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);
		MimeMessage msg = mailSender.createMimeMessage();
		try {

			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(dto.getLogin());
			helper.setSubject("Registration is successful for ORS Project SUNRAYS Technologies.");
			// use the true flag to indicate the text included is HTML
			helper.setText(message, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			System.out.println("userregistration fail");
			e.printStackTrace();
		}
*/
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#update(in.co.rays.project_0.
	 * dto.UserDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) {
		log.debug("Service update Started");
		dao.update(dto);
		log.debug("Service update End");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {

		log.debug("Service Delete Started");
		System.out.println("servise delete" + id);
		dao.delete(id);
		log.debug("Service delete End");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#findByLogin(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		log.debug("Service findByLogin Started");
		UserDTO dto = dao.findByLogin(login);
		System.out.println("in findByLogin method" + dto);
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#findByPK(long)
	 */
	@Transactional(readOnly = true)
	public UserDTO findByPK(long pk) {
		log.debug("Service findByPK Started");
		UserDTO dto = dao.findByPK(pk);
		log.debug("Service findByPK End");
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#search(in.co.rays.project_0.
	 * dto.UserDTO, int, int)
	 */
	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#search(in.co.rays.project_0.
	 * dto.UserDTO)
	 */
	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		return dao.search(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#changePassword(java.lang.
	 * Long, java.lang.String, java.lang.String)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(Long id, String oldPassword, String newPassword) throws DuplicateRecordException {
		UserDTO dto = findByPK(id);
		if (oldPassword.equals(dto.getPassword())) {
			dto.setPassword(newPassword);
			dao.update(dto);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#authenticate(in.co.rays.
	 * project_0.dto.UserDTO)
	 */
	@Transactional(readOnly = true)
	public UserDTO authenticate(UserDTO dto) {
		UserDTO dtoExist = null;
		UserDTO dto1 = null;
		dtoExist = dao.findByLogin(dto.getLogin());
		System.out.println("in auth method-------->>" + dtoExist + "eixst pwd" + dtoExist.getPassword() + "per pwd"
				+ dto.getPassword());
		if ((dtoExist != null) && (dtoExist.getPassword().equals(dto.getPassword()))) {
			System.out.println("in if condition---------");
			dto1 = dtoExist;
			dao.update(dtoExist);
			return dto1;
		}
		return dto1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#lock(java.lang.String)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean lock(String login) {
		log.debug("Service lock Started");
		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = findByLogin(login);
		if (dtoExist != null) {
			dtoExist.setLock(UserDTO.ACTIVE);
			dao.update(dtoExist);
			flag = true;
		} else {
		}
		log.debug("Service lock End");
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#resetPassword(java.lang.
	 * String)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean resetPassword(String login) throws ApplicationException {
		log.debug("Service resetPassword Started");
		boolean flag = false;
		UserDTO dtoExist = null;
		dtoExist = dao.findByLogin(login);
		/*if (dtoExist != null) {
			String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
			dtoExist.setPassword(newPassword);
			dao.update(dtoExist);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			String message = EmailBuilder.getForgetPasswordMessage(map);

			MimeMessage msg = mailSender.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(msg, true);
				helper.setTo(dtoExist.getLogin());
				helper.setSubject("Password has been reset.");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
			} catch (MessagingException e) {
				System.out.println("Mail Sending Failed");
				e.printStackTrace();
			}
			mailSender.send(msg);

			flag = true;
		} else {
		}*/
		log.debug("Service restPassword End");
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#forgetPassword(java.lang.
	 * String)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public boolean forgetPassword(String login) throws ApplicationException {
		log.debug("Service forgetPassword Started");

		UserDTO dtoExist = dao.findByLogin(login);

		
		 /* if (dtoExist != null) {
		  
		  HashMap<String, String> map = new HashMap<String, String>();
		  map.put("firstName", dtoExist.getFirstName()); map.put("lastName",
		  dtoExist.getLastName()); map.put("login", dtoExist.getLogin());
		  map.put("password", dtoExist.getPassword());
		  
		  String message = EmailBuilder.getForgetPasswordMessage(map);
		  
		  MimeMessage msg = mailSender.createMimeMessage();
		  
		  try { MimeMessageHelper helper = new MimeMessageHelper(msg);
		  helper.setTo(login); 
		  
		  helper.setSubject("SunilOS ORS Password reset");
		  // use the true flag to indicate the text included is HTML
		  helper.setText(message, true); 
		  
		  mailSender.send(msg); } catch
		 (MessagingException e) { e.printStackTrace(); log.error(e); return
		  false; } } else { 
			  return false; } */
		  log.debug("Service forgetPassword End");
		 
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.co.rays.project_0.service.UserServiceInt#getRole(in.co.rays.project_0.
	 * dto.UserDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public RoleDTO getRole(UserDTO dto) {
		// TODO Auto-generated method stub
		return roleService.findById(dto.getRoleId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.rays.project_0.service.UserServiceInt#updateAccess(in.co.rays.
	 * project_0.dto.UserDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public UserDTO updateAccess(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
