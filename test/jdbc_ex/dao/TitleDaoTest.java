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
		System.out.println("testSelectTitleByNo");
		Title selectTitle = dao.selectTitleByNo(new Title(1));
		Assert.assertNotNull(selectTitle);
		
		System.out.println(selectTitle);
	}
	
	@Test
	public void testInsertTitle() {
		System.out.println("testInsertTitle");
		Title inserTitle = new Title(6, "인턴");
		int res = dao.insertTitle(inserTitle);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void testUpdateTitle() {
		System.out.println("testUpdateTitle");
		Title updateTitle = new Title(6, "계약직");
		int res = dao.updateTitle(updateTitle);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectTitleByNo(con, updateTitle));
	}
	
	@Test
	public void testDeleteTitle() {
		System.out.println("testDeleteTitle");
		Title delTitle = new Title(6);
		int res = dao.deleteTitle(delTitle);
		Assert.assertEquals(1, res);
		
		System.out.println(dao.selectTitleByNo(con, delTitle));
	}

}
