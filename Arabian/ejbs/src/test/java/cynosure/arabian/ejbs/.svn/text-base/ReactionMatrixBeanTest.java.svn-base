package cynosure.arabian.ejbs;

import static org.junit.Assert.*;

import java.util.*;

import org.jmock.*;
import org.junit.*;

import cynosure.arabian.data.*;
import cynosure.arabian.data.dao.*;

public class ReactionMatrixBeanTest
{
	private ReactionMatrixBean bean;
	
	private Mockery mockery;

	private ReactionMatrixDAO dao;
	
	private ReactionMatrix matrix;
	private String title;

	@Before
	public void before() {
		bean = new ReactionMatrixBean();
		
		matrix = new ReactionMatrix();
		
		title = UUID.randomUUID().toString();
		matrix.setTitle(title);
		
		mockery = new Mockery();
		dao = mockery.mock(ReactionMatrixDAO.class);
		bean.setDAO(dao);
	}
	
	@After
	public void after() {
		mockery.assertIsSatisfied();
	}
	
	@Test
	public void getMatrix()
	{
		mockery.checking(new Expectations()
		{
			{
				oneOf(dao).getMatrix(title);
				will(returnValue(matrix));
			}
		});

		ReactionMatrix fromService = bean.getMatrix(title);

		assertEquals(matrix, fromService);
	}

	@Test
	public void getTale()
	{
		String adjective = UUID.randomUUID().toString();
		String reaction = UUID.randomUUID().toString();
		String tale = UUID.randomUUID().toString(); 
		
		String[] headings = new String [] { UUID.randomUUID().toString(), reaction };
		String[] adjectives = new String[] { adjective };
		String[][] tales = new String[][] {{UUID.randomUUID().toString(), tale}}; 

		matrix.setHeadings(headings);
		matrix.setAdjectives(adjectives);
		matrix.setTales(tales);

		mockery.checking(new Expectations()
		{
			{
				oneOf(dao).getMatrix(title);
				will(returnValue(matrix));
			}
		});

		String fromBean = bean.getTale(title, adjective, reaction);

		assertEquals(tale, fromBean);
	}

	@Test
	public void getTaleCaseInsensitve()
	{
		String adjective = UUID.randomUUID().toString();
		String reaction = UUID.randomUUID().toString();
		String tale = UUID.randomUUID().toString(); 
		
		String[] headings = new String [] { UUID.randomUUID().toString(), reaction };
		String[] adjectives = new String[] { adjective };
		String[][] tales = new String[][] {{UUID.randomUUID().toString(), tale}}; 

		matrix.setHeadings(headings);
		matrix.setAdjectives(adjectives);
		matrix.setTales(tales);

		mockery.checking(new Expectations()
		{
			{
				oneOf(dao).getMatrix(title);
				will(returnValue(matrix));
			}
		});

		String fromBean = bean.getTale(title, adjective, reaction.toUpperCase());

		assertEquals(tale, fromBean);
	}

	@Test
	public void getTales()
	{
		String adjective = UUID.randomUUID().toString();
		
		String[] headings = new String [] { UUID.randomUUID().toString(), UUID.randomUUID().toString() };
		String[] adjectives = new String[] { adjective };
		String[][] tales = new String[][] {{UUID.randomUUID().toString(), UUID.randomUUID().toString()}}; 

		matrix.setHeadings(headings);
		matrix.setAdjectives(adjectives);
		matrix.setTales(tales);

		mockery.checking(new Expectations()
		{
			{
				oneOf(dao).getMatrix(title);
				will(returnValue(matrix));
			}
		});

		String[] fromBean = bean.getTales(title, adjective);

		assertTrue(Arrays.deepEquals(tales[0], fromBean));
	}
}
