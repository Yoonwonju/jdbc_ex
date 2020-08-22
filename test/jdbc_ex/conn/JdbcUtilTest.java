package jdbc_ex.conn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.printf("%s()%n", "setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.printf("%s()%n", "tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.printf("%s()%n", "setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.printf("%s()%n", "tearDown");
	}

	@Test
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
//		fail("Not yet implemented");
	}

}
