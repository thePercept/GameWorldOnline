package GameWorldOnline.DatabaseArea;

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

    public void showAllGames() {
        readFromFile.showAllGames();
    }

    public void showTopTenGamesByRating() {
        readFromFile.showTopTenGamesByRating();
    }

    public void sortAllGamesByRatingHighToLow() {
        readFromFile.sortAllGamesByRatingHighToLow();
    }

    public void groupGamesByPlatform() {
        readFromFile.groupGamesByPlatform();
    }

    public void groupGamesByGenre() {
        readFromFile.groupGamesByGenre();
    }

}
