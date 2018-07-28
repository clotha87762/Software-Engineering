package GradeSystemProject.src.gradesystemproject;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class Unit1 {
	//GradeSystemProject gsp;
	/**
	 * @uml.property  name="gs"
	 * @uml.associationEnd  
	 */
	
	
	/*
	 * Unit Test 1 
	 * SetUp時創建一個新的GradeSystem，依序測試Project中主要的幾個Public Method
	 * (1) testShowRank()測試GradeSystem中的ShowRank函式 
	 * 	        測試的是65002038 蘇亨玠的排名，若回傳值是58則pass
	 * 
	 * (2) testShowAverage()測試GradeSystem中的ShowAverage函式
	 * 	   因為沒有更改過權重，所以若回傳值是89則pass
	 * 
	 * (3) testShowGrade()測試把楊永成的成績印出
	 * 	         若能符合直接手算出來的output則Pass
	 * 
	 * TearDown時把GradeSystem nullify
	 * 
	 * 
	 */
	GradeSystem gs;
	@Before
	public void setUp() throws Exception {
		//gsp = new GradeSystemProject();
		gs = new GradeSystem();
		
	}

	@After
	public void tearDown() throws Exception {
		gs = null;
		//gsp = null;
	}

	
	
	@Test
	public void testShowRank() {
		assertEquals(gs.ShowRank("965002038"),58);
		
	}
	
	@Test
	public void testShowAverage() {
		assertEquals(gs.ShowAverage(),89);
	}
	
	
	@Test
	public void testShowGrade() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  System.setOut (new PrintStream (outContent));
		  gs.ShowGrade("975002026");
		 assertEquals("楊永成成績:\r\nlab1:85\r\nlab2:90\r\nlab3:82\r\nmid-term:93\r\nfinal-exam:85\r\ntotal-grade:88\r\n", outContent.toString());
		 System.setOut (System.out);
	}
	

	

}
