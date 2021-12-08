package in.co.rays.project_0.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project_0.dto.UserDTO;
import in.co.rays.project_0.exception.DuplicateRecordException;
import in.co.rays.project_0.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
//@ContextConfiguration("/dispatcher-servlet.xml")
public class TestUser {
	
	
	@Autowired
	private UserServiceInt model;
	
	@Ignore
	public void testAdd(){
		System.out.println("User Test.......");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  Date d = null;
		try {
			d = sdf.parse("20/02/2020");
		} catch (ParseException e) 
		{
			System.out.println("parsing.....");
			e.printStackTrace();
		}
   UserDTO dto = new UserDTO();
   dto.setFirstName("shiv");
   dto.setLastName("tiwari");
   dto.setLogin("shivam26@gmail.com");
   dto.setGender("Male");
   dto.setDob(d);
   dto.setRoleId(2);
   dto.setMobileNo("917991523");
   dto.setCreatedBy("shivam");
   dto.setModifiedBy("shivam");
   dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
   dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
   
   try {
			model.add(dto);
		} catch (DuplicateRecordException e) {
			System.out.println("Exception.....");
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate(){
		System.out.println("User Test.......");
		   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  Date d = null;
		try {
			d = sdf.parse("20/02/2020");
		} catch (ParseException e) 
		{
			System.out.println("parsing.....");
			e.printStackTrace();
		}
   UserDTO dto = new UserDTO();
   dto.setId(2);
   dto.setFirstName("shiv123");
   dto.setLastName("tiwari");
   dto.setLogin("shivam26@gmail.com");
   dto.setGender("Male");
   dto.setDob(d);
   dto.setRoleId(2);
   dto.setMobileNo("917991523");
   dto.setCreatedBy("shivam");
   dto.setModifiedBy("shivam");
   dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
   dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
   
			model.update(dto);
			System.out.println("Exception.....");
		}
	
	@Ignore
	public void testDelete(){
		model.delete(2);
		System.out.println("delete successful");
	}
	
    @Ignore
	public void testFindByLogin(){
		UserDTO dto=new UserDTO();
		dto= model.findByLogin("shivam@gmail.com");
		System.out.println(dto.getFirstName());
	}

}
