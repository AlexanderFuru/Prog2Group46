public class Book extends Item implements PriceableWithVAT6{

    public final String author;

    public final double price;

    public final boolean bound;

    public Book(String name, String author, double price, boolean bound){
        super(name);
        this.price = price;
        this.author = author;
        this.bound = bound;
    }

    @Override
    public double getPrice(){
        return (bound) ? price * 1.3 : price;
    }

    @Override
    public String toString(){
        return "Book { name= " + getName() + " Author= " + author + " bound= " + bound + " Price= " + getPrice() + " Price+VAT= " + getPriceWithVAT() + "}";
    }
}
