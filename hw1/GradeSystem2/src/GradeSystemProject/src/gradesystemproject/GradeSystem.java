/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradeSystemProject.src.gradesystemproject;

import java.util.*;


public class GradeSystem {
  static double mul[]={0.1,0.1,0.1,0.3,0.4};
    /**
	 * @uml.property  name="sc"
	 */
    Scanner sc ;
    /**
	 * @uml.property  name="term" multiplicity="(0 -1)" dimension="1"
	 */
    String[] term = {"lab1", "lab2", "lab3", "mid-term", "final-term"};
    /**
	 * @uml.property  name="score" multiplicity="(0 -1)" dimension="1"
	 */
    double[] score = new double[10];
    /**
	 * @uml.property  name="jud"
	 */
    String jud;
    static public DataSet data  =  new DataSet();
/* method ShowAverage------------------------
    *  算出全班的總平均
    *  @type int
    *  @return 全班總平均
    *  Pseudo code:
    * 利用之前建好的DataSet來初始化各個的資料
    * 利用while迴圈來把dataSet裡頭記錄好的record的個人平均來做相加
    * 最後在除上總人數即為全班平均
    * Time estimate : O (n)
    -----------------------------------------
    */   
    public int ShowAverage() {
        //DataSet data = new DataSet();
        int total = 0, i = 999;
        while (data.record[i] != 0) {
            total += data.record[i];
            i--;
        }    
        System.out.println("全部總平均:" + total / (999 - i));
        return (total / (999 - i));
    }
 /* method ShowGrade------------------------
    *  算出全班的總平均
    *  @param ID 用來查詢要找的人的成績
    *  @type void
    *  Pseudo code:
    * 利用之前建好的DataSet來初始化各個的資料
    * 利用DataSet裡頭初始化好的各個成績透過ID跟別取得
    * 由剛才取得的成績進行相加除以總人數求得個人平均
    * Time estimate : O (1)
    -----------------------------------------
    */   
    
  
    public void ShowGrade(String ID) {
        try {        
            System.out.println(new Name().map.get(ID) + "成績:");
            PrintLab1(ID);
            PrintLab2(ID);
            PrintLab3(ID);
            PrintMid(ID);
            PrintFinal(ID);
            PrintTotal( (int) (Integer.parseInt(data.mapFinal.get(ID).toString()) * mul[4] + Integer.parseInt(data.mapMid.get(ID).toString()) *mul[3] + Integer.parseInt(data.mapLab1.get(ID).toString()) * mul[0] + Integer.parseInt(data.mapLab2.get(ID).toString()) * mul[1] + Integer.parseInt(data.mapLab3.get(ID).toString()) *mul[2] + 0.5));
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }
    
    private void PrintLab1(String ID){
    	if(Integer.parseInt(data.mapLab1.get(ID).toString())<60)
    		System.out.println("lab1:" + data.mapLab1.get(ID)+"*");
    	else
    		System.out.println("lab1:" + data.mapLab1.get(ID));
    }
    private void PrintLab2(String ID){
      	if(Integer.parseInt(data.mapLab2.get(ID).toString())<60)
    		System.out.println("lab2:" + data.mapLab2.get(ID)+"*");
    	else
    		System.out.println("lab2:" + data.mapLab2.get(ID));
    }
    private void PrintLab3(String ID){
    	if(Integer.parseInt(data.mapLab3.get(ID).toString())<60)
    		System.out.println("lab3:" + data.mapLab3.get(ID)+"*");
    	else
    		System.out.println("lab3:" + data.mapLab3.get(ID));
    }
    
    private void PrintMid(String ID){
    	if(Integer.parseInt(data.mapMid.get(ID).toString())<60)
    		System.out.println("mid-term:" + data.mapMid.get(ID)+"*");
    	else
    		System.out.println("mid-term:" + data.mapMid.get(ID));
    }
    private void PrintFinal(String ID){
    	if(Integer.parseInt(data.mapFinal.get(ID).toString())<60)
    		System.out.println("final-exam:" + data.mapFinal.get(ID)+"*");
    	else
    		System.out.println("final-exam:" + data.mapFinal.get(ID));
    }
    private void PrintTotal(int temp){
      	if(temp<60)
    		System.out.println("total-grade:" + temp+"*");
    	else
    		System.out.println("total-grade:" + temp);
    }
    
    
/* method ShowRank------------------------
    *  算出該ID的名次
    *  @param ID 用來查詢要找的人的成績
    *  @type int
    *  @return int回傳該ID名次
    *  Pseudo code:
    * 利用之前建好的DataSet來初始化各個的資料
    * 利用DataSet中排序好的全部成績,依次與該ID的平均成績進行比對,來求出該ID位於第幾位
    * Time estimate : O (n)
    -----------------------------------------
    */   
    public int ShowRank(String ID) {
        // DataSet data = new DataSet();
        int i = 999;
        int count = 0;
        int total = (int) (Integer.parseInt(data.mapFinal.get(ID).toString()) *mul[4] + Integer.parseInt(data.mapMid.get(ID).toString()) *mul[3] + Integer.parseInt(data.mapLab1.get(ID).toString()) *mul[0] + Integer.parseInt(data.mapLab2.get(ID).toString()) *mul[1] + Integer.parseInt(data.mapLab3.get(ID).toString()) *mul[2]+0.5);
        while (data.record[i] != total) {
            i--;         
        }
        System.out.println(new Name().map.get(ID) + "排名: " + (999 - i +1));
        return (999-i+1);
    }
/* method UpdateGrade------------------------
    *  重新更新各個分數的比重
    *  @type void
    *  Pseudo code:
    * 利用之前建好的DataSet來初始化各個的資料
    * 取出DataSet中的mul陣列(依次代表各個成績所佔的比重)
    * 透過EnterNewWeight的方法來輸入新的比重
    * 透過ShowNewWeight的方法來顯示EnterNewWeight輸入的比重
    * 藉由是否為確認Y來決定是否要將剛才輸入的新比重來更改mul裡的比重
    * Time estimate : O (15)
    -----------------------------------------
    */   
    public void UpdateGrade() {
         while(true){
	        System.out.println("舊配分: \n" + "lab1: " +mul[0] * 100 + "%\n" + "lab2: " +mul[1] * 100 + "%\n" + "lab3: " + mul[2] * 100 + "%\n" + "mid-term: " +mul[3] * 100 + "%\n" + "final-term: " +mul[4] * 100 + "%\n");
	        EnterNewWeight();
	        ShowNewWeight();
	        System.out.println("以上正確嗎?Y (Yes) 或 N (No)");   
	        jud = sc.next();
	        if (jud.equals("Y")) {
	            for (int u = 0; u < term.length; u++) {mul[u] = score[u];}
	           data = new DataSet();   break;
	        } 
        }
    }
    /* method EnterNewWeight------------------------
    *  用來輸入新比重   
    *  @type void
    *  Pseudo code:
    * 用for迴圈將輸入新比重並暫存於score陣列中
    * Time estimate : O (5)
    -----------------------------------------
    */  
    private void EnterNewWeight(){
    	System.out.println("輸入新配分:");
    	sc = new Scanner(System.in);
        for (int i = 0; i < term.length; i++) {
            System.out.println(term[i] + ": ");
            score[i] = (sc.nextInt() * 0.01);
        }
    }
    /* method ShowNewWeight------------------------
    *  用來顯示輸入新比重   
    *  @type void
    *  Pseudo code:
    *  用for迴圈將剛才暫存的score顯示出來
    * Time estimate : O (5)
    -----------------------------------------
    */  
    private void ShowNewWeight(){
    	System.out.println("請確認新配分:");
        for (int j = 0; j < term.length; j++) {
            System.out.println(term[j] + ":" + (int) (score[j] * 100) + "%");
        }
    }

	
    
   
}
