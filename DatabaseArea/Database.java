package GameWorldOnline.DatabaseArea;
import GameWorldOnline.Utility.ReadFromFile;
public class Database {

    public static ReadFromFile readFromFile;


    

    public Database() {
        initializeWebsiteDatabase();
    }

    private void initializeWebsiteDatabase(){

        readFromFile = new ReadFromFile("C:\\Users\\abhis\\Desktop\\utkarsh\\GameWorldOnline\\DatabaseArea\\WebsiteInventory\\products.csv");
        System.out.println(readFromFile.getSingleRecord());
    }




    
}
