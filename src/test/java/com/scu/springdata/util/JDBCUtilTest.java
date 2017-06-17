package com.scu.springdata.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JDBCUtilTest {

	@Test
	public void testGetConnection() throws Exception{
		
		Connection connection = JDBCUtil.getConnection();
		Assert.assertNotNull(connection);
	}

}
