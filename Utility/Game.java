package GameWorldOnline.Utility;

//      "GWO_3456","Cyberpunk 2077","2020","7.7/10","3499","PC"
public class Game {
    String id, name,year_released,rating,price,platform;

    public Game(String id, String name, String year_released, String rating, String price, String platform) {
        this.id = id;
        this.name = name;
        this.year_released = year_released;
        this.rating = rating;
        this.price = price;
        this.platform = platform;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear_released() {
        return year_released;
    }

    public void setYear_released(String year_released) {
        this.year_released = year_released;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    
}
