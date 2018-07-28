package GradeSystemProject.src.gradesystemproject;

import static java.lang.System.exit;

import java.util.Scanner;

public class ChooseCase {
    /**
	 * @uml.property  name="grade"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    GradeSystem Grade=new GradeSystem();
    /**
	 * @uml.property  name="sc"
	 */
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
   /* method ChooseCase------------------------
    * 用來進行指令所要對應的動作
    *  @param ID 用來幫助之後的METHOD來進行該ID資料的運算
    *  @type  void 不須產生任何的回傳值
    *  Pseudo code:
    *  設立一布林flag=true作為該while是否繼續執行
    *  設立一String op作為指令的輸入
    *  利用switch進行指令所要對應到的方法
    *  Time estimate : O (1)
    -----------------------------------------
    */   
    ChooseCase(String ID) {
        while(flag){  	
            System.out.println("輸入指令:");
            System.out.println("1) G 顯示成績 (Grade)");
            System.out.println("2) R 顯示排名 (Rank)");
            System.out.println("3) A 顯示平均 (Average)");
            System.out.println("4) W 更新配分 (Weight)");
            System.out.println("5) E 離開選單 (Exit)");
            String op = sc.next();
            Operation(op,ID);
        }
    }
    
    private void Operation(String op,String ID){
    	switch (op) {
        case "G":Grade.ShowGrade(ID);break;
        case "R":Grade.ShowRank(ID);break;
        case "A":Grade.ShowAverage();break;
        case "W":Grade.UpdateGrade();break;
        case "E":flag = false; break;
        default:System.out.println("沒有此指令!!");break;
    }
   }
    
}
