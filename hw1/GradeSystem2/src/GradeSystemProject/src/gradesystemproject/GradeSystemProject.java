package GradeSystemProject.src.gradesystemproject;

import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;



public class GradeSystemProject {
              
        static String commandID;
        static String command;
    /* method main------------------------
    * 程式執行剛開始的主要方法
    *  @type  static void
    *  Pseudo code:
    * 讀入ID並透過Name方法找出該ID的人名
    * 透過DataSet將各個資料進行初始化
    * Time estimate : O (1)
    -----------------------------------------
    */   
    public static void main(String[] args) {
    	System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        while (true) {          
            Scanner sc = new Scanner(System.in);
            System.out.print("1. 輸入ID或 Q (結束使用)？");
            commandID = sc.next();   
            new Name(commandID);
        }

    }
    

}
