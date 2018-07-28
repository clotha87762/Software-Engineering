package GradeSystemProject.src.gradesystemproject;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Integrate2 {

	/**
	 * @uml.property  name="gs"
	 * @uml.associationEnd  
	 */

	/*
	 * 此Integration test測試了整個Grade system，
	 * 
	 * setUp時先建立一個新的GradeSystem
	 * test1（）函式依序測試高嘉晴當使用者時的各項功能
	 * 先測試林芯妤的ＳｈｏｗＧｒａｄｅ（）函式
	 * 接著測試showRank跟showAverage，測試是否跟手算出來的結果一樣
	 * 接著測試UpdateGrade，用 ０　０　０　５０　５０　當作新的權重
	 * 去重新測試ShowAverage跟ShowRank函式是否跟新權重之下手算出來的結果一樣
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
	public void test1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  System.setOut (new PrintStream (outContent));
		  gs.ShowGrade("985002022");
		 assertEquals("高嘉靖成績:\r\nlab1:88\r\nlab2:91\r\nlab3:85\r\nmid-term:91\r\nfinal-exam:94\r\ntotal-grade:91\r\n", outContent.toString());
		 System.setOut (System.out);
		 
		 assertEquals(gs.ShowRank("985002022"),22);
		 assertEquals(gs.ShowAverage(),89);
		 
		 String input = "0 0 0 50 50 Y";
		 System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
		 gs.UpdateGrade();
	     assertEquals(0.0,GradeSystem.mul[0],0.01);
		 assertEquals(0,GradeSystem.mul[1],0.01);
		 assertEquals(0,GradeSystem.mul[2],0.01);
		 assertEquals(0.5,GradeSystem.mul[3],0.01);
		 assertEquals(0.5,GradeSystem.mul[4],0.01);
			
		 assertEquals(gs.ShowRank("985002022"),15);
		  outContent = new ByteArrayOutputStream();
		  System.setOut (new PrintStream (outContent));
		  gs.ShowGrade("985002022");
		 assertEquals("高嘉靖成績:\r\nlab1:88\r\nlab2:91\r\nlab3:85\r\nmid-term:91\r\nfinal-exam:94\r\ntotal-grade:93\r\n", outContent.toString());
		 System.setOut (System.out);
			 	
		 
	}

	

}
