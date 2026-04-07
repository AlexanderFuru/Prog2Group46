public abstract class Recording implements PriceableWithVAT25 {

    private String name;
    private String artist;
    private int year;
    private int condition; 
    private double price;  

    public Recording(String name, String artist, int year, int condition, double price) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.condition = condition;
        this.price = price;
    }

    public abstract String getType();

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public int getCondition() {
        return condition;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double value = price * (condition / 10.0);

        if (value < 10) {
            value = 10;
        }

        return value;
    }

    public double getOriginalPrice() {
        return price;
    }

    public String toString() {
        return name + " - " + artist + " (" + year + "), condition: "
                + condition + ", price: " + getPrice();
    }

    
}