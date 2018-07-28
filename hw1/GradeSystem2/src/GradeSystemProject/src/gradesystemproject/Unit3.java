package GradeSystemProject.src.gradesystemproject;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Unit3 {
	/**
	 * @uml.property  name="gs"
	 * @uml.associationEnd  
	 */
	
	/*
	 * Unit Test 1 
	 * SetUp時創建一個新的GradeSystem，依序測試Project中主要的幾個Public Method
	 * (1) testShowRank()測試GradeSystem中的ShowRank函式 
	 * 	        測試的是975002070 楊宗穎的排名，若回傳值是1則pass
	 * 
	 * (2) testShowAverage()測試GradeSystem中的ShowAverage函式
	 * 	   因為沒有更改過權重，所以若回傳值是89則pass
	 * 
	 * (3) testShowGrade()測試把楊宗穎的成績印出
	 * 	         若能符合直接手算出來的output則Pass
	 * 
	 * 
	 * 
	 * 
	 */
	
	GradeSystem gs;
	@Before
	public void setUp() throws Exception {
		gs = new GradeSystem();
	}

	@After
	public void tearDown() throws Exception {
		gs = null;
	}

	
	
	@Test
	public void testShowRank() {
		assertEquals(gs.ShowRank("975002070"),1);
		
	}
	
	@Test
	public void testShowAverage() {
		assertEquals(gs.ShowAverage(),89);
	}
	
	
	@Test
	public void testShowGrade() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  System.setOut (new PrintStream (outContent));
		  gs.ShowGrade("975002070");
		 assertEquals("楊宗穎成績:\r\nlab1:93\r\nlab2:93\r\nlab3:97\r\nmid-term:96\r\nfinal-exam:94\r\ntotal-grade:95\r\n", outContent.toString());
		 System.setOut (System.out);
	}
	

}
