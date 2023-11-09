package GameWorldOnline.DatabaseArea;

import GameWorldOnline.Utility.Game;
import GameWorldOnline.Utility.ProcessFileData;

public class Database {

    public static ProcessFileData readFromFile;

    public Database() {
        initializeWebsiteDatabase();
    }

    private void initializeWebsiteDatabase() {

        readFromFile = new ProcessFileData("databaseFile",
                "C:\\Users\\abhis\\Desktop\\utkarsh\\GameWorldOnline\\DatabaseArea\\WebsiteInventory\\products.csv");
    }

    public Game searchGameById(String gwid) {
        
        if(readFromFile.getgameByID(gwid) != null){
            return readFromFile.getgameByID(gwid);
        }else{
            return null;
        }
    }

    public void showAllGames() {
        readFromFile.showAllGames();
    }

}
