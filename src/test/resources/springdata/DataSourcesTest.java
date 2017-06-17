package springdata;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataSourcesTest {

	private ApplicationContext context = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-dao.xml");
		System.out.println("setup");
	}
	
	@Test
	public void testDataSources() {
		
		System.out.println("testDataSources");
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		Assert.assertNotNull(dataSource);
	}
	
	@Test
	public void testjdbcTemplate() {
		
		System.out.println("testjdbcTemplate");
		JdbcTemplate dataSource = (JdbcTemplate) context.getBean("jdbcTemplate");
		Assert.assertNotNull(dataSource);
	}

	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
}
