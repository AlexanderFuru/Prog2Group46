public class Item {

    //Implementera Interface Pricable

    private String name;

    public Item(String name){
        //Fixa så stor första bokstav, små resten
        this.name = name.toUpperCase();
    }

    public String getName(){
        return name;
    }
}
