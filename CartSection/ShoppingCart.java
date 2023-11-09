package GameWorldOnline.CartSection;

import java.util.ArrayList;
import java.util.List;

import GameWorldOnline.Utility.Game;


public class ShoppingCart {
    private ArrayList<Game> gameCart;

    public ShoppingCart() {
        this.gameCart = new ArrayList<Game>(); ;
    }

    public List<Game> getGameCart() {
        return gameCart;
    }

    public void addGamesinCart(Game game) {
        this.gameCart.add(game);
    }

    public void removeGamesFromCart() {
        this.gameCart.clear();
    }


}
