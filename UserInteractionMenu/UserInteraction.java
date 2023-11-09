package GameWorldOnline.UserInteractionMenu;

import java.util.Scanner;

import GameWorldOnline.DatabaseArea.Database;
import GameWorldOnline.FinanceSection.TaxCalculation;
import GameWorldOnline.Utility.Game;

public class UserInteraction extends TaxCalculation {
    public String currentPage;
    public static Scanner scanner;
    Database database;
    UIMessage uiMessage;
    Boolean interactionFlag;
    Game gameSelected;

    public UserInteraction(Database database) {
        // Mimic Initial Page load -start
        Thread thread_one = new Thread(new UILoading());
        thread_one.start();
                  

        this.interactionFlag = true;
        this.database = database;
        scanner = new Scanner(System.in);
        this.currentPage = "0";
        this.uiMessage = new UIMessage("0");


        // Mimic Initial Page load -end

  


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


            // 1
            if(this.currentPage == "2"){
                System.out.println("\nAdding Game to Cart now :" + gameSelected.getName());
                System.out.println("\tSr. \tGame ID \tGame Name \tPrice \tGST INCLUSIVE Amount"  );
                String fomrattedSummary = String.format("\t1. \t%s \t%s \t%s \t%s ",
                                                                gameSelected.getId(),
                                                                gameSelected.getName(),
                                                                gameSelected.getPrice(), 
                                                                this.getFinalRate(Integer.parseInt(gameSelected.getPrice()))
                                                                
                                                                
                                                                );
                System.out.println(fomrattedSummary  );


            }

            // 2
            this.uiMessage.getMessageByPageAndStep(this.currentPage, 0);
     
            
            //3 
            if(this.currentPage == "0"){
                // Mimic Page load
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                 
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
                        // System.out.println("Adding Game to Cart now :" + gameSelected.getName());
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

    @Override
    public double getFinalRate(double originalPrice) {
        return super.getFinalRate(originalPrice);
    }

}
