package GameWorldOnline.UserInteractionMenu;

import java.util.HashMap;

public class UIMessage {

    String pageNumber;
    HashMap<Integer, String> pageOneMessages,pageTwoMessages,pageThreeMessages,pageFourMessages;

    public UIMessage(String pageNumber) {
        this.pageNumber = pageNumber;

        pageOneMessages = new HashMap<>();
        pageTwoMessages = new HashMap<>();
        pageThreeMessages = new HashMap<>();
        pageFourMessages = new HashMap<>();



        pageOneMessages.put(0, "Welcome To Game World Online !");
        pageOneMessages.put(1, "To view the game world online page please type NEXT and press Enter.");
        pageOneMessages.put(2, "2.If you're staff then type STAFF and press Enter.");


        pageTwoMessages.put(0, "Add a game in the Cart by typing ADD followed by the GWO ID and press enter. For example. ADD GWO_1211");


        pageThreeMessages.put(0, "To clear the cart type CLEAR and press ENTER");

        pageFourMessages.put(0, "To go back to previous page type BACK and press ENTER");


    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void getMessageByPageAndStep(String page, int step) {
        if (this.pageNumber == "0") {
            System.out.println(this.pageOneMessages.get(step));
        }else if (this.pageNumber =="1"){
            System.out.println(this.pageTwoMessages.get(step));
        }else if(this.pageNumber=="2"){
            System.out.println(this.pageThreeMessages.get(step));
        }else if(this.pageNumber=="3"){
            System.out.println(this.pageFourMessages.get(step));
        }
    }

}
