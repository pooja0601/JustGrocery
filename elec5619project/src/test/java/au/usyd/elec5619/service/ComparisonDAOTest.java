package au.usyd.elec5619.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.domain.retailer;
import junit.framework.TestCase;

@Configuration(value = "classpath:persistence-context-test.xml")
public class ComparisonDAOTest extends TestCase {

	@Autowired
	private ComparisonDAO comparisonDAO;
	
	@Test
	@Transactional
	//@Rollback(true)
	public void testAddDepartment()
	{
	    //other code
	}

}
