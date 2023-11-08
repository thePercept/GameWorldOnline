package GameWorldOnline.ProductSection;

import GameWorldOnline.FinanceSection.TaxCalculation;

public class Product extends TaxCalculation {
    private String name;
    private double price;


    @Override
    public double getFinalRate(double originalPrice) {
        return super.getFinalRate(originalPrice);
    }

    public Product() {
        System.out.println("Initializing Product");
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        System.out.println("Final Price of Product is "+ price);
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = this.getFinalRate(price);
    }






}