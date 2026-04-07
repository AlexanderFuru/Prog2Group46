import java.time.Year;

public class LongPlay extends Recording {

    public LongPlay(String name, String artist, int year, int condition, double price) {
        super(name, artist, year, condition, price);
    }

    @Override
    public String getType() {
        return "LP";
    }

    @Override
    public double getPrice() {
        int currentYear = Year.now().getValue();
        
        double basePrice = getOriginalPrice() * (getCondition() / 10.0);
        
        double ageBonus = (currentYear - getYear()) * 5.0;
        
        return basePrice + ageBonus;
    }
}