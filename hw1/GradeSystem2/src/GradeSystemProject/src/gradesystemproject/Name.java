
package GradeSystemProject.src.gradesystemproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import static java.lang.System.exit;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Name {

    /**
	 * @uml.property  name="sc"
	 */
    Scanner sc = new Scanner(System.in);
    /**
	 * @uml.property  name="map"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="ID:java.lang.String java.lang.Object"
	 */
    HashMap map = new HashMap();
    static String[][] Data = new String[1000][1000];
    /**
	 * @uml.property  name="str"
	 */
    String str;
	/**
	 * @uml.property  name="tempLine"
	 */
	String tempLine;
    /**
	 * @uml.property  name="i"
	 */
    int i = 0;
   /* method Name------------------------
    *  用來顯示輸入新比重   
    *  @type 建構子
    *  Pseudo code:
    *  將後面的NameSet方法進行初始化
    * Time estimate : O (1)
    -----------------------------------------
    */  
    Name() {

        NameSet();
    }
 /* method Name------------------------
    *  比對程式剛執行時所下的Q指令或者找尋的ID  
    *  @type 帶有參數建構子
    *  @param String command 用來讀入你的指令Q或者你的ID是否合法
    *  Pseudo code:
    *  利用傳入的參數command來逐一比對所下的指令
    * Time estimate : O (1)
    -----------------------------------------
    */  
    Name(String command) {
        NameSet();
        if (command.equals("Q")) {
            System.out.println("結束了");
            exit(0);
        // } else if (command.equals("955002056")) {
           // System.out.println("Welcome " + map.get(Data[0][0]));
            //Option(Data[0][0]);
           // new ChooseCase( command.toString());
        }else if (map.get(command.toString()) == null) {
            System.out.println("無此ID!!");
        } else {
            System.out.println("Welcome " + map.get(command.toString()));
            //Option(command.toString());
            new ChooseCase( command.toString());
        }
    }
 /* method NameSet------------------------
    *  比對程式剛執行時所下的Q指令或者找尋的ID  
    *  @type 帶有參數建構子
    *  Pseudo code:
    * 利用FIFO將txt檔中的每航資料做讀入
    * 利用while迴圈搭配split的函式將各行資料利用空白字元進行切割並存入Data二維陣列中
    * 最後再將個比ID以及所對應的人名放入map中
    * Time estimate : O (n)
    -----------------------------------------
    */  
    private void NameSet() {
        try {

            BufferedReader readTxt = new BufferedReader(new FileReader(new File("C:\\gradeinput.txt")));
            while ((tempLine = readTxt.readLine()) != null) {
                str = tempLine.replaceAll("  ", "");
                Data[i] = str.split(" ");
                map.put(Data[i][0], Data[i][1]);
                i++;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    
    

}
