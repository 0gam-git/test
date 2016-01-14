package com.jacademy.txtest.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EmpDaoTest {
	
	private EmpDao dao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		dao = context.getBean("empDao", EmpDao.class);
	}

	@Test
	public void testInsertEmps() {
		dao.delete();
		
		assertThat(dao.count(), is(0));
		try {
			dao.insertEmps();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(dao.count(), is(0));
	}

}
