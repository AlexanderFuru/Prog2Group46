public class Book extends Item implements PriceableWithVAT6{

    private String name;
    private String author;

    private double price;

    private boolean bound;

    public Book(String name, String author, double price, boolean bound){
        super(name);
        this.price = price;
        this.name = name;
        this.author = author;
    }

    public double getPrice(double price){
        if (bound)
            return price * 1.3;

        else
            return price;
    }

    @Override
    public double getPrice(){
        if (bound)
            return this.price * 1.3;

        else
            return this.price;
    }

    @Override
    public String toString(){
        return "Book: "+name;
    }
}
