package GameWorldOnline.DatabaseArea;
import GameWorldOnline.Utility.ProcessFileData;
public class Database {

    public static ProcessFileData readFromFile;


    

    public Database() {
        initializeWebsiteDatabase();
    }

    private void initializeWebsiteDatabase(){

        readFromFile = new ProcessFileData("C:\\Users\\abhis\\Desktop\\utkarsh\\GameWorldOnline\\DatabaseArea\\WebsiteInventory\\products.csv");
    }




    
}
