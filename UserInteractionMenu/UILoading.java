package GameWorldOnline.UserInteractionMenu;

public class UILoading implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nWebsite loaded successfully!");
    }
    
}
