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

public class SpringDataSourceTest {

	private ApplicationContext context = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testEntityManagerFactory() {
		
	}
	
}
