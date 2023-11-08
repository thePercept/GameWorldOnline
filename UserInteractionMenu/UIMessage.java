package GameWorldOnline.UserInteractionMenu;

public class UIMessage {
    String messageString;
    String id;

    

    public UIMessage(String id,String messageString) {
        this.messageString = messageString;
        this.id = id;
    }
    public String getMessageString() {
        return messageString;
    }
    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    



}
