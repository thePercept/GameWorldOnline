package GameWorldOnline.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessFileData implements ReadUserLoginData, ProcessGameData {
    String readFileType;

    BufferedReader fileReader;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;
    public String line;
    String[] tempArr;
    List<String[]> results;
    HashMap<String,Game> structuredGameData;

    public ProcessFileData(String readFileType, String filePath) {
        this.readFileType = readFileType;
        this.line = "";
        results = new ArrayList<String[]>();
        structuredGameData = new HashMap<>();

        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
            System.out.println("Error while reading File");
        }
        this.inputStreamReader = new InputStreamReader(fileInputStream);
        fileReader = new BufferedReader(inputStreamReader);
        try {
            while ((this.line = fileReader.readLine()) != null) {
                String[] row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)\\R");
                results.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV File " + e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error closing inputstream " + e);
            }
        }


        this.processGameData();

    }
    private String removeSlash(String str){
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        return str;        
    }

    private void insertIntoHashMap(String value){
        // structuredGameData
        // System.out.println("Splitting...")  ;      
        String[] valuesExtraction = value.split(",");  
        this.structuredGameData.put(removeSlash(valuesExtraction[0]),
        new Game(
            removeSlash(valuesExtraction[0]),
            removeSlash(valuesExtraction[1]),
            removeSlash(valuesExtraction[2]),
            removeSlash(valuesExtraction[3]),  
            removeSlash(valuesExtraction[4]),
            removeSlash(valuesExtraction[5])
            )
        );
    }

    public void processGameData() {

        for (String[] row : results) {
            for (String value : row) {
                this.insertIntoHashMap(value);
            }
        }


    }

    @Override
    public void login(String userName, String password) {
        // Login feature
    }

    @Override
    public Game getgameByID(String gameID) {
        // System.out.println("Finally getgameByID "+gameID);
        if(this.structuredGameData.get(gameID)!=null){
            return this.structuredGameData.get(gameID);
        }else{
            return null;
        }
        
    }
    @Override
    public void showAllGames() {
        for (String[] row : results) {
            for (String value : row) {
                System.out.print(value + "");
            }
            System.out.println();
        }        
    }


}
