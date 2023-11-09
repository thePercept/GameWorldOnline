package GameWorldOnline.UserInteractionMenu;

import java.util.Scanner;

import GameWorldOnline.DatabaseArea.Database;
import GameWorldOnline.Utility.Game;

public class UserInteraction {
    public String currentPage;
    public static Scanner scanner;
    Database database;
    UIMessage uiMessage;
    Boolean interactionFlag;
    Game gameSelected;

    public UserInteraction(Database database) {
        this.interactionFlag = true;
        this.database = database;
        scanner = new Scanner(System.in);
        this.currentPage = "0";
        this.uiMessage = new UIMessage("0");
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public static void getUserInput(String userInpuString) {

    }

    public void startInteraction() {
        while (this.interactionFlag) {

            System.out.println("\n****************************************************************************************************************");
            System.out.println("Current Page "+this.currentPage);
            System.out.println("****************************************************************************************************************");

            this.uiMessage.getMessageByPageAndStep(this.currentPage, 0);
            if(this.currentPage == "0"){
                this.uiMessage.getMessageByPageAndStep(this.currentPage, 1);            
                this.uiMessage.getMessageByPageAndStep(this.currentPage, 2);
            }


            String choice = scanner.nextLine();
            choice = choice.toUpperCase();
            String[] words = choice.split(" ");
            System.out.println("words ???"+words.length );
            
            // When Adding to Cart (Page 2)
            if(words[0].matches("^ADD")){
                this.clearScreen();

                if(words.length>1){
                    if(database.searchGameById(words[1])==null){
                        System.out.println("No games found in database, please try again");
                    }else{
                        gameSelected = database.searchGameById(words[1]);
                        System.out.println("Adding Game to Cart now :" + gameSelected.getName());
                        this.currentPage = "2";
                        this.uiMessage.setPageNumber("2");                        
                    }  
                }
            }
            // When on 1st Screen (Page 1)
            else if(choice.equalsIgnoreCase("NEXT")){
                this.clearScreen();
                if (this.currentPage == "0") {
                    System.out.println("\n\nPage selected: next. Loading all the Games ...");
                    this.currentPage = "1";
                    this.uiMessage.setPageNumber("1");
                    database.showAllGames();
                }                

            }
            // When Cart is viewed (Page 3)
            else if(choice.equalsIgnoreCase("PAY")){
                this.clearScreen();

            }
            

            // When wrong input
            else{
                System.out.println("FALSEEE");
            }


        }
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();          
    }

}
