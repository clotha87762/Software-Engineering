package GradeSystemProject.src.gradesystemproject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Unit2 {
	/**
	 * @uml.property  name="gs"
	 * @uml.associationEnd  
	 */
	/*
	 *  因為考量到測試順序(若改完權重平均和排名會變，但是Junit的測試順序無法指定)，所以用另外一個Unit Test來個別測試
	 *  GradeSystem中的UpdateGrade()函式。
	 *  
	 *  setUp時創建一個新的GradeSystem
	 *  
	 *  呼叫GradeSystem裡的UpdateGrade函式
	 *  用System.setIn函式模擬使用者輸入了"30 30 30 5 5 Y"
	 *  並測試權重(以static放在GradeSystem class中)是否在呼叫完此函式之後有更改
	 *  
	 *  TearDown是把 GradeSystem nullify
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
	public void testUpdateGrade(){
		String input = "30 30 30 5 5 Y";
		System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
		gs.UpdateGrade();
		
		//gs.UpdateGrade();
		
		//double temp[] = {0.3,0.3,0.3,0.05,0.05};
		assertEquals(0.3,GradeSystem.mul[0],0.01);
		assertEquals(0.3,GradeSystem.mul[1],0.01);
		assertEquals(0.3,GradeSystem.mul[2],0.01);
		assertEquals(0.05,GradeSystem.mul[3],0.01);
		assertEquals(0.05,GradeSystem.mul[4],0.01);
	}
}
