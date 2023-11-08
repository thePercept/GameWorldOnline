package GameWorldOnline.UserInteractionMenu;

import java.util.ArrayList;
import java.util.Scanner;

import GameWorldOnline.DatabaseArea.Database;

public class UserInteraction {
    public String currentPage;
    public static Scanner scanner;
    Database database;
    // UIMessage uiMessage;
    ArrayList<UIMessage> messageList;
    Boolean interactionFlag;

    public UserInteraction(Database database) {
        this.interactionFlag = true;
        this.database = database;
        scanner = new Scanner(System.in);
        this.currentPage = "0";
        this.messageList = new ArrayList<>();
        this.messageList.add(new UIMessage("S1-0", "Welcome To Game World Online !"));
        this.messageList.add(new UIMessage("S1-1",
                "1.To view the game world online page please type NEXT and press Enter.\n2.If you're staff then type STAFF and press Enter"));
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
            System.out.println(this.messageList.get(0).getMessageString());
            System.out.println(this.messageList.get(1).getMessageString());

            String choice = scanner.next();
            choice.toUpperCase();

            switch (choice) {

                case "NEXT":
                    if (this.currentPage == "0") {
                        System.out.println("Page selected: next");
                        this.currentPage = "1";

                    }

                default:
                    // this.interactionFlag = false;
                    System.out.println("\nThats a wrong input. Please try again...");
                    break;
            }

        }
    }

}
