package com.ar.utilities;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;

public class AutomUtility {
    public static void main(String args[]) throws IOException {

        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put("FindBy".toLowerCase(Locale.ROOT), "@FindBy(how=How.XPATH,using=\"//button[text()='Create User']\")\n" +
                "public WebElement btnCreateUser;");
        hm.put("Select".toLowerCase(Locale.ROOT), "Select select = new Select(cmbDropDown);\n" +
                "select.SelectByVisibleText(\"\");");

        File file = new File("C:\\Users\\venkatm\\Desktop\\Test\\test.txt");   //creates a new file instance
        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
        String line;
        while((line=br.readLine())!=null)
        {
            sb.append(line);      //appends line to string buffer
            sb.append("\n");     //line feed
        }
        fr.close();    //closes the stream and release the resources
        String[] cont = sb.toString().split("\n");

        for(String c :cont)
        {
            System.out.println(hm.get(c.toLowerCase(Locale.ROOT)));
        }
    }
}
