
package GradeSystemProject.src.gradesystemproject;

import java.io.*;
import java.util.*;

public class DataSet {

    /**
	 * @uml.property  name="record" multiplicity="(0 -1)" dimension="1"
	 */
    int record[] = new int[1000];
    /**
	 * @uml.property  name="mapLab1"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap mapLab1 = new HashMap();
    /**
	 * @uml.property  name="mapLab2"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap mapLab2 = new HashMap();
    /**
	 * @uml.property  name="mapLab3"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap mapLab3 = new HashMap();
    /**
	 * @uml.property  name="mapMid"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap mapMid = new HashMap();
    /**
	 * @uml.property  name="mapFinal"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap mapFinal = new HashMap();
    /**
	 * @uml.property  name="str"
	 */
    String str;
	/**
	 * @uml.property  name="tempLine"
	 */
	String tempLine;
    /**
	 * @uml.property  name="name"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    Name name = new Name();
   /**
 * @uml.property  name="i"
 */
int i=0;
/**
 * @uml.property  name="k"
 */
int k=0;
/**
 * @uml.property  name="l"
 */
int l=0;
/**
 * @uml.property  name="m"
 */
int m=0;
/**
 * @uml.property  name="n"
 */
int n=0;
/**
 * @uml.property  name="p"
 */
int p=0;
   /**
 * @uml.property  name="grade"
 * @uml.associationEnd  multiplicity="(1 1)"
 */
GradeSystem Grade=new GradeSystem();
   /* method DataSet------------------------
    *  用來進行剛開始個個資料的初始化以及處理,並提更給後續方法所需用到的資料
    *  Pseudo code:
    *  @type 建構子
    * Time estimate : O (1)
    -----------------------------------------
    */   
    DataSet() {
        Lab1Set();
        Lab2Set();
        Lab3Set();
        MidSet();
        FinalSet();
        TotalData();
    }
 /* method TotalData------------------------
    *  用來將各個ID的所有成績算出他們個人的平均
    *  @type void
    *  Pseudo code:
    * 將 name對應到的ID的各次分數算出平均後存到record中
    *利用Arrays.sort()函式來將大家的平均進行sort
    * Time estimate : O (nlogn)
    -----------------------------------------
    */   
    private void TotalData() {
        
       
        while (name.Data[i][0] != null) {
        	record[i] = (int) (Integer.parseInt(mapFinal.get(name.Data[i][0]).toString()) * Grade.mul[4] + Integer.parseInt(mapMid.get(name.Data[i][0]).toString()) * Grade.mul[3] + Integer.parseInt(mapLab1.get(name.Data[i][0]).toString()) * Grade.mul[0] + Integer.parseInt(mapLab2.get(name.Data[i][0]).toString()) * Grade.mul[1] + Integer.parseInt(mapLab3.get(name.Data[i][0]).toString()) *Grade.mul[2] + 0.5);
        	// System.out.println(i + " "+record[i]+" ");

        	i++;
           
        }
        
        Arrays.sort(record);

    }
    
   /* method Lab1Set------------------------
    *  讀入每個人的Lab1成績並將他們的成績加入倒HashMap中
    *  @type private String
    *  return null
    *  Pseudo code:
    * 利用FIFO將每一行讀入做判斷,同時進行以空白為單位做切割並存入Data的二維陣列中
    * 最後再將ID以及ID所對應到的Lab1分數放入到mapLab1中
    * Time estimate : O (n)
    -----------------------------------------
    */   
     private String Lab1Set() {
        String[][] Data = new String[1000][1000];
        try {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File("gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[k] = str.split(" ");
                mapLab1.put(Data[k][0], Data[k][2]);
                k++;     }
        } catch (Exception e) {          System.out.println(e.getMessage());        }
        return "";
    }
/* method Lab2Set------------------------
    *  讀入每個人的Lab2成績並將他們的成績加入倒HashMap中
    *  @type private String
    *  return null
    *  Pseudo code:
    * 利用FIFO將每一行讀入做判斷,同時進行以空白為單位做切割並存入Data的二維陣列中
    * 最後再將ID以及ID所對應到的Lab2分數放入到mapLab2中
    * Time estimate : O (n)
    -----------------------------------------
    */   
    private String Lab2Set() {
        String[][] Data = new String[1000][1000];
        try {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File("gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[l] = str.split(" ");
                mapLab2.put(Data[l][0], Data[l][3]);
                l++;  }
        } catch (Exception e) {   System.out.println(e.getMessage());}
        return "";
    }
/* method Lab3Set------------------------
    *  讀入每個人的Lab3成績並將他們的成績加入倒HashMap中
    *  @type private String
    *  return null
    *  Pseudo code:
    * 利用FIFO將每一行讀入做判斷,同時進行以空白為單位做切割並存入Data的二維陣列中
    * 最後再將ID以及ID所對應到的Lab3分數放入到mapLab3中
    * Time estimate : O (n)
    -----------------------------------------
    */   
    private String Lab3Set() {
        String[][] Data = new String[1000][1000];
        try {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File("gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[m] = str.split(" ");
                mapLab3.put(Data[m][0], Data[m][4]);
                m++;    }
        } catch (Exception e) {       System.out.println(e.getMessage()); }
        return "";
    }
/* method MidSet------------------------
    *  讀入每個人的Lab3成績並將他們的成績加入倒HashMap中
    *  @type private String
    *  return null
    *  Pseudo code:
    * 利用FIFO將每一行讀入做判斷,同時進行以空白為單位做切割並存入Data的二維陣列中
    * 最後再將ID以及ID所對應到的Mid分數放入到mapMid中
    * Time estimate : O (n)
    -----------------------------------------
    */   
    private String MidSet() {
        String[][] Data = new String[1000][1000];
        try {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File("gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[n] = str.split(" ");
                mapMid.put(Data[n][0], Data[n][5]);
                n++;  }
        } catch (Exception e) {  System.out.println(e.getMessage()); }
        return "";
    }
/* method MidSet------------------------
    *  讀入每個人的Lab3成績並將他們的成績加入倒HashMap中
    *  @type private String
    *  return null
    *  Pseudo code:
    * 利用FIFO將每一行讀入做判斷,同時進行以空白為單位做切割並存入Data的二維陣列中
    * 最後再將ID以及ID所對應到的Final分數放入到mapFinal中
    * Time estimate : O (n)
    -----------------------------------------
    */  
    private String FinalSet() {
        String[][] Data = new String[1000][1000];
        try {
            BufferedReader readTxt = new BufferedReader(new FileReader(new File("gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[p] = str.split(" ");
                mapFinal.put(Data[p][0], Data[p][6]);
                p++;    }
        } catch (Exception e) {   System.out.println(e.getMessage());}
        return "";
    }
}
