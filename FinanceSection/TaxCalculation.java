package GameWorldOnline.FinanceSection;

public abstract class TaxCalculation {
    private double gstRate =  18/100; 

    public double getFinalRate(double originalPrice){
        double finalPrice = originalPrice * this.gstRate; 
        finalPrice = originalPrice + finalPrice;
        return finalPrice;        
    }
}
