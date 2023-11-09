package GameWorldOnline.DatabaseArea.UserDetailsStorageArea;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import GameWorldOnline.Utility.Game;

public class InvoiceGeneration {
    PrintStream originalOut;

    Double finalRate;
    String invoice_name;
    Game gameObject;
    File file;
    FileOutputStream fos;
    PrintStream newOut;
    Date date;

    public InvoiceGeneration(Game game, Double finalRate) {
        this.finalRate = finalRate;
        originalOut = System.out;
        date= new Date();
        this.gameObject = game;
        invoice_name = String.format("INVOICE_%s_%s.txt", this.gameObject.getId(), date.getTime());
        file = new File(invoice_name);

        try {
            fos = new FileOutputStream(file);
        } catch (Exception e) {
            System.out.println("Exception in InvoiceGeneration");
            System.out.println("Exception iS"+e.getMessage());

        }
        newOut = new PrintStream(fos);
        System.setOut(newOut);
        this.setToFile();
        System.setOut(originalOut);


    }

    private void setToFile() {
        System.out.println("Sale Date: " + this.date.toString());
        System.out.println("\n");        
        System.out.println("\tSr. \tGame ID \tGame Name \t\tPrice \t\tGST INCLUSIVE Amount");
        String fomrattedSummary = String.format("\t1. \t%s \t%s \t%s \t\t%s ",
                this.gameObject.getId(),
                this.gameObject.getName(),
                Double.parseDouble(this.gameObject.getPrice()),
                this.finalRate);
        System.out.println(fomrattedSummary);
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");
        String fomrattedSummary2 = String.format("\tGROSS AMOUNT \t\t\t\t\t\t\t%s",
                this.finalRate);
        System.out.println(fomrattedSummary2);      
        
        

    }
}
