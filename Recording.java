public abstract class Recording extends Item implements PriceableWithVAT25{

    private final String artist;
    private final int year;
    private int condition; 
    private final double price;  

    protected Recording(String name, String artist, int year, int condition, double price) {
        super(name);
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

    @Override
    public double getPrice() {
       return Math.max(10, getOriginalPrice() * getCondition() / 10.0 + (2026 - year));
    }

    protected double getOriginalPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{ " + getType() + ": " + " name= " + getName() + " artist= " + getArtist() + " year= " + getYear() + " condition= " + getCondition() + " original price= " + getOriginalPrice() + " Price= " + getPrice() + " Price+VAT= " + getPriceWithVAT() + "}";
    }   
}