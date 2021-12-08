package in.co.rays.project_0.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.rays.project_0.dto.CourseDTO;
import in.co.rays.project_0.exception.DuplicateRecordException;
import in.co.rays.project_0.service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestCourse {

	@Autowired
	private CourseServiceInt model;
	
	@Test
	public void testAdd() throws DuplicateRecordException{
		CourseDTO dto=new CourseDTO();
		dto.setName("english");
		dto.setDuration("3years");
		dto.setDescription("hello");
		dto.setCreatedBy("a@gmail.com");
		dto.setModifiedBy("a@gmail.com");
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}
	
}
