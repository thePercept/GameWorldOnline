package GameWorldOnline.FinanceSection;

public abstract class TaxCalculation {
    private float gstRate =  18/100; 

    public double getFinalRate(double originalPrice){
        double finalPrice = originalPrice * this.gstRate; 
        finalPrice = originalPrice + finalPrice;
        System.out.println("originalPrice = " + originalPrice);
        System.out.println("finalPrice = " + gstRate);

        System.out.println("finalPrice = " + finalPrice);
        return finalPrice;        
    }
}
