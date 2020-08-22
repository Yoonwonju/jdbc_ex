package jdbc_ex.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_ex.dao.Impl.TitleDaoImpl;
import jdbc_ex.dto.Title;

public class TitleDaoTest {

	private TitleDaoImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = TitleDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectTitleByAll() {
		List<Title> list = dao.selectTitleByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectTitleByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTitle() {
		fail("Not yet implemented");
	}

}
