package GameWorldOnline.FinanceSection;

public abstract class TaxCalculation {
    

    public double getFinalRate(double originalPrice){
        double gstRate =  0.18; 
        double finalPrice = originalPrice * gstRate; 
        finalPrice = originalPrice + finalPrice;
        return finalPrice;        
    }
}
