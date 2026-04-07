public class Book extends Item implements PriceableWithVAT6{

    public String author;

    public double price;

    public boolean bound;

    public Book(String name, String author, double price, boolean bound){
        super(name);
        this.price = price;
        this.name = name;
        this.author = author;
        this.bound = bound;
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
        return "Book: "+name+" Author: "+author+" Price: "+getPrice()+" bound? "+bound;
    }
}
