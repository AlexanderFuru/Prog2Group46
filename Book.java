public class Book extends Item {

    private String name;

    public Book(String name, String author, double price, boolean bound){
        super(name);
    }

    public double getPrice(double price){
        //Räkna ut bokens pris
        return price;
    }

    @Override
    public String toString(){
        return "Book: "+name;
    }
}
