package GameWorldOnline.Utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProcessFileData implements ReadUserLoginData {
    BufferedReader fileReader;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;
    public String line;
    String[] tempArr;
    List<String[]> results;

    public ProcessFileData(String filePath) {
        this.line = "";
        results = new ArrayList<String[]>();

        try {
            fileInputStream = new FileInputStream(filePath);
            System.out.println(fileInputStream.toString());
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
            System.out.println("Error while reading File");
        }
        this.inputStreamReader = new InputStreamReader(fileInputStream);
        fileReader = new BufferedReader(inputStreamReader);
        System.out.println("Reading Complete ....");

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


        

    }

    public void processGameData() {

        for (String[] row : results) {
            for (String value : row) {
                System.out.print(value + "");
            }
            System.out.println();
        }

    }

    @Override
    public void login(String userName, String password) {
        // Login feature
    }

}
