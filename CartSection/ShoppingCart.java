package GameWorldOnline.CartSection;

import java.util.ArrayList;
import java.util.List;

import GameWorldOnline.ProductSection.Product;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return items;
    }
}
