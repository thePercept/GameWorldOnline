package GameWorldOnline.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFromFile {
    BufferedReader fileReader;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;    

    public ReadFromFile(String filePath){
        try{
            fileInputStream = new FileInputStream(filePath);
            System.out.println(fileInputStream.toString());
        }catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
            System.out.println("Error while reading File");
        }
        this.inputStreamReader = new InputStreamReader(fileInputStream);   
        fileReader = new BufferedReader(inputStreamReader);            
    }





}
