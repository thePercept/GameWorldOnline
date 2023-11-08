package GameWorldOnline.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadFromFile {
    BufferedReader fileReader;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;    

    public String value;

    public ReadFromFile(){
        this.value = "";
    }

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
        System.out.println("Reading Complete ....");

    }
    public String getSingleRecord(){
        try{
            if(fileReader.readLine()!=null) {
                StringTokenizer tokens = new StringTokenizer((String) fileReader.readLine(), ",");
                System.out.println(fileReader.readLine());
                this.value = tokens.nextToken();
            }
        }catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
            System.out.println("Error while reading the Lines");
        }
        return value;    

    }
    




}
