package GameWorldOnline.UserInteractionMenu;

import java.util.ArrayList;
import java.util.Scanner;

import GameWorldOnline.DatabaseArea.Database;

public class UserInteraction {
    public String currentPage;
    public static Scanner scanner;
    Database database;
    UIMessage uiMessage;
    Boolean interactionFlag;

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
            this.uiMessage.getMessageByPageAndStep(this.currentPage, 1);
            if(this.currentPage == "0"){
                this.uiMessage.getMessageByPageAndStep(this.currentPage, 2);
            }


            String choice = scanner.next();
            choice = choice.toUpperCase();

            if(choice.substring(0, 4).contains("GWO_")){
                System.out.println("GWO_ pattern found" );
            }else if(choice.equalsIgnoreCase("NEXT")){
                if (this.currentPage == "0") {
                    System.out.println("\n\nPage selected: next. Loading all the Games ...");
                    this.currentPage = "1";
                    this.uiMessage.setPageNumber("1");
                    database.showAllGames();
                }                

            }


        }
    }

}
